package com.etk.db.model;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: mladen
 * Date: 10/30/13
 * Time: 7:53 PM
 * To change this template use File | Settings | File Templates.
 */
public class JoinTable implements RowCollection {

    private RowCollection leftTable;
    private RowCollection rightTable;
    private List<Joint> joints;  //FKs to left and right table rows
    private String joinAttribute;
    private Map<String, Integer> joinedAttributeIndices;   //do this in the constructor

    public JoinTable(RowCollection leftTable, RowCollection rightTable, String joinAttribute) {
        this.joints = new ArrayList<Joint>();
        this.leftTable = leftTable;
        this.rightTable = rightTable;
        this.joinAttribute = joinAttribute.toUpperCase();

        joinedAttributeIndices = new HashMap<String, Integer>();
        HashSet<String> joinedAttributes = new HashSet<String>(leftTable.getAttributes());
        joinedAttributes.addAll(rightTable.getAttributes());
        joinedAttributes.add(this.joinAttribute);

        int i = 0;
        for(String att : joinedAttributes) {
            joinedAttributeIndices.put(att,i);
            i++;
        }

       calculateJoin(this.joinAttribute);
    }

    private void calculateJoin(String att) {
        Collection<Row> l = leftTable.getRows();
        Collection<Row> r = rightTable.getRows();
        int lIndex = leftTable.getAttributeIndex(att);
        int rIndex = rightTable.getAttributeIndex(att);

        for(Row lr : l) {
            for(Row rr : r) {
                Object lo = lr.getValue(lIndex);
                Object ro = rr.getValue(rIndex);
                if(lo != null && ro != null) {
                    if(lo.equals(ro)) {
                        joints.add(new Joint(lr,rr));
                    }
                }
            }
        }
    }




    @Override
    public Collection<Row> getRows() {

        return null;
        //reconstruct rows from joints
    }

    @Override
    public Set<String> getAttributes() {
        return joinedAttributeIndices.keySet();
    }

    @Override
    public int getSize() {
        return joints.size();
    }

    @Override
    public Class getType(String attribute) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int getAttributeIndex(String attribute) {
            return getAttributeIndex(attribute);
    }

    private class Joint {
        private Row leftRow;
        private Row rightRow;

        public Joint(Row leftRow, Row rightRow) {
            this.leftRow = leftRow;
            this.rightRow = rightRow;
        }


        public Row getRightRow() {
            return rightRow;
        }

        public Row getLeftRow() {
            return leftRow;
        }
    }

    @Override
    public String toString() {
        return leftTable.toString()+"  "+joinAttribute+"   "+rightTable+"   "+joinedAttributeIndices;
    }
}

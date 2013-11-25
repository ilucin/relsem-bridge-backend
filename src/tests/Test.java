package tests;

import com.etk.db.model.JoinTable;
import com.etk.db.model.Row;
import com.etk.db.model.RowImple;
import com.etk.db.model.Table;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mladen
 * Date: 10/30/13
 * Time: 9:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class Test {
    public static void main(String[] args) {
        List<Row> r1 = new ArrayList<Row>();
        Object[] o1 = {"Marko", "Markic", 3235};
        r1.add(new RowImple(o1));
        o1 = new Object[]{"Petar", "Ivkovic", 542};
        r1.add(new RowImple(o1));
        o1 = new Object[]{"Ivan", "Peric", 9242};
        r1.add(new RowImple(o1));


        List<Row> r2 = new ArrayList<Row>();
        o1 = new Object[] {"Zagreb", "Croatia", 3235};
        r2.add(new RowImple(o1));
        o1 = new Object[]{"Munchen", "Germany", 542};
        r2.add(new RowImple(o1));
        o1 = new Object[]{"London", "England", 9242};
        r2.add(new RowImple(o1));


        List<Row> r3 = new ArrayList<Row>();
        o1 = new Object[] {"Marko", "gavrilovic", 253};
        r3.add(new RowImple(o1));
        o1 = new Object[]{"Petar", "piko", 212};
        r3.add(new RowImple(o1));
        o1 = new Object[]{"Ivan", "podravka", 222};
        r3.add(new RowImple(o1));


        List<Row> r4 = new ArrayList<Row>();
        o1 = new Object[] {"prva", "podravka", 8432};
        r4.add(new RowImple(o1));
        o1 = new Object[]{"peta", "gavrilovic", 3104};
        r4.add(new RowImple(o1));
        o1 = new Object[]{"desta", "piko", 5467};
        r4.add(new RowImple(o1));





        String[] t1a  = {"Ime","Prezime","ccode"};
        Table t1 = new Table(t1a,r1);
        String[] t2a  = {"City","Satate","ccode"};
        Table t2 = new Table(t2a,r2);

        String[] t3a  = {"Ime","pasteta","OIB"};
        Table t3 = new Table(t3a,r3);
        String[] t4a  = {"Kurec","pasteta","fsdf"};
        Table t4 = new Table(t4a,r4);




        JoinTable jt1  = new JoinTable(t1,t2,"ccode");
        JoinTable jt2  = new JoinTable(t3,t4,"pasteta");
        //System.out.println(jt2.getAttributes());
        //System.out.println(jt1.getAttributes());
        JoinTable jt  = new JoinTable(jt1,jt2,"Ime");
        for(Row r : jt.getRows()) {
            System.out.println(r.toString());
        }

        System.out.println(jt.getAttributes().toString());

    }
}

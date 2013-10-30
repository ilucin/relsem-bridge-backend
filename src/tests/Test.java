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





        String[] t1a  = {"Ime","Prezime","OIB"};
        Table t1 = new Table(t1a,r1);
        String[] t2a  = {"City","Satate","OIB"};
        Table t2 = new Table(t2a,r2);

        JoinTable jt  = new JoinTable(t1,t2,"oIb");
        System.out.println(jt);


        /*for(Row row : t1.getRows()) {
            System.out.println(row.toString());
        }
        for(Row row : t2.getRows()) {
            System.out.println(row.toString());
        }*/


       /* String[] t2a  = {"Grad","Drzava","OIB"};
        Table t2 = new Table(t2a);

        JoinTable jt = new JoinTable(t1,t2,"oib");
        System.out.println(jt);*/
    }
}

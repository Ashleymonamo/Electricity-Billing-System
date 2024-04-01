package electricity.billing.system;

import javax.swing.*;

import java.sql.ResultSet;
//import net.proteanit.sql.DbUtils;

public class BillDetails extends JFrame {
    String meter;
    BillDetails(String meter)
    {this.meter=meter;
        setSize(550,  550);
        setLocation(300,70);
         JTable table=new JTable();

        try
        {
          Conn c=new Conn();
          String query="select * from bill where meter_no='"+meter+"'";
            ResultSet rs=c.s.executeQuery(query);
            //table.setModel(DbUtils.resultSetToTableModel(rs));

        }catch(Exception e)
        {
            e.printStackTrace();
        }
        JScrollPane sp=new JScrollPane(table);
        sp.setBounds(0,0,550,400);
        add(sp);
        setVisible(true);
    }
    public static void main(String[] args) {
        new BillDetails("");

    }
}

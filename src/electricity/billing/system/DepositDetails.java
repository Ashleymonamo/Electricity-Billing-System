package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.sql.*;

//import net.proteanit.sql.DbUtils;
public class DepositDetails extends JFrame implements ActionListener  {

    JLabel lblmeterno,lblmonth;
    Choice monthtxt,meterNo;
    JTable table;
    JButton search,print;
    DepositDetails()
    {
        super("Deposit Details");

        setSize(550,  550);
        setLocation(300,70);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);


        lblmeterno=new JLabel("Search by Meter No");
        lblmeterno.setBounds(20,20,120,30);
        add(lblmeterno);
        meterNo=new Choice();
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from newcustomer");
            while (rs.next()) {
                meterNo.add(rs.getString("meterNo"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        meterNo.setBounds(150,20,120,30);
        add(meterNo);

        lblmonth=new JLabel("Search by Month");
        lblmonth.setBounds(290,20,110,30);
        add(lblmonth);
        monthtxt=new Choice();
        monthtxt.setBounds(400,20,70,30);
        monthtxt.add("Jan");
        monthtxt.add("Feb");
        monthtxt.add("Mar");
        monthtxt.add("Apr");
        monthtxt.add("May");
        monthtxt.add("Jun");
        monthtxt.add("Jul");
        monthtxt.add("Aug");
        monthtxt.add("Sep");
        monthtxt.add("Oct");
        monthtxt.add("Nov");
        monthtxt.add("Dec");
        add(monthtxt);

        table=new JTable();

try
{
    Conn c = new Conn();
    ResultSet rs1 = c.s.executeQuery("select * from bill");
//table.setModel(DbUtils.resultSetToTableModel(rs1));

}catch (Exception e)
{
    e.printStackTrace();
}
JScrollPane sp=new JScrollPane(table);
sp.setBounds( 0,100,700,600);

        search=new JButton("Search");
        search.setBounds(90,70,100,20);
        search.addActionListener(this);
        add(search);

        print=new JButton("Print");
        print.setBounds(230,70,100,20);
        print.addActionListener(this);
        add(print);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==search)
        {String query="select * from bill where meter_no= '"+meterNo.getSelectedItem()+"' and month='"+monthtxt.getSelectedItem()+"'";

          try
          {
            Conn c=new Conn();
            ResultSet rs2=c.s.executeQuery(query);
           // table.setModel(DbUtils.resultSetToTable(rs2));
          }catch(Exception e)
          {
              e.printStackTrace();
          }


        }else  if(ae.getSource()==print)
        {
            try{
                table.print();
            }catch (Exception e)
            {
                e.printStackTrace();
            }

        }
    }
    public static void main(String[] args) {
        new DepositDetails();
    }
}

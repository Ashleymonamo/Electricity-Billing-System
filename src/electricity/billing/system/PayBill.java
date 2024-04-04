package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class PayBill extends JFrame implements ActionListener {
    JLabel lblname,lblMeter,name,meterNo,lblmonth,lblUnits,units,lbltotalbill,totalbill,lblstatus,status;
    Choice monthtxt;
    JButton Pay,back;
    String meternum,userAcc;

   PayBill(String meternum,String userAcc)
   {
       this.meternum=meternum;
       this.userAcc=userAcc;
       setSize(550, 550);
       setLocation(300, 70);
       setLayout(null);

       JLabel heading = new JLabel("Pay Electricity Bill");
       heading.setBounds(140, 20, 200, 25);
       heading.setFont(new Font("Tahona", Font.PLAIN, 18));
       add(heading);

       lblname=new JLabel("Name");
       lblname.setBounds(100,80,200,25);
       add(lblname);
       name=new JLabel("");
       name.setBounds(100,100,200,25);
       add(name);

       lblMeter=new JLabel("Meter No");
       lblMeter.setBounds(340,80,200,25);
       add(lblMeter);
       meterNo=new JLabel("");
       meterNo.setBounds(340,100,200,25);
       add(meterNo);

       lblmonth=new JLabel("Month");
       lblmonth.setBounds(100,130,80,30);
       add(lblmonth);
       monthtxt=new Choice();
       monthtxt.setBounds(100,160,70,30);
       monthtxt.add(" ");
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

       lblUnits=new JLabel("Units");
       lblUnits.setBounds(340,130,80,30);
       add(lblUnits);
       units=new JLabel("");
       units.setBounds(340,150,80,30);
       add(units);

       lbltotalbill=new JLabel("Total Bill Cost");
       lbltotalbill.setBounds(100,190,120,30);
       add(lbltotalbill);
       totalbill=new JLabel("");
       totalbill.setBounds(100,210,80,30);
       add(totalbill);

       lblstatus=new JLabel("Status");
       lblstatus.setBounds(340,190,120,30);
       add(lblstatus);
       status=new JLabel("");
       status.setBounds(340,210,80,30);
       add(status);

try{
    Conn c=new Conn();
    //String query="select * from bill where meter_no='"+meterNo+"'";
    ResultSet rs=c.s.executeQuery("select * from newcustomer where meterNo='"+meternum+"'");
    while(rs.next())
    {
        meterNo.setText(meternum);
        name.setText(rs.getString("Name"));

    }



//     rs=c.s.executeQuery("select * from bill where meter_no='"+meternum+"' AND month='"+monthtxt.getSelectedItem()+"'");
//    while(rs.next())
//    {
//        totalbill.setText(rs.getString("totalbill"));
//        units.setText(rs.getString("units"));
//        status.setText(rs.getString("status"));
//    }

}catch(Exception e )
       {
         e.printStackTrace();
       }


       monthtxt.addItemListener(new ItemListener() {
           @Override
           public void itemStateChanged(ItemEvent e) {
               try {
                   Conn c = new Conn();
                   ResultSet rs1 = c.s.executeQuery("select * from bill where meter_no='"+meternum+"' AND month='"+monthtxt.getSelectedItem()+"'");
                   while(rs1.next())
                   {
                       totalbill.setText(rs1.getString("totalbill"));
                       units.setText(rs1.getString("units"));
                       status.setText(rs1.getString("status"));

                   }

               } catch (Exception ex)
               {
                   ex.printStackTrace();
               }
           }
       });


       Pay=new JButton("Pay");
       Pay.setBounds(100,300,90,40);
       Pay.addActionListener(this);
       add(Pay);
       back=new JButton("Back");
       back.setBounds(230,300,90,40);
       back.addActionListener(this);
       add(back);

       setVisible(true);
   }
public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==Pay)
{
    try
    {
        Conn c=new Conn();
        c.s.executeUpdate("update bill set status='Paid' where meter_no='"+meternum+"' AND month='"+monthtxt.getSelectedItem()+"'");
        JOptionPane.showMessageDialog(null,"Bill Paid Successfully");
        setVisible(false);

    }catch(Exception e)
    {
        e.printStackTrace();
    }


}if(ae.getSource()==back)
{
setVisible(false);

}
}
    public static void main(String[] args) {
        new PayBill("","");
    }
}

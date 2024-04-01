package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class PayBill extends JFrame implements ActionListener {
    JLabel lblname,lblMeter,name,meterNo,lblmonth,lblUnits,units,lbltotalbill,totalbill,lblstatus,status;
    Choice monthtxt;
    JButton Pay;
   PayBill()
   {
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
       name=new JLabel("Kamo");
       name.setBounds(100,100,200,25);
       add(name);

       lblMeter=new JLabel("Meter No");
       lblMeter.setBounds(340,80,200,25);
       add(lblMeter);
       meterNo=new JLabel("1234355");
       meterNo.setBounds(340,100,200,25);
       add(meterNo);

       lblmonth=new JLabel("Month");
       lblmonth.setBounds(100,130,80,30);
       add(lblmonth);
       monthtxt=new Choice();
       monthtxt.setBounds(100,160,70,30);
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
       units=new JLabel("280");
       units.setBounds(340,150,80,30);
       add(units);

       lbltotalbill=new JLabel("Total Bill Cost");
       lbltotalbill.setBounds(100,190,120,30);
       add(lbltotalbill);
       totalbill=new JLabel("12344");
       totalbill.setBounds(100,210,80,30);
       add(totalbill);

       lblstatus=new JLabel("Status");
       lblstatus.setBounds(340,190,120,30);
       add(lblstatus);
       status=new JLabel("Paid");
       status.setBounds(340,210,80,30);
       add(status);

       Pay=new JButton("Update");
       Pay.setBounds(200,300,90,40);
       Pay.addActionListener(this);
       add(Pay);

       setVisible(true);
   }
public void actionPerformed(ActionEvent ae)
{

}
    public static void main(String[] args) {
        new PayBill();
    }
}

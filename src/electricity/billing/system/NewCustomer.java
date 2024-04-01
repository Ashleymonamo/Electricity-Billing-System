

package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import  java.sql.*;


public class NewCustomer extends JFrame implements ActionListener {
    JLabel lblname,lblMeter,lblMeter2,lblemail,lblcity,lblphone;
    JTextField nametxt,emailtxt,citytxt,phonetxt;
    Button next,cancel;
    NewCustomer()
    {
        setSize(550,  550);
        setLocation(300,70);


        JPanel p=new JPanel();
        p.setLayout(null);
        p.setBackground(new Color(173,216,230));
        add(p);

        JLabel heading=new JLabel("New Customer");
        heading.setBounds(180,20,200,25);
        heading.setFont(new Font("Tahona",Font.PLAIN,24));
        p.add(heading);


        lblname=new JLabel("Customer name");
        lblname.setBounds(100,80,100,30);
        p.add(lblname);
        nametxt=new JTextField();
        nametxt.setBounds(210,80,150,30);
        p.add(nametxt);

        lblMeter=new JLabel("Meter No");
        lblMeter.setBounds(100,120,100,30);
        p.add(lblMeter);
        Random ran=new Random();
        long number =ran.nextLong()%10000000;
        lblMeter2=new JLabel();
        lblMeter2.setBounds(210,120,150,30);
        lblMeter2.setText(""+Math.abs(number));
        p.add(lblMeter2);

        lblemail=new JLabel("Email Address");
        lblemail.setBounds(100,160,100,30);
        p.add(lblemail);
        emailtxt=new JTextField();
        emailtxt.setBounds(210,160,150,30);
        p.add(emailtxt);

        lblcity=new JLabel("City");
        lblcity.setBounds(100,200,100,30);
        p.add(lblcity);
        citytxt=new JTextField();
        citytxt.setBounds(210,200,150,30);
        p.add(citytxt);

        lblphone=new JLabel("Phone No");
        lblphone.setBounds(100,240,100,30);
        p.add(lblphone);
        phonetxt=new JTextField();
        phonetxt.setBounds(210,240,150,30);
        p.add(phonetxt);

        next=new Button("Next");
        next.setBounds(140,290,100,40);
        next.addActionListener(this);
        p.add(next);

        cancel=new Button("Cancel");
        cancel.setBounds(260,290,100,40);
        cancel.addActionListener(this);
        p.add(cancel);

        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae)
    {
        if (ae.getSource()==next)
        {
            String meterNo=lblMeter2.getText();
            String emailAddress=emailtxt.getText();
            String Name=nametxt.getText();
            String phoneNo=phonetxt.getText();
            String city=citytxt.getText();
            String query1="insert into newcustomer values('"+meterNo+"','"+Name+"','"+emailAddress+"','"+city+"','"+phoneNo+"')";
            String query2="insert into login values('"+meterNo+"','','"+emailAddress+"','"+Name+"','')";



try{
   Conn c=new Conn();
   c.s.executeUpdate(query1);
    c.s.executeUpdate(query2);
    JOptionPane.showMessageDialog(null,"Customer Details Added Successfully");
    setVisible(false);
    new MeterInfo(meterNo);
}
catch (Exception e)
{
    e.printStackTrace();
}

        }
    else if (ae.getSource()==cancel)
    {
        setVisible(false);
        //new Project();
    }
    }
    public static void main(String[] args) {
        new NewCustomer();
    }
}



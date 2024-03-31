package electricity.billing.system;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.sql.*;

public class Signup extends JFrame implements ActionListener {
    JLabel lblpassword,lbluserName,heading,lblmeterNo,lblName;
    JTextField email,passwrd,meterNo,name;
    Choice accType;
    JPanel panel;
    JButton create,back;
    Signup()
    {

        super("Sign Up Page");
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setSize(550,  550);
        setLocation(300,70);
        setVisible(true);
        panel=new JPanel();
        panel.setBounds(40,30,450,450);
        panel.setBorder(new TitledBorder(new LineBorder(new Color(173,216,230),2),"Create Account",TitledBorder.LEADING,TitledBorder.TOP,null,new Color(172,216,230)));
       panel.setLayout(null);
       panel.setForeground(new Color(34,139,34));;
        add(panel);
        heading=new JLabel("Create Account As");
        heading.setBounds(50,100,100,30);
        panel.add(heading);

        accType=new Choice();
        accType.setBounds(170,100,140,30);
        accType.add("Admin");
        accType.add("Customer");
        panel.add(accType);

        lblmeterNo=new JLabel("Meter No");
        lblmeterNo.setBounds(50,140,140,30);
        panel.add(lblmeterNo);

        meterNo=new JTextField();
        meterNo.setBounds(170,140,140,30);
        panel.add(meterNo);

        lbluserName=new JLabel("Email");
        lbluserName.setBounds(50,180,140,30);
        panel.add(lbluserName);

        email=new JTextField();
        email.setBounds(170,180,140,30);
        panel.add(email);

        lblName=new JLabel("Name");
        lblName.setBounds(50,220,140,30);
        panel.add(lblName);

        name=new JTextField();
        name.setBounds(170,220,140,30);
        panel.add(name);

        lblpassword=new JLabel("Password");
        lblpassword.setBounds(50,260,140,30);
        panel.add(lblpassword);

        passwrd=new JTextField();
        passwrd.setBounds(170,260,140,30);
        panel.add(passwrd);

        create=new JButton("Create");
        create.setBounds(90,300,90,40);
        create.addActionListener(this);
        panel.add(create);

        back=new JButton("Back");
        back.setBounds(200,300,90,40);
        back.addActionListener(this);
        panel.add(back);
    }

    public void actionPerformed(ActionEvent ae)
    {
         if(ae.getSource()==create)
        {
            String accountType= accType.getSelectedItem();
            String emailAdd=email.getText();
            String Name=name.getText();
            String meterNum=meterNo.getText();
            String Password=passwrd.getText();

            try{
               Conn c=new Conn();
                String query="insert into login values('"+meterNum+"','"+accountType+"','"+emailAdd+"','"+Name+"','"+Password+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Account Created Successfully");
                setVisible(false);
                 new Login();
            }
          catch (Exception e)
           {

               //System.out.println("Couldnt create account");
               e.printStackTrace();
           }


        } else if(ae.getSource()==back)
    {
        setVisible(false);
        new Login();
    }
    }
    public static void main(String[] args) {

        new Signup();
    }
}

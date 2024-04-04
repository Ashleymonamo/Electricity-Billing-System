package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class Login extends JFrame implements ActionListener{
    JLabel lblpassword,lblloginOpt,lbluserName;
    Button login,cancel,signup;
    JTextField email,passwrd;
    Choice loginOpt;
Login()
{
       super("Login Page");
       getContentPane().setBackground(Color.WHITE);
      setLayout(null);

    lbluserName=new JLabel("Email");
    lbluserName.setBounds(250,100,80,30);
    add(lbluserName);

    lblpassword=new JLabel("Password");
    lblpassword.setBounds(250,140,80,30);
    add(lblpassword);

    lblloginOpt=new JLabel("Login as");
    lblloginOpt.setBounds(250,180,80,30);
    add(lblloginOpt);

    email=new JTextField();
    email.setBounds(350,100,150,30);
    add(email);

    passwrd=new JTextField();
    passwrd.setBounds(350,140,150,30);
    add(passwrd);

    loginOpt =new Choice();
    loginOpt.setBounds(350,180,150,30);
    loginOpt.add("");
    loginOpt.add("Admin");
    loginOpt.add("Customer");
    add(loginOpt);


    login=new Button("Login");
    login.setBounds(260,230,100,40);
    login.addActionListener(this);
    add(login);


    cancel=new Button("Cancel");
    cancel.setBounds(380,230,100,40);
    cancel.addActionListener(this);
    add(cancel);


    signup=new Button("Sign Up");
    signup.setBounds(320,290,100,40);
    signup.addActionListener(this);
    add(signup);

    ImageIcon i7=new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
    Image i8=i7.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
    ImageIcon i9=new ImageIcon(i8);
    JLabel image=new JLabel(i9);
    image.setBounds(0,80,250,250);
    add(image);


    setSize(550,  550);
    setLocation(300,70);
    setVisible(true);

}
public void actionPerfomed(ActionEvent ae)
{
   if (ae.getSource()==login)
   {
//    { String accountType= loginOpt.getSelectedItem();
//        String Username=username.getText();
//        String passsWord=passwrd.getText();
//
//        try
//        {
//Conn c= new Conn();
//String query="select * from login where username= '"+Username+"'and password='"+passsWord+"' and accType='"+accountType+"'";
//ResultSet rs= c.s.executeQuery(query);
//if(rs.next())
//{
//setVisible(false);
//new Project();
//}
//else
//{
//    JOptionPane.showMessageDialog(null,"Invalid Login Credentials");
//
//}
//        }catch(Exception e)
//        {
//            e.printStackTrace();
//        }
//      // setVisible(false);
    }
    else if (ae.getSource()==signup)
    {
       //
        new Signup();
    }
    else if (ae.getSource()==cancel)
     {

         //setVisible(false);
     }


}


    public static void main(String[] args) {
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource()==login)
        {

            String accountType= loginOpt.getSelectedItem();
            String emailAdress=email.getText();
            String passsWord=passwrd.getText();

            try
            {
                Conn c= new Conn();
                String query="select * from login where email= '"+emailAdress+"'and password='"+passsWord+"' and accType='"+accountType+"'";
                ResultSet rs= c.s.executeQuery(query);

                if(rs.next())
                {String meter=rs.getString("meterNo");
                    setVisible(false);
                    new Project(accountType,meter);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Invalid Login Credentials");
                    setVisible(false);
                    new Login();

                }
            }catch(Exception e)
            {
                e.printStackTrace();
            }


        }
        else if (ae.getSource()==signup)
        {
            setVisible(false);
             new Signup();
        }
        else if (ae.getSource()==cancel)
        {
            setVisible(false);
        }

    }
}

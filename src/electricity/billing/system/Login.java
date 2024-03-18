package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener{
    JLabel lblpassword,lblloginOpt,lbluserName;
    Button login,cancel,signup;
    JTextField username,passwrd;
    Choice loginOpt;
Login()
{
       super("Login Page");
       getContentPane().setBackground(Color.WHITE);
      setLayout(null);

    lbluserName=new JLabel("Username");
    lbluserName.setBounds(250,100,80,30);
    add(lbluserName);

    lblpassword=new JLabel("Password");
    lblpassword.setBounds(250,140,80,30);
    add(lblpassword);

    lblloginOpt=new JLabel("Login as");
    lblloginOpt.setBounds(250,180,80,30);
    add(lblloginOpt);

    username=new JTextField();
    username.setBounds(350,100,150,30);
    add(username);

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
      // setVisible(false);
    }
    else if (ae.getSource()==signup)
    {
       // setVisible(false);
       // new Signup();
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
             setVisible(false);
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

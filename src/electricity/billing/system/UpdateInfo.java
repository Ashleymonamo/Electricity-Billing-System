package electricity.billing.system;

import com.mysql.cj.protocol.Resultset;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class UpdateInfo extends JFrame implements ActionListener {
    JLabel lblname,lblMeter,lblemail,lblcity,lblphone,meterNo,name;
    JButton cancel,update;
    JTextField email,city,phone;
    String meter;
    UpdateInfo(String meter)
    {
//        super("Update Customer Information");
        this.meter=meter;
        setSize(550,  550);
        setLocation(300,70);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        JLabel heading=new JLabel("Update Customer Information");
        heading.setBounds(180,20,200,25);
        heading.setFont(new Font("Tahona",Font.PLAIN,14));
        add(heading);

        lblname=new JLabel("Name");
        lblname.setBounds(100,80,200,25);
        add(lblname);
        name=new JLabel("");
        name.setBounds(100,100,200,25);
        add(name);


        lblcity=new JLabel("City");
        lblcity.setBounds(100,150,200,25);
        add(lblcity);
        city=new JTextField("");
        city.setBounds(100,170,200,25);
        add(city);

        lblphone=new JLabel("Phone No");
        lblphone.setBounds(340,150,200,25);
        add(lblphone);
        phone=new JTextField("");
        phone.setBounds(340,170,200,25);
        add(phone);

        lblMeter=new JLabel("Meter No");
        lblMeter.setBounds(340,80,200,25);
        add(lblMeter);
        meterNo=new JLabel();
        meterNo.setBounds(340,100,200,25);
        add(meterNo);

        lblemail=new JLabel("Email");
        lblemail.setBounds(100,210,200,25);

        add(lblemail);
        email=new JTextField("");
        email. setBounds(100,230,200,25);
        add(email);


        try
        {
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from newcustomer where meterNo= '"+meter+"'");

            while (rs.next())
            {
                meterNo.setText(rs.getString("meterNo"));
                name.setText(rs.getString("Name"));
                phone.setText(rs.getString("phone"));
                email.setText(rs.getString("email"));
                city.setText(rs.getString("city"));
            }
        }catch(Exception e)
        {
            e.printStackTrace();

        }

        update=new JButton("Update");
        update.setBounds(200,300,90,40);
        update.addActionListener(this);
        add(update);
        cancel=new JButton("Cancel");
        cancel.setBounds(300,300,90,40);
        cancel.addActionListener(this);
        add(cancel);

setVisible(true);

    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==update)
        {
            String emailAdd=email.getText();
            String phoneNum=phone.getText();
            String City=city.getText();
           try
           {
               Conn c=new Conn();
               c.s.executeUpdate("update newcustomer set email='"+emailAdd+"',city='"+City+"',phone='"+phoneNum+"'");
               JOptionPane.showMessageDialog(null,"Information Updated Successfully");
               setVisible(false);
           }
           catch (Exception e)
           {
               e.printStackTrace();
           }
        }else if(ae.getSource()==cancel)
        {
            setVisible(false);

        }
    }

    public static void main(String[] args) {
        new UpdateInfo("");
    }
}

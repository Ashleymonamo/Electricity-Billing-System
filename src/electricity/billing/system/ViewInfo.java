package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ViewInfo extends JFrame implements ActionListener {
    JLabel lblname,name,lblMeter,meterNo,lblemail,email,lblcity,city,lblphone,phone;
JButton cancel;
    ViewInfo(String meter)
    {
        super("View Customer Information");
        setSize(550,  550);
        setLocation(300,70);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        JLabel heading=new JLabel("View Customer Information");
        heading.setBounds(180,20,200,25);
        heading.setFont(new Font("Tahona",Font.PLAIN,14));
        add(heading);

        lblname=new JLabel("Name");
        lblname.setBounds(100,80,200,25);
        add(lblname);
        name=new JLabel("");
        name.setBounds(100,100,200,25);
        add(name);

        lblemail=new JLabel("Email");
        lblemail.setBounds(340,80,200,25);
        add(lblemail);
        email=new JLabel("");
        email.setBounds(340,100,200,25);
        add(email);

        lblcity=new JLabel("City");
        lblcity.setBounds(100,150,200,25);
        add(lblcity);
        city=new JLabel("");
        city.setBounds(100,170,200,25);
        add(city);

        lblphone=new JLabel("Phone No");
        lblphone.setBounds(340,150,200,25);
        add(lblphone);
        phone=new JLabel("");
        phone.setBounds(340,170,200,25);
        add(phone);

        lblMeter=new JLabel("Meter No");
        lblMeter.setBounds(100,210,200,25);
        add(lblMeter);
        meterNo=new JLabel("");
        meterNo.setBounds(100,230,200,25);
        add(meterNo);

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

        cancel=new JButton("Cancel");
        cancel.setBounds(200,300,100,40);
        cancel.addActionListener(this);
        add(cancel);
    setVisible(true);

    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==cancel)
        {
            setVisible(false);
            //new Project(meterNo)
        }
    }
    public static void main(String[] args) {
        new ViewInfo("");
    }
}

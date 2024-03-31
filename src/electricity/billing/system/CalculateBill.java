

package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.util.*;



public class CalculateBill extends JFrame implements ActionListener {
    JLabel lblname,lblMeter,lblunits,lblmonth,lblAddress,name,adress;
    JTextField unitstxt;
    Choice monthtxt,meterno;
    Button cancel,submit;
    CalculateBill() {
        setSize(550, 550);
        setLocation(300, 70);


        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBackground(new Color(173, 216, 230));
        add(p);

        JLabel heading = new JLabel("Calculate Electricity Bill");
        heading.setBounds(140, 20, 200, 25);
        heading.setFont(new Font("Tahona", Font.PLAIN, 18));
        p.add(heading);


        lblMeter = new JLabel("Meter No");
        lblMeter.setBounds(100, 80, 100, 30);
        p.add(lblMeter);

        meterno = new Choice();
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from newcustomer");
            while (rs.next()) {
                meterno.add(rs.getString("meterNo"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        meterno.setBounds(210, 80, 150, 30);
        p.add(meterno);

        lblname = new JLabel("Name");
        lblname.setBounds(100, 120, 100, 30);
        p.add(lblname);
        name = new JLabel("");
        name.setBounds(210, 120, 150, 30);
        p.add(name);

        lblAddress = new JLabel("Address");
        lblAddress.setBounds(100, 160, 100, 30);
        p.add(lblAddress);
        adress = new JLabel("");
        adress.setBounds(210, 160, 150, 30);
        p.add(adress);
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from newcustomer where meterNo = '"+meterno.getSelectedItem()+"'");
           while(rs.next())
           {
               name.setText(rs.getString("Name"));
               adress.setText(rs.getString("city"));

           }

        } catch (Exception e)
        {
            e.printStackTrace();
        }

        meterno.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try {
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery("select * from newcustomer where meterNo = '"+meterno.getSelectedItem()+"'");
                    while(rs.next())
                    {
                        name.setText(rs.getString("Name"));
                        adress.setText(rs.getString("city"));

                    }

                } catch (Exception ex)
                {
                    ex.printStackTrace();
                }
            }
        });


        lblunits=new JLabel("Units Consumed");
        lblunits.setBounds(100,200,100,30);
        p.add(lblunits);
        unitstxt=new JTextField();
        unitstxt.setBounds(210,200,150,30);
        p.add(unitstxt);

        lblmonth=new JLabel("Month");
        lblmonth.setBounds(100,240,100,30);
        p.add(lblmonth);
        monthtxt=new Choice();
        monthtxt.setBounds(210,240,150,30);
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
        p.add(monthtxt);

        submit=new Button("Next");
        submit.setBounds(140,290,100,40);
        submit.addActionListener(this);
        p.add(submit);

        cancel=new Button("Cancel");
        cancel.setBounds(260,290,100,40);
        cancel.addActionListener(this);
        p.add(cancel);

        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae)
    {
        if (ae.getSource()==submit)
        {
            String meterNo=meterno.getSelectedItem();
            String units=unitstxt.getText();
            String month=monthtxt.getSelectedItem();

            int totalbill=0;
            int unit_consumed=Integer.parseInt(units);
            String query="select * from tax";

            try
            {
               Conn c=new Conn();
                ResultSet rs=c.s.executeQuery(query);
                while(rs.next())
                {
                    totalbill +=  unit_consumed * Integer.parseInt(rs.getString("cost_per_unit"));
                    totalbill +=Integer.parseInt(rs.getString("meter_rent"));
                    totalbill += Integer.parseInt(rs.getString("service_charge"));
                    totalbill += Integer.parseInt(rs.getString("service_tax"));
                    totalbill += Integer.parseInt(rs.getString("swacch_bharat_cess"));
                    totalbill += Integer.parseInt(rs.getString("fixed_tax"));



                }
            }
             catch (Exception e)
             {
                 e.printStackTrace();
             }

            String query1="insert into bill values('"+meterNo+"','"+month+"','"+units+"','"+totalbill+"')";
           // String query2="insert into login values('"+meterNo+"','','','"+Name+"','',)";


            try{
                Conn c=new Conn();
                c.s.executeUpdate(query1);

                JOptionPane.showMessageDialog(null,"Customer Bill Updated Successfully");
                setVisible(false);
                new Project();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

        }
        else if (ae.getSource()==cancel)
        {
            setVisible(false);
            new Project();
        }
    }
    public static void main(String[] args) {
        new CalculateBill();
    }
}



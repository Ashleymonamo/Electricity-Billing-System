package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import  java.sql.*;

public class MeterInfo extends JFrame  implements ActionListener{


    Button submit;
    JLabel lblMeter,lblMeter2,lblmeterlocation,lblmetertype,lblphaseCode,lblbillType;
    Choice meterlocation,meterType,phaseType,billType;

    MeterInfo( String meterNo)
    {
        setSize(550,  550);
        setLocation(300,70);


        JPanel p=new JPanel();
        p.setLayout(null);
        p.setBackground(new Color(173,216,230));
        add(p);

        JLabel heading=new JLabel("Meter Information");
        heading.setBounds(180,20,200,25);
        heading.setFont(new Font("Tahona",Font.PLAIN,24));
        p.add(heading);




        lblMeter=new JLabel("Meter No");
        lblMeter.setBounds(100,120,100,30);
        p.add(lblMeter);

//        Random ran=new Random();
//        long number =ran.nextLong()%10000000;
        lblMeter2=new JLabel(meterNo);
        lblMeter2.setBounds(210,120,150,30);
       // lblMeter2.setText(""+Math.abs(number));
        p.add(lblMeter2);

        lblmeterlocation=new JLabel("Meter Location");
        lblmeterlocation.setBounds(100,160,100,30);
        p.add(lblmeterlocation);

        meterlocation=new Choice();
        meterlocation.setBounds(210,160,150,30);
        meterlocation.add("Inside");
        meterlocation.add("Outside");
        p.add(meterlocation);


        lblmetertype=new JLabel("Meter Type");
        lblmetertype.setBounds(100,200,100,30);
        p.add(lblmetertype);

        meterType=new Choice();
        meterType.setBounds(210,200,150,30);
        meterType.add("Electric Meter");
        meterType.add("Solar Meter");
        meterType.add("Smart Meter");
        p.add(meterType);


        lblphaseCode=new JLabel("Phase Code");
        lblphaseCode.setBounds(100,240,100,30);
        p.add(lblphaseCode);

        phaseType=new Choice();
        phaseType.setBounds(210,240,150,30);
        phaseType.add("011");
        phaseType.add("022");
        phaseType.add("033");
        phaseType.add("044");
        phaseType.add("055");
        phaseType.add("066");
        phaseType.add("077");
        phaseType.add("088");
        phaseType.add("099");
        p.add(phaseType);

        lblbillType=new JLabel("Phase Type");
        lblbillType.setBounds(100,280,100,30);
        p.add(lblbillType);

        billType=new Choice();
        billType.setBounds(210,280,150,30);
        billType.add("Normal");
        billType.add("Industrial");
        p.add(billType);




        submit=new Button("Next");
        submit.setBounds(140,320,100,40);
        submit.addActionListener(this);
        p.add(submit);



        setVisible(true);

    }


    public void actionPerformed(ActionEvent ae)
    {
        if (ae.getSource()==submit)
        {
            String meterNo=lblMeter2.getText();
            String meterLoc=meterlocation.getSelectedItem();
          String billtype=billType.getSelectedItem();
          String phasecode=phaseType.getSelectedItem();
          String metertype=meterType.getSelectedItem();

            String query1="insert into meterinfo values('"+meterNo+"','"+meterLoc+"','"+metertype+"','"+phasecode+"','"+billtype+"') ";

            try{
                Conn c=new Conn();
                c.s.executeUpdate(query1);
                JOptionPane.showMessageDialog(null,"Meter Info Added Successfully");
                setVisible(false);


            }catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        new MeterInfo("");
    }
}

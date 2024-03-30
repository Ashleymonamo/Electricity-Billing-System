package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import  java.sql.*;

public class MeterInfor extends JFrame  {

    JTextField nametxt,emailtxt,citytxt,phonetxt;
    Button next,cancel;
    JLabel lblname,lblMeter,lblMeter2,lblemail,lblcity,lblmeterlocation,lblmetertype,lblphaseCode,lblbillType;
    Choice meterlocation,meterType,phaseType,billType;

    MeterInfor()
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


//        lblMeter=new JLabel("Meter Number");
//        lblMeter.setBounds(100,80,100,30);
//        p.add(lblMeter);
//        nametxt=new JTextField();
//        nametxt.setBounds(210,80,150,30);
//        p.add(nametxt);

        lblMeter=new JLabel("Meter No");
        lblMeter.setBounds(100,120,100,30);
        p.add(lblMeter);

        Random ran=new Random();
        long number =ran.nextLong()%10000000;
        lblMeter2=new JLabel();
        lblMeter2.setBounds(210,120,150,30);
        lblMeter2.setText(""+Math.abs(number));
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


        lblphaseCode=new JLabel("Phase Type");
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




        next=new Button("Next");
        next.setBounds(140,320,100,40);
//        next.addActionListener(this);
        p.add(next);

        cancel=new Button("Cancel");
        cancel.setBounds(260,320,100,40);
//        cancel.addActionListener(this);
        p.add(cancel);

        setVisible(true);

    }
    public static void main(String[] args) {
        new MeterInfor();
    }
}

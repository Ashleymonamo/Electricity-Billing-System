package electricity.billing.system;

import javax.swing.*;
import java.awt.*;

public class GenerateBill extends JFrame {


    Choice monthtxt;
    JScrollPane pane;
    JButton generate;
    String meter;
    GenerateBill(String meter)
    {
        this.meter=meter;
        setSize(550, 550);
        setLocation(300, 70);

        JLabel heading = new JLabel("Generate Electricity Bill");
        heading.setBounds(140, 20, 200, 25);
        heading.setFont(new Font("Tahona", Font.PLAIN, 18));
        add(heading);

        monthtxt=new Choice();
        monthtxt.setBounds(300,20,30,30);
        monthtxt.add("");
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

//JScrollPane pane=new JScrollPane();
generate=new JButton("Generate");
generate.setBounds(200,40,50,20);
        add(generate);



     setVisible(true);
    }
    public static void main(String[] args) {
        new GenerateBill("");
    }
}

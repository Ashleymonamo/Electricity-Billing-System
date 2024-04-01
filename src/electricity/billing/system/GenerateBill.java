package electricity.billing.system;

import javax.swing.*;
import java.awt.*;

public class GenerateBill extends JFrame {

    GenerateBill()
    {
        setSize(550, 550);
        setLocation(300, 70);

        JLabel heading = new JLabel("Generate Electricity Bill");
        heading.setBounds(140, 20, 200, 25);
        heading.setFont(new Font("Tahona", Font.PLAIN, 18));
        add(heading);
    }
    public static void main(String[] args) {
        new GenerateBill();
    }
}

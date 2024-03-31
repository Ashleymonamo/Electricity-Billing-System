package electricity.billing.system;
import  javax.swing.*;
import java.awt.*;
//import java.util.*;

public class Splash extends JFrame implements Runnable{
Thread t;
    //constructor
    Splash()
    {
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/bulb.jpg"));
        Image i2=i1.getImage().getScaledInstance(550,550,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        add(image);
        setTitle("Landing Page");
        setVisible(true);


        for (int i = 1; i< 550 ; i++) {
            setSize(i,  i);
            setLocation(300,70);
            try{
                Thread.sleep(5);
            }
            catch(Exception e)
            {
                e.printStackTrace();

            }
        }

        t=new Thread(this);
        t.start();

        setVisible(true);


    }

    @java.lang.Override
    public void run() {
        try{
            Thread.sleep(5000);
            setVisible(false);
            new Login();
        }catch(Exception e)
        {
            e.printStackTrace();

        }
    }

    public static void main(String[] args) {
        new Splash();//means dynamically memory allocation
    }
}

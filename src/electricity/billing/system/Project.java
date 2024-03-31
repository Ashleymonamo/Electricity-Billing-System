package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.awt.event.KeyEvent;

public class Project extends JFrame implements ActionListener {
    JMenuBar mb;
    //TABS
    JMenu master,information,user,report,utility,exit;
    //Power station
    Project()
    {
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/power-station.jpg"));
        Image i2=i1.getImage().getScaledInstance(1550,850,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        add(image);

        //JMenuBar is more like a navigation bar
        mb= new JMenuBar();
        setJMenuBar(mb);

        master=new JMenu("Master");
        master.setForeground(Color.BLUE);
        mb.add(master);

        JMenuItem newcustomer=new JMenuItem("New Customer");
        newcustomer.setFont(new Font("monospaced",Font.PLAIN,12));
        newcustomer.setBackground(Color.WHITE);
        ImageIcon icon1=new ImageIcon(ClassLoader.getSystemResource("icons/bk.png"));
        Image image1=icon1.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        newcustomer.setIcon((new ImageIcon(image1)));
        //SETS shortcuts
        newcustomer.setMnemonic('N');
        newcustomer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,ActionEvent.CTRL_MASK));
        newcustomer.addActionListener(this);
        master.add(newcustomer);



        JMenuItem customerdetails=new JMenuItem("Customer Details");
        customerdetails.setFont(new Font("monospaced",Font.PLAIN,12));
        customerdetails.setBackground(Color.WHITE);
        ImageIcon icon2=new ImageIcon(ClassLoader.getSystemResource("icons/customer.png"));
        Image image2=icon2.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        customerdetails.setIcon((new ImageIcon(image2)));
        customerdetails.addActionListener(this);
        //SETS shortcuts
        customerdetails.setMnemonic('C');
        customerdetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        master.add(customerdetails);

        JMenuItem depositdetails=new JMenuItem("Deposit Details");
        depositdetails.setFont(new Font("monospaced",Font.PLAIN,12));
        depositdetails.setBackground(Color.WHITE);
        ImageIcon icon3=new ImageIcon(ClassLoader.getSystemResource("icons/deposit.png"));
        Image image3=icon3.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        depositdetails.setIcon((new ImageIcon(image3)));
        depositdetails.addActionListener(this);
        //SETS shortcuts
        depositdetails.setMnemonic('D');
        depositdetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.CTRL_MASK));
        master.add(depositdetails);


        JMenuItem calculatebill=new JMenuItem("Calculate Bill");
        calculatebill.setFont(new Font("monospaced",Font.PLAIN,12));
        calculatebill.setBackground(Color.WHITE);
        ImageIcon icon4=new ImageIcon(ClassLoader.getSystemResource("icons/calculate.png"));
        Image image4=icon4.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        calculatebill.setIcon((new ImageIcon(image4)));
        calculatebill.addActionListener(this);
        //SETS shortcuts
        calculatebill.setMnemonic('B');
        calculatebill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK));
        master.add(calculatebill);


        //SECOND TAB
        information=new JMenu("Information");
        information.setForeground(Color.BLUE);
        mb.add(information);


        JMenuItem updateInfo=new JMenuItem("Update Information");
        updateInfo.setFont(new Font("monospaced",Font.PLAIN,12));
        updateInfo.setBackground(Color.WHITE);
        ImageIcon icon5=new ImageIcon(ClassLoader.getSystemResource("icons/update.png"));
        Image image5=icon5.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        updateInfo.setIcon((new ImageIcon(image5)));
        updateInfo.addActionListener(this);
        //SETS shortcuts
        updateInfo.setMnemonic('U');
        updateInfo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, ActionEvent.CTRL_MASK));
        information.add(updateInfo);

        JMenuItem viewInfo=new JMenuItem("View Information");
        viewInfo.setFont(new Font("monospaced",Font.PLAIN,12));
        viewInfo.setBackground(Color.WHITE);
        ImageIcon icon6=new ImageIcon(ClassLoader.getSystemResource("icons/view.png"));
        Image image6=icon6.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        viewInfo.setIcon((new ImageIcon(image6)));
        viewInfo.addActionListener(this);
        //SETS shortcuts
        viewInfo.setMnemonic('I');
        viewInfo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK));
        information.add(viewInfo);


        //  3RD TAB
        user=new JMenu("User");
        user.setForeground(Color.BLUE);
        mb.add(user);


        JMenuItem paybill=new JMenuItem("Pay Bill");
        paybill.setFont(new Font("monospaced",Font.PLAIN,12));
        paybill.setBackground(Color.WHITE);
        ImageIcon icon7=new ImageIcon(ClassLoader.getSystemResource("icons/paybill.png"));
        Image image7=icon7.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        paybill.setIcon((new ImageIcon(image7)));
        paybill.addActionListener(this);
        //SETS shortcuts
        paybill.setMnemonic('P');
        paybill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        user.add(paybill);

        JMenuItem billdetails=new JMenuItem("Bill Details");
        billdetails.setFont(new Font("monospaced",Font.PLAIN,12));
        billdetails.setBackground(Color.WHITE);
        ImageIcon icon8=new ImageIcon(ClassLoader.getSystemResource("icons/bill.png"));
        Image image8=icon8.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        billdetails.setIcon((new ImageIcon(image8)));
        billdetails.addActionListener(this);
        //SETS shortcuts
        billdetails.setMnemonic('C');
        billdetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
        user.add(billdetails);


//4th tab
        report=new JMenu("Report");
        report.setForeground(Color.BLUE);
        mb.add(report);

        JMenuItem generatebill=new JMenuItem("Generate Bill");
        generatebill.setFont(new Font("monospaced",Font.PLAIN,12));
        generatebill.setBackground(Color.WHITE);
        ImageIcon icon9=new ImageIcon(ClassLoader.getSystemResource("icons/generate.png"));
        Image image9=icon9.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        generatebill.setIcon((new ImageIcon(image9)));
        generatebill.addActionListener(this);
        //SETS shortcuts
        generatebill.setMnemonic('R');
        generatebill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G,ActionEvent.CTRL_MASK));
        report.add(generatebill);


        utility=new JMenu("Notepad");
        utility.setForeground(Color.BLUE);
        mb.add(utility);

        JMenuItem notepad=new JMenuItem("Notepad");
        notepad.setFont(new Font("monospaced",Font.PLAIN,12));
        notepad.setBackground(Color.WHITE);
        ImageIcon icon10=new ImageIcon(ClassLoader.getSystemResource("icons/bk.jpg"));
        Image image10=icon10.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        notepad.setIcon((new ImageIcon(image10)));
        notepad.addActionListener(this);
        //SETS shortcuts
        notepad.setMnemonic('N');
        notepad.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T,ActionEvent.CTRL_MASK));
        utility.add(notepad);

        JMenuItem calculator=new JMenuItem("Calculator");
        calculator.setFont(new Font("monospaced",Font.PLAIN,12));
        calculator.setBackground(Color.WHITE);
        ImageIcon icon11=new ImageIcon(ClassLoader.getSystemResource("icons/calculator.png"));
        Image image11=icon11.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        calculator.setIcon((new ImageIcon(image11)));
        calculator.addActionListener(this);
        //SETS shortcuts
        calculator.setMnemonic('C');
        calculator.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,ActionEvent.CTRL_MASK));
        calculator.addActionListener(this);
        utility.add(calculator);



        exit=new JMenu("Exit");
        exit.setForeground(Color.BLUE);
        mb.add(exit);

        JMenuItem exit1=new JMenuItem("Exit");
        exit1.setFont(new Font("monospaced",Font.PLAIN,12));
        exit1.setBackground(Color.WHITE);
        ImageIcon icon12=new ImageIcon(ClassLoader.getSystemResource("icons/exit.png"));
        Image image12=icon12.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        exit1.setIcon((new ImageIcon(image12)));
        exit1.addActionListener(this);
        //SETS shortcuts
        exit1.setMnemonic('X');
        exit1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W,ActionEvent.CTRL_MASK));
        exit.add(exit1);

        setLayout(new FlowLayout());
        setVisible(true);


    }
public void actionPerformed(ActionEvent ae)
{

    String msg=ae.getActionCommand();
    if(msg.equals("New Customer"))
    {
        new NewCustomer();

    }
     if (msg.equals("Calculate Bill"))
    {
new CalculateBill();


    }else if (msg.equals("Exit"))
{
    setVisible(false);


}
}

    public static void main(String[] args) {
        new Project();
    }
}

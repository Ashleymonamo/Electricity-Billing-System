package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.sql.*;

//import net.proteanit.sql.DbUtils;
public class CustomerDetails extends JFrame implements ActionListener  {


    JTable table;
    JButton search,print;
    CustomerDetails()
    {
        super("Customer Details");

        setSize(550,  550);
        setLocation(300,70);

        table=new JTable();

        try
        {
            Conn c = new Conn();
            ResultSet rs1 = c.s.executeQuery("select * from newcustomer");
//table.setModel(DbUtils.resultSetToTableModel(rs1));

        }catch (Exception e)
        {
            e.printStackTrace();
        }
        JScrollPane sp=new JScrollPane(table);

        add(sp);

        print=new JButton("Print");
        print.setBounds(500,500,50,30);
        print.addActionListener(this);
        add(print,"South");
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae)
    {
            try{
                table.print();
            }catch (Exception e)
            {
                e.printStackTrace();
            }


    }
    public static void main(String[] args) {
        new CustomerDetails();
    }
}

import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.awt.*;
import java.util.*;

public class fastcash extends JFrame implements ActionListener {
  JLabel t1;
  JButton m1 = new JButton("Rs.100");
  JButton m2 = new JButton("Rs.500");
  JButton m3 = new JButton("Rs.1,000");
  JButton m4 = new JButton("Rs.2,000");
  JButton m5 = new JButton("Rs.5,000");
  JButton m6 = new JButton("Rs.10,000");
  JButton exit = new JButton("Exit");
  JFrame jf5 = new JFrame();
  String pinno;
  fastcash(String pinno) {
    this.pinno=pinno;
    jf5.setBounds(350, 50, 800, 750);
    jf5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jf5.setLayout(null);
    ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("images/atmimg.jpg"));
    Image i3 = i2.getImage().getScaledInstance(800, 750, Image.SCALE_DEFAULT);
    ImageIcon i4 = new ImageIcon(i3);
    JLabel atmimg = new JLabel(i4);
    atmimg.setBounds(0, 0, 800, 750);
    jf5.add(atmimg);

    JLabel t1 = new JLabel("Please Select the Amount");
    t1.setBounds(250, 280, 290, 40);
    t1.setForeground(Color.BLACK);
    t1.setFont(new Font("oswards", Font.BOLD, 14));
    atmimg.add(t1);

    m1.setBounds(190, 340, 100, 20);
    m1.setFont(new Font("oswards", Font.BOLD, 12));
    m1.addActionListener(this);
    atmimg.add(m1);

    m2.setBounds(340, 340, 140, 20);
    m2.setFont(new Font("oswards", Font.BOLD, 12));
    m2.addActionListener(this);
    atmimg.add(m2);

    m3.setBounds(190, 365, 100, 20);
    m3.setFont(new Font("oswards", Font.BOLD, 12));
    atmimg.add(m3);

    m4.setBounds(340, 361, 140, 20);
    m4.setFont(new Font("oswards", Font.BOLD, 12));
    atmimg.add(m4);

    m5.setBounds(190, 390, 100, 20);
    m5.setFont(new Font("oswards", Font.BOLD, 12));
    atmimg.add(m5);

    m6.setBounds(340, 383, 140, 20);
    m6.setFont(new Font("oswards", Font.BOLD, 12));
    atmimg.add(m6);

    exit.setBounds(340, 410, 140, 20);
    exit.setFont(new Font("oswards", Font.BOLD, 12));
    atmimg.add(exit);
    exit.addActionListener(this);
    jf5.setVisible(true);
  }

  public void actionPerformed(ActionEvent ae1) {
    if (ae1.getSource() == exit) {
      jf5.setVisible(false);
      new signin(pinno).setVisible(true);
    }
    else{
        String amount=((JButton)ae1.getSource()).getText().substring(3);
        conn c=new conn();
        try{
            ResultSet rs=c.s.executeQuery("select * from bank where Pin_Number='"+pinno+"'");
            int balance=0;
            while(rs.next()){
               if(rs.getString("Type_of_Transaction").equals("Deposit")){
                balance+=Integer.parseInt(rs.getString("amount"));
               }
               else{
                balance-=Integer.parseInt(rs.getString("amount"));
               }
            } 
            if(ae1.getSource()!=exit && balance<Integer.parseInt(amount)){
                   JOptionPane.showMessageDialog(null,"Insufficient Balance");
                   return;
            }
            Date date=new Date();
            String query="insert into bank values('"+pinno+"','"+date+"','WithDrawl','"+amount+"')";
            c.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Debited Successful");
            jf5.setVisible(false);
            new signin(pinno).setVisible(true);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
  }

  public static void main(String args[]) {
    new fastcash("");
  }
}
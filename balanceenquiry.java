import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class balanceenquiry extends JFrame implements ActionListener{
    String pinno;
    JButton back=new JButton("Back");
      JFrame jf8=new JFrame();
       ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("images/atmimg.jpg"));
       Image i2=i1.getImage().getScaledInstance(800,750,Image.SCALE_DEFAULT);
       ImageIcon i3=new ImageIcon(i2);
      JLabel l3=new JLabel(i3);
     
    balanceenquiry(String pinno){
        this.pinno=pinno;
      
        jf8.setBounds(350,50,800,750);
        jf8.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf8.setLayout(null);
        l3.setBounds(0,0,800,750);
        jf8.add(l3);
        
        back.setBounds(387,400,100,30);
        back.setFont(new Font("oswards",Font.BOLD,16));
        back.addActionListener(this);
        l3.add(back);
        int balance=0;
        try{
            conn c=new conn();
            ResultSet rs=c.s.executeQuery("select * from bank where Pin_Number='"+pinno+"'");
            while(rs.next()){
               if(rs.getString("Type_of_Transaction").equals("Deposit")){
                balance+=Integer.parseInt(rs.getString("amount"));
               }
               else{
                balance-=Integer.parseInt(rs.getString("amount"));
               }
            }
        } 
            catch(Exception ea){
                System.out.println(ea);
            }
        
        JLabel sheet=new JLabel("Your current Balance is Rs."+balance);
        sheet.setBounds(199,290,450,30);
        sheet.setFont(new Font("oswards",Font.BOLD,14));
        l3.add(sheet);
        jf8.setVisible(true);

    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==back){
            jf8.setVisible(false);
            new signin(pinno).setVisible(true);
        }

    }
    public static void main(String[] args) {
        new balanceenquiry("");
    }
}

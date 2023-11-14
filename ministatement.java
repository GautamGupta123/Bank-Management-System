import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class ministatement extends JFrame implements ActionListener{
    String pinno;
    JButton ok=new JButton("OK");
    JFrame jf9=new JFrame();
    ministatement(String pinno){
         this.pinno=pinno;
         jf9.setBounds(250,50,500,550);
         jf9.setLayout(null);
         jf9.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         JLabel text=new JLabel();
         text.setBounds(50,250,450,200);
         jf9.add(text);

         JLabel bank=new JLabel("National Bank");
         bank.setBounds(130,30,350,40);
         bank.setFont(new Font("oswards",Font.BOLD,35));

         JLabel cardno=new JLabel();
         cardno.setBounds(100,86,350,30);
         cardno.setFont(new Font("oswards",Font.BOLD,15));
         jf9.add(cardno);
         jf9.add(bank);

         ok.setBounds(190,400,100,30);
         ok.setFont(new Font("oswards",Font.BOLD,20));
         ok.addActionListener(this);
         jf9.add(ok);

         JLabel thank=new JLabel("🤝THANK YOU!!🤝");
         thank.setBounds(100,450,550,40);
         thank.setFont(new Font("oswards",Font.BOLD,35));
         jf9.add(thank);

         try{
             conn c=new conn();
             ResultSet rs=c.s.executeQuery("select * from sign3 where Pin_Number='"+pinno+"'");
             while (rs.next()){
                    cardno.setText("Card Number:"+"XXXX-XXXX-XXXX-"+rs.getString("Card_Number").substring(12,16));
             }
         }
         catch(Exception e){
            System.out.println(e);
         }
         try{
             conn c=new conn();
             ResultSet rs=c.s.executeQuery("select * from bank where Pin_Number='"+pinno+"'");
             while(rs.next()){
                text.setText(text.getText()+"<html>"+rs.getString("Date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("Type_of_Transaction")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+"Rs."+rs.getString("amount")+"<br>"+"<br>");
             }
         }
         catch(Exception ea){
            System.out.println(ea);
         }
         text.setBounds(90,90,450,200);
         jf9.setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        jf9.setVisible(false);
    }
    public static void main(String[] args) {
        new ministatement("");
    }
}

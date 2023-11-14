import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;


public class withdraw extends JFrame implements ActionListener{
    JButton back = new JButton("Back");
        JFrame jf6 = new JFrame();
        JTextField w = new JTextField();
        JButton withd = new JButton("WithDraw");
        String pinno;
        withdraw(String pinno){
            this.pinno=pinno;
        jf6.setBounds(400, 200, 800, 600);
        jf6.setLayout(null);
        jf6.setTitle("My Bank");
        jf6.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("images/atmimg.jpg"));
        Image i1 = i.getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        JLabel l1 = new JLabel(i2);
        l1.setBounds(0, 0, 800, 600);
        jf6.add(l1);

        JLabel l2=new JLabel("Enter the Amount you want to WithDraw");
        l2.setBounds(230,230,250,30);
        l1.add(l2);

        
        w.setBounds(230,260,190,30);
        l1.add(w);

        withd.setBounds(340, 310, 100, 25);
        withd.addActionListener(this);
        l1.add(withd);

       
        back.setBounds(210, 310, 100, 25);
        back.addActionListener(this);
        l1.add(back);
        jf6.setVisible(true);
        }
        public void actionPerformed(ActionEvent e){
            if(e.getSource()==back){
                jf6.setVisible(false);
                new signin(pinno).setVisible(true);
           }
           else if(e.getSource()==withd){
                   String amt=w.getText();
                   Date date=new Date();
                   if(amt.equals("")){
                      JOptionPane.showMessageDialog(null,"Please Enter The Amount");
                   }
                   else{
                      try{
                           conn c=new conn();
                           String query="insert into bank values('"+pinno+"','"+date+"','WithDrawl','"+amt+"')";
                           c.s.executeUpdate(query);
                           JOptionPane.showMessageDialog(null,"Amount WithDrawl Successfully");
                           jf6.setVisible(false);
                           new signin(pinno).setVisible(true);
                      }
                       catch(Exception ee){
                          System.out.println(ee);
                       }
                   }
           }
        }
    public static void main(String[] args) {
        
        new withdraw("");
    }
}

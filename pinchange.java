import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class pinchange extends JFrame implements ActionListener {
    String pinno;
    JFrame jf7 = new JFrame();
    JTextField npin1 = new JTextField();
    JTextField rnpin1 = new JTextField();
    JButton change = new JButton("Change");
    JButton back = new JButton("Back");

    pinchange(String pinno) {
        this.pinno = pinno;

        jf7.setBounds(350, 50, 800, 750);
        jf7.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf7.setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/atmimg.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 750, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(0, 0, 800, 750);
        jf7.add(l1);

        JLabel cpin = new JLabel("Change your Pin");
        cpin.setBounds(270, 280, 200, 30);
        cpin.setFont(new Font("oswards", Font.BOLD, 18));
        l1.add(cpin);

        JLabel ncpin = new JLabel("Enter New Pin:");
        ncpin.setBounds(190, 320, 200, 30);
        ncpin.setFont(new Font("oswards", Font.BOLD, 13));
        l1.add(ncpin);

        JLabel rncpin = new JLabel("Re-Enter New Pin:");
        rncpin.setBounds(190, 360, 200, 30);
        rncpin.setFont(new Font("oswards", Font.BOLD, 13));
        l1.add(rncpin);

        npin1.setBounds(320, 325, 150, 25);
        l1.add(npin1);

        rnpin1.setBounds(320, 365, 150, 25);
        l1.add(rnpin1);

        change.setBounds(370, 395, 100, 30);
        change.setFont(new Font("oswards", Font.BOLD, 16));
        change.addActionListener(this);
        l1.add(change);

        back.setBounds(200, 395, 100, 30);
        back.setFont(new Font("oswards", Font.BOLD, 16));
        back.addActionListener(this);
        l1.add(back);
        jf7.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
             jf7.setVisible(false);
             new signin(pinno).setVisible(true);
        }
        else if(e.getSource()==change){
            String p=npin1.getText();
            String p1=rnpin1.getText();
            if(p.length()>4 || p1.length()>4){
                JOptionPane.showMessageDialog(null,"Pin Length is exceeded");
            }
            if(!p.equals("") && p1.equals("")){
                JOptionPane.showMessageDialog(null,"(Re-Enter) Box is Empty");
            }
            if(p.length()<4 || p1.length()<4){
                JOptionPane.showMessageDialog(null,"Pin Length should be 4");
            }
            else{
                 if(!p.equals(p1)){
                    JOptionPane.showMessageDialog(null,"Please Re-Enter the Correct Pin");
                 }
         }
           try{
                 conn c=new conn();
                 String q1="update bank set Pin_Number='"+p1+"' where Pin_Number='"+pinno+"'";
                 String q2="update sign3 set Pin_Number='"+p1+"' where Pin_Number='"+pinno+"'";
                 c.s.executeUpdate(q1);
                 c.s.executeUpdate(q2);

                 JOptionPane.showMessageDialog(null,"Pin is Changed Successfully");
           }
           catch(Exception ea1){
            System.out.println(ea1);
           }
        }
        jf7.setVisible(false);
        new signin(pinno).setVisible(true);
    }

    public static void main(String[] args) {
        new pinchange("");
    }
}

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class signup1 extends JFrame implements ActionListener {

    JLabel h1 = new JLabel("Page 1: Personal Details 📄");
    JLabel name = new JLabel("Enter Name :");
    JLabel fname = new JLabel("Enter Father's Name :");
    JLabel mobno = new JLabel("Enter Mobile Number :");
    JLabel gen = new JLabel("Gender :");
    JLabel gmail = new JLabel("Email Address :");
    JLabel marstatus = new JLabel("Marital Status :");
    JLabel city = new JLabel("Enter City :");
    JLabel state = new JLabel("Enter State :");
    JLabel pincode = new JLabel("Enter PinCode :");
    JLabel point =new JLabel("*All Details must be Filled*");
    JTextField name1 = new JTextField();
    JTextField fname1 = new JTextField();
    JTextField mobno1 = new JTextField();
    JRadioButton male = new JRadioButton("Male");
    JRadioButton fmale = new JRadioButton("Female");
    JRadioButton others = new JRadioButton("Others");
    ButtonGroup btgrp1 = new ButtonGroup();
    ButtonGroup btgrp = new ButtonGroup();
    JTextField gmail1 = new JTextField();
    JButton next = new JButton("Next");
    JButton back = new JButton("back");
    JTextField state1 = new JTextField();
    JRadioButton yes = new JRadioButton("YES");
    JRadioButton no = new JRadioButton("NO");
    JTextField city1 = new JTextField();
    JTextField pincode1 = new JTextField();
    JFrame jf1 = new JFrame();
    public signup1() {
        
        jf1.setTitle("Signup Page");
        jf1.setBounds(350, 50, 900, 750);
        jf1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        h1.setBounds(310, 30, 300, 60);
        h1.setFont(new Font("oswards", Font.BOLD, 25));
        jf1.add(h1);
 
        point.setBounds(50,80,180,40);
        point.setFont(new Font("oswards",Font.BOLD,12));
        point.setForeground(Color.RED);
        jf1.add(point);

        name.setBounds(50, 120, 150, 30);
        name.setFont(new Font("oswards", Font.BOLD, 18));
        jf1.add(name);

        fname.setBounds(50, 170, 200, 30);
        fname.setFont(new Font("oswards", Font.BOLD, 18));
        jf1.add(fname);

        mobno.setBounds(50, 220, 250, 30);
        mobno.setFont(new Font("oswards", Font.BOLD, 18));
        jf1.add(mobno);

        gen.setBounds(50, 270, 250, 30);
        gen.setFont(new Font("oswards", Font.BOLD, 18));
        jf1.add(gen);

        gmail.setBounds(50, 320, 250, 30);
        gmail.setFont(new Font("oswards", Font.BOLD, 18));
        jf1.add(gmail);

        marstatus.setBounds(50, 370, 250, 30);
        marstatus.setFont(new Font("oswards", Font.BOLD, 18));
        jf1.add(marstatus);

        city.setBounds(50, 420, 250, 30);
        city.setFont(new Font("oswards", Font.BOLD, 18));
        jf1.add(city);

        state.setBounds(50, 470, 250, 30);
        state.setFont(new Font("oswards", Font.BOLD, 18));
        jf1.add(state);

        pincode.setBounds(50, 520, 250, 30);
        pincode.setFont(new Font("oswards", Font.BOLD, 18));
        jf1.add(pincode);

        name1.setBounds(280, 120, 350, 30);
        name1.setFont(new Font("Arieal", Font.BOLD, 14));
        jf1.add(name1);

        fname1.setBounds(280, 170, 350, 30);
        fname1.setFont(new Font("Arieal", Font.BOLD, 14));
        jf1.add(fname1);

        mobno1.setBounds(280, 220, 350, 30);
        mobno1.setFont(new Font("Arieal", Font.BOLD, 14));
        jf1.add(mobno1);

        male.setBounds(280, 270, 100, 30);
        male.setFont(new Font("Arieal", Font.BOLD, 18));
        jf1.add(male);

        fmale.setBounds(400, 270, 100, 30);
        fmale.setFont(new Font("Arieal", Font.BOLD, 18));
        jf1.add(fmale);

        others.setBounds(520, 270, 100, 30);
        others.setFont(new Font("Arieal", Font.BOLD, 18));
        jf1.add(others);

        btgrp.add(male);
        btgrp.add(fmale);
        btgrp.add(others);

        gmail1.setBounds(280, 320, 350, 30);
        gmail1.setFont(new Font("Arieal", Font.BOLD, 13));
        jf1.add(gmail1);

        yes.setBounds(280, 370, 100, 30);
        yes.setFont(new Font("Arieal", Font.BOLD, 18));
        jf1.add(yes);

        no.setBounds(400, 370, 100, 30);
        no.setFont(new Font("Arieal", Font.BOLD, 18));
        jf1.add(no);

        btgrp1.add(yes);
        btgrp1.add(no);

        city1.setBounds(280, 420, 350, 30);
        city1.setFont(new Font("Arieal", Font.BOLD, 13));
        jf1.add(city1);

        state1.setBounds(280, 470, 350, 30);
        state1.setFont(new Font("Arieal", Font.BOLD, 13));
        jf1.add(state1);

        pincode1.setBounds(280, 520, 350, 30);
        pincode1.setFont(new Font("Arieal", Font.BOLD, 13));
        jf1.add(pincode1);

        next.setBounds(650, 620, 150, 40);
        next.setFont(new Font("oswards", Font.BOLD, 20));
        next.setBackground(Color.LIGHT_GRAY);
        next.setForeground(Color.BLACK);
        next.addActionListener(this);
        jf1.add(next);

        back.setBounds(450, 620, 150, 40);
        back.setFont(new Font("oswards", Font.BOLD, 20));
        back.setBackground(Color.LIGHT_GRAY);
        back.setForeground(Color.BLACK);
        back.addActionListener(this);
        jf1.add(back);

        jf1.setLayout(null);
        jf1.setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        //  int flag=0;
         if(e.getSource()==back){
            jf1.setVisible(false);
            new bank().setVisible(true);
        }
        else{
        String name2 = name1.getText();
        String fname2 = fname1.getText();
        String mnumber = mobno1.getText();
        String gender = null;
        if (male.isSelected()) {
            gender = "Male";
        } else if (fmale.isSelected()) {
            gender = "Female";
        } else {
            gender = "Others";
        }
        if(!male.isSelected() && !fmale.isSelected() && !others.isSelected()){
            JOptionPane.showMessageDialog(null,"Gender is not selected");
        }
        String email = gmail1.getText();
        String marry = null;
        if (yes.isSelected()) {
            marry = "YES";
        } else if(no.isSelected()){
            marry = "NO";
        }
        String cityname = city1.getText();
        String statename = state1.getText();
        String pinno = pincode1.getText();
        if(!yes.isSelected() && !no.isSelected()){
            JOptionPane.showMessageDialog(null,"Marital status not filled");
        }
        if(name2.equals("")){
            JOptionPane.showMessageDialog(null,"Name is not filled");
        }
       else if(fname2.equals("")){
            JOptionPane.showMessageDialog(null,"Father's Name is not filled");
        }
        else if(mnumber.equals("")){
            JOptionPane.showMessageDialog(null,"Mobile Number is not filled");

        }
        else if(email.equals("")){
            JOptionPane.showMessageDialog(null,"Email is not filled");
        }
        else if(statename.equals("")){
            JOptionPane.showMessageDialog(null,"State is not filled");
        }
        else if(pinno.equals("")){
            JOptionPane.showMessageDialog(null,"Pincode is not filled");
        }
        else{
            try {
                conn c = new conn();
                String query = "insert into sign values('" + name2 + "','" + fname2 + "','" + mnumber + "','" + gender+"','" + email + "','" + marry + "','" + cityname + "','" + statename + "','" + pinno + "')";
                c.s.executeUpdate(query);
            } catch (Exception e1) {
                System.out.println(e1);
            }
            jf1.setVisible(false);
            new signup2().setVisible(true);
        }
    }
      }
    public static void main(String[] args) {
        new signup1();
    }
}

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class signup3 extends JFrame implements ActionListener {

    JFrame jf1 = new JFrame();
    JLabel heading = new JLabel("Page 3: Account Details");
    JLabel typeacc = new JLabel("Type of Account:");
    JRadioButton saving = new JRadioButton("Saving Account");
    JRadioButton current = new JRadioButton("Current Account");
    JRadioButton fd = new JRadioButton("Fixed-Deposit Account");
    JRadioButton recurring = new JRadioButton("Recurring Account");
    ButtonGroup bg1 = new ButtonGroup();
    JLabel card = new JLabel("Card Number :");
    JLabel number = new JLabel("XXXX-XXXX-XXXX-6234");
    JLabel pin = new JLabel("PIN :");
    JLabel pnumber = new JLabel("XXXX");
    JLabel head = new JLabel("16 digit card number");
    JLabel phead = new JLabel("4 digit pin number");
    JLabel services = new JLabel("Services Required:");
    JCheckBox s1 = new JCheckBox("ATM CARD");
    JCheckBox s2 = new JCheckBox("Internet Banking");
    JCheckBox s3 = new JCheckBox("EMAIL & SMS Alerts");
    JCheckBox s4 = new JCheckBox("MINI STATEMENT");
    JCheckBox s5 = new JCheckBox("Cheque-Book");
    JCheckBox s6 = new JCheckBox("Mobile Banking");
    JCheckBox s7 = new JCheckBox("I hereby declares that the above information being provided is correct");
    JButton submit = new JButton("SUBMIT");
    JButton cancel = new JButton("CANCEL");

    public signup3() {

        jf1.setBounds(320, 90, 800, 700);
        jf1.setLayout(null);
        jf1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        heading.setBounds(280, 30, 350, 30);
        heading.setFont(new Font("railway", Font.BOLD, 25));
        jf1.add(heading);

        typeacc.setBounds(100, 100, 250, 30);
        typeacc.setFont(new Font("Raleway", Font.BOLD, 19));
        jf1.add(typeacc);

        saving.setBounds(120, 150, 150, 20);
        saving.setFont(new Font("Raleway", Font.BOLD, 16));
        jf1.add(saving);

        current.setBounds(350, 150, 150, 20);
        current.setFont(new Font("Raleway", Font.BOLD, 16));
        jf1.add(current);

        fd.setBounds(120, 190, 200, 20);
        fd.setFont(new Font("Raleway", Font.BOLD, 16));
        jf1.add(fd);

        recurring.setBounds(350, 190, 200, 20);
        recurring.setFont(new Font("Raleway", Font.BOLD, 16));
        jf1.add(recurring);

        bg1.add(saving);
        bg1.add(fd);
        bg1.add(current);
        bg1.add(recurring);

        card.setFont(new Font("Raleway", Font.BOLD, 20));
        card.setBounds(90, 250, 150, 30);
        jf1.add(card);

        number.setFont(new Font("Raleway", Font.BOLD, 18));
        number.setBounds(350, 250, 250, 30);
        jf1.add(number);

        pin.setFont(new Font("Raleway", Font.BOLD, 20));
        pin.setBounds(90, 320, 150, 30);
        jf1.add(pin);

        pnumber.setFont(new Font("Raleway", Font.BOLD, 18));
        pnumber.setBounds(350, 320, 150, 30);
        jf1.add(pnumber);

        head.setFont(new Font("Raleway", Font.BOLD, 10));
        head.setBounds(90, 270, 150, 30);
        jf1.add(head);

        phead.setFont(new Font("Raleway", Font.BOLD, 10));
        phead.setBounds(90, 340, 150, 30);
        jf1.add(phead);

        services.setFont(new Font("Raleway", Font.BOLD, 20));
        services.setBounds(90, 390, 200, 30);
        jf1.add(services);

        s1.setBounds(90, 430, 150, 20);
        jf1.add(s1);

        s2.setBounds(350, 430, 150, 20);
        jf1.add(s2);

        s3.setBounds(90, 470, 150, 20);
        jf1.add(s3);

        s4.setBounds(350, 468, 150, 20);
        jf1.add(s4);

        s5.setBounds(90, 510, 150, 20);
        jf1.add(s5);

        s6.setBounds(350, 510, 150, 20);
        jf1.add(s6);

        s7.setBounds(90, 570, 440, 20);
        s7.setBackground(Color.WHITE);
        jf1.add(s7);

        submit.setBounds(200, 610, 100, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        jf1.add(submit);

        cancel.setBounds(330, 610, 100, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        jf1.add(cancel);

        jf1.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
      if(e.getSource()==submit){
         if(!s7.isSelected()){
         JOptionPane.showMessageDialog(null,"Please accept the required details");
      }
      if(!saving.isSelected() && !current.isSelected() && !fd.isSelected() && !recurring.isSelected()){
         JOptionPane.showMessageDialog(null,"Please select atleast one type of account");
      }
      else {
            JOptionPane.showMessageDialog(null,"You are Registered Successfully");
             String accounttype=null;
             if(saving.isSelected()){
                accounttype="Saving Account";
             }
             else if(current.isSelected()){
                accounttype="Current Account";
             }
             else if(fd.isSelected()){
                accounttype="Fixed-Deposit Account";
             }
             else if(recurring.isSelected()){
                accounttype="Recurring Deposit Account";
             }
           Random ran=new Random();
           String cardno= "" + Math.abs(ran.nextLong() % 90000000L + 5040936000000000L);
           String pinno=""+Math.abs(ran.nextLong() % 9000L + 1000L);

           String facility="";
           if(s1.isSelected()){
            facility=facility+"ATM CARD";
           }
           else if(s2.isSelected()){
            facility=facility+"InternetBanking";
           }
           else if(s3.isSelected()){
            facility=facility+"Email & SMS Alerts";
           }
           else if(s4.isSelected()){
            facility=facility+"MINI Statement";
           }
           else if(s5.isSelected()){
            facility=facility+"Cheque-Book";
           }
           else if(s6.isSelected()){
            facility=facility+"Mobile Banking";
           }
           try{
                conn c=new conn();
                String query1="insert into sign3 values('"+accounttype+"','"+cardno+"','"+pinno+"','"+facility+"')";
                c.s.executeUpdate(query1);

                JOptionPane.showMessageDialog(null,"Card Number :"+cardno+"\n"+"Pin Number :"+pinno);
           }
           catch(Exception ea){
            System.out.println(ea);
           }
           jf1.setVisible(false);
           new signin(pinno).setVisible(true);
        }  
      }
        else if(e.getSource()==cancel){
                jf1.setVisible(false);
                new bank().setVisible(true);
          }
    }

    public static void main(String[] args) {
        new signup3();
    }
}

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class signin extends JFrame implements ActionListener {
  JLabel t1;
  JButton deposit = new JButton("Deposit");
  JButton withdraw = new JButton("Cash Withdrawl");
  JButton fastcash = new JButton("Fast Cash");
  JButton mstatement = new JButton("Mini Statement");
  JButton pchange = new JButton("Pin Change");
  JButton balance = new JButton("Balance Enquiry");
  JButton exit = new JButton("Exit");
  JButton loan= new JButton("Loan");
  JFrame jf5 = new JFrame();
  String pinno;
  signin(String pinno) {
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

    JLabel t1 = new JLabel("Please select the service you required");
    t1.setBounds(210, 280, 290, 40);
    t1.setForeground(Color.BLACK);
    t1.setFont(new Font("oswards", Font.BOLD, 14));
    atmimg.add(t1);

    deposit.setBounds(190, 340, 100, 20);
    deposit.setFont(new Font("oswards", Font.BOLD, 12));
    deposit.addActionListener(this);
    atmimg.add(deposit);

    withdraw.setBounds(340, 340, 140, 20);
    withdraw.setFont(new Font("oswards", Font.BOLD, 12));
    withdraw.addActionListener(this);
    atmimg.add(withdraw);

    fastcash.setBounds(190, 365, 100, 20);
    fastcash.setFont(new Font("oswards", Font.BOLD, 12));
    fastcash.addActionListener(this);
    atmimg.add(fastcash);

    mstatement.setBounds(340, 361, 140, 20);
    mstatement.setFont(new Font("oswards", Font.BOLD, 12));
    mstatement.addActionListener(this);
    atmimg.add(mstatement);

    pchange.setBounds(190, 390, 100, 20);
    pchange.setFont(new Font("oswards", Font.BOLD, 12));
    pchange.addActionListener(this);
    atmimg.add(pchange);

    balance.setBounds(340, 383, 140, 20);
    balance.setFont(new Font("oswards", Font.BOLD, 12));
    balance.addActionListener(this);
    atmimg.add(balance);

    loan.setBounds(190, 412, 100, 20);
    loan.setFont(new Font("oswards", Font.BOLD, 12));
    atmimg.add(loan);
    loan.addActionListener(this);

    exit.setBounds(340, 410, 140, 20);
    exit.setFont(new Font("oswards", Font.BOLD, 12));
    atmimg.add(exit);
    exit.addActionListener(this);
    jf5.setVisible(true);
  }

  public void actionPerformed(ActionEvent ae1) {
    if (ae1.getSource() == exit) {
      System.exit(0);
    }
    else if(ae1.getSource()==deposit){
      jf5.setVisible(false);
      new deposit(pinno).setVisible(true);
    }
    else if(ae1.getSource()==withdraw){
      jf5.setVisible(false);
      new withdraw(pinno).setVisible(true);
    }
    else if(ae1.getSource()==fastcash){
       jf5.setVisible(false);
       new fastcash(pinno).setVisible(true);
    }
    else if(ae1.getSource()==pchange){
      jf5.setVisible(false);
      new pinchange(pinno).setVisible(true);
    }
    else if(ae1.getSource()==balance){
      jf5.setVisible(false);
      new balanceenquiry(pinno).setVisible(true);
    }
    else if(ae1.getSource()==mstatement){
      new ministatement(pinno).setVisible(true);
    }
    else if(ae1.getSource()==loan){
      jf5.setVisible(false);
      new loan(pinno).setVisible(true);
    }
  }

  public static void main(String args[]) {
    new signin("");
  }
}
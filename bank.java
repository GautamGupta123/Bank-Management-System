import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class bank extends JFrame implements ActionListener {

    JButton clearall = new JButton("ClearAll");
    JButton login = new JButton("SignIn");
    JButton signup = new JButton("SignUp");
    JTextField cardn = new JTextField();
    JPasswordField pinn = new JPasswordField();
    JFrame jf = new JFrame();

    public bank() {

        jf.setBounds(400, 200, 800, 600);
        jf.setLayout(null);
        jf.setTitle("My Bank");
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("images/bankimg.png"));
        Image i1 = i.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        JLabel l1 = new JLabel(i2);
        l1.setBounds(20, 20, 200, 200);
        jf.add(l1);

        JLabel l2 = new JLabel("Welcome to ATM");
        l2.setBounds(300, 30, 500, 100);
        l2.setFont(new Font("Osward", Font.BOLD, 50));
        jf.add(l2);

        JLabel cardnumber = new JLabel("Enter Your Card Number :");
        cardnumber.setBounds(70, 290, 300, 50);
        cardnumber.setFont(new Font("Oswards", Font.BOLD, 20));
        jf.add(cardnumber);

        JLabel pinnumber = new JLabel("Enter Your Card Pin :");
        pinnumber.setBounds(70, 350, 300, 50);
        pinnumber.setFont(new Font("Oswards", Font.BOLD, 20));
        jf.add(pinnumber);

        cardn.setBounds(325, 302, 200, 30);
        jf.add(cardn);

        pinn.setBounds(325, 362, 200, 30);
        jf.add(pinn);

        login.setBounds(220, 450, 120, 30);
        login.setFont(new Font("Oswards", Font.BOLD, 17));
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        jf.add(login);

        clearall.setBounds(350, 450, 120, 30);
        clearall.setFont(new Font("Oswards", Font.BOLD, 17));
        clearall.setBackground(Color.BLACK);
        clearall.setForeground(Color.WHITE);
        clearall.addActionListener(this);
        jf.add(clearall);

        signup.setBounds(220, 490, 250, 30);
        signup.setFont(new Font("Oswards", Font.BOLD, 17));
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        jf.add(signup);
        signup.addActionListener(this);
        jf.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == clearall) {
            cardn.setText("");
            pinn.setText("");
        } else if (e.getSource() == signup) {
            jf.setVisible(false);
            new signup1().setVisible(true);
        } else if (e.getSource() == login) {
            conn c = new conn();
            String cardno = cardn.getText();
            String pinno = pinn.getText();
            String q = "select * from sign3 where Card_Number='" + cardno + "' and Pin_Number='" + pinno + "'";
            try {
                ResultSet rs = c.s.executeQuery(q);
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Successfully Logged In");
                    jf.setVisible(false);
                    new signin(pinno).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Credentials!!!");
                }
            } catch (Exception ea) {
                System.out.println(ea);
            }

        }
    }

    public static void main(String[] args) {
        new bank();
    }
}

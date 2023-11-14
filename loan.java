import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class loan extends JFrame implements ActionListener {
    JTextField email1 = new JTextField();
    JTextField loanamt1 = new JTextField();
    JFrame j10 = new JFrame();
    JTextField salary1 = new JTextField();
    JLabel l3 = new JLabel("Loan Details");
    JLabel loanamt = new JLabel("Loan Amount");
    JTextField name1 = new JTextField();
    JTextField phone1 = new JTextField();
    JLabel guarantee = new JLabel("Guaranteer");
    JTextField guarantee1 = new JTextField();
    JLabel phone = new JLabel("Phone Number");
    JLabel email = new JLabel("Email Address");
    JButton submit = new JButton("Submit");
    JButton back = new JButton("back");
    JLabel name = new JLabel("Full-Name");
    JLabel salary = new JLabel("Income p.a.");
    String pinno;

    loan(String pinno) {
        this.pinno = pinno; 
        j10.setBounds(400, 20, 800, 800);
        j10.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j10.setLayout(null);

        l3.setBounds(250, 10, 250, 40);
        l3.setFont(new Font("oswards", Font.BOLD, 35));
        j10.add(l3);

        name.setBounds(70, 100, 150, 40);
        name.setFont(new Font("oswards", Font.PLAIN, 24));
        j10.add(name);

        email.setBounds(70, 200, 200, 40);
        email.setFont(new Font("oswards", Font.PLAIN, 24));
        j10.add(email);

        phone.setBounds(70, 300, 200, 40);
        phone.setFont(new Font("oswards", Font.PLAIN, 24));
        j10.add(phone);

        loanamt.setBounds(70, 400, 200, 40);
        loanamt.setFont(new Font("oswards", Font.PLAIN, 24));
        j10.add(loanamt);

        salary.setBounds(70, 500, 200, 40);
        salary.setFont(new Font("oswards", Font.PLAIN, 24));
        j10.add(salary);

        guarantee.setBounds(70, 600, 200, 40);
        guarantee.setFont(new Font("oswards", Font.PLAIN, 24));
        j10.add(guarantee);
        
        name1.setBounds(250, 100, 500, 40);
        name1.setFont(new Font("oswards",Font.PLAIN,18));
        j10.add(name1);

        email1.setBounds(250, 200, 500, 40);
        email1.setFont(new Font("oswards",Font.PLAIN,18));
        j10.add(email1);

        phone1.setBounds(250, 300, 500, 40);
        phone1.setFont(new Font("oswards",Font.PLAIN,18));
        j10.add(phone1);

        loanamt1.setBounds(250, 400, 500, 40);
        loanamt1.setFont(new Font("oswards",Font.PLAIN,18));
        j10.add(loanamt1);

        salary1.setBounds(250, 500, 500, 40);
        salary1.setFont(new Font("oswards",Font.PLAIN,18));
        j10.add(salary1);

        guarantee1.setBounds(250, 600, 500, 40);
        guarantee1.setFont(new Font("oswards",Font.PLAIN,18));
        j10.add(guarantee1);

        submit.setBounds(650, 700, 100, 30);
        submit.setForeground(Color.WHITE);
        submit.setBackground(Color.BLACK);
        submit.setFont(new Font("oswards", Font.BOLD, 20));
        submit.addActionListener(this);
        j10.add(submit);

        back.setBounds(520, 700, 100, 30);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.setFont(new Font("oswards", Font.BOLD, 20));
        back.addActionListener(this);
        j10.add(back);

        j10.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            j10.setVisible(false);
            new signin(pinno).setVisible(true);
        } else if (e.getSource() == submit) {
            String name = name1.getText();
            String email2 = email1.getText();
            String phno1 = phone1.getText();
            String amt = loanamt1.getText();
            String salary = salary1.getText();
            String guarantee = guarantee1.getText();
            if (name.equals("")) {
                JOptionPane.showMessageDialog(null, "Name cannot be left Blank");
            } else if (email2.equals("")) {
                JOptionPane.showMessageDialog(null, "Email cannot be left Blank");
            } else if (phno1.equals("")) {
                JOptionPane.showMessageDialog(null, "Phone Number cannot be left Blank");
            } else if (amt.equals("")) {
                JOptionPane.showMessageDialog(null, "Loan Amount cannt be left Blank");
            } else if (salary.equals("")) {
                JOptionPane.showMessageDialog(null, "Salary cannot be left Blank");
            } else if (guarantee.equals("")) {
                JOptionPane.showMessageDialog(null, "Guarantee cannot be left Blank");
            } else {
                try {
                    conn c = new conn();
                    String query = "insert into loan_info values('" + pinno + "','" +name+ "','"+email2+"','"+phno1+"','"+ amt +"','"+salary+"','"+guarantee+"')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Loan Information Saved Successfully");
                    j10.setVisible(false);
                    new signin(pinno).setVisible(true);
                } catch (Exception e1) {
                    System.out.println(e1);
                }
            }
        }
    }

    public static void main(String[] args) {
        new loan("");
    }
}

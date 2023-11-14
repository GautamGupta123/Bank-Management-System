import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class signup2 extends JFrame implements ActionListener {

    JLabel h1 = new JLabel("Page 2: Additional Details");
    JLabel religion1 = new JLabel("Religion :");
    JLabel category1 = new JLabel("Category :");
    JLabel income1 = new JLabel("Income :");
    JLabel education1 = new JLabel("Educational");
    JLabel qualification1 = new JLabel("Qualification:");
    JLabel occupation1 = new JLabel("Occupation :");
    JLabel panno = new JLabel("Pan Number :");
    JLabel aadharno = new JLabel("Aadhar Number :");
    JLabel existacc = new JLabel("Existing Account :");
    JButton next = new JButton("Next");
    JButton back = new JButton("back");
    JTextField pannumber = new JTextField();
    JTextField aadharnumber = new JTextField();
    JRadioButton yes = new JRadioButton("Yes");
    JRadioButton no = new JRadioButton("No");
    ButtonGroup bg = new ButtonGroup();
    String religionval[] = { "Select", "Hindu", "Muslim", "Christian", "Others" };
    JComboBox<String> religion = new JComboBox<>(religionval);
    String categoryval[] = { "Select", "General", "SC", "ST", "OBC", "Others" };
    JComboBox<String> category = new JComboBox<>(categoryval);
    String incomeval[] = { "Select", "< 1,50,000", "< 2,50,000", "5,00,000", "Upto 10,00,000" };
    JComboBox<String> income = new JComboBox<>(incomeval);
    String eductionval[] = { "Select", "Non-Graduate", "Graduate", "Post-Graduate", "Docrate", "Other" };
    JComboBox<String> edu = new JComboBox<>(eductionval);
    String occupationval[] = { "Select", "Bussiness", "Self-Employeed", "Retired", "Student", "Other" };
    JComboBox<String> occupation = new JComboBox<>(occupationval);
    JFrame jf1 = new JFrame();

    public signup2() {

        jf1.setTitle("Signup Page");
        jf1.setBounds(350, 50, 900, 750);
        jf1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        h1.setBounds(310, 30, 300, 60);
        h1.setFont(new Font("oswards", Font.BOLD, 25));
        jf1.add(h1);

        religion1.setBounds(50, 120, 150, 30);
        religion1.setFont(new Font("oswards", Font.BOLD, 18));
        jf1.add(religion1);

        category1.setBounds(50, 170, 200, 30);
        category1.setFont(new Font("oswards", Font.BOLD, 18));
        jf1.add(category1);

        income1.setBounds(50, 220, 250, 30);
        income1.setFont(new Font("oswards", Font.BOLD, 18));
        jf1.add(income1);

        education1.setBounds(50, 270, 250, 30);
        education1.setFont(new Font("oswards", Font.BOLD, 18));
        jf1.add(education1);

        qualification1.setBounds(50, 290, 250, 30);
        qualification1.setFont(new Font("oswards", Font.BOLD, 18));
        jf1.add(qualification1);

        occupation1.setBounds(50, 370, 250, 30);
        occupation1.setFont(new Font("oswards", Font.BOLD, 18));
        jf1.add(occupation1);

        existacc.setBounds(50, 420, 250, 30);
        existacc.setFont(new Font("oswards", Font.BOLD, 18));
        jf1.add(existacc);

        panno.setBounds(50, 470, 250, 30);
        panno.setFont(new Font("oswards", Font.BOLD, 18));
        jf1.add(panno);

        aadharno.setBounds(50, 520, 250, 30);
        aadharno.setFont(new Font("oswards", Font.BOLD, 18));
        jf1.add(aadharno);

        religion.setBounds(280, 120, 350, 30);
        religion.setBackground(Color.WHITE);
        jf1.add(religion);

        category.setBounds(280, 170, 350, 30);
        category.setBackground(Color.WHITE);
        jf1.add(category);

        income.setBounds(280, 220, 350, 30);
        income.setBackground(Color.WHITE);
        jf1.add(income);

        edu.setBounds(280, 290, 350, 30);
        edu.setBackground(Color.WHITE);
        jf1.add(edu);

        occupation.setBounds(280, 369, 350, 30);
        occupation.setBackground(Color.WHITE);
        jf1.add(occupation);

        yes.setBounds(280, 420, 80, 30);
        yes.setFont(new Font("Arieal", Font.BOLD, 13));
        jf1.add(yes);

        no.setBounds(360, 420, 80, 30);
        no.setFont(new Font("Arieal", Font.BOLD, 13));
        jf1.add(no);

        bg.add(yes);
        bg.add(no);

        pannumber.setBounds(280, 470, 350, 30);
        pannumber.setFont(new Font("Arieal", Font.BOLD, 13));
        jf1.add(pannumber);

        aadharnumber.setBounds(280, 520, 350, 30);
        aadharnumber.setFont(new Font("Arieal", Font.BOLD, 13));
        jf1.add(aadharnumber);

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
        if(e.getSource()==back){
            jf1.setVisible(false);
            new signup1().setVisible(true);
        }
        else{
        int flag = 0;
        String religion2 = (String) religion.getSelectedItem();
        String category2 = (String) category.getSelectedItem();
        String income2 = (String) income.getSelectedItem();
        String occupation2 = (String) occupation.getSelectedItem();
        String education2 = (String) edu.getSelectedItem();
        String aadhar = aadharnumber.getText();
        String pan = pannumber.getText();
        String account = null;
        if (yes.isSelected()) {
            account = "Yes";
        } else {
            account = "No";
        }
        if (!yes.isSelected() && !no.isSelected()) {
            JOptionPane.showMessageDialog(null, "Existing account not Selected");
            flag++;
        }
        if (religion2 == "Select") {
            JOptionPane.showMessageDialog(null, "Religion is not selected");
            flag++;
        }
        if (category2 == "Select") {
            JOptionPane.showMessageDialog(null, "Category is not selected");
            flag++;
        }
        if (income2 == "Select") {
            JOptionPane.showMessageDialog(null, "Select the income");
            flag++;
        }
        if (occupation2 == "Select") {
            JOptionPane.showMessageDialog(null, "Occupation is not Selected");
            flag++;
        }
        if (education2 == "Select") {
            JOptionPane.showMessageDialog(null, "Education is not selected");
            flag++;
        }
        if(aadhar.equals("")){
            JOptionPane.showMessageDialog(null,"Aadhaar number cannot be empty!");
            flag++;
        }
        if(pan.equals("")){
            JOptionPane.showMessageDialog(null,"Pan Card Number cannot be empty!");
            flag++;
        }
        if(!pan.equals("") && (pan.length()>10 || pan.length()<10)){
            JOptionPane.showMessageDialog(null,"Invalid Pan card Number! Please enter valid one.");
            flag++;
        }
        if(!aadhar.equals("") && (aadhar.length()>12 || aadhar.length()<12)){
            JOptionPane.showMessageDialog(null,"Invalid Aadhaar Number! Please enter valid one.");
            flag++;
        }
        if (flag == 0) {
            try {
                conn c = new conn();
                String query = "insert into sign2 values('" + religion2 + "','" + category2 + "','" + income2 + "','"
                        + occupation2 + "','" + education2 + "','" + account + "','" + aadhar + "','" + pan + "')";
                c.s.executeUpdate(query);
            } catch (Exception e1) {
                System.out.println(e1);
            }
            jf1.setVisible(false);
            new signup3().setVisible(true);
        }
    }
    }

    public static void main(String[] args) {
        new signup2();
    }
}

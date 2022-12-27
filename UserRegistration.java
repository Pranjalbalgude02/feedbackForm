package net.javaguides.swing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.border.EmptyBorder;


public class UserRegistration extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField firstname;
    private JTextField lastname;
    private JTextField email;
    private JTextField apptitle;
    private JTextField servicerating;
    private JTextField deliverytime;
    private JTextField deliverycharge;
    private JTextField friend;
    
    private JTextField mob;
    private JPasswordField passwordField;
    private JButton btnNewButton;
    private JRadioButton star;

  
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UserRegistration frame = new UserRegistration();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    

    public UserRegistration() {
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\User\\Desktop\\STDM.jpg"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 190, 1014, 597);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

     
        
        JLabel lblFeedbackForm = new JLabel("Feedback Form For Online Delivery");
        lblFeedbackForm.setFont(new Font("Times New Roman", Font.PLAIN, 42));
        lblFeedbackForm.setBounds(222, 12, 725, 50);
        contentPane.add(lblFeedbackForm);
        
        JLabel lblName = new JLabel("First name");
        lblName.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblName.setBounds(38, 70, 79, 20);
        contentPane.add(lblName);

        JLabel lblNewLabel = new JLabel("Last name");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblNewLabel.setBounds(38, 110, 160, 20);
        contentPane.add(lblNewLabel);

        JLabel lblEmailAddress = new JLabel("Reviewer Email");
        lblEmailAddress.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblEmailAddress.setBounds(38, 150, 124, 20);
        contentPane.add(lblEmailAddress);
        
        JLabel lblTitle = new JLabel("application Name");
        lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblTitle.setBounds(38, 190, 124, 20);
        contentPane.add(lblTitle);
        
        JLabel lblrate = new JLabel("Rating:  (poor/very poor/good/better/best)");
        lblrate.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblrate.setBounds(390, 230, 624, 20);
        contentPane.add(lblrate);
        
        JLabel lblrating = new JLabel("How would you rate our overall service?");
        lblrating.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblrating.setBounds(38, 270, 624, 20);
        contentPane.add(lblrating);
        
        JLabel lbltime = new JLabel("How was the delivery time?");
        lbltime.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lbltime.setBounds(700, 270, 624, 20);
        contentPane.add(lbltime);

        JLabel lblprice = new JLabel("How was the delivery charges?");
        lblprice.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblprice.setBounds(38, 350, 624, 20);
        contentPane.add(lblprice);
        
        JLabel lblquality = new JLabel("How was the friendlyness of delivery man?");
        lblquality.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblquality.setBounds(700, 350, 624, 20);
        contentPane.add(lblquality);
        
        firstname = new JTextField();
        firstname.setFont(new Font("Tahoma", Font.PLAIN, 14));
        firstname.setBounds(150, 70, 160, 25);
        contentPane.add(firstname);
        firstname.setColumns(10);

        lastname = new JTextField();
        lastname.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lastname.setBounds(150, 110, 160, 25);
        contentPane.add(lastname);
        lastname.setColumns(10);

        email = new JTextField();
        email.setFont(new Font("Tahoma", Font.PLAIN, 14));
        email.setBounds(150, 150, 160, 25);
        contentPane.add(email);
        email.setColumns(10);
        
        apptitle = new JTextField();
        apptitle.setFont(new Font("Tahoma", Font.PLAIN, 14));
        apptitle.setBounds(150, 190, 160, 25);
        contentPane.add(apptitle);
        apptitle.setColumns(10);
        
        servicerating = new JTextField();
        servicerating.setFont(new Font("Tahoma", Font.PLAIN, 14));
        servicerating.setBounds(38, 300, 250, 25);
        contentPane.add(servicerating);
        servicerating.setColumns(10);
        
        deliverytime = new JTextField();
        deliverytime.setFont(new Font("Tahoma", Font.PLAIN, 14));
        deliverytime.setBounds(700, 300, 250, 25);
        contentPane.add(deliverytime);
        deliverytime.setColumns(10);
        
        deliverycharge = new JTextField();
        deliverycharge.setFont(new Font("Tahoma", Font.PLAIN, 14));
        deliverycharge.setBounds(38, 380, 250, 25);
        contentPane.add(deliverycharge);
        deliverycharge.setColumns(10);
        
        friend = new JTextField();
        friend.setFont(new Font("Tahoma", Font.PLAIN, 14));
        friend.setBounds(700, 380, 250, 25);
        contentPane.add(friend);
        friend.setColumns(10);


        

        
        
        btnNewButton = new JButton("Submit");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String firstName = firstname.getText();
                String lastName = lastname.getText();
                String emailId = email.getText();
                String Title = apptitle.getText();
                String rating = servicerating.getText();
               
                String time = deliverytime.getText();
                String price = deliverycharge.getText();
                String quality = friend.getText();
                
				
                String msg = "" + firstName;           				
                msg += " \n";
               

                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/swing_demo", "root", "vaishu");

                    String query = "INSERT INTO orderdelivery values('" + firstName + "','" + lastName + "','" + emailId + "','" + Title + "','" + rating
                    		+ "', '" +
                    		time + "','" + price + "', '" + quality + "')";

                    Statement sta = connection.createStatement();
                    int x = sta.executeUpdate(query);
                    if (x == 0) {
                        JOptionPane.showMessageDialog(btnNewButton, "This is alredy exist");
                    } else {
                        JOptionPane.showMessageDialog(btnNewButton,
                            "Thankyou!, " + msg + "Your feedback is sucessfully recorded");
                    }
                    connection.close();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
        btnNewButton.setBounds(399, 447, 259, 74);
        contentPane.add(btnNewButton);
    }
}
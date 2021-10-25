package WithLogin;

import java.awt.Color;
import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.util.regex.*;

public class Registration extends JFrame implements  ActionListener {
	
	
	public Registration() {
		setSize(500,460);
//		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(3);
		setLayout(null);
		
		// header Panel
		JPanel headerPanel = new JPanel();
		headerPanel.setBackground(new Color(54,198,217));
		headerPanel.setBounds(5,5,490,60);
		add(headerPanel);
		
		JLabel headerText = new JLabel("Registration Form !");
		headerText.setFont(new Font("Arial",Font.BOLD,30));
		headerPanel.add(headerText);
		
		//Input Field Panel
		JPanel inputPanel = new JPanel();
		inputPanel.setBackground(new Color(75,196,196));
		inputPanel.setBounds(5,70,490,425);
		inputPanel.setLayout(null);
		add(inputPanel);
		
		JLabel nameLabel = new JLabel("Name : ");
		nameLabel.setBounds(130,5,100,25);
		nameLabel.setFont(new Font("Arial",Font.BOLD,16));
		nameLabel.setForeground(Color.white);
		inputPanel.add(nameLabel);
		JTextField nametext = new JTextField();
		nametext.setBounds(200,5,200,25);
		inputPanel.add(nametext);
		
		JLabel emailLabel = new JLabel("Email : ");
		emailLabel.setBounds(130,50,100,25);
		emailLabel.setFont(new Font("Arial",Font.BOLD,16));
		emailLabel.setForeground(Color.white);
		inputPanel.add(emailLabel);
		JTextField emailtext = new JTextField();
		emailtext.setBounds(200,50,200,25);
		inputPanel.add(emailtext);
		
		JLabel passLabel = new JLabel("Password : ");
		passLabel.setBounds(95,100,100,25);
		passLabel.setFont(new Font("Arial",Font.BOLD,16));
		passLabel.setForeground(Color.white);
		inputPanel.add(passLabel);
		JTextField passtext = new JTextField();
		passtext.setBounds(200,100,200,25);
		inputPanel.add(passtext);
		
		JLabel conPassLabel = new JLabel("Confirm Password : ");
		conPassLabel.setBounds(30,150,170,25);
		conPassLabel.setFont(new Font("Arial",Font.BOLD,16));
		conPassLabel.setForeground(Color.white);
		inputPanel.add(conPassLabel);
		JTextField conPasstext = new JTextField();
		conPasstext.setBounds(200,150,200,25);
		inputPanel.add(conPasstext);
		
		JLabel mobileLabel = new JLabel("Mobile : ");
		mobileLabel.setBounds(120,200,100,25);
		mobileLabel.setFont(new Font("Arial",Font.BOLD,16));
		mobileLabel.setForeground(Color.white);
		inputPanel.add(mobileLabel);
		JTextField mobiletext = new JTextField();
		mobiletext.setBounds(200,200,200,25);
		inputPanel.add(mobiletext);
		
		JLabel addressLabel = new JLabel("Address : ");
		addressLabel.setBounds(105,250,100,25);
		addressLabel.setFont(new Font("Arial",Font.BOLD,16));
		addressLabel.setForeground(Color.white);
		inputPanel.add(addressLabel);
		JTextField addresstext = new JTextField();
		addresstext.setBounds(200,250,200,25);
		inputPanel.add(addresstext);
		
		//button field
		JButton register = new JButton("Register");
		register.setBounds(300,300,100,30);
		register.setBackground(new Color(191,42,117));
		register.setFont(new Font("Arial",Font.BOLD,16));
		register.setBorder(new LineBorder(Color.gray));
		register.setForeground(Color.WHITE);
		inputPanel.add(register);
		
		JButton loginBtn = new JButton("Login");
		loginBtn.setBounds(195,300,100,30);
		loginBtn.setBackground(new Color(191,42,117));
		loginBtn.setFont(new Font("Arial",Font.BOLD,16));
		loginBtn.setBorder(new LineBorder(Color.gray));
		loginBtn.setForeground(Color.WHITE);
		inputPanel.add(loginBtn);
		
		setVisible(true);
		
		register.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//get input text
				String userName = nametext.getText();
				String email = emailtext.getText();
				String pass = passtext.getText();
				String conPass = conPasstext.getText();
				String mobile = mobiletext.getText();
				String address = addresstext.getText();
				
				//validation
				String mobileRex = "(\\+88)?01[3-9]\\d{8}";
				String nameRex = "^[a-zA-Z. ]+$";
				String emailRex = "^[a-zA-Z0-9.]+@[a-z]+.[a-z]+$";
				String passRex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
				
				//conditions
				if(!Pattern.matches(nameRex, userName)) {
					JOptionPane.showMessageDialog(null,"In-Valid UserName");
				}
				else if(!Pattern.matches(emailRex, email)) {
					JOptionPane.showMessageDialog(null,"In-Valid Email");
				}
				else if(!pass.equals(conPass)) {
					JOptionPane.showMessageDialog(null,"PassWord and Confirm-password are not matched.");
				}
				
				else if(!Pattern.matches(passRex, pass)) {
					JOptionPane.showMessageDialog(null,"Please, Give a Strong Password & Following :\r\n"
							+ "1. A digit must occur at least once \r\n"
							+ "2. A lower case letter must occur at least once \r\n"
							+ "3. An upper case letter must occur at least once \r\n"
							+ "4. A special character must occur at least once \r\n"
							+ "5. no whitespace allowed in the entire string \r\n"
							+ "6. Ensure string is of length 8.\r\n");
				}
				
				else if(!Pattern.matches(mobileRex, mobile)) {
					JOptionPane.showMessageDialog(null,"In-Valid Mobile number");
				}
				else {
					try {
						
						DataBaseConnect db = new DataBaseConnect();
                 		String queryInsert = "INSERT INTO `users`(`userName`, `email`, `pass`, `mobile`, `address`) VALUES ('"+userName+"','"+email+"','"+pass+"','"+mobile+"','"+address+"')";
						
						db.RegisterInsert(queryInsert);
						
						
					} catch(Exception e2) {
						System.err.println(e2);
					}
					
				}
				
				
				
				
			}
			
		});
		loginBtn.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Login();
			}
			
		});
				
		
		
				
		
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}

	

}
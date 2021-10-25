package WithLogin;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class MainWindow extends JFrame implements ActionListener {
	JButton addImageBtn, insertBtn, updateBtn , deleteBtn;
	String imagePath ;
	JLabel imageDisplayLabel ;
	JFileChooser fc;
	public MainWindow() {
		setSize(800,420);
		
		setLocationRelativeTo(null);
		setDefaultCloseOperation(3);
		setLayout(null);
		setTitle("Product Info");
		
		      // header Panel
				JPanel addPanel = new JPanel();
				addPanel.setBackground(new Color(93,161,217));
				addPanel.setBounds(0,0,410,420);
				addPanel.setLayout(null);
				add(addPanel);
				
				
				
			
				JPanel showPanel = new JPanel();
				showPanel.setBackground(new Color(199,227,240));
				showPanel.setBounds(410,0,410,420);
				showPanel.setLayout(null);
				add(showPanel);
				
				
				Font font =  new Font ("Arial",Font.BOLD,16);
				// name area 
			    JLabel nameLabel = new JLabel("Product Name : ");
			    nameLabel.setBounds(10,10,150,25);
			    nameLabel.setFont(font);		    
			    addPanel.add(nameLabel);
			    
			    
			    JTextField nameTxt = new JTextField();
			    nameTxt.setBounds(180,10,200,25);
			    nameTxt.setFont(font);
			    addPanel.add(nameTxt);
			    
			    // price area
			    JLabel priceLabel = new JLabel("Product price : ");
			    priceLabel.setBounds(10,45,150,25);
			    priceLabel.setFont(font);		    
			    addPanel.add(priceLabel);
			    
			    
			    JTextField priceTxt = new JTextField();
			    priceTxt.setBounds(180,45,200,25);
			    priceTxt.setFont(font);
			    addPanel.add(priceTxt);
			    
			    // product quantity
			    JLabel quantityLabel = new JLabel("Product quantity : ");
			    quantityLabel.setBounds(10,80,150,25);
			    quantityLabel.setFont(font);		    
			    addPanel.add(quantityLabel);
			    
			    
			    JTextField quantityTxt = new JTextField();
			    quantityTxt.setBounds(180,80,200,25);
			    quantityTxt.setFont(font);
			    addPanel.add(quantityTxt);
			    
			    
			    //add img
			    
			    JLabel addImageLabel = new JLabel("Add Image : ");
			    addImageLabel.setBounds(10,115,150,25);
			    addImageLabel.setFont(font);		    
			    addPanel.add(addImageLabel);
			    
			    //button field
				addImageBtn = new JButton("Add Image");
				addImageBtn.setBounds(180,115,150,35);
				addImageBtn.setBackground(new Color(191,42,117));
				addImageBtn.setFont(new Font("Arial",Font.BOLD,16));
				addImageBtn.setBorder(new LineBorder(Color.gray));
				addImageBtn.setForeground(Color.WHITE);
				addPanel.add(addImageBtn);
				
				//fileChooser for img
				addImageBtn.addActionListener(this);
				
				// images box
				 imageDisplayLabel = new JLabel();
				 imageDisplayLabel.setBounds(180,160,200,150);
				 imageDisplayLabel.setBorder(new LineBorder(Color.gray));
				 imageDisplayLabel.setForeground(Color.BLACK);
				 		    
				 addPanel.add(imageDisplayLabel);
				 
				//button field are insert ,update, 
				 insertBtn = new JButton("Insert");
			     insertBtn.setBounds(50,330,100,30);
				 insertBtn.setBackground(new Color(191,42,117));
				 insertBtn.setFont(new Font("Arial",Font.BOLD,16));
				 insertBtn.setBorder(new LineBorder(Color.gray));
				 insertBtn.setForeground(Color.WHITE);
				 addPanel.add(insertBtn);
				 
				 updateBtn = new JButton("Update");
			     updateBtn.setBounds(175,330,100,30);
				 updateBtn.setBackground(new Color(191,42,117));
				 updateBtn.setFont(new Font("Arial",Font.BOLD,16));
				 updateBtn.setBorder(new LineBorder(Color.gray));
				 updateBtn.setForeground(Color.WHITE);
				 addPanel.add(updateBtn);
				 
				 deleteBtn = new JButton("Delete");
			     deleteBtn.setBounds(300,330,100,30);
				 deleteBtn.setBackground(new Color(191,42,117));
				 deleteBtn.setFont(new Font("Arial",Font.BOLD,16));
				 deleteBtn.setBorder(new LineBorder(Color.gray));
				 deleteBtn.setForeground(Color.WHITE);
				 addPanel.add(deleteBtn);
			    
			    
			    
			    
			    
			    
			    
				
				setVisible(true);
				
			
		
		      
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
			if(e.getSource() == addImageBtn) {
				try {
					fc = new JFileChooser();
					fc.showDialog(null, "Choose");
					
					File file = fc.getSelectedFile();
					imagePath = file.getAbsolutePath();
					ImageIcon image = new ImageIcon(new ImageIcon(imagePath).getImage().getScaledInstance(200,150,Image.SCALE_DEFAULT));
					imageDisplayLabel.setIcon(image);
					
					
				}catch(Exception e2) {
					System.err.println("image error : "+e2);
				}
			}
		
	}

}


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/* This class designs the introduction screen and makes the adjustments for the user signing and action functions. */

public class Intro_SCREEN extends JFrame implements DESIGN{
	JPanel mainpanel =new JPanel(new BorderLayout()); // field variable initializations
	JPanel buttonpanel= new JPanel();
	JPanel signinpanel= new JPanel(new BorderLayout());
	JPanel signuppanel= new JPanel(new GridLayout(7, 2,5,5));
	JButton signinbutton= new JButton("SIGN IN");
	JButton signupbutton= new JButton("SIGN UP");
	/////////////////SIGN IN//////////////////////////////
	JPanel sinpanel1 = new JPanel();
	JPanel sinpanel2 = new JPanel();
	JLabel username_in = new JLabel("Username :");
	JLabel password_in = new JLabel("Password :");
	JTextField uname = new JTextField();
	JPasswordField pw = new JPasswordField();
	JButton login= new JButton("LOGIN");
	JButton cancellog=new JButton("CANCEL");
	/////////////////SIGN UP/////////////////////////////
	JLabel name = new JLabel("Name :");
	JTextField namefield= new JTextField();
	JLabel age = new JLabel("Age :");
	JTextField agefield = new JTextField();
	JPanel genderpanel = new JPanel(new FlowLayout());
	JLabel gender = new JLabel("Gender :");
	JRadioButton male = new JRadioButton("Male");
	JRadioButton female = new JRadioButton("Female");
	ButtonGroup gendergroup = new ButtonGroup();
	JLabel usernameLabel = new JLabel("Username :");
	JTextField username = new JTextField();
	JLabel passwordLabel = new JLabel("Password :");
	JPasswordField password = new JPasswordField();
	JLabel passwordAuthLabel = new JLabel("Password (Again) :");
	JPasswordField passwordAuth = new JPasswordField();
	JButton signup = new JButton("SIGN UP");
	JButton cancelsignup=new JButton("CANCEL");
	//////////////////////////////////////////////////////
	USER userlogged;
	
	ArrayList <USER> allUsers = new <USER> ArrayList();
	
	public Intro_SCREEN() throws FileNotFoundException, IOException{ //constructor
		design();
	}
	
	public void design() throws FileNotFoundException, IOException{ //implemented from DESIGN interface
		signIn();
		signUp();
		
		ObjectInputStream input = new ObjectInputStream(new FileInputStream(new File("src/main/java/users.dat")));
		//allUsers = (ArrayList<USER>) input.readObject();
		ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(new File("src/main/java/users.dat")));
		setTitle("ORGANDOKU v.1.0");
		
		setSize(300, 80);
		setLocationRelativeTo(null);
		setVisible(true);
		
		add(mainpanel);
		mainpanel.add(buttonpanel, BorderLayout.NORTH);
		buttonpanel.add(signinbutton );
		buttonpanel.add(signupbutton);
		
		signinbutton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				mainpanel.remove(signinpanel);
				mainpanel.remove(signuppanel);
				mainpanel.add(signinpanel,BorderLayout.CENTER);
				
				setSize(350, 175);
				setLocationRelativeTo(null);
				repaint();
				validate();
			}	

		});
		signupbutton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				mainpanel.remove(signinpanel);
				mainpanel.remove(signuppanel);
				mainpanel.add(signuppanel,BorderLayout.CENTER);
				
				setSize(700, 600);
				setLocationRelativeTo(null);
				repaint();
				validate();
			}
		});
		login.addActionListener(new ActionListener() {// buraya bakilacak
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean usernamestate=  false; // encapsulation ornegi icin fieldda private tanimlanabilir (sonradan sifirlamak sartiyla)
				boolean passwordstate = false;
				
				
			for(int i=0;i<allUsers.size();i++)	{	 
						
			if(uname.getText().equals(allUsers.get(i).getUsername()) && (pw.getText().equals(allUsers.get(i).getPassword()))){
							userlogged=allUsers.get(i);
							usernamestate=true;
							passwordstate=true;

						}}
					
				if(usernamestate&&passwordstate){
					JOptionPane.showMessageDialog(new JPanel(),"Successfully logged in.");
					Mode_SelectScreen selectscreen =new Mode_SelectScreen(userlogged);
					dispose();
				}else{
					uname.setText("");
					pw.setText("");
				}	
			}
		});
		cancellog.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainpanel.remove(signinpanel);
				mainpanel.remove(signuppanel);
				setSize(300, 80);
				setLocationRelativeTo(null);
				repaint();
				validate();
				
			}
		});
		signup.addActionListener(new ActionListener() {
			String message = "Successfully signed up. Please log in.";
			@Override
			public void actionPerformed(ActionEvent e) {
				name.setForeground(Color.BLACK);
				age.setForeground(Color.BLACK);
				gender.setForeground(Color.BLACK);
				usernameLabel.setForeground(Color.BLACK);
				passwordLabel.setForeground(Color.BLACK);
				passwordAuthLabel.setForeground(Color.BLACK);
				boolean usernamestate=false;
				boolean passwordstate=false;
				boolean namestate=false;
				boolean agestate=false; 
				boolean passwordauthstate=false;
				boolean genderstate=true;
				
				if (!(username.getText().equals(""))) {
					usernamestate=true;
				}
				if(password.getText().length()>3){
					passwordstate=true;
				}
				if (!(namefield.getText().equals(""))) {
					namestate=true;
				}
				if (isinteger(agefield)){
					agestate=true;
				}
				if(!(passwordAuth.getText().equals(""))&&passwordAuth.getText().equals(password.getText())){
					passwordauthstate=true;
				}
				if (gendergroup.getSelection() == null){
					genderstate=false;
				}
				
					
					for (int i = 0;i<allUsers.size();i++){
						if(username.getText().equals(allUsers.get(i).getUsername())){
							JOptionPane.showMessageDialog(new JFrame(), "This username is already used");
							usernamestate=false;
						}
					}	
					if(usernamestate&&passwordstate&&namestate&&agestate&&passwordauthstate&&genderstate){
						USER user= new USER(namefield.getText(),Integer.parseInt(agefield.getText()), male.isSelected()
								, username.getText(), password.getText());
						allUsers.add(user);
						try {
							output.writeObject(allUsers);
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						JOptionPane.showMessageDialog(null, message);
						mainpanel.remove(signuppanel);
						mainpanel.add(signinpanel,BorderLayout.CENTER);
						
						
						setSize(350, 175);
						setLocationRelativeTo(null);
						repaint();
						validate();
					}
					else{
						if (usernamestate==false) {
							usernameLabel.setForeground(Color.RED);
							username.setText("");
						}
						if (passwordstate==false){
							passwordLabel.setForeground(Color.RED);
							password.setText("");
							passwordAuthLabel.setForeground(Color.RED);
						}
						if (genderstate==false) {
							gender.setForeground(Color.RED);
							
						}
						if (namestate==false){
							name.setForeground(Color.RED);
							namefield.setText("");
						}
						if (agestate==false) {
							age.setForeground(Color.RED);
							agefield.setText("");
						}
						if (passwordauthstate==false){
							passwordLabel.setForeground(Color.RED);
							password.setText("");
							passwordAuth.setText("");
						
							if(passwordstate==true)
							JOptionPane.showMessageDialog(new JFrame(), "Please type your password again");
						}
					}
						
					}}
			
		);
		cancelsignup.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainpanel.remove(signinpanel);
				mainpanel.remove(signuppanel);
				
				setSize(300, 80);
				setLocationRelativeTo(null);
				
				repaint();
				validate();
			}});
		
	}
	
	
	private boolean isinteger(JTextField agefield) {
		try{
			int a=Integer.parseInt(agefield.getText());
		}catch (Exception e) {
			return false;
		}
		return true;
	}
	private void signIn() {
		sinpanel2.setLayout(new GridLayout(3, 2,5,5));
		sinpanel2.add(username_in);
		sinpanel2.add(uname);
		sinpanel2.add(password_in);
		sinpanel2.add(pw);
		sinpanel2.add(login);
		sinpanel2.add(cancellog);
		signinpanel.add(sinpanel2,BorderLayout.CENTER);
		
		
	}
	private void signUp() {
		signuppanel.add(name);
		signuppanel.add(namefield);
		signuppanel.add(age);
		signuppanel.add(agefield);
		signuppanel.add(gender);
		gendergroup.add(male);
		gendergroup.add(female);
		genderpanel.add(male);
		genderpanel.add(female);
		signuppanel.add(genderpanel);
		signuppanel.add(usernameLabel);
		signuppanel.add(username);
		signuppanel.add(passwordLabel);
		signuppanel.add(password);
		signuppanel.add(passwordAuthLabel);
		signuppanel.add(passwordAuth);
		signuppanel.add(signup);
		signuppanel.add(cancelsignup);
	
	}
	
}

package org.deneme.organdoku.screen;

import org.springframework.stereotype.Component;

import java.awt.*;
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

import javax.swing.*;

@Component
public class Game extends JFrame {
	//Font fnt = new Font("Bodoni MT Black",30, 30); // constant variable for unary font design

	private final JPanel mainPanel = new Panel();
	private final JPanel welcomePanel = new Panel();
	private final JPanel buttonPanel = new Panel();
	private final JPanel signInPanel = new JPanel(new BorderLayout());
	private final JPanel signUpPanel = new JPanel(new GridLayout(7, 2,5,5));
	private final JButton signInButton = new JButton("SIGN IN");
	private final JButton signUpButton = new JButton("SIGN UP");
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
	User userlogged;
	
	ArrayList <User> allUsers = new <User> ArrayList();
	
	public Game() throws IOException{ //constructor
		String welcome = "This ORGANDOKU program brings a brain teaser to you!\n"+
				"ORGANDOKU has two different game modes: GENERIC ORGANDOKU and DKA (DON'T KILL ANYBODY)\n"+
				"ORGANDOKU mode is very similar to generic sudoku structure, with some twist. " +
				"For every completed 3x3 section,\n"+
				"(which are represented as PATIENTS),row and column, you will gain BONUS points:\n"+
				"3x3 SECTION = + 20 PTS\n"+
				"ROW & COLUMN = + 15 PTS\n"+
				"On the contrary, you will be penalized for every MISTAKE you will perform.\n"+
				"MISTAKE = - 5 PTS\n"+
				"If your score drops below - 50, YOU WILL SCREW UP!\n"+
				"DKA (DON'T KILL ANYBODY) mode is a crueler mode, which doesn't let you kill a PATIENT! \n" +
				"Which means, YOU CAN'T MAKE ANY MISTAKE!\n"+
				"Point regulation is the same for both modes.\n"+
				"ORGANDOKU provides a good-looking, sleek user interface and easy playability.";

		//JOptionPane.showMessageDialog(new JFrame(), welcome);
		this.add(mainPanel);
		//this.pack(); // TODO
		mainPanel.add(welcomePanel, BorderLayout.CENTER);
		mainPanel.add(buttonPanel, BorderLayout.SOUTH);
		JTextArea welcomeText = new JTextArea(welcome);
		welcomeText.setEditable(false);
		welcomePanel.add(welcomeText);
		buttonPanel.add(signInButton);
		buttonPanel.add(signUpButton);
		design();
	}
	
	public void design() throws FileNotFoundException, IOException{ //implemented from org.deneme.organdoku.screen.DESIGN interface
		signIn();
		signUp();
		
		ObjectInputStream input = new ObjectInputStream(new FileInputStream(new File("src/main/java/users.dat")));
		//allUsers = (ArrayList<org.deneme.organdoku.screen.USER>) input.readObject();
		ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(new File("src/main/java/users.dat")));
		
		signInButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				mainPanel.remove(welcomePanel);
				mainPanel.remove(buttonPanel);
				mainPanel.remove(signInPanel);
				mainPanel.remove(signUpPanel);
				mainPanel.add(signInPanel,BorderLayout.CENTER);
				
				setSize(350, 175);
				setLocationRelativeTo(null);
				repaint();
				validate();
			}	

		});
		signUpButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				mainPanel.remove(signInPanel);
				mainPanel.remove(signUpPanel);
				mainPanel.add(signUpPanel,BorderLayout.CENTER);
				
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
					ModeSelectScreen selectscreen =new ModeSelectScreen(userlogged);
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
				mainPanel.remove(signInPanel);
				mainPanel.remove(signUpPanel);
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
						User user= new User(namefield.getText(),Integer.parseInt(agefield.getText()), male.isSelected()
								, username.getText(), password.getText());
						allUsers.add(user);
						try {
							output.writeObject(allUsers);
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						JOptionPane.showMessageDialog(null, message);
						mainPanel.remove(signUpPanel);
						mainPanel.add(signInPanel,BorderLayout.CENTER);
						
						
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
				mainPanel.remove(signInPanel);
				mainPanel.remove(signUpPanel);
				
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
		signInPanel.add(sinpanel2,BorderLayout.CENTER);
		
		
	}
	private void signUp() {
		signUpPanel.add(name);
		signUpPanel.add(namefield);
		signUpPanel.add(age);
		signUpPanel.add(agefield);
		signUpPanel.add(gender);
		gendergroup.add(male);
		gendergroup.add(female);
		genderpanel.add(male);
		genderpanel.add(female);
		signUpPanel.add(genderpanel);
		signUpPanel.add(usernameLabel);
		signUpPanel.add(username);
		signUpPanel.add(passwordLabel);
		signUpPanel.add(password);
		signUpPanel.add(passwordAuthLabel);
		signUpPanel.add(passwordAuth);
		signUpPanel.add(signup);
		signUpPanel.add(cancelsignup);
	
	}
	
}

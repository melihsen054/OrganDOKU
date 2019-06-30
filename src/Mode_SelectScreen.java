import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Mode_SelectScreen extends JFrame{ // manages the mode selections
	
	private JLabel header = new JLabel("CHOOSE GAME MODE");
	
	private JButton nrml = new JButton();
	private JButton dka = new JButton();
	ImageIcon nrmIcon = new ImageIcon("src/nrmlIcon.png");
	ImageIcon dkaIcon = new ImageIcon("src/dkaIcon.png");
	
	private JPanel btnPnl = new JPanel();
	
	private JButton nrmEasy = new JButton("EASY");
	private JButton nrmMedium = new JButton("MEDIUM"); // bunlara actionlistener eklenecek
	private JButton nrmHard = new JButton("HARD");
	
	private JButton dkaEasy = new JButton("EASY");
	private JButton dkaMedium = new JButton("MEDIUM");
	private JButton dkaHard = new JButton("HARD");
	
	private USER user;
	
	public Mode_SelectScreen(USER user){
		this.user = user;
		header.setFont(new Font("Bodoni MT Black",30,30));
		setLayout(new BorderLayout());
		
		btnPnl.setLayout(new GridLayout(1,2));
		
		nrml.setIcon(nrmIcon);
		dka.setIcon(dkaIcon);
		
		
		btnPnl.add(nrml);
		btnPnl.add(dka);		
		add(header,BorderLayout.NORTH);
		add(btnPnl,BorderLayout.CENTER);
		

		
		nrml.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				btnPnl.removeAll();
				header.setText("CHOOSE DIFFICULTY - NORMAL");
				btnPnl.setLayout(new GridLayout(3,1,10,10));
				btnPnl.add(nrmEasy);
				btnPnl.add(nrmMedium);
				btnPnl.add(nrmHard);
				repaint();
				revalidate();
				
			}
		});
		
		
		
		nrmEasy.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				MODE easy = new Normal();
				easy.setDiff(0);
				Game_SCREEN screen = new Game_SCREEN(easy,user);	
				dispose();
			}
		});
		nrmMedium.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MODE medium = new Normal();
				medium.setDiff(1);
				Game_SCREEN screen = new Game_SCREEN(medium,user);	
				dispose();
			}
		});
		nrmHard.addActionListener(new ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent e) {
				MODE hard = new Normal();
				hard.setDiff(2);
				Game_SCREEN screen = new Game_SCREEN(hard,user);		
				dispose();
			}
		});
		
		
		dka.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				btnPnl.removeAll();
				btnPnl.setLayout(new GridLayout(3,1,10,10));
				header.setText("CHOOSE DIFFICULTY - DKA");
				btnPnl.add(dkaEasy);
				btnPnl.add(dkaMedium);
				btnPnl.add(dkaHard);
				repaint();
				revalidate();
			
			}
		});
		
		dkaEasy.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				

				MODE dka_easy = new DKA();
				dka_easy.setDiff(0);
				Game_SCREEN screen = new Game_SCREEN(dka_easy,user);		
				dispose();
				
			}
		});
		dkaMedium.addActionListener(new ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent e) {
	
				MODE dka_medium = new DKA();
				dka_medium.setDiff(1);
				Game_SCREEN screen = new Game_SCREEN(dka_medium,user);	
				
				dispose();
				
			}
		});
		dkaHard.addActionListener(new ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent e) {
				MODE dka_hard = new DKA();
				dka_hard.setDiff(2);
				Game_SCREEN screen = new Game_SCREEN(dka_hard,user);		
				dispose();

			}
		});

		setSize(800,500);
		setUndecorated(true);	
		setLocationRelativeTo(null);
		setVisible(true);
	}


}

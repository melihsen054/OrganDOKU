package org.deneme.organdoku.screen;

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

public class ModeSelectScreen extends JFrame{ // manages the mode selections
	
	private JLabel header = new JLabel("CHOOSE GAME org.deneme.organdoku.screen.MODE");
	
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
	
	private User user;
	
	public ModeSelectScreen(User user){
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
			
				Mode easy = new Normal();
				easy.setDiff(0);
				GameScreen screen = new GameScreen(easy,user);
				dispose();
			}
		});
		nrmMedium.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Mode medium = new Normal();
				medium.setDiff(1);
				GameScreen screen = new GameScreen(medium,user);
				dispose();
			}
		});
		nrmHard.addActionListener(new ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent e) {
				Mode hard = new Normal();
				hard.setDiff(2);
				GameScreen screen = new GameScreen(hard,user);
				dispose();
			}
		});
		
		
		dka.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				btnPnl.removeAll();
				btnPnl.setLayout(new GridLayout(3,1,10,10));
				header.setText("CHOOSE DIFFICULTY - org.deneme.organdoku.screen.DKA");
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
				

				Mode dka_easy = new DontKillAnybody();
				dka_easy.setDiff(0);
				GameScreen screen = new GameScreen(dka_easy,user);
				dispose();
				
			}
		});
		dkaMedium.addActionListener(new ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent e) {
	
				Mode dka_medium = new DontKillAnybody();
				dka_medium.setDiff(1);
				GameScreen screen = new GameScreen(dka_medium,user);
				
				dispose();
				
			}
		});
		dkaHard.addActionListener(new ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent e) {
				Mode dka_hard = new DontKillAnybody();
				dka_hard.setDiff(2);
				GameScreen screen = new GameScreen(dka_hard,user);
				dispose();

			}
		});

		setSize(800,500);
		setUndecorated(true);	
		setLocationRelativeTo(null);
		setVisible(true);
	}


}

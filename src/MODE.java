import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
public abstract class MODE {
		private Score score=new Score() ;
		private byte area [][] = new byte [9][9];
		public boolean mask[][]= new boolean [9][9];
		
		public MODE(){

		}
		
		public Score getScore() {
			return score;
		}
		public void setScoretoZero(){ // sets the score to zero, because the user might want to play again!
			this.score.setscore(0);
		}
		
		public byte[][] getArea() { // getter and setter methods for point actions
			return area;
		}
		public void setArea(byte[][] area) {
			this.area = area;
		}
		public int getscore() {
			return score.getscore();
		}
		public boolean[][] getMask() {
			return mask;
		}

		public void setMask(boolean[][] mask) {
			this.mask = mask;
		}
		 abstract void setDiff(int check);

		public void EndScreen(JPanel score,JPanel timelabel,JPanel mistakeLabel,USER user){ // displays the end screen
			JFrame frame = new JFrame();
			frame.setLayout(new BorderLayout());
			JPanel northpnl= new JPanel(new FlowLayout());
			JLabel lbl= new JLabel("YOU DID IT");
			JPanel mainpanel= new JPanel(new GridLayout(3, 1));
			JPanel leftpanel= new JPanel();

			JPanel rightpanel=new JPanel();

			JPanel southpanel= new JPanel(new FlowLayout());
			JLabel againlbl= new JLabel("Do you want to play again?");
			JButton yes = new JButton("Yes");
			JButton no = new JButton("No");
			northpnl.add(lbl);
			southpanel.add(againlbl);
			southpanel.add(yes);
			southpanel.add(no);
			mainpanel.add(score);
			mainpanel.add(timelabel);
			mainpanel.add(mistakeLabel);
			frame.add(northpnl,BorderLayout.NORTH);
			frame.add(mainpanel, BorderLayout.CENTER);
			frame.add(southpanel, BorderLayout.SOUTH);
			frame.setSize(500, 500);
			frame.setLocationRelativeTo(null);
			frame.setUndecorated(true);
			frame.setVisible(true);
			yes.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					Mode_SelectScreen select= new Mode_SelectScreen(user);
					setScoretoZero();
					frame.dispose();
				}
			});
			no.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
						System.exit(0);
					
				}
			});
		}
		protected void FailScreen(JLabel disp,String name,double puan,USER user){
			JFrame failed = new JFrame("You screwed up...");
			JLabel screwLbl = new JLabel("You screwed up, "+name);
			screwLbl.setFont(new Font("Bodoni MT Black",32,32));
			
			ImageIcon failedIcon = new ImageIcon("src/screwup.jpg"); //!!!!
			
			JLabel failedLbl = new JLabel();
			
			
			failedLbl.setIcon(failedIcon);
			JLabel point = new JLabel("Point : "+ puan);
			point.setFont(new Font("Bodoni MT Black",32,32));
			JLabel time = new JLabel("Your time : "+disp.getText());
			time.setFont(new Font("Bodoni MT Black",32,32));
			
			JPanel againPnl = new JPanel();
			JLabel againLbl = new JLabel("Do you want to play again?");
			againLbl.setFont(new Font("Bodoni MT Black",30,30));
			JButton OK = new JButton("OK");
			JButton cancel = new JButton("Cancel");
			againPnl.add(againLbl);
			againPnl.add(OK);
			againPnl.add(cancel);
			
			OK.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					Mode_SelectScreen scrn = new Mode_SelectScreen(user);
					setScoretoZero();
					failed.dispose();
					
				}
			});
			cancel.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					System.exit(1);
				}
			});
			
			JPanel failPnl = new JPanel();
			failPnl.setLayout(new GridLayout(4,1));
			failPnl.add(screwLbl);
			failPnl.add(point);
			failPnl.add(time);
			failPnl.add(againPnl);
			
			failed.setLayout(new BorderLayout());

			failed.add(failedLbl,BorderLayout.NORTH);
			
			failed.add(failPnl,BorderLayout.CENTER);
			failed.setSize(450, 800);
			failed.setLocationRelativeTo(null);
			failed.setUndecorated(true);
			failed.setVisible(true);
			
		}
}
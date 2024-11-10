import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JToggleButton;

/*	This class is the backbone of the program, which means majority of the program is settled here.
	
*/

public class Game_SCREEN extends JFrame implements DESIGN{
	private String [] iconpaths={"src/Heart.jpg","src/Blood.png","src/Colon.png","src/Cornea.png",// paths for icon
			"src/Kidney.png","src/Liver.png","src/Lung.png","src/Marrow.jpg","src/this_man.jpg"};
	private ImageIcon icon;
	private byte pointer_val; // pointer value for writing and checking functions
	private int organsToPut = 0; 
	JPanel mainpanel = new JPanel(new BorderLayout()); //panels,labels and buttons
	JPanel gamepanel = new JPanel(new GridLayout(3,3));
	JPanel gamehouse1 = new JPanel(new GridLayout(3,3,5,5));
	JPanel gamehouse2 = new JPanel(new GridLayout(3,3,5,5));
	JPanel gamehouse3 = new JPanel(new GridLayout(3,3,5,5));
	JPanel gamehouse4= new JPanel(new GridLayout(3,3,5,5));
	JPanel gamehouse5 = new JPanel(new GridLayout(3,3,5,5));
	JPanel gamehouse6 = new JPanel(new GridLayout(3,3,5,5));
	JPanel gamehouse7= new JPanel(new GridLayout(3,3,5,5));
	JPanel gamehouse8= new JPanel(new GridLayout(3,3,5,5));
	JPanel gamehouse9= new JPanel(new GridLayout(3,3,5,5));
	
	JPanel eastpnl = new JPanel(new BorderLayout());
	JPanel upperpnl = new JPanel();
	JPanel actionpanel = new JPanel(new GridLayout(5, 1,0,0));
	
	JPanel selectbuttonpanel= new JPanel(new GridLayout(3, 3,5,5));
	JPanel timepanel= new JPanel();
	JLabel timelabel= new JLabel("Time Elapsed :");
	TimeCounter timeCount = new TimeCounter();///////////////////////////////////////////////adding timer to label time
	JPanel remaningspanel= new JPanel();
	JLabel remaninglabel=new JLabel("Organs to Put :");
	JLabel remaning= new JLabel();/////////////////////////////////////////remaining number
	JLabel mistakeLabel = new JLabel("Mistakes :");
	JPanel mistakepanel= new JPanel();
	JLabel mistake= new JLabel("0");
	private int mistakes=0;
	JPanel scorepanel= new JPanel();
	JLabel scorelabel= new JLabel("Score :");
	JLabel score= new JLabel("0");
	JPanel duzpanel = new JPanel();
	JScrollBar bar = new JScrollBar();
	/////////////////ORGAN SELECTION BUTTONS//////////////////////////////
	ButtonGroup organ_group = new ButtonGroup();
	Toggle_Writer heart = new Toggle_Writer(0);
	Toggle_Writer blood = new Toggle_Writer(1);
	Toggle_Writer colon = new Toggle_Writer(2);
	Toggle_Writer cornea = new Toggle_Writer(3);
	Toggle_Writer kidney= new Toggle_Writer(4);
	Toggle_Writer liver = new Toggle_Writer(5);
	Toggle_Writer lung = new Toggle_Writer(6);
	Toggle_Writer marrow = new Toggle_Writer(7);
	Toggle_Writer he = new Toggle_Writer(8);
///////////////////////////////////////////////////////////////////////
	MODE level; //this class involves a MODE variable
	USER user;
	JFrame endFrame = new JFrame();
	JButton endButton = new JButton("GIVE UP");
///////////////////////////////////////////////////////////////////////
	public Game_SCREEN(MODE lvl,USER user) {
		level = lvl;
		level.setScoretoZero();
		System.out.println(lvl.getscore());
		this.user = user;
		timeCount.clock.start();
		add(bar);
		setorganselectionbuttons();
		design();
		//setSize(540, 540);
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		setUndecorated(true);
		setLocationRelativeTo(null);
		
		setVisible(true);
		
	}
	private void setorganselectionbuttons() {
		organ_group.add(blood);
		organ_group.add(heart);
		organ_group.add(colon);
		organ_group.add(cornea);
		organ_group.add(kidney);
		organ_group.add(liver);
		organ_group.add(lung);
		organ_group.add(marrow);
		organ_group.add( he);
		
		selectbuttonpanel.add(blood);
		selectbuttonpanel.add(heart);
		selectbuttonpanel.add(colon);
		selectbuttonpanel.add(cornea);
		selectbuttonpanel.add(kidney);
		selectbuttonpanel.add(liver);
		selectbuttonpanel.add(lung);
		selectbuttonpanel.add(marrow);
		selectbuttonpanel.add(he);
	}@Override
	public void design() {
		
		gamearadesign(level);
		
		timelabel.setFont(fnt); // "fnt" constant comes from DESIGN interface
		remaninglabel.setFont(fnt);
		remaning.setFont(fnt);
		mistakeLabel.setFont(fnt);
		mistake.setFont(fnt);
		scorelabel.setFont(fnt);
		score.setFont(fnt);
		
		
		add(mainpanel);
		mainpanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		gamepanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5, false));
		gamehouse1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3, false));
		gamehouse2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3, false));
		gamehouse3.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3, false));
		gamehouse4.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3, false));
		gamehouse5.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3, false));
		gamehouse6.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3, false));
		gamehouse7.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3, false));
		gamehouse8.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3, false));
		gamehouse9.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3, false));
		
		mainpanel.add(gamepanel, BorderLayout.CENTER);
		selectbuttonpanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		upperpnl.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		upperpnl.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5, false));
		upperpnl.add(selectbuttonpanel);
		eastpnl.add(upperpnl, BorderLayout.NORTH);
		eastpnl.add(actionpanel, BorderLayout.CENTER);
		mainpanel.add(eastpnl, BorderLayout.EAST);
		
		
	
		timepanel.add(timelabel);
		timepanel.add(timeCount);
		
		actionpanel.add(timepanel);
		remaningspanel.add(remaninglabel);
		remaningspanel.add(remaning);
		actionpanel.add(remaningspanel);
		
		if(user.getGender()){ // sets the background color with respect to gender choice
			actionpanel.setBackground(Color.CYAN);
			remaningspanel.setBackground(Color.CYAN);
			timepanel.setBackground(Color.CYAN);
			mistakepanel.setBackground(Color.CYAN);
			scorepanel.setBackground(Color.CYAN);
			duzpanel.setBackground(Color.CYAN);
			gamepanel.setBackground(Color.CYAN);

		}else{
			actionpanel.setBackground(Color.PINK);
			remaningspanel.setBackground(Color.PINK);
			timepanel.setBackground(Color.PINK);
			mistakepanel.setBackground(Color.PINK);
			scorepanel.setBackground(Color.PINK);
			duzpanel.setBackground(Color.PINK);
			gamepanel.setBackground(Color.PINK);
		}
		actionpanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5, false));
		scorepanel.add(scorelabel);
		scorepanel.add(score);
		
		actionpanel.add(scorepanel);
		
		if(level instanceof Normal){ // if user chooses Normal mode, we add a panel in order to count mistakes
			mistakepanel.add(mistakeLabel);
			mistakepanel.add(mistake);
			actionpanel.add(mistakepanel);
		}
		else{
			actionpanel.add(duzpanel);
		}
		endButton.addActionListener(new ActionListener() { // Action Listener declarations and creations	
			@Override
			public void actionPerformed(ActionEvent e) {
				level.FailScreen(timeCount.getDisplay(),user.getName(),level.getScore().getscore(),user);
				level.setScoretoZero();
				dispose();
			}
		});
		actionpanel.add(endButton);
	}
	private void gamearadesign(MODE lvl){ // game area design ( 9x9 section ) with buttons
		this.level = lvl;
		gamepanel.add(gamehouse1);
		gamepanel.add(gamehouse2);
		gamepanel.add(gamehouse3);
		gamepanel.add(gamehouse4);
		gamepanel.add(gamehouse5);
		gamepanel.add(gamehouse6);
		gamepanel.add(gamehouse7);
		gamepanel.add(gamehouse8);
		gamepanel.add(gamehouse9);
		for (int i = 0; i <9; i++) {
			for (int j = 0; j < 9; j++) {
				housecontrol(i+1,j+1,true);
				if(level.getMask()[i][j] == true){
					organsToPut++;
				}
			}
		}remaning.setText(organsToPut+"");
	}
	public void housecontrol(int line,int column,boolean mode){ // Mode==false:game area design----Mode==true:3x3 bonus point controller method
		if(line>=1&&line<=3&&column>=1&&column<=3){
			int a=0;
			if(mode){
				Item_AREA area = new Item_AREA( level.getArea()[line-1][column-1]-1, level.getMask()[line-1][column-1],line-1,column-1);
				gamehouse1.add(area);
			}else{
			for(int l=1;l<=3;l++){
				for(int c=1;c<=3;c++){
					if(level.getMask()[l-1][c-1]==false){
						a++;
					}
				}
			}
			}
			if(a==9){
				level.getScore().housescore();
			}
		}
		if(line>=4&&line<=6&&column>=1&&column<=3){
			int a=0;
			if(mode){
				Item_AREA area = new Item_AREA( level.getArea()[line-1][column-1]-1, level.getMask()[line-1][column-1],line-1,column-1);
				gamehouse2.add(area);
			}else{
			for(int l=4;l<=6;l++){
				for(int c=1;c<=3;c++){
					if(level.getMask()[l-1][c-1]==false){
						a++;
					}
				}
			}
			}
			if(a==9){
				level.getScore().housescore();
			}
		}if(line>=7&&line<=9&&column>=1&&column<=3){
			int a=0;
			if(mode){
				Item_AREA area = new Item_AREA( level.getArea()[line-1][column-1]-1, level.getMask()[line-1][column-1],line-1,column-1);
				gamehouse3.add(area);
			}else{
			for(int l=7;l<=9;l++){
				for(int c=1;c<=3;c++){
					if(level.getMask()[l-1][c-1]==false){
						a++;
					}
				}
			}
			}
			if(a==9){
				level.getScore().housescore();
			}
		}if(line>=1&&line<=3&&column>=4&&column<=6){
			int a=0;
			if(mode){
				Item_AREA area = new Item_AREA( level.getArea()[line-1][column-1]-1, level.getMask()[line-1][column-1],line-1,column-1);
				gamehouse4.add(area);
			}else{
			for(int l=4;l<=6;l++){
				for(int c=1;c<=3;c++){
					if(level.getMask()[l-1][c-1]==false){
						a++;
					}
				}
			}
			}
			if(a==9){
				level.getScore().housescore();
			}
		}if(line>=4&&line<=6&&column>=4&&column<=6){
			int a=0;
			if(mode){
				Item_AREA area = new Item_AREA( level.getArea()[line-1][column-1]-1, level.getMask()[line-1][column-1],line-1,column-1);
				gamehouse5.add(area);
			}else{
			for(int l=4;l<=6;l++){
				for(int c=4;c<=6;c++){
					if(level.getMask()[l-1][c-1]==false){
						a++;
					}
				}
			}
			}
			if(a==9){
				level.getScore().housescore();
			}
		}if(line>=7&&line<=9&&column>=4&&column<=6){
			int a=0;
			if(mode){
				Item_AREA area = new Item_AREA( level.getArea()[line-1][column-1]-1, level.getMask()[line-1][column-1],line-1,column-1);
				gamehouse6.add(area);
			}else{
			for(int l=4;l<=6;l++){
				for(int c=7;c<=9;c++){
					if(level.getMask()[l-1][c-1]==false){
						a++;
					}
				}
			}
			}
			if(a==9){
				level.getScore().housescore();
			}
		}
		if(line>=1&&line<=3&&column>=7&&column<=9){
			int a=0;
			if(mode){
				Item_AREA area = new Item_AREA( level.getArea()[line-1][column-1]-1, level.getMask()[line-1][column-1],line-1,column-1);
				gamehouse7.add(area);
			}else{
			for(int l=1;l<=3;l++){
				for(int c=7;c<=9;c++){
					if(level.getMask()[l-1][c-1]==false){
						a++;
					}
				}
			}
			}
			if(a==9){
				level.getScore().housescore();
			}
		}if(line>=4&&line<=6&&column>=7&&column<=9){
			int a=0;
			if(mode){
				Item_AREA area = new Item_AREA( level.getArea()[line-1][column-1]-1, level.getMask()[line-1][column-1],line-1,column-1);
				gamehouse8.add(area);
			}else{
			for(int l=4;l<=6;l++){
				for(int c=7;c<=9;c++){
					if(level.getMask()[l-1][c-1]==false){
						a++;
					}
				}
			}
			}
			if(a==9){
				level.getScore().housescore();
			}
		}
		if(line>=7&&line<=9&&column>=7&&column<=9){
			int a=0;
			if(mode){
				Item_AREA area = new Item_AREA( level.getArea()[line-1][column-1]-1, level.getMask()[line-1][column-1],line-1,column-1);
				gamehouse9.add(area);
			}else{
			for(int l=7;l<=9;l++){
				for(int c=7;c<=9;c++){
					if(level.getMask()[l-1][c-1]==false){
						a++;
					}
				}
			}
			}
			if(a==9){
				level.getScore().housescore();
			}
		}
	}
	public void controlnum(int line,int column){ // score control and equalization
				level.getMask()[line][column]=false;
				System.out.println(line+""+column);
				housecontrol(line+1, column+1,false);
			   level.getScore().oneboxscore();
			   int a=0;
			   for(int i=0;i<9;i++){
				   if(level.getMask()[line][i]==false){
					   a++;
				   }
				   if(level.getMask()[line][i]==false&&a==9){
					   level.getScore().rowscore();
				   }
			   }
			   int b=0;
			   for(int i1=0;i1<9;i1++){
				   if(level.getMask()[i1][column]==false){
					   b++;
				   }
				   if(level.getMask()[i1][column]==false&&b==9){
					   level.getScore().columbscore();
				   }
			   }
			}		
	
	class Item_AREA extends JButton{ // this is the inner class for buttons in the game area ( 9x9 section )
		private byte actual_val;	// , which ease us to manage points
		private boolean iconvisibility=false;
		
		public Item_AREA(int index , boolean visibility,int i,int j) {
			ImageIcon image=new ImageIcon(iconpaths[index]);
			actual_val=(byte)index;
			icon=image;
			iconvisibility=visibility;
			if(!visibility){
				setIcon(icon);
				setEnabled(false);
			}
			
			addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(level.getScore().getscore()<-40){ // when it reaches -50, you will lose.
						timeCount.clock.stop(); 
						level.getScore().setscore(-5); // this is for displaying -50 to the user
						level.FailScreen(timeCount.getDisplay(),user.getName(),level.getScore().getscore(),user);
						dispose();
					}
					if(actual_val==pointer_val-1){ // controls whether the answer is correct or not
					ImageIcon image1=new ImageIcon(iconpaths[pointer_val-1]);	
					setIcon(image1);
					setEnabled(false);
					organsToPut--; // decreases the organs to put number to control the end of the game
					remaning.setText(organsToPut+"");
					controlnum(i, j);
					score.setText(level.getScore().getscore()+"");
					
					if(organsToPut == 0){ // If the game is completed, the final screens are about to be displayed.

						timeCount.clock.stop();//stops the clock
						dispose();
						if(level instanceof Normal){
							
							((Normal) level).EndScreen(scorepanel,timepanel,mistakepanel,user);
							dispose();
						
						}
						else if(level instanceof DKA){
							((DKA) level).EndScreen(scorepanel,timepanel,mistakepanel,user);
							dispose();
						}
					}
					
					}
					else{
						if(level instanceof DKA){ //this is the fail screen setup for DKA, because one mistake stops the game
							timeCount.clock.stop();
							dispose();
							((DKA) level).FailScreen(timeCount.getDisplay(),user.getName(),level.getScore().getscore(),user);//dka method gelecek
						}
						else{//
						level.getScore().wrongscore();
						score.setText(level.getScore().getscore()+"");
						mistakes++;
						mistake.setText(mistakes+"");
						}
					}
						
				}
			});
		}}
	class Toggle_Writer extends JToggleButton{ // selector buttons on the right top of the screen
		public Toggle_Writer(int index) {
			ImageIcon image=new ImageIcon(iconpaths[index]);
			icon=image;
			this.setIcon(icon);
	
			setBackground(Color.BLACK);
			addActionListener(new ActionListener() {
					
				@Override
				public void actionPerformed(ActionEvent e) {	
					pointer_val= (byte)(index+1);
				}
			});
		}
	}
	
}


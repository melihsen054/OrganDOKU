
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Normal extends MODE { // keeps the database and uses extended methods from MODE
	private byte[][] areaNormal;
	private boolean[][] masksNormal;
	
	public Normal(){
		
	}
	
	public void setDiff(int check){
		 
		if(check==0){
		byte init[][] = {
		{6,1,2,5,8,3,7,4,9},
		{5,9,7,4,2,6,1,3,8},
		{4,3,8,9,7,1,5,2,6},
		{2,6,1,8,3,5,9,7,4},
		{3,4,9,1,6,7,2,8,5},
		{8,7,5,2,9,4,3,6,1},
		{7,5,6,3,1,8,4,9,2},
		{1,2,3,6,4,9,8,5,7},
		{9,8,4,7,5,2,6,1,3}};
		boolean [][] inito  =
		      {{true, true, true, true, false, true, true, true,false},
		           {true, true, true, false, false, false, false, false, true},
		           {true, true, true, false, true, false, false, true, false},
		           {false, true, true, false, false, true, false, false, false},
		           {false, true, false, true,false, true, true, false, true},
		           {true, true, true, false, false, false, true, true, true},
		           {true, false, false, false, false, true, true, true , true},
		           {true, true, true, true, true, true, false, true, false},
		           {true, false, false, true, false, false, true, false, true}};
		 
		areaNormal=init;
		masksNormal=inito;
		setArea(areaNormal);
		setMask(masksNormal);
		}else if(check==1){
		byte init[][] = {
		{8,2,3,5,1,9,7,4,6},
		{4,5,9,7,3,6,2,1,8},
		{1,6,7,2,8,4,9,3,5},
		{6,8,5,9,2,3,1,7,4},
		{3,1,4,6,7,5,8,9,2},
		{9,7,2,1,4,8,5,6,3},
		{7,4,1,8,6,2,3,5,9},
		{2,9,6,3,5,1,4,8,7},
		{5,3,8,4,9,7,6,2,1}};
		boolean [][] inito  =
		      {{true, false, true, false, false, false, true,true,true},
		           {true, false, true, false,true, true, true, false, true},
		           {true, false, true, false, true, true, false, true, true},
		           {false, false, false, true, false, false, true, true, true},
		           {true, true, true, true,true, true, false, true, false},
		           {true, false, true, false, false, true, true, true, true},
		           {false, true, false, true, true, true, true, false , false},
		           {true, true, true, true, true,false, true, true, false},
		           {true, false, true, false, false, true, true, false, false}};
		 
		areaNormal=init;
		masksNormal=inito;
		setArea(areaNormal);
		setMask(masksNormal);
		}else if(check ==2) {
		byte init[][] = {
		{2,4,3,8,7,6,9,5,1},
		{9,5,1,2,4,3,8,6,7},
		{8,7,6,1,9,5,2,4,3},
		{3,9,4,5,2,8,1,7,6},
		{1,6,2,4,3,7,5,8,9},
		{7,8,5,9,6,1,3,2,4},
		{6,2,9,3,8,4,7,1,5},
		{5,3,7,6,1,2,4,9,8},
		{4,1,8,7,5,9,6,3,2}};
		boolean [][] inito  =
		      {{false, true, true, true, true, true, false, false,false},
		           {true, true, true,true, true, true, true, true,false},
		           {false, false, false, true, true, false, false, true, true},
		           {false, true, false, true, false, false, true, true, true},
		           {true, true, true, true,true, true, false, true, false},
		           {true, true, false, true, true, false, false, true, false},
		           {true, false, true, true, false, false, true, false , true},
		           {true, true, true, true, false, true, true, false, false},
		           {true, true, true, true, true, true, true, true, true}};
		 
		areaNormal=init;
		masksNormal=inito;
		setArea(areaNormal);
		setMask(masksNormal);
		}
		 
		}
	@Override
	public void EndScreen(JPanel score,JPanel timelabel,JPanel mistakeLabel,USER user) {
		super.EndScreen(score,timelabel,mistakeLabel,user);
		
	}
	@Override
	protected void FailScreen(JLabel disp,String name,double puan,USER user){
		super.FailScreen(disp, name, puan, user);
		
	}


	
}
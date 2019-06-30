
import java.util.ArrayList;
import java.util.Scanner;

public class Easy extends MODE{
	private byte[][] areaNormal;
	
	private boolean[][] masksNormal;
	public Easy(){
		
		//setDiff(check);
	}
	public int easy(int x, int z){
		return areaNormal[x][z];
	}
	public void controlnum(int line,int columb, int number,String level){
		if(level.equals("easy")){
			if(number==areaNormal[line-1][columb-1]&&masksNormal[line-1][columb-1]==true){
				masksNormal[line-1][columb-1]=false;
				fillarea(masksNormal,line,columb);
			   getScore().oneboxscore();
			   int a=0;
			   for(int i=0;i<9;i++){
				   if(masksNormal[line-1][i]==false){
					   a++;
				   }
				   if(masksNormal[line-1][i]==false&&a==9){
					   getScore().rowscore();
				   }
			   }
			   int b=0;
			   for(int i=0;i<9;i++){
				   if(masksNormal[i][columb-1]==false){
					   b++;
				   }
				   if(masksNormal[i][columb-1]==false&&b==9){
					   getScore().columbscore();
				   }
			   }
			}
			else if(number!=areaNormal[line-1][columb-1]){
				System.out.println("Wrong choice\n");
				getScore().wrongscore();
			}
			else{
			   System.out.println("Wrong choice");
			   
			}
		}
	}
	public void fillarea(boolean [][] rowandcolumn,int line,int column){
		int m=0;
		int f=0;
		for(int i=0;i<9;i++){
			if(i<3){
				m=0;
			}
			if(i>=3&&i<6){
				m=3;
			}if(i>=6&&i<9){
				m=6;
			}
			int n=0;
			if(i==0||i==3||i==6){
				n=0;
			}
			if(i==1||i==4||i==7){
				n=3;
			}if(i==2||i==5||i==8){
				n=6;
			}
				for(int k=0;k<9;k++){
					if(k<3){
						getMask()[i][k]=rowandcolumn[m][n];
						if(m==line-1&&n==column-1){
							f=i;
						}
						n++;
						
					}
					if(k>=3&&k<6){
						getMask()[i][k]=rowandcolumn[m+1][n-3];
						if(m+1==line-1&&n-3==column-1){
							f=i;
						}
						n++;
					}
					if(k>=6&&k<9){
						getMask()[i][k]=rowandcolumn[m+2][n-6];
						if(m+2==line-1&&n-6==column-1){
							f=i;
						}
						n++;
					}
			}m++;
		}
		int a=0;
		   for(int i=0;i<9;i++){
			   if(getMask()[f][i]==false){
				   a++;
			   }
			   if(getMask()[f][i]==false&&a==9){
				   getScore().housescore();
			   }
		   }
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
		boolean [][]	inito  =
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
	//		areaNormal = 
		}else if(check ==2) {
		//	areaNormal = 
		}
		
	}

	
}
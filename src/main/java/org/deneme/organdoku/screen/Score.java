package org.deneme.organdoku.screen;

public class Score { // for the score CALCULATIONS
	private int score=0;
	public Score(){
		
	}
	public void setscore(int score){
		this.score= this.score+score;
	}
	public  int getscore(){
		return this.score;
	}
	public void rowscore(){
		this.score=this.score+15;
	}
	public void columbscore(){
		this.score=this.score+15;
	}
	public void housescore(){
		this.score=this.score+20;
	}
	public void wrongscore(){
		this.score=this.score-5;
	}
	public void oneboxscore() {
		this.score=this.score+5;
	}
}

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/* OOP PROJECT 1 : ORGANDOKU

	Batuhan YILMAZ 150715001
	Ali Mertcan KARAMAN 150716074
	Melih SEN 150714004

This ORGANDOKU program brings a brain teaser to you!

ORGANDOKU has two different game modes: GENERIC ORGANDOKU and DKA (DON'T KILL ANYBODY)

ORGANDOKU mode is very similar to generic sudoku structure, with some twist. For every completed 3x3 section,
(which are represented as PATIENTS),row and column, you will gain BONUS points:

3x3 SECTION = + 20 PTS
ROW & COLUMN = + 15 PTS

On the contrary, you will be penalized for every MISTAKE you will perform.

MISTAKE = - 5 PTS

If your score drops below - 50, YOU WILL SCREW UP!

DKA (DON'T KILL ANYBODY) mode is a crueler mode, which doesn't let you kill a PATIENT! Which means, YOU CAN'T MAKE ANY MISTAKE!

Point regulation is the same for both modes.

ORGANDOKU provides a good-looking, sleek user interface and easy playability.

*/

public class ORGANDOKU_MAIN {

	public static void main(String[] args) throws FileNotFoundException, IOException{
		//Mode_SelectScreen selectScreen = new Mode_SelectScreen();
		String welcome = "This ORGANDOKU program brings a brain teaser to you!\n"+
"ORGANDOKU has two different game modes: GENERIC ORGANDOKU and DKA (DON'T KILL ANYBODY)\n"+
"ORGANDOKU mode is very similar to generic sudoku structure, with some twist. For every completed 3x3 section,\n"+
"(which are represented as PATIENTS),row and column, you will gain BONUS points:\n"+
"3x3 SECTION = + 20 PTS\n"+
"ROW & COLUMN = + 15 PTS\n"+
"On the contrary, you will be penalized for every MISTAKE you will perform.\n"+
"MISTAKE = - 5 PTS\n"+
"If your score drops below - 50, YOU WILL SCREW UP!\n"+
"DKA (DON'T KILL ANYBODY) mode is a crueler mode, which doesn't let you kill a PATIENT! \nWhich means, YOU CAN'T MAKE ANY MISTAKE!\n"+
"Point regulation is the same for both modes.\n"+
"ORGANDOKU provides a good-looking, sleek user interface and easy playability.";
		
		JOptionPane.showMessageDialog(new JFrame(), welcome);
		Intro_SCREEN frame= new Intro_SCREEN();

	}

}

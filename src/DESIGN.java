import java.awt.Font;
import java.io.FileNotFoundException;
import java.io.IOException;

public interface DESIGN {// design interface for screens
	
	Font fnt = new Font("Bodoni MT Black",30, 30); // constant variable for unary font design
	
	public abstract void design() throws FileNotFoundException, IOException;
}

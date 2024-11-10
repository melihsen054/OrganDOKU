package org.deneme.organdoku.screen;

import java.awt.Font;
import java.io.FileNotFoundException;
import java.io.IOException;

public interface Design {// design interface for screens
	
	Font fnt = new Font("Bodoni MT Black",30, 30); // constant variable for unary font design
	
	public abstract void design() throws FileNotFoundException, IOException;
}

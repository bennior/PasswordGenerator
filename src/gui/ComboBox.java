package gui;

import javax.swing.JComboBox;

public class ComboBox extends JComboBox{
	
	public static ComboBox INSTANCE = new ComboBox();
	
	public ComboBox() {
		for(int i = 0; i <= 15; i++) {
			addItem(i + 1);
		}
	}
}


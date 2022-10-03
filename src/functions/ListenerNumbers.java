package functions;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;

import gui.CheckBoxNumbers;

public class ListenerNumbers implements ItemListener{

	public static boolean numbercheck = false;
	//public static ListenerNumbers n = new ListenerNumbers();

	@Override
	public void itemStateChanged(ItemEvent e) {
		boolean letters = ListenerLetters.lettercheck;
		boolean symbols = ListenerSymbols.symbolscheck;
		
		if(e.getStateChange()==ItemEvent.SELECTED) {
			numbercheck = true;
		}
		else {
			numbercheck = false;
		}	
		if(e.getStateChange() == ItemEvent.DESELECTED && letters == false && symbols == false) {
			((JCheckBox) e.getItem()).setSelected(true);
		}
	}
}

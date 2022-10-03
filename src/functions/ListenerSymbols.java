package functions;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;

import gui.CheckBoxSymbols;

public class ListenerSymbols implements ItemListener{

	public static boolean symbolscheck = false;
	//public static ListenerSymbols s = new ListenerSymbols();
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		boolean numbers = ListenerNumbers.numbercheck;
		boolean letters = ListenerLetters.lettercheck;
		
		if(e.getStateChange()==ItemEvent.SELECTED) {
			symbolscheck = true;
		}
		else {
				symbolscheck = false;
		}		
		if(e.getStateChange() == ItemEvent.DESELECTED && letters == false && numbers == false) {
			((JCheckBox) e.getItem()).setSelected(true);
		}
	}
}

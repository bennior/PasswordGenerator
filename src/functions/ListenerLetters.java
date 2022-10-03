package functions;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;

import gui.CheckBoxLetters;

public class ListenerLetters implements ItemListener{

	public static boolean lettercheck = true;
	//public static ListenerLetters l = new ListenersLetters();

	@Override
	public void itemStateChanged(ItemEvent e) {
		boolean numbers = ListenerNumbers.numbercheck;
		boolean symbols = ListenerSymbols.symbolscheck;
		
		if(e.getStateChange()==ItemEvent.SELECTED) {
			lettercheck = true;
		}
		else {
			lettercheck = false;
		}	
		if(e.getStateChange() == ItemEvent.DESELECTED && numbers == false && symbols == false) {
			((JCheckBox) e.getItem()).setSelected(true);
		}
	}
}


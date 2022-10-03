package functions;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;

import gui.ComboBox;

public class LengthHandler implements ItemListener{
	
		public static int length = 1;
		//public static LengthHandler lh = new LengthHandler();
		
		@Override
		public void itemStateChanged(ItemEvent event) {
			if(event.getStateChange()==ItemEvent.SELECTED) {
				length = ((JComboBox) event.getSource()).getSelectedIndex() + 1;
			}
		}

	}


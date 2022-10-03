package functions;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;

public class CopyHandler implements ActionListener{

	JTextArea jta;
	
	public CopyHandler(JTextArea jta) {
		this.jta = jta;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		StringSelection stringSelection = new StringSelection(jta.getText());
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, null);
	}

}

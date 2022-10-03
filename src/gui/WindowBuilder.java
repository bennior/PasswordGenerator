package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JFrame;
import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import javax.swing.LayoutStyle.ComponentPlacement;

import functions.CopyHandler;
import functions.Generation;
import functions.LengthHandler;
import functions.ListenerLetters;
import functions.ListenerNumbers;
import functions.ListenerSymbols;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;

public class WindowBuilder {

	JFrame frame;

	
	//Create the application.
	 
	public WindowBuilder() {
		initialize();
	}

	//Initialize the contents of the frame
	private void initialize() {
		//JFrame
		Font fontbutton = new Font("Courier New", Font.PLAIN, 20);
		Font fonttextarea = new Font("Courier New", Font.PLAIN, 35);
		Font fontlabel = new Font("Courier New", Font.BOLD, 30);
		Font fontlabel1 = new Font("Courier New", Font.BOLD, 20);
		Image image = new ImageIcon(this.getClass().getResource("padlock.png")).getImage();
		ImageIcon img = new ImageIcon(image);
		
		frame = new JFrame("Password Generator");
		frame.setBounds(0, 0, 617, 375);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setIconImage(img.getImage());
		frame.getContentPane().setBackground(Color.GRAY);
		frame.setVisible(true);
		//JTextArea
		JTextArea textArea = new JTextArea("");
		textArea.setFont(fonttextarea);
		textArea.setEditable(false);
		textArea.setRows(1);
		textArea.setColumns(16);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		//JCheckBoxes
		JCheckBox chckbxNewCheckBox = new CheckBoxLetters();
		chckbxNewCheckBox.addItemListener(new ListenerLetters());
		chckbxNewCheckBox.setOpaque(false);
		JCheckBox chckbxNewCheckBox_1 = new CheckBoxNumbers();
		chckbxNewCheckBox_1.addItemListener(new ListenerNumbers());
		chckbxNewCheckBox_1.setOpaque(false);
		JCheckBox chckbxNewCheckBox_2 = new CheckBoxSymbols();
		chckbxNewCheckBox_2.addItemListener(new ListenerSymbols());
		chckbxNewCheckBox_2.setOpaque(false);
		//JComboBox
		JComboBox comboBox = ComboBox.INSTANCE;
		//JComboBox comboBox = new JComboBox();
		comboBox.addItemListener(new LengthHandler());
		//JLabel
		JLabel lblNewLabel = new JLabel("Password:");
		lblNewLabel.setFont(fontlabel);
		//Jlabel Text time
		JLabel lblNewLabel_1 = new JLabel("Time to crack the password:");
		lblNewLabel_1.setFont(fontlabel1);
		//JLabel estimated time
		JLabel lblNewLabel_2 = new JLabel();
		lblNewLabel_2.setFont(fontbutton);
		//JButton
		JButton btnNewButton = new JButton("Generate");
		btnNewButton.setFont(fontbutton);
		btnNewButton.addActionListener(new Generation(textArea, lblNewLabel_2));
		JButton btnNewButton_1 = new JButton("Copy");
		btnNewButton_1.addActionListener(new CopyHandler(textArea));
		btnNewButton_1.setFont(fontbutton);		
		
		//GroupLayout
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(72)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(chckbxNewCheckBox, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(chckbxNewCheckBox_1, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(chckbxNewCheckBox_2, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
								.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 354, GroupLayout.PREFERRED_SIZE))
							.addGap(22)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton)))
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 336, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 367, GroupLayout.PREFERRED_SIZE))
					.addGap(26))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(42)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
						.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(chckbxNewCheckBox, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
							.addComponent(chckbxNewCheckBox_1, GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
							.addComponent(chckbxNewCheckBox_2, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addGap(35))
		);
		//Add to JFrame
		frame.getContentPane().setLayout(groupLayout);
	}
}

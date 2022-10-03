package functions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Locale;
import java.util.Random;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import gui.CheckBoxLetters;
import gui.ComboBox;
import me.gosimple.nbvcxz.Nbvcxz;
import me.gosimple.nbvcxz.resources.Configuration;
import me.gosimple.nbvcxz.resources.ConfigurationBuilder;
import me.gosimple.nbvcxz.scoring.Result;
import me.gosimple.nbvcxz.scoring.TimeEstimate;


public class Generation implements ActionListener{
	String[] chosefrom = {
			"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", //20
			"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", //26
			"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", //26
			"!", "@", "#", "$", "%", "&", "?", "-", "_", "§", "/", "*", "~", ".", ";", ",", "(", ")", "{", "}", "[", "]", "<", ">" //24
			};
	
	//public static ListenerLetters l = new ListenerLetters();
	//public static ListenerNumbers n = new ListenerNumbers();
	//public static ListenerSymbols s = new ListenerSymbols();
	//public static LengthHandler lh = new LengthHandler();
	JTextArea jta;
	JLabel jl;
	//public static String s;
	
	public Generation(JTextArea jta, JLabel jl) {
		this.jta = jta;
		this.jl = jl;
		}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		boolean letters = ListenerLetters.lettercheck;
		boolean numbers = ListenerNumbers.numbercheck;
		boolean symbols = ListenerSymbols.symbolscheck;
		int length = LengthHandler.length;
		try {
			Configuration configuration = new ConfigurationBuilder()
			        .setLocale(Locale.forLanguageTag(""))
			        .createConfiguration();
			Nbvcxz nbvcxz = new Nbvcxz(configuration);
			StringBuilder sb = new StringBuilder();
			String s = new String();
			//POSSIBILITY: 1                  l=true,n=false,s=false
			if(letters == true && numbers == false && symbols == false) {
				for(int t = 0; t < length; t++) {
					Random r = new Random();        
					int randomNumber = r.nextInt(52) + 20;
					sb.append(chosefrom[randomNumber]);
				}
				s = sb.toString();
				jta.setText(s);
				Result result = nbvcxz.estimate(s);
				String timeToCrackOff = TimeEstimate.getTimeToCrackFormatted(result, "OFFLINE_BCRYPT_12");
				jl.setText(timeToCrackOff);
			}
			else {
				//POSSIBILITY: 2              l=false, n=false, s=true
				if(letters == false && numbers == false && symbols == true) {
					for(int t = 0; t < length; t++) {
						Random r = new Random();        
						int randomNumber = r.nextInt(24) + 72;
						sb.append(chosefrom[randomNumber]);
					}
					s = sb.toString();
					jta.setText(s);
					Result result = nbvcxz.estimate(s);
					String timeToCrackOff = TimeEstimate.getTimeToCrackFormatted(result, "OFFLINE_BCRYPT_12");
					jl.setText(timeToCrackOff);
				}
				else {
					//POSSIBILITY: 3             l=false, n=true, s=true
					if(letters == false && numbers == true && symbols == true) {
						for(int t = 0; t < length; t++) {
							Random r = new Random();    
							int fifthy = r.nextInt(2);
							if(fifthy == 1) {
								Random r2 = new Random();
								int randomNumber = r2.nextInt(20);
								sb.append(chosefrom[randomNumber]);
							}
							else {
								Random r3 = new Random();
								int randomNumber2 = r3.nextInt(24) + 72;
								sb.append(chosefrom[randomNumber2]);
							}
						}
						s = sb.toString();
						jta.setText(s);
						Result result = nbvcxz.estimate(s);
						String timeToCrackOff = TimeEstimate.getTimeToCrackFormatted(result, "OFFLINE_BCRYPT_12");
						jl.setText(timeToCrackOff);
					}
					else {
						//POSSIBILITY: 4             l=false, n=true, s=false
						if(letters == false && numbers == true && symbols == false) {
							for(int t = 0; t < length; t++) {
								Random r = new Random();        
								int randomNumber = r.nextInt(20);
								sb.append(chosefrom[randomNumber]);
							}
							s = sb.toString();
							jta.setText(s);
							Result result = nbvcxz.estimate(s);
							String timeToCrackOff = TimeEstimate.getTimeToCrackFormatted(result, "OFFLINE_BCRYPT_12");
							jl.setText(timeToCrackOff);
						}
						else {
							//POSSIBILITY: 5             l=true, n=false, s=true
							if(letters == true && numbers == false && symbols == true) {
								for(int t = 0; t < length; t++) {
									Random r = new Random();        
									int randomNumber = r.nextInt(76) + 20;
									sb.append(chosefrom[randomNumber]);
								}
								s = sb.toString();
								jta.setText(s);
								Result result = nbvcxz.estimate(s);
								String timeToCrackOff = TimeEstimate.getTimeToCrackFormatted(result, "OFFLINE_BCRYPT_12");
								jl.setText(timeToCrackOff);
							}
							else {
								//POSSIBILITY: 6             l=true, n=true, s=false
								if(letters == true && numbers == true && symbols == false) {
									for(int t = 0; t < length; t++) {
										Random r = new Random();        
										int randomNumber = r.nextInt(72);
										sb.append(chosefrom[randomNumber]);
									}
									s = sb.toString();
									jta.setText(s);
									Result result = nbvcxz.estimate(s);
									String timeToCrackOff = TimeEstimate.getTimeToCrackFormatted(result, "OFFLINE_BCRYPT_12");
									jl.setText(timeToCrackOff);
								}
								else {
									//POSSIBILITY: 7             l=true, n=true, s=true
									if(letters == true && numbers == true && symbols == true) {
										for(int t = 0; t < length; t++) {
											Random r = new Random();        
											int randomNumber = r.nextInt(96);
											sb.append(chosefrom[randomNumber]);
										}
										s = sb.toString();
										jta.setText(s);
										Result result = nbvcxz.estimate(s);
										String timeToCrackOff = TimeEstimate.getTimeToCrackFormatted(result, "OFFLINE_BCRYPT_12");
										jl.setText(timeToCrackOff);
									}
									else {
										jta.setText("Error");
									}
								}
							}
						}
					}
				}
			}
		}
		catch(Exception error) {}
		}
}

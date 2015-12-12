import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class GUI implements ActionListener {
	private static DecimalFormat df2 = new DecimalFormat(".##");
	private AlkTest tester = new AlkTest();
	// 2 do: add GUI components
	private JLabel consumLabel = new JLabel("Konsum:");
	public JButton beerButton = new JButton("Bier"); 
	public JButton wineButton = new JButton("Wein"); 
	public JButton liquorButton = new JButton("Likör"); 
	public JButton boozeButton = new JButton("Schnaps"); 
	private JLabel bloodAlcoholValueLabel = new JLabel("Blutalkoholwert:");
	public JButton testButton = new JButton("Test"); 
	private JTextField testValueField = new JTextField(); 
	private JLabel settingsLabel = new JLabel("Einstellungen:");
	private JComboBox genderComboBox;
	private JTextField weightField = new JTextField(); 
	
	public GUI() {
		// config gender selector
		String[] genderList = {"Mann", "Frau"};
		genderComboBox = new JComboBox(genderList);
		genderComboBox.setSelectedIndex(0);
		
		Dimension d = new Dimension(90,30);
		consumLabel.setPreferredSize(d);
		beerButton.setPreferredSize(d);
		wineButton.setPreferredSize(d);
		liquorButton.setPreferredSize(d);
		boozeButton.setPreferredSize(d);
		bloodAlcoholValueLabel.setPreferredSize(d);
		testButton.setPreferredSize(d);
		testValueField.setPreferredSize(d);
		settingsLabel.setPreferredSize(d);
		genderComboBox.setPreferredSize(d);
		weightField.setPreferredSize(d);
		
		// create the panels
		JPanel consumPanel = new JPanel(new GridLayout(2,2));
		//labelPanel.add(consumLabel);
		consumPanel.add(beerButton);
		consumPanel.add(wineButton);
		consumPanel.add(liquorButton);
		consumPanel.add(boozeButton);
		JPanel testPanel = new JPanel(new FlowLayout());
		testPanel.add(testButton);
		testPanel.add(testValueField);
		JPanel settingsPanel = new JPanel(new FlowLayout());
		settingsPanel.add(genderComboBox);
		settingsPanel.add(weightField);
		JPanel panel = new JPanel(new GridLayout(6, 1)); 
		panel.add(consumLabel);
		panel.add(consumPanel);
		panel.add(bloodAlcoholValueLabel);
		panel.add(testPanel);
		panel.add(settingsLabel);
		panel.add(settingsPanel);
		
		// create the main window
		JFrame frame = new JFrame();
		frame.setContentPane(panel);
		frame.pack();
		frame.setVisible(true);
		
		beerButton.addActionListener(this);
		wineButton.addActionListener(this);
		liquorButton.addActionListener(this);
		boozeButton.addActionListener(this);
		testButton.addActionListener(this);
		
	}
	public void actionPerformed(ActionEvent e) {
		try {
			if (e.getActionCommand().equals("Bier")) {
				tester.addKonsum(0);
			}
			if (e.getActionCommand().equals("Wein")) {
				tester.addKonsum(1);
			}
			if (e.getActionCommand().equals("Likör")) {
				tester.addKonsum(2);
			}
			if (e.getActionCommand().equals("Schnaps")) {
				tester.addKonsum(3);
			}
			if (e.getActionCommand().equals("Test")) {
				boolean isFemale = false;
				if (genderComboBox.getSelectedIndex() == 0) {
					isFemale = false;
				}
				else {
					isFemale = true;
				}
				tester.setPerson(Double.parseDouble(weightField.getText()), isFemale);
				double currentLevel = tester.getCurrentLevel();
				testValueField.setText(String.valueOf(df2.format(currentLevel)));
				if (currentLevel > 3) {
					JOptionPane.showMessageDialog(null, "Äääähm du hast über 3 Promille und solltest schon tot sein.");
				}
			}
		} catch (Exception ex) {
		}
	}
	public static void main(String[] args) {
		GUI gui = new GUI();
	}
}
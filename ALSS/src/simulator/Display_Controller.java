package simulator;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.JTextPane;
import javax.swing.JTable;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JSlider;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Display_Controller extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField speedPilot;
	private JTextField altitudePilot;
	private JTextField landtimePilot;
	private JTextField copilotSpeed;
	private JTextField copilotAltitude;
	private JTextField copilotLandtime;
	private JTextField copilotGear;
	private JTextField gearPilot;

	public Display_Controller(Inputs display) {
		setTitle("Aircraft Landing Simulation System");
		
		Font font1 = new Font("SansSerif", Font.BOLD, 20);
		Font font2 = new Font("SansSerif", Font.BOLD, 15);
		Color red = new Color(229,45,45);
		Color yellow = new Color(255,255,76);
		Color grey = new Color(70,70,70);
		Color green = new Color(90,223,90);
		 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 884, 437);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(grey);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPilot = new JLabel("PILOT");
		lblPilot.setFont(font1);
		lblPilot.setForeground(Color.WHITE);
		lblPilot.setBounds(173, 18, 65, 16);
		contentPane.add(lblPilot);
		
		JLabel lblSpeed = new JLabel("Speed:");
		lblSpeed.setForeground(Color.WHITE);
		lblSpeed.setBounds(42, 245, 65, 14);
		contentPane.add(lblSpeed);
		
		JLabel lblAltitude = new JLabel("Altitude:");
		lblAltitude.setForeground(Color.WHITE);
		lblAltitude.setBounds(36, 272, 71, 14);
		contentPane.add(lblAltitude);
		
		JLabel lblLandtime = new JLabel("Landing Time:");
		lblLandtime.setForeground(Color.WHITE);
		lblLandtime.setBounds(196, 245, 93, 14);
		contentPane.add(lblLandtime);
		
		JLabel lblGearStatus_1 = new JLabel("Gear Down:");
		lblGearStatus_1.setForeground(Color.WHITE);
		lblGearStatus_1.setBounds(199, 272, 93, 14);
		contentPane.add(lblGearStatus_1);
		
		speedPilot = new JTextField();
		speedPilot.setText(""+display.getSpeed()); //setting speed to pilot interface
		speedPilot.setBounds(95, 241, 86, 20);
		speedPilot.setFont(font2);
		contentPane.add(speedPilot);
		speedPilot.setColumns(10);
		
		altitudePilot = new JTextField();
		altitudePilot.setText(""+display.getAltitude()); //setting altitude to pilot interface
		altitudePilot.setBounds(95, 272, 86, 20);
		altitudePilot.setFont(font2);
		contentPane.add(altitudePilot);
		altitudePilot.setColumns(10);
		
		landtimePilot = new JTextField();
		landtimePilot.setText(""+display.getTime()); //setting time to pilot interface
		landtimePilot.setBounds(301, 241, 86, 20);
		landtimePilot.setFont(font2);
		contentPane.add(landtimePilot);
		landtimePilot.setColumns(10);
		
		gearPilot = new JTextField();
		gearPilot.setFont(new Font("SansSerif", Font.BOLD, 15));
		gearPilot.setText(""+display.getGear());  //setting gear for pilot interface
		gearPilot.setColumns(10);
		gearPilot.setBounds(301, 272, 86, 20);
		contentPane.add(gearPilot);
		
		JButton pilotSpeedAdd = new JButton("Speed +");
		pilotSpeedAdd.setBounds(101, 325, 90, 28);
		contentPane.add(pilotSpeedAdd);
		
		JButton pilotSpeedMinus = new JButton("Speed -");
		pilotSpeedMinus.setBounds(192, 325, 90, 28);
		contentPane.add(pilotSpeedMinus);
		
		
		JLabel lblAlarm = new JLabel("ALARM");
		lblAlarm.setFont(font2);
		lblAlarm.setForeground(Color.WHITE);
		lblAlarm.setBounds(87, 49, 55, 16);
		contentPane.add(lblAlarm);
		
		JLabel lblWarning = new JLabel("WARNING");
		lblWarning.setFont(font2);
		lblWarning.setForeground(Color.WHITE);
		lblWarning.setBounds(246, 49, 82, 16);
		contentPane.add(lblWarning);
		
		/******************Setting Gear Not Down alarm for pilot interface****************************************/	

		JTextArea pilotAlarm = new JTextArea();		
		pilotAlarm.setAlignmentX(SwingConstants.LEFT);
		pilotAlarm.setAlignmentY(SwingConstants.TOP);
		if(display.getGearNotDownAlarm()){
		pilotAlarm.setBackground(Color.RED);
		pilotAlarm.setText("Gear Not Down");
		}else {
			pilotAlarm.setBackground(Color.GREEN);
			pilotAlarm.setText("");	
		}
		pilotAlarm.setFont(font1);
		pilotAlarm.setAlignmentX(JTextField.CENTER);
		pilotAlarm.setForeground(Color.WHITE);
		pilotAlarm.setBounds(32, 77, 163, 47);
		contentPane.add(pilotAlarm);
		
		/********************Setting Air Brake Warning for pilot interface*************************************/	

		JTextArea pilotWarning = new JTextArea();
		if(display.getAirBrakeWarning()){
		pilotWarning.setBackground(Color.YELLOW);
		pilotWarning.setText("Applying Air Brake");
		}else {
			pilotWarning.setBackground(Color.WHITE);
			pilotWarning.setText("");	
		}
		//pilotWarning.setBackground(Color.white);
		pilotWarning.setFont(font1);
		pilotWarning.setBounds(205, 77, 203, 47);
		contentPane.add(pilotWarning);
		
		/********************Setting Gear Air Speed Alarm for pilot interface*************************************/	
		JTextArea textArea_3 = new JTextArea();
		textArea_3.setForeground(Color.WHITE);
		textArea_3.setFont(new Font("SansSerif", Font.BOLD, 20));
		if(display.getGearAirSpeedAlarm()){
		textArea_3.setText("Gear Air Speed");		
		textArea_3.setBackground(Color.RED);
		}else {
			textArea_3.setText("");		
			textArea_3.setBackground(Color.GREEN);
		}
		textArea_3.setBounds(32, 137, 163, 47);
		contentPane.add(textArea_3);
		
	/***************************Setting Gear Override Warning for pilot interface ****************************************/
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setFont(new Font("SansSerif", Font.BOLD, 20));
		if(display.getGearOverrideWarning()){
		textArea_2.setText("Overriding Gear");
		textArea_2.setBackground(Color.YELLOW);
		}else {
			textArea_2.setText("");
			textArea_2.setBackground(Color.WHITE);	
		}
		textArea_2.setBounds(205, 137, 203, 47);
		contentPane.add(textArea_2);
	/*************************************************************************************************************************/	
		JToggleButton pilotGearToggle = new JToggleButton("Gear DOWN");
		pilotGearToggle.setBounds(205, 193, 163, 31);
		contentPane.add(pilotGearToggle);
		//pilotGearToggle.doClick();
		pilotGearToggle.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(pilotGearToggle.isSelected())
				{
					pilotGearToggle.setText("Gear UP");
				}
				else
				{
					pilotGearToggle.setText("Gear DOWN");
				}
			}
		});
		
		JToggleButton pilotAudio = new JToggleButton();

		pilotAudio.doClick();
		pilotAudio.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {

					if(pilotAudio.isSelected() ){
						pilotAudio.setText("AUDIO ALARM OFF");
						pilotAudio.setBackground(green);
					}
					else
					{
						pilotAudio.setBackground(red);
						pilotAudio.setText("AUDIO ALARM ON");
						
					}
				}

			
		});
		pilotAudio.setBounds(32, 193, 163, 31);
		contentPane.add(pilotAudio);
		
	/*******************Splitting screen for pilot and co-pilot**********************************************************/	
		JSeparator separator = new JSeparator();
		separator.setOrientation(1);
		separator.setBounds(420, 12, 2, 396);
		contentPane.add(separator);
	/*****************************************************************************************************/	
		
		/************************CO-PILOT INPUTS******************************************************/
		
		JLabel lblCopilot = new JLabel("CO-PILOT");
		lblCopilot.setFont(font1);
		lblCopilot.setForeground(Color.WHITE);
		lblCopilot.setBounds(563, 18, 105, 16);
		contentPane.add(lblCopilot);
		
		JLabel label = new JLabel("Speed:");
		label.setForeground(Color.WHITE);
		label.setBounds(445, 244, 41, 14);
		contentPane.add(label);
		
		
		JLabel label_1 = new JLabel("Altitude:");
		label_1.setForeground(Color.WHITE);
		label_1.setBounds(434, 269, 52, 14);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Landing Time:");
		label_2.setForeground(Color.WHITE);
		label_2.setBounds(589, 244, 90, 14);
		contentPane.add(label_2);
		
		JLabel lblGearStatus = new JLabel("Gear Down:");
		lblGearStatus.setForeground(Color.WHITE);
		lblGearStatus.setBounds(586, 272, 90, 14);
		contentPane.add(lblGearStatus);
		
		copilotSpeed = new JTextField();
		copilotSpeed.setText(""+display.getSpeed());  //setting speed for co-pilot interface
		copilotSpeed.setColumns(10);
		copilotSpeed.setFont(font2);
		copilotSpeed.setBounds(488, 240, 86, 20);
		contentPane.add(copilotSpeed);
		
		copilotAltitude = new JTextField();
		copilotAltitude.setText(""+display.getAltitude());  //setting altitude for co-pilot interface
		copilotAltitude.setColumns(10);
		copilotAltitude.setBounds(488, 265, 86, 20);
		copilotAltitude.setFont(font2);
		contentPane.add(copilotAltitude);
		
		copilotLandtime = new JTextField();
		copilotLandtime.setText(""+display.getTime());  //setting time for co-pilot interface
		copilotLandtime.setColumns(10);
		copilotLandtime.setBounds(674, 240, 86, 20);
		copilotLandtime.setFont(font2);
		contentPane.add(copilotLandtime);
		
		copilotGear = new JTextField();
		copilotGear.setFont(new Font("SansSerif", Font.BOLD, 15));
		copilotGear.setText(""+display.getGear());  //setting gear for co-pilot interface 
		copilotGear.setColumns(10);
		copilotGear.setBounds(674, 265, 86, 20);
		contentPane.add(copilotGear);
		
		JLabel label_4 = new JLabel("ALARM");
		label_4.setFont(font2);
		label_4.setForeground(Color.WHITE);
		label_4.setBounds(498, 49, 55, 16);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("WARNING");
		label_5.setFont(font2);
		label_5.setForeground(Color.WHITE);
		label_5.setBounds(652, 49, 71, 16);
		contentPane.add(label_5);
		
		/********************Setting Air Brake Warning for co-pilot interface*************************************/		
		JTextArea copilotWarning = new JTextArea();
		if(display.getAirBrakeWarning()){
		copilotWarning.setBackground(Color.YELLOW);
		copilotWarning.setText("Applying Air Brake");
		}else {
			copilotWarning.setBackground(Color.WHITE);
			copilotWarning.setText("");	
		}
		copilotWarning.setFont(font1);
		copilotWarning.setBounds(607, 77, 205, 47);
		contentPane.add(copilotWarning);
		
		/******************Setting Gear Not Down alarm for co-pilot interface****************************************/	
		JTextArea copilotAlarm = new JTextArea();	
		if(display.getGearNotDownAlarm()){
		copilotAlarm.setBackground(Color.RED);
		copilotAlarm.setText("Gear Not Down");
		}else{
			copilotAlarm.setBackground(Color.GREEN);
			copilotAlarm.setText("");	
		}
		copilotAlarm.setFont(font1);
		copilotAlarm.setForeground(Color.white);
		copilotAlarm.setBounds(434, 77, 163, 47);
		contentPane.add(copilotAlarm);
		
		/***************************Setting Gear Override Warning for co-pilot interface ****************************************/
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("SansSerif", Font.BOLD, 20));
		if(display.getGearOverrideWarning()){
		textArea.setText("Overriding Gear");
		textArea.setBackground(Color.YELLOW);
		}else {
			textArea.setText("");
			textArea.setBackground(Color.WHITE);
		}
		textArea.setBounds(607, 137, 205, 47);
		contentPane.add(textArea);
		
		/********************Setting Gear Air Speed Alarm for co-pilot interface*************************************/	

		JTextArea textArea_1 = new JTextArea();
		textArea_1.setForeground(Color.WHITE);
		textArea_1.setFont(new Font("SansSerif", Font.BOLD, 20));
		if(display.getGearAirSpeedAlarm()){
		textArea_1.setText("Gear Air Speed");		
		textArea_1.setBackground(Color.RED);
		}else {
			textArea_1.setText("");		
			textArea_1.setBackground(Color.GREEN);
		}
		textArea_1.setBounds(434, 137, 163, 47);
		contentPane.add(textArea_1);
		/*************************************************************************************************************/

								
	}

}

package org.usfirst.frc.team3793.robot;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;

public class TeleopForm {
	private static boolean haveLeftButtonPushed;
	private static boolean haveRightButtonPushed;
	private JFrame frame;
	private final JButton rButton = new JButton(">>>");
	private final JButton lButton = new JButton("<<<");
	private final JSlider slider = new JSlider();
	private final JLabel lLabel = new JLabel("");
	private final JLabel rLabel = new JLabel("");
	private final JLabel sliderLabel = new JLabel("");

	/**
	 * Create the application.
	 */
	public TeleopForm() {
		initialize();
	}


	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 830, 636);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		rButton.setBounds(664, 200, 80, 40);
		lButton.setBounds(166, 200, 80, 40);
		lButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				haveLeftButtonPushed = !haveLeftButtonPushed;
				lLabel.setText(Boolean.toString(haveLeftButtonPushed));				
			}
		});
		frame.getContentPane().setLayout(null);
		lLabel.setBounds(0, 0, 166, 636);
		
		frame.getContentPane().add(lLabel);
		
		frame.getContentPane().add(lButton);
		slider.setBounds(332, 0, 166, 636);
		slider.setOrientation(SwingConstants.VERTICAL);
		
		frame.getContentPane().add(slider);
		rButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				haveRightButtonPushed = !haveRightButtonPushed;
				rLabel.setText(Boolean.toString(haveRightButtonPushed));
			}
		});
		rLabel.setBounds(498, 0, 166, 636);
		
		frame.getContentPane().add(rLabel);
		
		frame.getContentPane().add(rButton);
		
		sliderLabel.setBounds(498, 89, 70, 15);
		frame.getContentPane().add(sliderLabel);
	}
	
	public int getSliderValue() {
		int a;
		a = slider.getValue();		
		return a;
	}
	public JButton getLeftButton() {
		return lButton;
	}
	public JButton getRightButton() {
		return rButton;
	}
	public void makeVisible(TeleopForm a) {
		a.frame.setVisible(true);
	}
	public void dispSliderVal(double a) {
		sliderLabel.setText(Double.toString(a));
	}
	public boolean rightButtonPressed () {
		return haveRightButtonPushed;
	}
	public boolean leftButtonPressed () {
		return haveLeftButtonPushed;
	}	
}




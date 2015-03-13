package org.usfirst.frc.team3793.robot;

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
	private final JButton rButton = new JButton("0 str");
	private final JButton lButton = new JButton("0 thr");
	private final JSlider throttleSlider = new JSlider();
	private final JLabel lLabel = new JLabel("");
	private final JLabel rLabel = new JLabel("");
	private final JLabel throttleSliderLabel = new JLabel("");
	private final JLabel steeringSliderLabel = new JLabel("");
	private final JSlider steeringSlider = new JSlider();

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
		frame.setBounds(100, 100, 470, 418);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		rButton.setBounds(350, 100, 80, 40);
		lButton.setBounds(50, 100, 80, 40);
		lButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				haveLeftButtonPushed = !haveLeftButtonPushed;
				zeroThrottleSliderVal();
//				lLabel.setText(Boolean.toString(haveLeftButtonPushed));				
			}
		});
		frame.getContentPane().setLayout(null);
		lLabel.setBounds(0, 0, 70, 15);
		
		frame.getContentPane().add(lLabel);
		
		frame.getContentPane().add(lButton);
		throttleSlider.setBounds(150, 0, 166, 200);
		throttleSlider.setOrientation(SwingConstants.VERTICAL);
		steeringSlider.setBounds(150, 200, 166, 200);
		steeringSlider.setOrientation(SwingConstants.HORIZONTAL);
		
		frame.getContentPane().add(throttleSlider);
		frame.getContentPane().add(steeringSlider);
		rButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				haveRightButtonPushed = !haveRightButtonPushed;
				zeroSteeringSliderVal();
//				rLabel.setText(Boolean.toString(haveRightButtonPushed));
			}
		});
		rLabel.setBounds(350, 0, 70, 15);
		
		frame.getContentPane().add(rLabel);
		
		frame.getContentPane().add(rButton);
		
		throttleSliderLabel.setBounds(350, 89, 70, 15);
		frame.getContentPane().add(throttleSliderLabel);
		steeringSliderLabel.setBounds(350,200, 70, 15);
		frame.getContentPane().add(steeringSliderLabel);
	}
	
	public int getthrottleSliderValue() {
		int a;
		a = throttleSlider.getValue();		
		return a;
	}
	public int getSteeringSliderValue() {
		int a;
		a = steeringSlider.getValue();
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
	public void dispthrottleSliderVal(double a) {
		throttleSliderLabel.setText(Double.toString(a));
	}
	public void dispSteeringSliderVal(double a) {
		steeringSliderLabel.setText(Double.toString(a));
	}
	public void dispRightVal (double a) {
		rLabel.setText(Double.toString(a));
	}
	public void dispLeftVal (double a) {
		lLabel.setText(Double.toString(a));
	}
	public boolean rightButtonPressed () {
		return haveRightButtonPushed;
	}
	public boolean leftButtonPressed () {
		return haveLeftButtonPushed;
	}
	public void zeroThrottleSliderVal() {
		throttleSlider.setValue(50);
	}
	public void zeroSteeringSliderVal() {
		steeringSlider.setValue(50);
	}
}




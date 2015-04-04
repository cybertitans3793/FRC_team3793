// RobotBuilder Version: 1.5
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc3793.CTRobot.subsystems;

import org.usfirst.frc3793.CTRobot.RobotMap;
import org.usfirst.frc3793.CTRobot.RobotDefines;
import org.usfirst.frc3793.CTRobot.commands.*;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Joystick.AxisType;
import edu.wpi.first.wpilibj.PIDSource.PIDSourceParameter;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import org.usfirst.frc3793.CTRobot.commands.MoveRobot;

//import org.usfirst.frc.team3793.robot.;



import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The DriveTrain subsystem incorporates the sensors and actuators attached to
 * the robots chassis. These include four drive motors, a left and right encoder
 * and a gyro.
 */
public class DriveTrain extends Subsystem {
	private SpeedController front_left_motor, back_left_motor,
							front_right_motor, back_right_motor;
	private RobotDrive drive;
	private Encoder left_encoder, right_encoder;
	private AnalogInput rangefinder;
	private Gyro gyro;
	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    	Encoder quadratureEncoderRight = RobotMap.driveTrainQuadratureEncoderRight;
    	Encoder quadratureEncoderLeft = RobotMap.driveTrainQuadratureEncoderLeft;
    	Ultrasonic sonarL = RobotMap.driveTrainSonarL;
    	Ultrasonic sonarR = RobotMap.driveTrainSonarR;
    	SpeedController motorL = RobotMap.driveTrainMotorL;
    	SpeedController motorR = RobotMap.driveTrainMotorR;
    	RobotDrive robotDrive01 = RobotMap.driveTrainRobotDrive01;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

	
	
//	if (RobotDefines.simulation == true) {
		private double missAlignmentFactor = 1.0;
//	} else {
//		private double missAlignmentFactor = 1.0;
//	}
	

	public DriveTrain() {

    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	}
	
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
        setDefaultCommand(new MoveRobot());
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
	}

	/**
	 * The log method puts interesting information to the SmartDashboard.
	 */

	/**
	 * Tank style driving for the DriveTrain. 
	 * @param left Speed in range [-1,1]
	 * @param right Speed in range [-1,1]
	 */
/*	public void drive(double left, double right) {
		drive.tankDrive(left, right);
	} */
//	public void drive(double left) {
//		double thr = 0.2;           //TODO: Replace with reading joystick (Robot.oi.getThrottleSlider()-50.0)/50.0;
		
//		drive.tankDrive(thr,thr+left);
//	} 
	/**
	 * @param joy The ps3 style joystick to use to drive tank style.
	 */
/*	public void driveAxis(Joystick joy) {
		drive(-joy.getY(), -joy.getAxis(AxisType.kThrottle));
	} */
/*	
	public void drive(double throttleVal,double steerVal) {
		double driveR;
		double driveL;
		double steerAdjVal;
//		boolean lButtonPressed = Robot.oi.leftButtonPressed();
//		boolean rButtonPressed = Robot.oi.rightButtonPressed();
		driveR = (throttleVal-50.0)/50.0;
		driveL = (throttleVal-50.0)/50.0;
		steerAdjVal = ((steerVal - 50.0)/50.0); 
//		Robot.oi.dispThrottleSliderVal(driveR);
//		Robot.oi.dispSteeringSliderVal(steerAdjVal);
//		System.out.println(Double.toString((driveL-steerAdjVal)/2.0));
//		System.out.println(Double.toString((driveR+steerAdjVal)/2.0));
//		drive((driveL)+(steerAdjVal),missAlignmentFactor*(driveR)+(-steerAdjVal));
 
	}
*/
    public void driveT (double outputMagnitude, double curve) {
    	drive.drive(outputMagnitude, curve);
    }
	/**
	 * @return The robots heading in degrees.
	 */
//	public double getHeading() {
//		return gyro.getAngle();
//	}

	/**
	 * Reset the robots sensors to the zero states.
	 */
	public void reset() {
		gyro.reset();
		left_encoder.reset();
		right_encoder.reset();
	}

	/**
	 * @return The distance driven (average of left and right encoders).
	 */
	public double getDistance() {
		return (left_encoder.getDistance() + right_encoder.getDistance())/2;
	}
	public double getRateLeft() {
		return left_encoder.getRate();
		
	}
	public double getRateRight() {
		return right_encoder.getRate();
		
	}	
	/**
	 * @return The distance to the obstacle detected by the rangefinder. 
	 */
	public double getDistanceToObstacle() {
		// Really meters in simulation since it's a rangefinder...
		return rangefinder.getAverageVoltage();
	}
}

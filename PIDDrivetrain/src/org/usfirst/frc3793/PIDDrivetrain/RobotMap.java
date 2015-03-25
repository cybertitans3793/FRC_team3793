// RobotBuilder Version: 1.5
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc3793.PIDDrivetrain;
    
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.PIDSource.PIDSourceParameter;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import java.util.Vector;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static Encoder driveTrainPIDRQuadratureEncoderR;
    public static SpeedController driveTrainPIDRwheelRF;
    public static Encoder driveTrainPIDRQuadratureEncoderL;
    public static SpeedController driveTrainPIDRwheelLF;
    public static SpeedController driveTrainPIDRwheelLR;
    public static SpeedController driveTrainPIDRwheelRR;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static Gyro	gyro;

    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        driveTrainPIDRQuadratureEncoderR = new Encoder(3, 4, false, EncodingType.k4X);
        LiveWindow.addSensor("DriveTrainPIDR", "Quadrature Encoder R", driveTrainPIDRQuadratureEncoderR);
        driveTrainPIDRQuadratureEncoderR.setDistancePerPulse(0.042);
        driveTrainPIDRQuadratureEncoderR.setPIDSourceParameter(PIDSourceParameter.kDistance);
        driveTrainPIDRwheelRF = new Talon(3);
        LiveWindow.addActuator("DriveTrainPIDR", "wheelRF", (Talon) driveTrainPIDRwheelRF);
        
        driveTrainPIDRQuadratureEncoderL = new Encoder(1, 2, false, EncodingType.k4X);
        LiveWindow.addSensor("DriveTrainPIDR", "Quadrature Encoder L", driveTrainPIDRQuadratureEncoderL);
        driveTrainPIDRQuadratureEncoderL.setDistancePerPulse(0.042);
        driveTrainPIDRQuadratureEncoderL.setPIDSourceParameter(PIDSourceParameter.kDistance);
        driveTrainPIDRwheelLF = new Talon(1);
        LiveWindow.addActuator("DriveTrainPIDR", "wheelLF", (Talon) driveTrainPIDRwheelLF);
        
        driveTrainPIDRwheelLR = new Talon(2);
        LiveWindow.addActuator("DriveTrainPIDR", "wheelLR", (Talon) driveTrainPIDRwheelLR);
        
        driveTrainPIDRwheelRR = new Talon(4);
        LiveWindow.addActuator("DriveTrainPIDR", "wheelRR", (Talon) driveTrainPIDRwheelRR);
        

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        
        gyro = new Gyro(1);
        LiveWindow.addActuator("Nav", "Gyro", (Gyro) gyro);
    }
    public static void setEncodersDistance () {
    	driveTrainPIDRQuadratureEncoderL.setPIDSourceParameter(PIDSourceParameter.kDistance);
    	driveTrainPIDRQuadratureEncoderR.setPIDSourceParameter(PIDSourceParameter.kDistance);
    }
    public static void setEncodersRate () {
    	driveTrainPIDRQuadratureEncoderL.setPIDSourceParameter(PIDSourceParameter.kRate);
    	driveTrainPIDRQuadratureEncoderR.setPIDSourceParameter(PIDSourceParameter.kRate);    	
    }
}
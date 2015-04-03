// RobotBuilder Version: 1.5
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc3793.CTRobot.commands;

import edu.wpi.first.wpilibj.PIDSource.PIDSourceParameter;
import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.command.Command;


import org.usfirst.frc3793.CTRobot.Robot;
import org.usfirst.frc3793.CTRobot.RobotDefines;
import org.usfirst.frc3793.CTRobot.RobotMap;
import org.usfirst.frc3793.CTRobot.subsystems.DriveTrain;

/**
 *
 */
public class  DriveStraight extends Command {
	    private PIDController pid;
    	private double kf = RobotDefines.cKf; 			//0.0;
    	private double kp = RobotDefines.cKp; 			//0.0;
    	private double ki = RobotDefines.cKi; 			//0.01;
    	private double sf = RobotDefines.cSf; 			//0.1;

	private double m_speed;
    public DriveStraight(double velocity_skew) {
        requires(Robot.driveTrain);
        pid = new PIDController(kp, ki, 0, kf,
                new PIDSource() { public double pidGet() {
                    return (Robot.driveTrain.getRateRight() - Robot.driveTrain.getRateLeft());
                }},
                new PIDOutput() { public void pidWrite(double d) {
                    Robot.driveTrain.drive(d);
                }});
        pid.setAbsoluteTolerance(0.01);
        pid.setSetpoint(sf*velocity_skew);
    }
    // Called just before this Command runs the first time
    public void initialize() {
    	// Get everything in a safe starting state.
        Robot.driveTrain.reset();
    	pid.reset();
        pid.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    public void execute() {}

    // Make this return true when this Command no longer needs to run execute()
    public boolean isFinished() {
        return pid.onTarget();
    }

    // Called once after isFinished returns true
    public void end() {
    	// Stop PID and the wheels
    	pid.disable();
        Robot.driveTrain.drive(0, 0);
    }

    public void setpoint(double a) {
    	pid.setSetpoint(sf*a);
    }
    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    public void interrupted() {
        end();
    }

}
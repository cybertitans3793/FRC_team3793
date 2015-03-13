/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team3793.robot.commands;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team3793.robot.Robot;

/**
 * Drive the given distance straight (negative values go backwards).
 * Uses a local PID controller to run a simple PID loop that is only
 * enabled while this command is running. The input is the averaged
 * values of the left and right encoders. 
 */
public class DriveStraight extends Command {
    private PIDController pid;
    private double kf = 1.0;
    private double ki = 0.1;
    private double sf = 5.0;
    
    public DriveStraight(double velocity) {
        requires(Robot.drivetrain);
        pid = new PIDController(0, ki, 0, kf,
                new PIDSource() { public double pidGet() {
                    return (Robot.drivetrain.getRateRight() + Robot.drivetrain.getRateLeft())/2;
                }},
                new PIDOutput() { public void pidWrite(double d) {
                    Robot.drivetrain.drive(d, d);
                }});
        pid.setAbsoluteTolerance(0.01);
        pid.setSetpoint(sf*velocity);
    }

    // Called just before this Command runs the first time
    public void initialize() {
    	// Get everything in a safe starting state.
        Robot.drivetrain.reset();
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
        Robot.drivetrain.drive(0, 0);
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

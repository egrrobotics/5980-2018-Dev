package org.usfirst.frc.team5980.robot.commands;

import org.usfirst.frc.team5980.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SetTurretPower extends Command {
	//double stopTime;
	//double time;
	double power;
    public SetTurretPower(double power) {
        // Use requires() here to declare subsystem dependencies
        //requires(chassis);
    	this.power = power;
    	//this.time = stopTime;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.turretElevator.setTurretPower(power);
    	//stopTime = System.currentTimeMillis() + time;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
 
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.turretElevator.setTurretPower(0);
    }
}

package org.usfirst.frc.team5980.robot.commands;

import org.usfirst.frc.team5980.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TurretForTime extends Command {
	long stopTime;
	double power;
	long time;
    public TurretForTime(long stopTime, double power) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.turret);
        this.stopTime = stopTime;
        this.power = power;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	time = System.currentTimeMillis() + stopTime;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.turret.setTurretPower(power);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return System.currentTimeMillis() > time;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.turret.setTurretPower(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.turret.setTurretPower(0);
    }
}

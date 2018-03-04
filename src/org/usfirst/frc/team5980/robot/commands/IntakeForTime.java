package org.usfirst.frc.team5980.robot.commands;

import org.usfirst.frc.team5980.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class IntakeForTime extends Command {
	long stopTime;
	long endTime;
	double speed;
    public IntakeForTime(long endTime, double speed) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.intake);
        this.speed = speed;
        this.endTime = endTime;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	stopTime = System.currentTimeMillis() + endTime;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.intake.setIntakePower(speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return System.currentTimeMillis() > stopTime;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.intake.setIntakePower(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.intake.setIntakePower(0);
    }
}

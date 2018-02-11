package org.usfirst.frc.team5980.robot.commands;

import org.usfirst.frc.team5980.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ElevatorForTime extends Command {
	long stopTime;
	int runTime;

    public ElevatorForTime(int runTime) {
    	this.runTime = runTime;
        // Use requires() here to declare subsystem dependencies
        requires(Robot.elevator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	stopTime = System.currentTimeMillis() + runTime;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.elevator.setElevatorPower(1);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (System.currentTimeMillis() > stopTime);
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.elevator.setElevatorPower(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.elevator.setElevatorPower(0);
    }
}

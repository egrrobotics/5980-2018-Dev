package org.usfirst.frc.team5980.robot.commands;

import org.usfirst.frc.team5980.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class SetClimberReleaseAngle extends Command {
	double angle;
    public SetClimberReleaseAngle(double angle) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.climber);
        this.angle = angle;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.climber.setReleaseAngle(angle);
    	SmartDashboard.putString("Released!", "");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}

package org.usfirst.frc.team5980.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc.team5980.robot.Acceleration;
import org.usfirst.frc.team5980.robot.Robot;

/**
 * This is a command that will run autonomous mode instructions.
 */
public class AutoCommand extends CommandGroup {
	public AutoCommand() {
		System.out.println("Auto Running");
		// Use requires() here to declare subsystem dependencies
		//requires(Robot.driveTrain);
		//addSequential(new DriveForwardAutoCommand(.35, 75, 0));
    	//addSequential(new RotateToHeadingCommand(-50, 0.3));
    	//addSequential(new ToggleTracking(true));
    	//addSequential(new WaitForTarget());
    	addSequential(new DriveToTarget(new Acceleration(.5,.5,0), 10));
    	//addSequential(new ToggleTracking(false));
    	//addSequential(new PauseCommand(500));
    	//addSequential(new GearOpen());
    	//addSequential(new PauseCommand(300));
    	//addSequential(new DriveBackwardsAutoCommand(.35, -40, -60));
    	//addSequential(new GearClose());
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
	}
}

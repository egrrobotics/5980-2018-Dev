package org.usfirst.frc.team5980.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team5980.robot.Robot;

/**
 * This command allows the robot to be controlled via the joy stick.
 */
public class ArcadeCommand extends Command {
	public ArcadeCommand() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.driveTrain);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		//System.out.println("ArcadeCommand.initialize");
	}

    public double deadBand(double x){
    	if (Math.abs(x)<.2){
    		return 0;
    	}else{
    		return x;
    	}
    }
    
    public double clip(double x){
    	if (x>.885) return .885;
    	if (x<-.885) return -.885;
    	return x;
    }
    
	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		//System.out.println("ArcadeCommand.execute");
		
		double throttle = deadBand(-Robot.oi.driver.getRawAxis(1)) * Robot.driveTrain.speedType;
		double wheel = deadBand(Robot.oi.driver.getRawAxis(4)) * Robot.driveTrain.speedType;
		double leftPower = clip (throttle + wheel);
		double rightPower = clip (throttle - wheel);
		Robot.driveTrain.setPower(leftPower, rightPower);
		
		//SmartDashboard.putNumber("Left Encoder: ", Robot.sensors.getLeftEncoder());
		//SmartDashboard.putNumber("Right Encoder: ", Robot.sensors.getRightEncoder());
		
		//check the various ways to get coordinates from the xboxController
		//System.out.println( Robot.oi.driver.getRawAxis(AxisType.kX.value) );
		//System.out.println( Robot.oi.driver.getY(Hand.kLeft) );
		//System.out.println( Robot.oi.driver.getX(Hand.kRight) );				
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		//System.out.println("ArcadeCommand.isFinished");
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		//System.out.println("ArcadeCommand.end");
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		//System.out.println("ArcadeCommand.interrupted");
	}
}

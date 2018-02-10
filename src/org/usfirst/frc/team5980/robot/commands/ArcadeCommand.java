package org.usfirst.frc.team5980.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import java.text.DecimalFormat;

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
    	
    	if (x>.75) return .75;
    	if (x<-.75) return -.75;
    	return x;
    }
    
	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		
		// leftPower and rightPower will be opposite (i.e 5 and -5) if the robot is going straight
		
		double throttle = deadBand(-Robot.oi.driver.getRawAxis(1)) * Robot.driveTrain.speedType;		//Axis 1 is left joystick up/down, up is -1 (thats why its inverted)	
		
		//if (throttle > .2)
		//	throttle = .2;
		//else if (throttle < .2)
		//	throttle = -.2;
			
		double wheel = deadBand(Robot.oi.driver.getRawAxis(4)) * Robot.driveTrain.speedType;				
		double leftPower = clip(throttle + wheel);//clip is necessary to keep power levels between -1 and 1
		double rightPower = clip(throttle - wheel);
		
		Robot.driveTrain.setPower(leftPower, rightPower);
		SmartDashboard.putNumber("yelloe: ", Robot.sensors.getYaw());
		
		//if (leftPower != 0 || rightPower != 0) {
		//	DecimalFormat df = new DecimalFormat("#.###");
		//	System.out.print("Throttle / Wheel: "); System.out.print(df.format(throttle)); System.out.print(" / ") ;System.out.println(df.format(wheel));
		//    System.out.print("Left / Right Power: "); System.out.print(df.format(leftPower)); System.out.print(" / ") ;System.out.println(df.format(rightPower));
		//    
		//}
		
		//SmartDashboard.putNumber("left encoder; ", Robot.sensors.getLeftEncoder());
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

package org.usfirst.frc.team5980.robot.commands;

import org.usfirst.frc.team5980.robot.utils.EGRPID;
import org.usfirst.frc.team5980.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class RotateToHeading extends Command {
	EGRPID rotatePID = new EGRPID(.1, 0, 0);
	int heading;
	double speed;
	long stopTime;
	
    public RotateToHeading(double speed, int heading) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.driveTrain);
        this.heading = heading;
        this.speed = speed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	rotatePID.setTarget(heading);
    	stopTime = System.currentTimeMillis() + 3000;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double correction = rotatePID.getCorrection(Robot.sensors.getYaw());
    	if (correction > 1) {
    		correction = 1;
    	}
    	
    	if (correction < -1) {
    		correction = -1;
    	}
    	
    	System.out.print("rotating...");
    	System.out.println(Robot.sensors.getYaw());

    	Robot.driveTrain.setPower(-speed * correction, speed * correction);
 
    	//SmartDashboard.putNumber("Rotate.speed: ", speed);
    	//SmartDashboard.putNumber("Rotate.correction: ", correction);
    	//SmartDashboard.putNumber("Rotate.heading: ", heading);
    	//SmartDashboard.putNumber("Rotate.Yaw: ", Robot.sensors.getYaw());
    	//SmartDashboard.putNumber("Rotate.Yaw-heading: ", Robot.sensors.getYaw() - heading);
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	Robot.sensors.updatePosition();
    	
    	System.out.print("checking if rotate done...");
    	if (Robot.sensors.isMoving == false)
    		System.out.print("NOT MOVING ");
    	System.out.print(Robot.sensors.getYaw());
    	
    	boolean headingReached = Math.abs(Robot.sensors.getYaw() - heading) < 2;
    	boolean isDone = headingReached && Robot.sensors.isMoving == false;
        
    	if (isDone)
    		System.out.println(" DONE");
    	else
    		System.out.println(" NOT DONE");
    	
    	return isDone;// || System.currentTimeMillis() > stopTime;    
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveTrain.setPower(0, 0);
    	SmartDashboard.putString("Done ", "Rotating");

    	System.out.print("********  rotate done...");
    	System.out.println(Robot.sensors.getYaw());
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	
    }
}

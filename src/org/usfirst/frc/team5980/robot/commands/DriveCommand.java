package org.usfirst.frc.team5980.robot.commands;

import org.usfirst.frc.team5980.robot.Robot;
import org.usfirst.frc.team5980.robot.utils.EGRPID;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveCommand extends Command {

	 EGRPID drivePID = new EGRPID(.05, 0, 0);
	 EGRPID stopPID = new EGRPID(.015, 0, 0);
	 double maxSpeed;
	 int distance;
	 double heading;
	 double speed = 0;
	 double encoderTarget;
	 
    public DriveCommand(double speed, int distance, double heading) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveTrain);
        this.maxSpeed = speed;
        this.distance = distance;
        this.heading = heading;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	encoderTarget = Robot.sensors.getLeftEncoder() + distance * Robot.sensors.encoderCountsPerInch;
    	drivePID.setTarget(heading);
    	stopPID.setTarget(encoderTarget);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double stopCorrection = stopPID.getCorrection(Robot.sensors.getLeftEncoder());
    	if(stopCorrection > 1) {
    		stopCorrection = 1;
    	}
    	stopCorrection = 1;
    	double correction = drivePID.getCorrection(Robot.sensors.getYaw());
    	if (speed < maxSpeed) {
    		speed += 0.04;
    	} 
    	correction = 0;
    	double leftWheelPower = (speed - correction)*stopCorrection;
    	if (this.distance < 0)
    		leftWheelPower = leftWheelPower*-1;
    	double rightWheelPower = (speed + correction)*stopCorrection;
    	if (this.distance < 0)
    		rightWheelPower = rightWheelPower*-1;
    	SmartDashboard.putNumber("leftWheel", leftWheelPower);
    	SmartDashboard.putNumber("rightWheel", rightWheelPower);
    	Robot.driveTrain.setPower(leftWheelPower, rightWheelPower);
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	SmartDashboard.putNumber("encoderTarget: ", Math.abs(encoderTarget));
    	SmartDashboard.putNumber("currentEncoder: ", Math.abs(Robot.sensors.getLeftEncoder()));
    	SmartDashboard.putNumber("counter:", Robot.Counter++);
        return Math.abs(Robot.sensors.getLeftEncoder()) > Math.abs(encoderTarget-30);
        
        
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveTrain.setPower(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}

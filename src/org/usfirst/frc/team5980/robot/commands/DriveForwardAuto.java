package org.usfirst.frc.team5980.robot.commands;

import org.usfirst.frc.team5980.robot.Robot;
import org.usfirst.frc.team5980.robot.utils.EGRPID;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveForwardAuto extends Command {

	EGRPID drivePID = new EGRPID(.02, 0, 0);
	EGRPID stopPID; // .0006 for 20% speed, .000125 for 30% speed
	double maxSpeed;
	int distance;
	double heading;
	double speed = 0;
	double encoderTarget;
	double stopTime;

	public DriveForwardAuto(double speed, int distance, double heading) {
		requires(Robot.driveTrain);
		this.maxSpeed = speed;
		this.distance = distance;
		this.heading = heading;
		this.stopPID = new EGRPID(.04, 0, 0);
	}

	public DriveForwardAuto(double speed, int distance, double heading, double stopP) {
		requires(Robot.driveTrain);
		this.maxSpeed = speed;
		this.distance = distance;
		this.heading = heading;
		this.stopPID = new EGRPID(stopP, 0, 0);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		encoderTarget = Robot.sensors.getRightEncoder() + distance * Robot.sensors.encoderCountsPerInch;
		drivePID.setTarget(heading);
		stopPID.setTarget(encoderTarget);
		stopTime = System.currentTimeMillis() +7000;
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		double stopCorrection = stopPID.getCorrection(Robot.sensors.getRightEncoder());
		if (stopCorrection > 1) {
			stopCorrection = 1;
		}
		double correction = drivePID.getCorrection(Robot.sensors.getYaw());
		if (speed < maxSpeed) {
			speed += 0.04;
		}
		if (encoderTarget - Robot.sensors.getRightEncoder() < 300) {
			correction = 0;
		}
		
		Robot.driveTrain.setPower((speed - correction) * stopCorrection, (speed + correction) * stopCorrection);
		//SmartDashboard.putNumber("left encoder: ", Robot.sensors.getRightEncoder());

	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return Robot.sensors.getRightEncoder() > encoderTarget - 30 || System.currentTimeMillis() > stopTime;
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

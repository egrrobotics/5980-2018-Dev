package org.usfirst.frc.team5980.robot.subsystems;

import org.usfirst.frc.team5980.robot.RobotMap;
import org.usfirst.frc.team5980.robot.commands.ArcadeCommand;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

/**
 * Main subsystem for driving/moving the robot via the talons and motors
 */
public class DriveTrain extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	TalonSRX left1, left2, right1, right2;
	public double speedType;
	public boolean type;
	
	public DriveTrain() {
		System.out.println("drivetrainInit");
		right1 = new TalonSRX(RobotMap.rightDriveTrain1TalonNum);
		right2 = new TalonSRX(RobotMap.rightDriveTrain2TalonNum);
		
		left1 = new TalonSRX(RobotMap.leftDriveTrain1TalonNum);
		left2 = new TalonSRX(RobotMap.leftDriveTrain2TalonNum);
		
		right1.setInverted(true);//ESSENTIAL! One side will have to be the opposite direction to go the same direction
		right2.setInverted(true);
		
		speedType = 1;
		type = true;
	}
	
	public void toggleSpeedType() {
		if (speedType == 1) {
			speedType = .5;
		}
		else if (speedType == .5) {
			speedType = 1;
		}
		//SmartDashboard.putNumber("speedType ", speedType);
	}
	public double deadband(double i) {
		if(Math.abs(i) < .06) {
			i = 0;
		}
		return i;
	}
	public void setPower(double left, double right) {
		
		//System.out.println(right1.getSelectedSensorPosition(0));
		//System.out.println(right1.getSelectedSensorVelocity(0));
		//SmartDashboard.putNumber("PowerLEFT", left);
		//SmartDashboard.putNumber("PowerRIGHT", right);
		
		//System.out.println("DriveSubsystem.setPower");
		//System.out.println(left);
		//System.out.println(right);
		left = deadband(left);
		right = deadband(right);
		left1.set(com.ctre.phoenix.motorcontrol.ControlMode.PercentOutput, left);
		left2.set(com.ctre.phoenix.motorcontrol.ControlMode.PercentOutput, left);
		right1.set(com.ctre.phoenix.motorcontrol.ControlMode.PercentOutput, right);
		right2.set(com.ctre.phoenix.motorcontrol.ControlMode.PercentOutput, right);
	}
	
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		this.setDefaultCommand(new ArcadeCommand());
	}
}

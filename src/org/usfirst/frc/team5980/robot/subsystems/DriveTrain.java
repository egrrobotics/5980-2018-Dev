package org.usfirst.frc.team5980.robot.subsystems;

import org.usfirst.frc.team5980.robot.commands.ArcadeCommand;
import edu.wpi.first.wpilibj.command.Subsystem;
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
		right1 = new TalonSRX(1);
		right2 = new TalonSRX(2);
		left1 = new TalonSRX(3);
		left2 = new TalonSRX(4);
		//right1.setInverted(true);
		//right2.setInverted(true);
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
	
	public void setPower(double left, double right) {
		System.out.println("DriveSubsystem.setPower");
		System.out.println(left);
		System.out.println(right);
	
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

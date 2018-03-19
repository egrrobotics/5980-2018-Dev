package org.usfirst.frc.team5980.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Climber extends Subsystem {
	TalonSRX climber = new TalonSRX(9);
	TalonSRX climberRelease = new TalonSRX(8);
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public void setClimberPower(double power) {
		climber.set(ControlMode.PercentOutput, power);
	}
	
	public void setReleasePower(double power) {
		climberRelease.set(ControlMode.PercentOutput, power);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}


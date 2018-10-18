package org.usfirst.frc.team5980.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Climber extends Subsystem {
	TalonSRX climber = new TalonSRX(9);
	
	Servo climberRelease = new Servo(0);
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public void setClimberPower(double power) {
		climber.set(ControlMode.PercentOutput, power);
	}
	
	public void setReleaseAngle(double angle) {
		climberRelease.set(angle);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}


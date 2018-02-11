package org.usfirst.frc.team5980.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class TurretElevator extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	TalonSRX turret = new TalonSRX(8);
	TalonSRX intake1 = new TalonSRX(3);
	TalonSRX intake2 = new TalonSRX(10);
	TalonSRX elevator = new TalonSRX(9);
	
	public void setTurretPower(double power) {
		turret.set(ControlMode.PercentOutput, power);
	}
	
	public void setIntakePower(double power) {
		intake1.set(ControlMode.PercentOutput, -power);
		intake2.set(ControlMode.PercentOutput, power);
	}
	
	public void setElevatorPower(double power) {
		elevator.set(ControlMode.PercentOutput, power);
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}


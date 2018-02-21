package org.usfirst.frc.team5980.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Intake extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	TalonSRX intake1 = new TalonSRX(1);
	TalonSRX intake2 = new TalonSRX(2);
	
	public void setIntakePower(double power) {
		intake1.set(ControlMode.PercentOutput, -power);
		intake2.set(ControlMode.PercentOutput, power);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	
    }
}


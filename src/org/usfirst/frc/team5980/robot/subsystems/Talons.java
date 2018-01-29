package org.usfirst.frc.team5980.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Talons extends Subsystem {
	
	public static TalonSRX leftTalon = new TalonSRX(3);		// <-- move constant to RobotMap (robot setup class)
	public static TalonSRX rightTalon = new TalonSRX(6);	// <-- move constant to RobotMap (robot setup class)

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}


package org.usfirst.frc.team5980.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	// ----- Drive Talons	
	public static int leftDriveTrain1TalonNum = 3;
	public static int leftDriveTrain2TalonNum = 4;	
	public static int rightDriveTrain1TalonNum = 1;
	public static int rightDriveTrain2TalonNum = 5;
		
	// ----- Other Talons
	public static int turretTalonNum = 8;
	public static int intake1TalonNum = 6;
	public static int intake2TalonNum = 7;
	public static int elevatorTalonNum = 9;
	
	// ----- Encoders	
	public static boolean useTalonEncoders = true;
	
	public static int leftTalonEncoderNum = 3;
	public static int rightTalonEncoderNum = 6;
	
	public static int leftEncoderChannelA = 0;
	public static int leftEncoderChannelB = 1;
	public static int rightEncoderChannelA = 8;
	public static int rightEncoderChannelB = 9;
	
	public static double encoderCountsPerInch = 189;
	
	public static void configureJacob() {
		System.out.println("Jacob");
		RobotMap.useTalonEncoders = false;
		
		RobotMap.encoderCountsPerInch = 29.85;
		
		RobotMap.rightDriveTrain1TalonNum = 1;
		RobotMap.rightDriveTrain2TalonNum = 5;
		
		RobotMap.leftDriveTrain1TalonNum = 3;
		RobotMap.leftDriveTrain2TalonNum = 4;
	}
	
	public static void configureNathan() {
		
		RobotMap.useTalonEncoders = true;	//uses DIO channels configured in leftEncoderChannelA/B and rightEncoderChannelA/B
	
		RobotMap.encoderCountsPerInch = 189;
		
		RobotMap.rightDriveTrain1TalonNum = 4;
		RobotMap.rightDriveTrain2TalonNum = 5;
		
		RobotMap.leftDriveTrain1TalonNum = 6;
		RobotMap.leftDriveTrain2TalonNum = 7;
	}
}

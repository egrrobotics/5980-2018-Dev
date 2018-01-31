package org.usfirst.frc.team5980.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.SPI;

/**
 *
 */
public class Sensors extends Subsystem {
	
	private boolean usingTalonEncoders = true;	   		// <-- move constant to RobotMap (robot setup class)
	private Encoder leftEncoder = new Encoder(2, 3);	// <-- move constant to RobotMap (robot setup class)
	private Encoder rightEncoder = new Encoder(9, 8);	// <-- move constant to RobotMap (robot setup class)

	//static Potentiometer pot = new AnalogPotentiometer(0, 360, 10); //Channel number for Analog input, scale factor 360 being the great, offset to add after scaling to prevent breakage (10 to 30 range) 
	static AHRS navX;
	int rightEncoderOffset = 0;
	int leftEncoderOffset = 0;
	float yawOffset = 0;
	double XCoordinate = 0;
	double YCoordinate = 0;
	double lastLeftEncoder = 0;
	double lastRightEncoder = 0;
	boolean encoderInvert = false;
	public double encoderCountsPerInch = 189;
	
	public Sensors() {
		try {
			navX = new AHRS(SPI.Port.kMXP);
		}
		catch(RuntimeException ex) {
			DriverStation.reportError("error instantiating navX: " + ex.getMessage(), true);
		}
		this.resetSensors();
	}
	
	public float getYaw() {
		float yaw;
		yaw = -(navX.getYaw() - yawOffset);
		while(yaw > 180) {
			yaw-=360;
		}
		while (yaw < -180) {
			yaw+=360;
		}
		return yaw;
	}
	
	public float getRoll() {
		float roll;
		roll = navX.getRoll();
		return roll;
	}
	
	public float getPitch() {
		float pitch;
		pitch = navX.getPitch();
		return pitch;
	}
	
	private int getLeftEncoderPosition() {
		if (this.usingTalonEncoders)
			return Talons.leftTalon.getSelectedSensorPosition(0);
		else
			return this.leftEncoder.get();
	}
	
	private int getRightEncoderPosition() {
		if (this.usingTalonEncoders)
			return Talons.rightTalon.getSelectedSensorPosition(0);
		else
			return this.rightEncoder.get();
	}
	
	public int getLeftEncoder() {
		int leftEncoderVal = this.getLeftEncoderPosition(); 	// this.leftTalon.getSelectedSensorPosition(0); // leftEncoder.get();
		int encoderValue = leftEncoderVal - leftEncoderOffset;
		return encoderValue;		
	}
	
	public int getRightEncoder() {
		int rightEncoderVal = this.getRightEncoderPosition(); 	// this.rightTalon.getSelectedSensorPosition(0);  //rightEncoder.get();
		int encoderValue = rightEncoderVal - rightEncoderOffset;
		return encoderValue;
	}
	
	public void switchDirection() {
		Encoder temp = rightEncoder;
		rightEncoder = leftEncoder;
		leftEncoder = temp;
		encoderInvert = !encoderInvert;
	}
	
	public void resetSensors() {
		leftEncoderOffset = this.getLeftEncoderPosition();
		rightEncoderOffset = this.getRightEncoderPosition();
		
		lastLeftEncoder = 0;
		lastRightEncoder = 0;
		
		yawOffset = navX.getYaw();
	}
	
	public void resetYaw() {
		navX.zeroYaw();
	}
	
	public void resetLeftEncoder() {
		leftEncoder.reset();
	}
	
	public void resetRightEncoder() {
		rightEncoder.reset();
	}
	
	/*
	public double getPot() {
		return pot.get();
	}
	*/
	
	/* public ConfigFwdLimitSwitchNormallyOpen() {
		if(btn4) {
			customMotorDescrip.ConfigFwdLimitSwitchNormallyOpen(true);
		}
		else if(btn2) {
			customMotorDescrip.ConfigFwdLimitSwitchNormallyOpen(false); 
		}
		if(btn1) {
			customMotorDescrip.ConfigRevLimitSwitchNormallyOpen(true);
		}
		elseif(btn3) {
			customMotorDescrip.ConfigRevLimitSwitchNormallyOpen(false);
		}
	}
	*/
	
	public void updatePosition() {
		double currentLeftEncoder = getLeftEncoder();
		double currentRightEncoder = getRightEncoder();
		double changeInLeftEncoder = currentLeftEncoder - lastLeftEncoder;
		double changeInRightEncoder = currentRightEncoder - lastRightEncoder;
		double encoderDistance = (changeInLeftEncoder + changeInRightEncoder)/2;
		double heading = Math.toRadians(getYaw());
		double changeInX = encoderDistance * Math.cos(heading);
		double changeInY = encoderDistance * Math.sin(heading);
		XCoordinate += changeInX;
		YCoordinate += changeInY;
		lastLeftEncoder = currentLeftEncoder;
		lastRightEncoder = currentRightEncoder;
	}
	
	public double getXCoordinate() {
		return XCoordinate / encoderCountsPerInch;
	}
	
	public double getYCoordinate() {
		return YCoordinate / encoderCountsPerInch;
	}
	
	public void resetPosition() {
		XCoordinate = 0;
		YCoordinate = 0;
	}
	
	// ---------------------------------------------

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
}


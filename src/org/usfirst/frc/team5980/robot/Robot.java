
package org.usfirst.frc.team5980.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team5980.robot.commands.*;
import org.usfirst.frc.team5980.robot.subsystems.*;
import org.usfirst.frc.team5980.robot.utils.GameData;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {	
	
	public static final DriveTrain driveTrain = new DriveTrain();
	public static OI oi;    
	public static GameData gameData = new GameData();		
	private Command autonomousCommand;
	private SendableChooser<Command> chooser = new SendableChooser<>();
	public static Sensors sensors = new Sensors();	
	
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {		
		oi = new OI();
		Robot.gameData.pullGameData();
		//this.setupSmartdashboard();	
		//this.updateSmartdashboard();
		
		sensors.resetSensors();
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {
		//System.out.println("Robot.disabledInit");
	}

	@Override
	public void disabledPeriodic() {
		//System.out.println("Robot.disabledPeriodic");
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		Robot.gameData.pullGameData();
		sensors.resetSensors();
		autonomousCommand = new FmsLlAutoCommandPosition1();

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		//System.out.println("Robot.autonomousPeriodic");
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		TalonSRX right1 = new TalonSRX(3);
		right1.setSelectedSensorPosition(0, 0, 0);
		
		//System.out.println("Robot.teleopInit");
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		
		//this.updateSmartdashboard();
		    	
		//System.out.println("-------");
		//System.out.println(right1.getSelectedSensorPosition(0));
		//System.out.println(right1.getSelectedSensorVelocity(0));
		//System.out.println("-------");
		
		//System.out.println("Robot.teleopPeriodic");
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		//System.out.println("Robot.testPeriodic");
		//LiveWindow.run();
	}
	
	// ---------------------------------------------

	private void setupSmartdashboard() {		
		chooser.addDefault("Autonomous option 1", new AutoCommand());
		chooser.addObject("Autonomous option 2", new AutoCommand());		
		//SmartDashboard.putData("Auto mode", chooser);	
	}
	
	private void updateSmartdashboard() {
		Robot.sensors.updatePosition();

		SmartDashboard.putNumber("L SensorPos:", Robot.sensors.getLeftEncoder() );  // left1.getSelectedSensorPosition(0)
		SmartDashboard.putNumber("L SensorVel:", Talons.leftTalon.getSelectedSensorVelocity(0));

		SmartDashboard.putNumber("R SensorPos:", Robot.sensors.getRightEncoder() );
		SmartDashboard.putNumber("R SensorVel:", Talons.rightTalon.getSelectedSensorVelocity(0));
		
	   	double currentX = Robot.sensors.getXCoordinate();
    	double currentY = Robot.sensors.getYCoordinate();
    	SmartDashboard.putNumber("x: ", currentX);
    	SmartDashboard.putNumber("y: ", currentY);
    	SmartDashboard.putNumber("yaw: ", Robot.sensors.getYaw());	
    }
	
}

package org.usfirst.frc.team5980.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team5980.robot.commands.SetActuatorPower;
import org.usfirst.frc.team5980.robot.commands.SetClimberPower;
import org.usfirst.frc.team5980.robot.commands.SetClimberReleaseAngle;

import org.usfirst.frc.team5980.robot.commands.SetElevatorPower;
import org.usfirst.frc.team5980.robot.commands.SetIntakePower;
import org.usfirst.frc.team5980.robot.commands.SetTurretPower;
import org.usfirst.frc.team5980.robot.commands.TurretForTime;
import org.usfirst.frc.team5980.robot.triggers.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	public Joystick driver = new Joystick(0);
	public Joystick operator = new Joystick(1);
	
	public OI() {
		//if (driver.getButtonCount() > 0)
			this.driverSetup();
		//if (operator.getButtonCount() > 0)
			this.operatorSetup();
		
		// ***
		// *** moved into operatorSetup below and changed use xboxTriggers...  needs to be tested
		// ***
		//Button buttonB = new JoystickButton(operator, 2); //button B on xbox
		//Button buttonA = new JoystickButton(operator, 1); //button A on xbox
		//buttonA.whileHeld(new SetIntakePower(-1));
		//buttonB.whileHeld(new SetIntakePower(1));//sets intake to take in box
	}
	
	private void driverSetup() {
		
		Button buttonLB = new JoystickButton(driver, XboxTrigger.LB); 
		buttonLB.whileActive(new SetTurretPower(-1));
		
		Button buttonRB = new JoystickButton(driver, XboxTrigger.RB); 
		buttonRB.whileActive(new SetTurretPower(1));
		
		Button buttonA = new JoystickButton(driver, 1);
		buttonA.whenPressed(new TurretForTime(2000, 1));
	
		Button buttonB = new JoystickButton(driver, 2);
		buttonB.whenPressed(new TurretForTime(2000, -1));
	}
	
	private void operatorSetup() {
		//XboxTrigger testButton = new XboxTrigger(operator, XboxTrigger.LB);
		//testButton.whileActive(null);
				
		Button buttonA = new JoystickButton(operator, 1); //button A on xbox
		buttonA.whileActive(new SetIntakePower(-1));

		Button buttonB = new JoystickButton(operator, 2); //button B on xbox
		buttonB.whileActive(new SetIntakePower(1));		//sets intake to push out? box	
		
		Button buttonX = new JoystickButton(operator, 3); 
		buttonX.whileActive(new SetClimberPower(1));
		
		Button buttonBack = new JoystickButton(operator, 7); 
		buttonBack.whileActive(new SetClimberPower(1));
		
		Button buttonStart = new JoystickButton(operator, 8); // releases climber
		buttonStart.whenPressed(new SetClimberReleaseAngle(.5));
		
		Button buttonLB = new JoystickButton(operator, 5);// lowers elevator
		buttonLB.whileActive(new SetElevatorPower(.5));
		
		Button buttonRB = new JoystickButton(operator, 6);// raises elevator
		buttonRB.whileActive(new SetElevatorPower(-.85)); 
		
	
	}
	
			
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
}

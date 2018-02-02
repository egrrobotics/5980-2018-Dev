package org.usfirst.frc.team5980.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team5980.robot.commands.SetIntakePower;
import org.usfirst.frc.team5980.robot.triggers.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	public XboxController driver = new XboxController(0);
	public XboxController operator = new XboxController(1);
	
	public OI() {
		if (driver.getButtonCount() > 0)
			this.driverSetup();
		if (operator.getButtonCount() > 0)
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
		XboxTrigger testButton = new XboxTrigger(driver, XboxTrigger.LB);
		testButton.whileActive(null);
	}
	
	private void operatorSetup() {
		//XboxTrigger testButton = new XboxTrigger(operator, XboxTrigger.LB);
		//testButton.whileActive(null);
				
		XboxTrigger buttonA = new XboxTrigger(operator, XboxTrigger.A); //button A on xbox
		buttonA.whileActive(new SetIntakePower(-1));

		XboxTrigger buttonB = new XboxTrigger(operator, XboxTrigger.B); //button B on xbox
		buttonB.whileActive(new SetIntakePower(1));		//sets intake to take in box		
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

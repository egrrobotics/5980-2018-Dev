package org.usfirst.frc.team5980.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class AutonSwitches extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	DigitalInput[] switches = new DigitalInput[8];
	
	public boolean[] getSwitchValues() {
		boolean[] values = new boolean[8];
		for(int i = 0; i < switches.length; i++) {
			values[i] = !switches[i].get();
		}
		return values;
	}
	
	public int getPosition() {
		int position = 0;
		if(this.getSwitchValues()[0]) {
			position = 1;
		}
		if(this.getSwitchValues()[1]) {
			position = 2;
		}
		if(this.getSwitchValues()[2]) {
			position = 3;
		}
		return position;
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}


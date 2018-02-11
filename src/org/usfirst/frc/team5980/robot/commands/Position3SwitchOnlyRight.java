package org.usfirst.frc.team5980.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Position3SwitchOnlyRight extends CommandGroup {

    public Position3SwitchOnlyRight() {
    	System.out.println("3switchonlyright");
    	//addSequential(new DriveForwardAuto(.3, 130, 0, .08));
    	//addParallel(new SetTurretPower(1, 2000));
    	addSequential(new PauseAuto(1000));
    	//addSequential(new RotateToHeading(.2, 90));
    	//addSequential(new PauseAuto(1000));
    	//addSequential(new DriveForwardAuto(.2, 34, 90, .08));
    	
    	
    }
}

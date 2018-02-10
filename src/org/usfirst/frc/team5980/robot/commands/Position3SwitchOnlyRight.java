package org.usfirst.frc.team5980.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Position3SwitchOnlyRight extends CommandGroup {

    public Position3SwitchOnlyRight() {
    	addSequential(new DriveForwardAuto(.3, 120, 0, .08));
    	addSequential(new PauseAuto(3000));
    	addSequential(new RotateToHeading(.2, 90));
    	addSequential(new PauseAuto(2000));
    	addSequential(new DriveForwardAuto(.2, 34, 90, .08));
    	
    	
    }
}

package org.usfirst.frc.team5980.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Position3SwitchOnlyLeft extends CommandGroup {

    public Position3SwitchOnlyLeft() {
    	addSequential(new DriveForwardAuto(.3, 175, 0, .08));
    	addSequential(new PauseAuto(2000));
    	addSequential(new RotateToHeading(.2, 90));
    	addSequential(new PauseAuto(2000));
    	addSequential(new DriveForwardAuto(.3, 150, 90, .08));
       
    }
}

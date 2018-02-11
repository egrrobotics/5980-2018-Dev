package org.usfirst.frc.team5980.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Position3SwitchOnlyLeft extends CommandGroup {

    public Position3SwitchOnlyLeft() {
    	addSequential(new DriveForwardAuto(.3, 195, 0, .08));
    	addSequential(new PauseAuto(2000));
    	addSequential(new RotateToHeading(90));
    	addSequential(new PauseAuto(2000));
    	addSequential(new DriveForwardAuto(.3, 170, 90, .08));
       
    }
}

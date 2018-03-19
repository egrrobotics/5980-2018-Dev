package org.usfirst.frc.team5980.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Position3DropLeftSwitch extends CommandGroup {

    public Position3DropLeftSwitch() {
    	
    	addSequential(new DriveForwardAuto(.4, 220, 0));//215, 135 
        addSequential(new RotateToHeading(90, .3)); 
        addSequential(new DriveForwardAuto(.3, 120, 90)); 
        addSequential(new RotateToHeading(117, .3)); 
        addSequential(new DriveForwardAuto(.4, 40, 117)); 
        addSequential(new TurretForTime(700, 1)); 
        addSequential(new IntakeForTime(2000, -1)); 
    }
}

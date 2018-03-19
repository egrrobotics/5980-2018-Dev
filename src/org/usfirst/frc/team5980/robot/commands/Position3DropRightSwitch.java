package org.usfirst.frc.team5980.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Position3DropRightSwitch extends CommandGroup {

    public Position3DropRightSwitch() {
    	 //addParallel(new ElevatorForTime(1500, .5)); // raise to be over switch wall
         //addParallel(new TurretForTime(1000, -.5)); // Turn turret towards switch
    	 //addSequential(new ElevatorForTime(1500, -.5));
    	// addParallel(new TurretForTime(1000, 1));
         addSequential(new DriveForwardAuto(.4, 150, 0)); // at the same time drive to the switc
         addParallel(new RotateToHeading(15, .3));
    	 addSequential(new TurretForTime(900, 1));
         addSequential(new IntakeForTime(2000, -1)); // shoots out cube
    }
}

package org.usfirst.frc.team5980.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Position1DropLeftSwitch extends CommandGroup {

    public Position1DropLeftSwitch() {
    	/*
       addParallel(new ElevatorForTime(1500, .5)); // raise to be over switch wall
       addParallel(new TurretForTime(1000, .5)); // Turn turret towards switch
       addSequential(new DriveForwardAuto(.5, 100, 0)); // at the same time drive to the switch
       addSequential(new IntakeForTime(2000, 1)); // shoots out cube
       */
    	 //addSequential(new ElevatorForTime(3500, -.5));
    	 addSequential(new DriveForwardAuto(.4, 150, 0)); // at the same time drive to the switche
    	 addParallel(new RotateToHeading(-15, .3));
    	 addSequential(new TurretForTime(900, -1));
    	  addSequential(new IntakeForTime(2000, -1)); // shoots out cube
    }
}

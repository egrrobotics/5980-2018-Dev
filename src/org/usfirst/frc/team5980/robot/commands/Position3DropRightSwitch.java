package org.usfirst.frc.team5980.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Position3DropRightSwitch extends CommandGroup {

    public Position3DropRightSwitch() {
    	 addParallel(new ElevatorForTime(1500, .5)); // raise to be over switch wall
         addParallel(new TurretForTime(1000, -.5)); // Turn turret towards switch
         addSequential(new DriveForwardAuto(.5, 100, 0)); // at the same time drive to the switch
         addSequential(new IntakeForTime(2000, 1)); // shoots out cube
    }
}

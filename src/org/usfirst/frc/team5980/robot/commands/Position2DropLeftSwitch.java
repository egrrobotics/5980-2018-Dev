package org.usfirst.frc.team5980.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Position2DropLeftSwitch extends CommandGroup {

    public Position2DropLeftSwitch() {
       addSequential(new DriveForwardAuto(.5, 50, 0));
       addSequential(new RotateToHeading(90, .5));
       addParallel(new ElevatorForTime(1500, .5));
       addParallel(new TurretForTime(1000, .5));
       addSequential(new DriveForwardAuto(.5, 50, 90));
       addSequential(new IntakeForTime(2000, 1));
    }
}

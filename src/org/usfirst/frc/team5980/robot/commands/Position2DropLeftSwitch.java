package org.usfirst.frc.team5980.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Position2DropLeftSwitch extends CommandGroup {

    public Position2DropLeftSwitch() {
       addSequential(new DriveForwardAuto(.3, 20, 0));
       addSequential(new RotateToHeading(35, .3));
       //addParallel(new ElevatorForTime(1500, .5));
       addParallel(new TurretForTime(350, -1));
       addSequential(new DriveForwardAuto(.4, 88, 35));
       addSequential(new IntakeForTime(2000, -1));
    }
}

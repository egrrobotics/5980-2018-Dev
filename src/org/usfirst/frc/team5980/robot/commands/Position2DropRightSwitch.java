package org.usfirst.frc.team5980.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Position2DropRightSwitch extends CommandGroup {

    public Position2DropRightSwitch() {
    	
    	addSequential(new DriveForwardAuto(.3, 20, 0));
        addSequential(new RotateToHeading(-35, .3));
        //addParallel(new ElevatorForTime(1500, .5));
        addParallel(new TurretForTime(400, 1));
        addSequential(new DriveForwardAuto(.4, 88, -35));
        addSequential(new IntakeForTime(2000, -1));
    }
}

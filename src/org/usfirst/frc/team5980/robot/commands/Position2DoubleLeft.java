package org.usfirst.frc.team5980.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Position2DoubleLeft extends CommandGroup {

    public Position2DoubleLeft() {
    	
    	
    	addSequential(new DriveForwardAuto(.3, 20, 0));
        addSequential(new RotateToHeading(35, .3));
        //addParallel(new ElevatorForTime(1500, .5));
        addParallel(new TurretForTime(350, -1));
        addSequential(new DriveForwardAuto(.4, 90, 35));
        addSequential(new IntakeForTime(1000, -1));
        addParallel(new ElevatorForTime(2500, .3));
    	addSequential(new DriveBackwardsAuto(.3, 35, 35));
    	
    	addSequential(new RotateToHeading(130, .35));
    	addSequential(new TurretForTime(1700, -1));
    	addParallel(new IntakeForTime(1300, 1));
    	addSequential(new DriveBackwardsAuto(.3, 10, 130));
    	
    	
    	addSequential(new DriveForwardAuto(.3, 20, 130));
    	/*
    	addSequential(new RotateToHeading(-130, .35));
    	addSequential(new ElevatorForTime(2200, -.7));
    	addSequential(new DriveBackwardsAuto(.3, 35, -130));
    	addSequential(new IntakeForTime(1000, -1));
    	*/
    	
    	
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}

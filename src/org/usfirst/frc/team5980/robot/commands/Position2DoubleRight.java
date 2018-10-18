package org.usfirst.frc.team5980.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Position2DoubleRight extends CommandGroup {

    public Position2DoubleRight() {
    	addSequential(new DriveForwardAuto(.5, 20, 0));
        addSequential(new RotateToHeading(-33, .5));
        //addParallel(new ElevatorForTime(1500, .5));
        addParallel(new TurretForTime(400, 1));
        addSequential(new DriveForwardAuto(.55, 88, -35));
        addSequential(new IntakeForTime(500, -1));
        
        addParallel(new ElevatorForTime(2500, .35));
    	addSequential(new DriveBackwardsAuto(.5, 35, -35));
    	
    	addSequential(new RotateToHeading(-125, .5));
    	addSequential(new TurretForTime(1700, 1));
    	addParallel(new IntakeForTime(1300, 1));
    	addSequential(new DriveBackwardsAuto(.5, 20, -130));
    	
    	addParallel(new IntakeForTime(400, 1));
    	addSequential(new DriveForwardAuto(.5, 13, -130));
    	addSequential(new RotateToHeading(-35, .5));
    	addSequential(new ElevatorForTime(2000, -.8));
    	addParallel(new ElevatorForTime(1400, -.5));
    	addSequential(new TurretForTime(1400, -1));
    	addParallel(new ElevatorForTime(1750, -.5));
    	addSequential(new DriveForwardAuto(.6, 47, -35));
    	addSequential(new IntakeForTime(1300, -1));
    	
    	/*
    	addSequential(new RotateToHeading(-178, .35));
    	addSequential(new ElevatorForTime(2200, -.7));
    	addSequential(new DriveBackwardsAuto(.3, 60, -178));
    	addSequential(new IntakeForTime(1000, -1));*/
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

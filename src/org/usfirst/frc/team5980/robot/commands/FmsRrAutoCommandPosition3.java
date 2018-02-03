package org.usfirst.frc.team5980.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class FmsRrAutoCommandPosition3 extends CommandGroup {

    public FmsRrAutoCommandPosition3() {
       
    	/* Place cube on right side of switch, grab cube behind switch, place cube on scale
    	 * (Denoted by all commands)
    	 * or
    	 * Place cube on right scale
    	 * (Denoted by all commands without "//")
    	
    	addSequential(new DriveForwardAutoCommand(power, distance, heading));
    	//addSequential(new TurretCommand(spin));
    	//addParallel(new ElevatorLiftCommand(lift for time));
    	//addSequential(new DropCubeCommand(power));
    	//addSequential(new DriveForwardsAutoCommand(p, d, h));
    	//addParallel(new ElevatorDropCommand(drop for time));
    	
    	//addSequential(new RotateToHeadingCommand(h, p));
    	//addSequential(new DriveForwardAutoCommand(p, d, h));
    	//addParallel(new GrabCubeCommand(power));
    	//addSequential(new DriveBackwardsCommand(p, d, h));
    	//addSequential(new RotateToHeadingCommand(h, p));
    	
    	//addSequential(new DriveForwardAutoCommand(p, d, h));
    	addSequential(new TurretCommand(spin));
    	addParalllel(new ElevatorLiftCommand(lift for time)); 
    	addSequential(new DropCubeCommand(power));
    	 */
    	addSequential(new DriveForwardAuto(.3, 136, 0, .000125));
    	addSequential(new PauseAuto(1000));
    	addSequential(new DriveForwardAuto(.3, 18, 0, .000125));
    	addSequential(new PauseAuto(2000));
    	addSequential(new DriveForwardAuto(.3, 36, 0, .000125));
    }
}

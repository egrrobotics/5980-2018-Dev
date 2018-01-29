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
    	//addSequential(new RotateToHeadingCommand(heading, power));
    	//addSequential(new DriveForwardAutoCommand(p, d, h));
    	//addParallel(new ElevatorLiftCommand(lift for time));
    	//addSequential(new DropCubeCommand(power));
    	//addSequential(new DriveBackwardsAutoCommand(p, d, h));
    	//addParallel(new ElevatorDropCommand(drop for time));
    	
    	//addSequential(new DriveForwardAutoCommand(p, d, h));
    	//addSequential(new RotateToHeadingCommand(h, p));
    	//addSequential(new DriveForwardAutoCommand(p, d, h));
    	//addParallel(new GrabCubeCommand(power));
    	//addSequential(new DriveBackwardsCommand(p, d, h));
    	//addSequential(new RotateToHeadingCommand(h, p));
    	
    	//addSequential(new DriveForwardAutoCommand(p, d, h));
    	addSequential(new RotateToHeadingCommand(h, p));
    	addSequential(new DriveForwardAutoCommand(p, d, h));
    	addParalllel(new ElevatorLiftCommand(lift for time)); 
    	addSequential(new DropCubeCommand(power));

    	 */

    }
}

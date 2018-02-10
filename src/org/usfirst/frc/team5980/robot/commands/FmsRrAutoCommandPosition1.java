package org.usfirst.frc.team5980.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class FmsRrAutoCommandPosition1 extends CommandGroup {

    public FmsRrAutoCommandPosition1() {
    	/*Go behind switch to place cube in the right switch side, pick up another cube
        *    
        addSequential(new DriveForwardAuto(power, distance, heading));
        addSequential(new RotateToHeading(heading, power));
        addSequential(new DriveForwardAuto(power, distance, heading));
        addSequential(new TurretCommand(spin susan spin));
        addParallel(new ElevatorLiftCommand(lift));
        addSequential(new PauseAuto(chill susan));
        addSequential(new DropCubeCommand(spit it out susan));
        
        addSequential(new DriveBackwardsAuto(power, distance, heading));
        addSequential(new ElevatorDropCommand(down));
        addSequential(new CubeGrabCommand(getit));
        */
    	addSequential(new DriveForwardAuto(.3, 310, 0, .08));
    	addSequential(new PauseAuto(2000));
    	addSequential(new RotateToHeading(.3, -60));
    	addSequential(new PauseAuto(500));
    	addSequential(new DriveForwardAuto(.3, 15, 0, .08));
    	
    	
    }
}

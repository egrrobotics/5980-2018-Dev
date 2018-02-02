package org.usfirst.frc.team5980.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class FmsRlAutoCommandPosition2 extends CommandGroup {

    public FmsRlAutoCommandPosition2() {
    	/* Place a cube on the left side scale
    	 * OR
    	 * Place a cube on the right side switch
    	 * 
         addSequential(new DriveForwardAuto(power, distance, heading));
         addSequential(new RotateToHeading(heading, power)); //left
         addSequential(new DriveForwardAuto(power, distance, heading)); //to the left
         addSequential(new RotateToHeading(heading, power)); //forward
         addSequential(new DriveForwardAuto(power, distance, heading)); //forwards
         addParallel(new ElevatorLiftCommand(lift));
         addParallel(new TurretCommand(spin susan));
         addSequential(new PauseAuto(pause time));
         addSequential(new DropCubeCommand(bye cube));
         *
         *
         addSequential(new DriveForwardAuto(power, distance, heading));
         addSequential(new RotateToHeading(heading, power));
         addSequential(new DriveForwardAuto(power, distance, heading));
         addParallel(new TurretCommand(spin)); //rotate to the left, robot facing right
         addParallel(new ElevatorLift(woo)); 
         addSequential(new DropCubeCommand(bye cube));
         */ 
    }
}

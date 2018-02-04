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
         */
    	 addSequential(new DriveCommand(.3, 100, 0));
    	 //addSequential(new PauseAuto(2000));
         //addSequential(new RotateToHeading(.3, -45)); //right
         //addSequential(new DriveForwardAuto(.3, 10, -45, 0)); //to the right
         //addSequential(new PauseAuto(2000));
         //addSequential(new RotateToHeading(.3, -360));
         //addSequential(new PauseAuto(2000));
         //addSequential(new DriveCommand(.3, -15, 0));
         //addSequential(new DriveForwardAuto(.3, 10, 0, 0));
         //addParallel(new TurretCommand(spin)); //rotate to the left, robot facing right
         //addParallel(new ElevatorLift(woo)); 
         //addSequential(new DropCubeCommand(bye cube));
         
    }
}

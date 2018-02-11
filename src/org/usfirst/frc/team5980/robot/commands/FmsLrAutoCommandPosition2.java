package org.usfirst.frc.team5980.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class FmsLrAutoCommandPosition2 extends CommandGroup {

    public FmsLrAutoCommandPosition2() {
        /* Place cube on the scale to the right, 
         * stay close to alliance wall to avoid other robots
         * OR
         * Place cube on the switch to the left
         * 
         addSequential(new DriveForwardAuto(power, distance, heading));
         addSequential(new RotateToHeading(heading, power)); //right
         addSequential(new DriveForwardAuto(power, distance, heading)); //to the right
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
         addParallel(new TurretCommand(spin)); //rotate to the right, robot facing left
         addParallel(new ElevatorLift(woo)); 
         addSequential(new DropCubeCommand(bye cube));
         */
    	addSequential(new TurretCommand(1000));
    }
}

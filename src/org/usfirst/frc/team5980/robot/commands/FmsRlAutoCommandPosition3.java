package org.usfirst.frc.team5980.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class FmsRlAutoCommandPosition3 extends CommandGroup {

    public FmsRlAutoCommandPosition3() {
    	/* Put cube on switch to the right
         * 
         * 
         addSequential(new DriveForwardAutoCommand(power, distance, heading));
         addSequential(new TurretCommand(power));
         addParallel(new ElevatorLiftCommand(lift));
         addSequential(new DropCubeCommand(power));
         addSequential(new DriveForwardAuto(power, distance, heading));
         * 
         */
    }
}

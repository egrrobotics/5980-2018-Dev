package org.usfirst.frc.team5980.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class FmsLlAutoCommandPosition1 extends CommandGroup {

    public FmsLlAutoCommandPosition1() {
    	
    	//addSequential(new DriveForwardToSwitch(5ft));
    	//addSequential(new DropCubeOnSwitchToRightOfBot());	
    	//addSequential(new DriveForward(1.5ft));
    	//addSequential(new PickupCubeRigthOfBot());
    	//addSequential(new DriveForwardToScale(3ft));
    	//addSequential(new DropCubeOnScaleToRightOfBot());
    	addSequential(new DriveForwardAuto(.3, 120, 0));
    	addSequential(new RotateToHeading(.1, 45));
    	addSequential(new DriveForwardAuto(.3, 120, 45));
    }

}

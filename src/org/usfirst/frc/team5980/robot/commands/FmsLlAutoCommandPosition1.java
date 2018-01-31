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
    	addSequential(new PauseAuto(2000));
    	addSequential(new DriveForwardAuto(.3, 136, 0));
    	addSequential(new PauseAuto(2000));
    	addSequential(new DriveForwardAuto(.3, 20, 0));
    }
}

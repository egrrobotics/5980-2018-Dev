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
    	
    	addSequential(new DriveForwardAuto(.3, 150, 0, .000125));
    	addSequential(new PauseAuto(1000));
    	addSequential(new DriveForwardAuto(.3, 50, 0, .000125));
    	addSequential(new PauseAuto(2000));
    	addSequential(new RotateToHeading(.2, -15));
    	addSequential(new DriveForwardAuto(.3, 50, -15, .000125));
    	addSequential(new RotateToHeading(.2, 0));
    	addSequential(new PauseAuto(500));
    	addSequential(new DriveForwardAuto(.3, 40, 0, .000125));
    }
}

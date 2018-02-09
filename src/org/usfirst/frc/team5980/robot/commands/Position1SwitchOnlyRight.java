package org.usfirst.frc.team5980.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Position1SwitchOnlyRight extends CommandGroup {

    public Position1SwitchOnlyRight() {
    	//addSequential(new DriveForwardAuto(.3, 190, 0, .000125));
    	//addSequential(new PauseAuto(300));
    	addSequential(new RotateToHeading(.2, 90));
    	//addSequential(new PauseAuto(300));
    	//addSequential(new DriveForwardAuto(.3, 150, -90, .000125));
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}

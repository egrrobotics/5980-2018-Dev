package org.usfirst.frc.team5980.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Position3ScaleOnlyRight extends CommandGroup {

    public Position3ScaleOnlyRight() {
        addSequential(new DriveForwardAuto(.4, 290, 0, .01));
    }
}

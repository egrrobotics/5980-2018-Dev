package org.usfirst.frc.team5980.robot.utils;

import org.usfirst.frc.team5980.robot.Robot;
import org.usfirst.frc.team5980.robot.commands.DriveForwardAuto;

import edu.wpi.first.wpilibj.command.Command;

public class GetAuton {
	Command autonCommand;
	public Command getAutonCommand() {
		autonCommand = new DriveForwardAuto(.5, 120, 0); //backup: crosses baseline if can't interpret switches and GameData
		if(Robot.autonSwitches.getPosition() == 1) {
			
		}
		
		if(Robot.autonSwitches.getPosition() == 2) {
			
		}
		
		if(Robot.autonSwitches.getPosition() == 3) {
			
		}
		return autonCommand;
	}
	
	public void DropLeftSwitch() {
		if(Robot.autonSwitches.getSwitchValues()[3] == false) 
		return;
		if(Robot.autonSwitches.getPosition() == 1 && Robot.gameData.NearSwitch == TeamSide.LEFT)
		autonCommand = 
		
		
	}

}

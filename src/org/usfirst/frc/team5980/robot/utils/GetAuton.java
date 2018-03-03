package org.usfirst.frc.team5980.robot.utils;

import org.usfirst.frc.team5980.robot.Robot;
import org.usfirst.frc.team5980.robot.commands.DriveForwardAuto;
import org.usfirst.frc.team5980.robot.commands.Position1DropLeftScale;
import org.usfirst.frc.team5980.robot.commands.Position1DropLeftSwitch;
import org.usfirst.frc.team5980.robot.commands.Position1DropRightSwitch;
import org.usfirst.frc.team5980.robot.commands.Position2DropLeftSwitch;
import org.usfirst.frc.team5980.robot.commands.Position2DropRightSwitch;
import org.usfirst.frc.team5980.robot.commands.Position3DropLeftSwitch;
import org.usfirst.frc.team5980.robot.commands.Position3DropRightScale;
import org.usfirst.frc.team5980.robot.commands.Position3DropRightSwitch;

import edu.wpi.first.wpilibj.command.Command;

public class GetAuton {
	Command autonCommand;
	public Command getAutonCommand() {
		autonCommand = new DriveForwardAuto(.5, 120, 0); //backup: crosses baseline if can't interpret switches and GameData
		if(Robot.autonSwitches.getPosition() == 1) {
			this.DropLeftSwitch();
			this.DropLeftScale();
			this.DropRightSwitch(); 
		}
		
		if(Robot.autonSwitches.getPosition() == 2) {
			this.DropLeftSwitch();
			this.DropRightSwitch();
		}
		
		if(Robot.autonSwitches.getPosition() == 3) {
			this.DropRightSwitch();
			this.DropRightScale();
			this.DropLeftSwitch();
		}
		return autonCommand;
	}
	
	public void DropLeftSwitch() {
		if(autonCommand != null)
			return;
		if(Robot.autonSwitches.getSwitchValues()[3] == false) 
			return;
		if(Robot.autonSwitches.getPosition() == 1 && Robot.gameData.NearSwitch == TeamSide.LEFT) {
			autonCommand = new Position1DropLeftSwitch();
			return;
		}
		if(Robot.autonSwitches.getPosition() == 3 && Robot.gameData.NearSwitch == TeamSide.LEFT) {
			autonCommand = new Position3DropLeftSwitch();
			return;
		}
		if(Robot.autonSwitches.getPosition() == 2 && Robot.gameData.NearSwitch == TeamSide.LEFT) {
			autonCommand = new Position2DropLeftSwitch();
			return;
		}
		
	}
	
	public void DropLeftScale() {
		if(autonCommand != null)
			return;
		if(Robot.autonSwitches.getSwitchValues()[4] == false)
			return;
		if(Robot.autonSwitches.getPosition() == 1 && Robot.gameData.Scale == TeamSide.LEFT) {
			autonCommand = new Position1DropLeftScale();
			return;
		}
	}
	
	public void DropRightSwitch() {
		if(autonCommand != null) 
			return;
		if(Robot.autonSwitches.getSwitchValues()[5] == false)
			return;
		if(Robot.autonSwitches.getPosition() == 1 && Robot.gameData.NearSwitch == TeamSide.RIGHT) {
			autonCommand = new Position1DropRightSwitch();
			return;
		}
		if(Robot.autonSwitches.getPosition() == 3 && Robot.gameData.NearSwitch == TeamSide.LEFT) {
			autonCommand = new Position3DropRightSwitch();
			return;
		}
		if(Robot.autonSwitches.getPosition() == 2 && Robot.gameData.NearSwitch == TeamSide.RIGHT) {
			autonCommand = new Position2DropRightSwitch();
			return;
		}
	}
	
	public void DropRightScale() {
		if(autonCommand != null)
			return;
		if(Robot.autonSwitches.getSwitchValues()[6] == false) 
			return;
		if(Robot.autonSwitches.getPosition() == 3 && Robot.gameData.Scale == TeamSide.RIGHT) {
			autonCommand = new Position3DropRightScale();
			return;
		}
			
	}

}

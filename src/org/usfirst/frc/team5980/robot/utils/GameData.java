package org.usfirst.frc.team5980.robot.utils;

import edu.wpi.first.wpilibj.DriverStation;

public class GameData {
	public TeamSide NearSwitch = TeamSide.NA;
	public TeamSide Scale = TeamSide.NA;
	public TeamSide FarSwitch = TeamSide.NA;
	
	public GameData(String gameData) {	
		if (gameData != null && gameData != "")
			this.parseGameData(gameData);
	}
	
	public GameData( ) {		
	}
	
	public void pullGameData() {	
		String gameData = "";
		int loopLimit = 1000;
		
		while (gameData.length() == 0 && loopLimit-- > 0) {
			gameData = DriverStation.getInstance().getGameSpecificMessage();	
		}
		
		this.parseGameData(gameData);
	}
	
	public void parseGameData(String gameData) {
		if (gameData == null || gameData.length() == 0) {
			System.out.println("--> COULD NOT READ GAME DATA");
			return;
		}
		
		System.out.println("--> Read game data: '" + gameData + "'");

		if (gameData.charAt(0) == 'L') 
			this.NearSwitch = TeamSide.LEFT;
		else 
			this.NearSwitch = TeamSide.RIGHT;

		if (gameData.charAt(1) == 'L')
			this.Scale = TeamSide.LEFT;
		else 
			this.Scale = TeamSide.RIGHT;

		if (gameData.charAt(2) == 'L')
			this.FarSwitch = TeamSide.LEFT;
		else 
			this.FarSwitch = TeamSide.RIGHT;		
	}
}

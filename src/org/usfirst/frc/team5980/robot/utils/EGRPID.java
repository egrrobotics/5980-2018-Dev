package org.usfirst.frc.team5980.robot.utils;

public class EGRPID {
	public double kp, ki, kd, target;
	public double lastError = 0;
	public double totalError = 0;
	public double error = 0;
	public EGRPID(double kp, double ki, double kd) {
		this.kp = kp;
		this.ki = ki;
		this.kd = kd;
	}
	
	public void setTarget(double target) {
		this.target = target;
	}
	
	public double getCorrection(double current) {
		error = target - current;
		totalError = 0.8*totalError + error;
		//if (lastError * error <= 0) totalError = 0;
		double changeInError = error - lastError;
		double correction = kp * error + ki * totalError + kd * changeInError;
		lastError = error;
		return correction;
	}

}

// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.LimeLight;

public class AutoCenter extends Command {
// Instance Variables
private double hypot = 0;
private double turnAngle = 0;
private double orientationAngle = 90 - turnAngle;
private double xDisp = 0;
private double zDisp = 0;

  /** Creates a new DriveTrain. */
  private final SwerveMod FL = new SwerveMod(
  Constants.frontLeftDrive,
  Constants.frontLeftTurn,
  Constants.frontLeftCanCoder, 
  new PIDController(Constants.kp, Constants.ki, Constants.kd)); // will pid constants be different for each module?

  private final SwerveMod BL = new SwerveMod(
  Constants.backLeftDrive,
  Constants.backLeftTurn,
  Constants.backLeftCanCoder, 
  new PIDController(Constants.kp, Constants.ki, Constants.kd)); 
 
  private final SwerveMod FR = new SwerveMod(
  Constants.frontRightDrive,
  Constants.frontRightTurn,
  Constants.frontRightCanCoder, 
  new PIDController(Constants.kp, Constants.ki, Constants.kd)); 
  
  private final SwerveMod BR = new SwerveMod(
  Constants.backRightDrive,
  Constants.backRightTurn,
  Constants.backRightCanCoder, 
  new PIDController(Constants.kp, Constants.ki, Constants.kd));  

  /** Creates a new AutoCenter. */
  public AutoCenter(double hypot, double turnAngle) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.hypot = hypot;
    this.turnAngle = turnAngle;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    LimeLight limeLight = new LimeLight(); // new limelight object
    xDisp = limeLight.calculateXdistance();
    zDisp = limeLight.calculateZdistance();
    
    // tell the motors to move & turn
    setMotorSpeed_Angle(0, turnAngle);
    setMotorSpeed_Angle(.2, 0);
    setMotorSpeed_Angle(0, orientationAngle);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(xDisp == 0 && zDisp == 0) {
      return true;
    } else {
      return false;
    }
  }

  public void setMotorSpeed_Angle(double speed, double angle) { // move to DriveTrain
    BR.drive(speed, angle); //off by about 32 degrees
    BL.drive(speed, angle);
    FR.drive(speed, angle);
    FL.drive(speed, angle);  
  }
}

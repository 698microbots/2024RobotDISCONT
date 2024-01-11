// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase {

  private final TalonFX Rmotor = new TalonFX(0);
  private final TalonFX Lmotor = new TalonFX(1);
  

  /** Creates a new DriveTrain. */
  public DriveTrain() {
  }

  public void setRightMotor(double speed) {
    
    Rmotor.set(ControlMode.PercentOutput, speed);

  }

  public void setLeftMotor(double speed) {
    Lmotor.set(ControlMode.PercentOutput, speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

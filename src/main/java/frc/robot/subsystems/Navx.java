// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.I2C;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
public class Navx extends SubsystemBase {
    private AHRS navX = new AHRS(I2C.Port.kMXP); // I2C.Port.kMXP is the port that connects to the RoboRio

    public double getXPosition() {
        return navX.getDisplacementX();
    }

    public double getYaw() { // yaw a.k.a. angle
        return navX.getAngle();
    }
}
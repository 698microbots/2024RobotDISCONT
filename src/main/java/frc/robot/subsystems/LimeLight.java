// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class LimeLight extends SubsystemBase {

  // creates the instance variables for the LimeLight Subsystem
  private NetworkTable limeLight;
  private NetworkTableEntry V_angle, H_angle, hasTargets, botPose, aprilID;
  private double[] aprilTagList;
  private double zDistance;
  private double xDistance;

  /** Creates a new LimeLight. */
  public LimeLight() {
    limeLight = NetworkTableInstance.getDefault().getTable("limelight");

    V_angle = limeLight.getEntry("ty");
    H_angle = limeLight.getEntry("tx");
    hasTargets = limeLight.getEntry("tv");
    botPose = limeLight.getEntry("botPose");
    aprilID = limeLight.getEntry("tid");
  }
  // getters
  public double hasTargets(){
    return hasTargets.getDouble(0);
  }
  public double getV_angle(){
    return V_angle.getDouble(0);
  }
  public double getH_angle(){
    return H_angle.getDouble(0);
  }
  public double getBotPose(){
    aprilTagList = botPose.getDoubleArray(new double[6]);
    return aprilTagList[0];
    
  }
  public double getaprilTagID(){
    return aprilID.getDouble(0);

  }

  // setters
  public void setPipeline(int pipe){
    limeLight.getEntry("pipeline").setNumber(pipe); 
   }
   //0: AprilTag
   //1: Reflective
   //2: Zoomed In
  
  public double calculateZdistance(){//Z direction is foward from the robot
    zDistance = ((Constants.goalHeight-Constants.limeLightHeight)/(Math.tan(Math.toRadians(getV_angle()+Constants.limeLightInitAngle))));
    return zDistance;
  }

  public double calculateXdistance(){//X direction is sideways from the robot
    xDistance = calculateZdistance()*Math.tan(Math.toRadians(getH_angle()));
    return xDistance;
  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    calculateXdistance();
    calculateZdistance();
  }
}

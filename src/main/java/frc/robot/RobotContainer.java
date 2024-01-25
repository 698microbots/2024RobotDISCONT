// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.hal.FRCNetComm.tResourceType;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.subsystems.*;
import frc.robot.commands.*;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;


/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in
 * the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of
 * the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  public XboxController xboxController = new XboxController(0); // new XBox object
  public final AHRS navX = new AHRS(SerialPort.Port.kUSB); // new NavX Object

  // The robot's subsystems and commands are defined here...
  //button definitions
  private final JoystickButton Xbutton = new JoystickButton(xboxController, Constants.Xbox_Button_X);
  private final JoystickButton Ybutton = new JoystickButton(xboxController, Constants.Xbox_Button_Y);
  private final JoystickButton Abutton = new JoystickButton(xboxController, Constants.Xbox_Button_A);
  private final JoystickButton Bbutton = new JoystickButton(xboxController, Constants.Xbox_Button_B);
  private final JoystickButton RBbutton = new JoystickButton(xboxController, Constants.Xbox_Button_RB);
  private final JoystickButton LBbutton = new JoystickButton(xboxController, Constants.Xbox_Button_LB);

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be
   * created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with
   * an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for
   * {@link
   * CommandXboxController
   * Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or
   * {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {

    // if (xboxController.getAButton()) {
    //     flywheel.setFlywheelMotorSpeed(1 ); // set the motor speed to the desired speed
    //     // add code here that waits for some time before turning the motors off.
    //   // }
    // }
    Abutton.onTrue(new SetFlywheelMotor());
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return Autos.exampleAuto(m_exampleSubsystem);
  }
}

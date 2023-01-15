// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


import java.util.HashMap;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.DriveSnapRotation;
import frc.robot.commands.Forward12Command;
import frc.robot.commands.Juke;
import frc.robot.commands.Rotate11Command;
import frc.robot.commands.ZeroGyroscope;
import frc.robot.shuffleboard.ConstantsIO;
import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.subsystems.Forward12;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Rotate11;
import frc.robot.subsystems.Shooter;
import frc.robot.util.AutoChooser;
import frc.robot.util.CustomXboxController;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  
  private final DrivetrainSubsystem mDrivetrainSubsystem = new DrivetrainSubsystem();
  private final Intake mIntake = new Intake();
  private final Shooter mShooter = new Shooter();
  private final Forward12 mForward12 = new Forward12();
  private final Rotate11 mRotate11 = new Rotate11();
  ConstantsIO mConstantsIO = ConstantsIO.getInstance();

  private final CustomXboxController mPilot = new CustomXboxController(0);

  private HashMap<String, Pose2d> mPointPositionMap;
  private AutoChooser autoChooser = new AutoChooser(mDrivetrainSubsystem, mIntake, mShooter);

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    mDrivetrainSubsystem.setDefaultCommand(new DriveSnapRotation(
            mDrivetrainSubsystem,
            () -> -modifyAxis(mPilot.getLeftY()) * DrivetrainSubsystem.MAX_VELOCITY_METERS_PER_SECOND,
            () -> -modifyAxis(mPilot.getLeftX()) * DrivetrainSubsystem.MAX_VELOCITY_METERS_PER_SECOND,
            () -> -modifyAxis(mPilot.getRightX()) * DrivetrainSubsystem.MAX_ANGULAR_VELOCITY_RADIANS_PER_SECOND,
            () -> -modifyAxis(mPilot.getRightY()) * DrivetrainSubsystem.MAX_ANGULAR_VELOCITY_RADIANS_PER_SECOND,
            mDrivetrainSubsystem.getSnapController()
    ));
    /*mDrivetrainSubsystem.setDefaultCommand(new DefaultDriveCommand(
            mDrivetrainSubsystem,
            () -> -modifyAxis(mPilot.getLeftY()) * DrivetrainSubsystem.MAX_VELOCITY_METERS_PER_SECOND,
            () -> -modifyAxis(mPilot.getLeftX()) * DrivetrainSubsystem.MAX_VELOCITY_METERS_PER_SECOND,
            () -> -modifyAxis(mPilot.getRightX()) * DrivetrainSubsystem.MAX_ANGULAR_VELOCITY_RADIANS_PER_SECOND
    ));*/
    mPointPositionMap = new HashMap<>();
    mPointPositionMap.put("A", new Pose2d(0, 0, new Rotation2d(Math.toRadians(0.0))));
    configureTeleopBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  public void configureTeleopBindings() {
    //mPilot.getYButtonObject().onTrue(new ResetDrivePose(mDrivetrainSubsystem, 0.0, 0.0, 0.0));
    //mPilot.getYButtonObject().onTrue(new ZeroGyroscope(mDrivetrainSubsystem));
    //mPilot.getAButtonObject().whileTrue(new Juke(mDrivetrainSubsystem));
    mPilot.getLeftTriggerObject().whileTrue(new Forward12Command(mForward12));
    mPilot.getRightTriggerObject().onTrue(new Rotate11Command(mRotate11));
    //mPilot.getAButtonObject().whileActiveContinuous(new DriveAtPath(mDrivetrainSubsystem, new Trajectory(mPointPositionMap.get("A")), mPointPositionMap.get("A").getRotation()));
    System.out.println("Teleop Bindings Configured");
  }

  public void configureTestBindings(){
    System.out.println("Test Bindings Configured");
  }
  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return autoChooser.getSelected();
  }

  private static double deadband(double value, double deadband) {
    if (Math.abs(value) > deadband) {
      if (value > 0.0) {
        return (value - deadband) / (1.0 - deadband);
      } else {
        return (value + deadband) / (1.0 - deadband);

      }
    } else {
      return 0.0;
    }
  }

  private static double modifyAxis(double value) {
    // Deadband
    value = deadband(value, 0.1);

    // Square the axis
    value = Math.copySign(value * value, value);

    //"Stage" mode
    //value = Math.round(value * 5.0)/5.0;

    return value;
  }

  public XboxController getPilot(){
    return mPilot;
  }
}

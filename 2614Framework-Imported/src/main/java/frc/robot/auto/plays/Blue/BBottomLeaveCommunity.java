package frc.robot.auto.plays.Blue;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.DriveAtPath;
import frc.robot.commands.ResetDrivePose;
import frc.robot.commands.ZeroGyroscope;
import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.util.AutoChooser;

public class BBottomLeaveCommunity extends SequentialCommandGroup{
    public BBottomLeaveCommunity(DrivetrainSubsystem drivetrain){
        addRequirements(drivetrain);

        Trajectory LeaveCommunity = AutoChooser.openTrajectoryFile("BLUE_TopMarkerP1.wpilib.json");
        addCommands(
            new ZeroGyroscope(drivetrain, 0).withTimeout(0.1),
            new ResetDrivePose(drivetrain, 1.81, 4.37, 0),
            new DriveAtPath(drivetrain, LeaveCommunity, 0, 10)
        );
    }
}

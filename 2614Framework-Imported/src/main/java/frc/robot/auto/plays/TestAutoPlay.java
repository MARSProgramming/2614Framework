package frc.robot.auto.plays;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.DriveAtPath;
import frc.robot.commands.ResetDrivePose;
import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.util.AutoChooser;

public class TestAutoPlay extends SequentialCommandGroup{
    private DrivetrainSubsystem mDrivetrain;
    public TestAutoPlay(DrivetrainSubsystem drivetrain){
        mDrivetrain = drivetrain;
        addRequirements(drivetrain);

        Trajectory testTrajectory = AutoChooser.openTrajectoryFile("testSpinPath.wpilib.json");
        addCommands(
            new ResetDrivePose(mDrivetrain, 2, 2, 0),
            new DriveAtPath(mDrivetrain, testTrajectory, new Rotation2d(180.0))
        );
    }
}

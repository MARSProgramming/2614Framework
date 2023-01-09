package frc.robot.auto.plays;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.DriveAtPath;
import frc.robot.commands.IntakeCommand;
import frc.robot.commands.ResetDrivePose;
import frc.robot.commands.ShooterCommand;
import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;
import frc.robot.util.AutoChooser;

public class TestAutoPlay extends SequentialCommandGroup{
    private DrivetrainSubsystem mDrivetrain;
    private Intake mIntake;
    private Shooter mShooter;
    public TestAutoPlay(DrivetrainSubsystem drivetrain, Intake take, Shooter shooter){
        mDrivetrain = drivetrain;
        mIntake = take;
        mShooter = shooter;
        addRequirements(drivetrain);

        Trajectory lPath1 = AutoChooser.openTrajectoryFile("LPath.wpilib.json");
        Trajectory lPath2 = AutoChooser.openTrajectoryFile("LPathPart2.wpilib.json");
        addCommands(
            new ResetDrivePose(mDrivetrain, 2, 2, 0),
            new ParallelCommandGroup(
                new DriveAtPath(mDrivetrain, lPath1, new Rotation2d(90.0)), new ShooterCommand(mShooter, 2.3)
            ),
            new ShooterCommand(mShooter, 2.0),
            new ParallelCommandGroup(
                new DriveAtPath(mDrivetrain, lPath2, new Rotation2d(90.0)), new ShooterCommand(mShooter, 2.0)
            ),
            new ShooterCommand(mShooter, 2.0)
        );
    }
}

package frc.robot.auto.plays;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.DriveAtPath;
import frc.robot.commands.ResetDrivePose;
import frc.robot.commands.ShooterCommand;
import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;
import frc.robot.util.AutoChooser;

public class TestAutoPlay extends SequentialCommandGroup{
    private DrivetrainSubsystem mDrivetrain;
    private Shooter mShooter;
    public TestAutoPlay(DrivetrainSubsystem drivetrain, Intake take, Shooter shooter){
        mDrivetrain = drivetrain;
        mShooter = shooter;
        addRequirements(drivetrain);

        Trajectory part1 = AutoChooser.openTrajectoryFile("COneConePart1.wpilib.json");
        Trajectory part2 = AutoChooser.openTrajectoryFile("COneConePart2.wpilib.json");
        addCommands(
            new ResetDrivePose(mDrivetrain, 1.93, 0.89, 0),
                //endRotation is in radians
            new DriveAtPath(mDrivetrain, part1, (0.0), 5),
            new ShooterCommand(mShooter, 3.0),
            new DriveAtPath(mDrivetrain, part2, (0.0), 5)
        );
    }
}

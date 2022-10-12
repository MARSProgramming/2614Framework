package frc.robot.auto.plays;

import java.io.IOException;
import java.nio.file.Path;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.math.trajectory.TrajectoryUtil;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Filesystem;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.DriveAtPath;
import frc.robot.commands.ResetDrivePose;
import frc.robot.subsystems.DrivetrainSubsystem;

public class TestAutoPlay extends SequentialCommandGroup{
    private DrivetrainSubsystem mDrivetrain;
    public TestAutoPlay(DrivetrainSubsystem drivetrain){
        mDrivetrain = drivetrain;
        addRequirements(drivetrain);

        Trajectory testTrajectory = openTrajectoryFile("testpath.wpilib.json");
        addCommands(
            new ResetDrivePose(mDrivetrain, 7.478, 1.736, 272.5),
            new DriveAtPath(mDrivetrain, testTrajectory, new Rotation2d(0.0))
        );
    }

    public Trajectory openTrajectoryFile(String name){
        try{
            Trajectory t = new Trajectory();
            Path path = Filesystem.getDeployDirectory().toPath().resolve("paths/output/" + name);
            t = TrajectoryUtil.fromPathweaverJson(path);
            return t;
        }
        catch(IOException ex){
            DriverStation.reportError("Unable to open trajectory: " + name, ex.getStackTrace());
            return null;
        }
    }
}

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
import frc.robot.subsystems.DrivetrainSubsystem;

public class TestAutoPlay extends SequentialCommandGroup{
    private DrivetrainSubsystem mDrivetrain;
    public TestAutoPlay(DrivetrainSubsystem drivetrain){
        mDrivetrain = drivetrain;
        addRequirements(drivetrain);

        Trajectory testTrajectory = new Trajectory();
        openTrajectoryFile("testpath.wpilib", testTrajectory);
        addCommands(
            new DriveAtPath(mDrivetrain, testTrajectory, new Rotation2d(0.0))
        );
    }

    public void openTrajectoryFile(String name, Trajectory trajectory){
        try{
            Path path = Filesystem.getDeployDirectory().toPath().resolve(name);
            trajectory = TrajectoryUtil.fromPathweaverJson(path);
        }
        catch(IOException ex){
            DriverStation.reportError("Unable to open trajectory: " + name, ex.getStackTrace());
        }
    }
}

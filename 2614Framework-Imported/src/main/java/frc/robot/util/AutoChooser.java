package frc.robot.util;

import java.io.IOException;
import java.nio.file.Path;

import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.math.trajectory.TrajectoryUtil;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Filesystem;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.auto.plays.DoNothing;
import frc.robot.auto.plays.TestAutoPlay;
import frc.robot.auto.plays.Blue.BBottomLeaveCommunity;
import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;

public class AutoChooser {
    private ShuffleboardTab preMatch;
    private SendableChooser<Command> autoChooser;
    
    public AutoChooser(DrivetrainSubsystem mDrivetrainSubsystem, Intake mIntake, Shooter mShooter){
        preMatch = Shuffleboard.getTab("Pre-Match");
        autoChooser = new SendableChooser<>();

        //auto plays
        autoChooser.setDefaultOption("Do Nothing", new DoNothing());
        autoChooser.addOption("Blue Bottom Leave Community", new BBottomLeaveCommunity(mDrivetrainSubsystem));
        
        
        preMatch.add(autoChooser).withSize(2, 1).withPosition(0, 0);
    }

    public Command getSelected(){
        return autoChooser.getSelected();
    }

    public static Trajectory openTrajectoryFile(String name){
        try{
            Trajectory t = new Trajectory();
            Path path = Filesystem.getDeployDirectory().toPath().resolve("pathplanner/generatedJSON/" + name);
            t = TrajectoryUtil.fromPathweaverJson(path);
            return t;
        }
        catch(IOException ex){
            DriverStation.reportError("Unable to open trajectory: " + name, ex.getStackTrace());
            return null;
        }
    }
}

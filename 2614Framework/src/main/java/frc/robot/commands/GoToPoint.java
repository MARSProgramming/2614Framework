package frc.robot.commands;

import java.util.HashMap;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DrivetrainSubsystem;

public class GoToPoint extends CommandBase{
    public enum DrivePoint{
        A,
        B,
        C,
        D
    };

    private DrivetrainSubsystem mDrivetrain;
    private DrivePoint mPoint;
    private HashMap<DrivePoint, Pose2d> mPointPositionMap;
    public GoToPoint(DrivetrainSubsystem drive, DrivePoint point){
        mDrivetrain = drive;
        mPointPositionMap = new HashMap<>();
        addRequirements(drive);
    }

    @Override
    public void initialize(){
        
    }
}

package frc.robot.auto.plays;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.ResetDrivePose;
import frc.robot.subsystems.DrivetrainSubsystem;

public class CNothing extends SequentialCommandGroup{
    private DrivetrainSubsystem mDrivetrain;
    public CNothing(DrivetrainSubsystem drivetrain){
        addRequirements(drivetrain);

        addCommands(
            new ResetDrivePose(mDrivetrain, 1.93, 0.89, 0)
        );
    }
}

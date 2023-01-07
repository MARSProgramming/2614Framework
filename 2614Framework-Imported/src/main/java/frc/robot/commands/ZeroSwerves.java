package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DrivetrainSubsystem;

public class ZeroSwerves extends CommandBase{
    private DrivetrainSubsystem mSub;
    public ZeroSwerves(DrivetrainSubsystem sub){
        mSub = sub;
        addRequirements(sub);
    }
    @Override
    public void initialize() {
        mSub.zeroSwerves(true);
    }
}

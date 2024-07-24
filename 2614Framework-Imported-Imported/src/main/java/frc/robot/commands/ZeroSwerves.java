package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DrivetrainSubsystem;

public class ZeroSwerves extends Command{
    private DrivetrainSubsystem mSub;
    public ZeroSwerves(DrivetrainSubsystem sub){
        mSub = sub;
    }
    @Override
    public void initialize() {
        mSub.zeroSwerves(true);
    }
    @Override
    public void execute(){
        mSub.zeroSwerves(true);
    }
    @Override
    public void end(boolean interrupted){
        mSub.zeroSwerves(true);
    }
}

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DrivetrainSubsystem;

public class ZeroGyroscope extends Command{
    private DrivetrainSubsystem mDT;
    public ZeroGyroscope(DrivetrainSubsystem dt){
        mDT = dt;
        addRequirements(dt);
    }

    @Override
    public void initialize(){
        mDT.zeroGyroscope(0);
    }
}

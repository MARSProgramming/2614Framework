package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DrivetrainSubsystem;

public class Juke extends CommandBase{
    private DrivetrainSubsystem dt;
    private DriveSnapRotation pivot;

    public Juke(DrivetrainSubsystem drivetrain){
        dt = drivetrain;
        pivot = new DriveSnapRotation(dt, () -> 0.0, () ->0.0, () ->0.0, () -> -1.0, dt.getSnapController());
        addRequirements(dt);
    }

    @Override
    public void initialize(){
        pivot.initialize();
        dt.setPivot(true);
    }

    @Override
    public void execute(){
        pivot.execute();
    }

    @Override
    public void end(boolean interrupted){
        pivot.end(false);
        dt.setPivot(false);
    }
}

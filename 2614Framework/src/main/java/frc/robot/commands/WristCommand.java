package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.WristMotor;

public class WristCommand extends CommandBase{
    private WristMotor mWristMotor;
    public WristCommand(WristMotor wristmotor,
                               DoubleSupplier rotationXSupplier){
        this.mWristMotor = wristmotor;
        mWristMotor.runPVoltage(rotationXSupplier.getAsDouble());
    }
    
    @Override
    public void initialize() {
      
    }
    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        mWristMotor.runPVoltage(0.5);
    }
    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        mWristMotor.runPVoltage(0);
    }
  }



















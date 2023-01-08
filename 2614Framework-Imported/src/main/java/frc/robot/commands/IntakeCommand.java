package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;

public class IntakeCommand extends CommandBase {
    private Intake mIntake;
    Timer mTimer;
    double mTimeout;  
    public IntakeCommand(Intake i, double timeout) {
        mIntake = i;
        addRequirements(i);
        mTimer = new Timer();
        mTimeout = timeout;
    }

    @Override
    public void initialize() {
        mIntake.extend();
        mTimer.start();
    }
  
    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        mIntake.runPVoltage(0.4);
    }
  
    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        mIntake.retract();
        mIntake.runPVoltage(0);
        
    }
    @Override
    public boolean isFinished() {
    return mTimer.get() > mTimeout;
  }
}

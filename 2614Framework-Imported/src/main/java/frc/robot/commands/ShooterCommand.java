package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter;

public class ShooterCommand extends CommandBase {
    private Shooter mShooter;
    Timer mTimer;
    double mTimeout;  
    public ShooterCommand(Shooter i, double timeout) {
        mShooter = i;
        addRequirements(i);
        mTimer = new Timer();
        mTimeout = timeout;
    }

    @Override
    public void initialize() {
        mTimer.start();
    }
  
    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        mShooter.RunMotor(0.4);
    }
  
    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        mShooter.RunMotor(0);
        
    }
    @Override
    public boolean isFinished() {
    return mTimer.get() > mTimeout;
  }
}

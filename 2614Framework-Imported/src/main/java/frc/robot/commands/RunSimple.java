package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.SimpleMotor;

public class RunSimple extends CommandBase {
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    private final SimpleMotor mSimpleMotor;
    double mTimeout;  
    Timer mTimer;
    public RunSimple(SimpleMotor s, double timeout) {
        mSimpleMotor = s;
        addRequirements(s);
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
        mSimpleMotor.RunMotor(0.4);
    }
  
    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        mSimpleMotor.RunMotor(0.0);
        
    }
    @Override
    public boolean isFinished() {
    return mTimer.get() > mTimeout;
  }
}

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Forward12;


public class Backward12Command extends CommandBase {
    private Forward12 mBackward12; 
    
    public Backward12Command(Forward12 i) {
        mBackward12 = i;
        addRequirements(i);
    }
    
    @Override
    public void initialize() {

    }
  
    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        mBackward12.RunMotor1(-0.4);
    }        
    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        mBackward12.RunMotor1(0);
    }
  
    
  }
  
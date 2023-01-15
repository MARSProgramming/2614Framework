package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Forward12;


public class Forward12Command extends CommandBase {
    private Forward12 mForward12; 
    
    public Forward12Command(Forward12 i) {
        mForward12 = i;
        addRequirements(i);
    }
    
    @Override
    public void initialize() {

    }
  
    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        mForward12.RunMotor1(0.4);
    }        
    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        mForward12.RunMotor1(0);
    }
  
    
  }
  
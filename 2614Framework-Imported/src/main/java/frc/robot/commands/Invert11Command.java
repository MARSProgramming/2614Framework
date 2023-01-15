package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Forward12;


public class Invert11Command extends CommandBase {
    private Forward12 mInvert11; 
    
    public Invert11Command(Forward12 i) {
        mInvert11 = i;
        addRequirements(i);
    }
    
    @Override
    public void initialize() {

    }
  
    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        mInvert11.RunMotor2(-0.4);
    }        
    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        mInvert11.RunMotor2(0);
    }
  
    
  }
  
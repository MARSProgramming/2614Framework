package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Forward12;
import frc.robot.subsystems.Rotate11;


public class Rotate11Command extends CommandBase {
    private Rotate11 mRotate11; 
    
    public Rotate11Command(Rotate11 i) {
        mRotate11 = i;
        addRequirements(i);
    }
    
    @Override
    public void initialize() {

    }
  
    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        mRotate11.RunMotor(0.4);
    }        
    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        mRotate11.RunMotor(0);
    }
  
    
  }
  
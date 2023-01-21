package frc.robot.commands;


import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeSubsystem;

public class IntakeCommand extends CommandBase {
    private IntakeSubsystem mIntakeSub;

    public IntakeCommand(IntakeSubsystem i) {
        mIntakeSub = i;
        addRequirements(i);

    }

    @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    mIntakeSub.RunMotors(0.4);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    mIntakeSub.RunMotors(0);
  }

}

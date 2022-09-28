
package frc.robot.commands;

import edu.wpi.first.math.controller.HolonomicDriveController;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.controller.ProfiledPIDController;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.math.trajectory.TrapezoidProfile;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.DrivetrainSubsystem;

public class DriveAtPath extends CommandBase {
    private final DrivetrainSubsystem mDrivetrainSubsystem;
    private Trajectory mTrajectory;
    private HolonomicDriveController mController;
    private Timer mTimer;
    private Rotation2d mEndRotation;

    public DriveAtPath(DrivetrainSubsystem subsystem, Trajectory traj, Rotation2d rotation) {
        mTrajectory = traj;
        mDrivetrainSubsystem = subsystem;
        mController = new HolonomicDriveController(new PIDController(Constants.Auto.holonomicXkP, Constants.Auto.holonomicXkI, Constants.Auto.holonomicXkD), new PIDController(Constants.Auto.holonomicYkP, Constants.Auto.holonomicYkI, Constants.Auto.holonomicYkD), new ProfiledPIDController(Constants.Auto.holonomicOkP, Constants.Auto.holonomicOkI, Constants.Auto.holonomicOkD, new TrapezoidProfile.Constraints(Constants.Auto.holonomicOMaxVelocity, Constants.Auto.holonomicOMaxAcceleration)));
        mTimer = new Timer();
        mEndRotation = rotation;
        
        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(subsystem);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        mTimer.start();
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        mDrivetrainSubsystem.drive(mController.calculate(mDrivetrainSubsystem.getPose(), mTrajectory.sample(mTimer.get()), mEndRotation));
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        mTimer.stop();
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }
}

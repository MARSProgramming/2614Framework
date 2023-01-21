package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase {
    
    private TalonFX Motor0 = new TalonFX(0);
    private TalonFX Motor13 = new TalonFX(13);
    
    public IntakeSubsystem() {

    }

    public void RunMotors(double voltage) {
        Motor0.set(ControlMode.PercentOutput, voltage);
        Motor13.set(ControlMode.PercentOutput, voltage);
    }
}

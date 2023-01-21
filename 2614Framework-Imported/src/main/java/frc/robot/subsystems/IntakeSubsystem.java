package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase {
    
    private TalonFX Motor0 = new TalonFX(0);
    
    public IntakeSubsystem() {
        Motor0.setNeutralMode(NeutralMode.Brake);
        Motor0.setInverted(true);
    }

    public void RunMotors(double voltage) {
        Motor0.set(ControlMode.PercentOutput, voltage);
    }
}

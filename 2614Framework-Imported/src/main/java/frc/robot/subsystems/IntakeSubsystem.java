package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase {
    
    private TalonSRX Motor0 = new TalonSRX(0);
    private TalonSRX Motor13 = new TalonSRX(13);
    
    public IntakeSubsystem() {
        Motor0.setNeutralMode(NeutralMode.Brake);
        Motor13.setNeutralMode(NeutralMode.Brake);
        Motor13.follow(Motor13);
        Motor0.setInverted(true);
        Motor0.setInverted(true);
    }

    public void RunMotors(double voltage) {
        Motor0.set(ControlMode.PercentOutput, voltage);
        Motor13.set(ControlMode.PercentOutput, voltage);
        
    }
}

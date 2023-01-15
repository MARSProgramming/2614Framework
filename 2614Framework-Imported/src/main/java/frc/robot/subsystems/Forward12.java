package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Forward12 extends SubsystemBase {

    private TalonFX Motor12 = new TalonFX(12);
    private TalonFX Motor11 = new TalonFX(11);

    public Forward12() {

    }

    public void RunMotor1(double voltage){
        Motor12.set(ControlMode.PercentOutput, voltage);

    }

    public void RunMotor2(double voltage) {
        Motor11.set(ControlMode.PercentOutput, voltage);        
    }
}

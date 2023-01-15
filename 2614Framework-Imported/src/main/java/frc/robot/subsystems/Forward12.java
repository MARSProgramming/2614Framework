package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Forward12 extends SubsystemBase {

    private TalonFX Motor12 = new TalonFX(12);

    public Forward12() {

    }

    public void RunMotor(double voltage){
        Motor12.set(ControlMode.PercentOutput, voltage);
    }
}

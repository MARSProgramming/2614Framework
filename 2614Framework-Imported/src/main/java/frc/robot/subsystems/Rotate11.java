package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Rotate11 extends SubsystemBase {

    private TalonFX Motor12 = new TalonFX(11);

    public Rotate11() {

    }

    public void RunMotor(double voltage){
        Motor12.set(ControlMode.PercentOutput, voltage);
    }
}

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class SimpleMotor extends SubsystemBase{



    private TalonFX motor1Fx = new TalonFX(16);

    public SimpleMotor() {
        
    }

    public void RunMotor(double voltage){
        motor1Fx.set(ControlMode.PercentOutput, voltage);
    }
}

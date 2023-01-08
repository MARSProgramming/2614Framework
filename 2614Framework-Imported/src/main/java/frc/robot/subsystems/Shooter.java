package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase{



    private TalonFX RightMotor = new TalonFX(19);
    private TalonFX LeftMotor = new TalonFX(18);

    public Shooter() {
        RightMotor.setInverted(InvertType.InvertMotorOutput);
        
    }

    public void RunMotor(double voltage){
        RightMotor.set(ControlMode.PercentOutput, voltage);
        LeftMotor.set(ControlMode.PercentOutput, voltage);
    }
}

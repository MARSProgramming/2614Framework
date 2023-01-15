package frc.robot.subsystems;

import java.util.function.DoubleSupplier;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.sensors.CANCoder;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Forward12 extends SubsystemBase {

    private TalonFX Motor12 = new TalonFX(12);
    private TalonFX Motor11 = new TalonFX(11);
    private CANCoder mCanCoder = new CANCoder(23);
    
    public Forward12() {

    }
    
    @Override
    public void periodic() {
        SmartDashboard.putNumber("CANCoder Position", mCanCoder.getPosition());
        SmartDashboard.putNumber("CANCoder Absolute Position", mCanCoder.getAbsolutePosition());
        SmartDashboard.putNumber("CANCoder Velocity DEG/SEC", mCanCoder.getVelocity());
  }


    public void RunMotor1(double voltage){
        Motor12.set(ControlMode.PercentOutput, voltage);

    }

    public void RunMotor2(double voltage) {
        Motor11.set(ControlMode.PercentOutput, voltage);        
    }
    




    public CommandBase RunBothMotors(DoubleSupplier voltage1, DoubleSupplier voltage2) {
        return runOnce(
            () -> {
                Motor12.set(ControlMode.PercentOutput, voltage1.getAsDouble());
                Motor11.set(ControlMode.PercentOutput, voltage2.getAsDouble());
            }
        );
    }



}

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase {
    private DoubleSolenoid mSolenoid = new DoubleSolenoid(63, PneumaticsModuleType.REVPH, 0, 1);
    private TalonFX Motor0 = new TalonFX(0);
    
    public IntakeSubsystem() {
        Motor0.setNeutralMode(NeutralMode.Brake);
        Motor0.setInverted(true);
    }

    public void extend(){
        mSolenoid.set(Value.kForward);
      }
      public void retract(){
        mSolenoid.set(Value.kReverse);
      }
      public void toggle(){
         mSolenoid.toggle();
      }

    public void RunMotors(double voltage) {
        Motor0.set(ControlMode.PercentOutput, voltage);
    }
}


  
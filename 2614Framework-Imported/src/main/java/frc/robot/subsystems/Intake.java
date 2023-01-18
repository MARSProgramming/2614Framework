package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
    private static Intake mInstance;
    public static Intake getInstance(){
        if(mInstance == null){
            mInstance = new Intake();
        }
        return mInstance;
    }
   // private DoubleSolenoid mSolenoid = new DoubleSolenoid(63, PneumaticsModuleType.REVPH, 0, 1);
    private TalonFX mMotor = new TalonFX(1);
    public Intake() {}
    public void extend(){
      //  mSolenoid.set(Value.kForward);
    }
    public void retract(){
      //  mSolenoid.set(Value.kReverse);
    }
    public void toggle(){
       // mSolenoid.toggle();
    }
    public void runPVoltage(double v){
        //mMotor.set(ControlMode.PercentOutput, v);
    }
    public TalonFX getMotor(){
        return mMotor;
    }
}
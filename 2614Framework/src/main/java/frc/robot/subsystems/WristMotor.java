
package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class WristMotor extends SubsystemBase {
    
    private static WristMotor mInstance;
    public static WristMotor getInstance(){
    if(mInstance == null){
        mInstance = new WristMotor();
    }
    return mInstance;
}

   TalonSRX WristMotor= new TalonSRX(13);

public void runPVoltage(double input){
    WristMotor.set(ControlMode.PercentOutput , input);
   
}
}
//public void speedControl(double setpoint){
    //WristMotor.set(TalonFXControlMode.Velocity, setpoint);
//}






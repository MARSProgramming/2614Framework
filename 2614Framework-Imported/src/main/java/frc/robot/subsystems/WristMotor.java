
package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import io.github.oblarg.oblog.Loggable;
import io.github.oblarg.oblog.annotations.Log;

public class WristMotor extends SubsystemBase implements Loggable{
    
    private static WristMotor mInstance;
    public static WristMotor getInstance(){
    if(mInstance == null){
        mInstance = new WristMotor();
    }
    return mInstance;
}

    public WristMotor(){}
    @Log
    private double position;

   TalonSRX WristMotor= new TalonSRX(13);

public void runPVoltage(double input){
    WristMotor.set(ControlMode.PercentOutput , input);
   
}

    @Override
    public void periodic(){
       position = WristMotor.getSelectedSensorPosition()* 2*Math.PI/4096;
    }
}
//public void speedControl(double setpoint){
    //WristMotor.set(TalonFXControlMode.Velocity, setpoint);
//}






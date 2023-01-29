package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import java.lang.reflect.Array;
import java.util.Arrays;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;



public class Limelight extends SubsystemBase{
    private static Limelight mLimelight;
    private NetworkTable table; 
    
    public Limelight(){ 
        table = NetworkTableInstance.getDefault().getTable("limelight"); 
    }
    
    public Double[] getCameraPoseTargetSpace(){
        return table.getEntry("camerapose_targetspace").getDoubleArray(new Double[6]);
    }

    public Double[] getTargetPoseCameraSpace(){
        return table.getEntry("targetpose_cameraspace").getDoubleArray(new Double[6]);
    }

    public Double[] getTargetPoseRobotSpace(){
        return table.getEntry("targetpose_robotspace").getDoubleArray(new Double[6]); 
    }
    
    public Double[] getRobotPoseTargetSpace(){
        return table.getEntry("botpose_targetspace").getDoubleArray(new Double[6]); 
    }

    public NetworkTableEntry getTargetID(){
        return table.getEntry("tid");  
    }

}

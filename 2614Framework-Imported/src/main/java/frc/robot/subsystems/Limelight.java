package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import java.lang.reflect.Array;
import java.util.Arrays;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;



public class Limelight extends SubsystemBase{
    private NetworkTable table; 
    
    public Limelight(){ 
        table = NetworkTableInstance.getDefault().getTable("limelight"); 
    }
    
    public double[] getCameraPoseTargetSpace(){
        return table.getEntry("camerapose_targetspace").getDoubleArray(new double[6]);
    }

    public double[] getTargetPoseCameraSpace(){
        return table.getEntry("targetpose_cameraspace").getDoubleArray(new double[6]);
    }

    public double[] getTargetPoseRobotSpace(){
        return table.getEntry("targetpose_robotspace").getDoubleArray(new double[6]); 
    }
    
    public double[] getRobotPoseTargetSpace(){
        return table.getEntry("botpose_targetspace").getDoubleArray(new double[6]); 
    }

    public NetworkTableEntry getTargetID(){
        return table.getEntry("tid");  
    }

    public double[] getBotPose(){ 
        return table.getEntry("botpose").getDoubleArray(new double[6]);
    }

    public double[] getBotPoseRed(){ 
        return table.getEntry("botpose_wpired").getDoubleArray(new double[6]);
    }
    
    public double[] getBotPoseBlue(){ 
        return table.getEntry("botpose_wpiblue").getDoubleArray(new double[6]); 
    }
}

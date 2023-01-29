package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

import edu.wpi.first.wpilibj.shuffleboard.BuiltInLayouts;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;



public class Limelight extends SubsystemBase{

    private NetworkTable table; 
    
    public Limelight(){ 
        table = NetworkTableInstance.getDefault().getTable("limelight"); 
    }

    @Override
    public void periodic() {
      // This method will be called once per scheduler run
    SmartDashboard.putNumberArray("camerapose_targetspace", getCameraPoseTargetSpace());
    SmartDashboard.putNumberArray("targetpose_cameraspace", getTargetPoseCameraSpace());
    SmartDashboard.putNumberArray("tergetpose_robotspace", getTargetPoseRobotSpace()); 
    SmartDashboard.putNumberArray("botpose_targetspace", getRobotPoseTargetSpace());
    SmartDashboard.putNumber("tid", getTargetID()); 
    SmartDashboard.putNumberArray("botpose", getBotPose()); 
    SmartDashboard.putNumberArray("BotPoseRed", getBotPoseRed()); 
    SmartDashboard.putNumberArray("botposeblue", getBotPoseBlue()); 

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

    public double getTargetID(){
        return table.getEntry("tid").getDouble(0);  
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

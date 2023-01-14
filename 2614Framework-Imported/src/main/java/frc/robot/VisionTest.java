package frc.robot;
import org.photonvision.PhotonCamera;
import org.photonvision.PhotonUtils;
import org.photonvision.targeting.PhotonPipelineResult;
import org.photonvision.targeting.PhotonTrackedTarget;

import edu.wpi.first.math.util.Units;

public class VisionTest {
    
    private PhotonPipelineResult results; 
    private double cameraHeight; 
    private double targetHeight; 
    private double cameraPitch; 
    private double range;

    

    public boolean targetFound(){
        return results.hasTargets(); 
    }

    public double getLatency(){
        return results.getLatencyMillis(); 
    }


    public double getTargetYaw(){
        return results.getBestTarget().getYaw(); // Yaw of the target in degrees (positive is to the right)
    }
    public double getTargetPitch(){
        return results.getBestTarget().getPitch();  // Pitch of the target in degrees (positive is up)
    }

  /*   public double getTargetSkew(){
        results.getBestTarget().getSkew(); 
        //Skew of the target in degrees (counter-clockwise is positive)
        //Not applicable for AprilTags
    } */

    public double getTargetArea(){
       return results.getBestTarget().getArea(); // Area of the target as a percent (0-100)
    }

    // Getting AprilTag specific data from the target: 
    public double getTargetID(){
        return results.getBestTarget().getFiducialId(); 
    }

    public double getTargetPoseAmbiguity(){
       return results.getBestTarget().getPoseAmbiguity(); 
    }


   
}

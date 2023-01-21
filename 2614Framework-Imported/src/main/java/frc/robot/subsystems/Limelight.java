package frc.robot.subsystems;
import org.photonvision.PhotonCamera;
import org.photonvision.targeting.PhotonPipelineResult;
import org.photonvision.targeting.PhotonTrackedTarget;
import org.photonvision.PhotonUtils;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Limelight extends SubsystemBase{

    private PhotonCamera mCamera;
    private PhotonPipelineResult result; 
    private PhotonTrackedTarget target; 
    ShuffleboardTab tab; 

    public Limelight (PhotonCamera camera) {
        tab = Shuffleboard.getTab("Vision");
        mCamera = camera; 
    }    

    @Override
    public void periodic() {
    // This method will be called once per scheduler run
        result = mCamera.getLatestResult(); 
        if(result.hasTargets()){
        target = result.getBestTarget(); 
        }
        else target = null; 

        tab.addBoolean("hasTargets", () -> result.hasTargets()); 
        tab.addNumber("targetYaw", () -> target.getYaw()); 
        tab.addNumber("targetPitch", () -> target.getPitch()); 
        tab.addNumber("getArea", () -> target.getArea()); 
        tab.addNumber("getSkew", () -> target.getSkew()); 
        tab.addNumber("targetID", () -> target.getFiducialId()); 
        tab.addNumber("poseAmbiguity", () -> target.getPoseAmbiguity()); 
    }

    public boolean hasTargets(){ 
        return result.hasTargets(); 
    }

    public double getYaw(){ 
        return target.getYaw(); 
    }

    public double getPitch(){ 
        return target.getPitch(); 
    }

    public double getArea(){ 
        return target.getArea(); 
    }

    public double getID(){ 
        return target.getFiducialId(); 
    }

    public double getAmbiguity(){ 
        return target.getPoseAmbiguity(); 
    }

    public double calculateDistanceToTarget(double cameraHeight, double targetHeight, double cameraPitch){ 
        // Calculate distance to target if the height of the target is fixed
        return PhotonUtils.calculateDistanceToTargetMeters(cameraHeight,targetHeight, cameraPitch,Math.toRadians(target.getPitch()));
    }
   

}

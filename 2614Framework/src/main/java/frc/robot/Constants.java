// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import java.util.HashMap;

import edu.wpi.first.math.trajectory.TrapezoidProfile;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    /**
     * The left-to-right distance between the drivetrain wheels
     *
     * Should be measured from center to center.
     */

    public static final HashMap<String, Object> DriveConstants = new HashMap<>();
    public static final HashMap<String, Object> SnapConstants = new HashMap<>();
    public static final HashMap<String, Object> AutoConstants = new HashMap<>();
    public static final HashMap<String, Double> ControllerConstants = new HashMap<>();
    static{
        DriveConstants.put("DRIVETRAIN_TRACKWIDTH_METERS", 0.5334);
        DriveConstants.put("DRIVETRAIN_WHEELBASE_METERS", 0.5334); 

        DriveConstants.put("DRIVETRAIN_PIGEON_ID", 31); 
        DriveConstants.put("kDriveCANivore", "canivore");

        DriveConstants.put("FRONT_LEFT_MODULE_DRIVE_MOTOR", 15); 
        DriveConstants.put("FRONT_LEFT_MODULE_STEER_MOTOR", 5); 
        DriveConstants.put("FRONT_LEFT_MODULE_STEER_ENCODER", 25); 
        DriveConstants.put("FRONT_LEFT_MODULE_STEER_OFFSET", -Math.toRadians(0.0)); 

        DriveConstants.put("FRONT_RIGHT_MODULE_DRIVE_MOTOR", 14); 
        DriveConstants.put("FRONT_RIGHT_MODULE_STEER_MOTOR", 4); 
        DriveConstants.put("FRONT_RIGHT_MODULE_STEER_ENCODER", 24); 
        DriveConstants.put("FRONT_RIGHT_MODULE_STEER_OFFSET", -Math.toRadians(0.0)); 

        DriveConstants.put("BACK_LEFT_MODULE_DRIVE_MOTOR", 16); 
        DriveConstants.put("BACK_LEFT_MODULE_STEER_MOTOR", 6); 
        DriveConstants.put("BACK_LEFT_MODULE_STEER_ENCODER", 26); 
        DriveConstants.put("BACK_LEFT_MODULE_STEER_OFFSET", -Math.toRadians(0.0)); 
                
        DriveConstants.put("BACK_RIGHT_MODULE_DRIVE_MOTOR", 17); 
        DriveConstants.put("BACK_RIGHT_MODULE_STEER_MOTOR", 7); 
        DriveConstants.put("BACK_RIGHT_MODULE_STEER_ENCODER", 27); 
        DriveConstants.put("BACK_RIGHT_MODULE_STEER_OFFSET", -Math.toRadians(0.0)); 

        SnapConstants.put("kP", 0.1);
        SnapConstants.put("kI", 0.0);
        SnapConstants.put("kD", 0.0);
    
        AutoConstants.put("holonomicXkP", 0.1);
        AutoConstants.put("holonomicXkI", 0.0);
        AutoConstants.put("holonomicXkD", 0.0);
        AutoConstants.put("holonomicYkP", 0.1);
        AutoConstants.put("holonomicYkI", 0.0);
        AutoConstants.put("holonomicYkD", 0.0);
        AutoConstants.put("holonomicOkP", 0.1);
        AutoConstants.put("holonomicOkI", 0.0);
        AutoConstants.put("holonomicOkD", 0.0);
        AutoConstants.put("holonomicOMaxVelocity", 6.0);
        AutoConstants.put("holonomicOMaxAcceleration", 15.0);

        ControllerConstants.put("kTriggerThreshold", 0.6);
    }
}

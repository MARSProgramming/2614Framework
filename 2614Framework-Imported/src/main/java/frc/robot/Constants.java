// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import edu.wpi.first.wpilibj.Filesystem;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInLayouts;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import frc.robot.util.DoubleHashMap;
import frc.robot.util.StringHashMap;

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

    public static final ShuffleboardTab ConstantsTab = Shuffleboard.getTab("Constants");
    public static final DoubleHashMap DoubleDriveConstants = new DoubleHashMap(ConstantsTab.getLayout("Drive", BuiltInLayouts.kList).withSize(2, 4));
    public static final HashMap<String, Integer> IntegerDriveConstants = new HashMap<>();
    public static final StringHashMap StringDriveConstants = new StringHashMap(ConstantsTab.getLayout("Drive", BuiltInLayouts.kList).withSize(2, 4));
    public static final DoubleHashMap DoubleSnapConstants = new DoubleHashMap(ConstantsTab.getLayout("Snap", BuiltInLayouts.kList).withSize(2, 4));
    public static final DoubleHashMap DoubleAutoConstants = new DoubleHashMap(ConstantsTab.getLayout("Auto", BuiltInLayouts.kList).withSize(2, 4));
    public static final DoubleHashMap DoubleControllerConstants = new DoubleHashMap(ConstantsTab.getLayout("Controller", BuiltInLayouts.kList));
    public static final ArrayList<Object> maps = new ArrayList<>();

    static{
        maps.add(DoubleDriveConstants);
        maps.add(IntegerDriveConstants);
        maps.add(StringDriveConstants);
        maps.add(DoubleSnapConstants);
        maps.add(DoubleAutoConstants);
        maps.add(DoubleControllerConstants);

        DoubleDriveConstants.put("DRIVETRAIN_TRACKWIDTH_METERS", 0.57);
        DoubleDriveConstants.put("DRIVETRAIN_WHEELBASE_METERS", 0.57);
        DoubleDriveConstants.put("MAX_SPEED_MULTIPLIER", 0.4); 

        IntegerDriveConstants.put("DRIVETRAIN_PIGEON_ID", 31); 
        StringDriveConstants.put("kDriveCANivore", "Drivetrain");

        File swerveZeros = new File(Filesystem.getDeployDirectory().toPath().resolve("constants/SwerveZeros.txt").toString());
        if (swerveZeros.exists()) {
            try{
                Scanner sc = new Scanner(swerveZeros);
                DoubleDriveConstants.put("FRONT_LEFT_MODULE_STEER_OFFSET", -Math.toRadians(Double.parseDouble(sc.nextLine())));
                DoubleDriveConstants.put("FRONT_RIGHT_MODULE_STEER_OFFSET", -Math.toRadians(Double.parseDouble(sc.nextLine())));
                DoubleDriveConstants.put("BACK_LEFT_MODULE_STEER_OFFSET", -Math.toRadians(Double.parseDouble(sc.nextLine())));
                DoubleDriveConstants.put("BACK_RIGHT_MODULE_STEER_OFFSET", -Math.toRadians(Double.parseDouble(sc.nextLine()))); 
                sc.close();
            }
            catch(FileNotFoundException e){
                System.out.println("Swerve Zeros file not found");
            }
        }
        else{
            DoubleDriveConstants.put("FRONT_LEFT_MODULE_STEER_OFFSET", -Math.toRadians(58.97460937500001));
            DoubleDriveConstants.put("FRONT_RIGHT_MODULE_STEER_OFFSET", -Math.toRadians(271.84218750000001));
            DoubleDriveConstants.put("BACK_LEFT_MODULE_STEER_OFFSET", -Math.toRadians(340.306640625));
            DoubleDriveConstants.put("BACK_RIGHT_MODULE_STEER_OFFSET", -Math.toRadians(292.14492187500001)); 
        }

        IntegerDriveConstants.put("FRONT_LEFT_MODULE_DRIVE_MOTOR", 15); 
        IntegerDriveConstants.put("FRONT_LEFT_MODULE_STEER_MOTOR", 5); 
        IntegerDriveConstants.put("FRONT_LEFT_MODULE_STEER_ENCODER", 25); 

        IntegerDriveConstants.put("FRONT_RIGHT_MODULE_DRIVE_MOTOR", 14); 
        IntegerDriveConstants.put("FRONT_RIGHT_MODULE_STEER_MOTOR", 4); 
        IntegerDriveConstants.put("FRONT_RIGHT_MODULE_STEER_ENCODER", 24);  

        IntegerDriveConstants.put("BACK_LEFT_MODULE_DRIVE_MOTOR", 16); 
        IntegerDriveConstants.put("BACK_LEFT_MODULE_STEER_MOTOR", 6); 
        IntegerDriveConstants.put("BACK_LEFT_MODULE_STEER_ENCODER", 26); 

        IntegerDriveConstants.put("BACK_RIGHT_MODULE_DRIVE_MOTOR", 17); 
        IntegerDriveConstants.put("BACK_RIGHT_MODULE_STEER_MOTOR", 7); 
        IntegerDriveConstants.put("BACK_RIGHT_MODULE_STEER_ENCODER", 27); 

        DoubleSnapConstants.put("kP", 0.03);
        DoubleSnapConstants.put("kI", 0.0);
        DoubleSnapConstants.put("kD", 0.0);

        DoubleAutoConstants.put("holonomicXkP", 1);
        DoubleAutoConstants.put("holonomicXkI", 0);
        DoubleAutoConstants.put("holonomicXkD", 0);
        DoubleAutoConstants.put("holonomicYkP", 1);
        DoubleAutoConstants.put("holonomicYkI", 0);
        DoubleAutoConstants.put("holonomicYkD", 0);
        DoubleAutoConstants.put("holonomicOkP", 0.1);
        DoubleAutoConstants.put("holonomicOkI", 0.0);
        DoubleAutoConstants.put("holonomicOkD", 0.0);
        DoubleAutoConstants.put("holonomicOMaxVelocity", 1);
        DoubleAutoConstants.put("holonomicOMaxAcceleration", 5);

        DoubleControllerConstants.put("kTriggerThreshold", 0.6);
    }
}

package frc.robot.util;

import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardLayout;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;

public interface PeriodicLoggable {
    public static ShuffleboardTab ioTAB = Shuffleboard.getTab("SubsystemInfo");
    public void periodicIO(ShuffleboardLayout layout);
}

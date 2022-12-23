package frc.robot.swervelib.rev;

import edu.wpi.first.wpilibj.DriverStation;
import com.revrobotics.*;

public final class RevUtils {
    private RevUtils() {}

    public static void checkNeoError(REVLibError error, String message) {
        if (error != REVLibError.kOk) {
            DriverStation.reportError(String.format("%s: %s", message, error.toString()), false);
        }
    }
}

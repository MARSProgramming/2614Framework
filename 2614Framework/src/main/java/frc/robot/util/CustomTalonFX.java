package frc.robot.util;

import com.ctre.phoenix.ParamEnum;
import com.ctre.phoenix.motorcontrol.ControlFrame;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.ctre.phoenix.motorcontrol.LimitSwitchSource;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.StatorCurrentLimitConfiguration;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;
import com.ctre.phoenix.motorcontrol.SupplyCurrentLimitConfiguration;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

public class CustomTalonFX extends TalonFX{
    
    private final static int kTimeoutMs = 100;
    private NeutralMode NEUTRAL_MODE = NeutralMode.Coast;
    // factory default
    private double NEUTRAL_DEADBAND = 0.04;

    private boolean ENABLE_SOFT_LIMIT = false;
    private boolean ENABLE_LIMIT_SWITCH = false;
    private int FORWARD_SOFT_LIMIT = 0;
    private int REVERSE_SOFT_LIMIT = 0;

    private boolean INVERTED = false;
    private boolean SENSOR_PHASE = false;

    private int CONTROL_FRAME_PERIOD_MS = 20; // 10
    private int MOTION_CONTROL_FRAME_PERIOD_MS = 100;
    private int GENERAL_STATUS_FRAME_RATE_MS = 20; // 10
    private int FEEDBACK_STATUS_FRAME_RATE_MS = 100;
    private int QUAD_ENCODER_STATUS_FRAME_RATE_MS = 1000;
    private int ANALOG_TEMP_VBAT_STATUS_FRAME_RATE_MS = 1000;
    private int PULSE_WIDTH_STATUS_FRAME_RATE_MS = 1000;

    private int VELOCITY_MEASUREMENT_ROLLING_AVERAGE_WINDOW = 64;

    private StatorCurrentLimitConfiguration STATOR_CURRENT_LIMIT = new StatorCurrentLimitConfiguration(false, 300, 700, 1);
    private SupplyCurrentLimitConfiguration SUPPLY_CURRENT_LIMIT = new SupplyCurrentLimitConfiguration(false, 40, 100, 1);

    private double OPEN_LOOP_RAMP_RATE = 0.0;
    private double CLOSED_LOOP_RAMP_RATE = 0.0;


    public CustomTalonFX(int slot){
        super(slot);
        super.set(ControlMode.PercentOutput, 0.0);

        super.changeMotionControlFramePeriod(MOTION_CONTROL_FRAME_PERIOD_MS);
        super.clearMotionProfileHasUnderrun(kTimeoutMs);
        super.clearMotionProfileTrajectories();

        super.clearStickyFaults(kTimeoutMs);

        super.configForwardLimitSwitchSource(LimitSwitchSource.FeedbackConnector,
                LimitSwitchNormal.Disabled, kTimeoutMs);
        super.configReverseLimitSwitchSource(LimitSwitchSource.FeedbackConnector,
                LimitSwitchNormal.Disabled, kTimeoutMs);
        super.overrideLimitSwitchesEnable(ENABLE_LIMIT_SWITCH);

        // Turn off re-zeroing by default.
        super.configSetParameter(
                ParamEnum.eClearPositionOnLimitF, 0, 0, 0, kTimeoutMs);
        super.configSetParameter(
                ParamEnum.eClearPositionOnLimitR, 0, 0, 0, kTimeoutMs);

        super.configNominalOutputForward(0, kTimeoutMs);
        super.configNominalOutputReverse(0, kTimeoutMs);
        super.configNeutralDeadband(NEUTRAL_DEADBAND, kTimeoutMs);

        super.configPeakOutputForward(1.0, kTimeoutMs);
        super.configPeakOutputReverse(-1.0, kTimeoutMs);

        super.setNeutralMode(NEUTRAL_MODE);

        super.configForwardSoftLimitThreshold(FORWARD_SOFT_LIMIT, kTimeoutMs);
        super.configForwardSoftLimitEnable(ENABLE_SOFT_LIMIT, kTimeoutMs);

        super.configReverseSoftLimitThreshold(REVERSE_SOFT_LIMIT, kTimeoutMs);
        super.configReverseSoftLimitEnable(ENABLE_SOFT_LIMIT, kTimeoutMs);
        super.overrideSoftLimitsEnable(ENABLE_SOFT_LIMIT);

        super.setInverted(INVERTED);
        super.setSensorPhase(SENSOR_PHASE);

        super.selectProfileSlot(0, 0);

        super.configVelocityMeasurementWindow(VELOCITY_MEASUREMENT_ROLLING_AVERAGE_WINDOW,
                kTimeoutMs);

        super.configOpenloopRamp(OPEN_LOOP_RAMP_RATE, kTimeoutMs);
        super.configClosedloopRamp(CLOSED_LOOP_RAMP_RATE, kTimeoutMs);

        super.configVoltageCompSaturation(0.0, kTimeoutMs);
        super.configVoltageMeasurementFilter(32, kTimeoutMs);
        super.enableVoltageCompensation(false);

        super.configStatorCurrentLimit(STATOR_CURRENT_LIMIT);
        super.configSupplyCurrentLimit(SUPPLY_CURRENT_LIMIT);

        super.setStatusFramePeriod(StatusFrameEnhanced.Status_1_General,
                GENERAL_STATUS_FRAME_RATE_MS, kTimeoutMs);
        super.setStatusFramePeriod(StatusFrameEnhanced.Status_2_Feedback0,
                FEEDBACK_STATUS_FRAME_RATE_MS, kTimeoutMs);

        super.setStatusFramePeriod(StatusFrameEnhanced.Status_3_Quadrature,
                QUAD_ENCODER_STATUS_FRAME_RATE_MS, kTimeoutMs);
        super.setStatusFramePeriod(StatusFrameEnhanced.Status_4_AinTempVbat,
                ANALOG_TEMP_VBAT_STATUS_FRAME_RATE_MS, kTimeoutMs);
        super.setStatusFramePeriod(StatusFrameEnhanced.Status_8_PulseWidth,
                PULSE_WIDTH_STATUS_FRAME_RATE_MS, kTimeoutMs);

        super.setControlFramePeriod(ControlFrame.Control_3_General, CONTROL_FRAME_PERIOD_MS);
    }
}

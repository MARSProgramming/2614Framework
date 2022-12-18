package frc.robot.shuffleboard;

import java.util.ArrayList;
import java.util.List;

import frc.robot.Constants;
import frc.robot.util.ReadsFromDashHashMap;
import frc.robot.util.WritesFromDashHashMap;

public class ConstantsIO {
    private static ConstantsIO mInstance;
    public static ConstantsIO getInstance(){
        if(mInstance == null) mInstance = new ConstantsIO();
        return mInstance;
    }

    private List<ReadsFromDashHashMap> reads;
    private List<WritesFromDashHashMap> writes;
    public ConstantsIO(){
        reads = new ArrayList<>();
        reads.add(Constants.DoubleAutoConstants);
        reads.add(Constants.DoubleControllerConstants);
        reads.add(Constants.DoubleDriveConstants);
        reads.add(Constants.DoubleSnapConstants);
        reads.add(Constants.StringDriveConstants);
        writes = new ArrayList<>();
    }

    public void periodic(){
        for(ReadsFromDashHashMap m : reads){
            m.readFromShuffleboard();
        }
        for(WritesFromDashHashMap m : writes){
            m.writeToShuffleboard();
        }
    }
}

package frc.robot.util;

import java.util.ArrayList;
import java.util.HashMap;

import edu.wpi.first.networktables.GenericEntry;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardLayout;

public class DoubleHashMap implements ReadsFromDashHashMap{
    private final HashMap<String, Double> map;
    private ArrayList<GenericEntry> entryArray;
    private ShuffleboardLayout layout;
    public DoubleHashMap(ShuffleboardLayout layout){
        map = new HashMap<>();
        entryArray = new ArrayList<>();
        this.layout = layout;
    }

    public void put(String key, double value){
        map.put(key, value);
        entryArray.add(layout.add(key, value).getEntry());
    }

    public double get(String key){
        return map.get(key);
    }

    @Override
    public void readFromShuffleboard(){
        for(GenericEntry entry : entryArray){
            map.put(entry.getName(), entry.getDouble(0.0));
        }
    }
}

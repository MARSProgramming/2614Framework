package frc.robot.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;

public class DoubleHashMap implements ReadsFromDashHashMap{
    private final HashMap<String, Double> map;
    private ArrayList<NetworkTableEntry> entryArray;
    private ShuffleboardTab tab;
    public DoubleHashMap(ShuffleboardTab tab){
        map = new HashMap<>();
        entryArray = new ArrayList<>();
        this.tab = tab;
    }

    public void put(String key, double value){
        map.put(key, value);
        entryArray.add(tab.add(key, value).getEntry());
    }

    public double get(String key){
        return map.get(key);
    }

    @Override
    public void readFromShuffleboard(){
        for(NetworkTableEntry entry : entryArray){
            map.put(entry.getName(), entry.getDouble(0.0));
        }
    }
}

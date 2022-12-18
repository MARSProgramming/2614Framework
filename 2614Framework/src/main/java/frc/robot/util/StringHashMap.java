package frc.robot.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;

public class StringHashMap implements ReadsFromDashHashMap{
    private final HashMap<String, String> map;
    private ArrayList<NetworkTableEntry> entryArray;
    private ShuffleboardTab tab;
    public StringHashMap(ShuffleboardTab tab){
        map = new HashMap<>();
        entryArray = new ArrayList<>();
        this.tab = tab;
    }

    public void put(String key, String value){
        map.put(key, value);
        entryArray.add(tab.add(key, value).getEntry());
    }

    public String get(String key){
        return map.get(key);
    }

    @Override
    public void readFromShuffleboard(){
        for(NetworkTableEntry entry : entryArray){
            map.put(entry.getName(), entry.getString(""));
        }
    }
}

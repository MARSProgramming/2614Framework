package frc.robot.util;

import java.util.ArrayList;
import java.util.HashMap;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardLayout;

public class StringHashMap implements ReadsFromDashHashMap{
    private final HashMap<String, String> map;
    private ArrayList<NetworkTableEntry> entryArray;
    private ShuffleboardLayout layout;
    public StringHashMap(ShuffleboardLayout layout){
        map = new HashMap<>();
        entryArray = new ArrayList<>();
        this.layout = layout;
    }

    public void put(String key, String value){
        if(!map.containsKey(key)) entryArray.add(layout.add(key, value).getEntry());
        map.put(key, value);
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

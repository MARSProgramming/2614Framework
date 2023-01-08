package frc.robot.util;

import java.util.ArrayList;
import java.util.HashMap;

import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardLayout;
import edu.wpi.first.wpilibj.shuffleboard.SimpleWidget;

public class StringHashMap implements ReadsFromDashHashMap{
    private final HashMap<String, String> map;
    private ArrayList<SimpleWidget> entryArray;
    private ShuffleboardLayout layout;
    public StringHashMap(ShuffleboardLayout layout){
        map = new HashMap<>();
        entryArray = new ArrayList<>();
        this.layout = layout;
    }

    public void put(String key, String value){
        if(!map.containsKey(key)) entryArray.add(layout.add(key, value));
        map.put(key, value);
    }

    public String get(String key){
        return map.get(key);
    }

    @Override
    public void readFromShuffleboard(){
        for(SimpleWidget entry : entryArray){
            map.put(entry.getTitle(), entry.getEntry().getString(""));
        }
    }
}

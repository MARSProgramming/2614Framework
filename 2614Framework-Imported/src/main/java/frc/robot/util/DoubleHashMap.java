package frc.robot.util;

import java.util.ArrayList;
import java.util.HashMap;

import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardLayout;
import edu.wpi.first.wpilibj.shuffleboard.SimpleWidget;

public class DoubleHashMap implements ReadsFromDashHashMap{
    private final HashMap<String, Double> map;
    private ArrayList<SimpleWidget> entryArray;
    private ShuffleboardLayout layout;
    public DoubleHashMap(ShuffleboardLayout layout){
        map = new HashMap<>();
        entryArray = new ArrayList<>();
        this.layout = layout;
    }

    public void put(String key, double value){
        map.put(key, value);
        entryArray.add(layout.add(key, value));
    }

    public double get(String key){
        return map.get(key);
    }

    @Override
    public void readFromShuffleboard(){
        for(SimpleWidget entry : entryArray){
            map.put(entry.getTitle(), entry.getEntry().getDouble(0.0));
        }
    }
}

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;

public class TestButtons extends Command{
    private String mString;
    public TestButtons(String str){
        mString = str;
    }

    @Override
    public void initialize(){
        SmartDashboard.putString("Button Pressed", mString);
    }
}

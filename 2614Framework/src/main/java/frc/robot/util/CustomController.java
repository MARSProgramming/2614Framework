package frc.robot.util;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.Button;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class CustomController extends Joystick{
    ButtonMap mButtonMap;
    public CustomController(int port, ButtonMap map){
        super(port);
        mButtonMap = map;
    }
    public Button getAButton(){
        return new JoystickButton(this, mButtonMap.A);
    }
    public Button getBButton(){
        return new JoystickButton(this, mButtonMap.B);
    }
    public Button getXButton(){
        return new JoystickButton(this, mButtonMap.X);
    }
    public Button getYButton(){
        return new JoystickButton(this, mButtonMap.Y);
    }
    public JoystickButton getOptionsButton(){
		return new JoystickButton(this, mButtonMap.BUTTON_OPTIONS);
	}

	public JoystickButton getShareButton() {
		return new JoystickButton(this, mButtonMap.BUTTON_SHARE);
	}
	
	public JoystickButton getStartButton() {
		return new JoystickButton(this, mButtonMap.BUTTON_START);
	}

	public JoystickButton getLeftBumper() {
		return new JoystickButton(this, mButtonMap.BUTTON_LEFT_BUMPER);
	}
}

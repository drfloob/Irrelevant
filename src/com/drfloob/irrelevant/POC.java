package com.drfloob.irrelevant;

import java.awt.Robot;
import java.awt.event.KeyEvent;

public class POC {
	public static void main(String[] args) throws java.awt.AWTException {
		Robot robot = new Robot();
		robot.delay(1000);
		
		robot.keyPress(KeyEvent.VK_KP_UP);
		robot.keyRelease(KeyEvent.VK_KP_UP);
		robot.delay(1000);
		
		// robot.keyPress(KeyEvent.VK_ENTER);
		// robot.keyRelease(KeyEvent.VK_ENTER);

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_A);
		robot.keyRelease(KeyEvent.VK_A);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.delay(1000);

		for (int i = 0; i < 10; i++) {
			robot.keyPress(KeyEvent.VK_KP_RIGHT);
			robot.keyRelease(KeyEvent.VK_KP_RIGHT);
			robot.delay(300);
		}
	}
}
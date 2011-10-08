package com.drfloob.irrelevant;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.AWTKeyStroke;

public class POC {
	public static void main(String[] args) throws java.awt.AWTException {
		Robot robot = new Robot();
		arbitraryUnicode(robot);
	}

	/**
	 * Executes the last command run at the prompt (requires shell
	 * with history)
	 */
	private static void compileSelf(Robot robot) {
		robot.keyPress(KeyEvent.VK_KP_UP);
		robot.keyRelease(KeyEvent.VK_KP_UP);
		robot.delay(1000);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	/**
	 * In BASH and other shells, this pulls up the last command,
	 * moves to the beginning of the line, and then moves forward
	 * a few spaces
	 */
	private static void moveAround(Robot robot) {
		robot.keyPress(KeyEvent.VK_KP_UP);
		robot.keyRelease(KeyEvent.VK_KP_UP);
		robot.delay(1000);

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

	private static void arbitraryUnicode(Robot robot) {
		char key = 'Ꝥ';
		AWTKeyStroke awtKS = AWTKeyStroke.getAWTKeyStroke(key);
		int key_code = awtKS.getKeyCode();
		System.out.println("key = "+key+" keyCode = "+key_code);
		robot.keyPress(key_code);
		robot.keyRelease(key_code);
	}
}
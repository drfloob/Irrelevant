package com.drfloob.irrelevant;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.AWTException;

public class Controller {

	private Robot rob;

	public Controller() throws AWTException {
		rob = new Robot();
	}
	
	public void handle(String req) throws Exception {
		String[] r = req.split("\\/");
		String button = r[1];
		// rob.delay(2000);
		if (button.equals("up")) {
			rob.keyPress(KeyEvent.VK_KP_UP);
			rob.keyRelease(KeyEvent.VK_KP_UP);
		} else if (button.equals("down")) {
			System.out.println("");
			rob.keyPress(KeyEvent.VK_KP_DOWN);
			rob.keyRelease(KeyEvent.VK_KP_DOWN);
		} else if (button.equals("left")) {
			rob.keyPress(KeyEvent.VK_KP_LEFT);
			rob.keyRelease(KeyEvent.VK_KP_LEFT);
		} else if (button.equals("right")) {
			rob.keyPress(KeyEvent.VK_KP_RIGHT);
			rob.keyRelease(KeyEvent.VK_KP_RIGHT);
		} else if (button.equals("a")) {
			rob.keyPress(KeyEvent.VK_A);
			rob.keyRelease(KeyEvent.VK_A);
		} else if (button.equals("b")) {
			rob.keyPress(KeyEvent.VK_B);
			rob.keyRelease(KeyEvent.VK_B);
		} else if (button.equals("start")) {
			rob.keyPress(KeyEvent.VK_ENTER);
			rob.keyRelease(KeyEvent.VK_ENTER);
		} else if (button.equals("select")) {
			rob.keyPress(KeyEvent.VK_SHIFT);
			rob.keyRelease(KeyEvent.VK_SHIFT);
		} else {
			throw new Exception("bad button: "+button);
		}

		System.out.println(button+" pressed");
	}
}
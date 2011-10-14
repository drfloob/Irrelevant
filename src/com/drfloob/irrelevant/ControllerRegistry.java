package com.drfloob.irrelevant;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import java.util.logging.Logger;

public class ControllerRegistry {
	
	private HashMap<String, Controller> registrants = new HashMap<String, Controller>();;
	private ArrayList<Controller> controllers = new ArrayList<Controller>();
	private static Logger log = Logger.getLogger(ControllerRegistry.class.getName());

	public ControllerRegistry() {
		try {
			controllers.add(new Controller());
		} catch (java.awt.AWTException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	// // ADMIN ACTIONS

	// public Map<String, Controller> listRegistered() {
	// 	return Collections.unmodifiableMap(registrants);
	// }

	// public List<Controller> listAvailable() {
	// 	return Collections.unmodifiableList(controllers);
	// }


	public boolean registerNext(String id) {
		// @TODO synchronize for race conditions
		Controller c = controllers.remove(0);
		registrants.put(id, c);

		return true;
	}

	public boolean unregister(String id) {
		if (!registrants.containsKey(id))
			return false;
		Controller c = registrants.remove(id);
		controllers.add(0, c);
		return true;
	}

	public void dispatch(String id, String request) throws Exception {
		if (request.equals("/register")) {
			log.info("registering new controller to id: "+id);
			registerNext(id);
			return;
		}
		if (request.equals("/unregister")) {
			log.info("unregistering id: "+id);
			unregister(id);
			return;
		}


		Controller c = registrants.get(id);
		if (c == null)
			throw new Exception("Controller not found; id: "+id);
		c.handle(request);
	}
}

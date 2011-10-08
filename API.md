## Basic Server Methods

All methods except `register` require authentication as a gamepad client.

 * register
	associates a device with the first open controller spot; gives back an id
 * press (button)
   	device pressed button (button)
 * release (button)
   	device released button (button)
 * move (button, coords)
   	device moved amouse, analog stick, etc. (button) to some position (coords)
 * unregister
   	unregisters th registered device with the server


## Server Administration Methods

All methods require authentication as an admin client.

 * list devices
 * unregister (id)
 * switch (id1, id2)
   	causes gamepads (id1, id2) to switch keybindings with each other
 * set required gamepad (gpid)


## Pluggable Gamepad Methods

No authentication required.

 * list gamepads
 * get gamepad (gpid)
 * get gamepad reqs
       	retrieves the keys the server requires


# Client-local Methods
 * reconfigure gamepad (id, gpid)
   	prompts gamepad to choose which buttons to use


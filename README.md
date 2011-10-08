# irrelevant

Note: **NOT FUNCTIONAL YET**

Irrelevant is a gamepad emulator for Android phones. It allows you to use your multi-touch Android device as a simple input device for your computer, built primarily for old-school gamers (and their emulators).

This is a combination of java server for your computer and an android client for android devices. Setup requires some technical ability. The server should work on most operating systems, since it's entirely written in Java using standard Java tools (nothing fancy or OS-specific).

Gamepads are pluggable. Defining your own gamepad is documented and straightforward (requires some graphics skills and some light programming). The server-side keymappings are configurable, and client-side button choices are configurable as well. New devices can download gamepads from any irrelevant server they connect to, allowing anyone with the app to play.

## design documents

 * [API](Irrelevant/blob/master/API.md): general list of all server api calls, organized by responsibility
 * [GAMEPAD](Irrelevant/blob/master/GAMEPAD.md): general requirements for gamepad packages

## license

    /*
     * ----------------------------------------------------------------------------
     * "THE BEER-WARE LICENSE" (Revision 42):
     * <aj@drfloob.com> wrote this file. As long as you retain this notice you
     * can do whatever you want with this stuff. If we meet some day, and you think
     * this stuff is worth it, you can buy me a beer in return. AJ Heller
     * ----------------------------------------------------------------------------
     */
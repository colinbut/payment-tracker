/*
 * |-------------------------------------------------
 * | Copyright © 2017 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.pt.io;

public enum Command {

    QUIT_COMMAND("QUIT"),
    Q_COMMAND("Q");

    Command(String command) {
        this.command = command;
    }

    private String command;

    public String getCommand() {
        return command;
    }
}

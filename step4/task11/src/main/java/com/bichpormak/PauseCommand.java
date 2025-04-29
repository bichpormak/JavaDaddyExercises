package com.bichpormak;

public class PauseCommand implements Command {

    @Override
    public void execute() {
        System.out.println("Pause command");
    }

}

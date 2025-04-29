package com.bichpormak;

public class StopCommand implements Command {

    @Override
    public void execute() {
        System.out.println("Stop command...");
    }

}

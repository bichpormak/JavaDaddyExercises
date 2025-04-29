package com.bichpormak;

public class StartCommand implements Command {

    @Override
    public void execute() {
        System.out.println("Start command...");
    }

}

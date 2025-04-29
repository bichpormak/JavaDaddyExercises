package com.bichpormak;

public class StrategyCommandDemo {

    public static void main(String[] args) {

        final CommandProcessor commandProcessor = new CommandProcessor();

        commandProcessor.getCommands().get(args[0]).execute();

    }

}
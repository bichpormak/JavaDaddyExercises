package com.bichpormak;

import java.util.HashMap;
import java.util.Map;

public class CommandProcessor {

    private static final Map<String, Command> commands = new HashMap<>()
    {{

        put("start", new StartCommand());
        put("pause", new PauseCommand());
        put("stop", new StopCommand());

    }};

    public Map<String, Command> getCommands() {
        return commands;
    }

}

package com.mjc.school.controller.impl.command;

import com.mjc.school.controller.Command;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class Invoker {

    private Command command;

    public void setCommand(Command command) throws IOException {
        this.command = command;
        this.execute();
    }

    private void execute() throws IOException {
        command.execute();
    }
}
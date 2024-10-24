package com.umk.app;
import com.umk.app.console.ConsoleApp;
import com.umk.app.gui.GuiApp;
import org.apache.commons.cli.*;

public class Application {
    public static void main(String[] args) {
        Options option = new Options();
        option.addOption("c", "console", false, "console or gui");
        option.addOption("g", "gui", false, "console or gui");
        CommandLineParser parser = new DefaultParser();
        try {
            CommandLine cmd = parser.parse(option, args);
            if (cmd.hasOption("c"))
                new ConsoleApp().run();
            else if(cmd.hasOption("g"))
                new GuiApp().Run();
        } catch (ParseException e) {
            System.out.println("Error: "+e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
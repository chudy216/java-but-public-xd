package com.umk.app.console;

import com.umk.app.objects.Game;

public class ConsoleApp {
    public  void run()
    {
        Game game = new Game();
        boolean running = true;

        game.initialize();

        while (running) {
            game.showLogo();
            game.ClearScreen();
            switch (game.showMenu()){
                case 0:
                    System.out.println("New Game");
                    game.ClearScreen();
                    game.gameLoop();
                    break;
                case 1:
                    System.out.println("Stats");
                    break;
                case 2:
                    System.out.println("Exit");
                    running = false;
                    break;
            }
        }
    }
}

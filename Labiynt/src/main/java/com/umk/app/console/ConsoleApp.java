package com.umk.app.console;


import com.umk.app.objects.Game;

public class ConsoleApp {
    public void run(){
        System.out.println("Tryb Konsolowy");
        //Runtime.getRuntime().exec("clear");
        boolean running = true;
        Game game = new Game();
        game.initialize();
        game.showLogo();
        while (running){
            int choice = game.showMenu();
            switch (choice){
                case 0:
                    System.out.println("New Game!");
                    game.gameLoop();
                    break;
                case 1:
                    System.out.println("statistics");
                    break;
                case 2:
                    System.out.println("exit");
                    running = false;
                    break;
            }
            //game.clearScreen();
        }

    }
}

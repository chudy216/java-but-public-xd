package com.umk.app.objects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Game implements iGame{
    String logoPath = "logo.txt";
    List<String> menuOptions = Arrays.asList("New Game", "Show Statistics", "Exit");
    GameBoard gameBoard = new GameBoard();
    Player player = new Player(2, 0, "XYZ", '#');
    @Override
    public void initialize() {
        clearScreen();
    }
    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    @Override
    public void showLogo() {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(logoPath);
        List<String> lines = new BufferedReader(new InputStreamReader(inputStream)).lines().toList();
        for(String line : lines){
            System.out.println(line);
        }

    }
    @Override
    public int showMenu() {
        System.out.println("\n\n\n");
        for (int i = 0; i < menuOptions.size(); i++) {
            System.out.println(i+1 + " - " + menuOptions.get(i));
        }
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        while(true){
          if (scanner.hasNextLine()){
              try {
                  choice = Integer.parseInt(scanner.nextLine()) - 1;
              } catch (NumberFormatException e) {
                  System.out.println("wpisuj liczbe");
                  // new RuntimeException(e);
              }

          }
          if(choice>=0 && choice<menuOptions.size()){
              return choice;
          }
        }
    }

    public void gameLoop(){
        char action = ' ';
        System.out.println("Witaj "+player.getObjectName());
        gameBoard.addPlayer(player.getObjectXpos(), player.getObjectYpos(), player.getObjectFigure());
        gameBoard.drawBoard();
        while(action != 'q' && action != 'Q'){
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextLine()){
                String line = scanner.nextLine();
                if (line.length() == 1) {
                    action = line.charAt(0);
                }
                else{
                    System.out.println("podawaj jeden znak");
                }
            }
        }
    }

    @Override
    public void showStatistics() {

    }
}

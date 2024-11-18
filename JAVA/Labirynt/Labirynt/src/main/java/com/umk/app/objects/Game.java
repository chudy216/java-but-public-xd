package com.umk.app.objects;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Game implements IGame {
    String logoPath = "logo.txt";
    List<String> menuOption = Arrays.asList("New game","Show statistics","Exit");

    GameBoard gameBoard = new GameBoard();
    Player player = new Player(1,1,"Player",'@');


    @Override
    public void initialize() {
        ClearScreen();
    }

    public  void ClearScreen()
    {
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }

    @Override
    public void showLogo() {
        InputStream input = this.getClass().getClassLoader().getResourceAsStream(logoPath);
        List<String> lines = new BufferedReader(new InputStreamReader(input)).lines().toList();

        for(String line : lines)
        {
            System.out.println(line);
        }
    }

    @Override
    public int showMenu() {
        System.out.println("\n\n\n");
        int i = 1;
        for(String option : menuOption)
        {
            System.out.println(i + ". " +option);
            i++;
        }

        Scanner scanner = new Scanner(System.in);
        int choice;
        while(true) {
            if (scanner.hasNextLine()) {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice >= 1 && choice <= menuOption.size()) {
                    return --choice;
                }
            }
        }
    }

    @Override
    public void showStatistcs() {

    }

    public void gameLoop()
    {
        char action = ' ';
        Scanner scanner = new Scanner(System.in);
        int prevXPos;
        int prevYPos;
        boolean finish = false;


        gameBoard.drawBoard();
        System.out.println(player.getName() + " " + player.getObjectFigure());
        while(action != 'Q' && action != 'q')
        {
            prevXPos = player.getPosX();
            prevYPos = player.getPosY();

            System.out.println("\nAction [WSAD]: ");
            action = scanner.next().charAt(0);
            switch(action)
            {
                case 'a':
                    if(!gameBoard.isCollision(player.getPosX(),player.getPosY()-1))
                    {
                        player.ChangePosition(player.getPosX(),player.getPosY()-1);
                    }
                    break;
                case 'd':
                    if(!gameBoard.isCollision(player.getPosX(),player.getPosY()+1))
                    {
                        player.ChangePosition(player.getPosX(),player.getPosY()+1);
                    }
                    else
                        finish= gameBoard.isFinish(player.getPosY());
                    break;
                case 'w':
                    if(!gameBoard.isCollision(player.getPosX()-1,player.getPosY()))
                    {
                        player.ChangePosition(player.getPosX()-1,player.getPosY());
                    }
                    break;
                case 's':
                    if(!gameBoard.isCollision(player.getPosX()+1,player.getPosY()))
                    {
                        player.ChangePosition(player.getPosX()+1,player.getPosY());
                    }
                    break;
                default:
                    System.out.println("Incorrect action!");
                    break;
            }
            gameBoard.changePlayerPosition(prevXPos,prevYPos,player.getPosX(), player.getPosY(),player.getObjectFigure());
            gameBoard.drawBoard();

            if(finish)
            {
                ClearScreen();
                System.out.println("The end");
                scanner.nextLine();
                break;
            }
        }
    }
}

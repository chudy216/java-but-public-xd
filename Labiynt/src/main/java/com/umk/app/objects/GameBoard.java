package com.umk.app.objects;

import com.umk.app.io.MazeManager;

import java.util.List;

public class GameBoard implements iGameBoard{
    MazeManager mazeManager = new MazeManager("maze.txt");
    private List<String>  map;
    char[][] gameBoard;
    @Override
    public void drawBoard() {
     map = mazeManager.getMapa();
        gameBoard = new char[map.size()][map.get(0).length()];
        for (int i = 0; i < map.size(); i++) {
            for (int j = 0; j < map.get(i).length(); j++) {
                gameBoard[i][j] = map.get(i).charAt(j);
            }
            System.out.println(map.get(i));
        }
        System.out.println("\n" );


    }
    public void addPlayer(int x, int y, char fig){
        gameBoard[x][y] = fig;
    }

    @Override
    public boolean isColision(int x, int y) {

        return false;
    }
}

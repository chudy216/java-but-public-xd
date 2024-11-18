package com.umk.app.objects;

import com.umk.app.io.MazeManager;

public class GameBoard implements IGameBoard{
    MazeManager mazeManager;
    char[][] gameBoard;
    int playerFinishPositionY;
    int playerStartPositionY;

    public GameBoard()
    {
        getMaze();
    }


    public void getMaze() {
        mazeManager = new MazeManager("src/main/resources/Maze1.txt");
        gameBoard = mazeManager.getMatrix();

        System.out.println(gameBoard[0].length);
        for (int row = 0; row < gameBoard.length ; row++) {
            for (int col = 0; col < gameBoard[0].length ; col++) {
                System.out.print(gameBoard[row][col]);
            }
            System.out.print('\n');
        }
    }

    @Override
    public  void drawBoard()
    {
        for (int row = 0; row < gameBoard.length ; row++) {
            for (int col = 0; col < gameBoard[0].length ; col++) {
                System.out.print(gameBoard[row][col]);
            }
            System.out.print('\n');
        }
    }

    public boolean isFinish(int y)
    {
        return y == playerFinishPositionY;
    }

    @Override
    public boolean isCollision(int x, int y) {
       if(x > 0 && y < gameBoard[0].length && x < gameBoard.length && y > 0 && gameBoard[x][y] == ' ')
           return false;
       return true;
    }

    public void changePlayerPosition(int prevXPos,int prevYPos,int posX, int posY, char objectFigure)
    {
        System.out.println(posX + " " + posY);
        gameBoard[posX][posY] = objectFigure;
        gameBoard[prevXPos][prevYPos] = ' ';
    }

    public  void getStartFinishPosition()
    {


    }

}

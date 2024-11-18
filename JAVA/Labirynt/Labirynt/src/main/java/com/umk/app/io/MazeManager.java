package com.umk.app.io;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class MazeManager {
    private char[][] matrix = null;

    public MazeManager(String fileName)
    {
        ReadFile(fileName);
    }


    public void ReadFile(String fileName)
    {
        List<String> data = new ArrayList<String>();

        try {
            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                 data.add(myReader.nextLine());
            }
            myReader.close();
            matrix = new char[data.size()][data.get(0).length()];

            int a = data.get(0).length();
            for (int i = 0; i < data.size(); i++) {
                for (int j = 0; j < a; j++) {
                    char c = data.get(i).charAt(j);
                    if(c != '\n') {
                        matrix[i][j] = c;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    public char[][] getMatrix()
    {
        return matrix;
    }
}

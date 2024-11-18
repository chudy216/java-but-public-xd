package com.umk.app.io;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class MazeManager {
    private char[][] matrix = null;
    private List<String> mapa = new Vector<String>();

    public MazeManager(String file) {
        read(file);
    }

//    public void ReadFile(String fileName){
//
//    }
    public void read(String fileName) {
        try {
            File myObj = new File("src/main/resources/"+fileName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                mapa.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public char[][] getMatrix(){
        return matrix;
    }
    public List<String> getMapa(){
        return mapa;
    }
}

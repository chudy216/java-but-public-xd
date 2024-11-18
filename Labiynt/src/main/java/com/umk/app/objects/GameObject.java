package com.umk.app.objects;

abstract public class GameObject {
    private String objectName;
    private char objectFigure;
    private int objectXpos, objectYpos;

    public GameObject(String name, char objectFigure, int XPos, int YPos){
        this.objectName = name;
        this.objectFigure = objectFigure;
        this.objectYpos = YPos;
        this.objectXpos = XPos;
    }
    abstract void ChangePositon(int x, int y);
    public int getObjectXpos(){
        return objectXpos;
    }

    public int getObjectYpos() {
        return objectYpos;
    }

    public String getObjectName() {
        return objectName;
    }

    public char getObjectFigure() {
        return objectFigure;
    }
}

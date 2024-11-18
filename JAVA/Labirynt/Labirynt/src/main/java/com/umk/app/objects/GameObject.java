package com.umk.app.objects;

abstract class GameObject {
    private String objectName;
    private char objectFigure;
    protected int objectXpos,objectYpos;

    public GameObject(String name,char objectFigure,int Xpos,int Ypos)
    {
        this.objectName =name;
        this.objectFigure = objectFigure;
        this.objectXpos = Xpos;
        this.objectYpos = Ypos;
    }


    abstract void ChangePosition(int x,int y);

    public  int getPosX(){
        return  objectXpos;
    }
    public  int getPosY() {
        return objectYpos;
    }
    public  String getName()
    {
        return objectName;
    }
    public  char getObjectFigure()
    {
        return  objectFigure;
    }

}

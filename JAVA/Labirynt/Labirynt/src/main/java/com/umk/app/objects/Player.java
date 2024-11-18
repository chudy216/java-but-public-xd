package com.umk.app.objects;

public class Player extends GameObject{

    public Player (int x,int y,String name,char playerFigure) {
        super(name,playerFigure,x,y);
    }



    public void ChangePosition(int x, int y)
    {
        this.objectXpos = x;
        this.objectYpos = y;
    }
}

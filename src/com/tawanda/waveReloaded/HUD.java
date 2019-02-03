package com.tawanda.waveReloaded;

import java.awt.*;

public class HUD {


    public static int HEALTH =  100;



    private  int score =0;



    private int level =1;
    public void tick() {

    HEALTH = Game.Clamp(HEALTH,0,100);
        score +=1;

    }
    public void render(Graphics g){
        g.setColor(Color.white);
        g.fillRect(15,15,200,32);
        g.setColor(Color.GREEN);
        g.fillRect(15,15,HEALTH*2,32);
        g.drawString("Score: "+score,16,80);
        g.drawString("Level: "+level,16,100);
    }
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
    public static int getHEALTH() {
        return HEALTH;
    }

    public  void setHEALTH(int HEALTH) {
        HUD.HEALTH = HEALTH;
    }
}

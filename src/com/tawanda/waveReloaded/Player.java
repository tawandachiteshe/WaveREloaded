package com.tawanda.waveReloaded;

import java.awt.*;
import java.util.Random;

public class Player extends GameObject {
    Random r = new Random();
    Handler handler;
    public Player(float x, float y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        
        

    }


    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y,32,32);
    }

    public void tick() {
        x += velX;
        y +=velY;
        x = Game.Clamp((int)x,0,Game.WIDTH-48);
        y = Game.Clamp((int)y,0,Game.HEIGHT-71);
        collision();

    }

    private void collision() {

        for (int i = 0; i < handler.gameObjectLinkedList.size() ; i++) {

            GameObject tempObject = handler.gameObjectLinkedList.get(i);
            if(tempObject.getId()==ID.Enemy||tempObject.getId()==ID.Enemy2){
                if(getBounds().intersects(tempObject.getBounds())){
                    HUD.HEALTH= HUD.HEALTH-1;
                }
            }

        }
    }

    public void render(Graphics g) {
        Graphics2D graphics2D = (Graphics2D) g;
        g.setColor(Color.LIGHT_GRAY);
        graphics2D.draw(getBounds());
        g.setColor(Color.white);
        g.fillRect((int)x,(int)y,32,32);

    }

}

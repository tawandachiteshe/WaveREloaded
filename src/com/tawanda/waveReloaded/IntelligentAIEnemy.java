

package com.tawanda.waveReloaded;

import java.awt.*;

public class IntelligentAIEnemy extends GameObject {

   private GameObject player;
    private  Handler handler;
    public IntelligentAIEnemy(float x, float y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;


        for (int i = 0; i < handler.gameObjectLinkedList.size(); i++) {
            if (handler.gameObjectLinkedList.get(i).getId()==ID.Player) player = handler.gameObjectLinkedList.get(i);
        }


    }
    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y,16,16);
    }
    @Override
    public void tick() {

        x += velX;
        y +=  velY;
        float Diffx = x-player.getX()-16;
        float Diffy = y-player.getY()-16;
        float distance =(float) Math.sqrt( (x-player.getX()) * (x-player.getX()) + (y-player.getY()) * (y-player.getY()) );
        velX =((-1/distance)*Diffx);
        velY =((-1/distance)*Diffy);

       // if (y<=0||y>=Game.HEIGHT-55){velY*= -1;}
        //if (x<=0||x>=Game.WIDTH-32){velX*= -1;}
        handler.addObject(new Trail((int)x,(int)y,ID.Trail,16,16,0.1f,Color.red,handler));
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.orange);
        g.fillRect((int)x,(int)y,16,16);

    }


}

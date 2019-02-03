package com.tawanda.waveReloaded;

import java.awt.*;

public class Trail extends GameObject {
    private float alpha =1;
   private Handler handler;
    private Color color;
    private int width ,height;
    private float life;


    public Trail(float x, float y, ID id, int width, int height, float life, Color color, Handler handler) {
        super(x, y, id);
        this.color=color;
        this.height=height;
        this.width =   width;
        this.life = life;
        this.handler = handler;
    }

    @Override
    public void tick() {
        if (alpha>life){
            alpha-=(life-0.0001f);
        }else
            handler.removeObject(this);
    }

    @Override
    public void render(Graphics g) {
        Graphics2D graphics2D = (Graphics2D)g;
        graphics2D.setComposite(alphaComposite(alpha));
        g.setColor(color);
        g.fillRect((int)x,(int)y,width,height);
        graphics2D.setComposite(alphaComposite(1));


    }
    public AlphaComposite alphaComposite(float alpha){
        int type = AlphaComposite.SRC_OVER;

        return (AlphaComposite.getInstance(type,alpha));

    }
    @Override
    public Rectangle getBounds() {
        return null;
    }


}

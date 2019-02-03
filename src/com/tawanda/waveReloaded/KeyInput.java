package com.tawanda.waveReloaded;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
    private Handler handler;
    private Game game;
    private HUD hud;
    private Boolean[] keyDown = new Boolean[4];
    public  KeyInput(Handler handler){
        this.handler = handler;

        keyDown[0]=false; keyDown[1]=false; keyDown[2]=false; keyDown[3]=false;
    }
    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        for (int i = 0; i < handler.gameObjectLinkedList.size(); i++) {
            GameObject tempObject = handler.gameObjectLinkedList.get(i);

            if(tempObject.getId()==ID.Player){
                if(key==KeyEvent.VK_UP){ tempObject.setVelY(-5);  keyDown[0]=true;}
               else if(key==KeyEvent.VK_DOWN){ tempObject.setVelY(+5);keyDown[1]=true;}
                else if(key==KeyEvent.VK_LEFT){ tempObject.setVelX(-5);keyDown[2]=true;}
               else if(key==KeyEvent.VK_RIGHT) {tempObject.setVelX(+5);keyDown[3]=true;}
            }
            if (tempObject.getId()==ID.Enemy){
                if(key==KeyEvent.VK_SPACE){
                    tempObject.setVelX(0);
                    tempObject.setVelY(0);
                }
            }
            if(tempObject.getId()==ID.Player) {
                if (key == KeyEvent.VK_1) {
                    hud.setHEALTH(100);
                    game.start();
                }
            }
        }
        System.out.println(key);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        for (int i = 0; i < handler.gameObjectLinkedList.size(); i++) {
            GameObject tempObject = handler.gameObjectLinkedList.get(i);

            if(tempObject.getId()==ID.Player){
                if(key==KeyEvent.VK_UP)  keyDown[0]=false;//tempObject.setVelY(0);
                else if(key==KeyEvent.VK_DOWN) keyDown[1]=false;// tempObject.setVelY(0);}
                else if(key==KeyEvent.VK_LEFT)  keyDown[2]=false;//tempObject.setVelX(0)}
                else if(key==KeyEvent.VK_RIGHT)keyDown[3]=false;//tempObject.setVelX(0)}


                if(!keyDown[0]&&!keyDown[1]) tempObject.setVelY(0);
                if(!keyDown[2]&&!keyDown[3]) tempObject.setVelX(0);
            }


        }
        System.out.println(key);
    }
}

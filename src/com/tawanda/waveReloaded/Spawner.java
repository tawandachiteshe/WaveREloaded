package com.tawanda.waveReloaded;

import java.util.Random;

public class Spawner {

    private Handler handler;
    private HUD hud ;
    private Game game;
    private  int scoreKeep;
    private Random r = new Random();
    public Spawner (Handler handler,HUD hud){
        this.handler = handler;
        this.hud = hud;
    }

    public  void tick(){
        scoreKeep++;
        if(scoreKeep>=150){
            scoreKeep=0;
           hud.setLevel(hud.getLevel()+1);

            if (hud.getLevel() == 2) {
                for (int i = 0; i < 5; i++) {
                    handler.addObject(new Enemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.Enemy,handler));
                }
            }
            else if(hud.getLevel()==5){
                handler.addObject(new IntelligentAIEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.IntelligentAIEnemy,handler));
            }
        }
        if(hud.getHEALTH()<=0){

          handler.gameObjectLinkedList.clear();

        }
        }
    }


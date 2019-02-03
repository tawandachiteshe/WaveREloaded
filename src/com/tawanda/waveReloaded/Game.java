package com.tawanda.waveReloaded;

import java.awt.*;
import java.awt.Window;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable {
    public static final   int WIDTH = 800,HEIGHT=600;
    private Thread thread;
    public boolean running = false;
    private Handler handler;
    private Random r;
    private HUD hud;
    private  Spawner  spawner;



   public Game(){
       handler = new Handler();
       this.addKeyListener(new KeyInput(handler));
       new Window(WIDTH,HEIGHT,"Slither",this);
        hud = new HUD();
        spawner = new Spawner(handler,hud);

           handler.addObject(new Player(WIDTH/2-32,HEIGHT/2-32,ID.Player,handler));
           r = new Random();

      // handler.addObject(new Boss1((Game.WIDTH/2),-120,ID.Boss1,handler));




   }

    public  synchronized  void start(){
        thread = new Thread(this);
        thread.start();
        running=true;
    }
    public  synchronized  void stop(){
       try {
           thread.join();
           running=false;
       }catch (Exception e){
           e.printStackTrace();
       }
    }
    public void run() {
       this.requestFocus();
       long lastTime = System.nanoTime();
       double amountOfTicks = 60.0;
       double ns = 1_000_000_000/amountOfTicks;
       double delta = 0;
       long timer = System.currentTimeMillis();
        int frames =0;

        while (running){
            long now = System.nanoTime();
            delta +=(now -lastTime)/ns;
            lastTime=now;
            while (delta>=1){
                tick();
                delta--;
            }
            if(running){
                render();
                frames++;
            }
            if(System.currentTimeMillis()-timer>1000){
                timer+=1000;
                //System.out.println("FPS"+frames);
                frames = 0;
            }

        }
        stop();
    }
    private void tick(){
        handler.tick();
        hud.tick();
        spawner.tick();


    }
    private void   render(){
        BufferStrategy bufferStrategy = this.getBufferStrategy();
        if (bufferStrategy==null){
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bufferStrategy.getDrawGraphics();
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0,0,WIDTH,HEIGHT);

        handler.render(g);
        hud.render(g);
        g.dispose();

        bufferStrategy.show();


    }

    public  static  int Clamp (int var, int min ,int max){
       if(var >= max){
           return var = max;
       }else if(var<=min){
           return var = min;
       }else {
           return var;
       }
    }

    public static void main(String[] args){
    new Game();
    }
}

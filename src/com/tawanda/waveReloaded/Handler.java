package com.tawanda.waveReloaded;

import java.awt.*;
import java.util.GregorianCalendar;
import java.util.LinkedList;

public class Handler {
    LinkedList<GameObject> gameObjectLinkedList = new LinkedList<GameObject>();

    public void tick(){
        for (int i = 0; i <gameObjectLinkedList.size() ; i++) {
            GameObject tempGameobject = gameObjectLinkedList.get(i);
            tempGameobject.tick();

        }
    }
    public void render(Graphics g){
        for (int i = 0; i <gameObjectLinkedList.size() ; i++) {
            GameObject tempGameobject = gameObjectLinkedList.get(i);
            tempGameobject.render(g);

        }
    }
    public void addObject(GameObject object){
        this.gameObjectLinkedList.add(object);

    }
    public  void removeObject(GameObject object){
        this.gameObjectLinkedList.remove(object);
    }
}

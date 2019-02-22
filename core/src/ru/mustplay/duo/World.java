package ru.mustplay.duo;


import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.TimeUtils;

import java.util.ArrayList;
import java.util.Random;

import ru.mustplay.duo.sprites.Platform;

public class World {

    public int theNumberSmall = 10;
    public int theNumberLarge = 7;

    private int s = 0, m = 0, b = 0, l = 0;     //какую платформу передвинуть следующую вверх

    public ArrayList<Platform> smallPlatform;
    public ArrayList<Platform> mediumPlatform;
    public ArrayList<Platform> bigPlatform;
    public ArrayList<Platform> largePlatform;

    private long lastGenTime = 0;

    Random type;

    public World() {
        smallPlatform = new ArrayList<Platform>();
        mediumPlatform = new ArrayList<Platform>();
        bigPlatform = new ArrayList<Platform>();
        largePlatform = new ArrayList<Platform>();

        type = new Random();

        for (int i = 0; i < theNumberSmall; i++){
            Platform platformS = new Platform(0, 40, -200, 120, 100);
            smallPlatform.add(platformS);
            Platform platformM = new Platform(1, 40, -200, 200, 100);
            mediumPlatform.add(platformM);
        }
        for (int i = 0; i < theNumberLarge; i++){
            Platform platformB = new Platform(2, 40, -200, 321, 100);
            bigPlatform.add(platformB);
            Platform platformL = new Platform(3, 40, -200, 400, 100);
            largePlatform.add(platformL);
        }
    }

    public void update(float dt){
        for (int i = 0; i < theNumberSmall; i++){
            smallPlatform.get(i).update(dt);
            mediumPlatform.get(i).update(dt);
        }
        for (int i = 0; i < theNumberLarge; i++){
            bigPlatform.get(i).update(dt);
            largePlatform.get(i).update(dt);
        }

        if(TimeUtils.nanoTime() - lastGenTime > 2000000000)
            generatePlatform();
    }

    public void render(SpriteBatch sb){
        for (int i = 0; i < theNumberSmall; i++){
            smallPlatform.get(i).render(sb);
            mediumPlatform.get(i).render(sb);
        }
        for (int i = 0; i < theNumberLarge; i++){
            bigPlatform.get(i).render(sb);
            largePlatform.get(i).render(sb);
        }
    }

    public void generatePlatform(){
        switch (type.nextInt(20) / 2 + type.nextInt(6)){
            case 0 : smallPlatform.get(s % theNumberSmall).position.set(40, 1280);
                s++;
                break;
            case 1 : mediumPlatform.get(m % theNumberSmall).position.set(40, 1280);
                m++;
                break;
            case 2 : bigPlatform.get(b % theNumberLarge).position.set(40, 1280);
                b++;
                break;
            case 3 : largePlatform.get(l % theNumberLarge).position.set(40, 1280);
                l++;
                break;
            case 4 : smallPlatform.get(s % theNumberSmall).position.set(560, 1280);
                s++;
                break;
            case 5 : mediumPlatform.get(m % theNumberSmall).position.set(480, 1280);
                m++;
                break;
            case 6 : bigPlatform.get(b % theNumberLarge).position.set(359, 1280);
                b++;
                break;
            case 7 : largePlatform.get(l % theNumberLarge).position.set(280, 1280);
                l++;
                break;
            case 8 : largePlatform.get(l % theNumberLarge).position.set(160, 1280);
                l++;
                break;
            case 9 : smallPlatform.get(s % theNumberSmall).position.set(40, 1280);
                s++;
                smallPlatform.get(s % theNumberSmall).position.set(560, 1280);
                s++;
                break;
            case 10 : mediumPlatform.get(m % theNumberSmall).position.set(40, 1280);
                m++;
                mediumPlatform.get(m % theNumberSmall).position.set(480, 1280);
                m++;
                break;
            case 11 : mediumPlatform.get(m % theNumberSmall).position.set(40, 1280);
                m++;
                smallPlatform.get(s % theNumberSmall).position.set(560, 1280);
                s++;
                break;
            case 12 : mediumPlatform.get(m % theNumberSmall).position.set(480, 1280);
                m++;
                smallPlatform.get(s % theNumberSmall).position.set(40, 1280);
                s++;
                break;
            case 13 :  smallPlatform.get(s % theNumberSmall).position.set(40, 1280);
                s++;
                smallPlatform.get(s % theNumberSmall).position.set(300, 1280);
                s++;
                smallPlatform.get(s % theNumberSmall).position.set(560, 1280);
                s++;
                break;
            case 14: mediumPlatform.get(m % theNumberSmall).position.set(40, 1280);
                m++;
                smallPlatform.get(s % theNumberSmall).position.set(420, 1280);
                s++;
                break;
            case 15: mediumPlatform.get(m % theNumberSmall).position.set(340, 1280);
                m++;
                smallPlatform.get(s % theNumberSmall).position.set(40, 1280);
                s++;
                break;
            default: smallPlatform.get(s % theNumberSmall).position.set(40, 1280);
                s++;
                break;
        }

        lastGenTime = TimeUtils.nanoTime();
    }
}

package ru.mustplay.duo.sprites;


import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

import ru.mustplay.duo.Assets;
import ru.mustplay.duo.DuoGame;

public class Rect {

    public final float VELOCITY = 400;

    public boolean isIntersect = false;

     //Vector3 тут потому что camera.unproject() работает только с ним
    public Vector3 posRightRect;
    public Vector3 posLeftRect;

    public Vector2 velocityLeft;
    public Vector2 velocityRight;

    public Rectangle rightRect;
    public Rectangle leftRect;

    public Rect() {
        posLeftRect = new Vector3(DuoGame.WIDTH / 2 - Assets.lRect.getRegionWidth(), DuoGame.WIDTH / 2, 0);
        posRightRect = new Vector3(DuoGame.WIDTH / 2, DuoGame.WIDTH / 2, 0);

        rightRect = new Rectangle(posRightRect.x, posRightRect.y, 100, 100);
        leftRect = new Rectangle(posLeftRect.x, posLeftRect.y, 100, 100);

        velocityRight = new Vector2(VELOCITY, 0);
        velocityLeft = new Vector2(-VELOCITY, 0);
    }

    public void update(float dt){
        posLeftRect.add(velocityLeft.x * dt, 0, 0);
        posRightRect.add(velocityRight.x * dt, 0, 0);

        collision();

        rightRect.setPosition(posRightRect.x, posRightRect.y);
        leftRect.setPosition(posLeftRect.x, posLeftRect.y);
    }

    private void collision(){


        if (posLeftRect.x >= 580) posLeftRect.x = 580;

        if (posRightRect.x <= 40) posRightRect.x = 40;

        if (posRightRect.x >= 580) posRightRect.x = 580;

        if (posLeftRect.x + 100 >= posRightRect.x) {
            posLeftRect.x = posRightRect.x - 100;
            isIntersect = true;
        } else isIntersect = false;

        if (posLeftRect.x <= 40) posLeftRect.x = 40;

        if (posRightRect.x - 100 <= posLeftRect.x)
            posRightRect.x = posLeftRect.x + 100;
    }

    public void render(SpriteBatch sb){
        sb.draw(Assets.lRect, posLeftRect.x, posLeftRect.y);
        sb.draw(Assets.rRect, posRightRect.x, posRightRect.y);
    }
}

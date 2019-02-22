package ru.mustplay.duo.sprites;


import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.mustplay.duo.Assets;
import ru.mustplay.duo.states.PlayState;
import sun.rmi.runtime.Log;

public class Platform {

    private static final short VELOCITY = 200;

    public TextureRegion texture;
    private Vector2 velocity;
    public Vector2 position;
    private int smallId, mediumId, bigId, largeId;

    public Platform(int type, float x, float y, float width, float hight) {
        position = new Vector2(x, y);
        velocity = new Vector2(0, VELOCITY);

        switch (type){
            case 0 : texture = new TextureRegion(Assets.smallPlatform);
                break;
            case 1 : texture = new TextureRegion(Assets.mediumPlatform);
                break;
            case 2 : texture = new TextureRegion(Assets.bigPlatform);
                break;
            case 3 : texture = new TextureRegion(Assets.largePlatform);
                break;
            default : Log.getLog("Something wrong with texture choice!", "Something wrong with texture choice!", false);
        }
    }

    public void update(float dt){
        position.add(0, -velocity.y * dt);
    }

    public void render(SpriteBatch sb){
        sb.draw(texture, position.x, position.y);
    }
}

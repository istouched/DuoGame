package ru.mustplay.duo.states;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

import ru.mustplay.duo.Assets;
import ru.mustplay.duo.DuoGame;
import ru.mustplay.duo.World;
import ru.mustplay.duo.sprites.Rect;

public class PlayState extends State{

    private Vector3 touch;

    private World world;

    private Rect rect;

    public PlayState(GameStateManager gsm) {
        super(gsm);
        camera.setToOrtho(false, DuoGame.WIDTH, DuoGame.HEIGHT);

        touch = new Vector3(0, 0, 0);

        rect = new Rect();
        world = new World();
    }

    @Override
    protected void handleInput() {
        if (Gdx.input.isTouched(0) && Gdx.input.getX(0) < DuoGame.WIDTH / 2 ||
                Gdx.input.isTouched(1) && Gdx.input.getX(1) < DuoGame.WIDTH / 2) {
           if (rect.isIntersect)
               rect.velocityLeft.x = 0;
           else
               rect.velocityLeft.x = rect.VELOCITY;
        } else
            rect.velocityLeft.x = -rect.VELOCITY;


        if (Gdx.input.isTouched(0) && Gdx.input.getX(0) > DuoGame.WIDTH / 2 ||
                Gdx.input.isTouched(1) && Gdx.input.getX(1) > DuoGame.WIDTH / 2) {
            if (rect.isIntersect)
                rect.velocityRight.x = 0;
            else
                rect.velocityRight.x = -rect.VELOCITY;
        } else
            rect.velocityRight.x = rect.VELOCITY;
    }

    @Override
    public void update(float dt) {
        handleInput();

        rect.update(dt);
        world.update(dt);
    }

    @Override
    public void render(SpriteBatch sb) {
        camera.update();
        sb.setProjectionMatrix(camera.combined);

        sb.begin();
        sb.draw(Assets.bg, 0, 0, DuoGame.WIDTH, DuoGame.HEIGHT);
        sb.draw(Assets.side, 0, 0);
        sb.draw(Assets.side, DuoGame.WIDTH - Assets.side.getRegionWidth(), 0);

        world.render(sb);
        rect.render(sb);

        sb.end();
    }

    @Override
    public void dispose() {

    }
}

package ru.mustplay.duo.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import ru.mustplay.duo.Assets;
import ru.mustplay.duo.DuoGame;

public class MenuState extends State{


    private BitmapFont whiteFont;
    public MenuState(GameStateManager gsm) {
        super(gsm);

        whiteFont = new BitmapFont();
        whiteFont.setColor(Color.WHITE);
    }

    @Override
    protected void handleInput() {
        if (Gdx.input.justTouched())
            gsm.set(new PlayState(gsm));
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(Assets.bg, 0, 0, DuoGame.WIDTH, DuoGame.HEIGHT);
        whiteFont.draw(sb, "Press START", 300, 600);
        sb.end();
    }

    @Override
    public void dispose() {

    }
}

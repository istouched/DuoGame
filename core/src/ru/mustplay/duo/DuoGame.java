package ru.mustplay.duo;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import ru.mustplay.duo.states.GameStateManager;
import ru.mustplay.duo.states.MenuState;
import ru.mustplay.duo.states.PlayState;

public class DuoGame extends ApplicationAdapter {

	public static int WIDTH = 720;
    public static int HEIGHT = 1280;

    private GameStateManager gsm;
	private SpriteBatch batch;
	
	@Override
	public void create () {
		Assets.load();
		batch = new SpriteBatch();
        gsm = new GameStateManager();
        Gdx.gl.glClearColor(1, 0, 0, 1);
        gsm.push(new MenuState(gsm));
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gsm.update(Gdx.graphics.getDeltaTime());
        gsm.render(batch);
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}

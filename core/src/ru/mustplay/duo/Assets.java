package ru.mustplay.duo;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;


public class Assets {

    public static Texture items;
    public static TextureRegion bg;
    public static TextureRegion rRect;
    public static TextureRegion lRect;
    public static TextureRegion side;
    public static TextureRegion smallPlatform;
    public static TextureRegion mediumPlatform;
    public static TextureRegion bigPlatform;
    public static TextureRegion largePlatform;

    public static void load(){
        items = new Texture("items.png");
        bg = new TextureRegion(items, 0, 0, 720, 1280);
        rRect = new TextureRegion(items, 760, 0, 100, 100);
        lRect = new TextureRegion(items, 860, 0, 100, 100);
        side = new TextureRegion(items, 720, 0, 40, 1280);
        smallPlatform = new TextureRegion(items, 760, 100, 120, 100);
        mediumPlatform = new TextureRegion(items, 760, 200, 200, 100);
        bigPlatform = new TextureRegion(items, 760, 300, 320, 100);
        largePlatform = new TextureRegion(items, 760, 400, 400, 100);
    }
}

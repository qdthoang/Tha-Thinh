package com.game.thathinh;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;

import java.util.Iterator;

public class ThaThinh extends ApplicationAdapter {
    private SpriteBatch batch;

    private int screenWidth;
    private int screenHeight;
    private ICustomHandler handler;

    private Texture girlImage;
    private Rectangle girl;

    private Texture thinhImage;
    private Array<Rectangle> thinhs;
    private long lastDropTime;

    public ThaThinh(int screenWidth, int screenHeight, ICustomHandler handler) {
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        this.handler = handler;
    }

    @Override
    public void create() {
        batch = new SpriteBatch();

        girlImage = new Texture("girl_color.png");
        girl = new Rectangle();
        girl.x = screenWidth / 2 - girlImage.getWidth() / 2;
        girl.y = 0;
        girl.width = girlImage.getWidth();
        girl.height = girlImage.getHeight();

        thinhImage = new Texture("note2.png");
        thinhs = new Array<Rectangle>();
        spawnThinh();
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        batch.draw(girlImage, girl.x, girl.y);
        for (Rectangle thinh : thinhs) {
            batch.draw(thinhImage, thinh.x, thinh.y);
        }
        batch.end();

        girl.x -= Gdx.input.getAccelerometerX() * 5;
        if (girl.x < 0) girl.x = 0;
        if (girl.x > screenWidth - girlImage.getWidth())
            girl.x = screenWidth - girlImage.getWidth();

        if (TimeUtils.nanoTime() - lastDropTime > 1500000000) spawnThinh();

        Iterator<Rectangle> thinhIter = thinhs.iterator();
        while (thinhIter.hasNext()) {
            Rectangle thinh = thinhIter.next();
            thinh.y -= 200 * Gdx.graphics.getDeltaTime();
            if (thinh.y + thinhImage.getHeight() < 0) thinhIter.remove();
            if (thinh.overlaps(girl)) {
                handler.callGameIntent();
            }
        }
    }

    @Override
    public void dispose() {
        batch.dispose();
        girlImage.dispose();
        thinhImage.dispose();
    }

    private void spawnThinh() {
        Rectangle thinh = new Rectangle();
        thinh.x = MathUtils.random(0, screenWidth - thinhImage.getWidth());
        thinh.y = screenHeight;
        thinh.width = thinhImage.getWidth();
        thinh.height = thinhImage.getHeight();
        thinhs.add(thinh);
        lastDropTime = TimeUtils.nanoTime();
    }
}

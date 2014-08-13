package com.rahul.libgdx.parallax;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;

/**
 * 
 * This is an abstract class that encapsulates the logic of a Parallaxly Scrolling layer that ParallaxBackground renders. 
 * It stores the ratio at which the layer has to scroll relatively. You can extend this class and implement its internal modal and rendering logic. This has an advantage over using just TextureRegions as layers of ParallaxBackground. 
 * Also see {@link TextureRegionParallaxLayer} as it is the direct extension of this class and ready to use if you want to render single texture region per layer repeatedly. 
 * <p>
 * As an example, consider you need to render 20 colored dots per camera viewport width over background. The balls need to scroll with the world camera, but with the parallax effect . Now you can extend this class to create your own balls layer with internal logic to maintain the balls(logically) and render them.
 * @author Rahul Verma
 *
 */
public abstract class ParallaxLayer {
	
	/**
	 * 
	 * TileMode basically represents the way a layer has to repeat itself while scrolling. Parallax Scrolling can be performed infinitely in any direction if TileMode is set to <b>TileMode.repeat</b> in that direction. 
	 * The layer will just keep on repeating itself. Specifying <b>TileMode.single</b> makes the layer render only once without repeating in a direction
	 * @author Rahul
	 *
	 */
	public enum TileMode{
		repeat,single
	}
	
	

	protected Vector2 parallaxRatio;
	protected TileMode tileModeX = TileMode.repeat;
	protected TileMode tileModeY = TileMode.single;
	
	/**
	 * returns the width of this layer. This width basically represents segment width of this layer after which it either repeats itself while rendering or just ceases to render further, depending upon the horizontal TileMode (see {@link #setTileModeX(TileMode)})
	 * @return width of the layer
	 */
	public abstract float getWidth();

	/**
	 * returns the height of this layer. This height basically represents segment height of this layer after which it either repeats itself while rendering or just ceases to render further, depending upon the vertical TileMode (see {@link #setTileModeY(TileMode)})
	 * @return returns the height of this layer
	 */
	public abstract float getHeight();




    /**
     * get the Vector2 that contains the parallax scrolling ratio of this layer in x and y direction.
     * @return parallax scrolling ratio
     */
	public Vector2 getParallaxRatio() {
		return parallaxRatio;
	}


	/**
     * set the parallax scrolling ratio of this layer in x and y direction.
     * @return parallax scrolling ratio
     */
	public void setParallaxRatio(Vector2 parallaxRatio) {
		if(this.parallaxRatio == null)
			this.parallaxRatio = new Vector2();
		this.parallaxRatio.set(parallaxRatio);
	}
	
	/**
     * set the parallax scrolling ratio of this layer in x and y direction.
     * @param ratioX scrolling ratio in x direction
     * @param ratioY scrolling ratio in y direction
     */
	public void setParallaxRatio(float ratioX, float ratioY) {
		if(this.parallaxRatio == null)
			this.parallaxRatio = new Vector2();
		this.parallaxRatio.set(ratioX,ratioY);
	}


	/**
	 * draw this layer at specified position. Make sure that when you implement or extend this method you draw this layer within bounds returned by {@link #getWidth()} and {@link #getHeight()}. 
	 * @param batch the batch used for rendering
	 * @param pos the position of the lower left corner where rendering should be done
	 */
	public void draw(Batch batch,Vector2 pos){
		this.draw(batch, pos.x, pos.y);
	}
	
	/**
	 * draw this layer at specified position. Make sure that when you implement or extend this method you draw this layer within bounds returned by {@link #getWidth()} and {@link #getHeight()}. 
	 * @param batch the batch used for rendering
	 * @param x the x position of the lower left corner where rendering should be done
	 * @param y the y position of the lower left corner where rendering should be done
	 */
	public abstract void draw(Batch batch,float x, float y);

	/**
	 * get the {@link TileMode} in x direction
	 * @return TileMode in x direction
	 */
	public TileMode getTileModeX() {
		return tileModeX;
	}

	/**
	 * set the {@link TileMode} in x direction
	 * @param tileModeX TileMode in x direction
	 */
	public void setTileModeX(TileMode tileModeX) {
		this.tileModeX = tileModeX;
	}

	/**
	 * get the {@link TileMode} in y direction
	 * @return TileMode in y direction
	 */
	public TileMode getTileModeY() {
		return tileModeY;
	}

	/**
	 * set the {@link TileMode} in y direction
	 * @param tileModeY TileMode in y direction
	 */
	public void setTileModeY(TileMode tileModeY) {
		this.tileModeY = tileModeY;
	}

}

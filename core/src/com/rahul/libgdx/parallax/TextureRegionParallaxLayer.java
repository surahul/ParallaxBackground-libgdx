package com.rahul.libgdx.parallax;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.rahul.libgdx.parallax.Utils.WH;

/**
 * 
 * TextureRegionParallaxLayer is the direct extension of {@link ParallaxLayer}. It represents a layer in the parallax scrolling background with just one texture region per layer . It still is very nifty and useful as it encapsulates the logic of padding in all the directions.
 * The padding can help you avoid using single full screen texture regions of background.
 * <p>
 * As an example let us suppose you wish to render repeatedly a single cloud region with 1/10  the width and height of the screen . You wish to render it at half way above the screen baseline. An plus no more than one could should be there within one screen width. You can easily achieve this using proper bottom, left and right padding in this layer  
 * @author Rahul
 *
 */
public class TextureRegionParallaxLayer extends ParallaxLayer{

	private TextureRegion texRegion;
	private float padLeft=0,padRight=0,padBottom=0,padTop=0;
	private float regionWidth,regionHeight;
	
	/**
	 * Creates a TextureRegionParallaxLayer with regionWidth and regionHeight equal that of the texRegion. Paddings are set to 0.
	 * @param texRegion the texture region
	 * @param parallaxScrollRatio the parallax ratio in x and y direction
	 */
	public TextureRegionParallaxLayer(TextureRegion texRegion, Vector2 parallaxScrollRatio){
		this.texRegion = texRegion;
		setRegionWidth(texRegion.getRegionWidth());
		setRegionHeight(texRegion.getRegionHeight());
		setParallaxRatio(parallaxScrollRatio);
	}
	
	/**
	 * Creates a TextureRegionParallaxLayer with regionWidth and regionHeight equal to parameters width and height. Paddings are set to 0.
	 * @param texRegion the texture region
	 * @param width width to be used as regionWidth
	 * @param height height to be used as regionHeight
	 * @param parallaxScrollRatio the parallax ratio in x and y direction
	 */
	public TextureRegionParallaxLayer(TextureRegion texRegion, float regionWidth, float regionHeight, Vector2 parallaxScrollRatio){
		this.texRegion = texRegion;
		setRegionWidth(regionWidth);
		setRegionHeight(regionHeight);
		setParallaxRatio(parallaxScrollRatio);
	}
	
	/**
	 * Creates a TextureRegionParallaxLayer with either regionWidth or regionHeight equal oneDimen specified, while the other is calculated maintaining the aspect ratio of the region. Paddings are set to 0.
	 * @param texRegion texRegion the texture region
	 * @param oneDimen either regionWidth of regionHeight
	 * @param parallaxScrollRatio the parallax ratio in x and y direction
	 * @param wh what does oneDimen represent
	 */
	public TextureRegionParallaxLayer(TextureRegion texRegion, float oneDimen, Vector2 parallaxScrollRatio, WH wh){
		this.texRegion = texRegion;
		switch(wh){
		    case width:
		    	setRegionWidth(oneDimen);
		    	setRegionHeight(Utils.calculateOtherDimension(WH.width, oneDimen, this.texRegion));
		    	break;
		    case height:
		    	setRegionHeight(oneDimen);
		    	setRegionWidth(Utils.calculateOtherDimension(WH.height, oneDimen, this.texRegion));
		    	break;
		}
		setParallaxRatio(parallaxScrollRatio);
	}
	
	
	
	/**
	 * draws the texture region at x y ,with left and bottom padding 
	 * <p>
	 * You might be wondering that why are topPadding and rightPadding not used , what is their use then . Well they are used by ParallaxBackground when it renders this layer . During rendering it pings the {@link #getWidth()}/{@link #getHeight()} method of this layer which in {@link TextureRegionParallaxLayer} implementation return the sum of regionWidth/regionHeight and paddings.
	 */
	@Override
	public void draw(Batch batch, float x, float y) {
		batch.draw(texRegion, x+padLeft, y+padBottom, getRegionWidth(), getRegionHeight());
	}
	
	

	/**
	 * returns the width of this layer (regionWidth+padLeft+padRight)
	 */
	@Override
	public float getWidth() {
		return getPadLeft()+getRegionWidth()+getPadRight();
	}

	/**
	 * returns the height of this layer (regionHeight+padTop+padBottom)
	 */
	@Override
	public float getHeight() {
		return getPadTop()+getRegionHeight()+getPadBottom();
	}
	
	/**
	 * sets left right top bottom padding to same value
	 * @param pad padding
	 */
	public void setAllPad(float pad){
		setPadLeft(pad);
		setPadRight(pad);
		setPadTop(pad);
		setPadBottom(pad);
	}

	/**
	 * returns texture region of this layer
	 * @return texture region
	 */
	public TextureRegion getTexRegion() {
		return texRegion;
	}

	/**
	 * get left padding
	 * @return left padding
	 */
	public float getPadLeft() {
		return padLeft;
	}

	/**
	 * sets the left padding
	 * @param left padding
	 */
	public void setPadLeft(float padLeft) {
		this.padLeft = padLeft;
	}

	/**
	 * get right padding
	 * @return right padding
	 */
	public float getPadRight() {
		return padRight;
	}

	/**
	 * sets the right padding
	 * @param right padding
	 */
	public void setPadRight(float padRight) {
		this.padRight = padRight;
	}

	/**
	 * get bottom padding
	 * @return bottom padding
	 */
	public float getPadBottom() {
		return padBottom;
	}

	/**
	 * sets the bottom padding
	 * @param bottom padding
	 */
	public void setPadBottom(float padBottom) {
		this.padBottom = padBottom;
	}

	/**
	 * get top padding
	 * @return top padding
	 */
	public float getPadTop() {
		return padTop;
	}

	/**
	 * sets the top padding
	 * @param top padding
	 */
	public void setPadTop(float padTop) {
		this.padTop = padTop;
	}


	/**
	 * return the region width of this layer
	 * @return region width
	 */
	public float getRegionWidth() {
		return regionWidth;
	}
	
	/**
	 * return the region height of this layer
	 * @return region height
	 */
	public float getRegionHeight() {
		return regionHeight;
	}

	
	private void setRegionWidth(float width){
		this.regionWidth = width;
	}
	private void setRegionHeight(float height){
		this.regionHeight = height;
	}
}

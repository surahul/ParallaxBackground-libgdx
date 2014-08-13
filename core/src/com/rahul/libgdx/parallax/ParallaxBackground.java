package com.rahul.libgdx.parallax;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.rahul.libgdx.parallax.ParallaxLayer.TileMode;
/**
 * A ParallaxBacground encapsulates the logic to Render ParallaxLayers.
 * It owns a collection of ParallaxLayers. 
 * These Layers a rendered on screen showing parallax effect based on scrolling characteristics of individual layers. 
 * This rendering module does not owns any Batch ,you need to provide one in the draw method. 
 * <p>
 * Also see {@link ParallaxLayer}. 
 * @author Rahul Verma
 *
 */
public class ParallaxBackground {
	
	/**
	 * this array contains the parallax scrolling layers that are drawn on the screen. Layers are rendered in the order they are present in this array.
	 */
	public Array<ParallaxLayer> layers;
	private Matrix4 cachedProjectionView;
	private Vector3 cachedPos;
	private float cachedZoom;
	
	/**
	 * Create a ParallaxBackground without any layers
	 */
	public ParallaxBackground(){
		initialize();
	}
	
	

	/**
	 * Create a ParallaxBackground instance with the layers added
	 * @param layers layers to be added to the parallaxBackground
	 */
	public ParallaxBackground(ParallaxLayer... layers){
		initialize();
		this.layers.addAll(layers);
	}
	
    private void initialize() {
    	layers = new Array<ParallaxLayer>();
		cachedPos = new Vector3();
		cachedProjectionView = new Matrix4();
	}
	
	/**
	 * Add the layers to the {@link #layers} array. These layers are rendered over the layers previously in the layers array
	 * @param layers layers to be added to the parallaxBackground
	 */
	public void addLayers(ParallaxLayer... layers){
		this.layers.addAll(layers);
	}
	
	/**
	 * render the layers held by this module. Of course the layers are rendered in parallax scrolling manner. The worldCamera and batch provided are unaffected by the method
	 * @param worldCamera The Orthographic WorldCamera , all layers are rendered relative to its position.
	 * @param batch The batch which is used to render the layers.
	 */
	public void draw(OrthographicCamera worldCamera, Batch batch){
		cachedProjectionView.set(worldCamera.combined);
		cachedPos.set(worldCamera.position);
		cachedZoom = worldCamera.zoom;
		
		
		for(int i=0; i<layers.size; i++){
			ParallaxLayer layer = layers.get(i);
			Vector2 origCameraPos = new Vector2(cachedPos.x,cachedPos.y);
			worldCamera.position.set(origCameraPos.scl(layer.getParallaxRatio()),cachedPos.z);
		    worldCamera.update();
		    batch.setProjectionMatrix(worldCamera.combined);
		    float currentX = (layer.getTileModeX().equals(TileMode.single)?0:((int)((worldCamera.position.x-worldCamera.viewportWidth*.5f*worldCamera.zoom) / layer.getWidth())) * layer.getWidth())-(Math.abs((1-layer.getParallaxRatio().x)%1)*worldCamera.viewportWidth*.5f);
			do{
		            float currentY =  (layer.getTileModeY().equals(TileMode.single)?0:((int)((worldCamera.position.y-worldCamera.viewportHeight*.5f*worldCamera.zoom) / layer.getHeight())) * layer.getHeight())-(((1-layer.getParallaxRatio().y)%1)*worldCamera.viewportHeight*.5f);
		            do{
		               if(!((worldCamera.position.x-worldCamera.viewportWidth*worldCamera.zoom*.5f>currentX+layer.getWidth())||(worldCamera.position.x+worldCamera.viewportWidth*worldCamera.zoom*.5f<currentX)||(worldCamera.position.y-worldCamera.viewportHeight*worldCamera.zoom*.5f>currentY+layer.getHeight())||(worldCamera.position.y+worldCamera.viewportHeight*worldCamera.zoom*.5f<currentY)))
		                   layer.draw(batch, currentX, currentY);
		               currentY += layer.getHeight();
		               if(layer.getTileModeY().equals(TileMode.single))
			        	     break;
		            }while( currentY < worldCamera.position.y+worldCamera.viewportHeight*worldCamera.zoom*.5f);
		            currentX += layer.getWidth();
		            if(layer.getTileModeX().equals(TileMode.single))
		        	     break;
		         }while( currentX < worldCamera.position.x+worldCamera.viewportWidth*worldCamera.zoom*.5f);
		     
		}
		
		worldCamera.combined.set(cachedProjectionView);
		worldCamera.position.set(cachedPos);
		worldCamera.zoom = cachedZoom;
		worldCamera.update();
		batch.setProjectionMatrix(worldCamera.combined);
	    
	}
	

}

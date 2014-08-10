package com.rahul.libgdx.parallax;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
/**
 * utility class for common calculations
 * @author Rahul Verma
 *
 */
public class Utils {

	public enum WH{
		width, height
	}
	
	/**
	 * calculate new width/height maintaining aspect ratio
	 * @param wh what oneDimen represents
	 * @param oneDimen either width or height 
	 * @param region the texture region
	 * @return if oneDimen is width then height else width
	 */
	public static float calculateOtherDimension(WH wh,float oneDimen,TextureRegion region){
		float result=0;
		switch (wh){
		    // height_specified
		    case width:
    		    result = region.getRegionHeight()*(oneDimen/region.getRegionWidth());
		    	break;
		    // width_specified
	    	case height:
	    		result = region.getRegionWidth()*(oneDimen/region.getRegionHeight());
		    	break;
		
		}
		
		return result;
		
	}
	
	/**
	 * calculate new width/height maintaining aspect ratio
	 * @param wh what oneDimen represents
	 * @param oneDimen either width or height 
	 * @param originalWidth the original width
	 * @param originalHeight the original height
	 * @return if oneDimen is width then height else width
	 */
	public static float calculateOtherDimension(WH wh,float oneDimen,float originalWidth, float originalHeight){
		float result=0;
		switch (wh){
		    case width:
    		    result = originalHeight*(oneDimen/originalWidth);
		    	break;
	    	case height:
	    		result = originalWidth*(oneDimen/originalHeight);
		    	break;
		
		}
		
		return result;
		
	}
	
	
}

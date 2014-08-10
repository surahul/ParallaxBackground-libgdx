package com.rahul.libgdx.parallax;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Utils {

	public enum WH{
		width, height
	}
	
	public static float calculateOtherDimension(WH wh,float dimension,TextureRegion region){
		float result=0;
		switch (wh){
		    // height_specified
		    case width:
    		    result = region.getRegionHeight()*(dimension/region.getRegionWidth());
		    	break;
		    // width_specified
	    	case height:
	    		result = region.getRegionWidth()*(dimension/region.getRegionHeight());
		    	break;
		
		}
		
		return result;
		
	}
	public static float calculateOtherDimension(WH wh,float newDimension,float originalWidth, float originalHeight){
		float result=0;
		switch (wh){
		    case width:
    		    result = originalHeight*(newDimension/originalWidth);
		    	break;
	    	case height:
	    		result = originalWidth*(newDimension/originalHeight);
		    	break;
		
		}
		
		return result;
		
	}
	
	
}

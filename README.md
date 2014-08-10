ParallaxBackground-libgdx
=========================

An Open Source utility for having Parallax Scrolling effect in your libgdx game.
The approach of this utility is to have generic layers, i.e. you can either use the TextureRegionParallaxLayer out of the box, or extend the basic ParallaxLayer to define your own layer rendering logic

Feel free to use this utility in your project, it would be great if you could mention this project in the credits section of your game :).


Features
-----
The utility has the following features:
* You can use it to render parallax scrolling layers as background of your game. Each layer has its local x and y scroll ratio which decide how slow or fast the layer scrolls relative to the normal scrolling
* You can use the TextureRegionParallaxLayer out of the box to make texture region as a layer of parallax background.
  *  I is not necessary that each texture region of this layer be full screen . You can define top bottom left and right padding of the layer. This helps you have full screen repeating layer without the texture region of being fullscreen resolution.
*Each layer can have either Single or Repeat TileMode in x and y direction.

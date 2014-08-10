ParallaxBackground-libgdx
=========================

An Open Source utility for having Parallax Scrolling effect in your libgdx game.
The approach of this utility is to have generic layers, i.e. you can either use the TextureRegionParallaxLayer out of the box, or extend the basic ParallaxLayer to define your own layer rendering logic

Feel free to use this utility in your project, it would be great if after using it, you could mention this project in the credits section of your game :).


Features
-----
The utility has the following features:
* You can use it to render parallax scrolling layers as background of your game. Each layer has its local x and y scroll ratio which decide how slow or fast the layer scrolls relative to the normal scrolling
* You can use the TextureRegionParallaxLayer out of the box to make single texture region as a layer of parallax background.
  * It is not necessary that the texture region of this layer be full screen . You can define top bottom left and right padding of the layer. This helps you have any resolution layer, without the texture region necessarily being of the same resolution.
* Each layer can have either Single or Repeat TileMode in x and y direction.
* The basic ParallaxLayer is abstract , i.e. you can extend it to have your own layer logic and render it your own way. You can then render any numbr of meshes, shapes, region in your layer.

Setup
-----

* Just copy the package com.rahul.libgdx.parallax and it classes (without test classes) in the src directory of your core libgdx project 

Usage
-----
Please see the GameListener class (a test) in the com.rahul.libgdx.parallax.test package. It is really easy to use this utility. The test pretty much explains everything.

Moreover all the classes are extremely well documented so you wont get lost.

Contribute
-----
Please do contribute if you feel like adding new features or improving present code. I will actively review and accept pull requests.

Developed By
-----
Rahul Verma

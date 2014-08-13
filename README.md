[![Flattr this git repo](http://api.flattr.com/button/flattr-badge-large.png)](https://flattr.com/submit/auto?user_id=rahul_verma&url=https://github.com/fooble/ParallaxBackground-libgdx&title=ParallaxBackground-libgdx&language=&tags=github&category=software)

ParallaxBackground-libgdx
=========================

An Open Source utility for having Parallax Scrolling effect in your [libgdx][1] game.
The approach of this utility is to have generic layers, i.e. you can either use the [TextureRegionParallaxLayer][2] out of the box, or extend the basic [ParallaxLayer][3] to define your own layer rendering logic.

Feel free to use this utility in your project, it would be great if after using it, you could mention this project in the credits section of your game :).


Features
-----
The utility has the following features:
* You can use it to render parallax scrolling layers as background of your game. Each layer has its local x and y scroll ratio which decide how slow or fast the layer scrolls relative to the normal scrolling.
* You can use the [TextureRegionParallaxLayer][2] out of the box to make single texture region as a layer of parallax background.
  * It is not necessary that the texture region of this layer be full screen. You can define top bottom left and right padding of the layer. This helps you have any resolution layer, without the texture region necessarily being of the same resolution.
* Each layer can have either Single or Repeat TileMode in x and y direction.
* The basic [ParallaxLayer][3] is abstract , i.e. you can extend it to have your own layer logic and render it your own way. You can then render any numbr of meshes, shapes, region in your layer.

Setup
-----

* Just copy the package [com.rahul.libgdx.parallax][4] and it classes (without test classes) in the src directory of your core libgdx project 

Usage
-----
Please see the [GameListener][5] class (a test) in the [com.rahul.libgdx.parallax.test][6] package. It is really easy to use this utility. The test pretty much explains everything.

Moreover all the classes are extremely well documented so you wont get lost.

Known Issues
-----
* Your world camera cannot enter any quadrant other than first . i.e. it fails for negative x and y. Will get fixed soon.

Contribute
-----
Please do contribute if you feel like adding new features or improving present code. I will actively review and accept pull requests.

Developed By
-----
[Rahul Verma][7]


License
-----

	Copyright 2014 Rahul Verma

	Licensed under the Apache License, Version 2.0 (the "License");
	you may not use this file except in compliance with the License.
	You may obtain a copy of the License at

	http://www.apache.org/licenses/LICENSE-2.0

	Unless required by applicable law or agreed to in writing, software
	distributed under the License is distributed on an "AS IS" BASIS,
	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	See the License for the specific language governing permissions and
	limitations under the License.

TODO
-----
* ~~WorldCamera zooming is not considered currently . If one zooms out the world camera , the parallax background layers don't make up the whole screen. Fix it.~~
* Make the code more efficient by eliminating object creation in draw loop.
* Make the srcolling work for quadrants other than first quadrant.

[1]: https://github.com/libgdx/libgdx
[2]: https://github.com/fooble/ParallaxBackground-libgdx/blob/master/core/src/com/rahul/libgdx/parallax/TextureRegionParallaxLayer.java
[3]: https://github.com/fooble/ParallaxBackground-libgdx/blob/master/core/src/com/rahul/libgdx/parallax/ParallaxLayer.java
[4]: https://github.com/fooble/ParallaxBackground-libgdx/tree/master/core/src/com/rahul/libgdx/parallax
[5]: https://github.com/fooble/ParallaxBackground-libgdx/blob/master/core/src/com/rahul/libgdx/parallax/test/GameListener.java
[6]: https://github.com/fooble/ParallaxBackground-libgdx/tree/master/core/src/com/rahul/libgdx/parallax/test
[7]: https://plus.google.com/u/0/+RahulVerma2/about




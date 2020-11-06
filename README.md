# Offline-Annotation -Android
This library allows to draw different shapes, lines, marks easily. It's customizable and provides posibility to draw different shapes by different color and different width. 


# Step 1. Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
# Step 2. Add the dependency

	dependencies {
	        implementation 'com.github.perfomatixsolutions:Offline-Annotation:Tag'
	}
# Step 3. Initialize the object for calling the functions

   	DrawableView mDrawableView;

  	mDrawableView.setDrawEnable(true); 

   	mDrawableView.clearDrawLocal();  //clear the view

   	mDrawableView.setupPaint(strokewidth, color); //set the width of line and colour

   	Eg: mDrawableView.setupPaint(5, Color.BLUE)
	
	
# MIT License

	Copyright (c) 2020 perfomatixsolutions

	Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

	The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

	THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

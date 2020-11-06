# Offline-Annotation -Android
It will help you to draw a line to your view


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

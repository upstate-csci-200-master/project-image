# Image Manipulator
## Overview
In Mini Program 7, you wrote a Java program to create a P6 PPM image. For this project, you will write **ImageManipulator.java** to read a PPM image, modify it, and output the updated PPM image.

## Tools
### Gimp
Use Gimp to convert any image to PPM format to use as input.

### Command-line Arguments
The String array **args** passed to the main holds command-line arguments:
```java ImageManipulator input.ppm output.ppm```. The first argument (**args[0]**) should be the **input** file name. The **second** should be the **output** file name. If there are **no other arguments**, perform your **best** (or only) image manipulation. A third argument can be used to specify other alternatives (for testing purposes). If the **user forgets** to use command-line arguments, **print an information message** and exit.

### FileInputStream
Use java.io.FileInputStream to read the image. The **read()** method returns a byte of data as an **int**. If you pass read a **byte array**, It will fill the array with as many bytes as the array can fit (up to file size). See [java.io.FileInputStream read(byte[])](https://docs.oracle.com/javase/7/docs/api/java/io/FileInputStream.html#read(byte[]))

### FileOutputStream
Use java.io.FileOutputStream to create the output image with some manipulation.

### getNextNumber method
Use the provided code to extract width, height, and maximum value (255) from the file.

### Conversions and Corrections
**Signed to unsigned**: Java byte variables have values in the range [-128, 127]. If you are using any mathematical formulas, you need the values to be in the range [0, 255]. ```-128 --> 128. -127 --> 129. -1 --> 255```. (Once your formulas are complete, you can assign them back to bytes and not worry about the sign value.) I recommend creating a **removeSign** method to perform the conversion for integers.

**Overflow and underflow**: If you perform math on a pixel channel that was in the range [0,255], you may get a result out of bounds (negative or greater than 255). I recommend creating a **cap** method that ensures an integer is in the range [0, 255].

## Versions
### B Version
**Grayscale**: Convert the image to grayscale. Here is an [excellent article](https://www.kdnuggets.com/2019/12/convert-rgb-image-grayscale.html) on how to convert RGB (red, green, blue) colors to grayscale. I recommend you use the linear approximation approach for this program. For each pixel **grayscale = (red×.3 + green×.59 + blue×.11)**. You should round the result. Use the grayscale value as the new red, green, and blue values.

### A Versions
Do **one** of the following image manipulations:<br/>
**Rotate 90**: Rotate the image 90° clockwise. Update the width and height accordingly.<br/>
**Vertical Flip**: Flip the image from top to bottom.<br/>
**Horizontal Flip**: Flip the image from left to right.<br/>
**Resize**: Prompt for a new width and height, and resize the image to match.<br/>
**Monochrome**: Pick a color, and put the whole image in shades of that color. See [Chrominance (Wikipedia)](https://en.wikipedia.org/wiki/Chrominance) for more information. Compute the 2 components of chrominance for your chosen color: <br/>
**Cb = -.147 × red - .289 × green + .436 × blue**<br/>
**Cr =  .615 × red - .515 × green - .1 × blue**<br/>

For each pixel, compute its luminance **(lum = red×.3 + green×.59 + blue×.11)**, then apply your chosen colors chrominance:<br/>
**red   = lum + 1.14 × Cr**<br/>
**green = lum - .395 × Cb - .581 × Cr**<br/>
**blue  = lum + 2.032 × Cb**<br/>

### Extra Credit Versions
**Tile**: Prompt for a new width and height, and tile the input image into the new (larger) image.<br/>
**Convolution Filter**: Apply any 3×3 convolution filter to the image. For each pixel channel, multiply the filter by it and the 8 pixel channels surrounding it (once for red, for green, and for blue), and use the sum as the new channel value.<br/>
**blur filter**<br/>
[1/9, 1/9, 1/9]<br/>
[1/9, 1/9, 1/9]<br/>
[1/9, 1/9, 1/9]<br/>
**sharpen filter**<br/>
[-1, -1, -1]<br/>
[-1,  9, -1]<br/>
[-1, -1, -1]<br/>
**horizontal emboss filter**<br/>
[-1, -1, -1]<br/>
[ 2,  2,  2]<br/>
[-1, -1, -1]<br/>

## Recommended Phases
1. Read the image and output it as.
2. Pick a manipulation that makes sense to you, and perform that manipulation.
3. Keep your first manipulation as an option (in case things go poorly), and attempt the best manipulation you think you can do.

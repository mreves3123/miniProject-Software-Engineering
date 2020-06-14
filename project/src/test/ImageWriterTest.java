package test;

import static org.junit.Assert.*;

import java.awt.Color;
import java.lang.reflect.Array;

import org.junit.Test;

import renderer.ImageWriter;

public class ImageWriterTest {

	@Test
	public void test() {
		//image number one
		ImageWriter image=new ImageWriter("image1",500,500,5,5);
		for (int j=0;j<500;j++)
		{		
			for (int i=0;i<5;i++)
			{
			image.writePixel(i, j, Color.cyan);
			}
		}
		for (int j=0;j<500;j++)
		{
			for (int i=0;i<5;i++)
			{
			image.writePixel(j, i, Color.cyan);
			}
		}
		for (int j=0;j<500;j++)
		{
			for (int i=495;i<500;i++)
			{
		
			image.writePixel(i, j, Color.cyan);
			}
		}
			for (int j=0;j<500;j++)
		{
				for (int i=495;i<500;i++)
				{
			
			image.writePixel(j, i, Color.cyan);
				}
		}
			
		for(int i=100;i<400;i++)
		{
			image.writePixel(i, i, Color.blue);

		}
		for(int i=399;i>100;i--)
		{
			image.writePixel(i, 500-i, Color.blue);

		}
		image.writeToimage();
		//image number 2
		ImageWriter image2=new ImageWriter("image2",1000,1000,5,5);
for(int i=50;i<450;i++)
{
	for(int j=550;j<950;j++)
		image2.writePixel(i, j, 90,55,239);
}
for(int i=550;i<950;i++)
{
	for(int j=50;j<450;j++)
		image2.writePixel(i, j, 140,60,200);
}
for(int i=50;i<450;i++)
{
	for(int j=50;j<450;j++)
		image2.writePixel(i, j, 100,50,40);
}
for(int i=550;i<950;i++)
{
	for(int j=550;j<950;j++)
		image2.writePixel(i, j, 255,192,100);
}
		image2.writeToimage();

		//image number 3
		ImageWriter image3=new ImageWriter("image3",1000,1000,5,5);
		int[] arr= {255,255,255};
		for(int i=100;i<500;i++)
			{
			image3.writePixel(i, 1000-i, arr);
			}
		for(int i=499;i<900;i++)
		{
		image3.writePixel(i, i, arr);
		}
		for(int i=100;i<900;i++)
			image3.writePixel(i, 900, arr);
				
		image3.writeToimage();
		ImageWriter image4=new ImageWriter("image4",500,500,10,10);
		for (int i=50;i<image4.getWidth();i+=50)
		{
			for (int j=0;j<image4.getHeight();j++)
			{
				image4.writePixel(i,j, 255,255,255);
			}
		}
		for (int i=50;i<image4.getHeight();i+=50)
		{
			for (int j=0;j<image4.getWidth();j++)
			{
				image4.writePixel(j,i, 255,255,255);
			}
		}
		image4.writeToimage();
		}
	
		
	}



package ie.tudublin;

import processing.core.PApplet;

public class Loops extends PApplet
{
	int animation = 0;

	public void settings()
	{
		size(500, 500);
	}

	public void setup() {
		background(0);	
	}
	
	public void draw()
	{	
		fill(0,0,255);
		clear();
		
		if(animation == 0) {
			if(mouseX >= 250) {
			rect(250, 0, 250, 500);
			} else {
				rect(0, 0, 250, 500);
			}
		}
		if(animation == 1 ) 
		{
			fill(0,0,255);
			if(mouseX >= 250) 
			{
				if(mouseY >= 250)
				{
					rect(250, 250, 500, 500); // Bottom Right
						
				} else {
					rect(250, 0, 250, 250);	// Top Right
				}
			}

			if(mouseX <= 250) 
			{
				if(mouseY <= 250)
				{
					rect(0, 0, 250, 250);
						
				} else {
					rect(0, 250, 250, 250);
				}
			}
		}
		
		if(animation == 2) 
		{
			if(mouseX > 200 && mouseX < 300) 
			{
				if(mouseY > 200 && mouseY < 260){
					fill(255,0,0);
				}
			}
			rect(200, 200, 100, 60);	
		}

	}

	public void keyPressed()
	{
		if (keyCode == LEFT)
		{
			if(animation == 2) {
				animation = 0;
			} else {
				animation++;
			}
		}
	}
}
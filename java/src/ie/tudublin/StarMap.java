package ie.tudublin;

import processing.core.PApplet;

public class StarMap extends PApplet
{
	public void settings()
	{
		size(500, 500);
	}

	public void setup() {
		//colorMode(HSB);
		background(0);

		smooth();
		
	}

	public void drawGrid() {
		int lekax = 50;
		int starty = 50;
		int matex = 50;
		int endy = 50;
		int variablex = -5;
		int variabley = -5;

		stroke(0,255,0);
		for (int i = 0; i < 440; i += 40){
			text(variablex++, lekax,40);
			text(variabley++, 30,lekax);
			line(50, starty, 450, endy);
			starty += 40;
			endy += 40;
			line(lekax,50, matex,450);
			lekax += 40;
			matex +=40;
		}
		
		
	}

		
	public void draw()
	{	
		drawGrid();
		strokeWeight(2);		
	}
}

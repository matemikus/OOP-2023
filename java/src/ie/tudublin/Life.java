package ie.tudublin;

import processing.core.PApplet;

public class Life extends PApplet
{
	public int pause = 0;

	LifeBoard board;
	public void settings()
	{
		size(1000, 1000);
	}

	public void setup() {
		colorMode(RGB);
		background(0);
		board = new LifeBoard(100, this);
		board.randomise();
	}

	public void draw()
	{	
		background(0);
		board.render();
		//board.applyRules();
		board.keyPressed();
		
	}
}

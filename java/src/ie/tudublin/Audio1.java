package ie.tudublin;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.PApplet;

public class Audio1 extends PApplet
{
    Minim minim;
    AudioPlayer ap;
    AudioInput ai;
    AudioBuffer ab;

    int mode = 0;

    float y = 0;
    float smoothedY = 0;
    float smoothedAmplitude = 0;

    public void keyPressed() {
		if (key >= '0' && key <= '9') {
			mode = key - '0';
		}
		if (keyCode == ' ') {
            if (ap.isPlaying()) {
                ap.pause();
            } else {
                ap.rewind();
                ap.play();
            }
        }
        if (keyCode == '0') {

        }
        if (keyCode == '1') {
            
        }
	}

    public void settings()
    {
        size(1024, 1000, P3D);
        //fullScreen(P3D, SPAN);
    }

    public void setup()
    {
        minim = new Minim(this);
        // Uncomment this to use the microphone
        ai = minim.getLineIn(Minim.MONO, width, 44100, 16);
        ab = ai.mix; 

        // And comment the next two lines out
        //ap = minim.loadFile("heroplanet.mp3", 1024);
        //ap.play();
        //ab = ap.mix;
        colorMode(HSB);

        y = height / 2;
        smoothedY = y;

    }

	public void draw()
	{	
		background(0);
        stroke(255);

        float half = height / 2;
        float cgap = 255 / (float)ab.size();
        for(int i = 0 ; i < ab.size() ; i ++)
        {
            stroke(cgap * i, 255, 255);
            line(i, half, i , half + ab.get(i) * half); 
        }

        
	}
}

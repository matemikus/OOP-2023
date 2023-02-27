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
    int draw = -1;

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
            draw = 0;
        }
        if (keyCode == '1') {
            draw = 1;
        }
        if (keyCode == '2') {
            draw = 2;
        }
        if (keyCode == '3') {
            draw = 3;
        }
        if (keyCode == '4') {
            draw = 4;
        }
        if (keyCode == '5') {
            draw = 5;
        }
        if (keyCode > '5') {
            draw = -1;
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

        if( draw == -1 || draw == 1 ) {
            for(int i = 0 ; i < ab.size() ; i ++)
            {
                stroke(cgap * i, 255, 255);
                line(i, half, i , half + ab.get(i) * half); // original line
            }
        }

        if( draw == 0 ) {
            for(int i = 0 ; i < ab.size() ; i ++)
            {
                stroke(cgap * i, 255, 255);
                line(i, half, half + ab.get(i) * half, i);
            }
        }

        if( draw == 2 ) {
            for(int i = 0 ; i < ab.size() ; i ++)
            {
                stroke(cgap * i, 255, 255);
                // Top Line
                line(i, 0, i , ab.get(i) * half);
                //Bottom Line
                line(i, 1000, i , 1000 + ab.get(i) * half);
                // Left Line
                line(0, i, ab.get(i) * half, i );
                // Right Line
                line(1024, i, 1024 + ab.get(i) * half, i );
            }
        }

        if( draw == 3 ) {
            float total = 300;
            
            for(int i = 0 ; i < ab.size() ; i ++)
            {
                total += abs(ab.get(i)); // abs = absolute value of
                strokeWeight(6);
            }
            
            float average = total / (float) ab.size();
            float r = average * 300;
            lerpedR = lerp(lerpedR, r, 0.2f);

            fill(204, 102, 0);
            circle(height/2,width/2,r);
            fill(255,164,0);

            //lerp (10, 20, 0); // lerp stands for linear interperation

            
        }

        if( draw == 4 ) {
            
            float total = 300;

            for(int i = 0 ; i < ab.size() ; i ++)
            {
               total += abs(ab.get(i)); 
               float upperLeftx = ((width/2-40) + total);
               float upperLefty = ((height/2-40 + total));
            }
            float average = total / (float) ab.size();
            float r = average * 200;

        }

        
	}
    float lerpedR = 0;
}

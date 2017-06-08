package wipro.topgear.com.animation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements Animation.AnimationListener {

    TextView fadein,fadeout,zoomin,zoomout,rotate_tv,move;

    Button alpha,rotate,scale,translate;

    // Animation
    Animation animFadein,animFadeout,animZoomin,animZoomout,animRotate,animMove;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fadein = (TextView) findViewById(R.id.fadeIn);
        fadeout = (TextView) findViewById(R.id.fadeout);
        zoomin = (TextView) findViewById(R.id.zoomin);
        zoomout = (TextView) findViewById(R.id.zoomout);
        rotate_tv = (TextView) findViewById(R.id.rotate_text);
        move = (TextView) findViewById(R.id.move);



        alpha = (Button) findViewById(R.id.alpha);
        rotate = (Button) findViewById(R.id.rotate);
        scale = (Button) findViewById(R.id.scale);
        translate = (Button) findViewById(R.id.Translate);

        // load the animation
        animFadein = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.fadein);
        animFadeout = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.fadeout);
        animZoomout = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.zoomin);
        animZoomin = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.zoomout);
        animRotate = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.rotate);
        animMove = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.translate);

        // set animation listener
        animFadein.setAnimationListener(this);
        animFadeout.setAnimationListener(this);
        animMove.setAnimationListener(this);
        animRotate.setAnimationListener(this);
        animZoomin.setAnimationListener(this);
        animZoomout.setAnimationListener(this);


        // button click event
        alpha.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                fadein.setVisibility(View.VISIBLE);
                fadeout.setVisibility(View.INVISIBLE);

                // start the animation
                fadein.startAnimation(animFadein);
                fadeout.startAnimation(animFadeout);
            }
        });

        scale.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                zoomin.setVisibility(View.VISIBLE);
                zoomout.setVisibility(View.VISIBLE);

                // start the animation
                zoomin.startAnimation(animZoomin);
                zoomout.startAnimation(animZoomout);
            }
        });

        rotate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                rotate_tv.setVisibility(View.VISIBLE);

                // start the animation
                rotate_tv.startAnimation(animRotate);

                //rotate_tv.setVisibility(View.INVISIBLE);
            }
        });

        translate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                move.setVisibility(View.VISIBLE);

                // start the animation
                move.startAnimation(animMove);
            }
        });

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        // Take any action after completing the animation

        // check for fade in animation
        if (animation == animFadeout) {
            Toast.makeText(getApplicationContext(), "Alpha Animation Stopped",
                    Toast.LENGTH_SHORT).show();
        }

        if (animation == animZoomout) {
            Toast.makeText(getApplicationContext(), "Scale Animation Stopped",
                    Toast.LENGTH_SHORT).show();
        }

        if (animation == animMove) {
            Toast.makeText(getApplicationContext(), "Translate Animation Stopped",
                    Toast.LENGTH_SHORT).show();
        }

        if (animation == animRotate) {
            Toast.makeText(getApplicationContext(), "Rotate Animation Stopped",
                    Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onAnimationRepeat(Animation animation) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onAnimationStart(Animation animation) {
        // TODO Auto-generated method stub

    }

}
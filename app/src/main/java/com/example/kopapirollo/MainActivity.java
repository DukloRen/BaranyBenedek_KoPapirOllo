package com.example.kopapirollo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ImageView yourImage;
    private ImageView computerImage;
    private TextView yourChoiceText;
    private TextView computerChoiceText;
    private LinearLayout linearLayout;
    private TextView score;
    private Button rockButton;
    private Button paperButton;
    private Button scissorsButton;
    public int yourChoice=4;
    public int computerChoice=5;
    public int ember=0;
    public int computer=0;
    private AlertDialog.Builder alertD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        Random random=new Random();
        rockButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                yourChoice=0;
                computerChoice = random.nextInt(3);
                yourImage.setImageResource(R.drawable.rock);
                if (computerChoice==0){
                    computerImage.setImageResource(R.drawable.rock);
                } else if (computerChoice==1) {
                    computerImage.setImageResource(R.drawable.paper);
                }
                else{
                    computerImage.setImageResource(R.drawable.scissors);
                }
                if (yourChoice==computerChoice){
                    Toast.makeText(MainActivity.this,"Döntetlen",Toast.LENGTH_SHORT).show();
                }
                else if (computerChoice==1){
                    computer++;
                    Toast.makeText(MainActivity.this,"A gép nyerte a kört",Toast.LENGTH_SHORT).show();
                    score.setText("Eredmény: Ember: "+ember+" Computer: "+computer);
                    gameControl();
                }
                else{
                    ember++;
                    Toast.makeText(MainActivity.this,"Te nyerted a kört",Toast.LENGTH_SHORT).show();
                    score.setText("Eredmény: Ember: "+ember+" Computer: "+computer);
                    gameControl();
                }
            }
        });
        paperButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                yourChoice=1;
                computerChoice = random.nextInt(3);
                yourImage.setImageResource(R.drawable.paper);
                if (computerChoice==0){
                    computerImage.setImageResource(R.drawable.rock);
                } else if (computerChoice==1) {
                    computerImage.setImageResource(R.drawable.paper);
                }
                else{
                    computerImage.setImageResource(R.drawable.scissors);
                }
                if (yourChoice==computerChoice){
                    Toast.makeText(MainActivity.this,"Döntetlen",Toast.LENGTH_SHORT).show();
                }
                else if (computerChoice==2){
                    computer++;
                    Toast.makeText(MainActivity.this,"A gép nyerte a kört",Toast.LENGTH_SHORT).show();
                    score.setText("Eredmény: Ember: "+ember+" Computer: "+computer);
                    gameControl();
                }
                else{
                    ember++;
                    Toast.makeText(MainActivity.this,"Te nyerted a kört",Toast.LENGTH_SHORT).show();
                    score.setText("Eredmény: Ember: "+ember+" Computer: "+computer);
                    gameControl();
                }
            }
        });
        scissorsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                yourChoice=2;
                computerChoice = random.nextInt(3);
                yourImage.setImageResource(R.drawable.scissors);
                if (computerChoice==0){
                    computerImage.setImageResource(R.drawable.rock);
                } else if (computerChoice==1) {
                    computerImage.setImageResource(R.drawable.paper);
                }
                else{
                    computerImage.setImageResource(R.drawable.scissors);
                }
                if (yourChoice==computerChoice){
                    Toast.makeText(MainActivity.this,"Döntetlen",Toast.LENGTH_SHORT).show();
                }
                else if (computerChoice==0){
                    computer++;
                    Toast.makeText(MainActivity.this,"A gép nyerte a kört",Toast.LENGTH_SHORT).show();
                    score.setText("Eredmény: Ember: "+ember+" Computer: "+computer);
                    gameControl();
                }
                else{
                    ember++;
                    Toast.makeText(MainActivity.this,"Te nyerted a kört",Toast.LENGTH_SHORT).show();
                    score.setText("Eredmény: Ember: "+ember+" Computer: "+computer);
                    gameControl();
                }
            }
        });
    }
    private void init(){
        yourImage=findViewById(R.id.yourImage);
        computerImage=findViewById(R.id.computerImage);
        yourChoiceText=findViewById(R.id.yourChoiceText);
        computerChoiceText=findViewById(R.id.computerChoiceText);
        linearLayout=findViewById(R.id.linearLayout);
        score=findViewById(R.id.score);
        rockButton=findViewById(R.id.rockButton);
        paperButton=findViewById(R.id.paperButton);
        scissorsButton=findViewById(R.id.scissorsButton);
        alertD = new AlertDialog.Builder(MainActivity.this);
        alertD.setMessage("Szeretne új játékot játszani?")
                .setNegativeButton("Igen", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        newGame();
                    }
                })
                .setPositiveButton("Nem", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })
                .setCancelable(false)
                .create();
    }
    private void gameControl(){
        if (ember==3){
            alertD.setTitle("Győzelem").create();
            alertD.show();
        }
        else if(computer==3){
            alertD.setTitle("Vesztettél").create();
            alertD.show();
        }
    }
    private void newGame(){
        yourImage.setImageResource(R.drawable.paper);
        computerImage.setImageResource(R.drawable.paper);
        score.setText("Eredmény: Ember: 0 Computer: 0");
        ember = 0;
        computer = 0;
        Random random = new Random();
        computerChoice = random.nextInt(3);
    }
}
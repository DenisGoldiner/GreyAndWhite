package com.my.program_10.app;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import android.view.*;
import android.view.Menu;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.Random;

public class ManeActivity extends Activity{

    private TextView textView2;
    private TextView textView1;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private Button button0;
    private Button buttonClear;
    private Button buttonEnter;
    public int[] mass = new int[4];
    public int[] mass1 = new int[4];
    public int cows = 0;
    public int bulls = 0;
    public  Random r = new Random();
    public int count = 0;
    public int trys = 0;


    public void showDialog(View view, int trys){
        AlertDialog.Builder builder = new AlertDialog.Builder(ManeActivity.this);

        builder.setTitle("WinGame")
                .setMessage("Вы Выиграли! \n" + "Потрачено " + trys + " попыток")
                .setCancelable(false)
                .setNegativeButton("В меню", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(ManeActivity.this, Menu.class);

                            startActivity(intent);


                    }
                })
                .setPositiveButton("Играть еще", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {


                    }
                });

        AlertDialog alert = builder.create();
        alert.show();



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_items, menu);

        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        textView2 = (TextView)findViewById(R.id.textView2);
        textView1 = (TextView)findViewById(R.id.textView);

        button1 = (Button) findViewById(R.id.button3);
        button2 = (Button) findViewById(R.id.button4);
        button3 = (Button) findViewById(R.id.button5);
        button4 = (Button) findViewById(R.id.button6);
        button5 = (Button) findViewById(R.id.button7);
        button6 = (Button) findViewById(R.id.button8);
        button7 = (Button) findViewById(R.id.button9);
        button8 = (Button) findViewById(R.id.button10);
        button9 = (Button) findViewById(R.id.button11);
        button0 = (Button) findViewById(R.id.button13);
        buttonClear = (Button) findViewById(R.id.button12);
        buttonEnter = (Button) findViewById(R.id.button14);



        int indikator = 0;

        for(int i = 0 ; i < 4 ; i++ ){

                int z = r.nextInt(10);
                for(int j = 0 ; j < 4; j++ ){

                    if(z == mass[j]){
                        indikator ++;
                    }
                }

            if(indikator == 0){
                mass[i] = z;
            }

            else{
                indikator = 0;
                i--;
            }
        }


            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    textView2.setText(textView2.getText() + "1");
                }
            });

            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    textView2.setText(textView2.getText() + "2");
                }
            });

            button3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    textView2.setText(textView2.getText() + "3");
                }
            });

            button4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    textView2.setText(textView2.getText() + "4");
                }
            });

            button5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    textView2.setText(textView2.getText() + "5");
                }
            });

            button6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    textView2.setText(textView2.getText() + "6");
                }
            });

            button7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    textView2.setText(textView2.getText() + "7");
                }
            });

            button8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    textView2.setText(textView2.getText() + "8");
                }
            });

            button9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    textView2.setText(textView2.getText() + "9");
                }
            });

            button0.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    textView2.setText(textView2.getText() + "0");
                }
            });

            buttonClear.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    textView2.setText("");
                }
            });

            buttonEnter.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {

                        if (textView2.length() == 4) {

                            int y = Integer.parseInt(textView2.getText().toString());
                            for (int i = 3; i >= 0; i--) {
                                mass1[i] = y % 10;
                                y = (y / 10) - ((y / 10) % 1);
                            }

                            for(int i = 0; i < 4; i++){
                                for(int j = 1 ; j < 4; j++) {
                                    if (i != j){
                                        if(mass1[i] == mass1[j]){
                                            count ++;
                                    }
                                    }
                                }
                            }

                            if(count == 0) {

                                for (int i = 0; i < 4; i++) {
                                    for (int j = 0; j < 4; j++) {
                                        if (mass[i] == mass1[j]) {
                                            if (i == j) {
                                                bulls++;
                                            } else cows++;
                                        }
                                    }
                                }

                                if (bulls == 4) {
                                    textView1.setText("");
                                    int indikator = 0;

                                    for (int i = 0; i < 4; i++) {

                                        int z = r.nextInt(10);
                                        for (int j = 0; j < 4; j++) {

                                            if (z == mass[j]) {
                                                indikator++;
                                            }
                                        }

                                        if (indikator == 0) {
                                            mass[i] = z;
                                        } else {
                                            indikator = 0;
                                            i--;
                                        }
                                    }

                                    showDialog(v,trys);

                                } else {
                                    textView1.setText(String.valueOf(textView1.getText()) + textView2.getText());
                                    if (cows == 1) {
                                        textView1.setText(String.valueOf(textView1.getText() + "   " + cows + "Корова, "));
                                    }
                                    if (cows == 0) {
                                        textView1.setText(String.valueOf(textView1.getText() + "   " + cows + "Коров, "));
                                    }
                                    if (cows > 1) {
                                        textView1.setText(String.valueOf(textView1.getText() + "   " + cows + "Коровы, "));
                                    }
                                    if (bulls == 1) {
                                        textView1.setText(String.valueOf(textView1.getText() + "" + bulls + " Бык \n"));
                                    }
                                    if (bulls == 0) {
                                        textView1.setText(String.valueOf(textView1.getText() + "" + bulls + " Быков \n"));
                                    }
                                    if (bulls > 1) {
                                        textView1.setText(String.valueOf(textView1.getText() + "" + bulls + " Быка \n"));
                                    }
                                    trys++;
                                }

                                bulls = 0;
                                cows = 0;
                                textView2.setText("");
                            }
                            else{
                                Toast toast = Toast.makeText(getApplicationContext(), "Есть повторы цифры", Toast.LENGTH_SHORT);
                                toast.setGravity(Gravity.CENTER, 0, 0);
                                toast.show();
                                count = 0;
                            }
                        } else {
                                Toast toast = Toast.makeText(getApplicationContext(), "Число должно содержать 4 цифры", Toast.LENGTH_SHORT);
                                toast.setGravity(Gravity.CENTER,0,0);
                                toast.show();
                        }

                }
            });
        }


}

package com.example.googlemgamebar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MyRecyclerViewAdapter.OnGameListner{
private RecyclerView recyclerView;
private GridLayoutManager gridLayoutManager;
private MyRecyclerViewAdapter myRecyclerViewAdapter;
private SingleRow singleRow;
private ArrayList<SingleRow> singleRowArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerview);
        gridLayoutManager=new GridLayoutManager(getApplicationContext(),2,RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(gridLayoutManager);
        int image[]={R.drawable.codingcarrots,R.drawable.cricket,R.drawable.hallo,R.drawable.fish,R.drawable.sca,R.drawable.pacman,R.drawable.tic,R.drawable.snake};
        String game[]={"Coding Carrots","Cricket","Halloween 2016","Fischinger","Scoville","Pac man","Tic-tok","Snake"};
        singleRowArrayList=new ArrayList<>();
        for(int i=0;i<game.length;i++){
            singleRow=new SingleRow(image[i],game[i]);
            singleRowArrayList.add(singleRow);
        }

        myRecyclerViewAdapter=new MyRecyclerViewAdapter(this,singleRowArrayList,this);
        recyclerView.setAdapter(myRecyclerViewAdapter);

    }

    @Override
    public void OnGameClick(int position) {
        String links[]={"https://g.co/doodle/ygxau2?ds=cl","https://doodlecricket.github.io/#/","https://g.co/doodle/kj6aru","https://www.google.com/logos/doodles/2017/fischinger/fischinger17.9.html?hl=en&doodle=undefined","https://www.google.com/doodles/wilbur-scovilles-151st-birthday","https://www.google.com/logos/2010/pacman10-i.html","https://playtictactoe.org/","https://snake.googlemaps.com/"};
        Intent intent=new Intent(getApplicationContext(),GameZone.class);
        intent.putExtra("url_key",links[position]);
        startActivity(intent);
        //Toast.makeText(getApplicationContext(),"asd "+position,Toast.LENGTH_SHORT).show();
    }
}
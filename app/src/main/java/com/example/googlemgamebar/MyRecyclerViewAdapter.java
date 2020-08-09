package com.example.googlemgamebar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<SingleRow> singleRowArrayList;
    OnGameListner onGameListner;

    public MyRecyclerViewAdapter(Context context, ArrayList<SingleRow> singleRowArrayList,OnGameListner onGameListner) {
        this.context = context;
        this.singleRowArrayList = singleRowArrayList;
        this.onGameListner=onGameListner;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.singlerow,parent,false);
        MyViewHolder myViewHolder= new MyViewHolder(view,onGameListner);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        SingleRow singleRow=singleRowArrayList.get(position);
        holder.textView.setText(singleRow.getTxtgame());
        holder.imageView.setImageResource(singleRow.getImage());

    }

    @Override
    public int getItemCount() {
        return singleRowArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imageView;
        TextView textView;
        OnGameListner onGameListner;
        public MyViewHolder(@NonNull View itemView,OnGameListner onGameListner) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imageview);
            this.onGameListner=onGameListner;
            itemView.setOnClickListener(this);
            textView=itemView.findViewById(R.id.txtgame);
        }


        @Override
        public void onClick(View v) {
            onGameListner.OnGameClick(getAdapterPosition());
        }
    }
    public interface OnGameListner{

        public void OnGameClick(int position);
    }

}

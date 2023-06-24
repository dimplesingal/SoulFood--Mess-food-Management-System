package com.example.myapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class Adapt_feed extends FirebaseRecyclerAdapter<model_feed, Adapt_feed.myViewHolder> {

    public Adapt_feed(@NonNull FirebaseRecyclerOptions<model_feed> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull Adapt_feed.myViewHolder holder,final int position, @NonNull model_feed model) {

        holder.Message.setText(model.getMessage());

        holder.deleteFeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder= new AlertDialog.Builder(holder.Message.getContext());
                builder.setTitle("Are You Sure?");
                builder.setMessage("Deleted data cant be undo..");

                builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        FirebaseDatabase.getInstance().getReference().child("Feedback")
                                .child(getRef(position).getKey()).removeValue();
                    }
                });

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(holder.Message.getContext(), "Cancelled", Toast.LENGTH_SHORT).show();
                    }
                });

                builder.show();
            }
        });
    }

    @NonNull
    @Override
    public Adapt_feed.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.feedback,parent,false);
        return new myViewHolder(view);
    }

    public class myViewHolder extends RecyclerView.ViewHolder {

        TextView Message;
        Button deleteFeed;


        public myViewHolder(@NonNull View itemView) {
            super(itemView);


            Message = (TextView) itemView.findViewById(R.id.feed_message);

            deleteFeed = (Button)itemView.findViewById(R.id.delbtn_feed);
        }
    }
}
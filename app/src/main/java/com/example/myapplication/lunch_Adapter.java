package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;

public class lunch_Adapter  extends FirebaseRecyclerAdapter<Member, lunch_Adapter.myViewHolder> {
    public lunch_Adapter(@NonNull FirebaseRecyclerOptions<Member> options){
        super(options);
    }
    @Override
    protected void onBindViewHolder(@NonNull lunch_Adapter.myViewHolder holder,final int position, @NonNull Member model) {
        holder.name.setText(model.getName());
        holder.room_no.setText(model.getRoom_no());

        holder.imagedelete3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase.getInstance().getReference().child("Lunch")
                        .child(getRef(position).getKey())
                        .removeValue()
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                            }
                        });
            }
        });

    }


    @NonNull
    @Override
    public lunch_Adapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lunchlist1,parent,false);
        return new lunch_Adapter.myViewHolder(view);
    }

     class myViewHolder extends RecyclerView.ViewHolder {
         TextView name, room_no;
         ImageView imagedelete3;

         public myViewHolder(@NonNull View itemView) {
             super(itemView);

             name = (TextView) itemView.findViewById(R.id.name_lunchlist);
             room_no = (TextView) itemView.findViewById(R.id.roomno_lunchlist);
             imagedelete3 =itemView.findViewById(R.id.image_delete3);
         }
     }
}

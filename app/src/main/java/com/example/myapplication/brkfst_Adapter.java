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

public class brkfst_Adapter extends FirebaseRecyclerAdapter<Member, brkfst_Adapter.myViewHolder> {
    public brkfst_Adapter(@NonNull FirebaseRecyclerOptions<Member> options){
        super(options);
    }



    @Override
    protected void onBindViewHolder(@NonNull brkfst_Adapter.myViewHolder holder, final int position, @NonNull Member model) {
        holder.name.setText(model.getName());
        holder.room_no.setText(model.getRoom_no());

        holder.imagedelete1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase.getInstance().getReference().child("Breakfast")
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
    public brkfst_Adapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.breakfastlist1,parent,false);
        return new brkfst_Adapter.myViewHolder(view);
    }

    class myViewHolder extends RecyclerView.ViewHolder {
        TextView name, room_no;
        ImageView imagedelete1;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.name_brkfstlist);
            room_no = (TextView) itemView.findViewById(R.id.roomno_brkfstlist);
            imagedelete1 = itemView.findViewById(R.id.image_delete1);
        }
    }
}

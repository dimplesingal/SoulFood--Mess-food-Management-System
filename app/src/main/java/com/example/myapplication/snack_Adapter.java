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

public class snack_Adapter extends FirebaseRecyclerAdapter<Member, snack_Adapter.myViewHolder> {
public snack_Adapter(@NonNull FirebaseRecyclerOptions<Member> options){
        super(options);
        }



@Override
protected void onBindViewHolder(@NonNull snack_Adapter.myViewHolder holder, final int position, @NonNull Member model) {
        holder.name.setText(model.getName());
        holder.room_no.setText(model.getRoom_no());

    holder.imagedelete2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            FirebaseDatabase.getInstance().getReference().child("Snacks")
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
public snack_Adapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.snackslist1,parent,false);
        return new snack_Adapter.myViewHolder(view);
        }

class myViewHolder extends RecyclerView.ViewHolder {
    TextView name, room_no;
    ImageView imagedelete2;

    public myViewHolder(@NonNull View itemView) {
        super(itemView);

        name = (TextView) itemView.findViewById(R.id.name_snacklist);
        room_no = (TextView) itemView.findViewById(R.id.roomno_snacklist);
        imagedelete2 = itemView.findViewById(R.id.image_delete2);
    }
}}

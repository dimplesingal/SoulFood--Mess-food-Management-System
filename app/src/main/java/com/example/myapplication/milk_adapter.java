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

public class milk_adapter extends FirebaseRecyclerAdapter<milkModel, milk_adapter.myViewHolder> {


    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public milk_adapter(@NonNull FirebaseRecyclerOptions<milkModel> options) {
        super(options);
    }

    @Override
        protected void onBindViewHolder(@NonNull myViewHolder holder, final int position, @NonNull milkModel model) {
            holder.name.setText(model.getName());
            holder.room_no.setText(model.getRoom_no());

            holder.deleteMilk.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder= new AlertDialog.Builder(holder.name.getContext());
                    builder.setTitle("Are You Sure?");
                    builder.setMessage("Deleted data cant be undo..");

                    builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            FirebaseDatabase.getInstance().getReference().child("Milk Details")
                                    .child(getRef(position).getKey()).removeValue();
                        }
                    });

                    builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(holder.name.getContext(), "Cancelled", Toast.LENGTH_SHORT).show();
                        }
                    });

                    builder.show();
                }
            });
        }

        @NonNull
        @Override
        public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.milkdetail,parent,false);
            return new myViewHolder(view);
        }

        class myViewHolder extends RecyclerView.ViewHolder {

            TextView name, room_no;
            Button deleteMilk;


            public myViewHolder(@NonNull View itemView) {
                super(itemView);

                name = (TextView) itemView.findViewById(R.id.name_milk);
                room_no = (TextView) itemView.findViewById(R.id.roomno_milk);

                deleteMilk = (Button)itemView.findViewById(R.id.delbtn_milk);
            }
        }
    }

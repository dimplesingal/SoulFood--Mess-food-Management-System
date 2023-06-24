package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;


    public class Adapter_StudentMenu extends FirebaseRecyclerAdapter<modelStudentMenu, com.example.myapplication.Adapter_StudentMenu.MenuViewHolder> {

        public Adapter_StudentMenu(@NonNull FirebaseRecyclerOptions<modelStudentMenu> options) {
            super(options);
        }


        @Override
        protected void onBindViewHolder(@NonNull Adapter_StudentMenu.MenuViewHolder holder, int position, @NonNull modelStudentMenu model) {
            holder.days.setText(model.getDays());
            holder.breakfast1.setText(model.getBreakfast1());
            holder.breakfast2.setText(model.getBreakfast2());
            holder.breakfast3.setText(model.getBreakfast3());
            holder.lunch1.setText(model.getLunch1());
            holder.lunch2.setText(model.getLunch2());
            holder.lunch3.setText(model.getLunch3());
            holder.snacks1.setText(model.getSnacks1());
            holder.snacks2.setText(model.getSnacks2());
            holder.dinner1.setText(model.getDinner1());
            holder.dinner2.setText(model.getDinner2());
        }

        @NonNull
        @Override
        public Adapter_StudentMenu.MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.student_menu,parent,false);
            return new MenuViewHolder(view);
        }


        class MenuViewHolder extends RecyclerView.ViewHolder{

            TextView days,breakfast1,breakfast2,breakfast3,lunch1,lunch2,lunch3,snacks1,snacks2,dinner1,dinner2;

            public MenuViewHolder(@NonNull View itemView) {
                super(itemView);
                days = itemView.findViewById(R.id.textView12);

                breakfast1 = itemView.findViewById(R.id.first);
                breakfast2 = itemView.findViewById(R.id.second);
                breakfast3 = itemView.findViewById(R.id.third);

                lunch1 = itemView.findViewById(R.id.fourth);
                lunch2 = itemView.findViewById(R.id.fifth);
                lunch3 = itemView.findViewById(R.id.sixth);

                snacks1 = itemView.findViewById(R.id.seventh);
                snacks2 = itemView.findViewById(R.id.eighth);

                dinner1 = itemView.findViewById(R.id.tenth);
                dinner2 = itemView.findViewById(R.id.eleventh);



            }
    }}

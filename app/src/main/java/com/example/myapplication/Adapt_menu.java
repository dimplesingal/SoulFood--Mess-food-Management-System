package com.example.myapplication;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

import java.util.HashMap;
import java.util.Map;

public class Adapt_menu extends FirebaseRecyclerAdapter<modelMenu,Adapt_menu.MenuViewHolder> {

    private MainMenuAdminActivity contextMenu;
    public Adapt_menu(@NonNull FirebaseRecyclerOptions<modelMenu> options, MainMenuAdminActivity contextMenu) {
        super(options);
        this.contextMenu = contextMenu;
    }

    @Override
    protected void onBindViewHolder(@NonNull MenuViewHolder holder, final int position, @NonNull modelMenu model) {


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

        holder.contentUpdateMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogPlus dialog = DialogPlus.newDialog(contextMenu)
                        .setGravity(Gravity.CENTER)
                        .setMargin(5,0,50,0)
                        .setContentHolder(new ViewHolder(R.layout.update_contentmenu_admin))
                        .setExpanded(false)
                        .create();

                View holderView = (LinearLayout)dialog.getHolderView();

                EditText days = holderView.findViewById(R.id.DaysUpdate);
                EditText  breakfast1 = holderView.findViewById(R.id.Breakfast4);
                EditText  breakfast2 = holderView.findViewById(R.id.breakfast5);
                EditText breakfast3 = holderView.findViewById(R.id.Breakfast6);
                EditText   lunch1 = holderView.findViewById(R.id.Lunch4);
                EditText   lunch2 = holderView.findViewById(R.id.Lunch5);
                EditText   lunch3 = holderView.findViewById(R.id.Lunch6);
                EditText   snacks1 = holderView.findViewById(R.id.Snacks3);
                EditText  snacks2 = holderView.findViewById(R.id.Snacks4);
                EditText   dinner1 = holderView.findViewById(R.id.Dinner3);
                EditText   dinner2 = holderView.findViewById(R.id.Dinner4);
                Button update = holderView.findViewById(R.id.UpdateMenu);


                days.setText(model.getDays());
                breakfast1.setText(model.getBreakfast1());
                breakfast2.setText(model.getBreakfast2());
                breakfast3.setText(model.getBreakfast3());
                lunch1.setText(model.getLunch1());
                lunch2.setText(model.getLunch2());
                lunch3.setText(model.getLunch3());
                snacks1.setText(model.getSnacks1());
                snacks2.setText(model.getSnacks2());
                dinner1.setText(model.getDinner1());
                dinner2.setText(model.getDinner2());

                update.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Map<String,Object> map = new HashMap<>();
                        map.put("days",days.getText().toString());
                        map.put("breakfast1",breakfast1.getText().toString());
                        map.put("breakfast2",breakfast2.getText().toString());
                        map.put("breakfast3",breakfast3.getText().toString());
                        map.put("lunch1",lunch1.getText().toString());
                        map.put("lunch2",lunch2.getText().toString());
                        map.put("lunch3",lunch3.getText().toString());
                        map.put("snacks1",snacks1.getText().toString());
                        map.put("snacks2",snacks2.getText().toString());
                        map.put("dinner1",dinner1.getText().toString());
                        map.put("dinner2",dinner2.getText().toString());



                        FirebaseDatabase.getInstance().getReference()
                                        .child("Menu")
                                                .child(getRef(position).getKey())
                                                        .updateChildren(map)
                                                                .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                                    @Override
                                                                    public void onComplete(@NonNull Task<Void> task) {
                                                                        dialog.dismiss();
                                                                    }
                                                                });


                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });

    }

    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.admin_menu_layout,parent,false);
        return new MenuViewHolder(view);
    }

    class MenuViewHolder extends RecyclerView.ViewHolder{

        TextView days,breakfast1,breakfast2,breakfast3,lunch1,lunch2,lunch3,snacks1,snacks2,dinner1,dinner2;
        Button contentUpdateMenu;
        public MenuViewHolder(@NonNull View itemView) {
            super(itemView);
            days = itemView.findViewById(R.id.textView11);

            breakfast1 = itemView.findViewById(R.id.firstContent);
            breakfast2 = itemView.findViewById(R.id.secondContent);
            breakfast3 = itemView.findViewById(R.id.thirdContent);

            lunch1 = itemView.findViewById(R.id.fourthContent);
            lunch2 = itemView.findViewById(R.id.fifthContent);
            lunch3 = itemView.findViewById(R.id.sixthContent);

            snacks1 = itemView.findViewById(R.id.seventhContent);
            snacks2 = itemView.findViewById(R.id.eighthContent);

            dinner1 = itemView.findViewById(R.id.tenthContent);
            dinner2 = itemView.findViewById(R.id.eleventhContent);

            contentUpdateMenu = itemView.findViewById(R.id.contentUpdate);



        }
    }
}

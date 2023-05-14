package com.example.tripity.Adapters;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tripity.R;

import java.util.List;

public class RecyclerAddedPerson extends RecyclerView.Adapter<RecyclerAddedPerson.AddedPersonModelViewHolder>{

    List<AddedPersonModel> addedPersonModelList;
    Context context;
    public RecyclerAddedPerson(Context context,List<AddedPersonModel> addedPersonModelList) {
        this.context = context;
        this.addedPersonModelList = addedPersonModelList;

    }

    @NonNull
    @Override
    public RecyclerAddedPerson.AddedPersonModelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.added_person_layout, parent, false);
        RecyclerAddedPerson.AddedPersonModelViewHolder viewHolder = new RecyclerAddedPerson.AddedPersonModelViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAddedPerson.AddedPersonModelViewHolder holder, @SuppressLint("RecyclerView") int position) {

        AddedPersonModel addedPersonModel = addedPersonModelList.get(position);

        holder.addedPersonName.setText(addedPersonModel.getName());
        holder.addedPersonId.setText(addedPersonModel.getId());
        holder.addedPersonTicketType.setText(addedPersonModel.getType());
        holder.addedPersonTicketType.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(context)
                        .setTitle("Delete Visitor")
                        .setMessage("Are you sure,want to delete?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                addedPersonModelList.remove(position);
                                notifyItemRemoved(position);

                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });
                builder.show();
                return true;
            }
        });


    }

    @Override
    public int getItemCount() {
        return addedPersonModelList.size();
    }
    public class AddedPersonModelViewHolder extends  RecyclerView.ViewHolder {
        public TextView addedPersonName,addedPersonId,addedPersonTicketType;
        public AddedPersonModelViewHolder(View itemView){
            super(itemView);
            addedPersonName=itemView.findViewById(R.id.vistorname);
            addedPersonId=itemView.findViewById(R.id.vistorid);
            addedPersonTicketType=itemView.findViewById(R.id.vistortype);
        }
    }
}

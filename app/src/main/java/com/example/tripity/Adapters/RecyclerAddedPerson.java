package com.example.tripity.Adapters;

import android.content.Context;
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
    public void onBindViewHolder(@NonNull RecyclerAddedPerson.AddedPersonModelViewHolder holder, int position) {

        AddedPersonModel addedPersonModel = addedPersonModelList.get(position);

        holder.addedPersonName.setText(addedPersonModel.getName());
        holder.addedPersonId.setText(addedPersonModel.getId());
        holder.addedPersonTicketType.setText(addedPersonModel.getType());


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

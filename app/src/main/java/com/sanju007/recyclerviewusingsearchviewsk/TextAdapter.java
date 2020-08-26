package com.sanju007.recyclerviewusingsearchviewsk;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class TextAdapter extends RecyclerView.Adapter<TextAdapter.MyViewHolder> {

    List<String> list;
    List<String> listCopy = new ArrayList<>();
    Context context;
    public TextAdapter(Context context,List<String> list){
        this .context =context;
        this .list =list;
        this .listCopy.addAll(list);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_row, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int i) {
        holder.textView.setText(list.get(i));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Item Click: "+list.get(i), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView textView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.textView);
        }
    }

    public void filter(String text) {
        if (text.isEmpty()) {
            list.clear();
            list.addAll(listCopy);
        } else {
            ArrayList<String> result = new ArrayList<>();
            text = text.toLowerCase();
            for (String item : listCopy) {
                //match by name or phone
                if (item.toLowerCase().contains(text)) {
                    result.add(item);
                }
            }
            list.clear();
            list.addAll(result);
        }
        notifyDataSetChanged();
    }
}

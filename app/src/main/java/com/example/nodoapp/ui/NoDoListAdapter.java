package com.example.nodoapp.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nodoapp.R;
import com.example.nodoapp.model.NoDo;

import java.util.List;


public class NoDoListAdapter extends RecyclerView.Adapter<NoDoListAdapter.NoDoViewHolder> {
    private final LayoutInflater noDoInflater;
    private List<NoDo> noDoList;

    public NoDoListAdapter(Context context) {
        noDoInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public NoDoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = noDoInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new NoDoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoDoViewHolder holder, int position) {

        if (noDoList != null) {
            NoDo current = noDoList.get(position);
            holder.noDoTextView.setText(current.getNoDo());
        } else {
            holder.noDoTextView.setText(R.string.no_notodo);
        }

    }

    public void setNoDos(List<NoDo> noDos) {
        noDoList = noDos;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (noDoList != null)
            return noDoList.size();
        else return 0;
    }

    public class NoDoViewHolder extends RecyclerView.ViewHolder {
        public TextView noDoTextView;

        public NoDoViewHolder(@NonNull View itemView) {
            super(itemView);
            noDoTextView = itemView.findViewById(R.id.textView);

        }
    }
}

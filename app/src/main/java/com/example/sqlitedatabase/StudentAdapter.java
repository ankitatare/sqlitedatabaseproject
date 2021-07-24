package com.example.sqlitedatabase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder>

{
    Context mContext;
    List<Student> studentList;

    public StudentAdapter(Context mContext,List<Student> studentList)
    {
        this.mContext=mContext;
        this.studentList=studentList;
    }

    @NonNull
    @Override
    public StudentAdapter.ViewHolder onCreateViewHolder( ViewGroup parent, int viewType)
    {
        View myView= LayoutInflater.from(mContext).inflate(R.layout.custom_design,parent,false);
        return new ViewHolder(myView);
    }

    @Override
    public void onBindViewHolder( StudentAdapter.ViewHolder holder, int position)
    {
        Student s=studentList.get(position);
        holder.txtid.setText(String.valueOf(s.getId()));
        holder.txtemail.setText(s.getEmail());
        holder.txtName.setText(s.getName());


    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView txtid,txtName,txtemail;
        public ViewHolder(View itemview) {
            super(itemview);

            txtid=itemview.findViewById(R.id.id);
            txtName=itemview.findViewById(R.id.name);
            txtemail=itemview.findViewById(R.id.email);
        }
    }
}

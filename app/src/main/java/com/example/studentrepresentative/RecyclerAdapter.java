package com.example.studentrepresentative;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
        private ArrayList<Model>  studentList ;
        private Context mCont ;

    public RecyclerAdapter(ArrayList<Model> studentList, Context mCont) {
        this.studentList = studentList;
        this.mCont = mCont;
    }

    public int[] imageList =  {R.drawable.image1,R.drawable.image2,R.drawable.image3};

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image ;
        TextView title ;
        TextView detail ;
        TextView yearStudy ;
        Button btRemove ;

        public ViewHolder(View itemView) {
            super(itemView);

            image = (ImageView)itemView.findViewById(R.id.item_image);
            title = (TextView)itemView.findViewById(R.id.textViewTitle);
            detail = (TextView)itemView.findViewById(R.id.textViewDetail);
            yearStudy = (TextView)itemView.findViewById(R.id.textViewYearStudy);
            btRemove = (Button)itemView.findViewById(R.id.bRemove) ;
        }
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_layout, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewholder, int i) {


        Model mdata = studentList.get(i);
        viewholder.title.setText(mdata.getName());
        viewholder.detail.setText(mdata.getFacultyName());
        viewholder.yearStudy.setText(mdata.getYearSem());
        viewholder.image.setImageResource(imageList[2]);
        viewholder.btRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             //Do nothing
            }
        });

    }

    @Override
    public int getItemCount() {

        return studentList.size();
    }


}

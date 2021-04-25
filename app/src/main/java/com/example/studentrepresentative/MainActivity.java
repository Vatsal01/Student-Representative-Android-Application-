package com.example.studentrepresentative;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView ;
    RecyclerView.Adapter adapter ;
    RecyclerView.LayoutManager layoutManager ;
    ArrayList<Model> dataArray ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycle_view) ;
        layoutManager = new LinearLayoutManager(this) ;
        recyclerView.setLayoutManager(layoutManager);


        dataArray = new ArrayList<>();

        //List of Students

        dataArray.add(new Model("John Smith", "Internet Engineering","Degree - II, Year - II, Semester - 3"));
        dataArray.add(new Model("John Smith", "Teleinformatics","Degree - I, Year - II, Semester - 2"));
        dataArray.add(new Model("John Smith", "Computer Systems and Networks","Degree - I, Year - III, Semester - 6"));
        dataArray.add(new Model("John Smith", "Graphics and Multimedia Systems","Degree - I, Year - III, Semester - 6"));
        dataArray.add(new Model("John Smith",  "Information technology systems in medicine","Degree - II, Year - II, Semester - 3"));
        dataArray.add(new Model("John Smith", "Advanced Informatics and Control","Degree - I, Year - III, Semester - 6"));
        dataArray.add(new Model("John Smith", "Robotics (ARR)", "Degree - I, Year - I, Semester - 2"));
        dataArray.add(new Model("John Smith", "Electronics","Degree - II, Year - II, Semester - 3"));
        dataArray.add(new Model("John Smith", "Robotics","Degree - I, Year - II, Semester - 4"));
        dataArray.add(new Model("John Smith", "Telecommunications (TEL)","Degree - I, Year - III, Semester - 6"));
        dataArray.add(new Model("John Smith", "ICT networks (TSI)","Degree - I, Year - III, Semester - 6"));

        adapter = new RecyclerAdapter(dataArray,this);
        recyclerView.setAdapter(adapter);


        //To delete the student card, swipe function is defined below, direction set to LEFT

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {

            int position ;
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

                //To store the position of the student data needs to be removed, in order to add it later via UNDO action defined in Snackbar.

                position = viewHolder.getAdapterPosition();

                Model deletedStudent = dataArray.get(viewHolder.getAdapterPosition());

                // this method is called when item is swiped.
                // below line is to remove item from our array list.

                dataArray.remove(viewHolder.getAdapterPosition());

                // below line is to notify our item is removed from adapter
                adapter.notifyItemRemoved(viewHolder.getAdapterPosition());

                 //Snackbar with following message and UNDO action defined.
                Snackbar.make( recyclerView,deletedStudent.getName(), Snackbar.LENGTH_LONG).setAction("UNDO", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dataArray.add(position,deletedStudent);

                        // below line is to notify item is
                        // added to our adapter class.

                        adapter.notifyItemInserted(position);
                    }
                }).show();
            }
            // at last we are adding this
            // to our recycler view.
        }).attachToRecyclerView(recyclerView);
    }
}

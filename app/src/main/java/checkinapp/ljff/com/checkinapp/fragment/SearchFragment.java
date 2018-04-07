package checkinapp.ljff.com.checkinapp.fragment;

import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import java.util.List;

import checkinapp.ljff.com.checkinapp.R;
import checkinapp.ljff.com.checkinapp.adapter.StudentListViewAdapter;
import checkinapp.ljff.com.checkinapp.database.AppDatabase;
import checkinapp.ljff.com.checkinapp.entity.Student;

/**
 * Created by Phouthasak Douanglee on 3/14/2018.
 */

public class SearchFragment extends Fragment{
    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerView;
    private SearchView searchBar;
    private View rootView;
    private AppDatabase database;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_search, container, false);
        searchBar = rootView.findViewById(R.id.svSearchBar);
        database = Room.databaseBuilder(getActivity().getApplicationContext(), AppDatabase.class, "students").allowMainThreadQueries().build();
        populateList();
        return rootView;
    }

    private void populateList(){
        //database.studentsDAO().deleteAllStudents();
//        Student student1 = new Student();
//        student1.setId(1);
//        student1.setStudentId(123);
//        student1.setFname("Sponge Bob");
//        student1.setLname("Squarepants");
//
//        Student student2 = new Student();
//        student2.setId(2);
//        student2.setStudentId(456);
//        student2.setFname("Patrick");
//        student2.setLname("Star");
//
//        Student student3 = new Student();
//        student3.setId(3);
//        student3.setStudentId(789);
//        student3.setFname("Squidward");
//        student3.setLname("Tentacles");
//
//        database.studentsDAO().addStudent(student1);
//        database.studentsDAO().addStudent(student2);
//        database.studentsDAO().addStudent(student3);

        List<Student> students = database.studentsDAO().getStudents();
        Log.d("*****StudentCount*****", String.valueOf(students.size()));
        for(Student student: students){
            Log.d("StudentID", String.valueOf(student.getId()));
            Log.d("StudentName", student.getFname() + " " + student.getLname());
        }

        recyclerView = rootView.findViewById(R.id.rvStudentList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        adapter = new StudentListViewAdapter(students);
        recyclerView.setAdapter(adapter);
    }
}

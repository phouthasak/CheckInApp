package checkinapp.ljff.com.checkinapp.fragment;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

import checkinapp.ljff.com.checkinapp.R;
import checkinapp.ljff.com.checkinapp.activity.ProfileActivity;
import checkinapp.ljff.com.checkinapp.adapter.StudentListViewAdapter;
import checkinapp.ljff.com.checkinapp.database.AppDatabase;
import checkinapp.ljff.com.checkinapp.entity.Student;

/**
 * Created by Phouthasak Douanglee on 3/14/2018.
 */

public class SearchFragment extends Fragment{
    private StudentListViewAdapter adapter;
    private RecyclerView recyclerView;
    private SearchView searchBar;
    private View rootView;
    private AppDatabase database;
    private List<Student> students;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_search, container, false);
        searchBar = rootView.findViewById(R.id.svSearchBar);
        database = Room.databaseBuilder(getActivity().getApplicationContext(), AppDatabase.class, "students").allowMainThreadQueries().build();
        populateList();

        searchBar.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                filter(s);
                return false;
            }
        });

        return rootView;
    }

    private void filter(String text){
        List<Student> filteredList = new ArrayList<Student>();
        boolean inputIsNumber = false;
        int studentId = 0;

        try{
            studentId = Integer.parseInt(text);
            inputIsNumber = true;
        }catch(NumberFormatException ex){
            Log.e("CheckingQueryString", "Input is not an integer");
        }

        for(Student student: students){
            if(student.getLname().toLowerCase().contains(text.toLowerCase()) || student.getFname().toLowerCase().contains(text.toLowerCase())){
                filteredList.add(student);
            }else if(inputIsNumber){
                if(student.getStudentId() == studentId){
                    filteredList.add(student);
                }
            }
        }

        adapter.filterList(filteredList);
    }

    private void populateList(){
//        recreateAndAddStudents();
        students = database.studentsDAO().getStudents();
        Log.d("*****StudentCount*****", String.valueOf(students.size()));
        for(Student student: students){
            Log.d("StudentID", String.valueOf(student.getId()));
            Log.d("StudentName", student.getFname() + " " + student.getLname());
            Log.d("StudentSchool", student.getSchoolName());
            Log.d("MediaWavier", String.valueOf(student.isMediaWavier()));
            Log.d("Guests", String.valueOf(student.getGuests()));
        }
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        DividerItemDecoration itemDecoration = new DividerItemDecoration(getContext(), layoutManager.getOrientation());
        recyclerView = rootView.findViewById(R.id.rvStudentList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(itemDecoration);
        adapter = new StudentListViewAdapter(students);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new StudentListViewAdapter.OnItemClickListener(){
            @Override
            public void onItemClicked(int position) {
                Intent intent = new Intent(getActivity(), ProfileActivity.class);
                intent.putExtra("student", students.get(position));
                getActivity().startActivity(intent);
            }
        });
    }

    private void recreateAndAddStudents() {
        //this is here for dummy data to test internal storage
        database.studentsDAO().deleteAllStudents();
        Student student1 = new Student();
        student1.setId(1);
        student1.setStudentId(123);
        student1.setFname("Sponge Bob");
        student1.setLname("Squarepants");
        student1.setSchoolName("St. Vincent St. Mary");
        student1.setMediaWavier(true);
        student1.setGuests(1);

        Student student2 = new Student();
        student2.setId(2);
        student2.setStudentId(456);
        student2.setFname("Patrick");
        student2.setLname("Star");
        student2.setSchoolName("St. Vincent St. Mary");
        student2.setMediaWavier(false);
        student2.setGuests(2);

        Student student3 = new Student();
        student3.setId(3);
        student3.setStudentId(789);
        student3.setFname("Squidward");
        student3.setLname("Tentacles");
        student3.setSchoolName("St. Vincent St. Mary");
        student3.setMediaWavier(false);
        student3.setGuests(0);

        Student student4 = new Student();
        student4.setId(4);
        student4.setStudentId(147);
        student4.setFname("Ugene");
        student4.setLname("Krabs");
        student4.setSchoolName("St. Vincent St. Mary");
        student4.setMediaWavier(false);
        student4.setGuests(2);

        Student student5 = new Student();
        student5.setId(5);
        student5.setStudentId(159);
        student5.setFname("Jennifer");
        student5.setLname("Puff");
        student5.setSchoolName("St. Vincent St. Mary");
        student5.setMediaWavier(true);
        student5.setGuests(0);

        Student student6 = new Student();
        student6.setId(6);
        student6.setStudentId(258);
        student6.setFname("Sheldon");
        student6.setLname("Plankton");
        student6.setSchoolName("St. Vincent St. Mary");
        student6.setMediaWavier(false);
        student6.setGuests(2);

        Student student7 = new Student();
        student7.setId(7);
        student7.setStudentId(321);
        student7.setFname("Larry");
        student7.setLname("Lobster");
        student7.setSchoolName("St. Vincent St. Mary");
        student7.setMediaWavier(false);
        student7.setGuests(5);

        Student student8 = new Student();
        student8.setId(8);
        student8.setStudentId(369);
        student8.setFname("Sandy");
        student8.setLname("Cheeks");
        student8.setSchoolName("St. Vincent St. Mary");
        student8.setMediaWavier(true);
        student8.setGuests(3);

        Student student9 = new Student();
        student9.setId(9);
        student9.setStudentId(654);
        student9.setFname("Ernie");
        student9.setLname("Mermaid");
        student9.setSchoolName("St. Vincent St. Mary");
        student9.setMediaWavier(false);
        student9.setGuests(1);

        Student student10 = new Student();
        student10.setId(10);
        student10.setStudentId(951);
        student10.setFname("Flying");
        student10.setLname("Dutchman");
        student10.setSchoolName("St. Vincent St. Mary");
        student10.setMediaWavier(false);
        student10.setGuests(10);

        Student student11 = new Student();
        student11.setId(11);
        student11.setStudentId(987);
        student11.setFname("Pearl");
        student11.setLname("Krabs");
        student11.setSchoolName("St. Vincent St. Mary");
        student11.setMediaWavier(true);
        student11.setGuests(1);

        database.studentsDAO().addStudent(student1);
        database.studentsDAO().addStudent(student2);
        database.studentsDAO().addStudent(student3);
        database.studentsDAO().addStudent(student4);
        database.studentsDAO().addStudent(student5);
        database.studentsDAO().addStudent(student6);
        database.studentsDAO().addStudent(student7);
        database.studentsDAO().addStudent(student8);
        database.studentsDAO().addStudent(student9);
        database.studentsDAO().addStudent(student10);
        database.studentsDAO().addStudent(student11);
    }


}

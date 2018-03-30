package checkinapp.ljff.com.checkinapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import checkinapp.ljff.com.checkinapp.R;
import checkinapp.ljff.com.checkinapp.entity.Student;

/**
 * Created by Phouthasak Douanglee on 3/30/2018.
 */

public class StudentListViewAdapter extends ArrayAdapter<Student> {
    private TextView tvStudentId, tvLastName, tvFirstName;
    public StudentListViewAdapter(Context context, List<Student> students) {
        super(context, R.layout.list_item, students);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View view = inflater.inflate(R.layout.list_item, parent, false);

        Student student = getItem(position);
        tvStudentId = view.findViewById(R.id.tvStudentID);
        tvLastName = view.findViewById(R.id.tvLastName);
        tvFirstName = view.findViewById(R.id.tvFirstName);

        tvStudentId.setText(String.valueOf(student.getStudentId()));
        tvLastName.setText(student.getLname());
        tvFirstName.setText(student.getFname());
        return view;
    }
}

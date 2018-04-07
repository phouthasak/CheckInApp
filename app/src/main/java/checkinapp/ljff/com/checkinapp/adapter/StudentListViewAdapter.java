package checkinapp.ljff.com.checkinapp.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import checkinapp.ljff.com.checkinapp.R;
import checkinapp.ljff.com.checkinapp.entity.Student;

/**
 * Created by Phouthasak Douanglee on 3/30/2018.
 */

public class StudentListViewAdapter extends RecyclerView.Adapter<StudentListViewAdapter.ViewHolder> {
    private List<Student> students;
    private OnItemClickListener listener;
    public StudentListViewAdapter(List<Student> students) {
        this.students = students;
    }

    public interface OnItemClickListener{
        void onItemClicked(int position);
    }

    public void setOnItemClickListener(OnItemClickListener clickListener){
        listener = clickListener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView tvStudentId, tvLastName, tvFirstName;
        public ViewHolder(View view, final OnItemClickListener onItemClickListener){
            super(view);
            tvStudentId = view.findViewById(R.id.tvStudentID);
            tvLastName = view.findViewById(R.id.tvLastName);
            tvFirstName = view.findViewById(R.id.tvFirstName);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(onItemClickListener != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            onItemClickListener.onItemClicked(position);
                        }
                    }
                }
            });
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(StudentListViewAdapter.ViewHolder holder, int position) {
        Student student = students.get(position);
        holder.tvStudentId.setText(String.valueOf(student.getStudentId()));
        holder.tvLastName.setText(student.getLname());
        holder.tvFirstName.setText(student.getFname());
    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    public void filterList(List<Student> filteredList){
        students = filteredList;
        notifyDataSetChanged();
    }
}

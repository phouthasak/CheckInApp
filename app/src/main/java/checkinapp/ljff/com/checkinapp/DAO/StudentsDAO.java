package checkinapp.ljff.com.checkinapp.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import checkinapp.ljff.com.checkinapp.entity.Student;

/**
 * Created by Phouthasak Douanglee on 3/30/2018.
 */

@Dao
public interface StudentsDAO {
    @Insert
    public void addStudent(Student student);

    @Query("select * from students")
    public List<Student> getStudents();

    @Query("delete from students where id >= 0")
    public void deleteAllStudents();
}

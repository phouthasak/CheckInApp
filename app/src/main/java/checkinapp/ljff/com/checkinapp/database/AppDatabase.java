package checkinapp.ljff.com.checkinapp.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import checkinapp.ljff.com.checkinapp.DAO.StudentsDAO;
import checkinapp.ljff.com.checkinapp.entity.Student;

/**
 * Created by Phouthasak Douanglee on 3/30/2018.
 */

@Database(entities = {Student.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase{
    public abstract StudentsDAO studentsDAO();
}

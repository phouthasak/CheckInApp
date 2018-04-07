package checkinapp.ljff.com.checkinapp.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Phouthasak Douanglee on 3/30/2018.
 */

@Entity(tableName = "students")
public class Student implements Parcelable{
    @PrimaryKey
    private int id;

    private int studentId;
    private String fname;
    private String lname;
    private String schoolName;
    private boolean mediaWavier;
    private int guests;
    private boolean checkedIn;

    public Student(){}

    protected Student(Parcel in) {
        id = in.readInt();
        studentId = in.readInt();
        fname = in.readString();
        lname = in.readString();
        schoolName = in.readString();
        mediaWavier = in.readByte() != 0;
        guests = in.readInt();
        checkedIn = in.readByte() != 0;
    }

    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel in) {
            return new Student(in);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeInt(studentId);
        parcel.writeString(fname);
        parcel.writeString(lname);
        parcel.writeString(schoolName);
        parcel.writeByte((byte) (mediaWavier ? 1 : 0));
        parcel.writeInt(guests);
        parcel.writeByte((byte) (checkedIn ? 1 : 0));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public boolean isMediaWavier() {
        return mediaWavier;
    }

    public void setMediaWavier(boolean mediaWavier) {
        this.mediaWavier = mediaWavier;
    }

    public int getGuests() {
        return guests;
    }

    public void setGuests(int guests) {
        this.guests = guests;
    }

    public boolean isCheckedIn() {
        return checkedIn;
    }

    public void setCheckedIn(boolean checkedIn) {
        this.checkedIn = checkedIn;
    }

}

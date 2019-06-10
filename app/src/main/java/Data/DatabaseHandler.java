package Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import Students.Student;
import Util.Util;


public class DatabaseHandler extends SQLiteOpenHelper {


    public DatabaseHandler( Context context) {
        super(context, Util.DATABASE_NAME, null, Util.DATABASE_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_STUDENTS_TABLE ="CREATE TABLE " + Util.TABLE_NAME + "("
                + Util.KEY_ID + " INTEGER PRIMARY KEY,"
                + Util.KEY_FACULTY + " TEXT,"
                + Util.KEY_FIRSTNAME + " TEXT,"
                + Util.KEY_SECONDNAME + " TEXT,"
                + Util.KEY_AVERAGERATING + " TEXT" + ")";

        db.execSQL(CREATE_STUDENTS_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Util.TABLE_NAME ); // delete old SQL version
        onCreate(db);
    }


    public void addStudent (Student student){
        SQLiteDatabase db =this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(Util.KEY_FACULTY , student.getFaculty());
        contentValues.put(Util.KEY_FIRSTNAME , student.getFirstName());
        contentValues.put(Util.KEY_SECONDNAME , student.getSecondName());
        contentValues.put(Util.KEY_AVERAGERATING , student.getAverageRating());

        db.insert(Util.TABLE_NAME, null , contentValues);
        db.close();
    }

    public List<Student> getAllStudents(){
        SQLiteDatabase db = this.getReadableDatabase();

        List<Student> studentList = new ArrayList<>();

        String selectAllStudents = "SELECT * FROM " + Util.TABLE_NAME;
        Cursor cursor = db.rawQuery(selectAllStudents , null);
        if(cursor.moveToFirst()){
            do{
                Student student = new Student();
                student.setId(Integer.parseInt(cursor.getString(0)));
                student.setFaculty(cursor.getString(1));
                student.setFirstName(cursor.getString(2));
                student.setSecondName(cursor.getString(3));
                student.setAverageRating(cursor.getString(4));

                studentList.add(student);
            }while (cursor.moveToNext());
        }
        return studentList;
    }

    public Student getStudent(int id){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(Util.TABLE_NAME, new String[] {Util.KEY_ID, Util.KEY_FACULTY,
        Util.KEY_FIRSTNAME, Util.KEY_SECONDNAME , Util.KEY_AVERAGERATING}, Util.KEY_ID + "=?",
                new String[] {String.valueOf(id)} , null , null , null, null);

        if (cursor != null){
            cursor.moveToFirst();
        }

        Student student = new Student(Integer.parseInt(cursor.getString(0)), cursor.getString(1),
                cursor.getString(2) , cursor.getString(3), cursor.getString(4));
        return student;
    }
}

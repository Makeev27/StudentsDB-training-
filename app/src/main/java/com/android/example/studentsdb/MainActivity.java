package com.android.example.studentsdb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

import Data.DatabaseHandler;
import Students.Student;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DatabaseHandler databaseHandler = new DatabaseHandler(this);
        databaseHandler.addStudent(new Student("ИТ-23" , "Пушкин" , "Александр" , "3,5"));
        databaseHandler.addStudent(new Student("ИТ-13" , "Душкин" , "Сергей" , "4,6"));
        databaseHandler.addStudent(new Student("ИТ-43" , "Макушкин" , "Владимир" , "3,7"));
        databaseHandler.addStudent(new Student("МИТ-33" , "Потягушкин" , "Иван" , "3,8"));
        databaseHandler.addStudent(new Student("ГИТ-53" , "Золотушкин" , "Илья" , "4"));

        List<Student> allStudents = databaseHandler.getAllStudents();

        for (Student student : allStudents){
            Log.d("hz" , "ID" + student.getId() + ", Имя " + student.getFirstName()
                    + ", Фамилия " + student.getSecondName() + ", Факультет " + student.getFaculty() + ", Средний Балл " +
                    student.getAverageRating());
        }


    }
}

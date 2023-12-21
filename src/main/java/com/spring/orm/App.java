package com.spring.orm;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.*;
import java.util.*;

public class App
{
    public static void main( String[] args ) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc  = new Scanner(System.in);

        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        StudentDao sdao = (StudentDao) context.getBean("studentDao");

        int id;
        String name, city;
        boolean go = true;
        while (go)
        {
            System.out.println("Select an operation: ");
            System.out.println("1.Insert");
            System.out.println("2.Update");
            System.out.println("3.Delete");
            System.out.println("4.Select a single object");
            System.out.println("5.Select multiple objects");
            System.out.println("6.Exit");
            System.out.println("Enter your choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1 -> {
                    Student s1 = new Student();
                    System.out.println("Enter studentId: ");
                    s1.setId(Integer.parseInt(br.readLine()));
                    System.out.println("Enter studentName: ");
                    s1.setName(br.readLine());
                    System.out.println("Enter studentCity: ");
                    s1.setCity(br.readLine());
                    int res = sdao.insertStudent(s1);
                    System.out.println("Student added successfully: " + res);
                }
                case 2 -> {
                    Student s2 = new Student();
                    System.out.println("Enter studentId: ");
                    s2.setId(Integer.parseInt(br.readLine()));
                    System.out.println("Enter studentName: ");
                    s2.setName(br.readLine());
                    System.out.println("Enter studentCity: ");
                    s2.setCity(br.readLine());
                    sdao.updateStudent(s2);
                    System.out.println("Student updated successfully.");
                }
                case 3 -> {
                    System.out.println("Enter studentId to be deleted: ");
                    Student s3 = sdao.deleteStudent(sc.nextInt());
                    if (s3 != null) {
                        System.out.println("Student deleted successfully.");
                    }
                    else{
                        System.out.println("The student not exist.");
                    }
                }
                case 4 -> {
                    System.out.println("Enter studentId to be retrieved: ");
                    Student s4 = sdao.getStudent(sc.nextInt());
                    System.out.println(s4);
                }
                case 5 -> {
                    List<Student> students = sdao.getAllStudents();
                    for (Student s : students) {
                        System.out.println(s);
                    }
                }
                case 6 -> {
                    System.out.println("Exiting...");
                    go = false;
                }
                default -> System.out.println("Invalid choice");

            }
        }

        System.out.println("Thanks for using CRUD operation program..");


    }
}

package com.spring.orm.dao;

import com.spring.orm.entities.Student;
import org.springframework.orm.hibernate5.HibernateTemplate;
import javax.transaction.Transactional;
import java.util.List;

public class StudentDao {
    private HibernateTemplate hTemplate;
    public HibernateTemplate gethTemplate() {
        return hTemplate;
    }

    public void sethTemplate(HibernateTemplate hTemplate) {
        this.hTemplate = hTemplate;
    }

    // To insert student
    @Transactional
    public int insertStudent(Student s1)
    {
        return (Integer) hTemplate.save(s1);
    }

    // To update student
    @Transactional
    public void updateStudent(Student s1)
    {
        hTemplate.update(s1);
    }

    // To delete a student
    @Transactional
    public Student deleteStudent(int id)
    {
        Student s1 = hTemplate.get(Student.class, id);
        if( s1 != null)
        {
            hTemplate.delete(s1);
        }
        return s1;
    }

    // To get a single row (object)
    public Student getStudent(int id)
    {
        return hTemplate.get(Student.class, id);
    }

    // To get all rows (multiple objects)
    public List<Student> getAllStudents()
    {
        return hTemplate.loadAll(Student.class);
    }


}

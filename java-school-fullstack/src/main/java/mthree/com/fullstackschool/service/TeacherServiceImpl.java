package mthree.com.fullstackschool.service;

import mthree.com.fullstackschool.dao.CourseDaoImpl;
import mthree.com.fullstackschool.dao.StudentDao;
import mthree.com.fullstackschool.dao.TeacherDao;
import mthree.com.fullstackschool.model.Course;
import mthree.com.fullstackschool.model.Student;
import mthree.com.fullstackschool.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.JDBCType;
import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherServiceInterface {

    //YOUR CODE STARTS HERE

    TeacherDao teacherDao;

    public TeacherServiceImpl() {}

    public TeacherServiceImpl(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }

    //YOUR CODE ENDS HERE

    public List<Teacher> getAllTeachers() {
        //YOUR CODE STARTS HERE

        return teacherDao.getAllTeachers();

        //YOUR CODE ENDS HERE
    }

    public Teacher getTeacherById(int id) {
        //YOUR CODE STARTS HERE

        Teacher tc = new Teacher();
        try {
            tc = teacherDao.findTeacherById(id);
        } catch (DataAccessException e) {
            tc.setTeacherFName("Teacher Not Found");
            tc.setTeacherLName("Teacher Not Found");
        }

        return tc;

        //YOUR CODE ENDS HERE
    }

    public Teacher addNewTeacher(Teacher teacher) {
        //YOUR CODE STARTS HERE

        if (teacher.getTeacherFName().isBlank()) {
            teacher.setTeacherFName("First Name blank, teacher NOT added");
        }
        if (teacher.getTeacherLName().isBlank()) {
            teacher.setTeacherLName("Last Name blank, teacher NOT added");
        }
        return teacherDao.createNewTeacher(teacher);

        //YOUR CODE ENDS HERE
    }

    public Teacher updateTeacherData(int id, Teacher teacher) {
        //YOUR CODE STARTS HERE

        if (id != teacher.getTeacherId()) {
            teacher.setTeacherFName("IDs do not match, teacher not updated");
            teacher.setTeacherLName("IDs do not match, teacher not updated");
        }
        teacherDao.updateTeacher(teacher);
        return teacher;

        //YOUR CODE ENDS HERE
    }

    public void deleteTeacherById(int id) {
        //YOUR CODE STARTS HERE

        teacherDao.deleteTeacher(id);

        //YOUR CODE ENDS HERE
    }
}

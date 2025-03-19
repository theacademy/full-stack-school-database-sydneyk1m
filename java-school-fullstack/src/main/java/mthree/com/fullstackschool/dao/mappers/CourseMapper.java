package mthree.com.fullstackschool.dao.mappers;

import mthree.com.fullstackschool.model.Course;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CourseMapper implements RowMapper<Course> {
    @Override
    public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
        //YOUR CODE STARTS HERE

        Course cs = new Course();
        cs.setCourseId(rs.getInt("cid"));
        cs.setCourseName(rs.getString("courseCode"));
        cs.setCourseDesc(rs.getString("courseDesc"));
        cs.setTeacherId(rs.getInt("teacherId"));
        return cs;

        //YOUR CODE ENDS HERE
    }
}

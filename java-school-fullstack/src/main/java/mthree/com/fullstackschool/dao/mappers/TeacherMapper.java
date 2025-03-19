package mthree.com.fullstackschool.dao.mappers;

import mthree.com.fullstackschool.model.Teacher;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TeacherMapper implements RowMapper<Teacher> {
    @Override
    public Teacher mapRow(ResultSet rs, int rowNum) throws SQLException {
        //YOUR CODE STARTS HERE

        Teacher tc = new Teacher();

        tc.setTeacherId(rs.getInt("tid"));
        tc.setTeacherFName(rs.getString("tFName"));
        tc.setTeacherLName(rs.getString("tLName"));
        tc.setDept(rs.getString("dept"));
        return tc;

        //YOUR CODE ENDS HERE
    }
}

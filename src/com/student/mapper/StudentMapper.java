package com.student.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

import com.student.bean.Student;

/**
 * StudentMapper数据库映射
 * @ClassName StudentMapper
 */

public class StudentMapper implements RowMapper<Student> {

	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		Student student = new Student();

		student.setId(rs.getInt(1));
		student.setName(rs.getString(2));

		student.setBirthday(getStringDate(rs.getString(3)));
		student.setAge(rs.getInt(4));
		student.setScore(rs.getDouble(5));
		return student;
	}

	/**
	   * 获取日期
	   * @return 返回日期字符串格式yyyy-MM-dd
	   * @throws ParseException
	   */
	private String getStringDate(String birthday) {

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date dateString = new Date();
		String strRtnDate = "";
		try {
			dateString = formatter.parse(birthday);
			strRtnDate = new SimpleDateFormat("yyyy-MM-dd").format(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return strRtnDate;
	}

}
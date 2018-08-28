package com.student.dao;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.jdbc.core.JdbcTemplate;

import com.student.bean.Student;
import com.student.mapper.StudentMapper;

public class StudentDao {

	/**
	 * @Fields jdbcTemplate
	 */
	private JdbcTemplate jdbcTemplate;

	/**
	 * spring謠蝉ｾ帷噪邀ｻ
	 *
	 * @param jdbcTemplate
	 * 霑泌屓蛟ｼ邀ｻ蝙具ｼ� void
	 */
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * 譟･隸｢謇�譛牙ｭｦ逕�
	 * @return 霑泌屓蛟ｼ邀ｻ蝙具ｼ� List<Student>
	 */
	public List<Student> queryAll() {

		// (1)Loggerオブジェクトの生成
//		Logger log = Logger.getLogger(ExLog2.class.getName());
//		log.info("変数は10以上です。"); // (2)infoメソッドの記述

		String sql = "select id,name,birthday,age,score,classid from student";
		// 将查询结果映射到Student类中，添加到list中，并返回
		List<Student> studentList = new ArrayList<Student>();
		studentList = (ArrayList<Student>) jdbcTemplate.query(sql, new StudentMapper());
		for (Student stud : studentList) {
			// Arraylistから学生を１個ずつ取り出し表示する
			System.out.println(stud.toString());
		}
		int IdSum1 = 0;
		int max = 0;
		int min = 0;
		int num = 0;
		for (Student student : studentList) {
			IdSum1 = student.getId() + IdSum1;
			if (student.getId() > max) {
				max = student.getId();
			}

			if (num == 0) {
				min = student.getId();
			} else {
				if (student.getId() < min) {
					min = student.getId();
				}

			}
			num++;

		}

		int avgID = IdSum1 / studentList.size();

		System.out.println("avgID" + avgID);
		System.out.println("max" + max);
		System.out.println("min" + min);
		return studentList;
	}

	/**
	 * 騾夊ｿ�蟋灘錐譟･隸｢
	 * @param name
	 * @return 霑泌屓蛟ｼ邀ｻ蝙具ｼ� List<Student>
	 */
	public List<Student> queryByName(String name) {
		String sql = "select id,name,birthday,age,score  from student where name like '%" + name + "%'";

		return jdbcTemplate.query(sql, new StudentMapper());
	}

	/**
	 * 豺ｻ蜉�蟄ｦ逕�
	 * @param student
	 * @return 霑泌屓蛟ｼ邀ｻ蝙具ｼ� boolean
	 */
	public boolean addStu(Student student) {
		String sql = "insert into student(id,name,birthday,age,score) values(0,?,?,?,?)";

		return jdbcTemplate.update(sql,
				new Object[] { student.getName(), student.getBirthday(), student.getAge(),
						student.getScore() },
				new int[] { Types.VARCHAR, Types.VARCHAR, Types.INTEGER, Types.DOUBLE }) == 1;
	}

	/**
	 * 蛻�髯､蟄ｦ逕�
	 * @param id
	 * @return 霑泌屓蛟ｼ邀ｻ蝙具ｼ� boolean
	 */
	public boolean deleteStu(Integer id) {

		String sql = "delete from student where id = ?";
		return jdbcTemplate.update(sql, id) == 1;
	}

	/**
	 * 譖ｴ譁ｰ蟄ｦ逕滉ｿ｡諱ｯ
	 * @param student
	 * @return 霑泌屓蛟ｼ邀ｻ蝙具ｼ� boolean
	 */
	public boolean updateStu(Student student) {

		String sql = "update student set name=? ,age=?,birthday = ? ,score = ? where id = ?";
		Object stuObj[] = new Object[] {student.getName(), student.getAge(), student.getBirthday(),
				student.getScore(), student.getId() };

		return jdbcTemplate.update(sql, stuObj) == 1;
	}

}

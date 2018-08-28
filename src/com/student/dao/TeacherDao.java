package com.student.dao;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.jdbc.core.JdbcTemplate;

import com.teacher.bean.Teacher;
import com.student.mapper.TeacherMapper;

import com.teacher.bean.Teacher;

public class TeacherDao {

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
	 * @return 霑泌屓蛟ｼ邀ｻ蝙具ｼ� List<teacher>
	 */
	public List<Teacher> queryAll() {

		// (1)Loggerオブジェクトの生成
//		Logger log = Logger.getLogger(ExLog2.class.getName());
//		log.info("変数は10以上です。"); // (2)infoメソッドの記述

		String sql = "select id,teachername,course from teacher";
		// 将查询结果映射到teacher类中，添加到list中，并返回
		List<Teacher> teacherList = new ArrayList<Teacher>();
		teacherList = (ArrayList<Teacher>) jdbcTemplate.query(sql, new TeacherMapper());
		for (Teacher teacher : teacherList) {
			// Arraylistから学生を１個ずつ取り出し表示する
			System.out.println(teacher.toString());
		}
		int IdSum1 = 0;
		int max = 0;
		int min = 0;
		int num = 0;
		for (Teacher teacher : teacherList) {
			IdSum1 = teacher.getId() + IdSum1;
			if (teacher.getId() > max) {
				max = teacher.getId();
			}

			if (num == 0) {
				min = teacher.getId();
			} else {
				if (teacher.getId() < min) {
					min = teacher.getId();
				}

			}
			num++;

		}

		int avgID = IdSum1 / teacherList.size();

		System.out.println("avgID" + avgID);
		System.out.println("max" + max);
		System.out.println("min" + min);
		return teacherList;
	}

	/**
	 * 騾夊ｿ�蟋灘錐譟･隸｢
	 * @param name
	 * @return 霑泌屓蛟ｼ邀ｻ蝙具ｼ� List<teacher>
	 */
	public List<Teacher> queryByName(String name) {
		String sql = "select id,teachername,course from teacher where name like '%" + name + "%'";

		return jdbcTemplate.query(sql, new TeacherMapper());
	}

	/**
	 * 豺ｻ蜉�蟄ｦ逕�
	 * @param teacher
	 * @return 霑泌屓蛟ｼ邀ｻ蝙具ｼ� boolean
	 */
	public boolean addTeacher(Teacher teacher) {
		String sql = "insert into teacher(id,name,birthday,age,score) values(0,?,?,?,?)";

		return jdbcTemplate.update(sql,
				new Object[] { teacher.getTeachername(), teacher.getId(), teacher.getCourse(),
						 },
				new int[] { Types.VARCHAR, Types.VARCHAR, Types.INTEGER, Types.DOUBLE }) == 1;
	}

	/**
	 * 蛻�髯､蟄ｦ逕�
	 * @param id
	 * @return 霑泌屓蛟ｼ邀ｻ蝙具ｼ� boolean
	 */
	public boolean deleteTeacher(Integer id) {

		String sql = "delete from teacher where id = ?";
		return jdbcTemplate.update(sql, id) == 1;
	}

	/**
	 * 譖ｴ譁ｰ蟄ｦ逕滉ｿ｡諱ｯ
	 * @param teacher
	 * @return 霑泌屓蛟ｼ邀ｻ蝙具ｼ� boolean
	 */
	public boolean updateTeacher(Teacher teacher) {

		String sql = "update teacher set teachername=? ,id=?,course = ?  where id = ?";
		Object teacherObj[] = new Object[] {teacher.getId(), teacher.getTeachername(), teacher.getCourse(),
				 };

		return jdbcTemplate.update(sql, teacherObj) == 1;
	}

}

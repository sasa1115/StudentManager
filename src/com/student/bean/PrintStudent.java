package com.student.bean;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ui.Model;

import com.student.dao.StudentDao;

public class PrintStudent {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		StudentDao studentDao = (StudentDao) context.getBean("dao");

		List<Student> studentList = studentDao.queryAll();
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

		System.out.println("�w����id�𕽋�" + avgID);
		System.out.println("�w����id���ő�" + max);
		System.out.println("�w����id���ŏ�" + min);

	}

	// TODO �����������ꂽ���\�b�h�E�X�^�u

}

/**
 *
 */
package com.teacher.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * �搶�̂Ԃ���
 *
 * @author USER
 *
 */
public class PrintTeacher {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		Teacher teacherOne = new Teacher();
		teacherOne.setId(1);
		teacherOne.setTeachername("teacher01");
		teacherOne.setCourse("Chinese");

		Teacher teacherTwo = new Teacher();
		teacherTwo.setId(2);
		teacherTwo.setTeachername("teacher02");
		teacherTwo.setCourse("Japanse");

		Teacher teacherThree = new Teacher();
		teacherThree.setId(3);
		teacherThree.setTeachername("teacher03");
		teacherThree.setCourse("Math");

		// �搶��hashmap��V�K����
		Map<Integer, Teacher> teacherMap = new HashMap();
		// �搶1��hashmap�ɂ����
		teacherMap.put(1, teacherOne);
		teacherMap.put(2, teacherTwo);
		teacherMap.put(3, teacherThree);
		// �搶��id�̏������G
		int Idsum = 0;
		// Loop���v
		for (Teacher teacher : teacherMap.values()) {
			// ����搶��id�����o��
			Idsum = teacher.getId() + Idsum;
		}
		System.out.println("�搶��id��" + Idsum);
		System.out.println("�搶��id�𕽋�" + Idsum / teacherMap.size());

		List<Teacher> teacherList = new ArrayList();
		teacherList.add(teacherOne);
		teacherList.add(teacherTwo);
		teacherList.add(teacherThree);
		// List��loop���v
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

		System.out.println("�搶��id�𕽋�" + avgID);
		System.out.println("�搶��id���ő�" + max);
		System.out.println("�搶��id���ŏ�" + min);

		int x = teacherOne.getId();
		System.out.println("x" + x);
	}

}

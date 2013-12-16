package com.dw.party.service;

import com.dw.party.pojo.Course;

/**
 * CourseService interface
 * @author xingkong1221
 *
 */
public interface ICourseService extends IBaseService<Course, Long> {
	/**
	 * Check title unqiue
	 * @param title
	 * @return
	 */
	public boolean checkTitleUnqiue(String title);
}

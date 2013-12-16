package com.dw.party.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.dw.party.dao.IBaseDao;
import com.dw.party.dao.ICourseDao;
import com.dw.party.pojo.Course;
import com.dw.party.service.ICourseService;

/**
 * Implements interface ICourseService
 * @author xingkong1221
 *
 */
@Service("courseService")
public class CourseServiceImpl extends BaseServiceImpl<Course, Long> implements ICourseService {
	private ICourseDao courseDao;
	
	@Autowired
	@Qualifier("courseDao")
	@Override
	public void setBaseDao(IBaseDao<Course, Long> baseDao) {
		this.baseDao = baseDao;
		this.courseDao = (ICourseDao) baseDao;
	}
	
	@Override
	public boolean checkTitleUnqiue(String title) {
		return this.courseDao.checkUnique("title", title);
	}

	

}

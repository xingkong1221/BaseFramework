package com.dw.party.dao.impl;

import org.springframework.stereotype.Repository;

import com.dw.party.dao.ICourseDao;
import com.dw.party.pojo.Course;

/**
 * Implements ICourseDao interface
 * @author xingkong1221
 *
 */
@Repository("courseDao")
public class CourseDaoImpl extends BaseDaoImpl<Course, Long> implements ICourseDao {

}

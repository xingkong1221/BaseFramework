package com.dw.party.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dw.party.pagination.Pager;
import com.dw.party.pojo.Course;
import com.dw.party.service.ICourseService;

/**
 * Study course
 * @author xingkong1221
 *
 */
@Controller
@RequestMapping(value = "/course")
public class CourseController extends BaseController {

	@Autowired
	@Qualifier("courseService")
	private ICourseService courseService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String index(Model model) {
		Pager pager = new Pager();
		pager.setSort("createTime");
		pager.setDir("desc");
		pager.calcPageCount(this.courseService.countAll());
		List<Course> courses = this.courseService.list(pager, "organId", userPreferences.getOrganId());
		model.addAttribute("courses", courses);
		model.addAttribute("pager", pager);
		return "course/index";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public String list(Pager pager, Model model) {
		List<Course> courses = this.courseService.list(pager, "organId", userPreferences.getOrganId());
		pager.calcPageths();
		model.addAttribute("courses",courses);
		model.addAttribute("pager", pager);
		return "course/list";
	}
	
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String view(Model model, Long id) {
		Course course = this.courseService.get(id);
		model.addAttribute("course", course);
		return "course/view";
	}
	
	@RequestMapping(value="/admin", method = RequestMethod.GET)
	public String admin(Model model) {
		Pager pager = new Pager();
		pager.setSort("createTime");
		pager.setDir("desc");
		pager.calcPageCount(this.courseService.countAll());
		List<Course> courses = this.courseService.list(pager, "organId", userPreferences.getOrganId());
		model.addAttribute("courses", courses);
		model.addAttribute("pager", pager);
		return "course/admin/index";
	}
	
	@RequestMapping(value = "/admin/list", method = RequestMethod.POST)
	public String adminList(Pager pager, Model model) {
		List<Course> courses = this.courseService.list(pager, "organId", userPreferences.getOrganId());
		pager.calcPageths();
		model.addAttribute("courses",courses);
		model.addAttribute("pager", pager);
		return "course/admin/list";
	}
	
	/**
	 * 删除课程
	 * @param model
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/admin/delete", method = RequestMethod.POST)
	public boolean delete(Model model, Long id) {
		this.courseService.deleteById(id);
		if (this.courseService.exists(id)) {
			return false;
		} else {
			return true;
		}
	}
	
	/**
	 * 返回组织学习课程内容修改界面
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/admin/modify", method = RequestMethod.GET)
	public String modify(Model model, Long id) {
		Course course = this.courseService.get(id);
		model.addAttribute("course", course);
		return add(model);
	}
	
	/**
	 * 处理组织学习课程内容修改请求
	 * @param model
	 * @param course
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/admin/modify", method = RequestMethod.POST)
	public String modifyAction(Model model, @ModelAttribute("course") @Valid Course course, BindingResult result) {
		if (result.hasErrors()) {
			model.addAttribute("course", course);
		} else {
			this.courseService.update(course);
		}
		return "redirect:/course/admin";
	}
	
	/**
	 * 系统管理界面添加课程界面
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/admin/add", method = RequestMethod.GET)
	public String add(Model model) {
		if (!model.containsAttribute("course" )) {
			model.addAttribute("course", new Course());
		}
		return "course/admin/add";
	}
	
	/**
	 * 处理系统管理界面添加课程的请求
	 * @param model
	 * @param course
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/admin/add", method = RequestMethod.POST)
	public String addAction(Model model, @ModelAttribute("course") @Valid Course course, BindingResult result, HttpServletRequest request) {
		if (result.hasErrors()) {
			model.addAttribute("course", course);
			return add(model);
		} else if (this.courseService.checkTitleUnqiue(course.getTitle())) {	//检查标题是否重复
			result.rejectValue("title", null, "标题已经重复！");
			model.addAttribute("course", course);
			return add(model);
		} else {
			course.setCreateTime(new Date());
			course.setCreateUserId(userPreferences.getUserId());
			course.setUsername(userPreferences.getUserName());
			course.setOrganId(userPreferences.getOrganId());
			this.courseService.save(course);
		}
		return "redirect:/course/admin?platformId=" + request.getSession().getAttribute("platformId");
	}
}

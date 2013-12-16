package com.dw.party.util;

/**
 * Page Util
 * @author xingkong1221
 *
 */
public class PageUtil {
	
	/**
	 * 根据页码和每一页的个数获取从那一条记录开始
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	public static int getStartIndex(int pageNumber, int pageSize) {
		return (pageNumber -1) * pageSize;
	}
	
	/**
	 * 获取一共多少页
	 * @param totalNumber
	 * @param pageSize
	 * @return
	 */
	public static int getPageCount(int totalNumber, int pageSize) {
		if (totalNumber > 1) {
			int count = totalNumber / pageSize;
			return (totalNumber % pageSize == 0) ? count : ++count;
		}
		return 1;
	}
}

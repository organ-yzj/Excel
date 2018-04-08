package com.iss.cnaf.manager.sys.model;
/**
 * 
 * ClassName:QueryParam
 *
 * @author   李丛阳
 * @version  
 * @since    Ver 1.1
 * @Date	 2015	2015年7月16日		上午9:46:48
 *
 * @see
 */
public class QueryParam {
	/*using in paged*/
	
	private Integer rows = 5,page =null;
	
	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}
	
	public Integer getStartPoint(){
		return (page-1)*rows;
	}
}

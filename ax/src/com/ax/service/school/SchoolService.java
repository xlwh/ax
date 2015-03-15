/*
 * Title:        爱学圈服务器 2015年2月2日
 * Description:  [描述模块的功能、作用、使用方法和注意事项]
 * Copyright:    Copyright (c) 2015
 * Company:      爱学圈
 * @author       张洪斌
 * @version      1.0  2015年2月2日
 */
package com.ax.service.school;

import java.util.List;

import com.ax.bean.School;
import com.ax.exception.DaoException;

/**
 *学校相关的业务逻辑接口
 * @author       张洪斌  1079039435@qq.com
 * @see          [相关类,可选,也可多条,对于重要的类或接口建议注释]
 * @since        爱学圈服务器, 2015年2月2日
 */
public interface SchoolService {
	public List<School> getAll() throws DaoException;
}

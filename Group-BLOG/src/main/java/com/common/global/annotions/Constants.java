package com.common.global.annotions;
/**
 * 全局变量声明类
 * @author Administrator
 *
 */
public class Constants {
  /**
   * 加密盐值
   */
	public static final String SALT=""; 
	/**
	 * 加密hash迭代次数
	 */
	public static final int HASH_iTERATIONS=2; 
	/**
	 * 重定向全局路径
	 */
	 public static final String REDIRECT_ROOT_PATH="http://ip:8080/";	
	/**
	 * 项目名
	 */
	 public static final String ROOT_NAME="Group-BLOG";
	 /**
	 * 每页显示多少条记录
	 */
	 public static final int EVERY_PAGE=5;
	/**
	 * 邮箱验证码提示信息
	 */
	public static final String EMAIL_MSG_TITLE="如非本人操作，请忽略.验证码:"; 
	/**
	 * 游客权限状态值
	 */
	public static final int AUTHORITY_VISITOR=1;
	/**
	 * 普通用户权限状态值
	 */
	public static final int AUTHORITY_USER=2;
	/**
	 * 管理员权限状态值
	 */
	public static final int AUTHORITY_ADMIN=3;
	/**
	 * 登录的session键值
	 */
	public static final String SESSION_FORCE_LOGOUT_KEY = "session.force.logout";
	/**
	 * 普通帖
	 */
	public static final int STATUS_COMMON = 0;
	/**
	 * 置顶帖
	 */
	public static final int STATUS_TOP = 1;
	
	/**
	 * 精品帖
	 */
	public static final int STATUS_HOT = 2;
	
	/**
	 * 置顶且加精品
	 */
	public static final int STATUS_TOP_HOT = 3;
	/**
	 * 吧主用户名
	 */
	public static final String MASTER_NAME = "少了一次秒西";
	/**
	 * 置顶且加精品
	 */
	public static final int HOT_BLOG_COUNT = 300;
	/**
	 * 日志每页显示多少条记录
	 */
	 public static final int LOGGER_PAGE=10;
	 
	 /**
	  * fastDFS远程服务器ip
	  */
	 public static final String BASE_URL="http://ip/";
	 /**
	  * 默认头像图片
	  */
	 public static final String DEFAULT_HEAD_IMG="http://www.slycmiaoxi.xyz/Group-BLOG/Static/img/none.gif";
	/**
	 * 本地服务器上传路径
	 */
	 public static final String UPLOAD_PATH="http://www.slycmiaoxi.xyz/Group-BLOG";
	 /**
	  * es文章类型名
	  */
		public static final String BLOG_SEARCH = "blogSearch";
		/**
		 * 
		 */
		public static final int ES_MAX_PAGE = 10;
}

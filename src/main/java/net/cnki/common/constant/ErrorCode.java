package net.cnki.common.constant;

/**
 * @Author: tianjl
 * @Date: 2020/10/15 13:14
 * @Eamil: 2695062879@qq.com
 */
public class ErrorCode {

    /**
     * 请求体不存在
     */
    public static final String NOT_BODY_HTTP = "not_body_http";
    /**
     * 修改失败
     */
    public static final String FAIL_MODIFY = "fail_modify";
    /**
     * 链路调用异常
     */
    public static final String ERROR_ROOTER_EXECUTE = "error_router_execute";
    /**
     * 系统异常
     */
    public static final String SYSTEM_ERROR = "system_error";
    /**
     * 机构已经存在了，不能重复申请
     */
    public static final String ORG_IS_NOT_EXISIT = "org_is_not_exisit";
    /**
     * 没有转化完毕的文档
     */
    public static final String NO_CONVERT_COMPLATE = "no_convert_complate";

    /**
     *  w文件不存在
     */
    public static final String NO_FILE_EXISIT = "no_file_exisit";

    /**
     * 积分不够了
     */
    public static final String ERROR_CODE_NO_MACH_POINT = "error_code_no_mach_point";
    /**
     * 不支持的方法
     */
    public static String NOT_SUPPORT_HTTP_METHOD="not_support_http_method";

    /**
     * 不支持的方法
     */
    public static String NO_LOGIN_USER="exception.sso.not-login";
}

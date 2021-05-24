package net.cnki.common.exception;

import lombok.extern.log4j.Log4j2;
import net.cnki.common.constant.ErrorCode;
import net.cnki.service.i18n.I18nService;
import net.cnki.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;
import java.util.List;


/**
 * 统一的异常处理
 *
 * @author tianjl
 */
@Log4j2
@RestControllerAdvice
public class AjaxExceptionHandle {



    /**
     * 国际化
     */
    @Autowired
    private I18nService i18nService;

    /**
     * 处理多重异常配置
     * @param e
     * @param response
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public ResponseResult errorHandler(Exception e, HttpServletResponse response) {
        ResponseResult resultDTO;
        /**
         * 打印一下日志，方便查bug
         */
        e.printStackTrace();
        if (e instanceof CustomException) {
            e.printStackTrace();
            CustomException exception = (CustomException) e;
            resultDTO = ResponseResult.error(i18nService.getMessage(((CustomException) e).getPromptMsg()));
        } else if (e instanceof HttpRequestMethodNotSupportedException) {
            resultDTO = ResponseResult.error(i18nService.getMessage(ErrorCode.NOT_SUPPORT_HTTP_METHOD));
        } else if (e instanceof HttpMessageNotReadableException) {
            resultDTO = ResponseResult.error(i18nService.getMessage(ErrorCode.NOT_BODY_HTTP));
        } else if (e instanceof MethodArgumentNotValidException) {
            List<ObjectError> errorList = ((MethodArgumentNotValidException) e).getBindingResult().getAllErrors();
            resultDTO = getAutoException(errorList);
        } else if (e instanceof BindException) {
            List<ObjectError> errorList = ((BindException) e).getBindingResult().getAllErrors();
            resultDTO = getAutoException(errorList);
        } else {
            resultDTO = ResponseResult.error("未知错误！");
        }
        //异常信息写入日志文件
        return resultDTO;
    }

    /**
     * 注解报错
     *
     * @param errorList 报错列表
     * @return 返回第一个报错
     */
    private ResponseResult getAutoException(List<ObjectError> errorList) {
        String error = "";
        for (ObjectError objectError : errorList) {
            error = objectError.getDefaultMessage();
        }
        return ResponseResult.error(error);
    }

}

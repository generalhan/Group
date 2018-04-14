package com.common.exception;
import java.util.Date;

import javax.servlet.ServletException;

import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException;

/**
 * Ĭ��ȫ���쳣������
 * @author zwl
 *
 */

@ControllerAdvice 
public class DefaultExceptionHandler {
    
	private Logger logger = (Logger) LoggerFactory.getLogger(this.getClass().getName());
	
	/**
	 * û��Ȩ���쳣
	 * @param request
	 * @param e
	 * @return
	 */
    @ExceptionHandler({UnauthorizedException.class}) 
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public String processUnauthenticatedException(NativeWebRequest request, UnauthorizedException e) {
 
    	try {
			
		} catch (UnauthorizedException e2) {
			logger.error("����һ����Ȩ�޵�¼�쳣 :"+new Date().toLocaleString());
		}     	
        return "unauthorized";
}
    /**
     * 500�������쳣
     * @param ex
     * @return
     */
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)  
    public String handleUnexpectedServerError(RuntimeException ex) { 
    	try {
			
		} catch (Exception e) {
			logger.error("ϵͳ�����������쳣���뼰ʱ����^_^");
		}   	
        return null;
    }
    
    /**
     * 404�쳣
     * @return
     */
    
    @ExceptionHandler(ServletException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)  
    public String handleNotFoundError() {   	
           try {
			
		} catch (Exception e) {
			logger.error("������˼~����һ��ҳ���Ѷ���^_^");
		}
           
          return null;       
    }
}

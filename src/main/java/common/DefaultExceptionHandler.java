package common;
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
 * 默认全局异常处理类
 *
 *
 */

@ControllerAdvice
public class DefaultExceptionHandler {

    private Logger logger = (Logger) LoggerFactory.getLogger(this.getClass().getName());


    /**
     * 500运行期异常
     * @param ex
     * @return
     */
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleUnexpectedServerError(RuntimeException ex) {
        try {

        } catch (Exception e) {
            logger.debug("系统出现运行期异常，请及时处理^_^");
        }
        return null;
    }

    /**
     * 404异常
     * @return
     */

    @ExceptionHandler(ServletException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public String handleNotFoundError() {
        try {

        } catch (Exception e) {
            logger.info("不好意思~，有一个页面已丢了^_^");
        }

        return null;
    }
}
package com.mellon.platform.util;

import com.alibaba.dubbo.rpc.RpcException;
import com.mellon.common.domain.result.Result;
import com.mellon.common.util.JsonMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * 〈异常拦截器，在应用xml中声明可用〉<br>
 * 〈异常拦截器在controller发生异常而未及返回视图时会拦截。由它接管并返回视图。 这个实现依赖具体的异常类，根据具体的异常类不同而返回不同的视图〉
 *
 */
public class HandlerExceptionResolver implements org.springframework.web.servlet.HandlerExceptionResolver {

	private static final Logger LOG = LoggerFactory.getLogger(HandlerExceptionResolver.class);

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response,
			Object handler, Exception ex) {
		response.setContentType("application/json;charset=UTF-8");
		Result result = new Result();
		result.setSuccess(false);
		String message = ex.getMessage() == null ? "" : ex.getMessage();
		Throwable throwable = ex.getCause();
		if (throwable instanceof ConstraintViolationException) {
			ConstraintViolationException constraintViolationException = (ConstraintViolationException) throwable;
			Iterator<ConstraintViolation<?>> it = constraintViolationException
					.getConstraintViolations().iterator();
			List<String> validationMessages = new ArrayList<String>();
			while (it.hasNext()) {
				validationMessages.add(it.next().getMessage());
			}
			result.setValidationMessages(validationMessages);
		}
		if (ex instanceof DataAccessException) {
			result.setMessage(message);
		} else if (ex instanceof ValidationException) {
			result.setMessage(message);
		} else if (ex instanceof RpcException) {
			result.setMessage(message);
		}
		// 自定义异常
		else if (ex instanceof UnsupportedOperationException) {
			result.setSuccess(true);
			result.setValid(false);
			int index = message.indexOf("~");
			if (index != -1) {
				String msg = message.substring(0, index);
				String code = message.substring(index + 1, message.length());
				result.setMessage(msg);
				result.setResultCode(code);
			} else {
				result.setMessage(message);
			}
		} else if (ex instanceof IllegalArgumentException) {// spring 断言异常
			result.setSuccess(true);
			result.setValid(false);
			result.setMessage(message);
		} else if (ex instanceof NullPointerException) {// spring 断言异常
			result.setSuccess(true);
			result.setValid(false);
			result.setMessage(message);
		} else if (ex instanceof RuntimeException) {
			result.setMessage(message);
		} else if (ex instanceof Exception) {
			result.setMessage(message);
		} else {
			result.setMessage(message);
		}
		try (PrintWriter writer = response.getWriter()) {
			writer.write(JsonMapper.nonEmptyMapper().toJson(result));
			writer.flush();
			writer.close();
		} catch (IOException e) {
			LOG.error("" + e, e);
		}
		LOG.error("" + throwable, throwable);
		return null;
	}

}

package com.mellon.common.domain.result;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.mellon.common.domain.vo.PageInfo;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

/**
 *
 * Class {@code Result<T>} is the root of the standard result hierarchy.
 *
 * @author mellon
 * @version 1.0
 */
public class Result<T> implements Serializable {

	public Result() {
		this.success = true;
		this.isValid = true;
	}

	/**
	 * the flag of transaction or operation
	 */
	private boolean success;
	/**
	 * the returning code of transaction or operation
	 */
	private String resultCode;
	/**
	 * the returning message of transaction or operation
	 */
	private String message;
	/**
	 * single model
	 */
	private T model;
	/**
	 * multi models
	 */
	private List<T> models;
	/**
	 * paging info
	 */
	private PageInfo<T> paging;

	/**
	 * extra info
	 */
	private Object extra;

	/**
	 */
	private boolean isValid;

	/**
	 */
	private List<String> validationMessages;

	public List<String> getValidationMessages() {
		return validationMessages;
	}

	public void setValidationMessages(List<String> validationMessages) {
		this.validationMessages = validationMessages;
	}

	// @JsonIgnore
	public void setValidationErrorMessages(BindingResult errors) {
		List<String> errorMessages = new ArrayList<String>();
		Iterator<FieldError> iter = errors.getFieldErrors().iterator();
		while (iter.hasNext()) {
			errorMessages.add(iter.next().getDefaultMessage());
		}
		this.setValidationMessages(errorMessages);
	}

	public boolean isValid() {
		return isValid;
	}

	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getModel() {
		return model;
	}

	public void setModel(T model) {
		this.model = model;
	}

	public List<T> getModels() {
		if (null != this.models) {
			return models;
		} else {
			return new ArrayList<T>();
		}
	}

	public void setModels(List<T> models) {
		this.models = models;
	}

	public PageInfo<T> getPaging() {
		return paging;
	}

	public void setPaging(PageInfo<T> paging) {
		this.paging = paging;
	}

	public Object getExtra() {
		return extra;
	}

	public void setExtra(Object extra) {
		this.extra = extra;
	}
}

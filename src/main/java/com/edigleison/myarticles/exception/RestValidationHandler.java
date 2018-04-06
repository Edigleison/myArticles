package com.edigleison.myarticles.exception;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.edigleison.myarticles.exception.FieldValidationError.MessageType;

@ControllerAdvice
public class RestValidationHandler {
	
	private MessageSource messageSource;

	@Autowired
	public RestValidationHandler(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ResponseEntity<FieldValidationErrorDetails> handleValidationError(
			MethodArgumentNotValidException notValidException, HttpServletRequest request) {

		FieldValidationErrorDetails errorDetails = new FieldValidationErrorDetails();
		errorDetails.setErroTimesTamp(Calendar.getInstance().getTime().getTime());
		errorDetails.setErroStatus(HttpStatus.BAD_REQUEST.value());
		errorDetails.setErroTitle("Field Validation Error");
		errorDetails.setErroDeveloperMessage(MethodArgumentNotValidException.class.getName());
		errorDetails.setErroPath(request.getRequestURI());
		
		for(FieldError fieldError : notValidException.getBindingResult().getFieldErrors()) {
			List<FieldValidationError> fValidationErrorsList = errorDetails.getErrors().get(fieldError.getField());
			if(fValidationErrorsList == null) {
				fValidationErrorsList = new ArrayList<>();
				errorDetails.getErrors().put(fieldError.getField(), fValidationErrorsList);
			}
			FieldValidationError fieldValidationError = processFieldError(fieldError);
			fValidationErrorsList.add(fieldValidationError);
		}
		
		return new ResponseEntity<FieldValidationErrorDetails>(errorDetails, HttpStatus.BAD_REQUEST);		
	}

	private FieldValidationError processFieldError(final FieldError fieldError) {
		final Locale locale = LocaleContextHolder.getLocale();
		final String message = messageSource.getMessage(fieldError.getDefaultMessage(), null, locale);	
		
		final FieldValidationError fieldValidationError = new FieldValidationError();
		fieldValidationError.setField(fieldError.getField());
		fieldValidationError.setMessage(message);
		fieldValidationError.setType(MessageType.ERROR);
		
		return fieldValidationError;
	}

}

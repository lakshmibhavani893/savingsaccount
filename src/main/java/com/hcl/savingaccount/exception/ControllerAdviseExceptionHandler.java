package com.hcl.savingaccount.exception;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class ControllerAdviseExceptionHandler extends ResponseEntityExceptionHandler {
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		Map<String, Object> body = new LinkedHashMap<>();
		body.put("timestamp", LocalDate.now());
		body.put("status", status.value());

		List<String> FeildErrors = ex.getBindingResult().getFieldErrors().stream().map(x -> x.getField())
				.collect(Collectors.toList());

		List<String> errors = ex.getBindingResult().getFieldErrors().stream().map(x -> x.getDefaultMessage())
				.collect(Collectors.toList());
		body.put("FeildErrors", FeildErrors);
		body.put("errors", errors);

		return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
	}
		
	
	
	@ExceptionHandler(value = CustomerNotFoundException.class)
	public ResponseEntity<Object> exception(CustomerNotFoundException exception) {
		return new ResponseEntity<>("customer not found", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = InvalidNameException.class)
	public ResponseEntity<Object> exception(InvalidNameException exception) {
		return new ResponseEntity<>("Invalid Name, You must Enter only alphabets ", HttpStatus.NOT_ACCEPTABLE);
	}
	@ExceptionHandler(value = InvalidDateOfBirthException.class)
	public ResponseEntity<Object> exception(InvalidDateOfBirthException exception) {
		return new ResponseEntity<>("You must enter past date ", HttpStatus.NOT_ACCEPTABLE);
	}
	@ExceptionHandler(value = InsufficientFundsException.class)
	public ResponseEntity<Object> exception(InsufficientFundsException exception) {
		return new ResponseEntity<>("Insufficient funds to transfer", HttpStatus.NOT_ACCEPTABLE);
	}
	@ExceptionHandler(value = InvalidBeneficiaryException.class)
	public ResponseEntity<Object> exception(InvalidBeneficiaryException exception) {
		return new ResponseEntity<>("Invalid Beneficiary account", HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value = InvalidAccountNumberException.class)
	public ResponseEntity<Object> exception(InvalidAccountNumberException exception) {
		return new ResponseEntity<>("you can't transfer to same account", HttpStatus.NOT_ACCEPTABLE);
	}
	@ExceptionHandler(value = AccountNotFoundException.class)
	public ResponseEntity<Object> exception(AccountNotFoundException exception) {
		return new ResponseEntity<>("account not found", HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value = BeneficiaryNotFoundException.class)
	public ResponseEntity<Object> exception(BeneficiaryNotFoundException exception) {
		return new ResponseEntity<>("beneficiary not found", HttpStatus.NOT_FOUND);
	}
	

}

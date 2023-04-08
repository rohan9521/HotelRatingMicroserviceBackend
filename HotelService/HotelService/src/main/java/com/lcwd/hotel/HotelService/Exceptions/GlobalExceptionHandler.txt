@RestControllerAdvice
public class GlobalExceptionHandler{
	
@ExceptionHandler(ResourceHandlerException.class)
public ResponseEntity<ApiResponse> handlerResourceNotFoundException(ResourceNotFoundException resourceNotFoundException){
		String message = resourceNotFoundException.message();
		ApiResponse response = ApiResponseBuilder().message(message).success(true).status(HttpStatus.NOT_FOUND).build();
	return new ResponseEntity<ApiResponse>(response,Http.NOT_FOUND);
}
}
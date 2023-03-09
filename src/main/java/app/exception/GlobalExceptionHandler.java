package app.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler
{
    @ExceptionHandler(value={EntityNotFoundException.class})
    @ResponseStatus(value=HttpStatus.NOT_FOUND)
    public ExceptionResponse entityNotFoundExceptionHandler()
    {
        return new ExceptionResponse("No Record Found by this id");
    }
}
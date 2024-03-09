package com.rum.ksc_back.KSCException;

import com.rum.ksc_back.Config.Request;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
@ControllerAdvice
@ResponseBody
@Controller
public class ExceptionHandle {
    @ExceptionHandler(ApiException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public final Request handleAllExceptions(ApiException ex) {
        return new Request(ex.errorCode,ex.errorMessage);
    }
}

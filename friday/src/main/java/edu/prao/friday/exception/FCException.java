package edu.prao.friday.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FCException extends Exception{

    private String code;
    private String message;
}

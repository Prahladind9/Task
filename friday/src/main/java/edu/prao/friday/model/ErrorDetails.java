package edu.prao.friday.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
@Builder
@ApiModel(description = "Response model for error returned")
public class ErrorDetails {

    @ApiModelProperty(notes = "timestamp at which the error occurred")
    private Date timeStamp;

    @ApiModelProperty(notes = "error message")
    private String message;

    @ApiModelProperty(notes = "Details of the error message")
    private String details;

}
package edu.prao.friday.controller;

import edu.prao.friday.apispec.AddressAPISpec;
import edu.prao.friday.exception.FCException;
import edu.prao.friday.model.AddressRequest;
import edu.prao.friday.model.AddressResponse;
import edu.prao.friday.service.AddressParserService;
import io.micrometer.core.annotation.Timed;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;

@RestController
@AllArgsConstructor
@Tag(name = "Friday", description = "Friday Challenge to parse concatenated address to separate fields for street name and street number.")
@RequestMapping("v1")
public class AddressController implements AddressAPISpec {

    private AddressParserService addressParserService;

    @Timed(value="parseAddress", description = "For given address, time taken to parse the address")
    @Override
    public ResponseEntity<AddressResponse> parseAddress(@RequestBody @NotBlank AddressRequest address) throws FCException {
        return ResponseEntity.status(HttpStatus.OK)
                .body(addressParserService.parseAddress(address));
    }


}

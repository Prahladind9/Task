package edu.prao.friday.apispec;

import edu.prao.friday.exception.FCException;
import edu.prao.friday.model.AddressRequest;
import edu.prao.friday.model.AddressResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface AddressAPISpec {

    @Operation(summary = "${api.parseAddress.post_address.description}")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "${api.responseCodes.ok.description}"),
                    @ApiResponse(
                            responseCode = "400",
                            description = "${api.responseCodes.badRequest.description}"),
            })
    @PostMapping("parseAddress")
    ResponseEntity<AddressResponse> parseAddress(@RequestBody AddressRequest address) throws FCException;
}

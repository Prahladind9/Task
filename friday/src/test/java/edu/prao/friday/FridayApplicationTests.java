package edu.prao.friday;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.prao.friday.exception.FCException;
import edu.prao.friday.model.AddressRequest;
import edu.prao.friday.model.AddressResponse;
import edu.prao.friday.service.AddressParserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.objectweb.asm.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
@SpringBootTest
class FridayApplicationTests {

    @Autowired
    private AddressParserService addressParserService;
    @Autowired
    Jackson2ObjectMapperBuilder mapperBuilder;

    @Test
    public void runSampleTests() throws FCException, IOException {
        for (int i = 1; i <= 9; i++) {
            runSampleTests(i);
        }
    }

    public void runSampleTests(int i) throws FCException, IOException {
        AddressRequest addressRequest = getAddressRequest("/parseRequest" + i + ".json");
        log.info("addressRequest:{}", addressRequest);
        AddressResponse actualResponse = addressParserService.parseAddress(addressRequest);
        AddressResponse expectedResponse = getParsedAddressResponse("/parsedResponse" + i + ".json");
        log.info("actualResponse:{}", actualResponse);
        log.info("expectedResponse:{}", expectedResponse);
        assertTrue(actualResponse.equals(expectedResponse));
    }

    private AddressRequest getAddressRequest(String path) throws IOException {
        ObjectMapper mapper = mapperBuilder.build();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        return mapper.readValue(TypeReference.class.getResourceAsStream(path), AddressRequest.class);
    }

    private AddressResponse getParsedAddressResponse(String path) throws IOException {
        ObjectMapper mapper = mapperBuilder.build();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        return mapper.readValue(TypeReference.class.getResourceAsStream(path), AddressResponse.class);
    }
}

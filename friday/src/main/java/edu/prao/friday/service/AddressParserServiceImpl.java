package edu.prao.friday.service;

import edu.prao.friday.exception.FCException;
import edu.prao.friday.model.AddressRequest;
import edu.prao.friday.model.AddressResponse;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;

import static edu.prao.friday.config.FCConstants.*;

@Service
public class AddressParserServiceImpl implements AddressParserService{
    @Override
    public AddressResponse parseAddress(AddressRequest address) throws FCException {
        if(isValid(address)) throw new FCException(BAD_REQUEST_FOR_ADDRESS, BAD_REQUEST_FOR_ADDRESS_MSG);

        for (AddressParserHelper addressParserHelper : AddressParserHelper.values()) {
            Matcher matcher = addressParserHelper.regexInfo.getPattern().matcher(address.getAddress());
            if (matcher.matches()) {
                String streetName = matcher.group(addressParserHelper.regexInfo.getStreetGroup()).strip();
                String houseNumber = matcher.group(addressParserHelper.regexInfo.getStreetNumberGroup()).strip();
                return AddressResponse.builder().street(streetName).housenumber(houseNumber).build();
            }
        }
        throw new FCException(ADDRESS_FORMAT_NOT_FOUND, ADDRESS_FORMAT_NOT_FOUND_MSG);
    }
}

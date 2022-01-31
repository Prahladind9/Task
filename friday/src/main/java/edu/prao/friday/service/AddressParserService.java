package edu.prao.friday.service;

import edu.prao.friday.exception.FCException;
import edu.prao.friday.model.AddressRequest;
import edu.prao.friday.model.AddressResponse;

public interface AddressParserService {
    AddressResponse parseAddress(AddressRequest address) throws FCException;

    default boolean isValid(AddressRequest address) {
        return address == null || address.getAddress() == null || address.getAddress().trim().length() == 0;
    }
}

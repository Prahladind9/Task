package edu.prao.friday.model;

import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressResponse implements Serializable {
    private String street;
    private String housenumber;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressResponse that = (AddressResponse) o;
        return Objects.equals(street, that.street) && Objects.equals(housenumber, that.housenumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(street, housenumber);
    }
}

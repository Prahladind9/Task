package edu.prao.friday.service;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.regex.Pattern;

/**
 * Application yml file read - fails due to special character's
 */
public enum AddressParserHelper {
    GERMAN(
            new RegexInfo(
                    Pattern.compile("^(([A-zäÄüÜÖö]*\\s)*)([0-9]*\\s?[A-z]*)$"),
                    1, 3
            )),

    FRENCH(
            new RegexInfo(
                    Pattern.compile("^([0-9]*)(,?)\\s(([A-z]*\\s*)*)"),
                    3, 1
            )
    ),

    SPANISH(
            new RegexInfo(
                    Pattern.compile("^(([A-z]|\\s)*([0-9]*\\s)*)(,\\s)?((No\\s)?([0-9]*\\s?)[A-z]*)$"),
                    1, 5
            )
    );


    public final RegexInfo regexInfo;

    AddressParserHelper(RegexInfo regexInfo) {
        this.regexInfo = regexInfo;
    }

    /**
     *  Container class that contains the regex pattern as well as information on
     *  which group of the matched pattern corresponds to street name and street
     *  number, should a match occur.
     */
    @Data
    @AllArgsConstructor
    public static class RegexInfo {
        private Pattern pattern;
        private int streetGroup;
        private int streetNumberGroup;
    }

}

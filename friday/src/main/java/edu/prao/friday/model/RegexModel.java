package edu.prao.friday.model;

import lombok.Data;

import java.util.regex.Pattern;

@Data
public class RegexModel {
    private Pattern pattern;
    private int streetGroup;
    private int streetNumberGroup;

    public RegexModel(String pattern, int streetGroup, int streetNumberGroup) {
        this.pattern = Pattern.compile(pattern);
        this.streetGroup = streetGroup;
        this.streetNumberGroup = streetNumberGroup;
    }
}

package org.nameapi.client.services.parser.personnameparser;

/**
 */
public class ParsedPersonMatch {

    private final ParsedPerson parsedPerson;
    private final double likeliness;
    private final double confidence;

    public ParsedPersonMatch(ParsedPerson parsedPerson, double likeliness, double confidence) {
        this.parsedPerson = parsedPerson;
        this.likeliness = likeliness;
        this.confidence = confidence;
    }


    public ParsedPerson getParsedPerson() {
        return parsedPerson;
    }

    public double getLikeliness() {
        return likeliness;
    }

    public double getConfidence() {
        return confidence;
    }
}

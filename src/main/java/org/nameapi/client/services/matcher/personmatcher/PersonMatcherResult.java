package org.nameapi.client.services.matcher.personmatcher;

import org.jetbrains.annotations.NotNull;

/**
 */
public class PersonMatcherResult {

    @NotNull
    private final PersonMatchType matchType;

    @NotNull
    private final PersonMatchComposition personMatchComposition;

    private final double points;

    private final double confidence;


    @NotNull
    private final PersonNameMatcherResult personNameMatcherResult;

    @NotNull
    private final GenderMatcherResult genderMatcherResult;

    @NotNull
    private final AgeMatcherResult ageMatcherResult;


    public PersonMatcherResult(@NotNull PersonMatchType matchType, @NotNull PersonMatchComposition personMatchComposition, double points, double confidence, @NotNull PersonNameMatcherResult personNameMatcherResult, @NotNull GenderMatcherResult genderMatcherResult, @NotNull AgeMatcherResult ageMatcherResult) {
        this.matchType = matchType;
        this.personMatchComposition = personMatchComposition;
        this.points = points;
        this.confidence = confidence;
        this.personNameMatcherResult = personNameMatcherResult;
        this.genderMatcherResult = genderMatcherResult;
        this.ageMatcherResult = ageMatcherResult;
    }

    @NotNull
    public PersonMatchType getMatchType() {
        return matchType;
    }

    @NotNull
    public PersonMatchComposition getPersonMatchComposition() {
        return personMatchComposition;
    }

    public double getPoints() {
        return points;
    }

    public double getConfidence() {
        return confidence;
    }

    @NotNull
    public PersonNameMatcherResult getPersonNameMatcherResult() {
        return personNameMatcherResult;
    }

    @NotNull
    public GenderMatcherResult getGenderMatcherResult() {
        return genderMatcherResult;
    }

    @NotNull
    public AgeMatcherResult getAgeMatcherResult() {
        return ageMatcherResult;
    }
}

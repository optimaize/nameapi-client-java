package org.nameapi.client.services.email.emailnameparser;

import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * One successful way of parsing a name out of an email address.
 */
public interface EmailNameParserMatch {

    /**
     * @return 0-n, 0 in case the name did not contain any given name.
     */
    @NotNull
    List<NameFromEmailAddress> getGivenNames();

    /**
     * @return 0-n, 0 in case the name did not contain any surname.
     */
    @NotNull
    List<NameFromEmailAddress> getSurnames();

    /**
     * @return 0-1 where 1 is the best.
     */
    double getConfidence();

}

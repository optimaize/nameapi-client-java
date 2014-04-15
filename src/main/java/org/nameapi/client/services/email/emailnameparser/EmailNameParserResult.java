package org.nameapi.client.services.email.emailnameparser;

import com.google.common.base.Optional;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 */
public interface EmailNameParserResult {

    @NotNull
    EmailAddressParsingResultType getResultType();

    @NotNull
    Optional<EmailNameParserMatch> getBestNameMatch();

    /**
     * The first entry (if any) is the best, they are ordered by likeliness in descending order.
     */
    @NotNull
    List<EmailNameParserMatch> getNameMatches();

}

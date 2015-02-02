package org.nameapi.client.services.email.emailnameparser2;

import com.google.common.base.Optional;
import org.jetbrains.annotations.NotNull;
import org.nameapi.client.services.email.emailnameparser.EmailAddressParsingResultType;
import org.nameapi.client.services.email.emailnameparser.EmailNameParserMatch;

import java.util.List;

/**
 */
public interface EmailNameParser2Result {

    @NotNull
    EmailAddressParsingResultType2 getResultType();

    @NotNull
    Optional<EmailNameParserMatch> getBestNameMatch();

    /**
     * The first entry (if any) is the best, they are ordered by likeliness in descending order.
     */
    @NotNull
    List<EmailNameParserMatch> getNameMatches();

}

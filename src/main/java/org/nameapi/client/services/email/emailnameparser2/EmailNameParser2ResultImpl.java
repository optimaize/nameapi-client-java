package org.nameapi.client.services.email.emailnameparser2;

import com.google.common.base.Optional;
import crema.annotation.Immutable;
import org.jetbrains.annotations.NotNull;
import org.nameapi.client.services.email.emailnameparser.EmailNameParserMatch;

import java.util.Collections;
import java.util.List;

/**
 */
@Immutable
class EmailNameParser2ResultImpl implements EmailNameParser2Result {

    @NotNull
    private final EmailAddressParsingResultType2 resultType;
    @NotNull
    private final List<EmailNameParserMatch> matches;

    EmailNameParser2ResultImpl(@NotNull EmailAddressParsingResultType2 resultType, @NotNull List<EmailNameParserMatch> matches) {
        this.resultType = resultType;
        this.matches    = Collections.unmodifiableList(matches);
    }


    @Override @NotNull
    public EmailAddressParsingResultType2 getResultType() {
        return resultType;
    }

    @NotNull @Override
    public Optional<EmailNameParserMatch> getBestNameMatch() {
        if (matches.isEmpty()) return Optional.absent();
        return Optional.of(matches.get(0));
    }

    @NotNull @Override
    public List<EmailNameParserMatch> getNameMatches() {
        return matches;
    }

    @Override @NotNull
    public String toString() {
        return getResultType() + ": "+matches;
    }

}

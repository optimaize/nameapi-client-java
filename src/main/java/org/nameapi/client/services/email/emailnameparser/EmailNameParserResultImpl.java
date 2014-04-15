package org.nameapi.client.services.email.emailnameparser;

import com.google.common.base.Optional;
import crema.annotation.Immutable;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;

/**
 */
@Immutable
class EmailNameParserResultImpl implements EmailNameParserResult {

    @NotNull
    private final EmailAddressParsingResultType resultType;
    @NotNull
    private final List<EmailNameParserMatch> matches;

    EmailNameParserResultImpl(@NotNull EmailAddressParsingResultType resultType, @NotNull List<EmailNameParserMatch> matches) {
        this.resultType = resultType;
        this.matches    = Collections.unmodifiableList(matches);
    }


    @Override @NotNull
    public EmailAddressParsingResultType getResultType() {
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

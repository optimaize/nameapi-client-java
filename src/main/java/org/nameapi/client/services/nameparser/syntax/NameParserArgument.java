package org.nameapi.client.services.nameparser.syntax;

import crema.annotation.Immutable;
import crema.lang.Preconditions;
import org.jetbrains.annotations.NotNull;
import org.nameapi.client.services.nameparser.Conversion;
import org.nameapi.client.services.nameparser.wsdl.SoapNameParserRule;

import java.util.List;

/**
 * The input for the {@link SyntaxBasedNameParserCommand}.
 */
@Immutable
public class NameParserArgument {

    @NotNull
    private final String nameString;
    @NotNull
    private final List<SoapNameParserRule> rules;

    public NameParserArgument(@NotNull String nameString, @NotNull List<NameParserRule> rules) {
        Preconditions.notNullAndNotEmpty(nameString, "nameString");
        if (rules.isEmpty()) throw new IllegalArgumentException("At least one rule is mandatory!");
        this.nameString = nameString;
        this.rules  = Conversion.convertRules(rules);
    }

    @NotNull
    public String getNameString() {
        return nameString;
    }

    @NotNull
    public List<SoapNameParserRule> getRules() {
        return rules;
    }
}

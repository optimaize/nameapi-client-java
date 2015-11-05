package org.nameapi.client.services.nameparser.syntax;

import cremacopy.annotation.Immutable;
import cremacopy.lang.Preconditions;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * The input for the {@link SyntaxBasedNameParserCommand}.
 */
@Immutable
public class NameParserArgument {

    @NotNull
    private final String nameString;
    @NotNull
    private final List<NameParserRule> rules;

    public NameParserArgument(@NotNull String nameString, @NotNull List<NameParserRule> rules) {
        Preconditions.notNullAndNotEmpty(nameString, "nameString");
        if (rules.isEmpty()) throw new IllegalArgumentException("At least one rule is mandatory!");
        this.nameString = nameString;
        this.rules  = rules;
    }

    @NotNull
    public String getNameString() {
        return nameString;
    }

    @NotNull
    public List<NameParserRule> getRules() {
        return rules;
    }
}

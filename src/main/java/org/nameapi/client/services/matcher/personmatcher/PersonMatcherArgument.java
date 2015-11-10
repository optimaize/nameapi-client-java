package org.nameapi.client.services.matcher.personmatcher;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.nameapi.ontology5.input.entities.person.InputPerson;
import org.nameapi.ontology5.services.formatter.FormatterProperties;

/**
 *
 */
public class PersonMatcherArgument {

    @NotNull
    private final InputPerson inputPerson1;
    @NotNull
    private final InputPerson inputPerson2;

    public PersonMatcherArgument(@NotNull InputPerson inputPerson1, @NotNull InputPerson inputPerson2) {
        this.inputPerson1 = inputPerson1;
        this.inputPerson2 = inputPerson2;
    }

    @NotNull
    public InputPerson getInputPerson1() {
        return inputPerson1;
    }

    @NotNull
    public InputPerson getInputPerson2() {
        return inputPerson2;
    }
}

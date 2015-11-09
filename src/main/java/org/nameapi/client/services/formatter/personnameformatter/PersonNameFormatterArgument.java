package org.nameapi.client.services.formatter.personnameformatter;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.nameapi.ontology5.input.entities.person.InputPerson;
import org.nameapi.ontology5.services.formatter.FormatterProperties;

/**
 *
 */
public class PersonNameFormatterArgument {

    @NotNull
    private final InputPerson inputPerson;
    @Nullable
    private final FormatterProperties properties;

    public PersonNameFormatterArgument(@NotNull InputPerson inputPerson, @Nullable FormatterProperties properties) {
        this.inputPerson = inputPerson;
        this.properties = properties;
    }

    @NotNull
    public InputPerson getInputPerson() {
        return inputPerson;
    }

    @Nullable
    public FormatterProperties getProperties() {
        return properties;
    }
}

package org.nameapi.client.services.formatter.personnameformatter;

import com.optimaize.command4j.lang.Immutable;
import org.jetbrains.annotations.NotNull;
import org.nameapi.client.services.formatter.FormatterProperties;
import org.nameapi.ontology5.input.entities.person.InputPerson;

/**
 *
 */
@Immutable
public class PersonNameFormatterArgument {

    @NotNull
    private final InputPerson inputPerson;
    @NotNull
    private final FormatterProperties formatterProperties;

    public PersonNameFormatterArgument(@NotNull InputPerson inputPerson, @NotNull FormatterProperties formatterProperties) {
        this.inputPerson = inputPerson;
        this.formatterProperties = formatterProperties;
    }

    @NotNull
    public InputPerson getInputPerson() {
        return inputPerson;
    }

    @NotNull
    public FormatterProperties getFormatterProperties() {
        return formatterProperties;
    }
}

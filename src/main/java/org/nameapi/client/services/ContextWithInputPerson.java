package org.nameapi.client.services;

import org.nameapi.ontology5.input.context.Context;
import org.nameapi.ontology5.input.entities.person.InputPerson;

/**
 *
 */
public class ContextWithInputPerson {

    private final Context context;
    private final InputPerson inputPerson;

    public ContextWithInputPerson(Context context, InputPerson inputPerson) {
        this.context = context;
        this.inputPerson = inputPerson;
    }

    public Context getContext() {
        return context;
    }

    public InputPerson getInputPerson() {
        return inputPerson;
    }
}

package org.nameapi.client.services.parser.personnameparser;

import org.nameapi.ontology4.input.entities.person.PersonType;
import org.nameapi.ontology4.output.entities.person.name.OutputPersonName;

import java.util.List;

/**
 */
public class ParsedPerson {

    private final PersonType personType;
    private final List<OutputPersonName> names;

    public ParsedPerson(PersonType personType, List<OutputPersonName> names) {
        this.personType = personType;
        this.names = names;
    }


    public PersonType getPersonType() {
        return personType;
    }

    public List<OutputPersonName> getNames() {
        return names;
    }
}

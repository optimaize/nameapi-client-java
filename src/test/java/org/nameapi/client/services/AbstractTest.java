package org.nameapi.client.services;

import org.jetbrains.annotations.NotNull;
import org.nameapi.ontology5.input.entities.person.name.InputPersonName;
import org.nameapi.ontology5.input.entities.person.name.builder.NameBuilders;
import org.nameapi.ontology5.input.entities.person.name.builder.WesternInputPersonNameBuilder;

/**
 * @author Fabian Kessler
 */
public class AbstractTest {

    @NotNull
    protected InputPersonName makeName(@NotNull String gn, @NotNull String sn) {
        return new WesternInputPersonNameBuilder().givenName(gn).surname(sn).build();
    }

    @NotNull
    protected InputPersonName makeName(@NotNull String fullname) {
        return NameBuilders.western().fullname(fullname).build();
    }

}

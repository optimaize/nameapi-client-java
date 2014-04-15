package org.nameapi.client.services.email.emailnameparser;

import org.jetbrains.annotations.NotNull;

/**
 * As contained in {@link EmailNameParserMatch}.
 */
public interface NameFromEmailAddress {

    @NotNull
    String getName();

    @NotNull
    EmailAddressNameType getNameType();

}

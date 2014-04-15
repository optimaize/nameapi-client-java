package org.nameapi.client.services.email.emailnameparser;

import crema.annotation.GeneratedCode;
import crema.annotation.Immutable;
import org.jetbrains.annotations.NotNull;

/**
 */
@Immutable
class NameFromEmailAddressImpl implements NameFromEmailAddress {

    @NotNull
    private String name;
    @NotNull
    private EmailAddressNameType nameType;

    NameFromEmailAddressImpl(@NotNull String name, @NotNull EmailAddressNameType nameType) {
        this.name = name;
        this.nameType = nameType;
    }

    @Override @NotNull
    public String getName() {
        return name;
    }

    @Override @NotNull
    public EmailAddressNameType getNameType() {
        return nameType;
    }

    @Override @NotNull
    public String toString() {
        return name+"("+nameType+")";
    }


    @Override @GeneratedCode
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NameFromEmailAddressImpl name1 = (NameFromEmailAddressImpl) o;

        if (!name.equals(name1.name)) return false;
        if (nameType != name1.nameType) return false;

        return true;
    }

    @Override @GeneratedCode
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + nameType.hashCode();
        return result;
    }
}

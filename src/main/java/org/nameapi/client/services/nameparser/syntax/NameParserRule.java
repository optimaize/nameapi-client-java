
package org.nameapi.client.services.nameparser.syntax;

import org.jetbrains.annotations.NotNull;
import org.nameapi.ontology5.cremalang.annotation.GeneratedCode;
import org.nameapi.ontology5.cremalang.lang.Preconditions;

/**
 */
public class NameParserRule {

    @NotNull
    private final String name;
    private final int chance;
    @NotNull
    private final String syntax;

    /**
     * @param chance 1-100
     * @throws IllegalArgumentException
     */
    public NameParserRule(@NotNull String name, int chance, @NotNull String syntax) throws IllegalArgumentException {
        if (chance<1 || chance >100) {
            throw new IllegalArgumentException("Chance must be 1-100 but was: "+chance+"!");
        }
        Preconditions.notNullAndNotEmpty(syntax, "syntax");
        this.name = name;
        this.chance = chance;
        this.syntax = syntax;
    }

    public String getName() {
        return name;
    }

    public int getChance() {
        return chance;
    }

    @NotNull
    public String getSyntax() {
        return syntax;
    }

    @Override @GeneratedCode
    public String toString() {
        return "NameParserRule{" +
                "name='" + name + '\'' +
                ", chance=" + chance +
                ", syntax='" + syntax + '\'' +
                '}';
    }

    @Override @GeneratedCode
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NameParserRule that = (NameParserRule) o;

        if (chance != that.chance) return false;
        if (!name.equals(that.name)) return false;
        if (!syntax.equals(that.syntax)) return false;

        return true;
    }

    @Override @GeneratedCode
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + chance;
        result = 31 * result + syntax.hashCode();
        return result;
    }
}

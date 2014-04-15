package org.nameapi.client.services.nameparser.fieldnameparser;

import com.google.common.collect.ImmutableList;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;

/**
 * The result of a {@link FieldNameParserCommand}.
 *
 * @author Fabian Kessler
 */
public class FieldNameParserResult {

    private static final FieldNameParserResult EMPTY = new FieldNameParserResult(Collections.<Match>emptyList());
    public static FieldNameParserResult empty() {
        return EMPTY;
    }

    @NotNull
    private final List<Match> matches;

    public FieldNameParserResult(@NotNull List<Match> matches) {
        this.matches = ImmutableList.copyOf(matches);
    }

    @NotNull
    public List<Match> getMatches() {
        return matches;
    }
}

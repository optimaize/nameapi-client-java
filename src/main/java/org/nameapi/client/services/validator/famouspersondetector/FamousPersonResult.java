
package org.nameapi.client.services.validator.famouspersondetector;

import com.google.common.base.Optional;
import com.optimaize.command4j.lang.Immutable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


/**
 */
@Immutable
public final class FamousPersonResult {

    private final int points;
    @NotNull
    private final Optional<String> message;

    public FamousPersonResult(int points, @Nullable String message) {
        this.points = points;
        this.message = Optional.fromNullable(message);
    }

    /**
     * @return 0-100 where 100 is the max.
     */
    public int getPoints() {
        return points;
    }

    @NotNull
    public Optional<String> getMessage() {
        return message;
    }


    @Override
    public String toString() {
        return "FamousPersonResult{" +
                "points=" + points +
                ", message=" + message +
                '}';
    }
}

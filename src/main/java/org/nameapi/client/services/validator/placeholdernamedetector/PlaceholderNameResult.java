
package org.nameapi.client.services.validator.placeholdernamedetector;

import com.google.common.base.Optional;
import cremacopy.annotation.Immutable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 */
@Immutable
public final class PlaceholderNameResult {

    @NotNull
    private final FakeType fakeType;
    private final int points;
    @NotNull
    private final Optional<String> message;


    public PlaceholderNameResult(@NotNull FakeType fakeType, int points, @Nullable String message) {
        this.fakeType = fakeType;
        this.points = points;
        this.message = Optional.fromNullable(message);
    }


    @NotNull
    public FakeType getFakeType() {
        return fakeType;
    }

    public int getPoints() {
        return points;
    }

    @NotNull
    public Optional<String> getMessage() {
        return message;
    }


    @Override
    public String toString() {
        return "PlaceholderNameResult{" +
                "fakeType=" + fakeType +
                ", points=" + points +
                ", message=" + message +
                '}';
    }
}

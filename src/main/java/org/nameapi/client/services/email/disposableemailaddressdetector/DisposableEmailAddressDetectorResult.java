package org.nameapi.client.services.email.disposableemailaddressdetector;

import crema.lang.Maybe;
import org.jetbrains.annotations.NotNull;

/**
 * Result returned by {@link DisposableEmailAddressDetectorCommand}.
 */
public class DisposableEmailAddressDetectorResult {

    @NotNull
    private final Maybe disposable;

    public DisposableEmailAddressDetectorResult(@NotNull Maybe disposable) {
        this.disposable = disposable;
    }

    @NotNull
    public Maybe getDisposable() {
        return disposable;
    }
}

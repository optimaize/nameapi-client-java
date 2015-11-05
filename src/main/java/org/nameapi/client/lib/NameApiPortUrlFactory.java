package org.nameapi.client.lib;

import com.optimaize.anythingworks.client.rest.AbstractRestPortUrlFactory;
import com.optimaize.anythingworks.common.host.Host;
import org.jetbrains.annotations.NotNull;

import java.net.URL;

/**
 */
public class NameApiPortUrlFactory extends AbstractRestPortUrlFactory {

    private final String restPrefix;

    /**
     * This is updated whenever the "latest stable" server api version changes.
     *
     * Currently this is version 5.0.
     */
    public static NameApiPortUrlFactory versionLatestStable() {
        return version5_0();
    }

    /**
     * This is always set to the latest release candidate, that is the version right before it becomes the latest stable.
     * Such a version does not always exist. After successful testing, it becomes the live version.
     *
     * Currently this is version 5.0.
     */
    public static NameApiPortUrlFactory versionLatestReleaseCandidate() {
        return version5_0();
    }

    /**
     * This is always set to the current main development version.
     * You do not necessarily have access to this.
     *
     * Currently this is version 5.0.
     */
    public static NameApiPortUrlFactory versionLatestDevelopment() {
        return version5_0();
    }

    public static NameApiPortUrlFactory version5_0() {
        return new NameApiPortUrlFactory("5.0");
    }

    /**
     * @param version for example "5.0".
     */
    private NameApiPortUrlFactory(@NotNull String version) {
        this.restPrefix = "/rest/v"+version;
    }

    @NotNull @Override
    public URL createUrl(@NotNull Host host) {
        return createUrl(host, restPrefix);
    }
}

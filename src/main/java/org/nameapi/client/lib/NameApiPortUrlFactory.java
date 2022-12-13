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
     * Currently this is version 5.3.
     */
    public static NameApiPortUrlFactory versionLatestStable() {
        return version5_3();
    }

    /**
     * This is always set to the latest release candidate, that is the version right before it becomes the latest stable.
     * Such a version does not always exist. After successful testing, it becomes the live version.
     *
     * Currently there is no release candidate available, so it returns the stable version.
     */
    public static NameApiPortUrlFactory versionLatestReleaseCandidate() {
        return version5_3();
    }


    public static NameApiPortUrlFactory version5_3() {
        return new NameApiPortUrlFactory("5.3");
    }

    /**
     * @param version for example "5.3".
     */
    private NameApiPortUrlFactory(@NotNull String version) {
        this.restPrefix = "/rest/v"+version;
    }

    @NotNull @Override
    public URL createUrl(@NotNull Host host) {
        return createUrl(host, restPrefix);
    }
}

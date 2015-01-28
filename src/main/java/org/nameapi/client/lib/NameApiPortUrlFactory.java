package org.nameapi.client.lib;

import com.optimaize.soapworks.client.AbstractPortUrlFactory;
import com.optimaize.soapworks.common.host.Host;
import org.jetbrains.annotations.NotNull;

import java.net.URL;

/**
 */
public class NameApiPortUrlFactory extends AbstractPortUrlFactory {

    private final String soapPrefix;

    /**
     * This is updated whenever the "latest stable" server api version changes.
     *
     * Currently this is version 4.0.
     */
    public static NameApiPortUrlFactory versionLatestStable() {
        return version4_0();
    }

    /**
     * This is always set to the latest release candidate, that is the version right before it becomes the latest stable.
     * Such a version does not always exist. After successful testing, it becomes the live version.
     *
     * Currently this is version 4.1.
     */
    public static NameApiPortUrlFactory versionLatestReleaseCandidate() {
        return version4_1();
    }

    /**
     * This is always set to the current main development version.
     * You do not necessarily have access to this.
     *
     * Currently this is version 4.2.
     */
    public static NameApiPortUrlFactory versionLatestDevelopment() {
        return version4_2();
    }

    public static NameApiPortUrlFactory version4_0() {
        return new NameApiPortUrlFactory("4.0");
    }
    public static NameApiPortUrlFactory version4_1() {
        return new NameApiPortUrlFactory("4.1");
    }
    public static NameApiPortUrlFactory version4_2() {
        return new NameApiPortUrlFactory("4.2");
    }

    /**
     * @param version for example "4.0".
     */
    private NameApiPortUrlFactory(@NotNull String version) {
        this.soapPrefix = "/soap/v"+version;
    }

    @NotNull @Override
    public URL createUrl(@NotNull Host host, @NotNull String servicePath) {
        return createUrl(host, soapPrefix, servicePath);
    }
}

package org.nameapi.client.lib;

import com.optimaize.soapworks.client.AbstractPortUrlFactory;
import com.optimaize.soapworks.common.host.Host;
import org.jetbrains.annotations.NotNull;

import java.net.URL;

/**
 */
public class NameApiPortUrlFactory extends AbstractPortUrlFactory {

    /**
     * This is updated whenever the server api version changes.
     */
    private static final String soapPrefix = "/soap/v4.0";

    @NotNull @Override
    public URL createUrl(@NotNull Host host, @NotNull String servicePath) {
        return createUrl(host, soapPrefix, servicePath);
    }
}

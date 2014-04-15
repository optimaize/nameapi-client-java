package org.nameapi.client.lib;

import com.optimaize.command4j.lang.Key;
import org.nameapi.client.commonwsdl.context.SoapContext;

/**
 * A place of keys used by this NameAPI library.
 */
public interface NameApiKeys {

    /**
     * The context is required for any call to NameApi services.
     * You must supply a valid context with the {@code mode} argument.
     */
    Key<SoapContext> CONTEXT = Key.create("Context", SoapContext.class);

}

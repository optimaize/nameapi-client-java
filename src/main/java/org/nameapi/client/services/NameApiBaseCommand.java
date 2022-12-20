package org.nameapi.client.services;

import com.optimaize.anythingworks.client.rest.RestBaseCommand;
import com.optimaize.anythingworks.client.rest.http.RestHttpClient;
import com.optimaize.anythingworks.client.rest.http.RestHttpClientImpl;
import com.optimaize.command4j.ExecutionContext;
import org.jetbrains.annotations.NotNull;
import org.nameapi.client.lib.NameApiKeys;
import org.nameapi.ontology5.input.context.Context;

import java.net.URL;

/**
 * Adds NameAPI-specific functionality to the BaseCommand.
 * @param <T> The wsdl port type.
 */
public abstract class NameApiBaseCommand<T, A, R> extends RestBaseCommand<T, A, R> {

    protected static String CLIENT_VERSION = "NameAPI Java Client 5.4.0";

    protected NameApiBaseCommand(@NotNull Class<T> wsdlPortType) {
        super(wsdlPortType);
    }

    @NotNull
    protected Context getContext(@NotNull ExecutionContext ec) {
        return ec.getMode().get(NameApiKeys.CONTEXT).get();
    }

    @NotNull
    protected String getApiKey(ExecutionContext ec) {
        return ec.getMode().get(NameApiKeys.API_KEY).get();
    }

    @NotNull
    protected RestHttpClient makeClient(@NotNull final ExecutionContext ec) {
        URL baseUrl = makeBaseUrl(ec);
        return new RestHttpClientImpl.Builder()
                .basePath(baseUrl.toExternalForm())
                .userAgent(CLIENT_VERSION)
                .build();
    }

}
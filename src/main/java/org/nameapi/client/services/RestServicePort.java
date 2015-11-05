package org.nameapi.client.services;

import com.optimaize.anythingworks.client.rest.http.RestHttpClient;

/**
 *
 */
public abstract class RestServicePort {

    protected final RestHttpClient restApiClient;
    protected final String servicePath;

    public RestServicePort(RestHttpClient restApiClient, String servicePath) {
        this.restApiClient = restApiClient;
        this.servicePath = servicePath;
    }

}

package org.nameapi.client.services.formatter.personnameformatter;

import com.optimaize.anythingworks.client.rest.http.HeaderParams;
import com.optimaize.anythingworks.client.rest.http.QueryParams;
import com.optimaize.anythingworks.client.rest.http.RestHttpClient;
import com.optimaize.anythingworks.client.rest.http.RestHttpClientResponse;
import com.optimaize.anythingworks.common.rest.TypeRef;
import org.nameapi.client.services.RestServicePort;
import org.nameapi.client.services.formatter.FormatterResult;

/**
 *
 */
class RestPort extends RestServicePort {

    private static final TypeRef returnType = new TypeRef<FormatterResult>() {};

    public RestPort(RestHttpClient restApiClient, String servicePath) {
        super(restApiClient, servicePath);
    }

    public FormatterResult ping(String apiKey) {
        QueryParams queryParams = QueryParams.create();
        queryParams.add("apiKey", apiKey);

        RestHttpClientResponse<FormatterResult> response = restApiClient.invokeGet(
                servicePath,
                queryParams, HeaderParams.none(),
                returnType
        );
        return response.getResult().get();
    }

}

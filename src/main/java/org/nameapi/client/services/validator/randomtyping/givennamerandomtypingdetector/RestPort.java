package org.nameapi.client.services.validator.randomtyping.givennamerandomtypingdetector;

import com.optimaize.anythingworks.client.rest.http.HeaderParams;
import com.optimaize.anythingworks.client.rest.http.QueryParams;
import com.optimaize.anythingworks.client.rest.http.RestHttpClient;
import com.optimaize.anythingworks.client.rest.http.RestHttpClientResponse;
import com.optimaize.anythingworks.common.rest.TypeRef;
import org.nameapi.client.services.RestServicePort;
import org.nameapi.client.services.validator.randomtyping.RandomTypingResult;

/**
 *
 */
class RestPort extends RestServicePort {

    private static final TypeRef returnType = new TypeRef<RandomTypingResult>() {};

    public RestPort(RestHttpClient restApiClient, String servicePath) {
        super(restApiClient, servicePath);
    }

    public RandomTypingResult ping(String apiKey, String nameField) {
        QueryParams queryParams = QueryParams.create();
        queryParams.add("apiKey", apiKey);
        queryParams.add("nameField", nameField);

        RestHttpClientResponse<RandomTypingResult> response = restApiClient.invokeGet(
                servicePath,
                queryParams, HeaderParams.none(),
                returnType
        );
        return response.getResult().get();
    }

}

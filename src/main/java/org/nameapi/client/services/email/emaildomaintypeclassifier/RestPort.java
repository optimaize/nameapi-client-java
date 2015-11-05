package org.nameapi.client.services.email.emaildomaintypeclassifier;

import com.optimaize.anythingworks.client.rest.http.HeaderParams;
import com.optimaize.anythingworks.client.rest.http.QueryParams;
import com.optimaize.anythingworks.client.rest.http.RestHttpClient;
import com.optimaize.anythingworks.client.rest.http.RestHttpClientResponse;
import com.optimaize.anythingworks.common.rest.TypeRef;
import org.nameapi.client.services.RestServicePort;
import org.nameapi.ontology5.services.email.emaildomaintypeclassifier.EmailDomainTypeClassifierResult;

/**
 *
 */
class RestPort extends RestServicePort {

    private static final TypeRef returnType = new TypeRef<EmailDomainTypeClassifierResult>() {};

    public RestPort(RestHttpClient restApiClient, String servicePath) {
        super(restApiClient, servicePath);
    }

    public EmailDomainTypeClassifierResult call(String apiKey, String emailAddress) {
        QueryParams queryParams = QueryParams.create();
        queryParams.add("apiKey", apiKey);
        queryParams.add("emailAddress", emailAddress);

        RestHttpClientResponse<EmailDomainTypeClassifierResult> response = restApiClient.invokeGet(
                servicePath,
                queryParams, HeaderParams.none(),
                returnType
        );
        return response.getResult().get();
    }

}

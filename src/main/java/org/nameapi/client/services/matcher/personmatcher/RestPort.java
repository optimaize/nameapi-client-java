package org.nameapi.client.services.matcher.personmatcher;

import com.optimaize.anythingworks.client.rest.http.HeaderParams;
import com.optimaize.anythingworks.client.rest.http.QueryParams;
import com.optimaize.anythingworks.client.rest.http.RestHttpClient;
import com.optimaize.anythingworks.client.rest.http.RestHttpClientResponse;
import com.optimaize.anythingworks.common.rest.TypeRef;
import org.nameapi.client.services.RestServicePort;
import org.nameapi.ontology5.input.context.Context;
import org.nameapi.ontology5.input.entities.person.InputPerson;
import org.nameapi.ontology5.services.InputWithPerson;
import org.nameapi.ontology5.services.InputWithTwoPeople;
import org.nameapi.ontology5.services.matcher.personmatcher.PersonMatcherResult;

/**
 *
 */
class RestPort extends RestServicePort {

    private static final TypeRef returnType = new TypeRef<PersonMatcherResult>() {};

    public RestPort(RestHttpClient restApiClient, String servicePath) {
        super(restApiClient, servicePath);
    }

    public PersonMatcherResult call(String apiKey, Context context, InputPerson inputPerson1, InputPerson inputPerson2) {
        QueryParams queryParams = QueryParams.create();
        queryParams.add("apiKey", apiKey);

        RestHttpClientResponse<PersonMatcherResult> response = restApiClient.invokeBody(
                servicePath, "POST",
                queryParams, HeaderParams.none(),
                new InputWithTwoPeople(context, inputPerson1, inputPerson2),
                returnType
        );
        return response.getResult().get();
    }

}

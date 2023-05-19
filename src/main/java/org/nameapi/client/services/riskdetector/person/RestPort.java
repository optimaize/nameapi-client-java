package org.nameapi.client.services.riskdetector.person;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Optional;
import com.optimaize.anythingworks.client.rest.http.HeaderParams;
import com.optimaize.anythingworks.client.rest.http.QueryParams;
import com.optimaize.anythingworks.client.rest.http.RestHttpClient;
import com.optimaize.anythingworks.client.rest.http.RestHttpClientResponse;
import com.optimaize.anythingworks.common.rest.TypeRef;
import org.nameapi.client.services.riskdetector.FixingObjectMapper;
import org.nameapi.client.services.RestServicePort;
import org.nameapi.ontology5.input.context.Context;
import org.nameapi.ontology5.input.entities.person.InputPerson;
import org.nameapi.ontology5.services.InputWithPerson;
import org.nameapi.ontology5.services.riskdetector.RiskDetectorResult;

import java.io.IOException;

class RestPort extends RestServicePort {

    private static final TypeRef returnType = new TypeRef<String>() {};
    private static final ObjectMapper FIXING_OBJECT_MAPPER = FixingObjectMapper.create();

    public RestPort(RestHttpClient restApiClient, String servicePath) {
        super(restApiClient, servicePath);
    }

    public RiskDetectorResult call(String apiKey, Context context, InputPerson inputPerson) {
        QueryParams queryParams = QueryParams.create();
        queryParams.add("apiKey", apiKey);

        RestHttpClientResponse<String> response = restApiClient.invokeBody(
                servicePath, "POST",
                queryParams, HeaderParams.none(),
                new InputWithPerson(context, inputPerson),
                returnType
        );

        Optional<String> result = response.getResult();
        if (!result.isPresent()) {
            throw new RuntimeException("No result from the server!");
        }
        String content = result.get();
        try {
            return FIXING_OBJECT_MAPPER.readValue(content, RiskDetectorResult.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

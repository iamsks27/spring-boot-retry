package com.example.demo.helper;

import com.example.demo.bean.Workflow;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Map;

/**
 * @author sksingh created on 18/01/24
 */
public class WorkflowConfigDeserializer extends JsonDeserializer<Map<String, Workflow>> {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    @Override
    public Map<String, Workflow> deserialize(
            JsonParser jsonParser, DeserializationContext deserializationContext
    ) throws IOException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);

        return MAPPER.convertValue(node, new TypeReference<>() {
        });
    }
}

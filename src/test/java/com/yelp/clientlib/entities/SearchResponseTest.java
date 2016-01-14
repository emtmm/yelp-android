package com.yelp.clientlib.entities;

import com.fasterxml.jackson.databind.JsonNode;
import com.yelp.clientlib.util.JsonTestUtils;
import com.yelp.clientlib.util.SerializationTestUtil;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class SearchResponseTest {
    @Test
    public void testDeserializeFromJson() throws IOException {
        JsonNode searchNode = JsonTestUtils.getSearchResponseJsonNode();
        SearchResponse searchResponse = JsonTestUtils.deserializeJson(searchNode.toString(), SearchResponse.class);

        Assert.assertEquals(new Integer(searchNode.path("total").asInt()), searchResponse.total());

        // The following objects are tested in their own tests.
        Assert.assertNotNull(searchResponse.region());
        Assert.assertNotNull(searchResponse.businesses());
    }

    @Test
    public void testSerializable() throws IOException, ClassNotFoundException {
        JsonNode searchResponseNode = JsonTestUtils.getSearchResponseJsonNode();
        SearchResponse searchResponse = JsonTestUtils.deserializeJson(
                searchResponseNode.toString(),
                SearchResponse.class
        );

        byte[] bytes = SerializationTestUtil.serialize(searchResponse);
        Assert.assertEquals(searchResponse, SerializationTestUtil.deserialize(bytes, SearchResponse.class));
    }
}

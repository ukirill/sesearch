package com.sesearch.services;

import com.sesearch.models.StackExchangeRequest;
import com.sesearch.models.StackExchangeResponse;
import org.glassfish.jersey.client.filter.EncodingFilter;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.message.GZipEncoder;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

public class StackExchangeService {

    private static String filterKey = "!5-dqr-cjd1-P)uV08dtYmzy4231UGRs8hOybx*";

    public StackExchangeResponse search(StackExchangeRequest req) {
        Client client = ClientBuilder.newClient();
        WebTarget target = client
                .register(GZipEncoder.class)
                .register(EncodingFilter.class)
                .register(JacksonFeature.class)
                .target("http://api.stackexchange.com/2.2/search")
                .queryParam("site", "stackoverflow")
                .queryParam("intitle", req.searchString)
                .queryParam("sort", req.sortField)
                .queryParam("order", "desc")
                .queryParam("filter", filterKey);
        if (req.pageNum > 1) {
            target = target.queryParam("page", req.pageNum);
        }
        if (req.pageSize > 0) {
            target = target.queryParam("pagesize", req.pageSize);
        }

        Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.get();
        StackExchangeResponse seResponse = response.readEntity(StackExchangeResponse.class);
        return seResponse;
    }
}

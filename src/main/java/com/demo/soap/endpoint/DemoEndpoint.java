package com.demo.soap.endpoint;


import com.soap.demo.generated.GetCountryRequest;
import com.soap.demo.generated.GetCountryResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class DemoEndpoint {

    @PayloadRoot(namespace = "http://demo.project/countries", localPart = "GetCountryRequest")
    @ResponsePayload
    public GetCountryResponse handleDemoRequest(@RequestPayload GetCountryRequest request) {

        GetCountryResponse response =new GetCountryResponse();
        response.setCountryName("India");
        response.setCapital("New Delhi");
          return response
                  ;
    }
}
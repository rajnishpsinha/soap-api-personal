package com.demo.soap.endpoint;


import com.demo.soap.service.CountryService;
import com.soap.demo.generated.GetCountryRequest;
import com.soap.demo.generated.GetCountryResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class DemoEndpoint {

    private final CountryService countryService;

    public DemoEndpoint(CountryService countryService) {
        this.countryService = countryService;
    }

    @PayloadRoot(namespace = "http://demo.project/countries", localPart = "GetCountryRequest")
    @ResponsePayload
    public GetCountryResponse handleDemoRequest(@RequestPayload GetCountryRequest request) {
        String[] data = countryService.getCountryData(request.getCountryCode());

        GetCountryResponse response = new GetCountryResponse();
        response.setCountryName(data[0]);
        response.setCapital(data[1]);
        return response;
    }
}
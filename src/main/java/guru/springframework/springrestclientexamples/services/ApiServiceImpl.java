package guru.springframework.springrestclientexamples.services;

import guru.springframework.api.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.List;

@Service
public class ApiServiceImpl implements ApiService{

    private final RestTemplate restTemplate;
    private final String API_URL;

    public ApiServiceImpl(RestTemplate restTemplate, @Value("${api.url}") String API_URL ){
        this.restTemplate = restTemplate;
        this.API_URL=API_URL;
    }

    @Override
    public List<User> getUsers() {

        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder
                .fromUriString(API_URL);

        ResponseEntity<User[]> response =restTemplate.getForEntity(uriComponentsBuilder.toUriString(),User[].class);
        return Arrays.asList(response.getBody());
    }
}

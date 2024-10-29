package co.edu.unicauca.api_rest_article.fachadaServices.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import co.edu.unicauca.api_rest_article.fachadaServices.DTO.ArticlesWithConferencesDTO.ConferenceDTO;
import reactor.core.publisher.Mono;

import java.util.List;


@Service
public class ConferenceService {
    @Autowired
    private WebClient.Builder webClientBuilder;
    public List<ConferenceDTO> getConferencesByArticle(Integer idArticle){
        String url = "http://localhost:8080/api/conferences/article/"+idArticle;
        Mono<ConferenceDTO[]> response = webClientBuilder.build()
            .get().uri(url).retrieve()
            .bodyToMono(ConferenceDTO[].class);
        
        ConferenceDTO[] conferences = response.block();
        return conferences!=null ? List.of(conferences) : List.of();
    }
}

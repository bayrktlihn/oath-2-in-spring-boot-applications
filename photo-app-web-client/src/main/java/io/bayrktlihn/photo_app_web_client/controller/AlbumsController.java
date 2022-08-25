package io.bayrktlihn.photo_app_web_client.controller;

import io.bayrktlihn.photo_app_web_client.response.AlbumRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Controller
public class AlbumsController {

    @Autowired
    OAuth2AuthorizedClientService oAuth2AuthorizedClientService;

//    @Autowired
//    RestTemplate restTemplate;

    @Autowired
    WebClient webClient;

    @GetMapping("albums")
    public String getAlbums(Model model, @AuthenticationPrincipal OidcUser principal) {

//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//
//        OAuth2AuthenticationToken oauthToken = (OAuth2AuthenticationToken) authentication;
//
//        OAuth2AuthorizedClient oauth2Client = oAuth2AuthorizedClientService.loadAuthorizedClient(oauthToken.getAuthorizedClientRegistrationId(), oauthToken.getName());
//
//        String jwtAccessToken = oauth2Client.getAccessToken().getTokenValue();
//        System.out.println("jwtAccessToken = " + jwtAccessToken);
//
//        System.out.println("Principal = " + principal);
//
//        OidcIdToken idToken = principal.getIdToken();
//        String idTokenValue = idToken.getTokenValue();
//        System.out.println("idTokenValue = " + idTokenValue);

        String url = "http://localhost:8082/albums";

//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Authorization", "Bearer " + jwtAccessToken);
//
//        HttpEntity<List<AlbumRest>> entity = new HttpEntity<>(headers);
//
//        ResponseEntity<List<AlbumRest>> responseEntity = restTemplate.exchange(url, HttpMethod.GET, entity, new ParameterizedTypeReference<List<AlbumRest>>() {
//        });
//
//        List<AlbumRest> albums = responseEntity.getBody();

        List<AlbumRest> albums = webClient.get().uri(url).retrieve().bodyToMono(new ParameterizedTypeReference<List<AlbumRest>>() {
                })
                .block();

//        AlbumRest albumRest = new AlbumRest();
//        albumRest.setAlbumId("albumOne");
//        albumRest.setAlbumTitle("Album one title");
//        albumRest.setAlbumUrl("http://localhost:8082/albums/1");
//
//
//        AlbumRest albumRest2 = new AlbumRest();
//        albumRest2.setAlbumId("albumTwo");
//        albumRest2.setAlbumTitle("Album two title");
//        albumRest2.setAlbumUrl("http://localhost:8082/albums/2");

        model.addAttribute("albums", albums);

        return "albums";
    }
}

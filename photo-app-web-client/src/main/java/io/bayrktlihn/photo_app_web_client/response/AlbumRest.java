package io.bayrktlihn.photo_app_web_client.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AlbumRest {
    private String albumId;
    private String userId;
    private String albumTitle;
    private String albumDescription;
    private String albumUrl;
}

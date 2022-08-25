package io.bayrktlihn.photos.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PhotoRest {

    private String albumId;
    private String photoId;
    private String userId;
    private String photoTitle;
    private String photoDescription;
    private String photoUrl;

}

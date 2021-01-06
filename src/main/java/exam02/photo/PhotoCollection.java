package exam02.photo;

import java.util.ArrayList;
import java.util.List;

public class PhotoCollection {

    private List<Photo> photos = new ArrayList<>();

    public void addPhoto(String ... photos) {
        for (String photo : photos) {
            this.photos.add(new Photo(photo));
        }
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void starPhoto(String photoName, Quality quality) {
        for (Photo photo : photos) {
            if (photo.getName().equals(photoName)) {
                photo.setQuality(quality);
                return;
            }
        }
        throw new PhotoNotFoundException();
    }

    public int numberOfStars() {
        int sum = 0;
        for (Photo photo : photos) {
            if (photo.getQuality() == Quality.ONE_STAR) {
                sum +=1;
            }
            if (photo.getQuality() == Quality.TWO_STAR) {
                sum +=2;
            }
        }
        return sum;
    }
}

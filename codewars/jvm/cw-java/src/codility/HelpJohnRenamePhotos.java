package codility;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;

class HelpJohnRenamePhotos {
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    // construct immutable Photo object - makes code easier to follow than working with array indexes from String.split()
    static final class Photo {
        private final String fileName;
        private final String extension;
        private final String city;
        private final LocalDateTime date;

        public Photo(String fileName, String city, String date) {
            this.fileName = fileName.trim();
            this.extension = this.fileName.substring(this.fileName.indexOf("."));
            this.city = city.trim();
            this.date = LocalDateTime.parse(date.trim(), formatter);
        }

        public String getFileName() {
            return fileName;
        }

        public String getExtension() {
            return extension;
        }

        public String getCity() {
            return city;
        }

        public LocalDateTime getDate() {
            return date;
        }
    }

    public static String solution(String S) {
        List<String> photoFiles = Arrays.asList(S.split("\n"));

        // track order of output
        List<Photo> photos = photoFiles.stream()
                .map(photoFile -> {
                    String[] fileParts = photoFile.split(",");
                    return new Photo(fileParts[0], fileParts[1], fileParts[2]);
                }).collect(toList());

        // track photo count in each city ordered by time stamp on each file
        Map<String, List<Photo>> photoGroup = photos.stream()
                .sorted(comparing(Photo::getDate))
                .collect(groupingBy(Photo::getCity));

        // return updated file names
        return photos.stream()
                .map(photo -> {
                    List<Photo> photosInCity = photoGroup.get(photo.getCity());
                    int numPhotosOfCity = photosInCity.size();
                    int indexOfPhotoInGroup = photosInCity.indexOf(photo);
                    return photo.getCity() +
                            String.format("%0" + String.valueOf(numPhotosOfCity).length() + "d", indexOfPhotoInGroup + 1) +
                            photo.getExtension();
                }).collect(joining("\n"));
    }

    public static void main(String... args) {
        String check = String.format("%0" + 3 + "d", 3);
        String input = "photo.jpg, Warsaw, 2013-09-05 14:08:15\n" +
                "john.png, London, 2015-06-20 15:13:22\n" +
                "john.png, London, 2015-06-20 15:13:23\n" +
                "myFriends.png, Warsaw, 2013-09-05 14:07:13\n" +
                "Eiffel.jpg, Paris, 2015-07-23 08:03:02\n" +
                "pisatower.jpg, Paris, 2015-07-22 23:59:59\n" +
                "BOB.jpg, London, 2015-08-05 00:02:03\n" +
                "notredame.png, Paris, 2015-09-01 12:00:00\n" +
                "me.jpg, Warsaw, 2013-09-06 15:40:22\n" +
                "a.png, Warsaw, 2016-02-13 13:33:50\n" +
                "b.jpg, Warsaw, 2016-01-02 15:12:22\n" +
                "c.jpg, Warsaw, 2016-01-02 14:34:30\n" +
                "d.jpg, Warsaw, 2016-01-02 15:15:01\n" +
                "e.png, Warsaw, 2016-01-02 09:49:09\n" +
                "f.png, Warsaw, 2016-01-02 10:55:32\n" +
                "g.jpg, Warsaw, 2016-02-29 22:13:11";
        String output = "Warsaw02.jpg\n" +
                "London1.png\n" +
                "London2.png\n" +
                "Warsaw01.png\n" +
                "Paris2.jpg\n" +
                "Paris1.jpg\n" +
                "London3.jpg\n" +
                "Paris3.png\n" +
                "Warsaw03.jpg\n" +
                "Warsaw09.png\n" +
                "Warsaw07.jpg\n" +
                "Warsaw06.jpg\n" +
                "Warsaw08.jpg\n" +
                "Warsaw04.png\n" +
                "Warsaw05.png\n" +
                "Warsaw10.jpg";
        solution(input);
        assert (solution(input).equals(output));
    }
}
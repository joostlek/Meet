package nl.jtosti.meet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import nl.jtosti.meet.socialMedia.SocialMedia;

public class Person {
    private String name;
    private String email;
    private ArrayList<SocialMedia> socialMedia;

    public Person(String name, String email, ArrayList<SocialMedia> socialMedia) {
        this.name = name;
        this.email = email;
        this.socialMedia = socialMedia;
    }

    public Person(String name, String email) {
        this.name = name;
        this.email = email;
        this.socialMedia = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<SocialMedia> getSocialMedia() {
        return socialMedia;
    }

    public void setSocialMedia(ArrayList<SocialMedia> socialMedia) {
        this.socialMedia = socialMedia;
    }

    public void addSocialMedia(SocialMedia socialMedia) {
        this.socialMedia.add(socialMedia);
    }

    public Map<String, Object> toMap() {
        Map<String, Object> user = new HashMap<>();
        user.put("name", this.name);
        user.put("email", this.email);
        return user;
    }
}

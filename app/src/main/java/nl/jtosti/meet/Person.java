package nl.jtosti.meet;

import java.util.ArrayList;

import nl.jtosti.meet.socialMedia.SocialMedia;

public class Person {
    private String firstName;
    private String lastName;
    private ArrayList<SocialMedia> socialMedia;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.socialMedia = new ArrayList<>();
    }

    public Person(String firstName, String lastName, ArrayList<SocialMedia> socialMedia) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.socialMedia = socialMedia;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String constructName() {
        return this.firstName + " " + this.lastName;
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
}

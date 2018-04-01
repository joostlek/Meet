package nl.jtosti.meet.socialMedia;


public abstract class SocialMedia {
    private String name;

    public SocialMedia(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

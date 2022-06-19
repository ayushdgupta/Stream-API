package Work;

import java.util.List;

public class AnimeCharacters {

    private String name;
    private String surName;
    private List<String> attacks;

    public AnimeCharacters() {
    }

    public AnimeCharacters(String name, String surName, List<String> attacks) {
        this.name = name;
        this.surName = surName;
        this.attacks = attacks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public List<String> getAttacks() {
        return attacks;
    }

    public void setAttacks(List<String> attacks) {
        this.attacks = attacks;
    }
}

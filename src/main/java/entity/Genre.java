package entity;

/**
 * Created by Lytki on 26.03.2017.
 */
public class Genre extends Entity {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "id='" + getId() + '\'' +
                "name='" + name + '\'' +
                '}';
    }
}

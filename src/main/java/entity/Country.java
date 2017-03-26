package entity;

/**
 * Created by Lytki on 26.03.2017.
 */
public class Country extends Entity {
    private String countryName;

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id='" + getId() + '\'' +
                "countryName='" + countryName + '\'' +
                '}';
    }
}

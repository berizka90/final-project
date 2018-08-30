package model.entity;

import java.io.Serializable;
import java.util.Objects;

public class Activity implements Serializable {

    private Integer idActivity;
    private String name;
    private String description;

    public Integer getIdActivity() {
        return idActivity;
    }

    public String getName() {
        return name;
    }

    public void setIdActivity(Integer idActivity) {
        this.idActivity = idActivity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Activity activity = (Activity) o;
        return Objects.equals(idActivity, activity.idActivity) &&
                Objects.equals(name, activity.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Activity{" +
                "idActivity=" + idActivity +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

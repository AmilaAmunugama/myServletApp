package DTO;

import java.util.Objects;

/**
 * by Amila
 * on 3/5/2016.
 */
public class UserData {

    private Integer id;
    private String name;

    public UserData() {
    }

    public UserData(String id, String name) {
        if (id != null) {
            this.id = Integer.parseInt(id);
        }
        if (name != null) {
            this.name = name;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        StringBuilder stringBuffer = new StringBuilder("");
        if (!Objects.isNull(id)) {
            stringBuffer.append("id -> ").append(id).append(" ");
        }
        if (!Objects.isNull(name)) {
            stringBuffer.append("name -> ").append(name).append(" ");
        }
        return stringBuffer.toString();
    }
}


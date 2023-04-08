package backendportafolio.repository.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "roles", schema = "backendDB", catalog = "")
public class RolesEntity {
    private int rolId;
    private String userId;
    private String permisions;

    @Id
    @Column(name = "rolId")
    public int getRolId() {
        return rolId;
    }

    public void setRolId(int rolId) {
        this.rolId = rolId;
    }

    @Basic
    @Column(name = "userId")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "permisions")
    public String getPermisions() {
        return permisions;
    }

    public void setPermisions(String permisions) {
        this.permisions = permisions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RolesEntity that = (RolesEntity) o;

        if (rolId != that.rolId) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (permisions != null ? !permisions.equals(that.permisions) : that.permisions != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rolId;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (permisions != null ? permisions.hashCode() : 0);
        return result;
    }
}

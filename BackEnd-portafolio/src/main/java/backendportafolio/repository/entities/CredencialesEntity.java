package backendportafolio.repository.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "credenciales", schema = "backendDB", catalog = "")
public class CredencialesEntity {
    private int credenialId;
    private String credential;
    private String userId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "credenial_id")
    public int getCredenialId() {
        return credenialId;
    }

    public void setCredenialId(int credenialId) {
        this.credenialId = credenialId;
    }

    @Basic
    @Column(name = "credential")
    public String getCredential() {
        return credential;
    }

    public void setCredential(String credential) {
        this.credential = credential;
    }

    @Basic
    @Column(name = "user_id")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CredencialesEntity that = (CredencialesEntity) o;

        if (credenialId != that.credenialId) return false;
        if (credential != null ? !credential.equals(that.credential) : that.credential != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = credenialId;
        result = 31 * result + (credential != null ? credential.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        return result;
    }
}

package backendportafolio.repository.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "administradores", schema = "backendDB", catalog = "")
public class AdministradoresEntity {
    private int adminId;
    private String nameLastName;
    private String email;
    private String idCredenciales;
    private String rol;

    @Id
    @Column(name = "adminId")
    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    @Basic
    @Column(name = "Name_LastName")
    public String getNameLastName() {
        return nameLastName;
    }

    public void setNameLastName(String nameLastName) {
        this.nameLastName = nameLastName;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "id_credenciales")
    public String getIdCredenciales() {
        return idCredenciales;
    }

    public void setIdCredenciales(String idCredenciales) {
        this.idCredenciales = idCredenciales;
    }

    @Basic
    @Column(name = "rol")
    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AdministradoresEntity that = (AdministradoresEntity) o;

        if (adminId != that.adminId) return false;
        if (nameLastName != null ? !nameLastName.equals(that.nameLastName) : that.nameLastName != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (idCredenciales != null ? !idCredenciales.equals(that.idCredenciales) : that.idCredenciales != null)
            return false;
        if (rol != null ? !rol.equals(that.rol) : that.rol != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = adminId;
        result = 31 * result + (nameLastName != null ? nameLastName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (idCredenciales != null ? idCredenciales.hashCode() : 0);
        result = 31 * result + (rol != null ? rol.hashCode() : 0);
        return result;
    }
}

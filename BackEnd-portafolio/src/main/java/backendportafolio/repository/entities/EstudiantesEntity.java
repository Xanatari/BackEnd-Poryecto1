package backendportafolio.repository.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "estudiantes", schema = "backendDB", catalog = "")
public class EstudiantesEntity {
    private int estudiantesId;
    private String email;
    private String especialidad;
    private String facultad;
    private String idCredenciales;
    private String nameLastName;
    private String rol;

    @OneToMany(mappedBy = "estudiante", cascade = CascadeType.ALL)
    private List<PruebasEntity> pruebas;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "estudiantes_id")
    public int getEstudiantesId() {
        return estudiantesId;
    }

    public void setEstudiantesId(int estudiantesId) {
        this.estudiantesId = estudiantesId;
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
    @Column(name = "especialidad")
    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    @Basic
    @Column(name = "facultad")
    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
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
    @Column(name = "name_last_name")
    public String getNameLastName() {
        return nameLastName;
    }

    public void setNameLastName(String nameLastName) {
        this.nameLastName = nameLastName;
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

        EstudiantesEntity that = (EstudiantesEntity) o;

        if (estudiantesId != that.estudiantesId) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (especialidad != null ? !especialidad.equals(that.especialidad) : that.especialidad != null) return false;
        if (facultad != null ? !facultad.equals(that.facultad) : that.facultad != null) return false;
        if (idCredenciales != null ? !idCredenciales.equals(that.idCredenciales) : that.idCredenciales != null)
            return false;
        if (nameLastName != null ? !nameLastName.equals(that.nameLastName) : that.nameLastName != null) return false;
        if (rol != null ? !rol.equals(that.rol) : that.rol != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = estudiantesId;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (especialidad != null ? especialidad.hashCode() : 0);
        result = 31 * result + (facultad != null ? facultad.hashCode() : 0);
        result = 31 * result + (idCredenciales != null ? idCredenciales.hashCode() : 0);
        result = 31 * result + (nameLastName != null ? nameLastName.hashCode() : 0);
        result = 31 * result + (rol != null ? rol.hashCode() : 0);
        return result;
    }
}

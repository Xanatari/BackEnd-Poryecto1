package backendportafolio.repository.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "pruebas", schema = "backendDB", catalog = "")
public class PruebasEntity {
    private int pruebasid;
    private String complegidad;
    private String contenido;
    private String descripcionPrueba;
    private String especialidad;
    private Integer estudianteId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pruebasid")
    public int getPruebasid() {
        return pruebasid;
    }

    public void setPruebasid(int pruebasid) {
        this.pruebasid = pruebasid;
    }

    @Basic
    @Column(name = "complegidad")
    public String getComplegidad() {
        return complegidad;
    }

    public void setComplegidad(String complegidad) {
        this.complegidad = complegidad;
    }

    @Basic
    @Column(name = "contenido")
    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    @Basic
    @Column(name = "descripcion_prueba")
    public String getDescripcionPrueba() {
        return descripcionPrueba;
    }

    public void setDescripcionPrueba(String descripcionPrueba) {
        this.descripcionPrueba = descripcionPrueba;
    }

    @Basic
    @Column(name = "especialidad")
    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PruebasEntity that = (PruebasEntity) o;

        if (pruebasid != that.pruebasid) return false;
        if (complegidad != null ? !complegidad.equals(that.complegidad) : that.complegidad != null) return false;
        if (contenido != null ? !contenido.equals(that.contenido) : that.contenido != null) return false;
        if (descripcionPrueba != null ? !descripcionPrueba.equals(that.descripcionPrueba) : that.descripcionPrueba != null)
            return false;
        if (especialidad != null ? !especialidad.equals(that.especialidad) : that.especialidad != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = pruebasid;
        result = 31 * result + (complegidad != null ? complegidad.hashCode() : 0);
        result = 31 * result + (contenido != null ? contenido.hashCode() : 0);
        result = 31 * result + (descripcionPrueba != null ? descripcionPrueba.hashCode() : 0);
        result = 31 * result + (especialidad != null ? especialidad.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "estudianteId")
    public Integer getEstudianteId() {
        return estudianteId;
    }

    public void setEstudianteId(Integer estudianteId) {
        this.estudianteId = estudianteId;
    }
}

package backendportafolio.repository.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "pruebas", schema = "backendDB", catalog = "")
public class PruebasEntity {
    private int pruebasId;
    private String descripcionPrueba;
    private String contenido;
    private String especialidad;
    private String complegidad;

    @Id
    @Column(name = "pruebasID")
    public int getPruebasId() {
        return pruebasId;
    }

    public void setPruebasId(int pruebasId) {
        this.pruebasId = pruebasId;
    }

    @Basic
    @Column(name = "descripcionPrueba")
    public String getDescripcionPrueba() {
        return descripcionPrueba;
    }

    public void setDescripcionPrueba(String descripcionPrueba) {
        this.descripcionPrueba = descripcionPrueba;
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
    @Column(name = "especialidad")
    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    @Basic
    @Column(name = "complegidad")
    public String getComplegidad() {
        return complegidad;
    }

    public void setComplegidad(String complegidad) {
        this.complegidad = complegidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PruebasEntity that = (PruebasEntity) o;

        if (pruebasId != that.pruebasId) return false;
        if (descripcionPrueba != null ? !descripcionPrueba.equals(that.descripcionPrueba) : that.descripcionPrueba != null)
            return false;
        if (contenido != null ? !contenido.equals(that.contenido) : that.contenido != null) return false;
        if (especialidad != null ? !especialidad.equals(that.especialidad) : that.especialidad != null) return false;
        if (complegidad != null ? !complegidad.equals(that.complegidad) : that.complegidad != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = pruebasId;
        result = 31 * result + (descripcionPrueba != null ? descripcionPrueba.hashCode() : 0);
        result = 31 * result + (contenido != null ? contenido.hashCode() : 0);
        result = 31 * result + (especialidad != null ? especialidad.hashCode() : 0);
        result = 31 * result + (complegidad != null ? complegidad.hashCode() : 0);
        return result;
    }
}

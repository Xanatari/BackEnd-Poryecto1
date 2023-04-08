package backendportafolio.repository.entities;

import jakarta.persistence.*;
@Entity
@Table(name = "resulados", schema = "backendDB", catalog = "")
public class ResuladosEntity {
    private int resuladoId;
    private String codigoId;
    private String resultado;
    private String comentariosDocente;
    private String especialidad;

    @Id
    @Column(name = "resuladoId")
    public int getResuladoId() {
        return resuladoId;
    }

    public void setResuladoId(int resuladoId) {
        this.resuladoId = resuladoId;
    }

    @Basic
    @Column(name = "codigoId")
    public String getCodigoId() {
        return codigoId;
    }

    public void setCodigoId(String codigoId) {
        this.codigoId = codigoId;
    }

    @Basic
    @Column(name = "resultado")
    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    @Basic
    @Column(name = "comentariosDocente")
    public String getComentariosDocente() {
        return comentariosDocente;
    }

    public void setComentariosDocente(String comentariosDocente) {
        this.comentariosDocente = comentariosDocente;
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

        ResuladosEntity that = (ResuladosEntity) o;

        if (resuladoId != that.resuladoId) return false;
        if (codigoId != null ? !codigoId.equals(that.codigoId) : that.codigoId != null) return false;
        if (resultado != null ? !resultado.equals(that.resultado) : that.resultado != null) return false;
        if (comentariosDocente != null ? !comentariosDocente.equals(that.comentariosDocente) : that.comentariosDocente != null)
            return false;
        if (especialidad != null ? !especialidad.equals(that.especialidad) : that.especialidad != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = resuladoId;
        result = 31 * result + (codigoId != null ? codigoId.hashCode() : 0);
        result = 31 * result + (resultado != null ? resultado.hashCode() : 0);
        result = 31 * result + (comentariosDocente != null ? comentariosDocente.hashCode() : 0);
        result = 31 * result + (especialidad != null ? especialidad.hashCode() : 0);
        return result;
    }
}

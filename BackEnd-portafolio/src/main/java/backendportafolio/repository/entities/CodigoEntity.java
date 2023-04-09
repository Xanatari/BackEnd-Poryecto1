package backendportafolio.repository.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "codigo", schema = "backendDB", catalog = "")
public class CodigoEntity {
    private int codigoId;
    private String codigo;
    private String resultado;
    private String comentariosDocente;
    private String especialidad;
    private String analizis;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigoId")
    public int getCodigoId() {
        return codigoId;
    }

    public void setCodigoId(int codigoId) {
        this.codigoId = codigoId;
    }

    @Basic
    @Column(name = "codigo")
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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

    @Basic
    @Column(name = "analizis")
    public String getAnalizis() {
        return analizis;
    }

    public void setAnalizis(String analizis) {
        this.analizis = analizis;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CodigoEntity that = (CodigoEntity) o;

        if (codigoId != that.codigoId) return false;
        if (codigo != null ? !codigo.equals(that.codigo) : that.codigo != null) return false;
        if (resultado != null ? !resultado.equals(that.resultado) : that.resultado != null) return false;
        if (comentariosDocente != null ? !comentariosDocente.equals(that.comentariosDocente) : that.comentariosDocente != null)
            return false;
        if (especialidad != null ? !especialidad.equals(that.especialidad) : that.especialidad != null) return false;
        if (analizis != null ? !analizis.equals(that.analizis) : that.analizis != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = codigoId;
        result = 31 * result + (codigo != null ? codigo.hashCode() : 0);
        result = 31 * result + (resultado != null ? resultado.hashCode() : 0);
        result = 31 * result + (comentariosDocente != null ? comentariosDocente.hashCode() : 0);
        result = 31 * result + (especialidad != null ? especialidad.hashCode() : 0);
        result = 31 * result + (analizis != null ? analizis.hashCode() : 0);
        return result;
    }
}

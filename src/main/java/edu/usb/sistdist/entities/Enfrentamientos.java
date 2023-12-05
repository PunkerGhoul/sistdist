/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.usb.sistdist.entities;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author PunkerGhoul
 */
@Entity
@Table(name = "enfrentamientos")
@NamedQueries({
    @NamedQuery(name = "Enfrentamientos.findAll", query = "SELECT e FROM Enfrentamientos e"),
    @NamedQuery(name = "Enfrentamientos.findById", query = "SELECT e FROM Enfrentamientos e WHERE e.id = :id"),
    @NamedQuery(name = "Enfrentamientos.findByEquipoLocal", query = "SELECT e FROM Enfrentamientos e WHERE e.equipoLocal = :equipoLocal"),
    @NamedQuery(name = "Enfrentamientos.findByEquipoVisitante", query = "SELECT e FROM Enfrentamientos e WHERE e.equipoVisitante = :equipoVisitante"),
    @NamedQuery(name = "Enfrentamientos.findByFecha", query = "SELECT e FROM Enfrentamientos e WHERE e.fecha = :fecha"),
    @NamedQuery(name = "Enfrentamientos.findByResultado", query = "SELECT e FROM Enfrentamientos e WHERE e.resultado = :resultado")})
public class Enfrentamientos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "equipo_local")
    private int equipoLocal;
    @Basic(optional = false)
    @Column(name = "equipo_visitante")
    private int equipoVisitante;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "resultado")
    private String resultado;

    public Enfrentamientos() {
    }

    public Enfrentamientos(Integer id) {
        this.id = id;
    }

    public Enfrentamientos(Integer id, int equipoLocal, int equipoVisitante, Date fecha) {
        this.id = id;
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.fecha = fecha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getEquipoLocal() {
        return equipoLocal;
    }

    public void setEquipoLocal(int equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    public int getEquipoVisitante() {
        return equipoVisitante;
    }

    public void setEquipoVisitante(int equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Enfrentamientos)) {
            return false;
        }
        Enfrentamientos other = (Enfrentamientos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.usb.sistdist.entities.Enfrentamientos[ id=" + id + " ]";
    }
    
}

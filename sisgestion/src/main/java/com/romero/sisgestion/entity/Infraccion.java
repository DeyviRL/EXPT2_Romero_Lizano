package com.romero.sisgestion.entity;

import java.sql.Date;
import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name="infracciones")

public class Infraccion {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id")
	    private Integer id;

	    @Column(name = "dni", nullable = false, length = 8)
	    private String dni;

	    @Column(name = "fecha", nullable = false)
	    private LocalDateTime fecha;

	    @Column(name = "placa", nullable = false, length = 7)
	    private String placa;

	    @Column(name = "infraccion", nullable = false, length = 200)
	    private String infraccion;

	    @Column(name = "descripcion", length = 255)
	    private String descripcion;

}

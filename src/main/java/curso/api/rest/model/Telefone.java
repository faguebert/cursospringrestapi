package curso.api.rest.model;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Telefone {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String numero;
	
	@ManyToOne
	@JoinColumn(name="usuario",nullable=false, foreignKey = @ForeignKey (name = "usuario_id"))
	private Usuario usuario;
}

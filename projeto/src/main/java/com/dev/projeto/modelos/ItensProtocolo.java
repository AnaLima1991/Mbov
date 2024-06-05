package com.dev.projeto.modelos;

	import java.io.Serializable;
	import java.util.Date;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


	@Entity
	@Table(name = "itens_protocolo")
	public class ItensProtocolo implements Serializable {

		public ItensProtocolo() {
			super();
		}

		private static final long serialVersionUID = 1L;
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Long id;
		@Temporal(TemporalType.TIMESTAMP)
		private Date dataManejo;

	

		@ManyToOne
		private Protocolo protocolo;
	
		@ManyToOne
		private Insumo insumo= new Insumo();
		
		private String nomeDia;
		

	
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Date getDataManejo() {
			return dataManejo;
		}

		public void setDataManejo(Date dataManejo) {
			this.dataManejo = dataManejo;
		}

		public Protocolo getProtocolo() {
			return protocolo;
		}

		public void setProtocolo(Protocolo protocolo) {
			this.protocolo = protocolo;
		}

		public Insumo getInsumo() {
			return insumo;
		}

		public void setInsumo(Insumo insumo) {
			this.insumo = insumo;
		}

		public String getNomeDia() {
			return nomeDia;
		}

		public void setNomeDia(String nomeDia) {
			this.nomeDia = nomeDia;
		}
		

		

		


}

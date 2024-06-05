package com.dev.projeto.modelos;

	import java.io.Serializable;
	import java.util.Date;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


	@Entity
	@Table(name = "itens_lote")
	public class ItensLote implements Serializable {

		public ItensLote() {
			super();
		}

		private static final long serialVersionUID = 1L;
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Long id;

	

		@ManyToOne
		private Lote lote;
		@ManyToOne
		private Bovino bovino;

		public Lote getLote() {
			return lote;
		}

		public Bovino getBovino() {
			return bovino;
		}

		public void setBovino(Bovino bovino) {
			this.bovino = bovino;
		}

		private int quantidade=1;
		

		
		

		
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		

		public void setLote(Lote lote) {
			this.lote = lote;
		}

		public int getQuantidade() {
			
			return quantidade;
		}

		public void setQuantidade(Integer quantidade) {
			this.quantidade = quantidade;
		}



}

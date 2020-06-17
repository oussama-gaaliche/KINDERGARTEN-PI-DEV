package tn.esprit.spring.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum FamilleArticles {
	
	Livres_scolaires{

		@Override
		public String getCode() {
			// TODO Auto-generated method stub
			return "Livres scolaires";
		}
	},
	Jeux{

		@Override
		public String getCode() {
			// TODO Auto-generated method stub
			return "Jeux";
		}
	},
	Equipement_de_la_classe{

		@Override
		public String getCode() {
			// TODO Auto-generated method stub
			return "Equipement de la classe";
		}
	};
	
	public abstract String getCode();
	
}

package tn.esprit.spring.entity;

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

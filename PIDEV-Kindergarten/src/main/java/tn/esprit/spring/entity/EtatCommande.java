package tn.esprit.spring.entity;

public enum EtatCommande {
	EnAttente{

		@Override
		public String getCode() {
			// TODO Auto-generated method stub
			return "En Attente";
		}
		
	},
	EnCoursLivraison{

		@Override
		public String getCode() {
			// TODO Auto-generated method stub
			return "Votre commande est en cours d'expedition";
		}
		
	},
	Expediée{

		@Override
		public String getCode() {
			// TODO Auto-generated method stub
			return "votre commande est expediée.";
		}
		
	},
	EnPreparation{

		@Override
		public String getCode() {
			// TODO Auto-generated method stub
			return "Nous avons bien enregistré votre commande et celle ci en preparation.Tous les articles commandés sont en stock et vous devriez etre notifié de leur expedition dans les prochaines 48 heures";
		}
		
	};
	public abstract String getCode();
}

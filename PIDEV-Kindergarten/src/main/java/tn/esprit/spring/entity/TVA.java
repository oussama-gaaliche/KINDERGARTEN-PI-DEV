package tn.esprit.spring.entity;

public enum TVA {
	TVA_7{

		@Override
		public int getCode() {
			// TODO Auto-generated method stub
			return 7;
		}
	
	},
	TVA_13{

		@Override
		public int getCode() {
			// TODO Auto-generated method stub
			return 13;
		}
	
	},
	TVA_19{

		@Override
		public int getCode() {
			// TODO Auto-generated method stub
			return 19;
		}
	
	};

	public abstract int getCode();
	

}

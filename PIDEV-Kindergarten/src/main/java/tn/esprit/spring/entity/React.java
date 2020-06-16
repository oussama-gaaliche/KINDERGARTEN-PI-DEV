package tn.esprit.spring.entity;

public enum React { 
	NONE(1), LIKE(2), LOVE(3), WOW(4), HAHA(5), SAD(6), ANGRY(7);
	private int code;
    
    React(int code) {
        this.code = code;
    }
 
    public int getCode() {
        return code;
    }

}

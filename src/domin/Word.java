package domin;

public class Word {
	private int word_pk;
	private int voca_fk;
	private String word;
	private String mean;
	
	public int getWord_pk() {
		return word_pk;
	}
	public void setWord_pk(int word_pk) {
		this.word_pk = word_pk;
	}
	public int getVoca_fk() {
		return voca_fk;
	}
	public void setVoca_fk(int voca_fk) {
		this.voca_fk = voca_fk;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public String getMean() {
		return mean;
	}
	public void setMean(String mean) {
		this.mean = mean;
	}
	
}

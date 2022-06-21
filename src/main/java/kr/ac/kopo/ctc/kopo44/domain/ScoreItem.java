package kr.ac.kopo.ctc.kopo44.domain;

import java.util.Objects;

public class ScoreItem {

	private String name;
	private int studentid;
	private int kor;
	private int eng;
	private int mat;

	public ScoreItem(String name, int studentid, int kor, int eng, int mat) {
		super();
		this.name = name;
		this.studentid = studentid;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}
	
	public ScoreItem() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStudentid() {
		return studentid;
	}

	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMat() {
		return mat;
	}

	public void setMat(int mat) {
		this.mat = mat;
	}

	@Override
	public int hashCode() {
		return Objects.hash(studentid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ScoreItem other = (ScoreItem) obj;
		return studentid == other.studentid;
	}

	@Override
	public String toString() {
		return "ScoreItem [name=" + name + ", studentid=" + studentid + ", kor=" + kor + ", eng=" + eng + ", mat=" + mat
				+ "]";
	}


}

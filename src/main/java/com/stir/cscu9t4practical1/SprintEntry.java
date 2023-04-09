package com.stir.cscu9t4practical1;

public class SprintEntry extends Entry {

	private int Recovery;
	private int Repetitions;

	public SprintEntry(String n, int GetRecovery, int Repetitions,  int d, int m, int y, int h, int min, int s,float dist) {

		super(n, d, m, y, h, min, s, dist);
		this.Recovery = GetRecovery;
		this.Repetitions = Repetitions;
	}

	public int getRecovery() {
		return Recovery;
	}

	public void setRecovery(int recovery) {
		this.Recovery = recovery;
	}

	public int getRepetitions() {
		return Repetitions;
	}

	public void setRepetitions(int repetitions) {
		this.Repetitions = repetitions;
	}
}
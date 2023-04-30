package dao;

import model.FloMemb;

public interface MembDao {
	public FloMemb findMemb(FloMemb fmb);
	public void insertMemb(FloMemb fmb);
}

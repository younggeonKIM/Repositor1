package dao;

import java.util.List;

import model.FloSort;

public interface SortDao {
	public List<FloSort> getAllFloName();
	public List<FloSort> getFloMGSN(String name);
	public Integer floMGSNno(String name);
	public FloSort getFloDetail (FloSort fst);
}

package dao;

import java.util.List;

import model.FloSort;
import model.Present;

public interface PresDao {
	public List<String> getFloMsg();
	public List<FloSort> getFloDetByMsg(Present pst);
}

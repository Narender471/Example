package in.bhel.dao;

import in.bhel.entity.CableStore;

public interface CableStoreDao {
	
	public boolean insertDrumToStore(CableStore cs);
	public String updateDateByDb(double dbNo, String date);
	public String updateUniqueCode();

}

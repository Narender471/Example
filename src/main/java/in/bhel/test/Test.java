package in.bhel.test;

import in.bhel.dao.CableStoreDao;
import in.bhel.dao.impl.CableStoreImpl;
import in.bhel.entity.CableStore;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("hello");
		CableStore cs = new CableStore();
		CableStoreDao csd = new CableStoreImpl();
		System.out.println(csd.updateDateByDb(458,"2023-01-05"));

	}

}

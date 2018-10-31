package witsmlTest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import witsmlTest.model.Well2;


@Component
public class WellService {

	private static List<Well2> wells = new ArrayList<>();

	static {
		//Initialize Data
		Well2 well10 = new Well2("BHI");
		Well2 well100 = new Well2("SC");
		Well2 well1000 = new Well2("Apple");
		
		wells.add(well10);
		wells.add(well100);
		wells.add(well1000);
	}
	
	public Well2 getFromStore(String wid)
	{
		for (Well2 well : wells) {
			if (well.getUid().equals(wid)) {
				return well;
			}
		}
		return null;
	}
	
	public Well2 addToStore(String wid)
	{
		Well2 addwell= new Well2("HP");
		wells.add(addwell);
		return addwell;
	}
	
	
	public Well2 updateInStore(String wid, String newId)
	{
		Well2 theWell=null;
		for (Well2 well : wells) {
			if (well.getUid().equals(wid)) {
				well.setUid(newId);
				theWell=well;
				break;
			}
		}
		return theWell;
	}
	
	public void deleteFromStore(String wid)
	{
	
		for(int i=0;i<=wells.size();i++)
	    {
			if (wells.get(i).getUid().equals(wid)) {
				wells.remove(i);				
				break;
			}
		}
	}
	
}


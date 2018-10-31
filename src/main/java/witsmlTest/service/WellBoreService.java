package witsmlTest.service;

import java.util.ArrayList;
import java.util.List;

import witsmlTest.model.Well2;
import witsmlTest.model.WellBore;

public class WellBoreService {
		
		private static List<WellBore> wellbores = new ArrayList<>();
		static {
			//Initialize Data
			WellBore wellbore10 = new WellBore("10");
			WellBore wellbore100 = new WellBore("100");
			WellBore wellbor1000 = new WellBore("1000");
			
			wellbores.add(wellbore10);
			wellbores.add(wellbore100);
			wellbores.add(wellbor1000);
		}

		public WellBore getFromStore(String wid)
		{
			for (WellBore wellbore : wellbores) {
				if (wellbore.getWellBoreId().equals(wid)) {
					return wellbore;
				}
			}
			return null;
		}
		
		public WellBore addToStore(String wid)
		{
			WellBore addwellbore= new WellBore("20");
			wellbores.add(addwellbore);
			return addwellbore;
		}
		
		public WellBore updateInStore(String wid, String newId)
		{
			WellBore theWell=null;
			for (WellBore well : wellbores) {
				if (well.getWellBoreId().equals(wid)) {
					well.setWellBoreId(newId);
					theWell=well;
					break;
				}
			}
			return theWell;
		}
		
		public void deleteFromStore(String wid)
		{
		
			for(int i=0;i<=wellbores.size();i++)
		    {
				if (wellbores.get(i).getWellBoreId().equals(wid)) {
					wellbores.remove(i);				
					break;
				}
			}
		}
}

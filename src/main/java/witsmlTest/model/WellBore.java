package witsmlTest.model;

public class WellBore {
	
	public String id;
	public WellBore(String wbid){
		id=wbid;
	}
	public String getWellBoreId(){
		return id;
	}
	public void setWellBoreId(String id){
		id=id;
	}
	
	@Override
	public String toString() {
		return String.format(
				"WellBore [wbid=%s]", id);
	}
}

package witsmlTest.model;

import java.io.Serializable;


/**
 * @author cathychen
 * This is mocked Well2 for testing. 
 */
public class Well2 implements Serializable{
	private String company=null;
	public  Well2(String company){
		  super();
		  company=company;
	}
    public String getUid(){
    	return company;
    }
    public void setUid(String id){
    	this.company=id;
    }	
    @Override
	public String toString() {
		return String.format(
				"Well [id=%s]", company);
	}
}


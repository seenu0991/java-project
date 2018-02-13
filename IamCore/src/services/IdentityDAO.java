package services;

import java.util.List;

import datamodel.Identity;



public interface IdentityDAO {

	public void create(Identity identity);

	public void update(Identity identity);

	public void delete(Identity identity);

	public List<Identity> search(Identity criteria);



	
}

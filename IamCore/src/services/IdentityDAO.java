package services;

import java.util.List;

import datamodel.Identity;
import exception.DaoCreateException;




public interface IdentityDAO {

	public void create(Identity identity) throws DaoCreateException;

	public void update(Identity identity);

	public void delete(Identity identity);

	public List<Identity> search(Identity criteria);



	
}

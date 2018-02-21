package services;

import java.util.List;

import datamodel.Identity;
import exception.DaoCreateException;
import exception.DaoDeleteException;
import exception.DaoUpdateException;

public interface IdentityDAO {

	public void create(Identity identity) throws DaoCreateException;

	public void update(Identity identity) throws DaoUpdateException;

	public void delete(Identity identity) throws DaoDeleteException;

	public List<Identity> search(Identity criteria);

}

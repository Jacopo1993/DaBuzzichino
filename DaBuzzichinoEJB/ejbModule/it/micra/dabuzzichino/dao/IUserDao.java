package it.micra.dabuzzichino.dao;

import java.util.List;

import it.micra.dabuzzichino.model.User;

public interface IUserDao {

	boolean login(String username, String password) throws Exception;

	List<User> getUsers(String username) throws Exception;

}

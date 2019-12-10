// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 * TEMPLATE:    SpringServiceImpl.vsl in andromda-spring cartridge
 * MODEL CLASS: AndroMDAModel::rofile::bw.co.roguesystems.rofile::user::service::UserService
 * STEREOTYPE:  Service
 */
package bw.co.roguesystems.rofile.user.service;

import bw.co.roguesystems.rofile.role.vo.RoleSearchCriteria;
import bw.co.roguesystems.rofile.user.User;
import bw.co.roguesystems.rofile.user.vo.UserDetailsVO;
import bw.co.roguesystems.rofile.user.vo.UserSearchCriteria;

import java.util.Collection;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @see bw.co.roguesystems.rofile.user.service.UserService
 */
@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
@Service("userService")
public class UserServiceImpl
    extends UserServiceBase
{

    /**
     * @see bw.co.roguesystems.rofile.user.service.UserService#findById(Long)
     */
    @Override
    protected  UserDetailsVO handleFindById(Long id)
        throws Exception
    {
    	UserDetailsVO userVO = null;
    	
    	if(id != null) {
    		userVO = getUserDao().toUserDetailsVO(getUserDao().load(id));
    	}
    	
    	return userVO;
    }

    /**
     * @see bw.co.roguesystems.rofile.user.service.UserService#getAllUsers()
     */
    @Override
    protected  Collection<UserDetailsVO> handleGetAllUsers()
        throws Exception
    {
    	return getUserDao().toUserDetailsVOCollection(getUserDao().loadAll());
    }

    /**
     * @see bw.co.roguesystems.rofile.user.service.UserService#deleteUser(UserDetailsVO)
     */
    @Override
    protected  void handleDeleteUser(Long id)
        throws Exception
    {
    	if(id != null)
    	{
    		getUserDao().remove(id);
    	}
    }

    /**
     * @see bw.co.roguesystems.rofile.user.service.UserService#saveUser(UserDetailsVO)
     */
    @Override
    protected  UserDetailsVO handleSaveUser(UserDetailsVO userDetailsVO)
        throws Exception
    {
        User user = getUserDao().userDetailsVOToEntity(userDetailsVO);
        user = getUserDao().createOrUpdate(user);        
        return getUserDao().toUserDetailsVO(user);
    }

    /**
     * @see bw.co.roguesystems.rofile.user.service.UserService#searchUsers(RoleSearchCriteria)
     */
    @Override
    protected  Collection<UserDetailsVO> handleSearchUsers(UserSearchCriteria searchCriteria)
        throws Exception
    {
    	Collection<User> users = getUserDao().findByCriteria(searchCriteria);
    	
    	for(User user : users) {
    		user.getUploadedFiles();
    		user.getRoles();
    		user.getOtherFiles();
    	}
    	
    	return getUserDao().toUserDetailsVOCollection(users);
    }

    /**
     * @see bw.co.roguesystems.rofile.user.service.UserService#userLogin(String, String)
     */
    @Override
    protected  UserDetailsVO handleUserLogin(String username, String password)
        throws Exception
    {
    	return getUserDao().toUserDetailsVO(getUserDao().userLogin(username, password));
    }

}
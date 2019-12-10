// Generated by hibernate/SpringHibernateDaoImpl.vsl in andromda-spring-cartridge on 08/16/2019 15:10:20+0100.
// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 */
package bw.co.roguesystems.rofile.user;

import bw.co.roguesystems.rofile.rfile.RFile;
import bw.co.roguesystems.rofile.rfile.vo.RFileVO;
import bw.co.roguesystems.rofile.role.Role;
import bw.co.roguesystems.rofile.role.vo.RoleVO;
import bw.co.roguesystems.rofile.user.vo.UserDetailsVO;
import bw.co.roguesystems.rofile.user.vo.UserSearchCriteria;
import bw.co.roguesystems.rofile.user.vo.UserVO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.NonUniqueResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

/**
 * @see User
 */
@Repository("userDao")
public class UserDaoImpl
    extends UserDaoBase
{
    /**
     * {@inheritDoc}
     */
    @Override
    protected Collection<User> handleFindByCriteria(UserSearchCriteria searchCriteria)
    {
        // TODO implement public Collection<User> handleFindByCriteria(UserSearchCriteria searchCriteria)
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void toUserVO(
        User source,
        UserVO target)
    {
        // TODO verify behavior of toUserVO
        super.toUserVO(source, target);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserVO toUserVO(final User entity)
    {
        // TODO verify behavior of toUserVO
        return super.toUserVO(entity);
    }

    /**
     * Retrieves the entity object that is associated with the specified value object
     * from the object store. If no such entity object exists in the object store,
     * a new, blank entity is created
     */
    private User loadUserFromUserVO(UserVO userVO)
    {
        User user = User.Factory.newInstance();
        if(userVO.getId() != null)
        {
        	user = this.load(userVO.getId());
        }
        
        return user;
    }

    /**
     * {@inheritDoc}
     */
    public User userVOToEntity(UserVO userVO)
    {
        // TODO verify behavior of userVOToEntity
        User entity = this.loadUserFromUserVO(userVO);
        this.userVOToEntity(userVO, entity, true);
        return entity;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void userVOToEntity(
        UserVO source,
        User target,
        boolean copyIfNull)
    {
        // TODO verify behavior of userVOToEntity
        super.userVOToEntity(source, target, copyIfNull);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void toUserDetailsVO(
        User source,
        UserDetailsVO target)
    {
        // TODO verify behavior of toUserDetailsVO
        super.toUserDetailsVO(source, target);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserDetailsVO toUserDetailsVO(final User entity)
    {
        // TODO verify behavior of toUserDetailsVO
        return super.toUserDetailsVO(entity);
    }

    /**
     * Retrieves the entity object that is associated with the specified value object
     * from the object store. If no such entity object exists in the object store,
     * a new, blank entity is created
     */
    private User loadUserFromUserDetailsVO(UserDetailsVO userDetailsVO)
    {
    	
        return this.loadUserFromUserVO(userDetailsVO);
    }

    /**
     * {@inheritDoc}
     */
    public User userDetailsVOToEntity(UserDetailsVO userDetailsVO)
    {
        User entity = this.loadUserFromUserDetailsVO(userDetailsVO);
        this.userDetailsVOToEntity(userDetailsVO, entity, true);
        return entity;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void userDetailsVOToEntity(
        UserDetailsVO source,
        User target,
        boolean copyIfNull)
    {
        super.userDetailsVOToEntity(source, target, copyIfNull);
        target.setUploadedFiles(new ArrayList<RFile>());
        for(RFileVO file : source.getUploadedFiles())
        {
        	RFile f = getRFileDao().load(file.getId());
        	target.getUploadedFiles().add(f);
        }
        
        target.setRoles(new ArrayList<Role>());
        for(RoleVO roleVO : source.getRoles())
        {
        	Role role = getRoleDao().load(roleVO.getId());
        	target.getRoles().add(role);
        }
        
        target.setOtherFiles(new ArrayList<RFile>());
        for(RFileVO file : source.getOtherFiles())
        {
        	RFile f = getRFileDao().load(file.getId());
        	target.getOtherFiles().add(f);
        }
    }

	@Override
	protected User handleUserLogin(String username, String password) throws Exception {
		CriteriaBuilder builder = getSession().getCriteriaBuilder();
    	CriteriaQuery<User> query = builder.createQuery(User.class);
    	Root<User> root = query.from(User.class);   
		List<Predicate> predicates = new ArrayList<Predicate>();
		
		if(StringUtils.isNotEmpty(username)) {
			predicates.add(builder.equal(root.<String>get("username"), username));
		}

		TypedQuery<User> typedQuery = getSession().createQuery(query);
		User user = null;
		try {
			user = typedQuery.getSingleResult();
		} catch (NonUniqueResultException e) {
			return null;
		}
		
		return user;
	}

	@Override
	protected User handleGetUserDetails(String username) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
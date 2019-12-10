// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 * TEMPLATE:    SpringServiceImpl.vsl in andromda-spring cartridge
 * MODEL CLASS: AndroMDAModel::rofile::bw.co.roguesystems.rofile::role::service::RoleService
 * STEREOTYPE:  Service
 */
package bw.co.roguesystems.rofile.role.service;

import bw.co.roguesystems.rofile.role.Role;
import bw.co.roguesystems.rofile.role.vo.RoleSearchCriteria;
import bw.co.roguesystems.rofile.role.vo.RoleVO;

import java.util.Collection;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @see bw.co.roguesystems.rofile.role.service.RoleService
 */
@Transactional(propagation = Propagation.REQUIRED, readOnly=false)
@Service("roleService")
public class RoleServiceImpl
    extends RoleServiceBase
{

    /**
     * @see bw.co.roguesystems.rofile.role.service.RoleService#findById(Long)
     */
    @Override
    protected  RoleVO handleFindById(Long id)
        throws Exception
    {
        RoleVO roleVO = null;
        if(id != null) {
        	roleVO = getRoleDao().toRoleVO(getRoleDao().load(id));
        }
        
        return roleVO;
    }

    /**
     * @see bw.co.roguesystems.rofile.role.service.RoleService#getAllRoles()
     */
    @Override
    protected  Collection handleGetAllRoles()
        throws Exception
    {
    	Collection<Role> roles = getRoleDao().loadAll();
    	
    	for(Role role : roles)
    	{
    		Hibernate.initialize(role.getRoleFiles());
    	}
    	
        return getRoleDao().toRoleVOCollection(roles);
    }

    /**
     * @see bw.co.roguesystems.rofile.role.service.RoleService#deleteRole(RoleVO)
     */
    @Override
    protected  void handleDeleteRole(Long id)
        throws Exception
    {
        if(id != null)
        {
        	getRoleDao().remove(id);
        }
    }

    /**
     * @see bw.co.roguesystems.rofile.role.service.RoleService#saveRole(RoleVO)
     */
    @Override
    protected  RoleVO handleSaveRole(RoleVO roleVO)
        throws Exception
    {
        Role role = getRoleDao().roleVOToEntity(roleVO);
        role = getRoleDao().createOrUpdate(role);        
        return getRoleDao().toRoleVO(role);
    }

    /**
     * @see bw.co.roguesystems.rofile.role.service.RoleService#searchRoles(RoleSearchCriteria)
     */
    @Override
    protected  Collection<RoleVO> handleSearchRoles(RoleSearchCriteria searchCriteria)
        throws Exception
    {
    	Collection<Role> roles = getRoleDao().findByCriteria(searchCriteria);
    	for(Role role : roles)
    	{
    		Hibernate.initialize(role.getRoleFiles());
    	}
    	
        return getRoleDao().toRoleVOCollection(roles);
    }
}
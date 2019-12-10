// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 * TEMPLATE:    SpringServiceImpl.vsl in andromda-spring cartridge
 * MODEL CLASS: AndroMDAModel::rofile::bw.co.roguesystems.rofile::rfile::service::RFileService
 * STEREOTYPE:  Service
 */
package bw.co.roguesystems.rofile.rfile.service;

import bw.co.roguesystems.rofile.rfile.RFile;
import bw.co.roguesystems.rofile.rfile.vo.RFileSearchCriteria;
import bw.co.roguesystems.rofile.rfile.vo.RFileVO;
import bw.co.roguesystems.rofile.user.vo.UserDetailsVO;
import java.util.Collection;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @see bw.co.roguesystems.rofile.rfile.service.RFileService
 */
 @Transactional(propagation = Propagation.REQUIRED, readOnly=false)
@Service("rFileService")
public class RFileServiceImpl
    extends RFileServiceBase
{

    /**
     * @see bw.co.roguesystems.rofile.rfile.service.RFileService#findById(Long)
     */
    @Override
    protected  RFileVO handleFindById(Long id)
        throws Exception
    {
    	if(id == null)
    	{
    		return null;
    	}
    	
        RFile rfile = getRFileDao().load(id);
        Hibernate.initialize(rfile.getRegions());
        Hibernate.initialize(rfile.getOwner());
        Hibernate.initialize(rfile.getSharedWithRoles());
        Hibernate.initialize(rfile.getSharedWithUsers());
        
        return getRFileDao().toRFileVO(rfile);
    }

    /**
     * @see bw.co.roguesystems.rofile.rfile.service.RFileService#getAllRFiles()
     */
    @Override
    protected  Collection<RFileVO> handleGetAllRFiles()
        throws Exception
    {
    	Collection<RFile> rfiles = getRFileDao().loadAll();
    	
    	for(RFile rfile : rfiles)
    	{
    		Hibernate.initialize(rfile.getRegions());
    		Hibernate.initialize(rfile.getOwner());
    		Hibernate.initialize(rfile.getSharedWithRoles());
    		Hibernate.initialize(rfile.getSharedWithUsers());
    	}
    	
        return getRFileDao().toRFileVOCollection(rfiles);
    }

    /**
     * @see bw.co.roguesystems.rofile.rfile.service.RFileService#deleteRFile(Long)
     */
    @Override
    protected  void handleDeleteRFile(Long id)
        throws Exception
    {
        
    	if(id != null)
    	{
    		getRFileDao().remove(id);
    	}    	
    }

    /**
     * @see bw.co.roguesystems.rofile.rfile.service.RFileService#saveRFile(RFileVO)
     */
    @Override
    protected  RFileVO handleSaveRFile(RFileVO fileVO)
        throws Exception
    {
        RFile rfile = getRFileDao().rFileVOToEntity(fileVO);
        rfile = getRFileDao().createOrUpdate(rfile);
        return getRFileDao().toRFileVO(rfile);
    }

    /**
     * @see bw.co.roguesystems.rofile.rfile.service.RFileService#searchFiles(RFileSearchCriteria)
     */
    @Override
    protected  Collection<RFileVO> handleSearchFiles(RFileSearchCriteria searchCriteria)
        throws Exception
    {
    	Collection<RFile> files = getRFileDao().findByCriteria(searchCriteria);
    	for(RFile file : files)
    	{
    		Hibernate.initialize(file.getSharedWithUsers());
    		Hibernate.initialize(file.getSharedWithRoles());
    		Hibernate.initialize(file.getRegions());
    	}
    	
    	return getRFileDao().toRFileVOCollection(files);
    }

    /**
     * @see bw.co.roguesystems.rofile.rfile.service.RFileService#getUserFiles(UserDetailsVO)
     */
    @Override
    protected  Collection<RFileVO> handleGetUserFiles(UserDetailsVO userVO)
        throws Exception
    {
        // TODO implement protected  Collection<RFileVO> handleGetUserFiles(UserDetailsVO userVO)
        throw new UnsupportedOperationException("bw.co.roguesystems.rofile.rfile.service.RFileService.handleGetUserFiles(UserDetailsVO userVO) Not implemented!");
    }

}
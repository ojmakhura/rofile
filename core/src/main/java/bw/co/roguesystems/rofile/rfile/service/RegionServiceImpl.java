// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 * TEMPLATE:    SpringServiceImpl.vsl in andromda-spring cartridge
 * MODEL CLASS: AndroMDAModel::rofile::bw.co.roguesystems.rofile::rfile::service::RegionService
 * STEREOTYPE:  Service
 */
package bw.co.roguesystems.rofile.rfile.service;

import bw.co.roguesystems.rofile.rfile.Region;
import bw.co.roguesystems.rofile.rfile.vo.RegionSearchCriteria;
import bw.co.roguesystems.rofile.rfile.vo.RegionVO;
import java.util.Collection;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @see bw.co.roguesystems.rofile.rfile.service.RegionService
 */
 @Transactional(propagation = Propagation.REQUIRED, readOnly=false)
@Service("regionService")
public class RegionServiceImpl
    extends RegionServiceBase
{

    /**
     * @see bw.co.roguesystems.rofile.rfile.service.RegionService#findById(Long)
     */
    @Override
    protected  RegionVO handleFindById(Long id)
        throws Exception
    {
    	if(id == null)
    	{
    		return null;
    	}
    	
    	return getRegionDao().toRegionVO(getRegionDao().load(id));
    }

    /**
     * @see bw.co.roguesystems.rofile.rfile.service.RegionService#getAllRegions()
     */
    @Override
    protected  Collection<RegionVO> handleGetAllRegions()
        throws Exception
    {
    	Collection<Region> regions = getRegionDao().loadAll();
    	    	
        return getRegionDao().toRegionVOCollection(regions);
    }

    /**
     * @see bw.co.roguesystems.rofile.rfile.service.RegionService#deleteRegion(Long)
     */
    @Override
    protected  void handleDeleteRegion(Long id)
        throws Exception
    {
        if(id != null)
        {
        	getRegionDao().remove(id);
        }
    }

    /**
     * @see bw.co.roguesystems.rofile.rfile.service.RegionService#saveRegion(RegionVO)
     */
    @Override
    protected  RegionVO handleSaveRegion(RegionVO regionVO)
        throws Exception
    {
        Region region = getRegionDao().regionVOToEntity(regionVO);
        region = getRegionDao().createOrUpdate(region);
        return getRegionDao().toRegionVO(region);        
    }

    /**
     * @see bw.co.roguesystems.rofile.rfile.service.RegionService#searchFiles(RegionSearchCriteria)
     */
    @Override
    protected  Collection<RegionVO> handleSearchFiles(RegionSearchCriteria searchCriteria)
        throws Exception
    {
    	Collection<Region> regions = getRegionDao().findByCriteria(searchCriteria);
    	return getRegionDao().toRegionVOCollection(regions);
    }

}
// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 * TEMPLATE:    SpringServiceImpl.vsl in andromda-spring cartridge
 * MODEL CLASS: AndroMDAModel::rofile::bw.co.roguesystems.rofile::user::service::SercurityService
 * STEREOTYPE:  Service
 */
package bw.co.roguesystems.rofile.user.service;

import bw.co.roguesystems.rofile.user.vo.UserDetailsVO;
import org.springframework.stereotype.Service;

/**
 * @see bw.co.roguesystems.rofile.user.service.SercurityService
 */
@Service("sercurityService")
public class SercurityServiceImpl
    extends SercurityServiceBase
{

	@Override
	protected UserDetailsVO handleAutoLogin(String username, String password) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String handleFindLoggenInUsername() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
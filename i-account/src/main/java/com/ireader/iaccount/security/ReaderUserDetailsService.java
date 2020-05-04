package com.ireader.iaccount.security;

//import com.ireader.iaccount.service.AccountService;
//import com.ireader.iaccount.service.PermissionService;
import com.ireader.iaccount.service.AccountService;
import com.ireader.iaccount.service.PermissionService;
import java.util.Optional;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * UserDetailsService用于返回用户相关数据
 */
@Component
public class ReaderUserDetailsService implements UserDetailsService {

	private static final Logger logger = LoggerFactory.getLogger(ReaderUserDetailsService.class);

	@Resource
	private AccountService accountService;

	@Resource
	private PermissionService permissionService;

	@Resource
	private PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if (StringUtils.isEmpty(username)) {
			throw new UsernameNotFoundException("用户名为空");
		}
		//从数据库中取出信息
		Optional optional = null; //accountService.getAccountByLoginAccount(username);
		if (!optional.isPresent()) {
			throw new UsernameNotFoundException("用户名不存在");
		}

		String password = passwordEncoder.encode("admin");
		logger.info("login fro username {}, password{}", username, password);
		return new User(username, password,
				AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
	}
}

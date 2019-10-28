/**
 *
 */
package com.kd.core.service.impl.user;

import com.kd.core.base.BaseServiceImpl;
import com.kd.core.dao.user.UserDao;
import com.kd.core.entity.UserInfo;
import com.kd.core.service.user.UserService;

/**
 * @author glt service 实现
 */

public class UserServiceImpl extends BaseServiceImpl<UserInfo, UserDao> implements UserService {

    /**
     * 总条数
     */
    public int countUser() throws Exception {
        return 0;
    }


    public UserInfo validUser(UserInfo user) {
        return dao.validUser(user);
    }

    @Override
    public boolean updateErr(UserInfo user) {
        int result = dao.updateErr(user);
        return result > 0 ? true : false;
    }

    @Override
    public boolean delByUserId(String userId) {
        return dao.delByUserId(userId) > 0;
    }

    @Override
    public boolean update(UserInfo t) {
        int result = dao.update(t);
        return result > 0 ? true : false;
    }
}

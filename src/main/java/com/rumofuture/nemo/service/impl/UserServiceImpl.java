package com.rumofuture.nemo.service.impl;

import com.rumofuture.nemo.context.exception.NemoException;
import com.rumofuture.nemo.model.domain.User;
import com.rumofuture.nemo.model.entity.PageModel;
import com.rumofuture.nemo.repository.UserRepository;
import com.rumofuture.nemo.service.UserService;
import com.rumofuture.nemo.util.constant.NemoConst;
import com.rumofuture.nemo.util.constant.RespStatus;
import com.rumofuture.nemo.util.generator.Generator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 用户业务逻辑接口实现类
 *
 * @author 王振琦  2017/12/28
 */
@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public User register(User user) {
        User targetUser = userRepository.findOneByMobilePhoneNumber(user.getMobilePhoneNumber());
        if (null == targetUser) {
            user.setObjectId(Generator.getObjectId());
            user.setStatus(1);
            user.setEmail("");
            user.setMotto("");
            user.setProfile("");
            user.setProfession("");
            user.setLocation("");
            user.setGender("");
            user.setAge(0);
            user.setFollow(0);
            user.setFollower(0);
            user.setFavorite(0);
            user.setBook(0);
            user.setAvatar("");
            user.setPortrait("");
            LocalDateTime dateTime = LocalDateTime.now().withNano(0);
            user.setBirthday(dateTime.toLocalDate());
            user.setCreateAt(dateTime);
            user.setUpdateAt(dateTime);
            userRepository.save(user);
            return user;
        } else {
            throw new NemoException(RespStatus.USER_REGISTERED);
        }
    }

    @Override
    public User login(User user) {
        User targetUser = userRepository.findOneByMobilePhoneNumber(user.getMobilePhoneNumber());
        if (null == targetUser) {
            throw new NemoException(RespStatus.USER_UNREGISTER);
        } else {
            if (targetUser.getPassword().equals(user.getPassword())) {
                return targetUser;
            } else {
                throw new NemoException(RespStatus.USER_LOGIN_PASSWORD_ERROR);
            }
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(User user) {
        userRepository.update(user);
    }

    @Override
    public List<User> findAuthorList(Integer index) {
        PageModel pageModel = new PageModel(index, NemoConst.PageModel.Limit.USER);
        return userRepository.findAuthorList(pageModel);
    }
}

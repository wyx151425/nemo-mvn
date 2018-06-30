package com.rumofuture.nemo.repository;

import com.rumofuture.nemo.model.domain.User;
import com.rumofuture.nemo.model.entity.PageModel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户表数据映射
 *
 * @author 王振琦  2017/12/21
 */
@Mapper
@Repository(value = "userRepository")
public interface UserRepository extends NemoRepository<User, Integer> {
    /**
     * 根据用户手机号查询用户对象
     *
     * @param mobilePhoneNumber 用户手机号
     * @return 目标对象
     */
    User findOneByMobilePhoneNumber(String mobilePhoneNumber);

    /**
     * 查询漫画册作者列表
     *
     * @param pageModel 分页模型
     * @return 目标对象列表
     */
    List<User> findAuthorList(PageModel pageModel);
}

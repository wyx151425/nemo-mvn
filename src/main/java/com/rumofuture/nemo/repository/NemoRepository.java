package com.rumofuture.nemo.repository;

import com.rumofuture.nemo.model.entity.PageModel;

import java.util.List;

/**
 * 数据库映射规范
 *
 * @param <T>  目标对象的类型
 * @param <ID> 目标对象的ID类型
 * @author 王振琦  2017/12/21
 */
public interface NemoRepository<T, ID> {
    /**
     * 保存对象
     *
     * @param object 目标对象
     * @return 操作影响的行数
     */
    int save(T object);

    /**
     * 更新对象
     *
     * @param object 目标对象
     * @return 操作影响的行数
     */
    int update(T object);

    /**
     * 根据ID删除对象
     *
     * @param id 目标对象ID
     * @return 操作影响的行数
     */
    int delete(ID id);

    /**
     * 根据ID查询对象
     *
     * @param id 目标对象ID
     * @return 目标对象
     */
    T findOne(ID id);

    /**
     * 分页查询数据列表
     *
     * @param pageModel 分页模型
     * @return 目标对象列表
     */
    List<T> findList(PageModel pageModel);
}

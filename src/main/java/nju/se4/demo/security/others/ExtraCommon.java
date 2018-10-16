package nju.se4.demo.security.others;

import java.util.List;

public interface ExtraCommon <T extends Entity,U extends SecurityUserFilter>{
    /**
     * 设置变化的部分
     * @param ori 原有的实体
     * @param cur 更新的实体
     * @return 要更新的实体
     */
//    public T setChanges(T ori,T cur);

    /**
     * 筛选查找
     * @param filter 筛选器
     * @return 查询结果
     */
//    public List<T> find (U filter);
}
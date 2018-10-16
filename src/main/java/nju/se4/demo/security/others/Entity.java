package nju.se4.demo.security.others;

public abstract class Entity<T> {
    /**
     * 获取实体对象的主键
     *
     * @return id
     */
    public abstract String getPrimeKey();

    /**
     * 为了不与clone冲突产生这个方法，调用构造器实现
     *
     * @return 新的对象
     */
    public abstract T copy();
}
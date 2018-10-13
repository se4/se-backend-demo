package nju.se4.demo.util;

import nju.se4.demo.util.innerData.Abilities;
import nju.se4.demo.util.innerData.Meta;

/**
 * 封装的给前端的辅助类
 * @param <T>
 */
public class Response<T> {

    private Abilities abilities;

    private T data;

    private Meta meta;

    public Response() {
    }

    public Response(Abilities abilities, T data, Meta meta) {
        this.abilities = abilities;
        this.data = data;
        this.meta = meta;
    }

    public Response(T data, Meta meta) {
        this.data = data;
        this.meta = meta;
    }

    public Response(Abilities abilities, T data) {
        this.abilities = abilities;
        this.data = data;
    }

    public Abilities getAbilities() {
        return abilities;
    }

    public void setAbilities(Abilities abilities) {
        this.abilities = abilities;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }
}
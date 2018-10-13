package nju.se4.demo.util.innerData;

public class Abilities {
    private boolean update;

    private boolean destory;

    public Abilities() {
    }

    public Abilities(boolean update, boolean destory) {
        this.update = update;
        this.destory = destory;
    }

    public Abilities(boolean update) {
        this.update = update;
    }



    public boolean isUpdate() {
        return update;
    }

    public void setUpdate(boolean update) {
        this.update = update;
    }

    public boolean isDestory() {
        return destory;
    }

    public void setDestory(boolean destory) {
        this.destory = destory;
    }
}

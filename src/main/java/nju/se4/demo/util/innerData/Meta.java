package nju.se4.demo.util.innerData;

public class Meta {
    private boolean liked;

    private boolean followed;

    public Meta() {
    }

    public Meta(boolean liked) {
        this.liked = liked;
    }

    public Meta(boolean liked, boolean followed) {
        this.liked = liked;
        this.followed = followed;
    }

    public boolean isLiked() {
        return liked;
    }

    public void setLiked(boolean liked) {
        this.liked = liked;
    }

    public boolean isFollowed() {
        return followed;
    }

    public void setFollowed(boolean followed) {
        this.followed = followed;
    }
}

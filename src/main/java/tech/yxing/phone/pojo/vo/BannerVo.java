package tech.yxing.phone.pojo.vo;

public class BannerVo {
    private String img;
    private String link;
    private Integer managerId;

    public BannerVo(){}

    public BannerVo(String img, String link, Integer managerId) {
        this.img = img;
        this.link = link;
        this.managerId = managerId;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    @Override
    public String toString() {
        return "BannerVo{" +
                "img='" + img + '\'' +
                ", link='" + link + '\'' +
                ", managerId=" + managerId +
                '}';
    }
}

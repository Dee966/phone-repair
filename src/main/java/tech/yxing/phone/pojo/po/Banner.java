package tech.yxing.phone.pojo.po;

import tech.yxing.phone.pojo.vo.BannerVo;

public class Banner {
    private Integer bannerId;
    private String img;
    private String link;
    private Integer managerId;

    public Banner(){}

    public Banner(BannerVo bannerVo){
        this.img = bannerVo.getImg();
        this.link = bannerVo.getLink();
        this.managerId = bannerVo.getManagerId();
    }

    public Banner(Integer bannerId, String img, String link, Integer managerId) {
        this.bannerId = bannerId;
        this.img = img;
        this.link = link;
        this.managerId = managerId;
    }

    public Integer getBannerId() {
        return bannerId;
    }

    public void setBannerId(Integer bannerId) {
        this.bannerId = bannerId;
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
        return "Banner{" +
                "bannerId=" + bannerId +
                ", img='" + img + '\'' +
                ", link='" + link + '\'' +
                ", managerId=" + managerId +
                '}';
    }
}

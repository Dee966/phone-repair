package tech.yxing.phone.pojo.vo;

public class PageVo {
    private Integer page;
    private final Integer pageSize = 5;

    public PageVo(){}

    public PageVo(Integer page) {
        this.page = page;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }
}

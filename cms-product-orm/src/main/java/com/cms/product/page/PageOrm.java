package com.cms.product.page;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "t_cms_page")
public class PageOrm {

    private long id;
    private String flag;
    private String name;
    private Set<CssGroupOrm> cssGroupOrmSet;
    private Set<JsGroupOrm> jsGroupOrmSet;
    private PageFrameworkOrm pageFrameworkOrm;
    private String productPath;
    private String sourcePath;//
    private Date createTime;
    private Date updateTime;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @Cascade(value= {org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    @JoinTable(name = "t_cms_page_css_m",joinColumns={@JoinColumn(name="pageId")},inverseJoinColumns = {@JoinColumn(name = "cssId")})
    public Set<CssGroupOrm> getCssGroupOrmSet() {
        return cssGroupOrmSet;
    }

    public void setCssGroupOrmSet(Set<CssGroupOrm> cssGroupOrmSet) {
        this.cssGroupOrmSet = cssGroupOrmSet;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @Cascade(value= {org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    @JoinTable(name = "t_cms_page_js_m",joinColumns={@JoinColumn(name="pageId")},inverseJoinColumns = {@JoinColumn(name = "jsId")})
    public Set<JsGroupOrm> getJsGroupOrmSet() {
        return jsGroupOrmSet;
    }

    public void setJsGroupOrmSet(Set<JsGroupOrm> jsGroupOrmSet) {
        this.jsGroupOrmSet = jsGroupOrmSet;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    public PageFrameworkOrm getPageFrameworkOrm() {
        return pageFrameworkOrm;
    }

    public void setPageFrameworkOrm(PageFrameworkOrm pageFrameworkOrm) {
        this.pageFrameworkOrm = pageFrameworkOrm;
    }

    public String getProductPath() {
        return productPath;
    }

    public void setProductPath(String productPath) {
        this.productPath = productPath;
    }

    public String getSourcePath() {
        return sourcePath;
    }

    public void setSourcePath(String sourcePath) {
        this.sourcePath = sourcePath;
    }
}

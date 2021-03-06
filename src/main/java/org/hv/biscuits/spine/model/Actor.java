package org.hv.biscuits.spine.model;

import org.hv.biscuits.spine.AbstractBisEntity;
import org.hv.pocket.annotation.Column;
import org.hv.pocket.annotation.Entity;
import org.hv.pocket.annotation.OneToMany;

import java.util.List;

/**
 * @author wujianchuan
 */
@Entity(table = "T_ACTOR", businessName = "分工")
public class Actor extends AbstractBisEntity {

    private static final long serialVersionUID = -8229871104842779922L;
    @Column
    private String serviceId;
    @Column
    private String bundleId;
    @Column
    private String actorId;
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private Double sort;
    @OneToMany(clazz = PostActorRelation.class, bridgeField = "actorUuid")
    private List<PostActorRelation> postActorRelations;

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getBundleId() {
        return bundleId;
    }

    public void setBundleId(String bundleId) {
        this.bundleId = bundleId;
    }

    public String getActorId() {
        return actorId;
    }

    public void setActorId(String actorId) {
        this.actorId = actorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getSort() {
        return sort;
    }

    public void setSort(Double sort) {
        this.sort = sort;
    }

    public List<PostActorRelation> getPostActorRelations() {
        return postActorRelations;
    }

    public void setPostActorRelations(List<PostActorRelation> postActorRelations) {
        this.postActorRelations = postActorRelations;
    }
}

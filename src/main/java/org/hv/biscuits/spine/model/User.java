package org.hv.biscuits.spine.model;

import org.hv.biscuits.spine.AbstractBisEntity;
import org.hv.pocket.annotation.Column;
import org.hv.pocket.annotation.Entity;
import org.hv.pocket.annotation.Join;
import org.hv.pocket.annotation.OneToMany;
import org.hv.pocket.constant.JoinMethod;

import java.util.Date;
import java.util.List;

/**
 * @author leyan95 2019/1/30
 */
@Entity(table = "T_USER", businessName = "人员")
public class User extends AbstractBisEntity {
    private static final long serialVersionUID = 9034066443646846844L;
    @Column(name = "AVATAR", businessName = "昵称")
    private String avatar;
    @Column(name = "STAFF_ID", businessName = "工号/编号")
    private String staffId;
    @Column(name = "NAME", businessName = "姓名")
    private String name;
    @Column(name = "SPELL", businessName = "拼音码")
    private String spell;
    @Column(name = "PHONE", businessName = "手机号")
    private String phone;
    @Column(name = "PASSWORD", businessName = "密码")
    private String password;
    @Column(name = "SIGN_PHOTO")
    private byte[] signPhoto;
    @Column(name = "DEPT_UUID", businessName = "部门")
    private String departmentUuid;
    @Join(columnName = "DEPT_UUID", columnSurname = "DEPT_NAME", businessName = "部门名称", joinTable = "T_DEPARTMENT", joinTableSurname = "T1", joinMethod = JoinMethod.LEFT, bridgeColumn = "UUID", destinationColumn = "NAME")
    private String departmentName;
    @Join(columnName = "DEPT_UUID", columnSurname = "DEPT_SPELL", businessName = "部门拼音码", joinTable = "T_DEPARTMENT", joinTableSurname = "T1", joinMethod = JoinMethod.LEFT, bridgeColumn = "UUID", destinationColumn = "SPELL")
    private String departmentSpell;
    @Column(name = "MEMO", businessName = "备注")
    private String memo;
    @Column(name = "ENABLE", businessName = "状态")
    private Boolean enable;
    @Column(name = "SORT", businessName = "排序码")
    private Integer sort;
    @Column(name = "LAST_PASSWORD_RESET_DATE", businessName = "密码最后更新时间")
    private Date lastPasswordResetDate;
    @Column(name = "LAST_ROLE_MODIFY_DATE", businessName = "角色最后分配时间")
    private Date lastRoleModifyDate;
    @Column(name = "IS_MANAGER", businessName = "超级管理员")
    private Boolean superAdmin;

    @OneToMany(clazz = UserRoleRelation.class, bridgeField = "userUuid")
    private List<UserRoleRelation> userRoleRelations;

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getSpell() {
        return spell;
    }

    public void setSpell(String spell) {
        this.spell = spell;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public byte[] getSignPhoto() {
        return signPhoto;
    }

    public void setSignPhoto(byte[] signPhoto) {
        this.signPhoto = signPhoto;
    }

    public String getDepartmentUuid() {
        return departmentUuid;
    }

    public void setDepartmentUuid(String departmentUuid) {
        this.departmentUuid = departmentUuid;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentSpell() {
        return departmentSpell;
    }

    public void setDepartmentSpell(String departmentSpell) {
        this.departmentSpell = departmentSpell;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Date getLastPasswordResetDate() {
        return lastPasswordResetDate;
    }

    public void setLastPasswordResetDate(Date lastPasswordResetDate) {
        this.lastPasswordResetDate = lastPasswordResetDate;
    }

    public Date getLastRoleModifyDate() {
        return lastRoleModifyDate;
    }

    public void setLastRoleModifyDate(Date lastRoleModifyDate) {
        this.lastRoleModifyDate = lastRoleModifyDate;
    }

    public Boolean getSuperAdmin() {
        return superAdmin;
    }

    public void setSuperAdmin(Boolean superAdmin) {
        this.superAdmin = superAdmin;
    }

    public List<UserRoleRelation> getUserRoleRelations() {
        return userRoleRelations;
    }

    public void setUserRoleRelations(List<UserRoleRelation> userRoleRelations) {
        this.userRoleRelations = userRoleRelations;
    }
}

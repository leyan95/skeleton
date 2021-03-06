package org.hv.biscuits.spine.viewmodel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hv.biscuits.spine.model.User;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author wujianchuan
 */
public class UserView implements Serializable {
    private static final long serialVersionUID = -8764729476298658876L;
    private String uuid;
    private String avatar;
    private String name;
    private String departmentUuid;
    private String departmentName;
    private String departmentSpell;
    private Map<String, Map<String, List<UserAuthorityView>>> departmentServiceUserAuthorityViewMap;
    private String businessDepartmentUuid;
    private String businessDepartmentName;
    private String businessDepartmentSpell;
    private String stationUuid;
    private String stationCode;
    private List<String> authIds;

    public UserView() {
    }

    private UserView(String uuid, String avatar, String name, String departmentUuid, String departmentName, String departmentSpell) {
        this.uuid = uuid;
        this.avatar = avatar;
        this.name = name;
        this.departmentUuid = departmentUuid;
        this.departmentName = departmentName;
        this.departmentSpell = departmentSpell;
        this.departmentServiceUserAuthorityViewMap = new HashMap<>();
    }

    /**
     * 使用{@link User}构造实例
     *
     * @param user {@link User}
     * @return user view
     */
    public static UserView fromUser(User user) {
        return new UserView(user.getUuid(), user.getAvatar(), user.getName(), user.getDepartmentUuid(), user.getDepartmentName(), user.getDepartmentSpell());
    }

    /**
     * 添加权限信息（角色所属部门暂时不可为空）
     *
     * @param userAuthorityViews 用户权限映射视图列表 {@link UserAuthorityView}
     */
    public UserView setAuthorities(List<UserAuthorityView> userAuthorityViews) {
        Map<String, Map<String, List<UserAuthorityView>>> departmentServiceUserAuthorityViewMap = userAuthorityViews.stream()
                .collect(Collectors.groupingBy(UserAuthorityView::getDepartmentUuid, Collectors.groupingBy(UserAuthorityView::getServiceId, Collectors.toList())));
        this.departmentServiceUserAuthorityViewMap.putAll(departmentServiceUserAuthorityViewMap);
        return this;
    }

    /**
     * @return 当前工作科室下可访问的service集合
     */
    @JsonIgnore
    public Set<String> getServiceIds() {
        return this.departmentServiceUserAuthorityViewMap.getOrDefault(this.departmentUuid, new HashMap<>(0)).keySet();
    }

    /**
     * @return 当前工作科室下可访问的bundle集合
     */
    @JsonIgnore
    public List<String> getBundleIds() {
        return this.departmentServiceUserAuthorityViewMap.getOrDefault(this.businessDepartmentUuid, new HashMap<>(0)).values().stream()
                .flatMap(Collection::stream).map(UserAuthorityView::getBundleId).distinct().collect(Collectors.toList());
    }

    /**
     * @return 当前工作科室下拥有的权限集合
     */
    public List<String> getAuthIds() {
        return this.authIds;
    }

    public void setDepartmentServiceUserAuthorityViewMap(Map<String, Map<String, List<UserAuthorityView>>> departmentServiceUserAuthorityViewMap) {
        this.departmentServiceUserAuthorityViewMap = departmentServiceUserAuthorityViewMap;
    }

    /**
     * NOTE: Jackson 反序列化是按照属性定义顺序调用的setter方法；
     * 因为此方法依赖于 {@code departmentServiceUserAuthorityViewMap}，
     * 故 {@code businessDepartmentUuid} 应定义在相对靠后的位置。
     */
    public UserView setBusinessDepartmentUuid(String businessDepartmentUuid) {
        this.businessDepartmentUuid = businessDepartmentUuid;
        this.authIds = this.departmentServiceUserAuthorityViewMap.getOrDefault(this.businessDepartmentUuid, new HashMap<>(0)).values().stream()
                .flatMap(Collection::stream).map(UserAuthorityView::getAuthorityId).collect(Collectors.toList());
        return this;
    }

    public UserView setBusinessDepartmentName(String businessDepartmentName) {
        this.businessDepartmentName = businessDepartmentName;
        return this;
    }

    public UserView setStationUuid(String stationUuid) {
        this.stationUuid = stationUuid;
        return this;
    }

    public UserView setStationCode(String stationCode) {
        this.stationCode = stationCode;
        return this;
    }

    public UserView setUuid(String uuid) {
        this.uuid = uuid;
        return this;
    }

    public UserView setAvatar(String avatar) {
        this.avatar = avatar;
        return this;
    }

    public UserView setName(String name) {
        this.name = name;
        return this;
    }

    public UserView setDepartmentUuid(String departmentUuid) {
        this.departmentUuid = departmentUuid;
        return this;
    }

    public UserView setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
        return this;
    }

    public UserView setDepartmentSpell(String departmentSpell) {
        this.departmentSpell = departmentSpell;
        return this;
    }

    public UserView setBusinessDepartmentSpell(String businessDepartmentSpell) {
        this.businessDepartmentSpell = businessDepartmentSpell;
        return this;
    }

    public void setAuthIds(List<String> authIds) {
        this.authIds = authIds;
    }

    public String getUuid() {
        return uuid;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getName() {
        return name;
    }

    public String getDepartmentUuid() {
        return departmentUuid;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public String getDepartmentSpell() {
        return departmentSpell;
    }

    public String getBusinessDepartmentUuid() {
        return businessDepartmentUuid;
    }

    public String getBusinessDepartmentName() {
        return businessDepartmentName;
    }

    public String getBusinessDepartmentSpell() {
        return businessDepartmentSpell;
    }

    public String getStationUuid() {
        return stationUuid;
    }

    public String getStationCode() {
        return stationCode;
    }

    public Map<String, Map<String, List<UserAuthorityView>>> getDepartmentServiceUserAuthorityViewMap() {
        return departmentServiceUserAuthorityViewMap;
    }
}

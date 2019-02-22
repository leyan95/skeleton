package org.hunter.skeleton.spine.repository;

import org.hunter.skeleton.repository.Repository;
import org.hunter.skeleton.spine.model.Role;

/**
 * @author wujianchuan 2019/2/21
 */
public interface RoleRepository extends Repository {

    Role findOne(Long uuid);

    Role findById(String id);
}
package org.hunter.skeleton.spine.model.repository.impl;

import org.hunter.pocket.criteria.Criteria;
import org.hunter.pocket.criteria.Restrictions;
import org.hunter.skeleton.repository.AbstractRepository;
import org.hunter.skeleton.spine.model.Bundle;
import org.hunter.skeleton.spine.model.repository.BundleRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wujianchuan 2019/2/26
 * @version 1.0
 */
@Repository
public class BundleRepositoryImpl extends AbstractRepository implements BundleRepository {
    @Override
    public List<Bundle> findByAuthIf(Boolean auth) {
        Criteria criteria = this.getSession().creatCriteria(Bundle.class);
        criteria.add(Restrictions.equ("withAuth", false));
        return criteria.list();
    }

    @Override
    public Bundle findOne(long uuid) {
        return (Bundle) this.getSession().findOne(Bundle.class, uuid);
    }

    @Override
    public List<Bundle> findAll() {
        Criteria criteria = this.getSession().creatCriteria(Bundle.class);
        return criteria.list(true);
    }
}
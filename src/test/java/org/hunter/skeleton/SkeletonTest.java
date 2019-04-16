package org.hunter.skeleton;

import org.hunter.pocket.criteria.Restrictions;
import org.hunter.pocket.session.Session;
import org.hunter.pocket.session.SessionFactory;
import org.hunter.skeleton.spine.model.Department;
import org.hunter.skeleton.spine.model.Role;
import org.hunter.skeleton.spine.model.repository.UserRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author wujianchuan 2019/1/16
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class SkeletonTest {
    @Autowired
    UserRepository userRepository;

    @Before
    public void setup() {
    }

    @After
    public void destroy() {
    }

    @Test
    public void test1() {
        Session session = SessionFactory.getSession("skeleton");
        session.open();
        this.userRepository.injectSession(session);
        List<Department> departments = session.createCriteria(Department.class).add(Restrictions.equ("enable", true)).list();
        departments.forEach(department -> System.out.println(department.getName()));
        session.close();
    }

    @Test
    public void test2() {
        Session session = SessionFactory.getSession("skeleton");
        session.open();
        this.userRepository.injectSession(session);
        List<Role> roles = this.userRepository.findByAvatar("ADMIN")
                .getRoles(session);
        roles.forEach(role -> System.out.println(role.getName()));
        session.close();
    }

    @Test
    public void test3() {
        Session session = SessionFactory.getSession("skeleton");
        session.open();
        List<Role> roles = session.createSQLQuery("SELECT T1.UUID AS uuid,T1.NAME AS name,T1.SPELL AS id,T1.SORT AS sort,T1.`ENABLE` AS enable,T1.MEMO AS memo FROM TBL_ROLE T1 LEFT JOIN TBL_USER_ROLE T2 ON T1.UUID = T2.ROLE_UUID LEFT JOIN TBL_USER T3 ON T2.USER_UUID = T3.UUID WHERE T3.CODE = :CODE", Role.class)
                .setParameter("CODE", "ADMIN")
                .list();
        System.out.println(roles.size());
        session.close();
    }
}
package org.hv.biscuit.launcher;

import org.hv.biscuit.mediator.Mediator;
import org.hv.biscuit.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author wujianchuan
 */
@Component
@Order(3)
public class MediatorLauncher implements CommandLineRunner {
    private final
    List<Mediator> mediators;
    private final ApplicationContext context;

    @Autowired
    public MediatorLauncher(@Nullable List<Mediator> mediators, ApplicationContext context) {
        this.mediators = mediators;
        this.context = context;
    }

    @Override
    public void run(String... args) throws Exception {
        if (this.mediators != null) {
            for (Mediator mediator : mediators) {
                for (Class<? extends Service> serviceClazz : mediator.getServiceClazzList()) {
                    mediator.registerService(context.getBean(serviceClazz));
                }
            }
        }
    }
}
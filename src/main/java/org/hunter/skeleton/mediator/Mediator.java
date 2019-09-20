package org.hunter.skeleton.mediator;


import org.hunter.skeleton.service.Service;

import java.util.List;

/**
 * @author wujianchuan
 */
public interface Mediator {
    /**
     * Get service clazz list.
     *
     * @return Class array.
     */
    List<Class<Service>> getServiceClazzList();

    /**
     * Register service
     *
     * @param service Service instance who implement {@link Service}
     */
    void registerService(Service service) throws Exception;

    /**
     * call another service method
     *
     * @param businessName business name
     * @param args         arguments
     * @return obj
     * @throws Exception e
     */
    Object call(String businessName, Object... args) throws Exception;
}

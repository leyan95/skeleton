package org.hv.biscuits.domain.even;

/**
 * @author leyan95
 */
public interface Monitor {
    /**
     * get event source id.
     *
     * @return even source id.
     */
    String[] evenSourceIds();

    /**
     * execute something.
     *
     * @param args arguments.
     */
    void execute(Object... args) throws Exception;
}

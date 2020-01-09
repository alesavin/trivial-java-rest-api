package ru.alesavin.trivial.rest.dao;

/**
 * Specs over [[InMemoryAdvertDao]]
 *
 * @author alesavin
 */
public class InMemoryAdvertDaoTest extends AdvertDaoTest {

    private AdvertDao d = new InMemoryAdvertDao();

    @Override
    AdvertDao dao() {
        return d;
    }
}

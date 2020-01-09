package ru.alesavin.trivial.rest.dao;

import org.junit.Test;
import ru.alesavin.trivial.rest.model.Advert;
import ru.alesavin.trivial.rest.model.AdvertCategory;
import ru.alesavin.trivial.rest.model.AdvertSource;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.*;

/**
 * Base specs for [[AdvertDao]]
 *
 * @author alesavin
 */
public abstract class AdvertDaoTest {

    abstract AdvertDao dao();
    private final AdvertSource source = new AdvertSource(
            "title",
            "body",
            AdvertCategory.AUTO,
            "phone",
            LocalDateTime.MIN,
            "author1"
    );

    @Test
    public void testEmptyOnStart() {
        assertTrue(dao().query(new AdvertDao.ById("1")).isEmpty());
        assertTrue(dao().query(new AdvertDao.ByAuthor("author1")).isEmpty());
    }
    @Test
    public void nothingToDeleteOnStart() {
        assertFalse(dao().delete("1"));
    }
    @Test
    public void createAndDeleteNewAdvert() {
        Advert a1 = Advert.fromSource("1", source);
        dao().upsert(a1);
        assertEquals(Collections.singletonList(a1), dao().query(new AdvertDao.ById("1")));
        assertEquals(Collections.singletonList(a1), dao().query(new AdvertDao.ByAuthor("author1")));
        assertTrue(dao().delete("1"));
        assertTrue(dao().query(new AdvertDao.ById("1")).isEmpty());
        assertTrue(dao().query(new AdvertDao.ByAuthor("author1")).isEmpty());
    }
    @Test
    public void createAndDeleteNewAdverts() {
        Advert a1 = Advert.fromSource("1", source);
        Advert a2 = Advert.fromSource("2", source);
        dao().upsert(a1);
        dao().upsert(a2);
        assertEquals(Collections.singletonList(a1), dao().query(new AdvertDao.ById("1")));
        assertEquals(Collections.singletonList(a2), dao().query(new AdvertDao.ById("2")));
        assertEquals(Arrays.asList(a1, a2), dao().query(new AdvertDao.ByAuthor("author1")));
        assertTrue(dao().delete("1"));
        assertTrue(dao().query(new AdvertDao.ById("1")).isEmpty());
        assertEquals(Collections.singletonList(a2), dao().query(new AdvertDao.ById("2")));
        assertFalse(dao().query(new AdvertDao.ByAuthor("author1")).isEmpty());
    }
    @Test
    public void updateAdvert() { }
}

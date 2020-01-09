package ru.alesavin.trivial.rest.dao;

import ru.alesavin.trivial.rest.model.Advert;

import java.util.List;

/**
 * DAO for operating by adverts
 *
 * @author alesavin
 */
public interface AdvertDao {

    void upsert(Advert advert);
    boolean delete(String id);
    List<Advert> query(Query query);

    interface Query { }
    class ById implements Query{
        public String id;

        public ById(String id) {
            this.id = id;
        }
    }
    class ByAuthor implements Query {
        public String authorId;

        public ByAuthor(String authorId) {
            this.authorId = authorId;
        }
    }
}

package ru.alesavin.trivial.rest.dao;

import ru.alesavin.trivial.rest.model.Advert;

import java.util.*;
import java.util.stream.Collectors;

/**
 * TODO
 *
 * @author alesavin
 */
public class InMemoryAdvertDao implements AdvertDao {

    private Map<String, Advert> map = new HashMap<>();

    @Override
    public void upsert(Advert advert) {
        map.put(advert.getId(), advert);
    }

    @Override
    public boolean delete(String id) {
        return map.remove(id) != null;
    }

    @Override
    public List<Advert> query(Query query) {
        if (query instanceof ById) {
           final String id = ((ById)query).id;
           return Optional.ofNullable(map.getOrDefault(id, null))
                   .map(Collections::singletonList)
                   .orElse(Collections.emptyList());
        } else if (query instanceof ByAuthor) {
            final String authorId = ((ByAuthor)query).authorId;
            return map.values()
                    .stream()
                    .filter(a -> authorId.equals(a.getAuthorId()))
                    .collect(Collectors.toList());
        } else {
            throw new IllegalArgumentException("Illegal query");
        }
    }
}

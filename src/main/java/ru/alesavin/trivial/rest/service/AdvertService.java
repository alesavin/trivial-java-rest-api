package ru.alesavin.trivial.rest.service;

import ru.alesavin.trivial.rest.model.Advert;
import ru.alesavin.trivial.rest.model.AdvertSource;

import java.util.List;
import java.util.Optional;

/**
 * Service for adverts operating
 *
 * @author alesavin
 */
public interface AdvertService {

    Advert create(AdvertSource advert);
    void delete(String id);
    Optional<Advert> getById(String id);
    List<Advert> getByAuthor(String authorId);
}

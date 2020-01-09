package ru.alesavin.trivial.rest.model;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

/**
 * Represent advertisement
 *
 * @author alesavin
 */
public class Advert {

    /**
     * Обьявление, с такими полями как
     *  уникальный идентификатор, заголовок объявления, тело, категория, контактный телефон, дата создания
     */
    private String id; // string for future extension
    private String title;
    private String body;
    private AdvertCategory category;
    private String phone;
    private LocalDateTime crDate;
    private String authorId;

    public Advert(String id, String title, String body, AdvertCategory category, String phone, LocalDateTime crDate, String authorId) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.category = category;
        this.phone = phone;
        this.crDate = crDate;
        this.authorId = authorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Advert)) return false;
        Advert advert = (Advert) o;
        return id.equals(advert.id) &&
                title.equals(advert.title) &&
                body.equals(advert.body) &&
                category == advert.category &&
                phone.equals(advert.phone) &&
                crDate.equals(advert.crDate) &&
                authorId.equals(advert.authorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, body, category, phone, crDate, authorId);
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public AdvertCategory getCategory() {
        return category;
    }

    public String getPhone() {
        return phone;
    }

    public LocalDateTime getCrDate() {
        return crDate;
    }

    public String getAuthorId() {
        return authorId;
    }

    @Override
    public String toString() {
        return "Advert{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", category=" + category +
                ", phone='" + phone + '\'' +
                ", crDate=" + crDate +
                ", authorId='" + authorId + '\'' +
                '}';
    }

    public static Advert fromSource(String id, AdvertSource source) {
        return new Advert(
                id,
                source.getTitle(),
                source.getBody(),
                source.getCategory(),
                source.getPhone(),
                source.getCrDate(),
                source.getAuthorId()
        );
    }
}

package ru.alesavin.trivial.rest.model;

import java.time.LocalDateTime;

/**
 * Source for [[Advert]]
 *
 * @author alesavin
 */
public class AdvertSource {

    private String title;
    private String body;
    private AdvertCategory category;
    private String phone;
    private LocalDateTime crDate;
    private String authorId;

    public AdvertSource(String title, String body, AdvertCategory category, String phone, LocalDateTime crDate, String authorId) {
        this.title = title;
        this.body = body;
        this.category = category;
        this.phone = phone;
        this.crDate = crDate;
        this.authorId = authorId;
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
        return "AdvertSource{" +
                "title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", category=" + category +
                ", phone='" + phone + '\'' +
                ", crDate=" + crDate +
                ", authorId='" + authorId + '\'' +
                '}';
    }
}

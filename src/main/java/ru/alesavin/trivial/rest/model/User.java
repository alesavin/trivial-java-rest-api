package ru.alesavin.trivial.rest.model;

/**
 * Represent some actor
 *
 * @author alesavin
 */
public class User {

    /**
     * Пользователь,
     *  уникальный идентификатор, имя, фамилия, почта, категория (физ -лицо или юридическое)
     */
    private String id; // string for future extension
    private String name;
    private String surName;
    private String email;
    private UserCategory category;

    public User(String id, String name, String surName, String email, UserCategory category) {
        this.id = id;
        this.name = name;
        this.surName = surName;
        this.email = email;
        this.category = category;
    }
}

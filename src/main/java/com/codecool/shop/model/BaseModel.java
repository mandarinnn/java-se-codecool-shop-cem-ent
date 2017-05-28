package com.codecool.shop.model;


import java.lang.reflect.Field;

/**
 * <h1>The base model of objects</h1>
 * <p>Various attributes of models, and related behaviour.</p>
 * @author Fanni Skoda
 * @since 2017.05.08.
 */

public class BaseModel {

    protected int id;
    protected String name;
    protected String description;

    /**
     * Constructor
     * @param name name of the model
     * @param description description of the model
     */
    public BaseModel(String name, String description) {
        this.name = name;
        this.description = description;
    }

    /**
     * Constructor
     * @param id unique id of the model
     * @param name name of the model
     * @param description description of the model
     */

    public BaseModel(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        for (Field field : this.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            Object value = null;
            try {
                value = field.get(this);
                if (value != null) {
                    sb.append(field.getName() + ":" + value + ",");
                }
            } catch (IllegalAccessException e) {

            }
        }
        return sb.toString();
    }

}

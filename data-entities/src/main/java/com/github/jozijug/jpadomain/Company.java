package com.github.jozijug.jpadomain;

import javax.persistence.Entity;

/**
 *
 * @author Matti Tahvonen
 */
@Entity
public class Company extends AbstractEntity {

	private static final long serialVersionUID = 4976048050860313444L;
	private String name;

    public Company(String name) {
        this.name = name;
    }

    public Company() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

}

package com.ilegra.logging.demo.loggingdemo.api.dto;

import java.util.Objects;
import java.util.StringJoiner;

public class UserDto {
    private String name;

    public UserDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDto userDto = (UserDto) o;
        return Objects.equals(name, userDto.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", UserDto.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .toString();
    }
}

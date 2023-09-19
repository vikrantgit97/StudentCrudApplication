package com.crudapp.utils;

import com.crudapp.entity.Teacher;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Vikrant on 19-09-2023
 * @Project StudentRegistrationApplication
 */
public class ListToMapConverter {

    public static Map<Long, String> convertToMap(List<Teacher> list) {
        return list.stream().collect(Collectors.toMap(Teacher::getId, Teacher::getFirstName));
    }

    public static Map<Long, String> convertListOfObjectArrayToMap(List<Object[]> list) {
        // Java 8 Stream API
        Map<Long, String> map = list.stream()
                .collect(Collectors.toMap(ob -> Long.valueOf(ob[0].toString()), ob -> ob[1].toString()));
        return map;
    }

    public static Map<Long, String> convertToMapIndex(List<Object[]> list) {
        // Java 8 Stream API
        Map<Long, String> map = list.stream().collect(Collectors.toMap(ob -> Long.valueOf(ob[0].toString()),
                ob -> ob[1].toString() + " " + ob[2].toString()));
        return map;
    }
}

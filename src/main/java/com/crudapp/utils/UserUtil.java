package com.crudapp.utils;
import java.util.UUID;

import org.springframework.stereotype.Component;
/**
 * @author Vikrant on 26-09-2023
 * @version V1.0
 * @Project StudentRegistrationApplication
 */


@Component
public class UserUtil {

    public String genPwd() {
        return UUID.randomUUID()
                .toString()
                .replace("-","")
                .substring(0, 8);
    }
}
package com.logistic.domain.dto;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class UserNewDto implements Serializable {

    @Serial
    private static final long serialVersionUID = -6795664418153346993L;

    private String userName;
    private String userEmail;
    private String password;

}

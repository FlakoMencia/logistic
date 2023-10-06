package com.logistic.domain.dto;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;


@Data
public class UserDto implements Serializable {
    @Serial
    private static final long serialVersionUID = -2918281298988259900L;

    private Long userId;
    private String userName;
    private String userEmail;
    private String userStatus;

}

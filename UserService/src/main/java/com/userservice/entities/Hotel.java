package com.userservice.entities;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Hotel {
    private String id;
    private String name;
    private String address;
    private String about;

}

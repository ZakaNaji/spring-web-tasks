package com.znaji.springwebtasks.court.demain;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@XmlRootElement
public class Member {
    private String name;
    private String email;
    private String phone;
}

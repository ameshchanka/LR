package by.itacademy.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by a.meshchanka on 03.02.2018.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Embeddable
public class Contact {

    @Column(name = "phoneNumber")
    private String phone;

    @Column(name = "skype")
    private String skype;

    @Column(name = "viber")
    private String viber;

    @Column(name = "telegram")
    private String telegram;
}

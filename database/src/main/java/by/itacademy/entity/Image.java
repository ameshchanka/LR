package by.itacademy.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * Created by a.meshchanka on 02.02.2018.
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "crm_images")
@Inheritance(strategy = InheritanceType.JOINED)
public class Image extends BaseEntity {

    @Column(name = "path", length = 65535, nullable = false)
    private String path;
}

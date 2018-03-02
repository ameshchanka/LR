package by.itacademy.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

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

    @Column(name = "path", nullable = false)
    private String path;

    public Image(String path) {
        this.path = path;
    }
}

//http://newsbel.by/wp-content/uploads/2016/03/newsbel.by-6.03.2016-njUmTtG0foQauqgmuhYVHSt4g5d8aKHx.jpg

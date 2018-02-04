package by.itacademy.entity;

import lombok.Setter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by a.meshchanka on 03.02.2018.
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "lr_messages")
public class Message extends BaseEntity {

    @Column(name = "text")
    private String text;

    @Column(name = "dateSend")
    private LocalDateTime dateSend;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "sender_id")
    private User sender;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "recipient_id", nullable = false)
    private User recipient;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "leasead_id")
    private LeaseAd leaseAd;

    public Message(String text, LocalDateTime dateSend, User sender, User recipient, LeaseAd leaseAd) {
        this.text = text;
        this.dateSend = dateSend;
        this.sender = sender;
        this.recipient = recipient;
        this.leaseAd = leaseAd;
    }
}

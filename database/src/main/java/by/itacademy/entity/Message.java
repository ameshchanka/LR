package by.itacademy.entity;

import lombok.Setter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;
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

    @Column(name = "text", length = 65535, columnDefinition = "TEXT")
    private String text;

    @Column(name = "dateSend")
    private LocalDateTime dateSend;

    @ManyToOne
    @JoinColumn(name = "sender_id")
    private User sender;

    @ManyToOne
    @JoinColumn(name = "recipient_id", nullable = false)
    private User recipient;

    @ManyToOne
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

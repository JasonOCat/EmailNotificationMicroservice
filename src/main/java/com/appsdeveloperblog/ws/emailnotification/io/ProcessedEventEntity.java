package com.appsdeveloperblog.ws.emailnotification.io;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProcessedEventEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = -5253574505872582923L;

    @Id
    @GeneratedValue
    private String id;

    @Column(nullable = false, unique = true)
    private String messageId;

    @Column(nullable = false)
    private String productId;

}

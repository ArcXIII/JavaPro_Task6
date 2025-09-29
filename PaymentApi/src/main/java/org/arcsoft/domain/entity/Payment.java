package org.arcsoft.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "payments")
@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private Long productId;

    @Column(name = "payment_amount", nullable = false)
    private Double amount;

}
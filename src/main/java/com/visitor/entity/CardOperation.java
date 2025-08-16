package com.visitor.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "card_operations")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CardOperation {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 
	 private String cardNumber;
	 
	 @ManyToOne
	 @JoinColumn(name = "visitor_id")
	 private Visitor visitor;
	 private String operation;
	 private LocalDateTime timestamp;
}

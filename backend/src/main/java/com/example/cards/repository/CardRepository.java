
package com.example.cards.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.cards.model.Card;
public interface CardRepository extends JpaRepository<Card,Long>{}

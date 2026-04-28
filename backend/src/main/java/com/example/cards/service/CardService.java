
package com.example.cards.service;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import com.example.cards.repository.CardRepository;
import com.example.cards.model.Card;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@Transactional
public class CardService {

 private final CardRepository repository;

 public CardService(CardRepository repo) {
  this.repository = repo;
 }

 public Optional<Card> findById(Long id) {

  return repository.findById(id);
 }

 public List<Card> findAll() {
  return repository.findAll();
 }

 public Card save(Card c) {
  return repository.save(c);
 }

 public Card delete(Long id) {

  Card existing = repository.findById(id)
          .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Card not found with id: " + id));
  repository.delete(existing);
  Optional<Card> optional = repository.findById(id);
  if (optional.isPresent())
     throw new ResponseStatusException(HttpStatus.ALREADY_REPORTED, "Card deleted found with id: " + id);
  else if (optional.isEmpty())
       return existing;
  else throw new ResponseStatusException(HttpStatus.ALREADY_REPORTED, "Card deleted found with id: " + id);
  // restituisce l'oggetto eliminato
 }

 public boolean deleteIfExists(Long id) {
  Card existing = repository.findById(id)
          .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Card not found with id: " + id));
  return true;
 }

}

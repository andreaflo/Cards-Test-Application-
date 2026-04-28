
package com.example.cards.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.cards.service.CardService;
import com.example.cards.model.Card;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/cards")
@CrossOrigin(origins = "http://localhost:3000")
public class CardController {
 private final CardService service;

 public CardController(CardService service)
 {
  this.service=service;
 }

 //GET /cards
 @GetMapping("/all")
 public List<Card> all()
 {
     return service.findAll();
 }

 //GET /cards/{id}
 @GetMapping("/get/{id}")
 public ResponseEntity<Card> getById(@PathVariable("id") Long id) {
  return service.findById(id)
          .map(ResponseEntity::ok)
          .orElse(ResponseEntity.notFound().build());
 }


    //POST /cards/{id}
    @PostMapping("/create/")
    public ResponseEntity<Card> create(@RequestBody Card card) {
            // 1. Validazioni
            if (card == null) {
                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST, "Card cannot be null");
            }

            if (card.getId() != null) {
                card.setId(null);
            }

            if (card.getName() == null || card.getName().isBlank()) {
                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST, "Name is required");
            }

            // 2. Default values
            if (card.getDescription() == null) {
                card.setDescription("");
            }

            // 3. Persist
            final Card returned = service.save(card);
    return ResponseEntity.status(HttpStatus.CREATED).body(returned);
}



 @DeleteMapping("/delete/{id}")
 public ResponseEntity<Card> delete(@PathVariable("id") Long id) {
  return service.findById(id)
          .map(existing -> {
           service.delete(id);
           return ResponseEntity.ok(existing);
          })
          .orElse(ResponseEntity.notFound().build());
 }

 // PUT /cards/{id}
 @PutMapping("/put/{id}")
 public ResponseEntity<Card> modify(@PathVariable("id") Long id, @RequestBody Card card) {
  return service.findById(id)
          .map(existing -> {;
              card.setId(id); // Assicura che l'ID sia corretto
           Card updated = service.save(card);
           return ResponseEntity.ok(updated);
          })
          .orElse(ResponseEntity.notFound().build());
 }
}

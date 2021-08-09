package uz.pdp.money_transfer_demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.money_transfer_demo.payload.CardDto;
import uz.pdp.money_transfer_demo.service.CardService;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/card")
public class CardController {


    @Autowired
    CardService cardService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllCard(){
        return cardService.getAllCard();
    }


    @GetMapping("/myInfo")
    public ResponseEntity<?> getMyCard(){
        return cardService.getMyCard();
    }


    @PostMapping("/add")
    public HttpEntity<?> cardAdd( @RequestBody CardDto cardDto){
        return cardService.addCard(cardDto);
    }

    @DeleteMapping("/delete/{id}")
    public HttpEntity<?> deleteCard(@PathVariable Integer id){
        return cardService.deleteCard(id);
    }

    @GetMapping("/income")
    public ResponseEntity<?> getMyCardIncomeList(){
        return cardService.getIncomeMoneyList();
    }
    @GetMapping("/outcome")
    public ResponseEntity<?> getMyCardOutcomeList(){
        return cardService.getOutcomeMoneyList();
    }
}

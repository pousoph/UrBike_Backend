package co.edu.unbosque.urbike.pagoservice.controller;

import co.edu.unbosque.urbike.pagoservice.model.request.ChargeRequestDTO;
import co.edu.unbosque.urbike.pagoservice.service.StripeService;
import com.stripe.exception.StripeException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/urbike/v1/pago")
@CrossOrigin("*")
public class ChargeController {
    private final StripeService stripeService;

    public ChargeController(StripeService stripeService) {
        this.stripeService = stripeService;
    }

    @PostMapping("/charge")
    public ResponseEntity<?> charge(@RequestBody ChargeRequestDTO chargeRequest) throws StripeException {
        return ResponseEntity.ok(stripeService.charge(chargeRequest));
    }
}

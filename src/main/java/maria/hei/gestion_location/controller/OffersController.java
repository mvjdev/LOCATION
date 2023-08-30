package maria.hei.gestion_location.controller;

import maria.hei.gestion_location.entity.Offers;
import maria.hei.gestion_location.service.OffersService.OffersInterface;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/offers")
public class OffersController {

    private final OffersInterface offersService;

    public OffersController(OffersInterface offersService) {
        this.offersService = offersService;
    }

    @GetMapping
    public List<Offers> getAllOffers() {
        return offersService.getAllOffers();
    }

    @GetMapping("/{offerId}")
    public Offers getOfferById(@PathVariable int offerId) {
        return offersService.getOfferById(offerId);
    }

    @PostMapping
    public void createOffer(@RequestBody Offers offer) {
        offersService.createOffer(offer);
    }

    @PutMapping("/{offerId}")
    public void updateOffer(@PathVariable int offerId, @RequestBody Offers offer) {
        // Implement offer update logic using offersService
        offersService.updateOffer(offer);
    }

    @DeleteMapping("/{offerId}")
    public void deleteOffer(@PathVariable int offerId) {
        offersService.deleteOffer(offerId);
    }
}

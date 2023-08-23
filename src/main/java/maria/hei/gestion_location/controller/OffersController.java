package maria.hei.gestion_location.controller;

import maria.hei.gestion_location.entity.Offers;
import maria.hei.gestion_location.service.OffersService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/offers")
public class OffersController {
    private OffersService offersService;

    public OffersController(OffersService offersService) {
        this.offersService = offersService;
    }

    @PostMapping
    public void createOffer(@RequestBody Offers offer) {
        offersService.createOffer(offer);
    }

    @GetMapping("/{id}")
    public Offers getOfferById(@PathVariable int id) {
        return offersService.getOfferById(id);
    }

    @GetMapping
    public List<Offers> getAllOffers() {
        return offersService.getAllOffers();
    }

    @PutMapping
    public void updateOffer(@RequestBody Offers offer) {
        offersService.updateOffer(offer);
    }

    @DeleteMapping("/{id}")
    public void deleteOffer(@PathVariable int id) {
        offersService.deleteOffer(id);
    }
}

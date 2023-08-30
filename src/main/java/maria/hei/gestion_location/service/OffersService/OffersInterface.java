package maria.hei.gestion_location.service.OffersService;

import maria.hei.gestion_location.entity.Offers;

import java.util.List;

public interface OffersInterface {
    void createOffer(Offers offer);
    Offers getOfferById(int id);
    List<Offers> getAllOffers();
    void updateOffer(Offers offer);
    void deleteOffer(int id);
}

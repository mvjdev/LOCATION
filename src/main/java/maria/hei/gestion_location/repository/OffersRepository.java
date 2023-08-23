package maria.hei.gestion_location.repository;

import maria.hei.gestion_location.entity.Offers;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class OffersRepository {
    private Map<Integer, Offers> offersMap;

    public OffersRepository() {
        offersMap = new HashMap<>();
    }

    public void createOffer(Offers offer) {
        offersMap.put(offer.getId(), offer);
    }

    public Offers getOfferById(int id) {
        return offersMap.get(id);
    }

    public List<Offers> getAllOffers() {
        return new ArrayList<>(offersMap.values());
    }

    public void updateOffer(Offers offer) {
        offersMap.put(offer.getId(), offer);
    }

    public void deleteOffer(int id) {
        offersMap.remove(id);
    }
}

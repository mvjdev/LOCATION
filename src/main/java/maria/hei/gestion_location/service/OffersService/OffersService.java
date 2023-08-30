package maria.hei.gestion_location.service.OffersService;

import maria.hei.gestion_location.entity.Offers;
import maria.hei.gestion_location.repository.OffersRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class OffersService {
    private OffersRepository offersRepository;

    public OffersService(OffersRepository offersRepository) {
        this.offersRepository = offersRepository;
    }

    public void createOffer(Offers offer) {
        offersRepository.createOffer(offer);
    }

    public Offers getOfferById(int id) {
        return offersRepository.getOfferById(id);
    }

    public List<Offers> getAllOffers() {
        return offersRepository.getAllOffers();
    }

    public void updateOffer(Offers offer) {
        offersRepository.updateOffer(offer);
    }

    public void deleteOffer(int id) {
        offersRepository.deleteOffer(id);
    }
}

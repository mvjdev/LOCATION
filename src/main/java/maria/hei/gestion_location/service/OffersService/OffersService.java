package maria.hei.gestion_location.service.OffersService;

import maria.hei.gestion_location.entity.Offers;
import maria.hei.gestion_location.repository.OffersRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OffersService implements OffersInterface {

    private final OffersRepository offersRepository;

    public OffersService(OffersRepository offersRepository) {
        this.offersRepository = offersRepository;
    }

    @Override
    public void createOffer(Offers offer) {
        offersRepository.createOffer(offer);
    }

    @Override
    public Offers getOfferById(int id) {
        return offersRepository.getOfferById(id);
    }

    @Override
    public List<Offers> getAllOffers() {
        return offersRepository.getAllOffers();
    }

    @Override
    public void updateOffer(Offers offer) {
        offersRepository.updateOffer(offer);
    }

    @Override
    public void deleteOffer(int id) {
        offersRepository.deleteOffer(id);
    }
}

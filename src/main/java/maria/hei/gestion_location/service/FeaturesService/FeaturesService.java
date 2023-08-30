package maria.hei.gestion_location.service.FeaturesService;

import maria.hei.gestion_location.entity.Features;
import maria.hei.gestion_location.repository.FeaturesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeaturesService implements FeaturesInterface {

    private final FeaturesRepository featuresRepository;

    public FeaturesService(FeaturesRepository featuresRepository) {
        this.featuresRepository = featuresRepository;
    }
    @Override
    public void createFeature(Features feature) {

    }

    @Override
    public Features getFeatureById(int id) {
        return null;
    }

    @Override
    public List<Features> getAllFeatures() {
        return null;
    }

    @Override
    public void updateFeature(Features feature) {

    }

    @Override
    public void deleteFeature(int id) {

    }

}

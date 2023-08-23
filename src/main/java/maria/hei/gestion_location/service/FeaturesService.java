package maria.hei.gestion_location.service;

import maria.hei.gestion_location.entity.Features;
import maria.hei.gestion_location.repository.FeaturesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class FeaturesService {
    private FeaturesRepository featuresRepository;

    public FeaturesService(FeaturesRepository featuresRepository) {
        this.featuresRepository = featuresRepository;
    }

    public void createFeature(Features feature) {
        featuresRepository.createFeature(feature);
    }

    public Features getFeatureById(int id) {
        return featuresRepository.getFeatureById(id);
    }

    public List<Features> getAllFeatures() {
        return featuresRepository.getAllFeatures();
    }

    public void updateFeature(Features feature) {
        featuresRepository.updateFeature(feature);
    }

    public void deleteFeature(int id) {
        featuresRepository.deleteFeature(id);
    }
}

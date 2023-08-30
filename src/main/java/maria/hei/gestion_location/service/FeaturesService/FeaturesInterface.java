package maria.hei.gestion_location.service.FeaturesService;

import maria.hei.gestion_location.entity.Features;

import java.util.List;

public interface FeaturesInterface {
    void createFeature(Features feature);
    Features getFeatureById(int id);
    List<Features> getAllFeatures();
    void updateFeature(Features feature);
    void deleteFeature(int id);
}

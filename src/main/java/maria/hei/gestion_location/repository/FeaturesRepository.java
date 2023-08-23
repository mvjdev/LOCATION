package maria.hei.gestion_location.repository;

import maria.hei.gestion_location.entity.Features;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class FeaturesRepository {
    private Map<Integer, Features> featuresMap;

    public FeaturesRepository() {
        this.featuresMap = new HashMap<>();
    }

    public void createFeature(Features feature) {
        featuresMap.put(feature.getId(), feature);
    }

    public Features getFeatureById(int id) {
        return featuresMap.get(id);
    }

    public List<Features> getAllFeatures() {
        return new ArrayList<>(featuresMap.values());
    }

    public void updateFeature(Features feature) {
        featuresMap.put(feature.getId(), feature);
    }

    public void deleteFeature(int id) {
        featuresMap.remove(id);
    }
}

package maria.hei.gestion_location.controller;

import maria.hei.gestion_location.entity.Features;
import maria.hei.gestion_location.service.FeaturesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/features")
public class FeaturesController {
    private FeaturesService featuresService;

    public FeaturesController(FeaturesService featuresService) {
        this.featuresService = featuresService;
    }

    @PostMapping
    public void createFeature(@RequestBody Features feature) {
        featuresService.createFeature(feature);
    }

    @GetMapping("/{id}")
    public Features getFeatureById(@PathVariable int id) {
        return featuresService.getFeatureById(id);
    }

    @GetMapping
    public List<Features> getAllFeatures() {
        return featuresService.getAllFeatures();
    }

    @PutMapping
    public void updateFeature(@RequestBody Features feature) {
        featuresService.updateFeature(feature);
    }

    @DeleteMapping("/{id}")
    public void deleteFeature(@PathVariable int id) {
        featuresService.deleteFeature(id);
    }
}

package vs.recipe.service.impl;

import org.springframework.stereotype.Service;
import vs.recipe.model.Ingredient;
import vs.recipe.service.IngredientService;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

@Service
public class IngredientServiceImpl implements IngredientService {

    private static long id = 1;
    private final Map<Long, Ingredient> ingredients = new TreeMap<>();

    @Override
    public Optional<Ingredient> addNewIngredient(Ingredient ingredient) {
        return Optional.ofNullable (ingredients.put(id++, ingredient));

    }

    @Override
    public Optional<Ingredient> getIngredient(Long id) {
        return Optional.ofNullable(ingredients.get(id));
    }

    @Override
    public Optional<Ingredient> editIngredient(Long id, Ingredient ingredient) {

        return Optional.ofNullable(ingredients.replace(id, ingredient));
    }

    @Override
    public Optional<Ingredient> deleteIngredient(Long id) {
        return Optional.ofNullable(ingredients.remove(id));
    }

    @Override
    public Map<Long, Ingredient> getAllIngredients() {
        return new HashMap<>(ingredients);
    }
}

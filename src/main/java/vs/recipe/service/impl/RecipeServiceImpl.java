package vs.recipe.service.impl;

import org.springframework.stereotype.Service;
import vs.recipe.model.Recipe;
import vs.recipe.service.RecipeService;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

@Service
public class RecipeServiceImpl implements RecipeService {
    private static long id = 1;
    private final Map<Long, Recipe> recipes = new TreeMap<>();

    @Override
    public Optional<Recipe> addNewRecipe(Recipe recipe) {
        return Optional.ofNullable (recipes.put(id++, recipe));
    }

    @Override
    public Optional<Recipe> getRecipe(Long id) {
        return Optional.ofNullable(recipes.get(id));
    }

    @Override
    public Optional<Recipe> edit(Long id, Recipe recipe) {

        return Optional.ofNullable(recipes.replace(id, recipe));
    }

    @Override
    public Optional<Recipe> delete(Long id) {
        return Optional.ofNullable(recipes.remove(id));
    }

    @Override
    public Map<Long, Recipe> getAll() {
        return new HashMap<>(recipes);
    }
}

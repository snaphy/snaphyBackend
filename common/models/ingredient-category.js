module.exports = function(IngredientCategory) {
    IngredientCategory.validatesUniquenessOf('name');
};

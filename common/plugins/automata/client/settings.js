/**
 * Created by robins on 2/12/15.
 */
(function() {
    'use strict';
})();
/*global $snaphy*/
//This is the setting file of the plugin..TO be configured according to the user needs..
var settings = {
    "defaultTemplate": true,
    loadDatabases: [
        "Employee",
        "EmployeeDetails",
        "Recipe",
        "Comments",
        "Category",
        "Customer",
        "Cuisines",
        "IngredientCategory",
        "Ingredients",
        "Priority",
        "RecipeIngredients",
        "RecipeTag",
        "Wishlist",
        "Chef"
    ]
};


//Now adding settings to the main index file..
$snaphy.addSettings('automata', settings);

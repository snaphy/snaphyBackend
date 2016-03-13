/**
 * Created by robins on 4/12/15.
 */
'use strict';
/*jslint browser: true*/
var settings = {
   "homeState" : "dashboard",
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
      "Chef",
      "RecipeAnalytic",
      //"Popularity",
      /* "Order",
       'OrderDetail',*/
      "Course"
   ]
};


//Now adding settings to the main index file..
$snaphy.addSettings('dashboard', settings);

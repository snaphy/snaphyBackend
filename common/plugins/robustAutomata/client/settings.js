/**
 * Created by robins on 2/12/15.
 */
'use strict';
/*jslint browser: true*/
/*$snaphy*/
//This is the setting file of the plugin..TO be configured according to the user needs..
var settings = {
   "defaultTemplate": true,
   "tablePanelId": "#automataWidget",
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
       "RecipeAnalytic"
   ]

};


//Now adding settings to the main index file..
$snaphy.addSettings('robustAutomata', settings);

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
       "Order",
       "Recipe",
       "RecipeAnalytic",
       "Comments",
       "Category",
       "Customer",
       "Cuisines",
       "Employee",
       "EmployeeDetails",
       "IngredientCategory",
       "Ingredients",
       "RecipeIngredients",
       "RecipeTag",
       "Wishlist",
       "Chef",
       //"Popularity",
       /*'OrderDetail',*/
       "Course",
       "ContactChef"
   ],
    "ignore":[
        "Order"
    ],
    "failedSaveStatus":[{
        "code":420,
        "message":"Your recipe upload limit for current chef is expired. Please renew it."
    }]

};


//Now adding settings to the main index file..
$snaphy.addSettings('robustAutomata', settings);

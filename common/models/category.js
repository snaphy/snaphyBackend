module.exports = function(Category) {
    Category.validatesUniquenessOf('name');
};

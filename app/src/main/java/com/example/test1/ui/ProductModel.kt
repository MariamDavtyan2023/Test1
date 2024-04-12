package com.example.test1.ui

data class ProductModel(
    val name: String
) {
    companion object {
        fun mapListToProductModelList(list: List<String>) : List<ProductModel> {
            val products = mutableListOf<ProductModel>()
            list.map {
                products.add(ProductModel(it))
            }
            return products
        }
    }
}

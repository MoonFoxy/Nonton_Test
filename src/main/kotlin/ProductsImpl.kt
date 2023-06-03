class ProductsImpl {
    private val products: MutableList<Product> = mutableListOf()

    fun addProduct(product: Product): Boolean {
        if (products.any { it.id == product.id }) {
            return false
        }
        products.add(product)
        return true
    }

    fun deleteProduct(product: Product): Boolean {
        return products.remove(product)
    }

    fun getName(id: String): String {
        val product = products.find { it.id == id }
        return product?.name ?: ""
    }

    fun findByName(name: String): List<String> {
        return products.filter { it.name == name }.map { it.id }
    }
}
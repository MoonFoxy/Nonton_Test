fun main(args: Array<String>) {
    val products = ProductsImpl()

    // Тестирование функции addProduct
    val product1 = Product().apply {
        id = "1"
        name = "Product 1"
    }
    println("1. addProduct: ${products.addProduct(product1)}") // true

    val product2 = Product().apply {
        id = "2"
        name = "Product 2"
    }
    println("2. addProduct: ${products.addProduct(product2)}") // true

    val product3 = Product().apply {
        id = "1" // Существующий id
        name = "Product 3"
    }
    println("3. addProduct: ${products.addProduct(product3)}") // false

    // Тестирование функции deleteProduct
    println("4. deleteProduct: ${products.deleteProduct(product2)}") // true
    println("5. deleteProduct: ${products.deleteProduct(product2)}") // false

    // Тестирование функции getName
    println("6. getName: ${products.getName("1")}") // Product 1
    println("7. getName: ${products.getName("2")}") // ""

    // Тестирование функции findByName
    val product4 = Product().apply {
        id = "4"
        name = "Product 1" // Совпадающее имя
    }
    products.addProduct(product4)

    val product5 = Product().apply {
        id = "5"
        name = "Product 2" // Несовпадающее имя
    }
    products.addProduct(product5)

    println("8. findByName: ${products.findByName("Product 1")}") // [1, 4]
    println("9. findByName: ${products.findByName("Product 2")}") // [5]
    println("10. findByName: ${products.findByName("Product 3")}") // []
}
package org.hanazono

fun main(){
    // Collections

    /*| Collection Type | Description                                                            |
    * |Lists            |Ordered collections of items                                            |
    * |Sets             |Unique unordered collections of items                                   |
    * |Maps             |Sets of key-value pairs where keys are unique and map to only one value |*/

    // Each collection type can be mutable or read only


    //================================================================================//


    // Lists - ORDER means CAN ACCESS DATA USING INDEX

    //= Lists store items in the order that they are added, and allow for duplicate items.
    //= To create a read-only 'List', use the 'ListOf()' function
    //= To create a 'MutableList', use the 'mutableListOf' function
    //= When creating lists, Kotlin can infer the type of items stored. To declare the type explicitly,
    //= add the type within angled brackets '< >' after the list declaration:

    // Read only list
    val readOnlyShapes = listOf("triangle", "square", "circle")
    println(readOnlyShapes)
    // OUTPUT: [triangle, square, cricle]

    // Mutable list with explicit type declaration
    val shapes: MutableList<String> = mutableListOf("triangle", "square", "circle")
    println(shapes)
    // OUTPUT: [triangle, square, circle]

    // To prevent unwanted modifications, you can create a read-only view of mutable list
    // by assigning it to a 'List:'

    val shapesLocked: List<String> = shapes
    println(shapesLocked)
    //This is also called 'casting'


    //= Lists are ordered so to access an item in a list, use the indexed access operator '[]'
    println("The first item in the list is: ${readOnlyShapes[0]}")
    // OUTPUT: the first item in the list is: triangle


    //= To get the first or last item in a list, use '.first()' and '.last()' function respectively:
    println("The first item in the list is: ${readOnlyShapes.first()}")
    // OUTPUT: The first item in the list is: triangle
    println("The last item in the list is: ${readOnlyShapes.last()}")
    // OUTPUT: The first item in the list is: circle


    //= To get the number of items in a list, use the '.count()' function:
    println("This list has ${readOnlyShapes.count()} items")
    // OUTPUT: This list has 3 items


    //= To check that an item is in a list, use the 'in' operator:
    println("circle" in readOnlyShapes)
    // OUTPUT: true


    //= To add or remove items from a mutable list, use '.add()' and '.remove() functions respectively:
    shapes.add("pentagon")
    println(shapes)
    // OUTPUT: [triangle, square, circle, pentagon]
    shapes.remove("pentagon")
    println(shapes)
    // OUTPUT: [triangle, square, circle]


    //================================================================================//


    // Set - NO ORDER means CAN'T ACCESS DATA USING INDEX / ONLY STORE 1 UNIQUE ITEMS

    //= Whereas lists are ordered and allow duplicate items, sets are unordered and only store unique items.
    //= To create a read-only 'Set', use the 'setOf()' function.
    //= To create a 'MutableSet', use the 'mutableSetOf()' function.
    //= When creating sets, Kotlin can infer the type of items stored. To declare the type explicitly,
    //= add the type within angled brackets '< >' after the set declaration:

    // Read-only set
    val readOnlyFruit = setOf("apple", "banana", "cherry", "cherry")
    //  Mutable set with explicit type declaration
    val fruit: MutableSet<String> = mutableSetOf("apple", "banana", "cherry", "cherry")

    println(readOnlyFruit)
    // [apple, banana, cherry]

    // To prevent unwanted modifications, you can create a read-only view of mutable set
    // by assigning it to a 'Set:'

    val fruitLocked: Set<String> = fruit
    println(fruitLocked)

    //= ! As sets are 'unordered', you can't access an item at a particular index.

    // To get the number of items in a set, use the '.count()' function.
    println("This set has ${readOnlyFruit.count()} items")
    // OUTPUT: This set has 3 items

    // To check that an item is in a set, use the 'in' operator:
    println("banana" in readOnlyFruit)
    // OUTPUT: true

    // To add or remove items from a mutable set, use '.add()' and '.remove()' functions
    fruit.add("dragonfruit")                // Add "dragonfruit" to the set
    println(fruit)                          // OUTPUT: [apple, banana, cherry, dragonfruit]

    fruit.remove("dragonfruit")     // Remove "dragonfruit" to the set
    println(fruit)                          // OUTPUT: [apple, banana, cherry]


    //================================================================================//


    // Map
    //= Maps store items as key-value pairs. You access the value by referencing the key. You can
    //= imagine a map like a food menu. You can find the price(value), by finding the food(key) you
    //= want to eat. Maps are useful if you want to look up a value without using a numbered index,
    //= like in a list.

    //= ! Every key in  a map must be unique so that Kotlin can understand which value you want to get.
    //= ! You can have duplicates values in a map.

    //= To create a read-only 'map', use the 'mapOf()' function
    //= To create a 'MutableMap', use the 'mutableMapOf()' function

    /* When creating maps, Kotlin can infer the type of items stored. To declare the type explicitly
    * add the types of they keys and values angled brackets '< >' after the map declaration. For Example:
    * 'MutableMap<String, Int>'. The keys have type 'String', and the values have type 'Int'.*/

    //= The easiest way to creat maps is to use 'to' between each key and its related value:

    // Read-only map
    val readOnlyJuiceMenu = mapOf("apple" to 100, "kiwi" to 190, "orange" to 100)
    println(readOnlyJuiceMenu)
    // OUTPUT: {apple=100, kiwi=190, orange=100}

    val juiceMenu: MutableMap<String, Int> = mutableMapOf("apple" to 100, "kiwi" to 190, "orange" to 100)
    // OUTPUT: {apple=100, kiwi=190, orange=100}

    //= ! To prevent unwanted modifications, you can create a read-only view of a mutable map by  assigning
    //= it to a 'Map:'

    val juiceMenuLocked: Map<String, Int> = juiceMenu
    println(juiceMenuLocked)

    //= To access a value in a map, use the indexed access operator '[]' with its 'key:'
    println("The value of apple juice is: ${readOnlyJuiceMenu["apple"]}")
    // OUTPUT: The value of apple juice is: 100

    //= ! If you try to access a key-value pair with a key that' doesn't exist in a map, you see a 'null' value:
    println("The value of pineapple juice is: ${readOnlyJuiceMenu["pineapple"]}")
    // OUTPUT: The value of pineapple juice is: null

    // You can also use the indexed access operator '[]' to add items to mutable map:
    juiceMenu["coconut"] = 150 // Add key 'coconut' with value of 150 to the map
    println(juiceMenu)
    // OUTPUT: {apple=100, kiwi=190, orange=100, coconut=150}

    // To remove items from a mutable map, use the '.remove()' function
    juiceMenu.remove("orange") // Remove key "orange" from the map
    println(juiceMenu)
    // OUTPUT: {apple=100, kiwi=190, coconut=150}

    // To get the number of items in a map, use the '.count()' function
    println("This map has ${juiceMenu.count()} key-value pairs")
    // OUTPUT: This map has 3 key-value pairs

    // To check if a specific key is already included in a map, use the '.containsKey()' function
    println(readOnlyJuiceMenu.containsKey("kiwi"))
    // OUTPUT: true

    // To Obtain a collection of keys or value of a map, use the 'keys' and 'values' properties respectively:
    println(readOnlyJuiceMenu.keys)
    // OUTPUT: [apple, kiwi, orange]
    println(readOnlyJuiceMenu.values)
    // OUTPUT: [100, 190, 100]

    //= ! 'keys' and 'values' are examples of 'properties' of an object. To access the property of an object, write
    //= the property name after the object appended with a period '.'

    //= ! Properties are discussed in more detail in the 'Classes' chapter. At this point in the tour, you only need to
    //= access them.

    // To check that a key or value is in a map, use the 'in' operator:
    println("orange" in readOnlyJuiceMenu.keys)
    // OUTPUT: true

    // Alternatively, you don't need to use the keys property
    println("orange" in readOnlyJuiceMenu)
    // OUTPUT: true

    println(200 in readOnlyJuiceMenu.values)
    // OUTPUT: false


    //================================================================================//


    // Ranges

    // Before talking about loops, it's useful to know how to construct ranges for loops to iterate over

    // The most common way to create range in Kotlin is to use the '..' operator. For example:
    // '1..4' is equivalent to 1,2,3,4.

    // To declare a range that doesn't include the end value, use the '..<' operator. For example:
    // '1..<4' is equivalent to 1,2,3

    // To declare a range in reverse order, use 'downTo'. For example, '4 downTo 1' is equivalent
    // to '4,3,2,1'

    // To declare a range that increments in a step that isn't 1, use 'step' and your desired increment value.
    // For example, '1..5 step 2' is equivalent to '1,3,5'

    // You can also do the same with 'Char' ranges:
    // * "'a'..'d'" is equivalent to 'a','b','c','d'
    // * "'z' downTo 's' step 2" is equivalent to 'z','x','v','t'


}
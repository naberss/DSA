package BST_questions

import kotlin.math.abs

fun main() {
    print(abs(0 - Int.MAX_VALUE))
}

open class BST3(value: Int) {
    var value = value
    var left: BST3? = null
    var right: BST3? = null

    fun insert(value: Int): BST3 {
        var currentNode: BST3 = this
        var wasInserted = false
        while(!wasInserted){

            when{
                value >= currentNode.value -> {
                    currentNode.right?.let {
                        currentNode = it
                    }?: run{
                        currentNode.right = BST3(value)
                        wasInserted = true
                    }
                }

                value < currentNode.value -> {
                    currentNode.left?.let {
                        currentNode = it
                    }?: run {
                        currentNode.left = BST3(value)
                        wasInserted = true
                    }
                }
            }
        }
        return this
    }

    fun contains(value: Int): Boolean {
        var currentNode:BST3? = this

        while(currentNode!=null){
            currentNode = when{
                value > currentNode.value -> {
                    currentNode.right
                }
                value < currentNode.value -> {
                    currentNode.left
                }
                else -> return true
            }
        }
        return false
    }

    private fun findSmallestValueAndRemoveV2(): Int {
        var currentNode: BST3? = this
        var value: Int = 0
        while (currentNode != null) {
            value = currentNode.value
            currentNode = currentNode.left
        }
        return value
    }


    
    fun remove(value: Int): BST3 {
        var currentNode: BST3? = this
        var wasRemoved = false
        
        while (!wasRemoved) {

            if (currentNode != null) {
                when{
                    value < currentNode.value -> {
                        currentNode = currentNode.right
                    }

                    value > currentNode.value -> {
                        currentNode = currentNode.left
                    }

                    else -> {
                        var count = 0
                        currentNode.right?.let { count ++ }
                        currentNode.left?.let { count ++ }
                        when{
                            (count == 0) -> {
                                currentNode = null
                                wasRemoved = true
                            }

                            (count == 1) -> {
                                if (currentNode.right != null) {
                                    currentNode = currentNode.right
                                    wasRemoved = true

                                } else if (currentNode.left != null) {
                                    currentNode = currentNode.left
                                    wasRemoved = true
                                }

                            }

                            (count == 2) -> {
                                val smallestValueCached = findSmallestValueAndRemoveV2()
                                remove(smallestValueCached)
                                currentNode.value= smallestValueCached
                                wasRemoved = true
                            }
                        }
                    }
                }
            }

        }
        return this
    }
}
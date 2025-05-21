package BST_questions

import kotlin.math.abs

fun main(){
    print(abs(0-Int.MAX_VALUE))
}

open class BST(value: Int) {
    var value = value
    var left: BST3? = null
    var right: BST3? = null
}

var closest: Int = Int.MAX_VALUE
fun findClosestValueInBst(tree: BST3, target: Int): Int {
    if(abs(tree.value - target) <= abs(closest - target)){
        closest = tree.value
    }

    if(target < tree.value){
        tree.left?.let { findClosestValueInBst(it,target) }
    } else {
        tree.right?.let { findClosestValueInBst(it,target) }
    }

    return closest
}
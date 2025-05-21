package arrays_questions

fun main(){
    print("testing")
}

fun twoNumberSum(array: MutableList<Int>, targetSum: Int): List<Int> {
    val targetArray: MutableList<Int> = mutableListOf()
    array.forEach {
        item1 ->
        array.forEach {
            item2 ->
            if (item1 != item2){
                val testValue = item1 + item2
                if(testValue == targetSum){
                    targetArray.add(item1)
                    targetArray.add(item2)
                    return targetArray
                }
            }
        }
    }
    return targetArray
}
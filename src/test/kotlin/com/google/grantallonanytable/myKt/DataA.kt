package com.google.grantallonanytable.myKt

import java.math.BigDecimal
import java.time.LocalDateTime

open class DataA(
    val field1: String?,
    val field2: Int?,
    val field3: Map<String, String>?,
    val field4: List<DataA1?>?,
    val field5: List<DataA2?>?
)

data class DataA1(
    val field11: String?,
    val field21: LocalDateTime?
)

data class DataA2(
    val field12: Int?,
    val field22: BigDecimal?
)

class DataB(
    field1: String?,
    field2: Int?,
    field3: Map<String, String>?,
    field4: List<DataA1?>?,
    field5: List<DataA2?>?,
    val field6: Map<String, Int>?,
    val field7: List<DataB1>?

): DataA(field1, field2, field3, field4, field5) {
    override fun toString(): String {
        return "DataB [field1=$field1; field2=$field2; field3=$field3; field4=$field4; field5=$field5;" +
                "field6=$field6; field7=$field7]"
    }
}

data class DataB1(
    val field11: Long
) {
    override fun toString(): String= field11.toString()
}

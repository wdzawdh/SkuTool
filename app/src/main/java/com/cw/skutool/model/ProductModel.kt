package com.cw.skutool.model

import com.cw.skutool.SkuTool


data class ProductModel(
    val code: Int,
    val resultMessage: String,
    val data: Product
)

data class EnablePathModel(
    val code: Int,
    val resultMessage: String,
    val data: List<EnablePath>
)

data class Product(
    val productInfos: List<SkuProperty>
)


data class SkuProperty(
    val id: Int,
    val name: String,
    var pricePropertyValueVos: List<SkuValue>,
) : SkuTool.Property {
    override fun getPropertyId() = id

    override fun getValues(): List<SkuTool.Value> = pricePropertyValueVos
}

data class SkuValue(
    val id: Int,
    val value: String,
    var selected: Boolean,
    var disable: Boolean,
) : SkuTool.Value {
    override fun getValueId() = id

    override fun isSelected() = selected

    override fun setCheckEnable(enable: Boolean) {
        disable = !enable
    }
}

data class EnablePath(
    val id: Int,
    var skuValueIdList: List<Int>
) : SkuTool.Path {
    override fun getValues(): List<Int> {
        return skuValueIdList
    }
}

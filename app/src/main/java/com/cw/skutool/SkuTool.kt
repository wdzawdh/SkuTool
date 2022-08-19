package com.cw.skutool


/**
 * Sku选择工具
 *
 * 思路参考 https://keelii.com/2016/12/22/sku-multi-dimensional-attributes-state-algorithm/
 */
object SkuTool {

    interface Property {
        fun getPropertyId(): Int
        fun getValues(): List<Value>
    }

    interface Value {
        fun getValueId(): Int
        fun isSelected(): Boolean
        fun setCheckEnable(enable: Boolean)
    }

    interface Path {
        fun getValues(): List<Int>
    }

    /**
     * 根据Sku选中状态和可选中路径 设置Sku的可点击状态
     * 在每次选中状态变化后调用
     *
     * @param propertyList 所有属性
     * @param pathList 所有可选中路径
     * @param onFinish 计算结束回调, hasMatch表示是否有匹配
     */
    fun checkEnable(
        propertyList: List<Property>,
        pathList: List<Path>,
        onFinish: ((hasMatch: Boolean) -> Unit)? = null
    ) {
        if (propertyList.isEmpty() || pathList.isEmpty()) {
            onFinish?.invoke(false)
            return
        }
        val selectValues = propertyList.flatMap { property ->
            property.getValues().filter { it.isSelected() }.map {
                Pair(property.getPropertyId(), it)
            }
        }
        val selectValueIds = selectValues.map { it.second.getValueId() }
        if (getEnablePaths(selectValueIds, pathList).isEmpty()) {
            //已选id不在可选中路径范围内
            onFinish?.invoke(false)
            return
        }

        val unselectValues = propertyList.flatMap { property ->
            property.getValues().filter { !it.isSelected() }.map {
                Pair(property.getPropertyId(), it)
            }
        }
        val enablePathsCache = arrayListOf<List<Path>>()
        //遍历所有非已选元素
        unselectValues.forEach { unselectValue ->
            val curProperty = unselectValue.first
            val curValue = unselectValue.second

            //1.取： a) 当前元素 b) 非当前元素所在的其它属性已选元素，形成一个路径
            val curPath = arrayListOf(curValue.getValueId()) //a
            selectValues.forEach { selectValue ->
                val property = selectValue.first
                val value = selectValue.second
                if (property != curProperty) {
                    curPath.add(value.getValueId()) //b
                }
            }
            //2.判断此路径是否存在（在所有可选路径中查询）
            val enablePaths = getEnablePaths(curPath, pathList)
            val enable = !enablePaths.isNullOrEmpty()
            curValue.setCheckEnable(enable)

            if (enable) {
                enablePathsCache.add(enablePaths)
            }
        }

        //保底逻辑，还有没选完的属性就已经找不到可选路径时就将所有Sku的enable置为true，保证不影响流程
        val hasUnselectProperty = selectValues.groupBy { it.first }.size < propertyList.size
        if (hasUnselectProperty && enablePathsCache.isEmpty()) {
            propertyList.forEach {
                it.getValues().forEach { value -> value.setCheckEnable(true) }
            }
            onFinish?.invoke(false)
        } else {
            onFinish?.invoke(true)
        }
    }

    private fun getEnablePaths(curPath: List<Int>, pathList: List<Path>): List<Path> {
        val enablePaths = pathList.filter { path ->
            val pathIdList = path.getValues()
            if (pathIdList.isEmpty()) {
                return@filter false
            }
            var containsPath = true
            for (curId in curPath) {
                if (!pathIdList.contains(curId)) {
                    containsPath = false
                    break
                }
            }
            containsPath
        }
        return enablePaths
    }
}
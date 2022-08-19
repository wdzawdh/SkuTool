package com.cw.skutool

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cw.skutool.model.EnablePathModel
import com.cw.skutool.model.ProductModel
import com.google.gson.Gson


class MainActivity : AppCompatActivity() {

    private val isStressTest = false //是否打开压力测试

    private val gson by lazy { Gson() }

    //sku的属性和元素
    private val propertyList by lazy {
        gson.fromJson(
            "{\"code\":200,\"resultMessage\":\"\",\"data\":{\"productInfos\":[{\"id\":1291,\"name\":\"小型号\",\"alias\":\"iPhone XS Max\",\"order\":0,\"type\":1,\"typeName\":\"基本问题\",\"isSkuProperty\":true,\"pricePropertyValueVos\":[{\"id\":9505,\"propertyName\":1291,\"value\":\"A2103\",\"order\":999,\"rankOrder\":999,\"isPreferred\":false,\"isSkuProperty\":true,\"isChoose\":false},{\"id\":7401,\"propertyName\":1291,\"value\":\"A2104\",\"order\":999,\"rankOrder\":999,\"isPreferred\":false,\"isSkuProperty\":true,\"isChoose\":false},{\"id\":7402,\"propertyName\":1291,\"value\":\"其他\",\"order\":999,\"rankOrder\":999,\"isPreferred\":false,\"isSkuProperty\":true,\"isChoose\":false}],\"skipInspectionType\":0},{\"id\":492,\"name\":\"网络制式\",\"alias\":\"新\",\"order\":4,\"type\":1,\"typeName\":\"基本问题\",\"isSkuProperty\":true,\"pricePropertyValueVos\":[{\"id\":3084,\"propertyName\":492,\"value\":\"全网通\",\"order\":999,\"rankOrder\":999,\"isPreferred\":false,\"isSkuProperty\":true,\"isChoose\":false}],\"skipInspectionType\":0},{\"id\":315,\"name\":\"存储容量\",\"alias\":\"新\",\"order\":10,\"type\":1,\"typeName\":\"基本问题\",\"isSkuProperty\":true,\"pricePropertyValueVos\":[{\"id\":2020,\"propertyName\":315,\"value\":\"8G\",\"order\":1,\"rankOrder\":1,\"isPreferred\":false,\"isSkuProperty\":true,\"isChoose\":false},{\"id\":2023,\"propertyName\":315,\"value\":\"64G\",\"order\":4,\"rankOrder\":4,\"isPreferred\":false,\"isSkuProperty\":true,\"isChoose\":false},{\"id\":2024,\"propertyName\":315,\"value\":\"128G\",\"order\":5,\"rankOrder\":5,\"isPreferred\":false,\"isSkuProperty\":true,\"isChoose\":false},{\"id\":3987,\"propertyName\":315,\"value\":\"256G\",\"order\":6,\"rankOrder\":6,\"isPreferred\":false,\"isSkuProperty\":true,\"isChoose\":false},{\"id\":7396,\"propertyName\":315,\"value\":\"512G\",\"order\":8,\"rankOrder\":8,\"isPreferred\":false,\"isSkuProperty\":true,\"isChoose\":false}],\"skipInspectionType\":0},{\"id\":314,\"name\":\"购买渠道\",\"alias\":\"新\",\"order\":12,\"type\":1,\"typeName\":\"基本问题\",\"isSkuProperty\":true,\"pricePropertyValueVos\":[{\"id\":2014,\"propertyName\":314,\"value\":\"大陆国行\",\"order\":1,\"rankOrder\":1,\"isPreferred\":true,\"isSkuProperty\":true,\"isChoose\":false},{\"id\":2984,\"propertyName\":314,\"value\":\"国行官换机\",\"order\":7,\"rankOrder\":7,\"isPreferred\":false,\"isSkuProperty\":true,\"isChoose\":false},{\"id\":10730,\"propertyName\":314,\"value\":\"资源机-BS国行\",\"order\":19,\"rankOrder\":19,\"isPreferred\":false,\"isSkuProperty\":true,\"isChoose\":false}],\"skipInspectionType\":0},{\"id\":456,\"name\":\"机身颜色\",\"alias\":\"新\",\"order\":17,\"type\":1,\"typeName\":\"基本问题\",\"isSkuProperty\":true,\"pricePropertyValueVos\":[{\"id\":2452,\"propertyName\":456,\"value\":\"金色\",\"order\":1,\"rankOrder\":1,\"isPreferred\":true,\"isSkuProperty\":true,\"isChoose\":false},{\"id\":2454,\"propertyName\":456,\"value\":\"黑色\",\"order\":2,\"rankOrder\":2,\"isPreferred\":false,\"isSkuProperty\":true,\"isChoose\":false},{\"id\":2959,\"propertyName\":456,\"value\":\"绿色\",\"order\":14,\"rankOrder\":14,\"isPreferred\":false,\"isSkuProperty\":true,\"isChoose\":false}],\"skipInspectionType\":0},{\"id\":333,\"name\":\"苹果保修期时长\",\"alias\":\"新\",\"order\":18,\"type\":1,\"typeName\":\"基本问题\",\"isSkuProperty\":true,\"pricePropertyValueVos\":[{\"id\":2072,\"propertyName\":333,\"value\":\"保修期一个月以上\",\"order\":0,\"rankOrder\":0,\"isPreferred\":true,\"isSkuProperty\":true,\"isChoose\":false},{\"id\":2075,\"propertyName\":333,\"value\":\"保修期一个月内或无保修\",\"order\":1,\"rankOrder\":1,\"isPreferred\":false,\"isSkuProperty\":true,\"isChoose\":false}],\"skipInspectionType\":0}],\"qualityInfos\":[{\"id\":316,\"name\":\"开机情况\",\"alias\":\"手机\",\"order\":1,\"type\":3,\"typeName\":\"主观问题\",\"isSkuProperty\":false,\"pricePropertyValueVos\":[{\"id\":2026,\"propertyName\":316,\"value\":\"正常开机\",\"order\":1,\"rankOrder\":1,\"isPreferred\":true,\"isSkuProperty\":false,\"isChoose\":true},{\"id\":2027,\"propertyName\":316,\"value\":\"无法开机\",\"order\":2,\"rankOrder\":2,\"isPreferred\":false,\"isSkuProperty\":false,\"isChoose\":false},{\"id\":9630,\"propertyName\":316,\"value\":\"有开机密码\",\"order\":4,\"rankOrder\":4,\"isPreferred\":false,\"isSkuProperty\":false,\"isChoose\":false}],\"skipInspectionType\":0,\"newCreated\":false,\"updated\":false},{\"id\":580,\"name\":\"触摸功能\",\"alias\":\"新12\",\"order\":1,\"type\":2,\"typeName\":\"功能使用问题\",\"isSkuProperty\":false,\"pricePropertyValueVos\":[{\"id\":3168,\"propertyName\":580,\"value\":\"触摸功能正常12\",\"order\":2,\"rankOrder\":2,\"isPreferred\":true,\"isSkuProperty\":false,\"isChoose\":true}],\"skipInspectionType\":0,\"newCreated\":false,\"updated\":false},{\"id\":352,\"name\":\"边框背板\",\"alias\":\"手机\",\"order\":2,\"type\":3,\"typeName\":\"主观问题\",\"isSkuProperty\":false,\"pricePropertyValueVos\":[{\"id\":2124,\"propertyName\":352,\"value\":\"全新机（已拆封，可无原机膜和卡针）\",\"order\":0,\"rankOrder\":0,\"isPreferred\":false,\"isSkuProperty\":false,\"isChoose\":false},{\"id\":2125,\"propertyName\":352,\"value\":\"外壳完美\",\"order\":1,\"rankOrder\":1,\"isPreferred\":true,\"isSkuProperty\":false,\"isChoose\":true},{\"id\":7937,\"propertyName\":352,\"value\":\"外壳划痕/小磕(划痕≥10mm,磕碰1.5-4mm)\",\"order\":4,\"rankOrder\":4,\"isPreferred\":false,\"isSkuProperty\":false,\"isChoose\":false},{\"id\":2128,\"propertyName\":352,\"value\":\"外壳明显磕碰/掉漆（≥3mm）\",\"order\":5,\"rankOrder\":5,\"isPreferred\":false,\"isSkuProperty\":false,\"isChoose\":false},{\"id\":7418,\"propertyName\":352,\"value\":\"外壳明显磕碰/掉漆（≥4mm）\",\"order\":6,\"rankOrder\":6,\"isPreferred\":false,\"isSkuProperty\":false,\"isChoose\":false},{\"id\":6874,\"propertyName\":352,\"value\":\"屏幕支架断开/错位\",\"order\":7,\"rankOrder\":7,\"isPreferred\":false,\"isSkuProperty\":false,\"isChoose\":false},{\"id\":6873,\"propertyName\":352,\"value\":\"外壳缺失/裂缝/孔变形/翘起/刻字\",\"order\":8,\"rankOrder\":8,\"isPreferred\":false,\"isSkuProperty\":false,\"isChoose\":false},{\"id\":6875,\"propertyName\":352,\"value\":\"屏幕支架断开+外壳缺失/裂缝/孔变形/刻字\",\"order\":9,\"rankOrder\":9,\"isPreferred\":false,\"isSkuProperty\":false,\"isChoose\":false},{\"id\":10024,\"propertyName\":352,\"value\":\"外壳无裂缝缺失\",\"order\":999,\"rankOrder\":999,\"isPreferred\":false,\"isSkuProperty\":false,\"isChoose\":false}],\"skipInspectionType\":0,\"newCreated\":false,\"updated\":false},{\"id\":355,\"name\":\"机身是否弯曲\",\"alias\":\"新\",\"order\":3,\"type\":2,\"typeName\":\"功能使用问题\",\"isSkuProperty\":false,\"pricePropertyValueVos\":[{\"id\":2134,\"propertyName\":355,\"value\":\"机身无弯曲\",\"order\":0,\"rankOrder\":0,\"isPreferred\":true,\"isSkuProperty\":false,\"isChoose\":true},{\"id\":6884,\"propertyName\":355,\"value\":\"轻微弯曲（弯曲1-2mm）\",\"order\":1,\"rankOrder\":1,\"isPreferred\":false,\"isSkuProperty\":false,\"isChoose\":false},{\"id\":2135,\"propertyName\":355,\"value\":\"明显弯曲（弯曲≥2mm）\",\"order\":2,\"rankOrder\":2,\"isPreferred\":false,\"isSkuProperty\":false,\"isChoose\":false}],\"skipInspectionType\":0,\"newCreated\":false,\"updated\":false},{\"id\":350,\"name\":\"屏幕显示\",\"alias\":\"手机\",\"order\":7,\"type\":3,\"typeName\":\"主观问题\",\"isSkuProperty\":false,\"pricePropertyValueVos\":[{\"id\":2114,\"propertyName\":350,\"value\":\"显示完美，无任何异常\",\"order\":1,\"rankOrder\":1,\"isPreferred\":true,\"isSkuProperty\":false,\"isChoose\":true},{\"id\":6876,\"propertyName\":350,\"value\":\"显示色斑（白色下非黑紫绿斑块，含色差）\",\"order\":3,\"rankOrder\":3,\"isPreferred\":false,\"isSkuProperty\":false,\"isChoose\":false},{\"id\":8565,\"propertyName\":350,\"value\":\"显示二层及下方透图（含色差色斑）\",\"order\":4,\"rankOrder\":4,\"isPreferred\":false,\"isSkuProperty\":false,\"isChoose\":false},{\"id\":9631,\"propertyName\":350,\"value\":\"显示黑色界面压伤（含色差色斑透图）\",\"order\":5,\"rankOrder\":5,\"isPreferred\":false,\"isSkuProperty\":false,\"isChoose\":false},{\"id\":2475,\"propertyName\":350,\"value\":\"显示异常（漏液/错乱/闪屏/屏生线）\",\"order\":6,\"rankOrder\":6,\"isPreferred\":false,\"isSkuProperty\":false,\"isChoose\":false},{\"id\":3304,\"propertyName\":350,\"value\":\"屏幕无法显示/全花屏\",\"order\":7,\"rankOrder\":7,\"isPreferred\":false,\"isSkuProperty\":false,\"isChoose\":false},{\"id\":9997,\"propertyName\":350,\"value\":\"无法检测\",\"order\":12,\"rankOrder\":12,\"isPreferred\":false,\"isSkuProperty\":false,\"isChoose\":false}],\"skipInspectionType\":0,\"newCreated\":false,\"updated\":false}],\"functionInfos\":[{\"id\":325,\"name\":\"通话功能\",\"alias\":\"手机\",\"order\":1,\"type\":2,\"typeName\":\"功能使用问题\",\"isSkuProperty\":false,\"pricePropertyValueVos\":[{\"id\":2045,\"propertyName\":325,\"value\":\"通话正常\",\"order\":0,\"rankOrder\":0,\"isPreferred\":true,\"isSkuProperty\":false,\"isChoose\":true},{\"id\":2047,\"propertyName\":325,\"value\":\"不读卡/不通话/无信号/无基带\",\"order\":1,\"rankOrder\":1,\"isPreferred\":false,\"isSkuProperty\":false,\"isChoose\":false},{\"id\":6941,\"propertyName\":325,\"value\":\"声音功能不正常\",\"order\":2,\"rankOrder\":2,\"isPreferred\":false,\"isSkuProperty\":false,\"isChoose\":false}],\"skipInspectionType\":0,\"newCreated\":false,\"updated\":false},{\"id\":343,\"name\":\"iCloud是否可注销\",\"alias\":\"新\",\"order\":1,\"type\":2,\"typeName\":\"功能使用问题\",\"isSkuProperty\":false,\"pricePropertyValueVos\":[{\"id\":2100,\"propertyName\":343,\"value\":\"iCloud已注销  \",\"order\":0,\"rankOrder\":0,\"isPreferred\":true,\"isSkuProperty\":false,\"isChoose\":true},{\"id\":2101,\"propertyName\":343,\"value\":\"iCloud无法注销  \",\"order\":1,\"rankOrder\":1,\"isPreferred\":false,\"isSkuProperty\":false,\"isChoose\":false}],\"skipInspectionType\":0,\"newCreated\":false,\"updated\":false},{\"id\":1811,\"name\":\"侧键\",\"alias\":\"\",\"order\":1,\"type\":1,\"typeName\":\"基本问题\",\"isSkuProperty\":false,\"pricePropertyValueVos\":[{\"id\":13518,\"propertyName\":1811,\"value\":\"侧键正常\",\"order\":999,\"rankOrder\":999,\"isPreferred\":true,\"isSkuProperty\":false,\"isChoose\":true},{\"id\":13519,\"propertyName\":1811,\"value\":\"无法检测侧键\",\"order\":999,\"rankOrder\":999,\"isPreferred\":false,\"isSkuProperty\":false,\"isChoose\":false}],\"skipInspectionType\":0,\"newCreated\":false,\"updated\":false},{\"id\":1812,\"name\":\"电池健康度\",\"alias\":\"\",\"order\":1,\"type\":2,\"typeName\":\"功能使用问题\",\"isSkuProperty\":false,\"pricePropertyValueVos\":[{\"id\":13520,\"propertyName\":1812,\"value\":\"电池无法检测健康度\",\"order\":999,\"rankOrder\":999,\"isPreferred\":true,\"isSkuProperty\":false,\"isChoose\":true},{\"id\":13521,\"propertyName\":1812,\"value\":\"电池健康度≤80%\",\"order\":999,\"rankOrder\":999,\"isPreferred\":false,\"isSkuProperty\":false,\"isChoose\":false}],\"skipInspectionType\":0,\"newCreated\":false,\"updated\":false},{\"id\":353,\"name\":\"受潮状况 \",\"alias\":\"手机\",\"order\":2,\"type\":2,\"typeName\":\"功能使用问题\",\"isSkuProperty\":false,\"pricePropertyValueVos\":[{\"id\":2129,\"propertyName\":353,\"value\":\"机身无进水\",\"order\":0,\"rankOrder\":0,\"isPreferred\":true,\"isSkuProperty\":false,\"isChoose\":true},{\"id\":6883,\"propertyName\":353,\"value\":\"机身有受潮（防潮标变色/非主板处生锈）\",\"order\":1,\"rankOrder\":1,\"isPreferred\":false,\"isSkuProperty\":false,\"isChoose\":false},{\"id\":2130,\"propertyName\":353,\"value\":\"机身进水（主板处生锈/水渍/霉斑/短路）\",\"order\":2,\"rankOrder\":2,\"isPreferred\":false,\"isSkuProperty\":false,\"isChoose\":false}],\"skipInspectionType\":0,\"newCreated\":false,\"updated\":false},{\"id\":344,\"name\":\"指纹功能\",\"alias\":\"新\",\"order\":6,\"type\":2,\"typeName\":\"功能使用问题\",\"isSkuProperty\":false,\"pricePropertyValueVos\":[{\"id\":2102,\"propertyName\":344,\"value\":\"指纹功能正常\",\"order\":1,\"rankOrder\":1,\"isPreferred\":true,\"isSkuProperty\":false,\"isChoose\":true},{\"id\":2103,\"propertyName\":344,\"value\":\"指纹无法完全录入和解锁\",\"order\":2,\"rankOrder\":2,\"isPreferred\":false,\"isSkuProperty\":false,\"isChoose\":false},{\"id\":10002,\"propertyName\":344,\"value\":\"无法检测\",\"order\":3,\"rankOrder\":3,\"isPreferred\":false,\"isSkuProperty\":false,\"isChoose\":false}],\"skipInspectionType\":0,\"newCreated\":false,\"updated\":false},{\"id\":1135,\"name\":\"面容识别功能\",\"alias\":\"新\",\"order\":7,\"type\":2,\"typeName\":\"功能使用问题\",\"isSkuProperty\":false,\"pricePropertyValueVos\":[{\"id\":5300,\"propertyName\":1135,\"value\":\"面容识别功能正常\",\"order\":0,\"rankOrder\":0,\"isPreferred\":true,\"isSkuProperty\":false,\"isChoose\":true},{\"id\":5299,\"propertyName\":1135,\"value\":\"面容无法录入和识别\",\"order\":1,\"rankOrder\":1,\"isPreferred\":false,\"isSkuProperty\":false,\"isChoose\":false}],\"skipInspectionType\":0,\"newCreated\":false,\"updated\":false},{\"id\":345,\"name\":\"拍摄功能\",\"alias\":\"新\",\"order\":8,\"type\":2,\"typeName\":\"功能使用问题\",\"isSkuProperty\":false,\"pricePropertyValueVos\":[{\"id\":2104,\"propertyName\":345,\"value\":\"拍照摄像正常\",\"order\":0,\"rankOrder\":0,\"isPreferred\":true,\"isSkuProperty\":false,\"isChoose\":true},{\"id\":6942,\"propertyName\":345,\"value\":\"画面异常（抖动/模糊/不对焦）\",\"order\":1,\"rankOrder\":1,\"isPreferred\":false,\"isSkuProperty\":false,\"isChoose\":false},{\"id\":2105,\"propertyName\":345,\"value\":\"拍照无法打开/报错/全黑/闪光灯坏\",\"order\":2,\"rankOrder\":2,\"isPreferred\":false,\"isSkuProperty\":false,\"isChoose\":false},{\"id\":9999,\"propertyName\":345,\"value\":\"无法检测\",\"order\":999,\"rankOrder\":999,\"isPreferred\":false,\"isSkuProperty\":false,\"isChoose\":false},{\"id\":10201,\"propertyName\":345,\"value\":\"后摄像头拍照有斑\",\"order\":999,\"rankOrder\":999,\"isPreferred\":false,\"isSkuProperty\":false,\"isChoose\":false}],\"skipInspectionType\":0,\"newCreated\":false,\"updated\":false},{\"id\":1364,\"name\":\"是否可恢复出厂设置\",\"alias\":\"手机\",\"order\":10,\"type\":2,\"typeName\":\"功能使用问题\",\"isSkuProperty\":false,\"pricePropertyValueVos\":[{\"id\":9625,\"propertyName\":1364,\"value\":\"已激活，可还原\",\"order\":0,\"rankOrder\":0,\"isPreferred\":true,\"isSkuProperty\":false,\"isChoose\":true},{\"id\":9626,\"propertyName\":1364,\"value\":\"已激活，无法还原\",\"order\":1,\"rankOrder\":1,\"isPreferred\":false,\"isSkuProperty\":false,\"isChoose\":false},{\"id\":10203,\"propertyName\":1364,\"value\":\"未激活\",\"order\":999,\"rankOrder\":999,\"isPreferred\":false,\"isSkuProperty\":false,\"isChoose\":false},{\"id\":10204,\"propertyName\":1364,\"value\":\"无法激活\",\"order\":999,\"rankOrder\":999,\"isPreferred\":false,\"isSkuProperty\":false,\"isChoose\":false}],\"skipInspectionType\":0,\"newCreated\":false,\"updated\":false},{\"id\":529,\"name\":\"指南针功能\",\"alias\":\"新\",\"order\":11,\"type\":2,\"typeName\":\"功能使用问题\",\"isSkuProperty\":false,\"pricePropertyValueVos\":[{\"id\":2808,\"propertyName\":529,\"value\":\"指南针功能正常\",\"order\":0,\"rankOrder\":0,\"isPreferred\":true,\"isSkuProperty\":false,\"isChoose\":true},{\"id\":2809,\"propertyName\":529,\"value\":\"指南针功能不正常\",\"order\":1,\"rankOrder\":1,\"isPreferred\":false,\"isSkuProperty\":false,\"isChoose\":false},{\"id\":10000,\"propertyName\":529,\"value\":\"无法检测\",\"order\":2,\"rankOrder\":2,\"isPreferred\":false,\"isSkuProperty\":false,\"isChoose\":false}],\"skipInspectionType\":0,\"newCreated\":false,\"updated\":false},{\"id\":346,\"name\":\"充电功能 \",\"alias\":\"新\",\"order\":12,\"type\":2,\"typeName\":\"功能使用问题\",\"isSkuProperty\":false,\"pricePropertyValueVos\":[{\"id\":2106,\"propertyName\":346,\"value\":\"充电正常\",\"order\":2,\"rankOrder\":2,\"isPreferred\":true,\"isSkuProperty\":false,\"isChoose\":true},{\"id\":2107,\"propertyName\":346,\"value\":\"充电无反应/充电孔接触不良\",\"order\":4,\"rankOrder\":4,\"isPreferred\":false,\"isSkuProperty\":false,\"isChoose\":false}],\"skipInspectionType\":0,\"newCreated\":false,\"updated\":false},{\"id\":1269,\"name\":\"震动功能\",\"alias\":\"FL\",\"order\":13,\"type\":2,\"typeName\":\"功能使用问题\",\"isSkuProperty\":false,\"pricePropertyValueVos\":[{\"id\":6949,\"propertyName\":1269,\"value\":\"振动正常\",\"order\":0,\"rankOrder\":0,\"isPreferred\":true,\"isSkuProperty\":false,\"isChoose\":true},{\"id\":6950,\"propertyName\":1269,\"value\":\"振动不正常\",\"order\":1,\"rankOrder\":1,\"isPreferred\":false,\"isSkuProperty\":false,\"isChoose\":false}],\"skipInspectionType\":0,\"newCreated\":false,\"updated\":false},{\"id\":1267,\"name\":\"实体按键功能\",\"alias\":\"大陆\",\"order\":14,\"type\":2,\"typeName\":\"功能使用问题\",\"isSkuProperty\":false,\"pricePropertyValueVos\":[{\"id\":6944,\"propertyName\":1267,\"value\":\"HOME按鍵正常\",\"order\":0,\"rankOrder\":0,\"isPreferred\":true,\"isSkuProperty\":false,\"isChoose\":true},{\"id\":6946,\"propertyName\":1267,\"value\":\"HOME键按压无反馈或失灵\",\"order\":1,\"rankOrder\":1,\"isPreferred\":false,\"isSkuProperty\":false,\"isChoose\":false}],\"skipInspectionType\":0,\"newCreated\":false,\"updated\":false},{\"id\":1809,\"name\":\"屏幕维修情况\",\"alias\":\"\",\"order\":4005,\"type\":3,\"typeName\":\"主观问题\",\"isSkuProperty\":false,\"pricePropertyValueVos\":[{\"id\":13508,\"propertyName\":1809,\"value\":\"屏幕无维修\",\"order\":999,\"rankOrder\":999,\"isPreferred\":true,\"isSkuProperty\":false,\"isChoose\":true},{\"id\":13509,\"propertyName\":1809,\"value\":\"外屏小修 \",\"order\":999,\"rankOrder\":999,\"isPreferred\":false,\"isSkuProperty\":false,\"isChoose\":false},{\"id\":13510,\"propertyName\":1809,\"value\":\"外屏维修\",\"order\":999,\"rankOrder\":999,\"isPreferred\":false,\"isSkuProperty\":false,\"isChoose\":false},{\"id\":13511,\"propertyName\":1809,\"value\":\"屏幕小修\",\"order\":999,\"rankOrder\":999,\"isPreferred\":false,\"isSkuProperty\":false,\"isChoose\":false},{\"id\":13512,\"propertyName\":1809,\"value\":\"屏幕维修\",\"order\":999,\"rankOrder\":999,\"isPreferred\":false,\"isSkuProperty\":false,\"isChoose\":false},{\"id\":13513,\"propertyName\":1809,\"value\":\"屏幕维修情况不检测\",\"order\":999,\"rankOrder\":999,\"isPreferred\":false,\"isSkuProperty\":false,\"isChoose\":false}],\"skipInspectionType\":0,\"newCreated\":false,\"updated\":false},{\"id\":1810,\"name\":\"主板维修情况\",\"alias\":\"\",\"order\":5007,\"type\":3,\"typeName\":\"主观问题\",\"isSkuProperty\":false,\"pricePropertyValueVos\":[{\"id\":13514,\"propertyName\":1810,\"value\":\"主板无维修\",\"order\":999,\"rankOrder\":999,\"isPreferred\":true,\"isSkuProperty\":false,\"isChoose\":true},{\"id\":13515,\"propertyName\":1810,\"value\":\"主板小修\",\"order\":999,\"rankOrder\":999,\"isPreferred\":false,\"isSkuProperty\":false,\"isChoose\":false},{\"id\":13516,\"propertyName\":1810,\"value\":\"主板维修\",\"order\":999,\"rankOrder\":999,\"isPreferred\":false,\"isSkuProperty\":false,\"isChoose\":false},{\"id\":13517,\"propertyName\":1810,\"value\":\"主板维修情况不检测\",\"order\":999,\"rankOrder\":999,\"isPreferred\":false,\"isSkuProperty\":false,\"isChoose\":false}],\"skipInspectionType\":0,\"newCreated\":false,\"updated\":false}],\"productLevelVos\":[{\"levelId\":573,\"levelName\":\"sss\"},{\"levelId\":503,\"levelName\":\"SS\"},{\"levelId\":404,\"levelName\":\"S\"},{\"levelId\":406,\"levelName\":\"A1\"},{\"levelId\":408,\"levelName\":\"A2\"},{\"levelId\":409,\"levelName\":\"B+1\"},{\"levelId\":411,\"levelName\":\"B+2\"},{\"levelId\":412,\"levelName\":\"B1\"},{\"levelId\":414,\"levelName\":\"B2\"},{\"levelId\":415,\"levelName\":\"C+1\"},{\"levelId\":417,\"levelName\":\"C+2\"},{\"levelId\":418,\"levelName\":\"C1\"},{\"levelId\":420,\"levelName\":\"C2\"},{\"levelId\":421,\"levelName\":\"D+1\"},{\"levelId\":423,\"levelName\":\"D+2\"},{\"levelId\":424,\"levelName\":\"D1\"},{\"levelId\":426,\"levelName\":\"D2\"},{\"levelId\":427,\"levelName\":\"D3\"},{\"levelId\":428,\"levelName\":\"E+1\"},{\"levelId\":430,\"levelName\":\"E+2\"},{\"levelId\":431,\"levelName\":\"E1\"},{\"levelId\":433,\"levelName\":\"E2\"},{\"levelId\":435,\"levelName\":\"F\"},{\"levelId\":436,\"levelName\":\"G+\"},{\"levelId\":437,\"levelName\":\"G1\"},{\"levelId\":439,\"levelName\":\"G2\"},{\"levelId\":440,\"levelName\":\"H+\"},{\"levelId\":441,\"levelName\":\"H1\"},{\"levelId\":443,\"levelName\":\"H2\"},{\"levelId\":444,\"levelName\":\"I+\"},{\"levelId\":445,\"levelName\":\"I1\"},{\"levelId\":447,\"levelName\":\"I2\"},{\"levelId\":448,\"levelName\":\"J+\"},{\"levelId\":450,\"levelName\":\"K+\"},{\"levelId\":449,\"levelName\":\"J\"},{\"levelId\":451,\"levelName\":\"K\"}]}}",
            ProductModel::class.java
        ).data.productInfos
    }

    //sku可用路径
    private val pathList by lazy {
        gson.fromJson(
            "{\"code\":200,\"resultMessage\":\"\",\"data\":[{\"id\":471529,\"skuValueIdList\":[2020,2072,2452,3084,7401,10730]},{\"id\":478213,\"skuValueIdList\":[2014,2023,2075,2452,3084,7401]},{\"id\":478498,\"skuValueIdList\":[2014,2072,2454,3084,7396,7401]},{\"id\":478499,\"skuValueIdList\":[2014,2075,2454,3084,7396,7401]},{\"id\":478510,\"skuValueIdList\":[2014,2020,2072,2452,3084,7401]},{\"id\":478511,\"skuValueIdList\":[2014,2024,2072,2452,3084,7401]},{\"id\":481146,\"skuValueIdList\":[2014,2024,2075,2452,3084,7401]},{\"id\":481147,\"skuValueIdList\":[2014,2024,2075,2452,3084,7402]},{\"id\":481148,\"skuValueIdList\":[2014,2024,2075,2452,3084,9505]},{\"id\":481149,\"skuValueIdList\":[2014,2075,2452,3084,3987,7401]},{\"id\":481150,\"skuValueIdList\":[2014,2075,2452,3084,3987,7402]},{\"id\":481151,\"skuValueIdList\":[2014,2075,2452,3084,3987,9505]},{\"id\":481152,\"skuValueIdList\":[2014,2024,2075,2454,3084,7401]},{\"id\":481153,\"skuValueIdList\":[2014,2024,2075,2454,3084,7402]},{\"id\":481154,\"skuValueIdList\":[2014,2024,2075,2454,3084,9505]},{\"id\":481155,\"skuValueIdList\":[2014,2075,2454,3084,3987,7401]},{\"id\":481156,\"skuValueIdList\":[2014,2075,2454,3084,3987,7402]},{\"id\":481157,\"skuValueIdList\":[2014,2075,2454,3084,3987,9505]},{\"id\":481164,\"skuValueIdList\":[2014,2024,2072,2452,3084,7402]},{\"id\":648386,\"skuValueIdList\":[2072,2959,2984,3084,3987,7402]},{\"id\":648387,\"skuValueIdList\":[2075,2959,2984,3084,3987,7402]}]}",
            EnablePathModel::class.java
        ).data
    }

    private val adapterList = arrayListOf<PropertyAdapter>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val llProduct = findViewById<LinearLayout>(R.id.ll_product)
        llProduct.removeAllViews()
        adapterList.clear()

        val propertyList = if (isStressTest) testPropertyList else propertyList
        val pathList = if (isStressTest) testPathList else pathList

        propertyList.forEach {
            val item = View.inflate(this, R.layout.sku_item, null)
            llProduct.addView(item)

            val tvTitle = item.findViewById<TextView>(R.id.tv_title)
            val recyclerview = item.findViewById<RecyclerView>(R.id.recyclerview)
            tvTitle.text = it.name
            recyclerview.layoutManager =
                LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
            val propertyAdapter = PropertyAdapter(it.pricePropertyValueVos) { id ->
                val startTime = System.currentTimeMillis()
                SkuTool.checkEnable(propertyList, pathList) {
                    adapterList.forEach { it.refresh() }
                }
                Log.d("耗时", (System.currentTimeMillis() - startTime).toString())
            }
            recyclerview.adapter = propertyAdapter
            adapterList.add(propertyAdapter)
        }
    }

    //----------------------------100倍压力测试-----------------------------


    private val testPropertyList by lazy {
        val testPropertyList = propertyList.toMutableList()
        testPropertyList.forEach { property ->
            val testValueList = property.pricePropertyValueVos.toMutableList()
            repeat(10) { testValueList.addAll(property.pricePropertyValueVos) }
            property.pricePropertyValueVos = testValueList
        }
        repeat(10) { testPropertyList.addAll(propertyList) }
        testPropertyList
    }

    private val testPathList by lazy {
        val testPathList = pathList.toMutableList()
        testPathList.forEach { path ->
            val testPathIdList = path.skuValueIdList.toMutableList()
            repeat(10) { testPathIdList.addAll(path.skuValueIdList) }
            path.skuValueIdList = testPathIdList
        }
        repeat(10) { testPathList.addAll(pathList) }
        testPathList
    }
}
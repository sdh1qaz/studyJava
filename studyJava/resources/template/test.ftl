[n2]${cr?substring(5,7)}月${cr?substring(8,10)}日


【充值查询】尊敬的客户，您好！您最近的充值记录为：<#assign num=0><#assign size=QPayRecordInfoPojo.result.listBusiRec?size>


代收费一般是您点播或定制梦网业务产生的费用，您${date?substring(0,4)}年[n2]${date?substring(4,6)}月没有产生代收费。


经查询，您本机办理宽带所在位置出现网络故障，影响电视正常观看，现工作人员正在积极抢修，预计${restoreTime?substring(0,4)}年[n2]${restoreTime?substring(4,6)}月${restoreTime?substring(6,8)}日${restoreTime?substring(8,10)}恢复正常，请您耐心等待，给您带来不便敬请谅解。


【代收费查询】尊敬的客户，您好！代收费一般是您点播或定制梦网业务产生的费用，查询您${date?substring(0,4)}年[n2]${date?substring(4,6)}月产生了${cr.dsFee}元的代收费，其中**费**元，**费**元。【中国移动】
代收费一般是您点播或定制梦网业务产生的费用，查询您${date?substring(0,4)}年[n2]${date?substring(4,6)}月产生了${cr.dsFee}元的代收费，其中**费**元，**费**元。

<#list QPayRecordInfoPojo.result.listBusiRec?sort_by("payDatetime")?reverse as l><#assign num=num+1>${l.payDatetime?substring(0,4)}年${l.payDatetime?substring(4,6)}月${l.payDatetime?substring(6,8)}日充值${l.amount}元<#if (num < 3) && (num < size)>，<#else>。<#break>
根据用户余额是否欠费进行不同的播报，模板如下：
欠费：截至*月*日*时，您的话费已欠费**元，本月累计消费**元。
未欠费：截至*月*日*时，您的话费余额**元，本月累计消费**元，（5月25日优化）


"oprTime": "20170906155455",
预付费欠费
sd001_tts02_1
截至[n2]${cb.result.oprTime?substring(4,6)}月${cb.result.oprTime?substring(6,8)}日${cb.result.oprTime?substring(8,10)}时，您的话费已欠费${cb.result.realFeeQryRsp.balance}元，本月累计消费${cb.result.realFeeQryRsp.currBillFeeFen?number/100}元。

sd001_sms02
【话费余额信息】尊敬的客户，您好！截至[n2]${cb.result.oprTime?substring(4,6)}月${cb.result.oprTime?substring(6,8)}日${cb.result.oprTime?substring(8,10)}，您的话费已欠费${cb.result.realFeeQryRsp.balance}元，本月累计消费${cb.result.realFeeQryRsp.currBillFeeFen?number/100}元。您当前放心用流量已用**，达到**GB会降速，降速后可继续使用，不额外收费；国内通用流量**，剩余**；其他流量**，剩余**。话费实时查询请点击安全链接：https://wx.online-cmcc.cn/website/personalHome/new/index 【中国移动】

预付费未欠费
sd001_tts02_2
截至[n2]${cb.result.oprTime?substring(4,6)}月${cb.result.oprTime?substring(6,8)}日${cb.result.oprTime?substring(8,10)}时，您的话费余额${cb.result.realFeeQryRsp.balance}元，本月累计消费${cb.result.realFeeQryRsp.currBillFeeFen?number/100}元。

sd001_sms01
【话费余额信息】尊敬的客户，您好！截至[n2]${cb.result.oprTime?substring(4,6)}月${cb.result.oprTime?substring(6,8)}日${cb.result.oprTime?substring(8,10)}时，您的话费余额${cb.result.realFeeQryRsp.balance}元，本月累计消费${cb.result.realFeeQryRsp.currBillFeeFen?number/100}元。您当前放心用流量已用**，达到**GB会降速，降速后可继续使用，不额外收费；国内通用流量**，剩余**；其他流量**，剩余**。话费实时查询请点击安全链接：https://wx.online-cmcc.cn/website/personalHome/new/index 【中国移动】


后付费欠费
sd001_tts01_1
截至[n2]${cb.result.oprTime?substring(4,6)}月${cb.result.oprTime?substring(6,8)}日${cb.result.oprTime?substring(8,10)}时，您本月累计消费${cb.result.realFeeQryRsp.currBillFeeFen?number/100}元，话费欠费${cb.result.realFeeQryRsp.availableBalance}元，往月未缴话费${cb.result.realFeeQryRsp.hisBillFee}元。
sd001_sms04
【话费余额信息】尊敬的客户，您好！截至[n2]${cb.result.oprTime?substring(4,6)}月${cb.result.oprTime?substring(6,8)}日${cb.result.oprTime?substring(8,10)}时，您本月累计消费${cb.result.realFeeQryRsp.currBillFeeFen?number/100}元，话费欠费${cb.result.realFeeQryRsp.availableBalance}元，往月未缴话费${cb.result.realFeeQryRsp.hisBillFee}元。您当前放心用流量已用**，达到**GB会降速，降速后可继续使用，不额外收费；国内通用流量**，剩余**；其他流量**，剩余**。话费实时查询请点击安全链接：https://wx.online-cmcc.cn/website/personalHome/new/index 【中国移动】

后付费未欠费
sd001_tts01_2
截至[n2]${cb.result.oprTime?substring(4,6)}月${cb.result.oprTime?substring(6,8)}日${cb.result.oprTime?substring(8,10)}时，您本月累计消费${cb.result.realFeeQryRsp.currBillFeeFen?number/100}元，话费余额${cb.result.realFeeQryRsp.availableBalance}元，往月未缴话费${cb.result.realFeeQryRsp.hisBillFee}元。
sd001_sms03
【话费余额信息】尊敬的客户，您好！截至[n2]${cb.result.oprTime?substring(4,6)}月${cb.result.oprTime?substring(6,8)}日${cb.result.oprTime?substring(8,10)}时，您本月累计消费${cb.result.realFeeQryRsp.currBillFeeFen?number/100}元，话费余额${cb.result.realFeeQryRsp.availableBalance}元，往月未缴话费${cb.result.realFeeQryRsp.hisBillFee}元。您当前放心用流量已用**，达到**GB会降速，降速后可继续使用，不额外收费；国内通用流量**，剩余**；其他流量**，剩余**。话费实时查询请点击安全链接：https://wx.online-cmcc.cn/website/personalHome/new/index 【中国移动】






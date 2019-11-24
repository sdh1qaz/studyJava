[n2]${cr?substring(5,7)}月${cr?substring(8,10)}日


【充值查询】尊敬的客户，您好！您最近的充值记录为：<#assign num=0><#assign size=QPayRecordInfoPojo.result.listBusiRec?size>


代收费一般是您点播或定制梦网业务产生的费用，您${date?substring(0,4)}年[n2]${date?substring(4,6)}月没有产生代收费。


您现在的放心用流量使用达到${bxSum}G会降速。

您放心用流量达到[n2]${total}G会降速，已用${total?number -leftNum?number}，系统已自动降速，网速下个账期自动恢复。

套餐外短彩信费一般是您发送短信或彩信产生的费用，您${date?substring(0,4)}年[n2]${date?substring(4,6)}月没有产生套餐外短彩信费。
（8月29日优化）


模板如下，请根据用户实际产生的费用进行播报 ，未产生则不播报。
套餐外短彩信费一般是您发送短信或彩信产生的费用，查询您${date?substring(0,4)}年[n2]${date?substring(4,6)}月产生了<#if tcwdxFee??>短信费${tcwdxFee?number/100}元，</#if><#if tcwcxFee??>彩信费${tcwcxFee?number/100}元，</#if>
短信费**元，彩信费**元。
（9月4日优化）

【套餐外短彩信费查询】尊敬的客户，您好！套餐外短彩信费一般是您发送短信或彩信产生的费用，查询您${date?substring(0,4)}年[n2]${date?substring(4,6)}月产生了套餐外短彩信费${tcwdcxFee?number/100}元，其中：<#if tcwdxFee??>短信费${tcwdxFee?number/100}元，</#if><#if tcwcxFee??>彩信费${tcwcxFee?number/100}元。</#if>【中国移动】

欠费的情况：
sd103_tts01
预付费：您的手机已停机，截至目前欠费${cb.result.realFeeQryRsp.balance?number?abs}元，充值开机后即可办理业务
sd103_tts03
后付费：您的手机已停机，截至目前您话费欠费${cb.result.realFeeQryRsp.availableBalance?number?abs}元，往月未缴话费${cb.result.realFeeQryRsp.hisBillFee?number?abs}元，充值开机后即可办理业务
未欠费情况：
sd103_tts02
预付费：现存在缴费开机不及时的情况，查询您目前话费余额${cb.result.realFeeQryRsp.balance?number?abs}元，如手机无法正常使用请将手机重新关开机测试，若仍未恢复，可稍等几分钟后再试
sd103_tts04
后付费：现存在缴费开机不及时的情况，查询您目前话费余额${cb.result.realFeeQryRsp.availableBalance?number?abs}元，往月未缴话费${cb.result.realFeeQryRsp.hisBillFee?number?abs}元，如手机无法正常使用请将手机重新关开机测试，若仍未恢复，可稍等几分钟后再试




1号账期下发模板：
【账期查询】尊敬的客户，您好！您的账期是1号，每月1号都会更新包月业务，如流量包、语音包，业务扣费时间在1号到7号。【中国移动】
非1号账期下发模板：
【账期查询】尊敬的客户，您好！您的账期是[n2]${accoutDay}号，本账期${cycleStart?substring(4,6)}月${cycleStart?substring(6,8)}号至${cycleEnd?substring(4,6)}月${cycleEnd?substring(6,8)}号，每个账期内前3天会扣除套餐及包月费用。【中国移动】



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

sd038_tts01
查询您本账期产生<#list tcwyy as t>${t.billItemName}${t.fee?number/100}元<#if t_has_next>，<#else>。</#if></#list>

sd038_tts02
查询您本账期产生<#list tcwyy as t>${t.billItemName}${t.fee?number/100}元<#if t_has_next>，<#else>。</#if></#list>您可登陆山东移动网上营业厅查询通话详单。

sd038_tts03
您${date?substring(0,4)}年[n2]${date?substring(4,6)}月未产生套餐外通话费。


sd038_tts04
查询您本账期产生<#list tcwyy as t>${t.billItemName}${t.fee?number/100}元<#if t_has_next>，<#else>。</#if></#list>

sd038_tts05
查询您${date?substring(0,4)}年[n2]${date?substring(4,6)}月产生了<#list tcwyy as t>${t.billItemName}${t.fee?number/100}元<#if t_has_next>，<#else>。</#if></#list>

有语音包月已使用完产生套餐外费用：sd038_sms01
【套餐外语音通信费查询】尊敬的客户，您好！查询截至${.now?string["MM月dd日HH时"]}，您的语音包月剩余情况如下：<#list cGSM as c>${c.privSet}含${t.sumNum}分钟，已使用完<#if c_has_next>，\r\n<#else>。</#if></#list>本账期产生套餐外语音通信费${tcwyyAll?number/100}元，其中：<#list tcwyy as t>${t.billItemName}${t.fee?number/100}元<#if t_has_next>，\r\n<#else>。</#if></#list>【中国移动】


有语音包月未产生套餐外费用：sd038_sms02
【套餐外语音通信费查询】尊敬的客户，您好！查询您本账期暂未产生套餐外语音通信费，您的语音包月截至${.now?string["MM月dd日HH时"]}剩余情况如下：<#list cGSM as c>${c.privSet}含${t.sumNum}分钟，剩余${t.leftNum}分钟<#if c_has_next>，\r\n<#else>。</#if></#list>【中国移动】

有语音包月未使用完产生套餐外费用：sd038_sms03
【套餐外语音通信费查询】尊敬的客户，您好！查询您本账期产生套餐外语音通信费${tcwyyAll?number/100}元，其中：<#list tcwyy as t>${t.billItemName}${t.fee?number/100}元<#if t_has_next>，\r\n<#else>。</#if></#list>您可登陆山东移动网上营业厅查询通话详单。【中国移动】

无语音包月产生套餐外费用：sd038_sms04
【套餐外语音通信费查询】尊敬的客户，您好！查询您本账期产生语音通信费${tcwyyAll?number/100}元，其中：<#list tcwyy as t>${t.billItemName}${t.fee?number/100}元<#if t_has_next>，\r\n<#else>。</#if></#list>【中国移动】

其他月份产生费用的短信模板：sd038_sms05
【套餐外语音通信费查询】尊敬的客户，您好！查询您${date?substring(0,4)}年[n2]${date?substring(4,6)}月产生语音通信费${tcwyyAll?number/100}元，其中：<#list tcwyy as t>${t.billItemName}${t.fee?number/100}元<#if t_has_next>，\r\n<#else>。</#if></#list>【中国移动】

sd12301_tts01_01
经查询，月初出账期扣了您本月的
<#if tcgdf??>套餐及固定费${tcgdf}元，</#if>
<#if zzywf??>增值业务费${zzywf}元，</#if>
<#if bNeed??><#list bNeed as b>${b.billItemName}${b.fee}元<#if b_has_next>，<#else>。</#if></#list></#if>
<#if yhjm??>另外给您优惠减免了${yhjm}元，</#if>
当前实际扣费${sjkf}元，暂时没有其他扣费。

sd12301_tts01_02
查询您[n2]${plist[0].payDate?substring(4,6)}月${plist[0].payDate?substring(6,8)}号交了${plist[0].amount}元话费，月初出账期扣除本月的
<#if tcgdf??>套餐及固定费${tcgdf}元，</#if>
<#if zzywf??>增值业务费${zzywf}元，</#if>
<#if bNeed??><#list bNeed as b>${b.billItemName}${b.fee}元<#if b_has_next>，<#else>。</#if></#list></#if>
<#if yhjm??>另外给您优惠减免了${yhjm}元，</#if>
当前实际扣费${sjkf}元，暂时没有其他扣费。

sd12301_tts01_03
查询您[n2]${plist[0].payDate?substring(4,6)}月${plist[0].payDate?substring(6,8)}号共交了${pSum}元话费，
<#list plist as p>第${p_index+1}次交了${p.amount}元<#if p_has_next>，<#else>。</#if></#list>
月初出账期扣除本月的
<#if tcgdf??>套餐及固定费${tcgdf}元，</#if>
<#if zzywf??>增值业务费${zzywf}元，</#if>
<#if bNeed??><#list bNeed as b>${b.billItemName}${b.fee}元<#if b_has_next>，<#else>。</#if></#list></#if>
<#if yhjm??>另外给您优惠减免了${yhjm}元，</#if>
当前实际扣费${sjkf}元，暂时没有其他扣费。


sd12301_tts01_04
查询您月初一共交了${pSum}元话费，其中
<#list plist as p>${p.payDate?substring(6,8)}号交了${p.amount}元<#if p_has_next>，<#else>。</#if></#list>
月初出账期扣除本月的
<#if tcgdf??>套餐及固定费${tcgdf}元，</#if>
<#if zzywf??>增值业务费${zzywf}元，</#if>
<#if bNeed??><#list bNeed as b>${b.billItemName}${b.fee}元<#if b_has_next>，<#else>。</#if></#list></#if>
<#if yhjm??>另外给您优惠减免了${yhjm}元，</#if>
当前实际扣费${sjkf}元，暂时没有其他扣费。

sd12301_tts02_01
查询您${month?substring(4,6)}月未达到协议消费补收${bsFee}元，本月又扣了您
<#if tcgdf??>套餐及固定费${tcgdf}元，</#if>
<#if zzywf??>增值业务费${zzywf}元，</#if>
<#if bNeed??><#list bNeed as b>${b.billItemName}${b.fee}元<#if b_has_next>，<#else>。</#if></#list></#if>
<#if yhjm??>另外给您优惠减免了${yhjm}元，</#if>
月初共扣费${ycgkf}元，暂时没有其他扣费。

sd12301_tts02_02
查询您[n2]${plist[0].payDate?substring(4,6)}月${plist[0].payDate?substring(6,8)}号交了${plist[0].amount}元话费，${month?substring(4,6)}月未达到协议消费补收${bsFee}元，本月又扣了您
<#if tcgdf??>套餐及固定费${tcgdf}元，</#if>
<#if zzywf??>增值业务费${zzywf}元，</#if>
<#if bNeed??><#list bNeed as b>${b.billItemName}${b.fee}元<#if b_has_next>，<#else>。</#if></#list></#if>
<#if yhjm??>另外给您优惠减免了${yhjm}元，</#if>
月初共扣费${ycgkf}元，暂时没有其他扣费。

sd12301_tts02_03
查询您[n2]${plist[0].payDate?substring(4,6)}月${plist[0].payDate?substring(6,8)}号共交了${pSum}元话费，
<#list plist as p>第${p_index+1}次交了${p.amount}元<#if p_has_next>，<#else>。</#if></#list>${month?substring(4,6)}月未达到协议消费补收${bsFee}元，本月又扣了您
<#if tcgdf??>套餐及固定费${tcgdf}元，</#if>
<#if zzywf??>增值业务费${zzywf}元，</#if>
<#if bNeed??><#list bNeed as b>${b.billItemName}${b.fee}元<#if b_has_next>，<#else>。</#if></#list></#if>
<#if yhjm??>另外给您优惠减免了${yhjm}元，</#if>
月初共扣费${ycgkf}元，暂时没有其他扣费。

sd12301_tts02_04
查询您月初一共交了${pSum}元话费，其中
<#list plist as p>${p.payDate?substring(6,8)}号交了${p.amount}元<#if p_has_next>，<#else>。</#if></#list>${month?substring(4,6)}月未达到协议消费补收${bsFee}元，本月又扣了您
<#if tcgdf??>套餐及固定费${tcgdf}元，</#if>
<#if zzywf??>增值业务费${zzywf}元，</#if>
<#if bNeed??><#list bNeed as b>${b.billItemName}${b.fee}元<#if b_has_next>，<#else>。</#if></#list></#if>
<#if yhjm??>另外给您优惠减免了${yhjm}元，</#if>
月初共扣费${ycgkf}元，暂时没有其他扣费。

sd034_tts01
您查询的PUK码是[n1]${puk}，再为您播报一遍，PUK码是${puk}；输入正确后，若屏幕提示输入PIN码时，输入1234即可，PUK连续输入10次错误手机卡被锁，需到营业厅办理补卡。请谨慎输入。


【PUK码查询】尊敬的客户，您好！您查询的手机PUK1码为[n1]${puk}，PUK连续输入10次错误手机卡被锁，需到营业厅办理补卡，请谨慎输入。输入正确后，若屏幕提示输入PIN1码时，输入1234即可（提示：PIN1码需输入2次）。【中国移动】

查询您${month?substring(4,6)}月未达到协议消费补收${bsFee?string('0.00')}元，本月又扣了您 <#if tcgdf??>套餐及固定费${tcgdf}元，</#if> <#if zzywf??>增值业务费${zzywf}元，</#if> <#if bNeed??><#list bNeed as b>${b.billItemName}${b.fee}元<#if b_has_next>，<#else>。</#if></#list></#if> <#if yhjm??>另外给您优惠减免了${yhjm}元，</#if> 月初共扣费${ycgkf}元，暂时没有其他扣费。


半年内最近的三次充值记录
sd010_tts01
我们可为您提供最近三次的缴费查询，请记录：<#assign num=0><#assign size=payHis?size><#list payHis?sort_by("payDate")?reverse as p><#assign num=num+1>${p.payDate?substring(0,4)}年[n2]${p.payDate?substring(4,6)}月${p.payDate?substring(6,8)}日充值${p.amount?number?string('0.00')?replace('.00','')}元<#if (num < 3) && (num < size)>，<#else>。<#break></#if></#list>

sd010_sms01
特殊说明：对于查询金额为0的短信不提供。
【充值记录查询】尊敬的客户，您好！您于
<#assign num=0><#assign size=payHis?size><#list payHis?sort_by("payDate")?reverse as p><#assign num=num+1>${p.payDate?substring(0,4)}年[n2]${p.payDate?substring(4,6)}月${p.payDate?substring(6,8)}日充值${p.amount?number?string('0.00')?replace('.00','')}元<#if (num < 3) && (num < size)>，<#else>。<#break></#if></#list>
也可以编辑短信“262*两位月份”如“262*09”发送到10086，查询缴费记录。更多服务请关注绑定“中国移动10086”微信公众号。【中国移动】



特殊说明：对于查询金额为0的语音不提供，
*年*月*日缴费*元，*年*月*日缴费*元，*年*月*日缴费*元。


以下为举例说明，请根据客户实际的情况播报，
您当前通话时长（含虚拟网）共[n2]${sum?string('0.00')?replace('.00','')}分钟，已用${used?string('0.00')?replace('.00','')}分钟，剩余${left?string('0.00')?replace('.00','')}分钟。


【剩余分钟数查询】尊敬的客户，您好！截至[n2]${.now?string["MM月dd日HH时"]}，您通话时长剩余${left?string('0.00')?replace('.00','')}分钟。具体明细如下：\r\n
<#list vl as v>（${v_index+1}）${v.privSet}，已用${(v.sumNum?number - v.leftNum?number)?string('0.00')?replace('.00','')}分钟，剩余${v.leftNum}分钟<#if v_has_next>；\r\n<#else>。\r\n</#if></#list>
更多套餐余量详情可关注绑定“中国移动10086”微信公众号查询。【中国移动】


sd095_tts01
<#assign ds=cInfo.cycleBeginDate><#assign de=cInfo.cycleEndDate>
[n1][y1]${ds?substring(0,4)}年[n2]${ds?substring(4.6)}月${ds?substring(6,8)}日至[n1][y1]${de?substring(0,4)}年[n2]${de?substring(4,6)}月${de?substring(6,8)}日，您的返还记录情况如下：
<#if al??>
协议款：
<#list al as a>${a_index+1}、您的${a.agrName}，已返还${a.agrCurMonthReturn}元，剩余金额为${a.agrMonthClosing}元<#if a_has_next>；<#else>。</#if></#list>
</#if>
<#if pl??>
赠送款：
<#list pl as p>${p_index+1}、您的${p.agrName}，已返还${p.preCurMonthReturn}元，剩余金额为${p.preMonthClosing}元，有效期：[n1][y1]${p.preEfftime?substring(0,4)}年[n2]${p.preEfftime?substring(4,6)}月<#if p_has_next>；<#else>。</#if></#list>
</#if>

协议款：
1、您的**，已返还**元，剩余金额为**元；
2、……
赠送款：
1、您的**，已返还**元，剩余金额为**元，有效期：**年**月；
2、……


【返还记录查询】尊敬的客户，您好！
<#assign ds=cInfo.cycleBeginDate><#assign de=cInfo.cycleEndDate>
${ds?substring(0,4)}年${ds?substring(4.6)}月${ds?substring(6,8)}日至${de?substring(0,4)}年${de?substring(4,6)}月${de?substring(6,8)}日，您的返还记录情况如下：\r\n
<#if al??>
协议款：\r\n
<#list al as a>${a_index+1}、您的${a.agrName}，已返还${a.agrCurMonthReturn}元，剩余金额为${a.agrMonthClosing}元<#if a_has_next>；\r\n<#else>。\r\n</#if></#list>
</#if>
<#if pl??>
赠送款：\r\n
<#list pl as p>${p_index+1}、您的${p.agrName}，已返还${p.preCurMonthReturn}元，剩余金额为${p.preMonthClosing}元，有效期：${p.preEfftime?substring(0,4)}年${p.preEfftime?substring(4,6)}月<#if p_has_next>；\r\n<#else>。\r\n</#if></#list>
</#if>
【中国移动】



您现在的套餐是<#list bs as b><#if b.productType=='01'>${b.bunessName}、</#if></#list>
，具体业务的查询链接已下发至您的手机上，请注意查收。您也可关注“中国移动10086”微信公众号详细查询本机业务


5月28日优化：
您现在的套餐是<#list bs as b><#if b.productType=='01'>${b.bunessName}、</#if></#list>。

sd035_tts01
您本机截至当前产生了增值业务费${zzywf?string('0.00')?replace('.00','')}元，包括：
<#list zl as z>${z_index+1}、${z.billItemName}，${(z.fee?number/100)?string('0.00')?replace('.00','')}元<#if z_has_next>；<#else>。</#if></#list>


sd035_sms01

【增值业务费查询】尊敬的客户，您好！当前您开通的增值业务是${zl[0].billItemName}，${(zl[0].fee?number/100)?string('0.00')?replace('.00','')}元，您可编辑短信0000至10086查询定制的除套餐外的增值业务，根据短信内容回复序号取消相应的业务。【中国移动】

开通的增值业务有两项以上的下发模板：

sd035_sms02
【增值业务费查询】尊敬的客户，您好！当前您开通的增值业务有：\r\n
<#list zl as z>${z_index+1}、${z.billItemName}，${(z.fee?number/100)?string('0.00')?replace('.00','')}元<#if z_has_next>；\r\n<#else>。\r\n</#if></#list>
您可编辑短信0000至10086查询定制的除套餐外的增值业务，根据短信内容回复序号取消相应的业务。【中国移动】

sd006_tts01
9月3日优化：
以下为举例说明，请根据客户实际情况播报，
通话时长（含虚拟网）共**分钟，已用**分钟，剩余**分钟
放心用流量已用**，达到**G会降速，降速后可继续使用，不额外收费；国内通用流量共**，已用**，剩余**；其他流量共**，已用**，剩余**。
短信共**条，已用**，剩余**。

<#assign thscAll=0>
<#assign thscLeft=0>
<#assign fxyUsed=0>
<#assign fxyJs=0>
<#assign gntyAll=0>
<#assign gntyLeft=0>
<#assign qtAll=0>
<#assign qtLeft=0>
<#assign msgAll=0>
<#assign msgLeft=0>
<#list cp as c>
<#if c.type=="GSM"><#assign thscAll+=c.sumNum?number><#assign thscLeft+=c.leftNum?number></#if>
<#if c.bizType=="不限流量"><#assign fxyJs=c.sumNum?number><#assign fxyUsed=c.sumNum?number-c.leftNum?number></#if>
<#if c.bizType=="国内通用流量"><#assign gntyAll+=c.sumNum?number><#assign gntyLeft+=c.leftNum?number></#if>
<#if c.type=="GPRS" && c.bizType!="不限流量" && c.bizType!="国内通用流量"><#assign qtAll+=c.sumNum?number><#assign qtLeft+=c.leftNum?number></#if>
<#if c.type=="SMS"><#assign msgAll+=c.sumNum?number><#assign msgLeft+=c.leftNum?number></#if>
</#list>
<#if thscAll gt 0>通话时长（含虚拟网）共${thscAll?string('#.##')}分钟，已用${(thscAll-thscLeft)?string('#.##')}分钟，剩余${thscLeft?string('#.##')}分钟</#if>
<#if fxyJs gt 0>放心用流量已用<#if fxyUsed gt 1024>${(fxyUsed/1024)?string('#.##')}G<#else>${fxyUsed?string('#.##')}M</#if>，达到${(fxyJs/1024)?string('#.##')}G会降速，降速后可继续使用，不额外收费；</#if>
<#if gntyAll gt 0>国内通用流量共<#if gntyAll gt 1024>${(gntyAll/1024)?string('#.##')}G<#else>${gntyAll?string('#.##')}M</#if>，已用<#if gntyAll-gntyLeft gt 1024>${((gntyAll-gntyLeft)/1024)?string('#.##')}G<#else>${(gntyAll-gntyLeft)?string('#.##')}M</#if>，剩余<#if gntyLeft gt 1024>${(gntyLeft/1024)?string('#.##')}G<#else>${gntyLeft?string('#.##')}M</#if>；</#if>
<#if qtAll gt 0>其他流量共<#if qtAll gt 1024>${(qtAll/1024)?string('#.##')}G<#else>${qtAll}M</#if>，已用<#if qtAll-qtLeft gt 1024>${(qtAll-qtLeft)/1024?string('#.##')}G<#else>${(qtAll-qtLeft)?string('#.##')}M</#if>，剩余<#if qtLeft gt 1024>${(qtLeft/1024)?string('#.##')}G<#else>${qtLeft?string('#.##')}M</#if>。</#if>
<#if msgAll gt 0>短信共${msgAll}条，已用${msgAll-msgLeft}条，剩余${msgLeft}。</#if>











<#if c.bizType=="不限流量"><#assign fxyJs=c.sumNum?number><#assign fxyUsed=c.sumNum?number-c.leftNum?number></#if>
<#if c.bizType=="国内通用流量"><#assign gntyAll+=c.sumNum?number><#assign gntyLeft+=c.leftNum?number></#if>
<#if c.type=="GPRS" && c.bizType!="不限流量" && c.bizType!="国内通用流量"><#assign qtAll+=c.sumNum?number><#assign qtLeft+=c.leftNum?number></#if>
<#if c.type=="SMS"><#assign msgAll+=c.sumNum?number><#assign msgLeft+=c.leftNum?number></#if>



sd006_sms01********************************
<#assign gntyAll=0>
<#assign gntyLeft=0>
<#assign gntyjzAll=0>
<#assign gntyjzLeft=0>
<#assign msgAll=0>
<#assign msgLeft=0>
<#assign thsc=0>
<#assign swtc=0>
<#list cp as c>
<#if c.type=="GSM"><#assign thsc+=1></#if>
<#if c.type=="GPRS"><#assign swtc+=1></#if>
<#if c.type=="SMS"><#assign msgAll+=c.sumNum?number><#assign msgLeft+=c.leftNum?number></#if>
<#if c.bizType=="国内通用流量"><#assign gntyAll+=c.sumNum?number><#assign gntyLeft+=c.leftNum?number>
<#if c.privSet?index_of("结转")!=-1><#assign gntyjzAll+=c.sumNum?number><#assign gntyjzLeft+=c.leftNum?number></#if>
</#if>
</#list>
【套餐余量信息】尊敬的客户，您好！以下是截至${.now?string["MM月dd日HH时"]}套餐具体使用情况：\r\n
<#if thsc gt 0>
<#assign n1=0>
【通话时长】：\r\n<#list cp as c>
<#if c.type=="GSM"><#assign n1=n1+1>（${n1}）${c.privSet}，已用${c.sumNum?number-c.leftNum?number}分钟，剩余${c.leftNum}分钟<#if n1 lt thsc>；<#else>。</#if>\r\n</#if>
</#list>
</#if>
<#if swtc gt 0>
<#assign n2=0>
【上网套餐】：\r\n
<#if gntyAll gt 0><#assign n2=n2+1>（${n2}）国内通用流量共<#if gntyAll gt 1024>${(gntyAll/1024)?string('#.##')}GB<#else>${gntyAll?string('#.##')}MB</#if>，已用<#if gntyAll-gntyLeft gt 1024>${((gntyAll-gntyLeft)/1024)?string('#.##')}GB<#else>${(gntyAll-gntyLeft)?string('#.##')}MB</#if>，剩余<#if gntyLeft gt 1024>${(gntyLeft/1024)?string('#.##')}GB<#else>${gntyLeft?string('#.##')}MB</#if><#if gntyjzAll gt 0>，上月结转流量<#if gntyjzAll gt 1024>${(gntyjzAll/1024)?string('#.##')}GB<#else>${gntyjzAll?string('#.##')}MB</#if>，剩余<#if gntyjzLeft gt 1024>${(gntyjzLeft/1024)?string('#.##')}GB<#else>${gntyjzLeft?string('#.##')}MB</#if></#if>；\r\n</#if>
<#list cp as c>
<#if c.bizType=="不限流量"><#assign n2=n2+1>（${n2}）${c.privSet}，已用<#if c.sumNum?number-c.leftNum?number gt 1024>${((c.sumNum?number-c.leftNum?number)/1024)?string('#.##')}GB<#else>${(c.sumNum?number-c.leftNum?number)?string('#.##')}M</#if>达到${(c.sumNum?number/1024)?string('#.##')}GB会降速，降速后可继续使用，不额外收费<#if n2 lt swtc>；<#else>。</#if>\r\n</#if>
<#if c.type=="GPRS" && c.bizType!="不限流量" && c.bizType!="国内通用流量"><#assign n2=n2+1>（${n2}）${c.privSet}，本月共<#if c.sumNum?number gt 1024>${(c.sumNum?number/1024)?string('#.##')}GB<#else>${(c.sumNum?number)?string('#.##')}MB</#if>，已用<#if c.sumNum?number - c.leftNum?number gt 1024>${((c.sumNum?number - c.leftNum?number)/1024)?string('#.##')}GB<#else>${(c.sumNum?number - c.leftNum?number)?string('#.##')}MB</#if>，剩余<#if c.leftNum?number gt 1024>${(c.leftNum?number/1024)?string('#.##')}GB<#else>${(c.leftNum?number)?string('#.##')}MB</#if>；\r\n</#if>
</#list>
</#if>
<#if msgAll gt 0>
【短信包月】：共${msgAll}条，已用${msgAll-msgLeft}条，剩余${msgLeft}。
</#if>
***********************************************************




<#if thscAll gt 0>通话时长（含虚拟网）共${thscAll?string('#.##')}分钟，已用${(thscAll-thscLeft)?string('#.##')}分钟，剩余${thscLeft?string('#.##')}分钟</#if>
<#if fxyJs gt 0>放心用流量已用<#if fxyUsed gt 1024>${(fxyUsed/1024)?string('#.##')}G<#else>${fxyUsed?string('#.##')}M</#if>，达到${(fxyJs/1024)?string('#.##')}G会降速，降速后可继续使用，不额外收费；</#if>
<#if gntyAll gt 0>国内通用流量共<#if gntyAll gt 1024>${(gntyAll/1024)?string('#.##')}G<#else>${gntyAll?string('#.##')}M</#if>，已用<#if gntyAll-gntyLeft gt 1024>${((gntyAll-gntyLeft)/1024)?string('#.##')}G<#else>${(gntyAll-gntyLeft)?string('#.##')}M</#if>，剩余<#if gntyLeft gt 1024>${(gntyLeft/1024)?string('#.##')}G<#else>${gntyLeft?string('#.##')}M</#if>；</#if>
<#if qtAll gt 0>其他流量共<#if qtAll gt 1024>${(qtAll/1024)?string('#.##')}G<#else>${qtAll}M</#if>，已用<#if qtAll-qtLeft gt 1024>${(qtAll-qtLeft)/1024?string('#.##')}G<#else>${(qtAll-qtLeft)?string('#.##')}M</#if>，剩余<#if qtLeft gt 1024>${(qtLeft/1024)?string('#.##')}G<#else>${qtLeft?string('#.##')}M</#if>。</#if>
<#if msgAll gt 0>短信共${msgAll}条，已用${msgAll-msgLeft}条，剩余${msgLeft}。</#if>


sd006_sms01
以下为举例说明，请根据客户实际的情况下发短信。
优化模板：
【套餐余量信息】尊敬的客户，您好！以下是截至*月*日*时套餐具体使用情况：
【通话时长】：
（1）**，已用**分钟，剩余**分钟；
（2）**，已用**分钟，剩余**分钟；
……。
【上网套餐】：
（1）**，已用**，达到**GB会降速，降速后可继续使用，不额外收费；
（2）**，本月共**MB，已用**MB，剩余**MB，上月结转流量**MB，剩余**MB；
（3）…………。
【短信包月】：共**条，已用**，剩余**。
套餐余量详情请点击安全链接：https://wx.online-cmcc.cn/website/personalHome/new/index 【中国移动】



sd007_tts01
您当前国内通用流量**，已用**，剩余**；其他流量**，已用**，剩余**。
<#assign gntyAll=0>
<#assign gntyLeft=0>
<#assign qtAll=0>
<#assign qtLeft=0>
<#list cp as c>
<#if c.bizType=="国内通用流量"><#assign gntyAll+=c.sumNum?number><#assign gntyLeft+=c.leftNum?number></#if>
<#if c.bizType!="国内通用流量"><#assign qtAll+=c.sumNum?number><#assign qtLeft+=c.leftNum?number></#if>
</#list>
<#if gntyAll gt 0>您当前国内通用流量<#if gntyAll gt 1024>${(gntyAll/1024)?string('#.##')}G<#else>${gntyAll?string('#.##')}M</#if>，已用<#if gntyAll-gntyLeft gt 1024>${((gntyAll-gntyLeft)/1024)?string('#.##')}G<#else>${(gntyAll-gntyLeft)?string('#.##')}M</#if>，剩余<#if gntyLeft gt 1024>${(gntyLeft/1024)?string('#.##')}G<#else>${gntyLeft?string('#.##')}M</#if>；</#if>
<#if qtAll gt 0>其他流量<#if qtAll gt 1024>${(qtAll/1024)?string('#.##')}G<#else>${qtAll}M</#if>，已用<#if qtAll-qtLeft gt 1024>${(qtAll-qtLeft)/1024?string('#.##')}G<#else>${(qtAll-qtLeft)?string('#.##')}M</#if>，剩余<#if qtLeft gt 1024>${(qtLeft/1024)?string('#.##')}G<#else>${qtLeft?string('#.##')}M</#if>。</#if>


sd007_tts02
您本机放心用流量已用**，使用达到**G会降速，降速后可继续使用，不额外收费；**流量**，已用**，剩余**，**流量**，已用**，剩余**，……。
<#assign fxyUsed=0>
<#assign fxyJs=0>
<#assign gntyAll=0>
<#assign gntyLeft=0>
<#assign qtAll=0>
<#assign qtLeft=0>
<#list cp as c>
<#if c.bizType=="不限流量"><#assign fxyJs=c.sumNum?number><#assign fxyUsed=c.sumNum?number-c.leftNum?number></#if>
<#if c.bizType=="国内通用流量"><#assign gntyAll+=c.sumNum?number><#assign gntyLeft+=c.leftNum?number></#if>
<#if c.bizType!="不限流量" && c.bizType!="国内通用流量"><#assign qtAll+=c.sumNum?number><#assign qtLeft+=c.leftNum?number></#if>
</#list>
<#if fxyJs gt 0>您本机放心用流量已用<#if fxyUsed gt 1024>${(fxyUsed/1024)?string('#.##')}G<#else>${fxyUsed?string('#.##')}M</#if>，使用达到${(fxyJs/1024)?string('#.##')}G会降速，降速后可继续使用，不额外收费；</#if>
<#if gntyAll gt 0>国内通用流量<#if gntyAll gt 1024>${(gntyAll/1024)?string('#.##')}G<#else>${gntyAll?string('#.##')}M</#if>，已用<#if gntyAll-gntyLeft gt 1024>${((gntyAll-gntyLeft)/1024)?string('#.##')}G<#else>${(gntyAll-gntyLeft)?string('#.##')}M</#if>，剩余<#if gntyLeft gt 1024>${(gntyLeft/1024)?string('#.##')}G<#else>${gntyLeft?string('#.##')}M</#if>；</#if>
<#if qtAll gt 0>其他流量<#if qtAll gt 1024>${(qtAll/1024)?string('#.##')}G<#else>${qtAll}M</#if>，已用<#if qtAll-qtLeft gt 1024>${(qtAll-qtLeft)/1024?string('#.##')}G<#else>${(qtAll-qtLeft)?string('#.##')}M</#if>，剩余<#if qtLeft gt 1024>${(qtLeft/1024)?string('#.##')}G<#else>${qtLeft?string('#.##')}M</#if>。</#if>


sd007_tts03
您本机放心用流量使用达到**G会降速，已用**，系统已自动降速；**流量**，已用**，剩余**，**流量**，已用**，剩余**，……。
<#assign fxyUsed=0>
<#assign fxyJs=0>
<#assign gntyAll=0>
<#assign gntyLeft=0>
<#assign qtAll=0>
<#assign qtLeft=0>
<#list cp as c>
<#if c.bizType=="不限流量"><#assign fxyJs=c.sumNum?number><#assign fxyUsed=c.sumNum?number-c.leftNum?number></#if>
<#if c.bizType=="国内通用流量"><#assign gntyAll+=c.sumNum?number><#assign gntyLeft+=c.leftNum?number></#if>
<#if c.bizType!="不限流量" && c.bizType!="国内通用流量"><#assign qtAll+=c.sumNum?number><#assign qtLeft+=c.leftNum?number></#if>
</#list>
<#if fxyJs gt 0>您本机放心用流量使用达到${(fxyJs/1024)?string('#.##')}G会降速，已用<#if fxyUsed gt 1024>${(fxyUsed/1024)?string('#.##')}G<#else>${fxyUsed?string('#.##')}M</#if>，系统已自动降速；</#if>
<#if gntyAll gt 0>国内通用流量<#if gntyAll gt 1024>${(gntyAll/1024)?string('#.##')}G<#else>${gntyAll?string('#.##')}M</#if>，已用<#if gntyAll-gntyLeft gt 1024>${((gntyAll-gntyLeft)/1024)?string('#.##')}G<#else>${(gntyAll-gntyLeft)?string('#.##')}M</#if>，剩余<#if gntyLeft gt 1024>${(gntyLeft/1024)?string('#.##')}G<#else>${gntyLeft?string('#.##')}M</#if>；</#if>
<#if qtAll gt 0>其他流量<#if qtAll gt 1024>${(qtAll/1024)?string('#.##')}G<#else>${qtAll}M</#if>，已用<#if qtAll-qtLeft gt 1024>${(qtAll-qtLeft)/1024?string('#.##')}G<#else>${(qtAll-qtLeft)?string('#.##')}M</#if>，剩余<#if qtLeft gt 1024>${(qtLeft/1024)?string('#.##')}G<#else>${qtLeft?string('#.##')}M</#if>。</#if>



sd007_sms01
以下为举例说明，请根据客户实际的情况下发短信，若剩余流量为0则无需以小数点展示，且小数点后两位如均为0则展示，不为0则保留小数点两位数即可。（“不限量”修改为”放心用“优先，顺序1为不限量套餐，若无不限量则顺序2提前）若用户不是不限量则不限量的内容不下发。
<#assign fxyUsed=0>
<#assign fxyJs=0>
<#assign gntyAll=0>
<#assign gntyLeft=0>
<#assign qtAll=0>
<#assign qtLeft=0>
<#assign gntyjzAll=0>
<#assign gntyjzLeft=0>
<#list cp as c>
<#if c.bizType=="不限流量"><#assign fxyJs=c.sumNum?number><#assign fxyUsed=c.sumNum?number-c.leftNum?number></#if>
<#if c.bizType=="国内通用流量"><#assign gntyAll+=c.sumNum?number><#assign gntyLeft+=c.leftNum?number>
<#if c.privSet?index_of("结转")!=-1><#assign gntyjzAll+=c.sumNum?number><#assign gntyjzLeft+=c.leftNum?number></#if>
</#if>
<#if c.bizType!="不限流量" && c.bizType!="国内通用流量"><#assign qtAll+=c.sumNum?number><#assign qtLeft+=c.leftNum?number></#if>
</#list>
<#assign n1=0>
【流量剩余信息】尊敬的客户，您好！截至${.now?string["MM月dd日HH时"]}
<#if fxyJs gt 0>放心用流量已用<#if fxyUsed gt 1024>${(fxyUsed/1024)?string('#.##')}GB<#else>${fxyUsed?string('#.##')}MB</#if>，使用达到${(fxyJs/1024)?string('#.##')}GB会降速，降速后可继续使用，不额外收费；</#if>
<#if gntyAll gt 0>国内通用流量<#if gntyAll gt 1024>${(gntyAll/1024)?string('#.##')}GB<#else>${gntyAll?string('#.##')}MB</#if>，已用<#if gntyAll-gntyLeft gt 1024>${((gntyAll-gntyLeft)/1024)?string('#.##')}GB<#else>${(gntyAll-gntyLeft)?string('#.##')}MB</#if>，剩余<#if gntyLeft gt 1024>${(gntyLeft/1024)?string('#.##')}GB<#else>${gntyLeft?string('#.##')}MB</#if>；</#if>
<#if qtAll gt 0>其他流量<#if qtAll gt 1024>${(qtAll/1024)?string('#.##')}GB<#else>${qtAll?string('#.##')}MB</#if>，已用<#if qtAll-qtLeft gt 1024>${(qtAll-qtLeft)/1024?string('#.##')}GB<#else>${(qtAll-qtLeft)?string('#.##')}MB</#if>，剩余<#if qtLeft gt 1024>${(qtLeft/1024)?string('#.##')}G<#else>${qtLeft?string('#.##')}MB</#if>。</#if>
以下是具体明细：\r\n
<#if fxyJs gt 0><#assign n1=n1+1>（${n1}）放心用流量，目前已用<#if fxyUsed gt 1024>${(fxyUsed/1024)?string('#.##')}GB<#else>${fxyUsed?string('#.##')}MB</#if>，使用达到${(fxyJs/1024)?string('#.##')}G会降速；\r\n</#if>
<#if gntyAll gt 0><#assign n1=n1+1>（${n1}）国内通用流量，本月共<#if gntyAll gt 1024>${(gntyAll/1024)?string('#.##')}GB<#else>${gntyAll?string('#.##')}MB</#if>，已用<#if gntyAll-gntyLeft gt 1024>${((gntyAll-gntyLeft)/1024)?string('#.##')}GB<#else>${(gntyAll-gntyLeft)?string('#.##')}MB</#if>，剩余<#if gntyLeft gt 1024>${(gntyLeft/1024)?string('#.##')}GB<#else>${gntyLeft?string('#.##')}MB</#if><#if gntyjzAll gt 0>，上月结转流量<#if gntyjzAll gt 1024>${(gntyjzAll/1024)?string('#.##')}GB<#else>${gntyjzAll?string('#.##')}MB</#if>，剩余<#if gntyjzLeft gt 1024>${(gntyjzLeft/1024)?string('#.##')}GB<#else>${gntyjzLeft?string('#.##')}MB</#if></#if>；\r\n</#if>
<#list cp as c>
<#if c.bizType!="不限流量" && c.bizType!="国内通用流量"><#assign n1=n1+1>（${n1}）${c.privSet}，本月共<#if c.sumNum?number gt 1024>${(c.sumNum?number/1024)?string('#.##')}GB<#else>${(c.sumNum?number)?string('#.##')}MB</#if>，已用<#if c.sumNum?number - c.leftNum?number gt 1024>${((c.sumNum?number - c.leftNum?number)/1024)?string('#.##')}GB<#else>${(c.sumNum?number - c.leftNum?number)?string('#.##')}MB</#if>，剩余<#if c.leftNum?number gt 1024>${(c.leftNum?number/1024)?string('#.##')}GB<#else>${(c.leftNum?number)?string('#.##')}MB</#if>；\r\n</#if>
</#list>
流量余量详情可点击安全链接：https://wx.online-cmcc.cn/website/personalHome/new/index 查看。 【中国移动】




【流量剩余信息】尊敬的客户，您好！截至*月*日*时***流量已用**，达到**GB后会降速，降速后可继续使用，不额外收费；**流量**，已用**，剩余**，**流量**MB，已用**MB，剩余**MB，……。
（1）**，目前已用**，使用达到**GB会降速；（若接口没变的情况下，将名称中的“不限量”修改为“放心用”）
（2）**，本月共**MB，已用**MB，剩余**MB，
上月结转流量**MB，剩余**MB；（结转流量有则体现，没有则忽略）
（3）**，本月共**MB，已用**MB，剩余**MB，
上月结转流量**MB，剩余**MB；（结转流量有则体现，没有则忽略）
（4）…………。
流量余量详情可点击安全链接：https://wx.online-cmcc.cn/website/personalHome/new/index 查看。 【中国移动】



sd152_tts01
模板：
经查询，您上个月话费剩余**元（如余额为负则播报：您上个月欠费**元，余额为0时播报：您上个月话费剩余0），这个月交了**元，另外给您返还了**元，这些费用加起来是**元，月初出账期扣了**元，现在余额是**元（如余额为负数时：现在欠费**元，余额为0时：现在余额是0），话费减少主要是月初扣费导致。

sd152_tts01
经查询，您上个月
<#if prevBalance lt 0>欠费<#else>话费剩余</#if>${(prevBalance/100)?string('#.##')}元，这个月交了${(chargeCur/100)?string('#.##')}元，
另外给您返还了${(returnUsed/100)?string('#.##')}元，这些费用加起来是${((prevBalance+chargeCur+returnUsed)/100)?string('#.##')}元，月初出账期扣了${(feeCur/100)?string('#.##')}元，现在
<#if curBalance lt 0>欠费<#else>余额</#if>是${(curBalance/100)?string('#.##')}元，话费减少主要是月初扣费导致。

模板：
sd152_tts02
经查询，您上个月未达到协议消费补收了${bsFee?number?string('#.##')}元，补收后话费
<#if prevBalance lt 0>欠费<#else>剩余</#if>${(prevBalance/100)?string('#.##')}元，这个月交了${(chargeCur/100)?string('#.##')}元，
另外给您返还了${(returnUsed/100)?string('#.##')}元，这些费用加起来是${((prevBalance+chargeCur+returnUsed)/100)?string('#.##')}元，月初出账期扣了${(feeCur/100)?string('#.##')}元，现在
<#if curBalance lt 0>欠费<#else>余额</#if>是${(curBalance/100)?string('#.##')}元，话费减少主要是月初扣费导致。







1、根据接口调取的时间数值下发，如某项无记录，则不下发，同时序号减少即可；
2、月份为用户来电月份-1；
sd152_sms01：
【账单信息】尊敬的客户，您好！以下是您的话费详情：\r\n
1、${lmonth}月末<#if prevBalance lt 0>欠费<#else>话费剩余</#if>${(prevBalance/100)?string('#.##')}元；\r\n
2、本月交费${(chargeCur/100)?string('#.##')}元；\r\n
3、返还话费${(returnUsed/100)?string('#.##')}元（包含减免预交，即协议款+减免预交）；\r\n
4、月初扣费${(feeCur/100)?string('#.##')}元；\r\n
即：${lmonth}月末<#if prevBalance lt 0>欠费<#else>话费剩余</#if>${(prevBalance/100)?string('#.##')}元+交费${(chargeCur/100)?string('#.##')}元+返还话费${(returnUsed/100)?string('#.##')}元-月初扣费${(feeCur/100)?string('#.##')}元=<#if curBalance lt 0>截至目前已欠费<#else>当前话费余额</#if>${(curBalance/100)?string('#.##')}元（如余额为负数则下发：截至目前已欠费**元），
话费减少主要是月初扣费导致，您也可关注“中国移动微信公众号”查询各项费用扣费明细。【中国移动】



sd152_sms02：
【账单信息】尊敬的客户，您好！以下是您的话费详情：\r\n
1、${lmonth}月未达到协议消费补收${bsFee?number?string('#.##')}元，补收后月末话费<#if prevBalance lt 0>欠费<#else>剩余</#if>${(prevBalance/100)?string('#.##')}元；\r\n
2、本月交费${(chargeCur/100)?string('#.##')}元；\r\n
3、返还话费${(returnUsed/100)?string('#.##')}元（包含减免预交，即协议款+减免预交）；\r\n
4、月初扣费${(feeCur/100)?string('#.##')}元；\r\n
即：补收后月末<#if prevBalance lt 0>欠费<#else>话费</#if>${(prevBalance/100)?string('#.##')}元+交费${(chargeCur/100)?string('#.##')}元+返还话费${(returnUsed/100)?string('#.##')}元-月初扣费${(feeCur/100)?string('#.##')}元=<#if curBalance lt 0>截至目前已欠费<#else>当前话费余额</#if>${(curBalance/100)?string('#.##')}元（如余额为负数则下发：截至目前已欠费**元），
话费减少主要是月初扣费和协议费用补收导致，您也可关注“中国移动微信公众号”查询各项费用扣费明细。【中国移动】




以下扣费根据客户实际账单信息进行播报，若账单细类合计费用为0则不播报。
当月1号账期1-7号来电播报：
sd05401_tts01_1
月初1到7号会扣除您的套餐费，现查询您账单扣费${crN.totalFee?replace('.00','')}元，其中
<#if crN.packageFee?? && crN.packageFee != '0.00'>套餐及固定费${crN.packageFee?replace('.00','')}元，</#if>
<#if crN.zzywFee?? && crN.zzywFee != '0.00'>增值业务费${crN.zzywFee?replace('.00','')}元，</#if>
<#if crN.bsFee?? && crN.bsFee != '0.00'>协议消费差额${crN.bsFee?replace('.00','')}元，</#if>
<#if crN.priviageFee?? && crN.priviageFee != '0.00'>优惠费${crN.priviageFee?replace('.00','')}元，</#if>
无其他额外扣费，请放心。

sd05401_tts01_2
现查询您${.now?string["YYYY年MM月"]}账期扣费${crN.totalFee?replace('.00','')}元，其中
<#if crN.packageFee?? && crN.packageFee != '0.00'>套餐及固定费${crN.packageFee?replace('.00','')}元，</#if>
<#if crN.zzywFee?? && crN.zzywFee != '0.00'>增值业务费${crN.zzywFee?replace('.00','')}元，</#if>
<#if crN.bsFee?? && crN.bsFee != '0.00'>协议消费差额${crN.bsFee?replace('.00','')}元，</#if>
<#if crN.priviageFee?? && crN.priviageFee != '0.00'>优惠费${crN.priviageFee?replace('.00','')}元，</#if>
无其他额外扣费，请放心。


以下扣费根据客户实际账单信息进行播报，若账单细类合计费用为0则不播报。
sd05401_tts02_1
当月1号账期1-7号来电播报：月初1到7号会一次性扣除您的套餐费，现查询您账单扣费${crN.totalFee?replace('.00','')}元，其中
<#if crN.packageFee?? && crN.packageFee != '0.00'>套餐及固定费${crN.packageFee?replace('.00','')}元，</#if>
<#if crN.tcwyyFee?? && crN.tcwyyFee != '0.00'>套餐外语音通信费${crN.tcwyyFee?replace('.00','')}元，</#if>
<#if crN.tcwswFee?? && crN.tcwswFee != '0.00'>套餐外上网费${crN.tcwswFee?replace('.00','')}元，</#if>
<#if crN.tcwdcxFee?? && crN.tcwdcxFee != '0.00'>套餐外短彩信费${crN.tcwdcxFee?replace('.00','')}元，</#if>
<#if crN.zzywFee?? && crN.zzywFee != '0.00'>增值业务费${crN.zzywFee?replace('.00','')}元，</#if>
<#if crN.dsFee?? && crN.dsFee != '0.00'>代收费${crN.dsFee?replace('.00','')}元，</#if>
<#if crN.bsFee?? && crN.bsFee != '0.00'>协议消费差额${crN.bsFee?replace('.00','')}元，</#if>
<#if crN.priviageFee?? && crN.priviageFee != '0.00'>优惠费${crN.priviageFee?replace('.00','')}元，</#if>


sd05401_tts02_2
现查询您${.now?string["YYYY年MM月"]}账期扣费${crN.totalFee?replace('.00','')}元，其中
<#if crN.packageFee?? && crN.packageFee != '0.00'>套餐及固定费${crN.packageFee?replace('.00','')}元，</#if>
<#if crN.tcwyyFee?? && crN.tcwyyFee != '0.00'>套餐外语音通信费${crN.tcwyyFee?replace('.00','')}元，</#if>
<#if crN.tcwswFee?? && crN.tcwswFee != '0.00'>套餐外上网费${crN.tcwswFee?replace('.00','')}元，</#if>
<#if crN.tcwdcxFee?? && crN.tcwdcxFee != '0.00'>套餐外短彩信费${crN.tcwdcxFee?replace('.00','')}元，</#if>
<#if crN.zzywFee?? && crN.zzywFee != '0.00'>增值业务费${crN.zzywFee?replace('.00','')}元，</#if>
<#if crN.dsFee?? && crN.dsFee != '0.00'>代收费${crN.dsFee?replace('.00','')}元，</#if>
<#if crN.bsFee?? && crN.bsFee != '0.00'>协议消费差额${crN.bsFee?replace('.00','')}元，</#if>
<#if crN.priviageFee?? && crN.priviageFee != '0.00'>优惠费${crN.priviageFee?replace('.00','')}元，</#if>



以下扣费根据客户实际账单信息进行下发，若账单细类合计费用为0则不下发。
有套餐外费用或代收费或协议消费差额短信模板：
sd05401_sms01
【账单信息】尊敬的客户，您好！您${.now?string["YYYY年MM月"]}账期
<#if crN.packageFee?? && crN.packageFee != '0.00'>套餐及固定费${crN.packageFee?replace('.00','')}元，</#if>
<#if crN.tcwyyFee?? && crN.tcwyyFee != '0.00'>套餐外语音通信费${crN.tcwyyFee?replace('.00','')}元，</#if>
<#if crN.tcwswFee?? && crN.tcwswFee != '0.00'>套餐外上网费${crN.tcwswFee?replace('.00','')}元，</#if>
<#if crN.tcwdcxFee?? && crN.tcwdcxFee != '0.00'>套餐外短彩信费${crN.tcwdcxFee?replace('.00','')}元，</#if>
<#if crN.zzywFee?? && crN.zzywFee != '0.00'>增值业务费${crN.zzywFee?replace('.00','')}元，</#if>
<#if crN.dsFee?? && crN.dsFee != '0.00'>代收费${crN.dsFee?replace('.00','')}元，</#if>
<#if crN.bsFee?? && crN.bsFee != '0.00'>协议消费差额${crN.bsFee?replace('.00','')}元，</#if>
<#if crN.priviageFee?? && crN.priviageFee != '0.00'>优惠费${crN.priviageFee?replace('.00','')}元，</#if>
账单合计扣费${crN.totalFee?replace('.00','')}元，当前<#if curBalance lt 0>欠费<#else>余额</#if>${(curBalance?abs/100)?string('#.##')}元。您可编辑短信25到10086查询各项费用扣费明细。【中国移动】



无套餐外费用或代收费模板：
sd05401_sms02
【账单信息】尊敬的客户，您好！您${.now?string["YYYY年MM月"]}账期
<#if crN.packageFee?? && crN.packageFee != '0.00'>套餐及固定费${crN.packageFee?replace('.00','')}元，</#if>
<#if crN.zzywFee?? && crN.zzywFee != '0.00'>增值业务费${crN.zzywFee?replace('.00','')}元，</#if>
<#if crN.bsFee?? && crN.bsFee != '0.00'>协议消费差额${crN.bsFee?replace('.00','')}元，</#if>
<#if crN.priviageFee?? && crN.priviageFee != '0.00'>优惠费${crN.priviageFee?replace('.00','')}元，</#if>
账单合计扣费${crN.totalFee?replace('.00','')}元，当前<#if curBalance lt 0>欠费<#else>余额</#if>${(curBalance?abs/100)?string('#.##')}元。您可编辑短信25到10086查询各项费用扣费明细。【中国移动】




sd029_tts03
套餐外上网费一般是超出流量或使用了不在套餐范围内的流量产生的费用，您${cr.cycleStart?substring(5,7)}月${cr.cycleStart?substring(8,10)}日至目前产生${cr.tcwswFee?replace('.00','')}元套餐外上网费，您本机每月${cr.cycleStart?substring(8,10)}号更新流量包月，如果手机看视频、下载软件或后台自动更新则流量使用较快，建议您关闭手机数据开关或者开通流量包月节省上网费用。


sd029_tts01
套餐外上网费一般是超出流量或使用了不在套餐范围内的流量产生的费用查询您${cr.cycleStart?substring(5,7)}月${cr.cycleStart?substring(8,10)}日至目前产生${cr.tcwswFee?replace('.00','')}元套餐外上网费，如果手机看视频、下载软件或后台自动更新则流量使用较快，建议您关闭手机数据开关或者开通流量包月节省上网费用。


sd029_tts02
<#assign fxyUsed=0>
<#assign fxyJs=0>
<#assign gntyAll=0>
<#assign gntyLeft=0>
<#assign qtAll=0>
<#assign qtLeft=0>
<#list cp as c>
<#if c.bizType=="不限流量"><#assign fxyJs=c.sumNum?number><#assign fxyUsed=c.sumNum?number-c.leftNum?number></#if>
<#if c.bizType=="国内通用流量"><#assign gntyAll+=c.sumNum?number><#assign gntyLeft+=c.leftNum?number></#if>
<#if c.bizType!="不限流量" && c.bizType!="国内通用流量"><#assign qtAll+=c.sumNum?number><#assign qtLeft+=c.leftNum?number></#if>
</#list>
经查询：您本机每月${cr.cycleStart?substring(8,10)}号更新流量包月，${cr.cycleStart?substring(5,7)}月${cr.cycleStart?substring(8,10)}日至目前
<#if fxyJs gt 0>放心用流量已用<#if fxyUsed gt 1024>${(fxyUsed/1024)?string('#.##')}G<#else>${fxyUsed?string('#.##')}M</#if>，达到${(fxyJs/1024)?string('#.##')}G会降速，降速后可继续使用，不额外收费；</#if>
<#if gntyAll gt 0>国内通用流量<#if gntyAll gt 1024>${(gntyAll/1024)?string('#.##')}G<#else>${gntyAll?string('#.##')}M</#if>，已用<#if gntyAll-gntyLeft gt 1024>${((gntyAll-gntyLeft)/1024)?string('#.##')}G<#else>${(gntyAll-gntyLeft)?string('#.##')}M</#if>，剩余<#if gntyLeft gt 1024>${(gntyLeft/1024)?string('#.##')}G<#else>${gntyLeft?string('#.##')}M</#if>；</#if>
<#if qtAll gt 0>其他流量<#if qtAll gt 1024>${(qtAll/1024)?string('#.##')}G<#else>${qtAll}M</#if>，已用<#if qtAll-qtLeft gt 1024>${(qtAll-qtLeft)/1024?string('#.##')}G<#else>${(qtAll-qtLeft)?string('#.##')}M</#if>，剩余<#if qtLeft gt 1024>${(qtLeft/1024)?string('#.##')}G<#else>${qtLeft?string('#.##')}M</#if>。</#if>



第一种情况：产生套餐外上网费
sd029_sms01
【套餐外上网费查询】尊敬的客户，您好！查询您本机截至${.now?string["MM月dd日HH时"]}，产生套餐外上网费${cr.tcwswFee?replace('.00','')}元，您可登陆山东移动网站查询上网详单。
温馨提示：建议您关闭手机数据开关或者开通流量包月节省上网费用，您可通过点击安全链接：http://dx.10086.cn/Tf2uMJ3 开通流量加油包。【中国移动】



第二种情况：未产生套餐外上网费（说明：模板中标红色字体若用户不是不限量则不下发，“不限量”修改为“放心用”。）
sd029_sms02
<#assign fxyUsed=0>
<#assign fxyJs=0>
<#assign gntyAll=0>
<#assign gntyLeft=0>
<#assign qtAll=0>
<#assign qtLeft=0>
<#list cp as c>
<#if c.bizType=="不限流量"><#assign fxyJs=c.sumNum?number><#assign fxyUsed=c.sumNum?number-c.leftNum?number></#if>
<#if c.bizType=="国内通用流量"><#assign gntyAll+=c.sumNum?number><#assign gntyLeft+=c.leftNum?number></#if>
<#if c.bizType!="不限流量" && c.bizType!="国内通用流量"><#assign qtAll+=c.sumNum?number><#assign qtLeft+=c.leftNum?number></#if>
</#list>
【流量剩余信息】尊敬的客户，您好！查询您本机截至${.now?string["MM月dd日HH时"]}，暂未产生套餐外上网费，流量剩余情况如下：
<#if fxyJs gt 0>放心用流量已用<#if fxyUsed gt 1024>${(fxyUsed/1024)?string('#.##')}G<#else>${fxyUsed?string('#.##')}M</#if>，达到${(fxyJs/1024)?string('#.##')}G会降速，降速后可继续使用，不额外收费；</#if>
<#if gntyAll gt 0>国内通用流量<#if gntyAll gt 1024>${(gntyAll/1024)?string('#.##')}G<#else>${gntyAll?string('#.##')}M</#if>，已用<#if gntyAll-gntyLeft gt 1024>${((gntyAll-gntyLeft)/1024)?string('#.##')}G<#else>${(gntyAll-gntyLeft)?string('#.##')}M</#if>，剩余<#if gntyLeft gt 1024>${(gntyLeft/1024)?string('#.##')}G<#else>${gntyLeft?string('#.##')}M</#if>；</#if>
<#if qtAll gt 0>其他流量<#if qtAll gt 1024>${(qtAll/1024)?string('#.##')}G<#else>${qtAll}M</#if>，已用<#if qtAll-qtLeft gt 1024>${(qtAll-qtLeft)/1024?string('#.##')}G<#else>${(qtAll-qtLeft)?string('#.##')}M</#if>，剩余<#if qtLeft gt 1024>${(qtLeft/1024)?string('#.##')}G<#else>${qtLeft?string('#.##')}M</#if>。</#if>
【中国移动】





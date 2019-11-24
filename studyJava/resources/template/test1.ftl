${.now?date}
${.now?time}
${.now}
${.now?string["MM月dd日HH时"]}
${.now?string["YYYY年MM月"]}
*******************************
${cycleStart?substring(5,7)}月${cycleStart?substring(8,10)}日
您放心用流量达到[n2]${total}G会降速，已用${(total?number - leftNum?number)?string('0.00')?replace('.00','')}G，系统已自动降速，网速下个账期自动恢复。
<#assign thscAll=0>
<#assign thscUsed=0>
<#assign thscLeft=0>
${thscAll}
${thscUsed}
${thscLeft}
********数字格式化测试****************
<#assign num=100000>
原样输出：${num?c}
'0.00'输出：${num?string('0.00')}
'#.##'输出：${num?string('#.##')}

*******************************************
sd152_tts01
经查询，您上个月
<#if prevBalance lt 0>欠费<#else>话费剩余</#if>${(prevBalance?abs/100)?string('#.##')}元，这个月交了${(chargeCur/100)?string('#.##')}元，
另外给您返还了${(returnUsed/100)?string('#.##')}元，这些费用加起来是${((prevBalance+chargeCur+returnUsed)/100)?string('#.##')}元，月初出账期扣了${(feeCur/100)?string('#.##')}元，现在
<#if curBalance lt 0>欠费<#else>余额</#if>是${(curBalance?abs/100)?string('#.##')}元，话费减少主要是月初扣费导致。

sd152_tts02
经查询，您上个月未达到协议消费补收了${bsFee?number?string('#.##')}元，补收后话费
<#if prevBalance lt 0>欠费<#else>剩余</#if>${(prevBalance?abs/100)?string('#.##')}元，这个月交了${(chargeCur/100)?string('#.##')}元，
另外给您返还了${(returnUsed/100)?string('#.##')}元，这些费用加起来是${((prevBalance+chargeCur+returnUsed)/100)?string('#.##')}元，月初出账期扣了${(feeCur/100)?string('#.##')}元，现在
<#if curBalance lt 0>欠费<#else>余额</#if>是${(curBalance?abs/100)?string('#.##')}元，话费减少主要是月初扣费导致。

sd152_sms01：
【账单信息】尊敬的客户，您好！以下是您的话费详情：\r\n
1、${lmonth}月末<#if prevBalance lt 0>欠费<#else>话费剩余</#if>${(prevBalance?abs/100)?string('#.##')}元；\r\n
2、本月交费${(chargeCur/100)?string('#.##')}元；\r\n
3、返还话费${(returnUsed/100)?string('#.##')}元（包含减免预交，即协议款+减免预交）；\r\n
4、月初扣费${(feeCur/100)?string('#.##')}元；\r\n
即：${lmonth}月末<#if prevBalance lt 0>欠费<#else>话费剩余</#if>${(prevBalance?abs/100)?string('#.##')}元+交费${(chargeCur/100)?string('#.##')}元+返还话费${(returnUsed/100)?string('#.##')}元-月初扣费${(feeCur/100)?string('#.##')}元=<#if curBalance lt 0>截至目前已欠费<#else>当前话费余额</#if>${(curBalance?abs/100)?string('#.##')}元；\r\n
话费减少主要是月初扣费导致，您也可关注“中国移动微信公众号”查询各项费用扣费明细。【中国移动】

sd152_sms02：
【账单信息】尊敬的客户，您好！以下是您的话费详情：\r\n
1、${lmonth}月未达到协议消费补收${bsFee?number?string('#.##')}元，补收后月末话费<#if prevBalance lt 0>欠费<#else>剩余</#if>${(prevBalance?abs/100)?string('#.##')}元；\r\n
2、本月交费${(chargeCur/100)?string('#.##')}元；\r\n
3、返还话费${(returnUsed/100)?string('#.##')}元（包含减免预交，即协议款+减免预交）；\r\n
4、月初扣费${(feeCur/100)?string('#.##')}元；\r\n
即：补收后月末<#if prevBalance lt 0>欠费<#else>话费</#if>${(prevBalance?abs/100)?string('#.##')}元+交费${(chargeCur/100)?string('#.##')}元+返还话费${(returnUsed/100)?string('#.##')}元-月初扣费${(feeCur/100)?string('#.##')}元=<#if curBalance lt 0>截至目前已欠费<#else>当前话费余额</#if>${(curBalance?abs/100)?string('#.##')}元；\r\n
话费减少主要是月初扣费和协议费用补收导致，您也可关注“中国移动微信公众号”查询各项费用扣费明细。【中国移动】


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
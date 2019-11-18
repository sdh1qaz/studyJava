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
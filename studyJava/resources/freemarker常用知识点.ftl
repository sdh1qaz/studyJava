1.获取当前日期时间
${.now?string["MM月dd日HH时"]}

2.判断数字大于0
<#if thscAll gt 0></#if>

3.判断数字小于0
<#if thscAll lt 0></#if>

4.判断list是否有下一个
<#list myList as m>
<#if m_has_next> <#else> </#if>
</#list>

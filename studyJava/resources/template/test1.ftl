${.now?date}
${.now?time}
${.now}
${.now?string["MM月dd日HH时"]}
${cr?number?abs}
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
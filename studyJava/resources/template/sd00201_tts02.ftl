您${cr.cycleStart?substring(0,4)}年[n2]${cr.cycleStart?substring(5,7)}月${cr.cycleStart?substring(8,10)}日至[n1]${cr.cycleStart?substring(0,4)}年[n2]${cr.cycleEnd?substring(5,7)}月${cr.cycleEnd?substring(8,10)}日共消费${cr.totalFee}元，其中
<#if cr.packageFee?? && cr.packageFee != "0.00">套餐及固定费${cr.packageFee}元，</#if>
<#if cr.tcwyyFee?? && cr.tcwyyFee != "0.00">套餐外语音通信费${cr.tcwyyFee}元，</#if>
<#if cr.tcwswFee?? && cr.tcwswFee != "0.00">套餐外上网费${cr.tcwswFee}元，</#if>
<#if cr.tcwdcxFee?? && cr.tcwdcxFee != "0.00">套餐外短彩信费${cr.tcwdcxFee}元，</#if>
<#if cr.zzywFee?? && cr.zzywFee != "0.00">增值业务费${cr.zzywFee}元，</#if>
<#if cr.dsFee?? && cr.dsFee != "0.00">代收费${cr.dsFee}元，</#if>
<#if cr.otherPay?? && cr.otherPay != "0.00">他人代付费${cr.otherPay}元，</#if>
<#if cr.bsFee?? && cr.bsFee != "0.00">协议消费差额${cr.bsFee}元，</#if>
<#if cr.priviageFee?? && cr.priviageFee != "0.00">优惠费${cr.priviageFee}元，</#if>
<#if cr.present?? && cr.present != "0.00">赠送费${cr.present}元，</#if>
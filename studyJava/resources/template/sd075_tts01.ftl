经查询，您<#list payRecRsp as p>${p.payDate?substring(0,4)}年[n2]${p.payDate?substring(4,6)}月${p.payDate?substring(6,8)}日${p.payDate?substring(8,10)}时${p.payDate?substring(10,12)}分充值${p.amount}元，</#list>当前余额${balance}元。如果您通过微信或支付宝等方式充值，可能存在到账延迟的情况，建议您关注第三方充值进度并耐心等待。
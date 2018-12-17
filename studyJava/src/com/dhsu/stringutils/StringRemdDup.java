package com.dhsu.stringutils;

import java.util.ArrayList;
import java.util.List;




/**
 * @ClassName:StringRemdDup
 * @Author: sudenghui
 * @Description:字符串数组去重
 * @Date:Created in 2018/01/30
 */
public class StringRemdDup {
   //����1
   public static List<String> removeDup(String[] str){
	   List<String> list = new ArrayList<String>(); 
       for(int i=0;i<str.length;i++){   
           if(!list.contains(str[i]))   
              list.add(str[i]);         
       }   
	   return list;
   }

   public static void main(String[] args) {
	   String[] bbbb ={"NGCRMPFGX_CGXHCCHECKCURRENTMONFLOWMEAL_POST",
			   "NGCRMPFGX_CGXHCGETNEXTMONFLOWMEAL_POST",
			   "NGCRMPFGX_CGXHCISMONTHPAYUSER_POST",
			   "NGCRMPFGX_CGXHCISOPEN139EMAIL_POST",
			   "NGCRMPFGX_CGXHCISOPENGPRS_POST",
			   "NGCRMPFGX_CGXHCISSMARTPHONE_POST",
			   "NGCRMPFGX_CGXHQGETACCOUNTUSERINFOLIST_POST",
			   "NGCRMPFGX_CGXHQGETENJOYMEAL_POST",
			   "NGCRMPFGX_CGXHQGETFEEINFO_POST",
			   "NGCRMPFGX_CGXHQGETFLOWASSMEAL_POST",
			   "NGCRMPFGX_CGXHQGETFLOWMEAL_POST",
			   "NGCRMPFGX_CGXHQGETFLOWPGMEAL_POST",
			   "NGCRMPFGX_CGXHQGETNEXTMNENJOYMEAL_POST",
			   "NGCRMPFGX_CGXHQGETNOWENJOYMEAL_POST",
			   "NGCRMPFGX_CGXHQGETPAYMENTRECORD_POST",
			   "NGCRMPFGX_CGXHQGETUSERLEVEL_POST",
			   "NGCRMPFGX_CGXHQQRYCURRENTMONFLOWMEAL_POST",
			   "NGCRMPFGX_CGXHQQRYHISFEEDETAIL_POST",
			   "NGCRMPFGX_CGXHQQRYHISMONTHINFO_POST",
			   "NGCRMPFGX_CGXHQQRYISACCEPTACTIVITY_POST",
			   "NGCRMPFGX_CGXHQQRYSTOPORSTARTSTATUS_POST",
			   "NGCRMPFGX_CGXHQQRYUSERINFOFORCALLLOG_POST",
			   "NGCRMPFGX_CGXHQQUERYBUSIREC_POST",
			   "NGCRMPFGX_CGXHQQUERYCOINRANGE_POST",
			   "NGCRMPFGX_CGXHQQUERYFEERESOURCE_POST",
			   "NGCRMPFGX_CGXHQQUERYPROMOFEETRANSFER_POST",
			   "NGCRMPFGX_CGXHQQUERYRANGE_POST",
			   "NGCRMPFGX_CGXHQQUERYREALTIMEFLOW_POST",
			   "NGCRMPFGX_CGXHQQUERYTRANSTOFLOW_POST",
			   "NGCRMPFGX_CGXHQQUERYUSERCOINEX_POST",
			   "NGCRMPFGX_CGXHQREALTIMEFEE_POST",
			   "NGCRMPFGX_CGXHTDOSTOPOPEN_POST",
			   "NGCRMPFGX_CGXHTDOTRANCOINTOFLOW_POST",
			   "NGCRMPFGX_CGXHTSAVESMSRECVCRM_POST",
			   "NGCRMPFGX_CGXHTSENDEMAILREQUEST_POST",
			   "NGCRMPFGX_CGXHTSMSDISPOSEKTLLDJ_POST",
			   "NGCRMPFGX_CGXHTSMSDISPOSEORDERVASOFFER_POST",
			   "NGCRMPFGX_CGXHTSMSDISPOSEZHTCSL_POST",
			   "NGCRMPFGX_CGXHTTRANCOINTOPREPAY_POST"}; 
	   
	   String[] aaaa = {"NGCRMPFGX_CGXHCCHECKBROADBANDPASSWORD_POST",
			   "NGCRMPFGX_CGXHCCHECKBROADPWDSTATUS_POST",
			   "NGCRMPFGX_CGXHCCHECKIDCARD_POST",
			   "NGCRMPFGX_CGXHCCHECKPWDLOCK_POST",
			   "NGCRMPFGX_CGXHCCHECKUSERPWD_POST",
			   "NGCRMPFGX_CGXHCDOCHECKPASS_POST",
			   "NGCRMPFGX_CGXHCGETNEXTMONFLOWMEAL_POST",
			   "NGCRMPFGX_CGXHQGETBROADBANDUSERINFO_POST",
			   "NGCRMPFGX_CGXHQGETFLOWMEAL_POST",
			   "NGCRMPFGX_CGXHQQRYCURRENTMONFLOWMEAL_POST",
			   "NGCRMPFGX_CGXHQQRYNEXTMONFLOWMEALBYGROUPOFFERID_POST",
			   "NGCRMPFGX_CGXHQQRYSPECIALPHONE_POST",
			   "NGCRMPFGX_CGXHQQRYSTOPORSTARTSTATUS_POST",
			   "NGCRMPFGX_CGXHQQRYSUSPICIONINFO_POST",
			   "NGCRMPFGX_CGXHTCHANGEBROADBANDPASSWORD_POST",
			   "NGCRMPFGX_CGXHTMODIFYUSERPASSWORD_POST",
			   "NGCRMPFGX_CGXHTSMSDISPOSEORDERVASOFFER_POST",
			   "NGCRMPFGX_CGXHTSTOPORSTARTUSER_POST"};
	   StringComomnUtil.getStrA(aaaa,bbbb);//aaaa有的bbbb没有
	   //StringComomnUtil.getStrA(my11,laiyi12);
   }
}
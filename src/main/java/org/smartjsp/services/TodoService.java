package org.smartjsp.services;

import java.util.Properties;

import org.compiere.model.MBPGroup;
import org.compiere.model.MBPartner;
import org.compiere.model.PO;
import org.compiere.util.Env;
import org.compiere.util.Trx;
import org.smartjsp.services.tools.Response;
import org.springframework.stereotype.Service;

//@Service
public class TodoService {

	public Response saludar() {
		return new Response("SmartJSP, idempiere web-services");
	}
	
	public static Response saludars() {
		return new Response("SmartJSP, idempiere web-services");
	}
	
	public Response createBpartner(String name, String taxid) {
		Properties ctx = new Properties();
		ctx.put("#AD_Language","en_US");
		ctx.put("#AD_Client_ID",1000024);
		ctx.put("#C_BP_Group_ID",1000017);
		
		MBPartner bp= new MBPartner(ctx,0,null);
		bp.setName(name);
		bp.setTaxID(taxid);
		bp.setBPGroup(new MBPGroup(ctx, 1000017, null));
		
		String saveResult = savePO(bp);
		if(saveResult.equals("@Ok@")) {
			return new Response("Done, "+ name + " was inserted!");
		}else
			return new Response("fail, "+saveResult);
		//return new Response("fail");
	}
	
	public String savePO( PO po) {
		String trxName = Trx.createTrxName();
		Trx trx = Trx.get(trxName, true);
		try {
			po.saveEx(trxName);
			trx.commit(true);
			
		} catch (Exception ex) {
			trx.rollback();
			return ex.getMessage();
		} finally {
			trx.close();
		}
		return "@Ok@";
	}

}

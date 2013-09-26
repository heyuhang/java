package com.hyh.factory;

import com.hyh.proxy.ChecksDaoProxy;
import com.hyh.proxy.ClientDaoProxy;
import com.hyh.proxy.DeliverDaoProxy;
import com.hyh.proxy.GoodsBrandProxy;
import com.hyh.proxy.GoodsDaoProxy;
import com.hyh.proxy.GoodsSortDaoProxy;
import com.hyh.proxy.ResourceDaoProxy;
import com.hyh.proxy.SectionDaoProxy;
import com.hyh.proxy.ShelfDaoProxy;
import com.hyh.proxy.StockInDaoProxy;
import com.hyh.proxy.StockOutDaoProxy;
import com.hyh.proxy.SupplierDaoProxy;
import com.hyh.proxy.UserDaoProxy;
/*
 * 服务  工厂
 */
public class ServiceFactory {
	
	public static ClientDaoProxy getClientService(){
		return new ClientDaoProxy();
	}
	
	public static GoodsBrandProxy getGoodsBrandService(){
		return new GoodsBrandProxy();
	}
	
	public static GoodsDaoProxy getGoodsService(){
		return new GoodsDaoProxy();
	}
	
	public static GoodsSortDaoProxy getGoodsSortService(){
		return new GoodsSortDaoProxy();
	}
	
	public static ResourceDaoProxy getResourceService(){
		return new ResourceDaoProxy();
	}
	
	public static SectionDaoProxy getSectionService(){
		return new SectionDaoProxy();
	}
	
	public static ShelfDaoProxy getShelfService(){
		return new ShelfDaoProxy();
	}
	
	public static SupplierDaoProxy getSupplierService(){
		return new SupplierDaoProxy();
	}
	
	public static UserDaoProxy getUserService(){
		return new UserDaoProxy();
	}
	
	public static StockInDaoProxy getStockInService(){
		return new StockInDaoProxy();
	}
	
	public static StockOutDaoProxy getStockOutService(){
		return new StockOutDaoProxy();
	}
	
	public static DeliverDaoProxy getDeliverService(){
		return new DeliverDaoProxy();
	}
	
	public static ChecksDaoProxy getChecksService(){
		return new ChecksDaoProxy();
	}
}

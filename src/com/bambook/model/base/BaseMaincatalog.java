package com.bambook.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings({"serial", "unchecked"})
public abstract class BaseMaincatalog<M extends BaseMaincatalog<M>> extends Model<M> implements IBean {

	public M setMCatalogID(java.lang.Integer mCatalogID) {
		set("mCatalogID", mCatalogID);
		return (M)this;
	}

	public java.lang.Integer getMCatalogID() {
		return get("mCatalogID");
	}

	public M setMCatalogName(java.lang.String mCatalogName) {
		set("mCatalogName", mCatalogName);
		return (M)this;
	}

	public java.lang.String getMCatalogName() {
		return get("mCatalogName");
	}

}

package com.pt.ssm.po;

import java.io.Serializable;
import java.util.Date;

import org.apache.ibatis.type.Alias;

@Alias("Property")
public class Property implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String applyname;  //申请人姓名
	private String applyphone;  //申请人电话
	private String applydate;  //申请时间
	private String applycontent;  //申请内容
	private String applyaddress;  //申请地址
	private String submitapplydate;  //提交申请时间
	private String distributeapplydate;  //派发时间
	private String scrapapplydate;  //报废时间
	private Integer materialmoney;  //材料费用
	private Integer repairmoney;  //维修费用
	private String  completecontent;  //完成情况
	private String  completedate;  //完成时间
	private Integer  statues;  //申请状态，0-物业报修列表，1-物业报修派发列表，3-待维修列表，4-存档，5-报废
	private Integer  applysource;  //申请来源，0填报申请,1在线申请
	private String repairsname;  //报修人姓名
	private String repairsphone;  //报修人电话
	private String repairsdate;  //报修时间
	private String assignname;  //派发人姓名
	private Integer assignphone;  //派发人电话
	private String assigndate;  //派发时间
	private String archivename;  //存档人姓名
	private Integer archivephone;  //存档人电话
	private String archivedate;//存档时间
	private String scrapname;//报废人
	private String scrapphone;//号码
	private String scrapdate;//时间
	private String maintainname;//维修人
	private String maintainphone;//号码
	private String maintaindate;//时间
	private String scrapwhy;//报废原因
	private String htstatues;//回退状态
	private String htreason;//回退原因
	
	private String departName;
	
	private Integer departId;
	private Integer userId;
	private String fj;
	
	private String name;
	
	
	
	private Integer total;
	
	
	
	
	public String getDepartName() {
		return departName;
	}
	public void setDepartName(String departName) {
		this.departName = departName;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public Integer getDepartId() {
		return departId;
	}
	public void setDepartId(Integer departId) {
		this.departId = departId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getScrapname() {
		return scrapname;
	}
	public void setScrapname(String scrapname) {
		this.scrapname = scrapname;
	}
	public String getScrapphone() {
		return scrapphone;
	}
	public void setScrapphone(String scrapphone) {
		this.scrapphone = scrapphone;
	}
	public String getScrapdate() {
		return scrapdate;
	}
	public void setScrapdate(String scrapdate) {
		this.scrapdate = scrapdate;
	}
	public String getMaintainname() {
		return maintainname;
	}
	public void setMaintainname(String maintainname) {
		this.maintainname = maintainname;
	}
	public String getMaintainphone() {
		return maintainphone;
	}
	public void setMaintainphone(String maintainphone) {
		this.maintainphone = maintainphone;
	}
	public String getMaintaindate() {
		return maintaindate;
	}
	public void setMaintaindate(String maintaindate) {
		this.maintaindate = maintaindate;
	}
	public String getScrapwhy() {
		return scrapwhy;
	}
	public void setScrapwhy(String scrapwhy) {
		this.scrapwhy = scrapwhy;
	}
	public String getHtstatues() {
		return htstatues;
	}
	public void setHtstatues(String htstatues) {
		this.htstatues = htstatues;
	}
	public String getHtreason() {
		return htreason;
	}
	public void setHtreason(String htreason) {
		this.htreason = htreason;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getApplyname() {
		return applyname;
	}
	public void setApplyname(String applyname) {
		this.applyname = applyname;
	}
	
	public String getApplyphone() {
		return applyphone;
	}
	public void setApplyphone(String applyphone) {
		this.applyphone = applyphone;
	}
	public String getApplydate() {
		return applydate;
	}
	public void setApplydate(String applydate) {
		this.applydate = applydate;
	}
	public String getApplycontent() {
		return applycontent;
	}
	public void setApplycontent(String applycontent) {
		this.applycontent = applycontent;
	}
	public String getApplyaddress() {
		return applyaddress;
	}
	public void setApplyaddress(String applyaddress) {
		this.applyaddress = applyaddress;
	}
	public String getSubmitapplydate() {
		return submitapplydate;
	}
	public void setSubmitapplydate(String submitapplydate) {
		this.submitapplydate = submitapplydate;
	}
	public String getDistributeapplydate() {
		return distributeapplydate;
	}
	public void setDistributeapplydate(String distributeapplydate) {
		this.distributeapplydate = distributeapplydate;
	}
	public String getScrapapplydate() {
		return scrapapplydate;
	}
	public void setScrapapplydate(String scrapapplydate) {
		this.scrapapplydate = scrapapplydate;
	}
	public Integer getMaterialmoney() {
		return materialmoney;
	}
	public void setMaterialmoney(Integer materialmoney) {
		this.materialmoney = materialmoney;
	}
	public Integer getRepairmoney() {
		return repairmoney;
	}
	public void setRepairmoney(Integer repairmoney) {
		this.repairmoney = repairmoney;
	}
	public String getCompletecontent() {
		return completecontent;
	}
	public void setCompletecontent(String completecontent) {
		this.completecontent = completecontent;
	}
	public String getCompletedate() {
		return completedate;
	}
	public void setCompletedate(String completedate) {
		this.completedate = completedate;
	}
	public Integer getStatues() {
		return statues;
	}
	public void setStatues(Integer statues) {
		this.statues = statues;
	}
	public Integer getApplysource() {
		return applysource;
	}
	public void setApplysource(Integer applysource) {
		this.applysource = applysource;
	}
	public String getRepairsname() {
		return repairsname;
	}
	public void setRepairsname(String repairsname) {
		this.repairsname = repairsname;
	}
	public String getRepairsphone() {
		return repairsphone;
	}
	public void setRepairsphone(String repairsphone) {
		this.repairsphone = repairsphone;
	}
	public String getRepairsdate() {
		return repairsdate;
	}
	public void setRepairsdate(String repairsdate) {
		this.repairsdate = repairsdate;
	}
	public String getAssignname() {
		return assignname;
	}
	public void setAssignname(String assignname) {
		this.assignname = assignname;
	}
	public Integer getAssignphone() {
		return assignphone;
	}
	public void setAssignphone(Integer assignphone) {
		this.assignphone = assignphone;
	}
	public String getAssigndate() {
		return assigndate;
	}
	public void setAssigndate(String assigndate) {
		this.assigndate = assigndate;
	}
	public String getArchivename() {
		return archivename;
	}
	public void setArchivename(String archivename) {
		this.archivename = archivename;
	}
	public Integer getArchivephone() {
		return archivephone;
	}
	public void setArchivephone(Integer archivephone) {
		this.archivephone = archivephone;
	}
	public String getArchivedate() {
		return archivedate;
	}
	public void setArchivedate(String archivedate) {
		this.archivedate = archivedate;
	}
	public String getFj() {
		return fj;
	}
	public void setFj(String fj) {
		this.fj = fj;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}

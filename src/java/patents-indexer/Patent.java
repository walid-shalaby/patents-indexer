import java.util.ArrayList;
import java.util.List;

//import org.apache.solr.common.SolrInputDocument;

enum ENUM_TYPE {
	e_UNKNOWN, 
	e_GRANT, 
	e_APPLICATION
}
public class Patent {

	ENUM_TYPE e_type;
	
	protected String appKind = "";
	protected String appDocNumber = "";
	protected String appCountry = "";
	protected String appDate = "";
	
	protected String pubCountry = "";
	protected String pubKind = "";
	protected String pubDate = "";
	protected String pubDocNumber = "";
	
	protected String title = "";
	
	protected String claimStmt = "";
	
	protected ArrayList<String> abstractParagraphs;	
	protected ArrayList<String> descParagraphs;
	protected ArrayList<String> claims;
	
	/**
	 * @return the e_type
	 */
	public ENUM_TYPE getType() {
		return e_type;
	}

	/**
	 * @return the e_type string
	 */
	public String getTypeString() {
		return "";
	}
	
	/**
	 * @return the id
	 */
	public String getId() {
		return getPubCountry() + getPubDocNumber() + getPubKind();
	}
	
	/**
	 * @return the pubCountry
	 */
	public String getPubCountry() {
		return pubCountry;
	}
	/**
	 * @param pubCountry the pubCountry to set
	 */
	public void setPubCountry(String pubCountry) {
		this.pubCountry = pubCountry;
	}
	/**
	 * @return the pubKind
	 */
	public String getPubKind() {
		return pubKind;
	}
	/**
	 * @param pubKind the pubKind to set
	 */
	public void setPubKind(String pubKind) {
		this.pubKind = pubKind;
	}
	/**
	 * @return the pubDate
	 */
	public String getPubDate(boolean solr_format) {
		if(solr_format==true)
			return String.format("%s-%s-%sT00:00:00Z", pubDate.substring(0,4), pubDate.substring(4,6), pubDate.substring(6,8));
		else
			return pubDate;
	}
	/**
	 * @return the pub year
	 */
	public String getPubYear() {
			return String.format("%s", pubDate.substring(0,4));
	}
	/**
	 * @return the app year
	 */
	public String getAppYear() {
			return String.format("%s", appDate.substring(0,4));
	}
	/**
	 * @param pubDate the pubDate to set
	 */
	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}
	/**
	 * @return the pubDocNumber
	 */
	public String getPubDocNumber() {
		return removeLeadingZeros(pubDocNumber);
	}
	/**
	 * @param pubDocNumber the pubDocNumber to set
	 */
	public void setPubDocNumber(String pubDocNumber) {
		this.pubDocNumber = pubDocNumber;
	}
	
	protected String mainClassification = "";
	/**
	 * @return the mainClassification
	 */
	public String getMainClassification() {
		return mainClassification;
	}
	/**
	 * @param mainClassification the mainClassification to set
	 */
	public void setMainClassification(String mainClassification) {
		this.mainClassification = mainClassification;
	}
	
	protected ArrayList<String> furtherClassification;
	/**
	 * @return the furtherClassification
	 */
	protected String getFurtherClassifications(String prefix, String suffix) {
		// TODO Auto-generated method stub
		String furtherClassifications = "";
		for(String s : this.furtherClassification) {
			furtherClassifications += prefix + s + suffix;
		}
		return furtherClassifications;
	}
	/**
	 * @param furtherClassification the furtherClassification to set
	 */
	public void addfurtherClassification(String furtherClassification) {
		this.furtherClassification.add(furtherClassification);
	}
	
	Patent() {
		e_type = ENUM_TYPE.e_UNKNOWN;
		
		abstractParagraphs = new ArrayList<String>();		
		descParagraphs = new ArrayList<String>();
		claims = new ArrayList<String>();
		furtherClassification = new ArrayList<String>();
		
		ipcClass = new ArrayList<String>();
		ipcClassification = new ArrayList<String>();
		ipcClassificationLevel = new ArrayList<String>();
		ipcClassificationValue = new ArrayList<String>();
		ipcMainGroup = new ArrayList<String>();
		ipcSection = new ArrayList<String>();
		ipcSubclass = new ArrayList<String>();
		ipcSubgroup = new ArrayList<String>();
		ipcSymbolLevel = new ArrayList<String>();
		ipcVersionDate = new ArrayList<String>();
		
		
		cpcFurtherClass = new ArrayList<String>();
		cpcFurtherClassification = new ArrayList<String>();
		cpcFurtherClassificationLevel = new ArrayList<String>();
		cpcFurtherClassificationValue = new ArrayList<String>();
		cpcFurtherGroup = new ArrayList<String>();
		cpcFurtherSection = new ArrayList<String>();
		cpcFurtherSubclass = new ArrayList<String>();
		cpcFurtherSubgroup = new ArrayList<String>();
		cpcFurtherSymbolLevel = new ArrayList<String>();
		cpcFurtherVersionDate = new ArrayList<String>();
		
		assignees = new ArrayList<AddrezzBook>();
		
		inventors = new ArrayList<AddrezzBook>();
	}
	
	/**
	 * @return the appKind
	 */
	public String getAppKind() {
		return appKind;
	}
	/**
	 * @param appType the appKind to set
	 */
	public void setAppKind(String appKind) {
		this.appKind = appKind;
	}
	/**
	 * @return the appNumber
	 */
	public String getAppNumber() {
		return getAppCountry()+getAppDocNumber();
	}
	/**
	 * @return the appDocNumber
	 */
	public String getAppDocNumber() {
		return removeLeadingZeros(appDocNumber);
	}
	/**
	 * @param appDocNumber the appDocNumber to set
	 */
	public void setAppDocNumber(String appDocNumber) {
		this.appDocNumber = appDocNumber;
	}
	/**
	 * @return the appCountry
	 */
	public String getAppCountry() {
		return appCountry;
	}
	/**
	 * @param appCountry the appCountry to set
	 */
	public void setAppCountry(String appCountry) {
		this.appCountry = appCountry;
	}
	/**
	 * @return the appDate
	 */
	public String getAppDate(boolean solr_format) {
		if(solr_format==true)
			return String.format("%s-%s-%sT00:00:00Z", appDate.substring(0,4), appDate.substring(4,6), appDate.substring(6,8));
		else
			return appDate;
	}
	
	/**
	 * @param appDate the appDate to set
	 */
	public void setAppDate(String appDate) {
		this.appDate = appDate;
	}
	
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the claimStmt
	 */
	public String getClaimStmt() {
		return claimStmt;
	}
	/**
	 * @param claimStmt the claimStmt to set
	 */
	public void setClaimStmt(String claimStmt) {
		this.claimStmt = claimStmt;
	}
	/**
	 * @return the abstractParagraphs
	 */
	public ArrayList<String> getAbstractParagraphs() {
		return abstractParagraphs;
	}
	/**
	 * @param abstractParagraph the abstractParagraph to add
	 */
	public void addAbstractParagraph(String abstractParagraph) {
		this.abstractParagraphs.add(abstractParagraph);
	}
	
	/**
	 * @param descParagraph the descParagraph to add
	 */
	public void addDescParagraph(String descParagraph) {
		this.descParagraphs.add(descParagraph);
	}
	/**
	 * @param claims the claims to set
	 */
	public void addClaim(String claim) {
		this.claims.add(claim);
	}
	
	public String toXML(boolean solr_format) {
		String xml = "<add><doc>";
		if(solr_format==true) {
			xml += "<field name=\"id\"><![CDATA["+getId()+"]]></field>"
				 + "<field name=\"type\"><![CDATA["+getTypeString()+"]]></field>"
				 + "<field name=\"title\"><![CDATA["+getTitle()+"]]></field>"
				 
				 + getAssignees(solr_format)
				 
				 + getInventors(solr_format)
				 
				 + "<field name=\"main_classification\"><![CDATA["+getMainClassification()+"]]></field>"
				 + getFurtherClassifications("<field name=\"further_classification\"><![CDATA[","]]></field>")
				 
				 + getIpcClassifications("<field name=\"ipc_classification\"><![CDATA[","]]></field>")
				 + getIpcVersionDate("<field name=\"ipc_version_date\"><![CDATA[","]]></field>", solr_format)
				 + getIpcClassificationLevel("<field name=\"ipc_classification_level\"><![CDATA[","]]></field>")
				 + getIpcSection("<field name=\"ipc_section\"><![CDATA[","]]></field>")
				 + getIpcClass("<field name=\"ipc_class\"><![CDATA[","]]></field>")
				 + getIpcSubclass("<field name=\"ipc_subclass\"><![CDATA[","]]></field>")
				 + getIpcMainGroup("<field name=\"ipc_main_group\"><![CDATA[","]]></field>")
				 + getIpcSubgroup("<field name=\"ipc_subgroup\"><![CDATA[","]]></field>")
				 + getIpcSymbolLevel("<field name=\"ipc_symbol_level\"><![CDATA[","]]></field>")
				 + getIpcClassificationValue("<field name=\"ipc_classification_value\"><![CDATA[","]]></field>")
				 
				 + "<field name=\"cpc_main_classification\"><![CDATA["+getCpcMainClassification("","")+"]]></field>"
				 + getCpcFurtherClassifications("<field name=\"cpc_further_classification\"><![CDATA[","]]></field>")
				 
				 + "<field name=\"abstract\"><![CDATA["+getAbstract("","\n\n")+"]]></field>"
				 + "<field name=\"description\"><![CDATA["+getDesc("","\n\n")+"]]></field>"
				 + "<field name=\"claims\"><![CDATA["+getClaims("","\n\n")+"]]></field>"
				 
				 + "<field name=\"publication_country\"><![CDATA["+getPubCountry()+"]]></field>"
				 + "<field name=\"publication_doc_number\"><![CDATA["+getPubDocNumber()+"]]></field>"
				 + "<field name=\"publication_kind\"><![CDATA["+getPubKind()+"]]></field>"
				 + "<field name=\"publication_date\"><![CDATA["+getPubDate(solr_format)+"]]></field>"
				 + "<field name=\"publication_year\"><![CDATA["+getPubYear()+"]]></field>"
			
				 + "<field name=\"application_country\"><![CDATA["+getAppCountry()+"]]></field>"
				 + "<field name=\"application_doc_mumber\"><![CDATA["+getAppDocNumber()+"]]></field>"
				 + "<field name=\"application_number\"><![CDATA["+getAppNumber()+"]]></field>"
				 + "<field name=\"application_kind\"><![CDATA["+getAppKind()+"]]></field>"
				 + "<field name=\"application_date\"><![CDATA["+getAppDate(solr_format)+"]]></field>"
				 + "<field name=\"application_year\"><![CDATA["+getAppYear()+"]]></field>";
			
		}
		else  {
			xml += "<id><![CDATA["+getId()+"]]></id>"
				 + "<type><![CDATA["+getTypeString()+"]]></type>"
				 + "<title><![CDATA["+getTitle()+"]]></title>"
				 
				 + getAssignees(solr_format)
				 
				 + "<main_classification><![CDATA["+getMainClassification()+"]]></main_classification>"
				 + getFurtherClassifications("<further_classification><![CDATA[","]]></further_classification>")
				 
				 + getIpcClassifications("<ipc_classification><![CDATA[","]]></ipc_classification>")
				 + getIpcVersionDate("<ipc_version_date><![CDATA[","]]></ipc_version_date>", solr_format)
				 + getIpcClassificationLevel("<ipc_classification_level><![CDATA[","]]></ipc_classification_level>")
				 + getIpcSection("<ipc_section><![CDATA[","]]></ipc_section>")
				 + getIpcClass("<ipc_class><![CDATA[","]]></ipc_class>")
				 + getIpcSubclass("<ipc_subclass><![CDATA[","]]></ipc_subclass>")
				 + getIpcMainGroup("<ipc_main_group><![CDATA[","]]></ipc_main_group>")
				 + getIpcSubgroup("<ipc_subgroup><![CDATA[","]]></ipc_subgroup>")
				 + getIpcSymbolLevel("<ipc_symbol_level><![CDATA[","]]></ipc_symbol_level>")
				 + getIpcClassificationValue("<ipc_classification_value><![CDATA[","]]></ipc_classification_value>")
				 
				 + "<cpc_main_classification><![CDATA["+getCpcMainClassification("","")+"]]></main_classification>"
				 + getCpcFurtherClassifications("<further_classification><![CDATA[","]]></further_classification>")
				 
				 + "<abstract><![CDATA["+getAbstract("","\n\n")+"]]></abstract>"
				 + "<description><![CDATA["+getDesc("","\n\n")+"]]></description>"
				 + "<claims><![CDATA["+getClaims("","\n\n")+"]]></claims>"
				 
				 + "<publication_country><![CDATA["+getPubCountry()+"]]></publication_country>"
				 + "<publication_doc_number><![CDATA["+getPubDocNumber()+"]]></publication_doc_number>"
				 + "<publication_kind><![CDATA["+getPubKind()+"]]></publication_kind>"
				 + "<publication_date><![CDATA["+getPubDate(solr_format)+"]]></publication_date>"
				 + "<publication_year><![CDATA["+getPubYear()+"]]></publication_year>"
			
				 + "<application_country><![CDATA["+getAppCountry()+"]]></application_country>"
				 + "<application_doc_mumber><![CDATA["+getAppDocNumber()+"]]></application_doc_mumber>"
				 + "<application_number><![CDATA["+getAppNumber()+"]]></application_number>"
				 + "<application_kind><![CDATA["+getAppKind()+"]]></application_kind>"
				 + "<application_date><![CDATA["+getAppDate(solr_format)+"]]></application_date>"
				 + "<application_year><![CDATA["+getAppYear()+"]]></application_year>";
		}
		xml += "</doc></add>";
		
		return xml;
	}
	
	/*public SolrInputDocument getSolrDocument() {
		// TODO Auto-generated method stub
		return null;
	}*/
	public String toXMLLine(boolean solr_format) {
		return toXML(solr_format).replace("\n", "\\n");
	}
		
	protected ArrayList<String> ipcClassification;
	/**
	 * @return the ipcClassification
	 */
	public String getIpcClassifications(String prefix, String suffix) {
		// TODO Auto-generated method stub
		String ipcClassifications = "";
		for(int i=0; i<this.ipcSection.size(); i++) {
			ipcClassifications += prefix + ipcSection.get(i)+ipcClass.get(i)+ipcSubclass.get(i)+" "+ipcMainGroup.get(i)+"/"+ipcSubgroup+ suffix;
		}
		return ipcClassifications;
	}
	
	/**
	 * @param ipcClassification the ipcClassification to set
	 */
	public void addIpcClassification(String ipcClassification) {
		this.ipcClassification.add(ipcClassification);
	}

	protected ArrayList<String> ipcVersionDate;
	/**
	 * @return the ipcVersionDate
	 */
	public String getIpcVersionDate(String prefix, String suffix, boolean solr_format) {
		// TODO Auto-generated method stub
		String ipcVersionDates = "";
		for(String s : this.ipcVersionDate) {
			if(solr_format==true)
				s = String.format("%s-%s-%sT00:00:00Z", s.substring(0,4), s.substring(4,6), s.substring(6,8));
			
			ipcVersionDates += prefix + s + suffix;
		}
		return ipcVersionDates;
	}
	
	/**
	 * @param ipcVersionDate the ipcVersionDate to set
	 */
	public void addIpcVersionDate(String ipcVersionDate) {
		this.ipcVersionDate.add(ipcVersionDate);
	}
	
	protected ArrayList<String> ipcClassificationLevel;
	/**
	 * @return the ipcClassificationLevel
	 */
	public String getIpcClassificationLevel(String prefix, String suffix) {
		// TODO Auto-generated method stub
		String ipcClassificationLevels = "";
		for(String s : this.ipcClassificationLevel) {
			ipcClassificationLevels += prefix + s + suffix;
		}
		return ipcClassificationLevels;
	}
	
	/**
	 * @param ipcVersionDate the ipcClassificationLevel to set
	 */
	public void addIpcClassificationLevel(String ipcClassificationLevel) {
		this.ipcClassificationLevel.add(ipcClassificationLevel);
	}
	
	protected ArrayList<String> ipcSection;
	/**
	 * @return the ipcSection
	 */
	public String getIpcSection(String prefix, String suffix) {
		// TODO Auto-generated method stub
		String ipcSections = "";
		for(String s : this.ipcSection) {
			ipcSections += prefix + s + suffix;
		}
		return ipcSections;
	}
	
	/**
	 * @param ipcVersionDate the ipcSection to set
	 */
	public void addIpcSection(String ipcSection) {
		this.ipcSection.add(ipcSection);
	}
	
	protected ArrayList<String> ipcClass;
	/**
	 * @return the ipcClass
	 */
	public String getIpcClass(String prefix, String suffix) {
		// TODO Auto-generated method stub
		String ipcClasss = "";
		for(String s : this.ipcClass) {
			ipcClasss += prefix + s + suffix;
		}
		return ipcClasss;
	}
	
	/**
	 * @param ipcVersionDate the ipcClass to set
	 */
	public void addIpcClass(String ipcClass) {
		this.ipcClass.add(ipcClass);
	}
	
	protected ArrayList<String> ipcSubclass;
	/**
	 * @return the ipcSubclass
	 */
	public String getIpcSubclass(String prefix, String suffix) {
		// TODO Auto-generated method stub
		String ipcSubclasss = "";
		for(String s : this.ipcSubclass) {
			ipcSubclasss += prefix + s + suffix;
		}
		return ipcSubclasss;
	}
	
	/**
	 * @param ipcVersionDate the ipcSubclass to set
	 */
	public void addIpcSubclass(String ipcSubclass) {
		this.ipcSubclass.add(ipcSubclass);
	}
	
	protected ArrayList<String> ipcMainGroup;
	/**
	 * @return the ipcMainGroup
	 */
	public String getIpcMainGroup(String prefix, String suffix) {
		// TODO Auto-generated method stub
		String ipcMainGroups = "";
		for(String s : this.ipcMainGroup) {
			ipcMainGroups += prefix + s + suffix;
		}
		return ipcMainGroups;
	}
	
	/**
	 * @param ipcVersionDate the ipcMainGroup to set
	 */
	public void addIpcMainGroup(String ipcMainGroup) {
		this.ipcMainGroup.add(ipcMainGroup);
	}
	
	protected ArrayList<String> ipcSubgroup;
	
	/**
	 * @return the ipcSubgroup
	 */
	public String getIpcSubgroup(String prefix, String suffix) {
		// TODO Auto-generated method stub
		String ipcSubgroups = "";
		for(String s : this.ipcSubgroup) {
			ipcSubgroups += prefix + s + suffix;
		}
		return ipcSubgroups;
	}
	
	/**
	 * @param ipcVersionDate the ipcSubgroup to set
	 */
	public void addIpcSubgroup(String ipcSubgroup) {
		this.ipcSubgroup.add(ipcSubgroup);
	}
	
	protected ArrayList<String> ipcSymbolLevel;
	/**
	 * @return the ipcSymbolLevel
	 */
	public String getIpcSymbolLevel(String prefix, String suffix) {
		// TODO Auto-generated method stub
		String ipcSymbolLevels = "";
		for(String s : this.ipcSymbolLevel) {
			ipcSymbolLevels += prefix + s + suffix;
		}
		return ipcSymbolLevels;
	}
	
	/**
	 * @param ipcVersionDate the ipcSymbolLevel to set
	 */
	public void addIpcSymbolLevel(String ipcSymbolLevel) {
		this.ipcSymbolLevel.add(ipcSymbolLevel);
	}
	
	protected ArrayList<String> ipcClassificationValue;
	/**
	 * @return the ipcClassificationValue
	 */
	public String getIpcClassificationValue(String prefix, String suffix) {
		// TODO Auto-generated method stub
		String ipcClassificationValues = "";
		for(String s : this.ipcClassificationValue) {
			ipcClassificationValues += prefix + s + suffix;
		}
		return ipcClassificationValues;
	}
	
	/**
	 * @param ipcVersionDate the ipcClassificationValue to set
	 */
	public void addIpcClassificationValue(String ipcClassificationValue) {
		this.ipcClassificationValue.add(ipcClassificationValue);
	}
	
	protected String cpcMainClassification;
	/**
	 * @return the cpcMainClassification
	 */
	public String getCpcMainClassification(String prefix, String suffix) {
		// TODO Auto-generated method stub
		return prefix + cpcMainSection+cpcMainClass+cpcMainSubclass+" "+cpcMainGroup+"/"+cpcMainSubgroup + suffix;
	}
	
	/**
	 * @param cpcMainClassification the cpcMainClassification to set
	 */
	public void setCpcMainClassification(String cpcMainClassification) {
		this.cpcMainClassification = cpcMainClassification;
	}

	protected String cpcMainVersionDate;
	/**
	 * @return the cpcMainVersionDate
	 */
	public String getCpcMainVersionDate(String prefix, String suffix, boolean solr_format) {
		// TODO Auto-generated method stub
		if(solr_format==true)
			return prefix + String.format("%s-%s-%sT00:00:00Z", cpcMainVersionDate.substring(0,4), cpcMainVersionDate.substring(4,6), cpcMainVersionDate.substring(6,8)) + suffix;
		else
			return prefix + cpcMainVersionDate + suffix;
		
	}
	
	/**
	 * @param cpcMainVersionDate the cpcMainVersionDate to set
	 */
	public void setCpcMainVersionDate(String cpcMainVersionDate) {
		this.cpcMainVersionDate = cpcMainVersionDate;
	}
	
	protected String cpcMainClassificationLevel;
	/**
	 * @return the cpcMainClassificationLevel
	 */
	public String getCpcMainClassificationLevel(String prefix, String suffix) {
		// TODO Auto-generated method stub
		return prefix + cpcMainClassificationLevel +  suffix;
	}
	
	/**
	 * @param cpcMainClassificationLevel the cpcMainClassificationLevel to set
	 */
	public void setCpcMainClassificationLevel(String cpcMainClassificationLevel) {
		this.cpcMainClassificationLevel = cpcMainClassificationLevel;
	}
	
	protected String cpcMainSection;
	/**
	 * @return the cpcMainSection
	 */
	public String getCpcMainSection(String prefix, String suffix) {
		// TODO Auto-generated method stub
		return prefix + cpcMainSection + suffix;
	}
	
	/**
	 * @param cpcMainSection the cpcMainSection to set
	 */
	public void setCpcMainSection(String cpcMainSection) {
		this.cpcMainSection = cpcMainSection;
	}
	
	protected String cpcMainClass;
	/**
	 * @return the cpcMainClass
	 */
	public String getCpcMainClass(String prefix, String suffix) {
		// TODO Auto-generated method stub
		return prefix + cpcMainClass + suffix;
	}
	
	/**
	 * @param cpcMainClass the cpcMainClass to set
	 */
	public void setCpcMainClass(String cpcMainClass) {
		this.cpcMainClass = cpcMainClass;
	}
	
	protected String cpcMainSubclass;
	/**
	 * @return the cpcMainSubclass
	 */
	public String getCpcMainSubclass(String prefix, String suffix) {
		return prefix + cpcMainSubclass + suffix;
	}
	
	/**
	 * @param cpcMainSubclass the cpcMainSubclass to set
	 */
	public void setCpcMainSubclass(String cpcMainSubclass) {
		this.cpcMainSubclass = cpcMainSubclass;
	}
	
	protected String cpcMainGroup;
	/**
	 * @return the cpcMainGroup
	 */
	public String getCpcMainGroup(String prefix, String suffix) {
		// TODO Auto-generated method stub
		return prefix + cpcMainGroup + suffix;
	}
	
	/**
	 * @param cpcMainMainGroup the cpcMainMainGroup to set
	 */
	public void setCpcMainGroup(String cpcMainGroup) {
		this.cpcMainGroup = cpcMainGroup;
	}
	
	protected String cpcMainSubgroup;
	
	/**
	 * @return the cpcMainSubgroup
	 */
	public String getCpcMainSubgroup(String prefix, String suffix) {
		// TODO Auto-generated method stub
		return prefix + cpcMainSubgroup + suffix;
	}
	
	/**
	 * @param cpcMainSubgroup the cpcMainSubgroup to set
	 */
	public void setCpcMainSubgroup(String cpcMainSubgroup) {
		this.cpcMainSubgroup = cpcMainSubgroup;
	}
	
	protected String cpcMainSymbolLevel;
	/**
	 * @return the cpcMainSymbolLevel
	 */
	public String getCpcMainSymbolLevel(String prefix, String suffix) {
		// TODO Auto-generated method stub
		return prefix + cpcMainSymbolLevel + suffix;
	}
	
	/**
	 * @param cpcMainSymbolLevel the cpcMainSymbolLevel to set
	 */
	public void setCpcMainSymbolLevel(String cpcMainSymbolLevel) {
		this.cpcMainSymbolLevel = cpcMainSymbolLevel;
	}
	
	protected String cpcMainClassificationValue;
	/**
	 * @return the cpcMainClassificationValue
	 */
	public String getCpcMainClassificationValue(String prefix, String suffix) {
		return prefix + cpcMainClassificationValue + suffix;
	}
	
	/**
	 * @param cpcMainClassificationValue the cpcMainClassificationValue to set
	 */
	public void setCpcMainClassificationValue(String cpcMainClassificationValue) {
		this.cpcMainClassificationValue = cpcMainClassificationValue;
	}

	protected ArrayList<String> cpcFurtherClassification;
	/**
	 * @return the cpcFurtherClassification
	 */
	public String getCpcFurtherClassifications(String prefix, String suffix) {
		// TODO Auto-generated method stub
		String cpcFurtherClassifications = "";
		for(int i=0; i<this.cpcFurtherSection.size(); i++) {
			cpcFurtherClassifications += prefix + cpcFurtherSection.get(i)+cpcFurtherClass.get(i)+cpcFurtherSubclass.get(i)+" "+cpcFurtherGroup.get(i)+"/"+cpcFurtherSubgroup+ suffix;
		}
		return cpcFurtherClassifications;
	}
	
	/**
	 * @param cpcFurtherClassification the cpcFurtherClassification to set
	 */
	public void addCpcFurtherClassification(String cpcFurtherClassification) {
		this.cpcFurtherClassification.add(cpcFurtherClassification);
	}

	protected ArrayList<String> cpcFurtherVersionDate;
	/**
	 * @return the cpcFurtherVersionDate
	 */
	public String getCpcFurtherVersionDate(String prefix, String suffix, boolean solr_format) {
		// TODO Auto-generated method stub
		String cpcFurtherVersionDates = "";
		for(String s : this.cpcFurtherVersionDate) {
			if(solr_format==true)
				s = String.format("%s-%s-%sT00:00:00Z", s.substring(0,4), s.substring(4,6), s.substring(6,8));
			
			cpcFurtherVersionDates += prefix + s + suffix;
		}
		return cpcFurtherVersionDates;
	}
	
	/**
	 * @param cpcFurtherVersionDate the cpcFurtherVersionDate to set
	 */
	public void addCpcFurtherVersionDate(String cpcFurtherVersionDate) {
		this.cpcFurtherVersionDate.add(cpcFurtherVersionDate);
	}
	
	protected ArrayList<String> cpcFurtherClassificationLevel;
	/**
	 * @return the cpcFurtherClassificationLevel
	 */
	public String getCpcFurtherClassificationLevel(String prefix, String suffix) {
		// TODO Auto-generated method stub
		String cpcFurtherClassificationLevels = "";
		for(String s : this.cpcFurtherClassificationLevel) {
			cpcFurtherClassificationLevels += prefix + s + suffix;
		}
		return cpcFurtherClassificationLevels;
	}
	
	/**
	 * @param cpcFurtherClassificationLevel the cpcFurtherClassificationLevel to set
	 */
	public void addCpcFurtherClassificationLevel(String cpcFurtherClassificationLevel) {
		this.cpcFurtherClassificationLevel.add(cpcFurtherClassificationLevel);
	}
	
	protected ArrayList<String> cpcFurtherSection;
	/**
	 * @return the cpcFurtherSection
	 */
	public String getCpcFurtherSection(String prefix, String suffix) {
		// TODO Auto-generated method stub
		String cpcFurtherSections = "";
		for(String s : this.cpcFurtherSection) {
			cpcFurtherSections += prefix + s + suffix;
		}
		return cpcFurtherSections;
	}
	
	/**
	 * @param cpcFurtherSection the cpcFurtherSection to set
	 */
	public void addCpcFurtherSection(String cpcFurtherSection) {
		this.cpcFurtherSection.add(cpcFurtherSection);
	}
	
	protected ArrayList<String> cpcFurtherClass;
	/**
	 * @return the cpcFurtherClass
	 */
	public String getCpcFurtherClass(String prefix, String suffix) {
		// TODO Auto-generated method stub
		String cpcFurtherClasss = "";
		for(String s : this.cpcFurtherClass) {
			cpcFurtherClasss += prefix + s + suffix;
		}
		return cpcFurtherClasss;
	}
	
	/**
	 * @param cpcFurtherClass the cpcFurtherClass to set
	 */
	public void addCpcFurtherClass(String cpcFurtherClass) {
		this.cpcFurtherClass.add(cpcFurtherClass);
	}
	
	protected ArrayList<String> cpcFurtherSubclass;
	/**
	 * @return the cpcFurtherSubclass
	 */
	public String getCpcFurtherSubclass(String prefix, String suffix) {
		// TODO Auto-generated method stub
		String cpcFurtherSubclasss = "";
		for(String s : this.cpcFurtherSubclass) {
			cpcFurtherSubclasss += prefix + s + suffix;
		}
		return cpcFurtherSubclasss;
	}
	
	/**
	 * @param cpcFurtherSubclass the cpcFurtherSubclass to set
	 */
	public void addCpcFurtherSubclass(String cpcFurtherSubclass) {
		this.cpcFurtherSubclass.add(cpcFurtherSubclass);
	}
	
	protected ArrayList<String> cpcFurtherGroup;
	/**
	 * @return the cpcFurtherGroup
	 */
	public String getCpcFurtherGroup(String prefix, String suffix) {
		// TODO Auto-generated method stub
		String cpcFurtherGroups = "";
		for(String s : this.cpcFurtherGroup) {
			cpcFurtherGroups += prefix + s + suffix;
		}
		return cpcFurtherGroups;
	}
	
	/**
	 * @param cpcFurtherGroup the cpcFurtherGroup to set
	 */
	public void addCpcFurtherGroup(String cpcFurtherGroup) {
		this.cpcFurtherGroup.add(cpcFurtherGroup);
	}
	
	protected ArrayList<String> cpcFurtherSubgroup;
	
	/**
	 * @return the cpcFurtherSubgroup
	 */
	public String getCpcFurtherSubgroup(String prefix, String suffix) {
		// TODO Auto-generated method stub
		String cpcFurtherSubgroups = "";
		for(String s : this.cpcFurtherSubgroup) {
			cpcFurtherSubgroups += prefix + s + suffix;
		}
		return cpcFurtherSubgroups;
	}
	
	/**
	 * @param cpcFurtherSubgroup the cpcFurtherSubgroup to set
	 */
	public void addCpcFurtherSubgroup(String cpcFurtherSubgroup) {
		this.cpcFurtherSubgroup.add(cpcFurtherSubgroup);
	}
	
	protected ArrayList<String> cpcFurtherSymbolLevel;
	/**
	 * @return the cpcFurtherSymbolLevel
	 */
	public String getCpcFurtherSymbolLevel(String prefix, String suffix) {
		// TODO Auto-generated method stub
		String cpcFurtherSymbolLevels = "";
		for(String s : this.cpcFurtherSymbolLevel) {
			cpcFurtherSymbolLevels += prefix + s + suffix;
		}
		return cpcFurtherSymbolLevels;
	}
	
	/**
	 * @param cpcFurtherSymbolLevel the cpcFurtherSymbolLevel to set
	 */
	public void addCpcFurtherSymbolLevel(String cpcFurtherSymbolLevel) {
		this.cpcFurtherSymbolLevel.add(cpcFurtherSymbolLevel);
	}
	
	protected ArrayList<String> cpcFurtherClassificationValue;
	
	/**
	 * @return the cpcFurtherClassificationValue
	 */
	public String getCpcFurtherClassificationValue(String prefix, String suffix) {
		// TODO Auto-generated method stub
		String cpcFurtherClassificationValues = "";
		for(String s : this.cpcFurtherClassificationValue) {
			cpcFurtherClassificationValues += prefix + s + suffix;
		}
		return cpcFurtherClassificationValues;
	}
	
	/**
	 * @param cpcFurtherClassificationValue the cpcFurtherClassificationValue to set
	 */
	public void addCpcFurtherClassificationValue(String cpcFurtherClassificationValue) {
		this.cpcFurtherClassificationValue.add(cpcFurtherClassificationValue);
	}
	
	protected static String removeLeadingZeros(String s) {
		String prefix = "";
		for(int i= 0; i<s.length(); i++) {
			char c = s.charAt(i);
			if(Character.isDigit(c))
					break;
			prefix += s.charAt(i);
		}
		String suffix = s.substring(prefix.length());
		return prefix+suffix.replaceFirst("0*", "");
	}
	
	List<AddrezzBook> assignees;
	
	protected String getAssignees(boolean solr_format) {
		// TODO Auto-generated method stub
		String ret = "";
		if(solr_format) {
		ret += getAssigneesAddrezzbookDepartment("<field name=\"assignee_addressbook_department\"><![CDATA[","]]></field>")
			 + getAssigneesAddrezzbookDtext("<field name=\"assignee_addressbook_dtext\"><![CDATA[","]]></field>")
			 + getAssigneesAddrezzbookEad("<field name=\"assignee_addressbook_ead\"><![CDATA[","]]></field>")
			 + getAssigneesAddrezzbookEmail("<field name=\"assignee_addressbook_email\"><![CDATA[","]]></field>")
			 + getAssigneesAddrezzbookFax("<field name=\"assignee_addressbook_fax\"><![CDATA[","]]></field>")
			 + getAssigneesAddrezzbookFirstName("<field name=\"assignee_addressbook_firstname\"><![CDATA[","]]></field>")
			 + getAssigneesAddrezzbookIid("<field name=\"assignee_addressbook_iid\"><![CDATA[","]]></field>")
			 + getAssigneesAddrezzbookLastName("<field name=\"assignee_addressbook_lastname\"><![CDATA[","]]></field>")
			 + getAssigneesAddrezzbookMiddleName("<field name=\"assignee_addressbook_middlename\"><![CDATA[","]]></field>")
			 + getAssigneesAddrezzbookName("<field name=\"assignee_addressbook_name\"><![CDATA[","]]></field>")
			 + getAssigneesAddrezzbookOrgname("<field name=\"assignee_addressbook_orgname\"><![CDATA[","]]></field>")
			 + getAssigneesAddrezzbookPhone("<field name=\"assignee_addressbook_phone\"><![CDATA[","]]></field>")
			 + getAssigneesAddrezzbookPrefix("<field name=\"assignee_addressbook_prefix\"><![CDATA[","]]></field>")
			 + getAssigneesAddrezzbookRegisteredNumber("<field name=\"assignee_addressbook_registerednumber\"><![CDATA[","]]></field>")
			 + getAssigneesAddrezzbookRole("<field name=\"assignee_addressbook_role\"><![CDATA[","]]></field>")
			 + getAssigneesAddrezzbookSuffix("<field name=\"assignee_addressbook_suffix\"><![CDATA[","]]></field>")
			 + getAssigneesAddrezzbookSynonym("<field name=\"assignee_addressbook_synonym\"><![CDATA[","]]></field>")
			 + getAssigneesAddrezzbookText("<field name=\"assignee_addressbook_text\"><![CDATA[","]]></field>")
			 + getAssigneesAddrezzbookUrl("<field name=\"assignee_addressbook_url\"><![CDATA[","]]></field>")
			 + getAssigneesDepartment("<field name=\"assignee_department\"><![CDATA[","]]></field>")
			 + getAssigneesDtext("<field name=\"assignee_dtext\"><![CDATA[","]]></field>")
			 + getAssigneesEad("<field name=\"assignee_ead\"><![CDATA[","]]></field>")
			 + getAssigneesEmail("<field name=\"assignee_email\"><![CDATA[","]]></field>")
			 + getAssigneesFax("<field name=\"assignee_fax\"><![CDATA[","]]></field>")
			 + getAssigneesFirstName("<field name=\"assignee_firstname\"><![CDATA[","]]></field>")
			 + getAssigneesIid("<field name=\"assignee_iid\"><![CDATA[","]]></field>")
			 + getAssigneesLastName("<field name=\"assignee_lastname\"><![CDATA[","]]></field>")
			 + getAssigneesMiddleName("<field name=\"assignee_middlename\"><![CDATA[","]]></field>")
			 + getAssigneesName("<field name=\"assignee_name\"><![CDATA[","]]></field>")
			 + getAssigneesOrgname("<field name=\"assignee_orgname\"><![CDATA[","]]></field>")
			 + getAssigneesPhone("<field name=\"assignee_phone\"><![CDATA[","]]></field>")
			 + getAssigneesPrefix("<field name=\"assignee_prefix\"><![CDATA[","]]></field>")
			 + getAssigneesRegisteredNumber("<field name=\"assignee_registerednumber\"><![CDATA[","]]></field>")
			 + getAssigneesRole("<field name=\"assignee_role\"><![CDATA[","]]></field>")
			 + getAssigneesSuffix("<field name=\"assignee_suffix\"><![CDATA[","]]></field>")
			 + getAssigneesSynonym("<field name=\"assignee_synonym\"><![CDATA[","]]></field>")
			 + getAssigneesText("<field name=\"assignee_text\"><![CDATA[","]]></field>")
			 + getAssigneesUrl("<field name=\"assignee_url\"><![CDATA[","]]></field>");
		}
		else {
			ret += getAssigneesAddrezzbookDepartment("<assignee_addressbook_department><![CDATA[","]]></field>")
				 + getAssigneesAddrezzbookDtext("<assignee_addressbook_dtext><![CDATA[","]]></assignee_addressbook_department>")
				 + getAssigneesAddrezzbookEad("<assignee_addressbook_ead><![CDATA[","]]></assignee_addressbook_ead>")
				 + getAssigneesAddrezzbookEmail("<assignee_addressbook_email><![CDATA[","]]></assignee_addressbook_email>")
				 + getAssigneesAddrezzbookFax("<assignee_addressbook_fax><![CDATA[","]]></assignee_addressbook_fax>")
				 + getAssigneesAddrezzbookFirstName("<assignee_addressbook_firstname><![CDATA[","]]></assignee_addressbook_firstname>")
				 + getAssigneesAddrezzbookIid("<assignee_addressbook_iid><![CDATA[","]]></assignee_addressbook_iid>")
				 + getAssigneesAddrezzbookLastName("<assignee_addressbook_lastname><![CDATA[","]]></assignee_addressbook_lastname>")
				 + getAssigneesAddrezzbookMiddleName("<assignee_addressbook_middlename><![CDATA[","]]></assignee_addressbook_middlename>")
				 + getAssigneesAddrezzbookName("<assignee_addressbook_name><![CDATA[","]]></assignee_addressbook_name>")
				 + getAssigneesAddrezzbookOrgname("<assignee_addressbook_orgname><![CDATA[","]]></assignee_addressbook_orgname>")
				 + getAssigneesAddrezzbookPhone("<assignee_addressbook_phone><![CDATA[","]]></assignee_addressbook_phone>")
				 + getAssigneesAddrezzbookPrefix("<assignee_addressbook_prefix><![CDATA[","]]></assignee_addressbook_prefix>")
				 + getAssigneesAddrezzbookRegisteredNumber("<assignee_addressbook_registerednumber><![CDATA[","]]></assignee_addressbook_registerednumber>")
				 + getAssigneesAddrezzbookRole("<assignee_addressbook_role><![CDATA[","]]></assignee_addressbook_role>")
				 + getAssigneesAddrezzbookSuffix("<assignee_addressbook_suffix><![CDATA[","]]></assignee_addressbook_suffix>")
				 + getAssigneesAddrezzbookSynonym("<assignee_addressbook_synonym><![CDATA[","]]></assignee_addressbook_synonym>")
				 + getAssigneesAddrezzbookText("<assignee_addressbook_text><![CDATA[","]]></assignee_addressbook_text>")
				 + getAssigneesAddrezzbookUrl("<assignee_addressbook_url><![CDATA[","]]></assignee_addressbook_url>")
				 + getAssigneesDepartment("<assignee_department><![CDATA[","]]></field>")
				 + getAssigneesDtext("<assignee_dtext><![CDATA[","]]></assignee_department>")
				 + getAssigneesEad("<assignee_ead><![CDATA[","]]></assignee_ead>")
				 + getAssigneesEmail("<assignee_email><![CDATA[","]]></assignee_email>")
				 + getAssigneesFax("<assignee_fax><![CDATA[","]]></assignee_fax>")
				 + getAssigneesFirstName("<assignee_firstname><![CDATA[","]]></assignee_firstname>")
				 + getAssigneesIid("<assignee_iid><![CDATA[","]]></assignee_iid>")
				 + getAssigneesLastName("<assignee_lastname><![CDATA[","]]></assignee_lastname>")
				 + getAssigneesMiddleName("<assignee_middlename><![CDATA[","]]></assignee_middlename>")
				 + getAssigneesName("<assignee_name><![CDATA[","]]></assignee_name>")
				 + getAssigneesOrgname("<assignee_orgname><![CDATA[","]]></assignee_orgname>")
				 + getAssigneesPhone("<assignee_phone><![CDATA[","]]></assignee_phone>")
				 + getAssigneesPrefix("<assignee_prefix><![CDATA[","]]></assignee_prefix>")
				 + getAssigneesRegisteredNumber("<assignee_registerednumber><![CDATA[","]]></assignee_registerednumber>")
				 + getAssigneesRole("<assignee_role><![CDATA[","]]></assignee_role>")
				 + getAssigneesSuffix("<assignee_suffix><![CDATA[","]]></assignee_suffix>")
				 + getAssigneesSynonym("<assignee_synonym><![CDATA[","]]></assignee_synonym>")
				 + getAssigneesText("<assignee_text><![CDATA[","]]></assignee_text>")
				 + getAssigneesUrl("<assignee_url><![CDATA[","]]></assignee_url>");
		}
		return ret;
	}
	/**
	 * @param addrezzBook the assignee to add
	 */
	public void addAssignee(AddrezzBook addrezzBook) {
		// TODO Auto-generated method stub
		assignees.add(addrezzBook);
	}
	
	/**
	 * @return the assignees firstname
	 */
	public String getAssigneesFirstName(String prefix, String suffix) {
		// TODO Auto-generated method stub
		String ret = "";
		String tmp = "";
		for(AddrezzBook elem : this.assignees) {
			tmp = elem.getFirstName();
				ret += prefix + tmp + suffix;
			}
		return ret;
	}
	
	/**
	 * @return the assignees lastname
	 */
	public String getAssigneesLastName(String prefix, String suffix) {
		// TODO Auto-generated method stub
		String ret = "";
		String tmp = "";
		for(AddrezzBook elem : this.assignees) {
			tmp = elem.getLastName();
				ret += prefix + tmp + suffix;
			}
		return ret;
	}
	
	/**
	 * @return the assignees name
	 */
	public String getAssigneesName(String prefix, String suffix) {
		// TODO Auto-generated method stub
		String ret = "";
		String tmp = "";
		for(AddrezzBook elem : this.assignees) {
			tmp = elem.getName();
				ret += prefix + tmp + suffix;
			}
		return ret;
	}
	
	/**
	 * @return the assignees department
	 */
	public String getAssigneesDepartment(String prefix, String suffix) {
		// TODO Auto-generated method stub
		String ret = "";
		String tmp = "";
		for(AddrezzBook elem : this.assignees) {
			tmp = elem.getDepartment();
				ret += prefix + tmp + suffix;
			}
		return ret;
	}
	
	/**
	 * @return the assignees dtext
	 */
	public String getAssigneesDtext(String prefix, String suffix) {
		// TODO Auto-generated method stub
		String ret = "";
		String tmp = "";
		for(AddrezzBook elem : this.assignees) {
			tmp = elem.getDtext();
				ret += prefix + tmp + suffix;
			}
		return ret;
	}
	
	/**
	 * @return the assignees ead
	 */
	public String getAssigneesEad(String prefix, String suffix) {
		// TODO Auto-generated method stub
		String ret = "";
		String tmp = "";
		for(AddrezzBook elem : this.assignees) {
			tmp = elem.getEad();
				ret += prefix + tmp + suffix;
			}
		return ret;
	}
	
	/**
	 * @return the assignees email
	 */
	public String getAssigneesEmail(String prefix, String suffix) {
		// TODO Auto-generated method stub
		String ret = "";
		String tmp = "";
		for(AddrezzBook elem : this.assignees) {
			tmp = elem.getEmail();
				ret += prefix + tmp + suffix;
			}
		return ret;
	}
	
	/**
	 * @return the assignees Fax
	 */
	public String getAssigneesFax(String prefix, String suffix) {
		// TODO Auto-generated method stub
		String ret = "";
		String tmp = "";
		for(AddrezzBook elem : this.assignees) {
			tmp = elem.getFax();
				ret += prefix + tmp + suffix;
			}
		return ret;
	}
	
	/**
	 * @return the assignees Iid
	 */
	public String getAssigneesIid(String prefix, String suffix) {
		// TODO Auto-generated method stub
		String ret = "";
		String tmp = "";
		for(AddrezzBook elem : this.assignees) {
			tmp = elem.getIid();
				ret += prefix + tmp + suffix;
			}
		return ret;
	}
	
	/**
	 * @return the assignees MiddleName
	 */
	public String getAssigneesMiddleName(String prefix, String suffix) {
		// TODO Auto-generated method stub
		String ret = "";
		String tmp = "";
		for(AddrezzBook elem : this.assignees) {
			tmp = elem.getMiddleName();
				ret += prefix + tmp + suffix;
			}
		return ret;
	}
	
	/**
	 * @return the assignees Orgname
	 */
	public String getAssigneesOrgname(String prefix, String suffix) {
		// TODO Auto-generated method stub
		String ret = "";
		String tmp = "";
		for(AddrezzBook elem : this.assignees) {
			tmp = elem.getOrgname();
				ret += prefix + tmp + suffix;
			}
		return ret;
	}
	
	/**
	 * @return the assignees Phone
	 */
	public String getAssigneesPhone(String prefix, String suffix) {
		// TODO Auto-generated method stub
		String ret = "";
		String tmp = "";
		for(AddrezzBook elem : this.assignees) {
			tmp = elem.getPhone();
				ret += prefix + tmp + suffix;
			}
		return ret;
	}
	
	/**
	 * @return the assignees Prefix
	 */
	public String getAssigneesPrefix(String prefix, String suffix) {
		// TODO Auto-generated method stub
		String ret = "";
		String tmp = "";
		for(AddrezzBook elem : this.assignees) {
			tmp = elem.getPrefix();
				ret += prefix + tmp + suffix;
			}
		return ret;
	}
	
	/**
	 * @return the assignees RegisteredNumber
	 */
	public String getAssigneesRegisteredNumber(String prefix, String suffix) {
		// TODO Auto-generated method stub
		String ret = "";
		String tmp = "";
		for(AddrezzBook elem : this.assignees) {
			tmp = elem.getRegisteredNumber();
				ret += prefix + tmp + suffix;
			}
		return ret;
	}
	
	/**
	 * @return the assignees Role
	 */
	public String getAssigneesRole(String prefix, String suffix) {
		// TODO Auto-generated method stub
		String ret = "";
		String tmp = "";
		for(AddrezzBook elem : this.assignees) {
			tmp = elem.getRole();
				ret += prefix + tmp + suffix;
			}
		return ret;
	}
	
	/**
	 * @return the assignees Suffix
	 */
	public String getAssigneesSuffix(String prefix, String suffix) {
		// TODO Auto-generated method stub
		String ret = "";
		String tmp = "";
		for(AddrezzBook elem : this.assignees) {
			tmp = elem.getSuffix();
				ret += prefix + tmp + suffix;
			}
		return ret;
	}
	
	/**
	 * @return the assignees Synonym
	 */
	public String getAssigneesSynonym(String prefix, String suffix) {
		// TODO Auto-generated method stub
		String ret = "";
		String tmp = "";
		for(AddrezzBook elem : this.assignees) {
			tmp = elem.getSynonym();
				ret += prefix + tmp + suffix;
			}
		return ret;
	}
	
	/**
	 * @return the assignees Text
	 */
	public String getAssigneesText(String prefix, String suffix) {
		// TODO Auto-generated method stub
		String ret = "";
		String tmp = "";
		for(AddrezzBook elem : this.assignees) {
			tmp = elem.getText();
				ret += prefix + tmp + suffix;
			}
		return ret;
	}
	
	/**
	 * @return the assignees Url
	 */
	public String getAssigneesUrl(String prefix, String suffix) {
		// TODO Auto-generated method stub
		String ret = "";
		String tmp = "";
		for(AddrezzBook elem : this.assignees) {
			tmp = elem.getUrl();
			ret += prefix + tmp + suffix;
		}
		return ret;
	}
	
	/**
	 * @return the assignees addrezzbook firstname
	 */
	public String getAssigneesAddrezzbookFirstName(String prefix, String suffix) {
		// TODO Auto-generated method stub
		String ret = "";
		String tmp = "";
		for(AddrezzBook elem : this.assignees) {
			if(elem.addrezzbook!=null)
				tmp = elem.addrezzbook.getFirstName();
			
			ret += prefix + tmp + suffix;
		}
		return ret;
	}
	
	/**
	 * @return the assignees addrezzbook lastname
	 */
	public String getAssigneesAddrezzbookLastName(String prefix, String suffix) {
		// TODO Auto-generated method stub
		String ret = "";
		String tmp = "";
		for(AddrezzBook elem : this.assignees) {
			if(elem.addrezzbook!=null)
				tmp = elem.addrezzbook.getLastName();
				
			ret += prefix + tmp + suffix;
		}
		return ret;
	}
	
	/**
	 * @return the assignees addrezzbook name
	 */
	public String getAssigneesAddrezzbookName(String prefix, String suffix) {
		// TODO Auto-generated method stub
		String ret = "";
		String tmp = "";
		for(AddrezzBook elem : this.assignees) {
			if(elem.addrezzbook!=null)
				tmp = elem.addrezzbook.getName();
				
			ret += prefix + tmp + suffix;
		}
		return ret;
	}
	
	/**
	 * @return the assignees addrezzbook department
	 */
	public String getAssigneesAddrezzbookDepartment(String prefix, String suffix) {
		// TODO Auto-generated method stub
		String ret = "";
		String tmp = "";
		for(AddrezzBook elem : this.assignees) {
			if(elem.addrezzbook!=null)
				tmp = elem.addrezzbook.getDepartment();
			ret += prefix + tmp + suffix;
		}
		return ret;
	}
	
	/**
	 * @return the assignees addrezzbook dtext
	 */
	public String getAssigneesAddrezzbookDtext(String prefix, String suffix) {
		// TODO Auto-generated method stub
		String ret = "";
		String tmp = "";
		for(AddrezzBook elem : this.assignees) {
			if(elem.addrezzbook!=null)
				tmp = elem.addrezzbook.getDtext();
				ret += prefix + tmp + suffix;
			}
		return ret;
	}
	
	/**
	 * @return the assignees addrezzbook ead
	 */
	public String getAssigneesAddrezzbookEad(String prefix, String suffix) {
		// TODO Auto-generated method stub
		String ret = "";
		String tmp = "";
		for(AddrezzBook elem : this.assignees) {
			if(elem.addrezzbook!=null)
				tmp = elem.addrezzbook.getEad();
			
			ret += prefix + tmp + suffix;
		}
		return ret;
	}
	
	/**
	 * @return the assignees addrezzbook email
	 */
	public String getAssigneesAddrezzbookEmail(String prefix, String suffix) {
		// TODO Auto-generated method stub
		String ret = "";
		String tmp = "";
		for(AddrezzBook elem : this.assignees) {
			if(elem.addrezzbook!=null)
				tmp = elem.addrezzbook.getEmail();
			
			ret += prefix + tmp + suffix;
		}
		return ret;
	}
	
	/**
	 * @return the assignees addrezzbook Fax
	 */
	public String getAssigneesAddrezzbookFax(String prefix, String suffix) {
		// TODO Auto-generated method stub
		String ret = "";
		String tmp = "";
		for(AddrezzBook elem : this.assignees) {
			if(elem.addrezzbook!=null)
				tmp = elem.addrezzbook.getFax();
			
			ret += prefix + tmp + suffix;
		}
		return ret;
	}
	
	/**
	 * @return the assignees addrezzbook Iid
	 */
	public String getAssigneesAddrezzbookIid(String prefix, String suffix) {
		// TODO Auto-generated method stub
		String ret = "";
		String tmp = "";
		for(AddrezzBook elem : this.assignees) {
			if(elem.addrezzbook!=null)
				tmp = elem.addrezzbook.getIid();
				
			ret += prefix + tmp + suffix;
		}
		return ret;
	}
	
	/**
	 * @return the assignees addrezzbook MiddleName
	 */
	public String getAssigneesAddrezzbookMiddleName(String prefix, String suffix) {
		// TODO Auto-generated method stub
		String ret = "";
		String tmp = "";
		for(AddrezzBook elem : this.assignees) {
			if(elem.addrezzbook!=null)
				tmp = elem.addrezzbook.getMiddleName();
				
			ret += prefix + tmp + suffix;
		}
		return ret;
	}
	
	/**
	 * @return the assignees addrezzbook Orgname
	 */
	public String getAssigneesAddrezzbookOrgname(String prefix, String suffix) {
		// TODO Auto-generated method stub
		String ret = "";
		String tmp = "";
		for(AddrezzBook elem : this.assignees) {
			if(elem.addrezzbook!=null)
				tmp = elem.addrezzbook.getOrgname();
				
			ret += prefix + tmp + suffix;
		}
		return ret;
	}
	
	/**
	 * @return the assignees addrezzbook Phone
	 */
	public String getAssigneesAddrezzbookPhone(String prefix, String suffix) {
		// TODO Auto-generated method stub
		String ret = "";
		String tmp = "";
		for(AddrezzBook elem : this.assignees) {
			if(elem.addrezzbook!=null)
				tmp = elem.addrezzbook.getPhone();
			
			ret += prefix + tmp + suffix;
		}
		return ret;
	}
	
	/**
	 * @return the assignees addrezzbook Prefix
	 */
	public String getAssigneesAddrezzbookPrefix(String prefix, String suffix) {
		// TODO Auto-generated method stub
		String ret = "";
		String tmp = "";
		for(AddrezzBook elem : this.assignees) {
			if(elem.addrezzbook!=null)
				tmp = elem.addrezzbook.getPrefix();
			
			ret += prefix + tmp + suffix;
		}
		return ret;
	}
	
	/**
	 * @return the assignees addrezzbook RegisteredNumber
	 */
	public String getAssigneesAddrezzbookRegisteredNumber(String prefix, String suffix) {
		// TODO Auto-generated method stub
		String ret = "";
		String tmp = "";
		for(AddrezzBook elem : this.assignees) {
			if(elem.addrezzbook!=null)
				tmp = elem.addrezzbook.getRegisteredNumber();
			
			ret += prefix + tmp + suffix;
		}
		return ret;
	}
	
	/**
	 * @return the assignees addrezzbook Role
	 */
	public String getAssigneesAddrezzbookRole(String prefix, String suffix) {
		// TODO Auto-generated method stub
		String ret = "";
		String tmp = "";
		for(AddrezzBook elem : this.assignees) {
			if(elem.addrezzbook!=null)
				tmp = elem.addrezzbook.getRole();
			
			ret += prefix + tmp + suffix;
		}
		return ret;
	}
	
	/**
	 * @return the assignees addrezzbook Suffix
	 */
	public String getAssigneesAddrezzbookSuffix(String prefix, String suffix) {
		// TODO Auto-generated method stub
		String ret = "";
		String tmp = "";
		for(AddrezzBook elem : this.assignees) {
			if(elem.addrezzbook!=null)
				tmp = elem.addrezzbook.getSuffix();
				
			ret += prefix + tmp + suffix;
		}
		return ret;
	}
	
	/**
	 * @return the assignees addrezzbook Synonym
	 */
	public String getAssigneesAddrezzbookSynonym(String prefix, String suffix) {
		// TODO Auto-generated method stub
		String ret = "";
		String tmp = "";
		for(AddrezzBook elem : this.assignees) {
			if(elem.addrezzbook!=null)
				tmp = elem.addrezzbook.getSynonym();
				
			ret += prefix + tmp + suffix;
		}
		return ret;
	}
	
	/**
	 * @return the assignees addrezzbook Text
	 */
	public String getAssigneesAddrezzbookText(String prefix, String suffix) {
		// TODO Auto-generated method stub
		String ret = "";
		String tmp = "";
		for(AddrezzBook elem : this.assignees) {
			if(elem.addrezzbook!=null)
				tmp = elem.addrezzbook.getText();
				
			ret += prefix + tmp + suffix;
		}
		return ret;
	}
	
	/**
	 * @return the assignees addrezzbook Url
	 */
	public String getAssigneesAddrezzbookUrl(String prefix, String suffix) {
		// TODO Auto-generated method stub
		String ret = "";
		String tmp = "";
		for(AddrezzBook elem : this.assignees) {
			if(elem.addrezzbook!=null)
				tmp = elem.addrezzbook.getUrl();
			
			ret += prefix + tmp + suffix;
		}
		return ret;
	}
	
	List<AddrezzBook> inventors;
	
	/**
	 * @param addrezzBook the inventor to add
	 */
	public void addInventor(AddrezzBook addrezzBook) {
		// TODO Auto-generated method stub
		inventors.add(addrezzBook);
	}
	
	/**
	 * @return the inventors firstname
	 */
	public String getInventorsFirstName(String prefix, String suffix) {
		// TODO Auto-generated method stub
		String ret = "";
		String tmp = "";
		for(AddrezzBook elem : this.inventors) {
			tmp = elem.getFirstName();
				ret += prefix + tmp + suffix;
			}
		return ret;
	}
	
	/**
	 * @return the inventors lastname
	 */
	public String getInventorsLastName(String prefix, String suffix) {
		// TODO Auto-generated method stub
		String ret = "";
		String tmp = "";
		for(AddrezzBook elem : this.inventors) {
			tmp = elem.getLastName();
				ret += prefix + tmp + suffix;
			}
		return ret;
	}
	
	/**
	 * @return the inventors name
	 */
	public String getInventorsName(String prefix, String suffix) {
		// TODO Auto-generated method stub
		String ret = "";
		String tmp = "";
		for(AddrezzBook elem : this.inventors) {
			tmp = elem.getName();
				ret += prefix + tmp + suffix;
			}
		return ret;
	}
	
	/**
	 * @return the inventors department
	 */
	public String getInventorsDepartment(String prefix, String suffix) {
		// TODO Auto-generated method stub
		String ret = "";
		String tmp = "";
		for(AddrezzBook elem : this.inventors) {
			tmp = elem.getDepartment();
				ret += prefix + tmp + suffix;
			}
		return ret;
	}
	
	/**
	 * @return the inventors dtext
	 */
	public String getInventorsDtext(String prefix, String suffix) {
		// TODO Auto-generated method stub
		String ret = "";
		String tmp = "";
		for(AddrezzBook elem : this.inventors) {
			tmp = elem.getDtext();
				ret += prefix + tmp + suffix;
			}
		return ret;
	}
	
	/**
	 * @return the inventors ead
	 */
	public String getInventorsEad(String prefix, String suffix) {
		// TODO Auto-generated method stub
		String ret = "";
		String tmp = "";
		for(AddrezzBook elem : this.inventors) {
			tmp = elem.getEad();
				ret += prefix + tmp + suffix;
			}
		return ret;
	}
	
	/**
	 * @return the inventors email
	 */
	public String getInventorsEmail(String prefix, String suffix) {
		// TODO Auto-generated method stub
		String ret = "";
		String tmp = "";
		for(AddrezzBook elem : this.inventors) {
			tmp = elem.getEmail();
				ret += prefix + tmp + suffix;
			}
		return ret;
	}
	
	/**
	 * @return the inventors Fax
	 */
	public String getInventorsFax(String prefix, String suffix) {
		// TODO Auto-generated method stub
		String ret = "";
		String tmp = "";
		for(AddrezzBook elem : this.inventors) {
			tmp = elem.getFax();
				ret += prefix + tmp + suffix;
			}
		return ret;
	}
	
	/**
	 * @return the inventors Iid
	 */
	public String getInventorsIid(String prefix, String suffix) {
		// TODO Auto-generated method stub
		String ret = "";
		String tmp = "";
		for(AddrezzBook elem : this.inventors) {
			tmp = elem.getIid();
				ret += prefix + tmp + suffix;
			}
		return ret;
	}
	
	/**
	 * @return the inventors MiddleName
	 */
	public String getInventorsMiddleName(String prefix, String suffix) {
		// TODO Auto-generated method stub
		String ret = "";
		String tmp = "";
		for(AddrezzBook elem : this.inventors) {
			tmp = elem.getMiddleName();
				ret += prefix + tmp + suffix;
			}
		return ret;
	}
	
	/**
	 * @return the inventors Orgname
	 */
	public String getInventorsOrgname(String prefix, String suffix) {
		// TODO Auto-generated method stub
		String ret = "";
		String tmp = "";
		for(AddrezzBook elem : this.inventors) {
			tmp = elem.getOrgname();
				ret += prefix + tmp + suffix;
			}
		return ret;
	}
	
	/**
	 * @return the inventors Phone
	 */
	public String getInventorsPhone(String prefix, String suffix) {
		// TODO Auto-generated method stub
		String ret = "";
		String tmp = "";
		for(AddrezzBook elem : this.inventors) {
			tmp = elem.getPhone();
				ret += prefix + tmp + suffix;
			}
		return ret;
	}
	
	/**
	 * @return the inventors Prefix
	 */
	public String getInventorsPrefix(String prefix, String suffix) {
		// TODO Auto-generated method stub
		String ret = "";
		String tmp = "";
		for(AddrezzBook elem : this.inventors) {
			tmp = elem.getPrefix();
				ret += prefix + tmp + suffix;
			}
		return ret;
	}
	
	/**
	 * @return the inventors RegisteredNumber
	 */
	public String getInventorsRegisteredNumber(String prefix, String suffix) {
		// TODO Auto-generated method stub
		String ret = "";
		String tmp = "";
		for(AddrezzBook elem : this.inventors) {
			tmp = elem.getRegisteredNumber();
				ret += prefix + tmp + suffix;
			}
		return ret;
	}
	
	/**
	 * @return the inventors Role
	 */
	public String getInventorsRole(String prefix, String suffix) {
		// TODO Auto-generated method stub
		String ret = "";
		String tmp = "";
		for(AddrezzBook elem : this.inventors) {
			tmp = elem.getRole();
				ret += prefix + tmp + suffix;
			}
		return ret;
	}
	
	/**
	 * @return the inventors Suffix
	 */
	public String getInventorsSuffix(String prefix, String suffix) {
		// TODO Auto-generated method stub
		String ret = "";
		String tmp = "";
		for(AddrezzBook elem : this.inventors) {
			tmp = elem.getSuffix();
				ret += prefix + tmp + suffix;
			}
		return ret;
	}
	
	/**
	 * @return the inventors Synonym
	 */
	public String getInventorsSynonym(String prefix, String suffix) {
		// TODO Auto-generated method stub
		String ret = "";
		String tmp = "";
		for(AddrezzBook elem : this.inventors) {
			tmp = elem.getSynonym();
				ret += prefix + tmp + suffix;
			}
		return ret;
	}
	
	/**
	 * @return the inventors Text
	 */
	public String getInventorsText(String prefix, String suffix) {
		// TODO Auto-generated method stub
		String ret = "";
		String tmp = "";
		for(AddrezzBook elem : this.inventors) {
			tmp = elem.getText();
				ret += prefix + tmp + suffix;
			}
		return ret;
	}
	
	protected String getInventors(boolean solr_format) {
		// TODO Auto-generated method stub
		String ret = "";
		if(solr_format) {
		ret += getInventorsAddressAddress1("<field name=\"inventor_address_address1\"><![CDATA[","]]></field>")
			 + getInventorsAddressAddress2("<field name=\"inventor_address_address2\"><![CDATA[","]]></field>")
			 + getInventorsAddressAddress3("<field name=\"inventor_address_address3\"><![CDATA[","]]></field>")
			 + getInventorsAddressAddressFloor("<field name=\"inventor_address_floor\"><![CDATA[","]]></field>")
			 + getInventorsAddressBuilding("<field name=\"inventor_address_building\"><![CDATA[","]]></field>")
			 + getInventorsAddressCity("<field name=\"inventor_address_city\"><![CDATA[","]]></field>")
			 + getInventorsAddressCountry("<field name=\"inventor_address_country\"><![CDATA[","]]></field>")
			 + getInventorsAddressCounty("<field name=\"inventor_address_county\"><![CDATA[","]]></field>")
			 + getInventorsAddressMailcode("<field name=\"inventor_address_mailcode\"><![CDATA[","]]></field>")
			 + getInventorsAddressPobox("<field name=\"inventor_address_pobox\"><![CDATA[","]]></field>")
			 + getInventorsAddressPostcode("<field name=\"inventor_address_postcode\"><![CDATA[","]]></field>")
			 + getInventorsAddressRoom("<field name=\"inventor_address_room\"><![CDATA[","]]></field>")
			 + getInventorsAddressState("<field name=\"inventor_address_state\"><![CDATA[","]]></field>")
			 + getInventorsAddressStreet("<field name=\"inventor_address_street\"><![CDATA[","]]></field>")
			 + getInventorsAddressText("<field name=\"inventor_address_text\"><![CDATA[","]]></field>")
			 + getInventorsDepartment("<field name=\"inventor_department\"><![CDATA[","]]></field>")
			 + getInventorsDtext("<field name=\"inventor_dtext\"><![CDATA[","]]></field>")
			 + getInventorsEad("<field name=\"inventor_ead\"><![CDATA[","]]></field>")
			 + getInventorsEmail("<field name=\"inventor_email\"><![CDATA[","]]></field>")
			 + getInventorsFax("<field name=\"inventor_fax\"><![CDATA[","]]></field>")
			 + getInventorsFirstName("<field name=\"inventor_firstname\"><![CDATA[","]]></field>")
			 + getInventorsIid("<field name=\"inventor_iid\"><![CDATA[","]]></field>")
			 + getInventorsLastName("<field name=\"inventor_lastname\"><![CDATA[","]]></field>")
			 + getInventorsMiddleName("<field name=\"inventor_middlename\"><![CDATA[","]]></field>")
			 + getInventorsName("<field name=\"inventor_name\"><![CDATA[","]]></field>")
			 + getInventorsOrgname("<field name=\"inventor_orgname\"><![CDATA[","]]></field>")
			 + getInventorsPhone("<field name=\"inventor_phone\"><![CDATA[","]]></field>")
			 + getInventorsPrefix("<field name=\"inventor_prefix\"><![CDATA[","]]></field>")
			 + getInventorsRegisteredNumber("<field name=\"inventor_registerednumber\"><![CDATA[","]]></field>")
			 + getInventorsRole("<field name=\"inventor_role\"><![CDATA[","]]></field>")
			 + getInventorsSuffix("<field name=\"inventor_suffix\"><![CDATA[","]]></field>")
			 + getInventorsSynonym("<field name=\"inventor_synonym\"><![CDATA[","]]></field>")
			 + getInventorsText("<field name=\"inventor_text\"><![CDATA[","]]></field>")
			 + getInventorsUrl("<field name=\"inventor_url\"><![CDATA[","]]></field>");
		}
		else {
			ret += getInventorsAddressAddress1("<inventor_address_address1><![CDATA[","]]></inventor_address_address1>")
				 + getInventorsAddressAddress2("<inventor_address_address2><![CDATA[","]]></inventor_address_address2>")
				 + getInventorsAddressAddress3("<inventor_address_address3><![CDATA[","]]></inventor_address_address3>")
				 + getInventorsAddressAddressFloor("<inventor_address_floor><![CDATA[","]]></inventor_address_floor>")
				 + getInventorsAddressBuilding("<inventor_address_building><![CDATA[","]]></inventor_address_building>")
				 + getInventorsAddressCity("<inventor_address_city><![CDATA[","]]></inventor_address_city>")
				 + getInventorsAddressCountry("<inventor_address_country><![CDATA[","]]></inventor_address_country>")
				 + getInventorsAddressCounty("<inventor_address_county><![CDATA[","]]></inventor_address_county>")
				 + getInventorsAddressMailcode("<inventor_address_mailcode><![CDATA[","]]></inventor_address_mailcode>")
				 + getInventorsAddressPobox("<inventor_address_pobox><![CDATA[","]]></inventor_address_pobox>")
				 + getInventorsAddressPostcode("<inventor_address_postcode><![CDATA[","]]></inventor_address_postcode>")
				 + getInventorsAddressRoom("<inventor_address_room><![CDATA[","]]></inventor_address_room>")
				 + getInventorsAddressState("<inventor_address_state><![CDATA[","]]></inventor_address_state>")
				 + getInventorsAddressStreet("<inventor_address_street><![CDATA[","]]></inventor_address_street>")
				 + getInventorsAddressText("<inventor_address_text><![CDATA[","]]></inventor_address_text>")
				 + getInventorsDepartment("<inventor_department><![CDATA[","]]></field>")
				 + getInventorsDtext("<inventor_dtext><![CDATA[","]]></inventor_department>")
				 + getInventorsEad("<inventor_ead><![CDATA[","]]></inventor_ead>")
				 + getInventorsEmail("<inventor_email><![CDATA[","]]></inventor_email>")
				 + getInventorsFax("<inventor_fax><![CDATA[","]]></inventor_fax>")
				 + getInventorsFirstName("<inventor_firstname><![CDATA[","]]></inventor_firstname>")
				 + getInventorsIid("<inventor_iid><![CDATA[","]]></inventor_iid>")
				 + getInventorsLastName("<inventor_lastname><![CDATA[","]]></inventor_lastname>")
				 + getInventorsMiddleName("<inventor_middlename><![CDATA[","]]></inventor_middlename>")
				 + getInventorsName("<inventor_name><![CDATA[","]]></inventor_name>")
				 + getInventorsOrgname("<inventor_orgname><![CDATA[","]]></inventor_orgname>")
				 + getInventorsPhone("<inventor_phone><![CDATA[","]]></inventor_phone>")
				 + getInventorsPrefix("<inventor_prefix><![CDATA[","]]></inventor_prefix>")
				 + getInventorsRegisteredNumber("<inventor_registerednumber><![CDATA[","]]></inventor_registerednumber>")
				 + getInventorsRole("<inventor_role><![CDATA[","]]></inventor_role>")
				 + getInventorsSuffix("<inventor_suffix><![CDATA[","]]></inventor_suffix>")
				 + getInventorsSynonym("<inventor_synonym><![CDATA[","]]></inventor_synonym>")
				 + getInventorsText("<inventor_text><![CDATA[","]]></inventor_text>")
				 + getInventorsUrl("<inventor_url><![CDATA[","]]></inventor_url>");
		}
		return ret;
	}

	
	/**
	 * @return the inventors Url
	 */
	public String getInventorsUrl(String prefix, String suffix) {
		// TODO Auto-generated method stub
		String ret = "";
		String tmp = "";
		for(AddrezzBook elem : this.inventors) {
			tmp = elem.getUrl();
			ret += prefix + tmp + suffix;
		}
		return ret;
	}
	
	/**
	 * @return the inventors Address Address1
	 */
	public String getInventorsAddressAddress1(String prefix, String suffix) {
		// TODO Auto-generated method stub
		String ret = "";
		String tmp = "";
		for(AddrezzBook elem : this.inventors) {
			Addrezz addrezz = elem.getAddrezz();
			if(addrezz!=null) {
				tmp = addrezz.getAddress2();
				}
			ret += prefix + tmp + suffix;
			}
		return ret;
	}
	
	/**
	 * @return the inventors Address Address2
	 */
	public String getInventorsAddressAddress2(String prefix, String suffix) {
		// TODO Auto-generated method stub
		String ret = "";
		String tmp = "";
		for(AddrezzBook elem : this.inventors) {
			Addrezz addrezz = elem.getAddrezz();
			if(addrezz!=null) {
				tmp = addrezz.getAddress2();
			}
			ret += prefix + tmp + suffix;
		}
		return ret;
	}
	
	/**
	 * @return the inventors Address Address3
	 */
	public String getInventorsAddressAddress3(String prefix, String suffix) {
		// TODO Auto-generated method stub
		String ret = "";
		String tmp = "";
		for(AddrezzBook elem : this.inventors) {
			Addrezz addrezz = elem.getAddrezz();
			if(addrezz!=null) {
				tmp = addrezz.getAddress3();					
				}
			ret += prefix + tmp + suffix;
			}
		return ret;
	}
	
	/**
	 * @return the inventors Address AddressFloor
	 */
	public String getInventorsAddressAddressFloor(String prefix, String suffix) {
		// TODO Auto-generated method stub
		String ret = "";
		String tmp = "";
		for(AddrezzBook elem : this.inventors) {
			Addrezz addrezz = elem.getAddrezz();
			if(addrezz!=null) {
				tmp = addrezz.getAddressFloor();					
				}
			ret += prefix + tmp + suffix;
			}
		return ret;
	}
	
	/**
	 * @return the inventors Address Building
	 */
	public String getInventorsAddressBuilding(String prefix, String suffix) {
		// TODO Auto-generated method stub
		String ret = "";
		String tmp = "";
		for(AddrezzBook elem : this.inventors) {
			Addrezz addrezz = elem.getAddrezz();
			if(addrezz!=null) {
				tmp = addrezz.getBuilding();					
				}
			ret += prefix + tmp + suffix;			
			}
		return ret;
	}
	
	/**
	 * @return the inventors Address City
	 */
	public String getInventorsAddressCity(String prefix, String suffix) {
		// TODO Auto-generated method stub
		String ret = "";
		String tmp = "";
		for(AddrezzBook elem : this.inventors) {
			Addrezz addrezz = elem.getAddrezz();
			if(addrezz!=null) {
				tmp = addrezz.getCity();
				}
			ret += prefix + tmp + suffix;
			}
		return ret;
	}
	
	/**
	 * @return the inventors Address Country
	 */
	public String getInventorsAddressCountry(String prefix, String suffix) {
		// TODO Auto-generated method stub
		String ret = "";
		String tmp = "";
		for(AddrezzBook elem : this.inventors) {
			Addrezz addrezz = elem.getAddrezz();
			if(addrezz!=null) {
				tmp = addrezz.getCountry();
				}
			ret += prefix + tmp + suffix;
			}
		return ret;
	}
	
	/**
	 * @return the inventors Address County
	 */
	public String getInventorsAddressCounty(String prefix, String suffix) {
		// TODO Auto-generated method stub
		String ret = "";
		String tmp = "";
		for(AddrezzBook elem : this.inventors) {
			Addrezz addrezz = elem.getAddrezz();
			if(addrezz!=null) {
				tmp = addrezz.getCounty();
				}
			ret += prefix + tmp + suffix;
			}
		return ret;
	}
	
	/**
	 * @return the inventors Address Mailcode
	 */
	public String getInventorsAddressMailcode(String prefix, String suffix) {
		// TODO Auto-generated method stub
		String ret = "";
		String tmp = "";
		for(AddrezzBook elem : this.inventors) {
			Addrezz addrezz = elem.getAddrezz();
			if(addrezz!=null) {
				tmp = addrezz.getMailcode();
				}
			ret += prefix + tmp + suffix;
			}
		return ret;
	}
	
	/**
	 * @return the inventors Address Pobox
	 */
	public String getInventorsAddressPobox(String prefix, String suffix) {
		// TODO Auto-generated method stub
		String ret = "";
		String tmp = "";
		for(AddrezzBook elem : this.inventors) {
			Addrezz addrezz = elem.getAddrezz();
			if(addrezz!=null) {
				tmp = addrezz.getPobox();
				}
			ret += prefix + tmp + suffix;
			}
		return ret;
	}
	
	/**
	 * @return the inventors Address Postcode
	 */
	public String getInventorsAddressPostcode(String prefix, String suffix) {
		// TODO Auto-generated method stub
		String ret = "";
		String tmp = "";
		for(AddrezzBook elem : this.inventors) {
			Addrezz addrezz = elem.getAddrezz();
			if(addrezz!=null) {
				tmp = addrezz.getPostcode();
				}
			ret += prefix + tmp + suffix;
			}
		return ret;
	}
	
	/**
	 * @return the inventors Address Room
	 */
	public String getInventorsAddressRoom(String prefix, String suffix) {
		// TODO Auto-generated method stub
		String ret = "";
		String tmp = "";
		for(AddrezzBook elem : this.inventors) {
			Addrezz addrezz = elem.getAddrezz();
			if(addrezz!=null) {
				tmp = addrezz.getRoom();
				}
			ret += prefix + tmp + suffix;
			}
		return ret;
	}
	
	/**
	 * @return the inventors Address State
	 */
	public String getInventorsAddressState(String prefix, String suffix) {
		// TODO Auto-generated method stub
		String ret = "";
		String tmp = "";
		for(AddrezzBook elem : this.inventors) {
			Addrezz addrezz = elem.getAddrezz();
			if(addrezz!=null) {
				tmp = addrezz.getState();					
				}
			ret += prefix + tmp + suffix;
			}
		return ret;
	}
	
	/**
	 * @return the inventors Address Street
	 */
	public String getInventorsAddressStreet(String prefix, String suffix) {
		// TODO Auto-generated method stub
		String ret = "";
		String tmp = "";
		for(AddrezzBook elem : this.inventors) {
			Addrezz addrezz = elem.getAddrezz();
			if(addrezz!=null) {
				tmp = addrezz.getStreet();
				}
			ret += prefix + tmp + suffix;
			}
		return ret;
	}
	
	private String getClaims(String prefix, String suffix) {
		// TODO Auto-generated method stub
		String claims = "";
		for(int i=0; i<this.claims.size(); i++) {
			if(i==0) {
				claims += prefix + this.claims.get(i).replaceFirst("\n+\\s*\n*","");
			}
			else
				claims += prefix + this.claims.get(i);
			
			if(i+1<this.claims.size()) // not last one
				 claims += suffix;
		}
		return claims;
	}
	private String getDesc(String prefix, String suffix) {
		// TODO Auto-generated method stub
		String desc = "";
		for(int i=0; i<this.descParagraphs.size(); i++) {
			if(i==0) {
				desc += prefix + this.descParagraphs.get(i).replaceFirst("\n+\\s*\n*","");
			}
			else
				desc += prefix + this.descParagraphs.get(i);
			
			if(i+1<this.descParagraphs.size()) // not last one
				desc += suffix;
		}
		return desc;
	}
	private String getAbstract(String prefix, String suffix) {
		// TODO Auto-generated method stub
		String abstr = "";
		for(int i=0; i<this.abstractParagraphs.size(); i++) {
			if(i==0) {
				abstr += prefix + this.abstractParagraphs.get(i).replaceFirst("\n+\\s*\n*","");
			}
			else
				abstr += prefix + this.abstractParagraphs.get(i);
			
			if(i+1<this.abstractParagraphs.size()) // not last one
				abstr += suffix;
		}
		return abstr;
	}
	
	
	/**
	 * @return the inventors Address Text
	 */
	public String getInventorsAddressText(String prefix, String suffix) {
		// TODO Auto-generated method stub
		String ret = "";
		String tmp = "";
		for(AddrezzBook elem : this.inventors) {
			Addrezz addrezz = elem.getAddrezz();
			if(addrezz!=null) {
				tmp = addrezz.getText();
				}
			ret += prefix + tmp + suffix;
			}
		return ret;
	}
	
}

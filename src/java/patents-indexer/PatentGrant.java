import java.util.ArrayList;
import java.util.List;

//import org.apache.solr.common.SolrInputDocument;

public class PatentGrant extends Patent {
	/**
	 * @return the e_type string
	 */
	public String getTypeString() {
		return "GRANT";
	}
	
	public PatentGrant() {
		// TODO Auto-generated constructor stub
		super();
		
		e_type = ENUM_TYPE.e_GRANT;
		
	}
	/*public String toXML(boolean solr_format) {
		String xml = "<add><doc>";
		if(solr_format==true) {
			xml += "<field name=\"id\"><![CDATA["+getId()+"]]></field>"
				 + "<field name=\"type\"><![CDATA["+getTypeString()+"]]></field>"
				 + "<field name=\"title\"><![CDATA["+getTitle()+"]]></field>"
				 
				 + getAssignees("<field name=\"assignee\"><![CDATA[","]]></field>")
				 
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
			
				 + "<field name=\"application_country\"><![CDATA["+getAppCountry()+"]]></field>"
				 + "<field name=\"application_doc_mumber\"><![CDATA["+getAppDocNumber()+"]]></field>"
				 + "<field name=\"application_number\"><![CDATA["+getAppNumber()+"]]></field>"
				 + "<field name=\"application_date\"><![CDATA["+getAppDate(solr_format)+"]]></field>";
			
		}
		else  {
			xml += "<id><![CDATA["+getId()+"]]></id>"
				 + "<type><![CDATA["+getTypeString()+"]]></type>"
				 + "<title><![CDATA["+getTitle()+"]]></title>"
				 
				 + getAssignees("<assignee><![CDATA[","]]></assignee>")
				 
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
			
				 + "<application_country><![CDATA["+getAppCountry()+"]]></application_country>"
				 + "<application_doc_mumber><![CDATA["+getAppDocNumber()+"]]></application_doc_mumber>"
				 + "<application_number><![CDATA["+getAppNumber()+"]]></application_number>"
				 + "<application_date><![CDATA["+getAppDate(solr_format)+"]]></application_date>";
		}
		xml += "</doc></add>";
		
		return xml;
	}*/
	

	/*
	public SolrInputDocument getSolrDocument() {
		// TODO Auto-generated method stub
		SolrInputDocument doc = new SolrInputDocument();
		doc.addField("id", getId());
		doc.addField("title", getTitle());
		doc.addField("abstract", getAbstract());
		doc.addField("description", getDesc());
		doc.addField("claims", getClaims());
		
		return doc;
	}
*/

}

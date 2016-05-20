import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.UnmarshallerHandler;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

public class PatentTransformer {
	   PatentTransformer() {
		   
	   }
	   
	   // transform input from USPTO xml format to index compliant xml format
	   public static Patent transform(String patentxml) {
		   patentxml = patentxml.trim();
		   //patentxml = patentxml.replace("<!DOCTYPE math PUBLIC \"-//W3C//DTD MathML 3.0//EN\" \"http://www.w3.org/Math/DTD/mathml3/mathml3.dtd\">", "<!DOCTYPE PATDOC [<!ENTITY nbsp   \"&#160;\" ><!ENTITY iexcl  \"&#161;\" ><!ENTITY cent   \"&#162;\" ><!ENTITY pound  \"&#163;\" ><!ENTITY curren \"&#164;\" ><!ENTITY yen    \"&#165;\" ><!ENTITY brvbar \"&#166;\" ><!ENTITY sect   \"&#167;\" ><!ENTITY uml    \"&#168;\" ><!ENTITY copy   \"&#169;\" ><!ENTITY ordf   \"&#170;\" ><!ENTITY laquo  \"&#171;\" ><!ENTITY not    \"&#172;\" ><!ENTITY shy    \"&#173;\" ><!ENTITY reg    \"&#174;\" ><!ENTITY macr   \"&#175;\" ><!ENTITY deg    \"&#176;\" ><!ENTITY plusmn \"&#177;\" ><!ENTITY sup2   \"&#178;\" ><!ENTITY sup3   \"&#179;\" ><!ENTITY acute  \"&#180;\" ><!ENTITY micro  \"&#181;\" ><!ENTITY para   \"&#182;\" ><!ENTITY middot \"&#183;\" ><!ENTITY cedil  \"&#184;\" ><!ENTITY sup1   \"&#185;\" ><!ENTITY ordm   \"&#186;\" ><!ENTITY raquo  \"&#187;\" ><!ENTITY frac14 \"&#188;\" ><!ENTITY frac12 \"&#189;\" ><!ENTITY frac34 \"&#190;\" ><!ENTITY iquest \"&#191;\" ><!ENTITY Agrave \"&#192;\" ><!ENTITY Aacute \"&#193;\" ><!ENTITY Acirc  \"&#194;\" ><!ENTITY Atilde \"&#195;\" ><!ENTITY Auml   \"&#196;\" ><!ENTITY Aring  \"&#197;\" ><!ENTITY AElig  \"&#198;\" ><!ENTITY Ccedil \"&#199;\" ><!ENTITY Egrave \"&#200;\" ><!ENTITY Eacute \"&#201;\" ><!ENTITY Ecirc  \"&#202;\" ><!ENTITY Euml   \"&#203;\" ><!ENTITY Igrave \"&#204;\" ><!ENTITY Iacute \"&#205;\" ><!ENTITY Icirc  \"&#206;\" ><!ENTITY Iuml   \"&#207;\" ><!ENTITY ETH    \"&#208;\" ><!ENTITY Ntilde \"&#209;\" ><!ENTITY Ograve \"&#210;\" ><!ENTITY Oacute \"&#211;\" ><!ENTITY Ocirc  \"&#212;\" ><!ENTITY Otilde \"&#213;\" ><!ENTITY Ouml   \"&#214;\" ><!ENTITY times  \"&#215;\" ><!ENTITY Oslash \"&#216;\" ><!ENTITY Ugrave \"&#217;\" ><!ENTITY Uacute \"&#218;\" ><!ENTITY Ucirc  \"&#219;\" ><!ENTITY Uuml   \"&#220;\" ><!ENTITY Yacute \"&#221;\" ><!ENTITY THORN  \"&#222;\" ><!ENTITY szlig  \"&#223;\" ><!ENTITY agrave \"&#224;\" ><!ENTITY aacute \"&#225;\" ><!ENTITY acirc  \"&#226;\" ><!ENTITY atilde \"&#227;\" ><!ENTITY auml   \"&#228;\" ><!ENTITY aring  \"&#229;\" ><!ENTITY aelig  \"&#230;\" ><!ENTITY ccedil \"&#231;\" ><!ENTITY egrave \"&#232;\" ><!ENTITY eacute \"&#233;\" ><!ENTITY ecirc  \"&#234;\" ><!ENTITY euml   \"&#235;\" ><!ENTITY igrave \"&#236;\" ><!ENTITY iacute \"&#237;\" ><!ENTITY icirc  \"&#238;\" ><!ENTITY iuml   \"&#239;\" ><!ENTITY eth    \"&#240;\" ><!ENTITY ntilde \"&#241;\" ><!ENTITY ograve \"&#242;\" ><!ENTITY oacute \"&#243;\" ><!ENTITY ocirc  \"&#244;\" ><!ENTITY otilde \"&#245;\" ><!ENTITY ouml   \"&#246;\" ><!ENTITY divide \"&#247;\" ><!ENTITY oslash \"&#248;\" ><!ENTITY ugrave \"&#249;\" ><!ENTITY uacute \"&#250;\" ><!ENTITY ucirc  \"&#251;\" ><!ENTITY uuml   \"&#252;\" ><!ENTITY yacute \"&#253;\" ><!ENTITY thorn  \"&#254;\" ><!ENTITY yuml   \"&#255;\" > <!ENTITY lt      \"&#38;#60;\" > <!ENTITY gt      \"&#62;\" > <!ENTITY amp     \"&#38;#38;\" > <!ENTITY apos    \"&#39;\" > <!ENTITY quot    \"&#34;\" > <!ENTITY OElig   \"&#338;\" > <!ENTITY oelig   \"&#339;\" > <!ENTITY Scaron  \"&#352;\" > <!ENTITY scaron  \"&#353;\" > <!ENTITY Yuml    \"&#376;\" > <!ENTITY circ    \"&#710;\" > <!ENTITY tilde   \"&#732;\" > <!ENTITY ensp    \"&#8194;\" > <!ENTITY emsp    \"&#8195;\" > <!ENTITY thinsp  \"&#8201;\" > <!ENTITY zwnj    \"&#8204;\" > <!ENTITY zwj     \"&#8205;\" > <!ENTITY lrm     \"&#8206;\" > <!ENTITY rlm     \"&#8207;\" > <!ENTITY ndash   \"&#8211;\" > <!ENTITY mdash   \"&#8212;\" > <!ENTITY lsquo   \"&#8216;\" > <!ENTITY rsquo   \"&#8217;\" > <!ENTITY sbquo   \"&#8218;\" > <!ENTITY ldquo   \"&#8220;\" > <!ENTITY rdquo   \"&#8221;\" > <!ENTITY bdquo   \"&#8222;\" > <!ENTITY dagger  \"&#8224;\" > <!ENTITY Dagger  \"&#8225;\" > <!ENTITY permil  \"&#8240;\" > <!ENTITY lsaquo  \"&#8249;\" > <!ENTITY rsaquo  \"&#8250;\" > <!ENTITY euro    \"&#8364;\" > <!ENTITY minus  \"&#43;\" > <!ENTITY plus  \"&#43;\" > <!ENTITY equals  \"&#61;\" > <!ENTITY af  \"\" > <!ENTITY it  \"\" ><!ENTITY fnof     \"&#402;\" > <!ENTITY Alpha    \"&#913;\" > <!ENTITY Beta     \"&#914;\" > <!ENTITY Gamma    \"&#915;\" > <!ENTITY Delta    \"&#916;\" > <!ENTITY Epsilon  \"&#917;\" > <!ENTITY Zeta     \"&#918;\" > <!ENTITY Eta      \"&#919;\" > <!ENTITY Theta    \"&#920;\" > <!ENTITY Iota     \"&#921;\" > <!ENTITY Kappa    \"&#922;\" > <!ENTITY Lambda   \"&#923;\" > <!ENTITY Mu       \"&#924;\" > <!ENTITY Nu       \"&#925;\" > <!ENTITY Xi       \"&#926;\" > <!ENTITY Omicron  \"&#927;\" > <!ENTITY Pi       \"&#928;\" > <!ENTITY Rho      \"&#929;\" > <!ENTITY Sigma    \"&#931;\" > <!ENTITY Tau      \"&#932;\" > <!ENTITY Upsilon  \"&#933;\" > <!ENTITY Phi      \"&#934;\" > <!ENTITY Chi      \"&#935;\" > <!ENTITY Psi      \"&#936;\" > <!ENTITY Omega    \"&#937;\" > <!ENTITY alpha    \"&#945;\" > <!ENTITY beta     \"&#946;\" > <!ENTITY gamma    \"&#947;\" > <!ENTITY delta    \"&#948;\" > <!ENTITY epsilon  \"&#949;\" > <!ENTITY zeta     \"&#950;\" > <!ENTITY eta      \"&#951;\" > <!ENTITY theta    \"&#952;\" > <!ENTITY iota     \"&#953;\" > <!ENTITY kappa    \"&#954;\" > <!ENTITY lambda   \"&#955;\" > <!ENTITY mu       \"&#956;\" > <!ENTITY nu       \"&#957;\" > <!ENTITY xi       \"&#958;\" > <!ENTITY omicron  \"&#959;\" > <!ENTITY pi       \"&#960;\" > <!ENTITY rho      \"&#961;\" > <!ENTITY sigmaf   \"&#962;\" > <!ENTITY sigma    \"&#963;\" > <!ENTITY tau      \"&#964;\" > <!ENTITY upsilon  \"&#965;\" > <!ENTITY phi      \"&#966;\" > <!ENTITY chi      \"&#967;\" > <!ENTITY psi      \"&#968;\" > <!ENTITY omega    \"&#969;\" > <!ENTITY thetasym \"&#977;\" > <!ENTITY upsih    \"&#978;\" > <!ENTITY piv      \"&#982;\" > <!ENTITY bull     \"&#8226;\" > <!ENTITY hellip   \"&#8230;\" > <!ENTITY prime    \"&#8242;\" > <!ENTITY Prime    \"&#8243;\" > <!ENTITY oline    \"&#8254;\" > <!ENTITY frasl    \"&#8260;\" > <!ENTITY weierp   \"&#8472;\" > <!ENTITY image    \"&#8465;\" > <!ENTITY real     \"&#8476;\" > <!ENTITY trade    \"&#8482;\" > <!ENTITY alefsym  \"&#8501;\" > <!ENTITY larr     \"&#8592;\" > <!ENTITY uarr     \"&#8593;\" > <!ENTITY rarr     \"&#8594;\" > <!ENTITY darr     \"&#8595;\" > <!ENTITY harr     \"&#8596;\" > <!ENTITY crarr    \"&#8629;\" > <!ENTITY lArr     \"&#8656;\" > <!ENTITY uArr     \"&#8657;\" > <!ENTITY rArr     \"&#8658;\" > <!ENTITY dArr     \"&#8659;\" > <!ENTITY hArr     \"&#8660;\" > <!ENTITY forall   \"&#8704;\" > <!ENTITY part     \"&#8706;\" > <!ENTITY exist    \"&#8707;\" > <!ENTITY empty    \"&#8709;\" > <!ENTITY nabla    \"&#8711;\" > <!ENTITY isin     \"&#8712;\" > <!ENTITY notin    \"&#8713;\" > <!ENTITY ni       \"&#8715;\" > <!ENTITY prod     \"&#8719;\" > <!ENTITY sum      \"&#8721;\" > <!ENTITY minus    \"&#8722;\" > <!ENTITY lowast   \"&#8727;\" > <!ENTITY radic    \"&#8730;\" > <!ENTITY prop     \"&#8733;\" > <!ENTITY infin    \"&#8734;\" > <!ENTITY ang      \"&#8736;\" > <!ENTITY and      \"&#8743;\" > <!ENTITY or       \"&#8744;\" > <!ENTITY cap      \"&#8745;\" > <!ENTITY cup      \"&#8746;\" > <!ENTITY int      \"&#8747;\" > <!ENTITY there4   \"&#8756;\" > <!ENTITY sim      \"&#8764;\" > <!ENTITY cong     \"&#8773;\" > <!ENTITY asymp    \"&#8776;\" > <!ENTITY ne       \"&#8800;\" > <!ENTITY equiv    \"&#8801;\" > <!ENTITY le       \"&#8804;\" > <!ENTITY ge       \"&#8805;\" > <!ENTITY sub      \"&#8834;\" > <!ENTITY sup      \"&#8835;\" > <!ENTITY nsub     \"&#8836;\" > <!ENTITY sube     \"&#8838;\" > <!ENTITY supe     \"&#8839;\" > <!ENTITY oplus    \"&#8853;\" > <!ENTITY otimes   \"&#8855;\" > <!ENTITY perp     \"&#8869;\" > <!ENTITY sdot     \"&#8901;\" > <!ENTITY lceil    \"&#8968;\" > <!ENTITY rceil    \"&#8969;\" > <!ENTITY lfloor   \"&#8970;\" > <!ENTITY rfloor   \"&#8971;\" > <!ENTITY lang     \"&#9001;\" > <!ENTITY rang     \"&#9002;\" > <!ENTITY loz      \"&#9674;\" > <!ENTITY spades   \"&#9824;\" > <!ENTITY clubs    \"&#9827;\" > <!ENTITY hearts   \"&#9829;\" > <!ENTITY diams    \"&#9830;\" > <!ENTITY lcub    \"\" > <!ENTITY rcub    \"\" > <!ENTITY excl    \"\" > <!ENTITY quest    \"\" > <!ENTITY num    \"\" >]>");
		   //patentxml = patentxml.replace("<!DOCTYPE math PUBLIC \"-//W3C//DTD MathML 3.0//EN\" \"http://www.w3.org/Math/DTD/mathml3/mathml3.dtd\">", "<!DOCTYPE math PUBLIC \"-//W3C//DTD MathML 2.0//EN\" \"dtds/mathml2.dtd\">");
		   patentxml = patentxml.replace("<!DOCTYPE math PUBLIC \"-//W3C//DTD MathML 3.0//EN\" \"http://www.w3.org/Math/DTD/mathml3/mathml3.dtd\">", "<!DOCTYPE math PUBLIC \"-//W3C//DTD MathML 2.0//EN\" \"http://10.18.203.79:7070/solr/dtds/mathml2.dtd\">");
		   Patent parsedPatent = null;
	      if(patentxml.contains("us-patent-grant") && patentxml.contains("dtd-version=\"v4.5 2014-04-03\"")==true) { // patent xml is grant in DTD v4.5
				parsedPatent = parseGrantv45(patentxml);		        
	        }
	        else if(patentxml.contains("us-patent-grant") && patentxml.contains("dtd-version=\"v4.4 2013-05-16\"")==true) { // patent xml is grant in DTD v4.4
	        	parsedPatent = parseGrantv44(patentxml);
	        }
	        else if(patentxml.contains("us-patent-grant") && patentxml.contains("dtd-version=\"v4.3 2012-12-04\"")==true) {  // patent xml is grant in DTD v4.3
	        	parsedPatent = parseGrantv43(patentxml);
	        }
	        else if(patentxml.contains("us-patent-grant") && patentxml.contains("dtd-version=\"v4.2 2006-08-23\"")==true) {  // patent xml is grant in DTD v4.2
	        	parsedPatent = parseGrantv42(patentxml);
	        }	
	        else if(patentxml.contains("us-patent-grant") && patentxml.contains("dtd-version=\"v4.1 2005-08-25\"")==true) {  // patent xml is grant in DTD v4.5
	        	parsedPatent = parseGrantv41(patentxml);
	        }
	        else if(patentxml.contains("us-patent-grant") && patentxml.contains("dtd-version=\"v40 2004-12-02\"")==true) {  // patent xml is grant in DTD v4.0
	        	parsedPatent = parseGrantv40_041202(patentxml);
	        }
	        else if(patentxml.contains("<PATDOC DTD=\"2.5\"")==true) {  // patent xml is grant in DTD v2.5
	        	parsedPatent = parseGrantv25(patentxml);		        				        
	        }
	        else if(patentxml.contains("<PATDOC DTD=\"2.4\"")==true) {  // patent xml is grant in DTD v2.5
	        	parsedPatent = parseGrantv24(patentxml);		        				        
	        }
	        else if(patentxml.contains("us-patent-application") && patentxml.contains("dtd-version=\"v4.4 2014-04-03\"")==true) {  // patent xml is application in DTD v4.4
	        	parsedPatent = parseApplicationv44(patentxml);		        
	        }
	        else if(patentxml.contains("us-patent-application") && patentxml.contains("dtd-version=\"v4.3 2012-12-04\"")==true) {  // patent xml is application in DTD v4.4
	        	parsedPatent = parseApplicationv43(patentxml);
	        }
	        else if(patentxml.contains("us-patent-application") && patentxml.contains("dtd-version=\"v4.2 2006-08-23\"")==true) {  // patent xml is application in DTD v4.4
	        	parsedPatent = parseApplicationv42(patentxml);
	        }
	        else if(patentxml.contains("us-patent-application") && patentxml.contains("dtd-version=\"v4.1 2005-08-25\"")==true) {  // patent xml is application in DTD v4.4
	        	parsedPatent = parseApplicationv41(patentxml);
	        }	    	   
	        else if(patentxml.contains("us-patent-application") && patentxml.contains("dtd-version=\"v4.0 2004-12-02\"")==true) {  // patent xml is application in DTD v4.4
	        	parsedPatent = parseApplicationv40_041202(patentxml);
	        }
	        else if(patentxml.contains("us-patent-application") && patentxml.contains("dtd-version=\"v4.0 2004-10-28\"")==true) {  // patent xml is application in DTD v4.4
	        	parsedPatent = parseApplicationv40_041028(patentxml);
	        }
	        else if(patentxml.contains("us-patent-application") && patentxml.contains("dtd-version=\"v4.0 2004-09-27\"")==true) {  // patent xml is application in DTD v4.4
	        	parsedPatent = parseApplicationv40_040927(patentxml);
	        }
	        else if(patentxml.contains("us-patent-application") && patentxml.contains("dtd-version=\"v4.0 2004-09-08\"")==true) {  // patent xml is application in DTD v4.4
	        	parsedPatent = parseApplicationv40_040908(patentxml);
	        }
	        else if(patentxml.contains("us-patent-application") && patentxml.contains("dtd-version=\"v4.0 2004-04-15\"")==true) {  // patent xml is application in DTD v4.4
	        	parsedPatent = parseApplicationv40_040415(patentxml);
	        }
	        else if(patentxml.indexOf("<!DOCTYPE patent-application-publication")==0 && patentxml.contains("pap-v16-2002-01-01.dtd")==true) {  // patent xml is application in DTD v1.6
	        	parsedPatent = parseApplicationv16(patentxml);
	        }
		   return parsedPatent==null? new Patent():parsedPatent;
	   }
	   
	private static Patent parseApplicationv16(String patentxml) {
		// TODO Auto-generated method stub
		patentxml = patentxml.replaceAll("<!DOCTYPE patent-application-publication.*?]>", "<!DOCTYPE math PUBLIC \"-//W3C//DTD MathML 2.0//EN\" \"http://10.18.203.79:7070/solr/dtds/mathml2.dtd\">");
		//patentxml = patentxml.replaceAll("<!DOCTYPE patent-application-publication.*?]>", "<!DOCTYPE math PUBLIC \"-//W3C//DTD MathML 2.0//EN\" \"dtds/mathml2.dtd\">");
		Patent patent = new PatentApplication();
       	try {
			SAXParserFactory spf = SAXParserFactory.newInstance();
			spf.setNamespaceAware(true);/*HEREHERE check if need in other functions*/
			SAXParser sp;
	
			sp = spf.newSAXParser();
	
			XMLReader xr = sp.getXMLReader();
       
	       // prase the xml according to its dtd version
	       JAXBContext jc = JAXBContext.newInstance("xml.us.patent.application.v16");
	       Marshaller marshaller = jc.createMarshaller();	        
	       Unmarshaller unmarshaller = jc.createUnmarshaller();
	       UnmarshallerHandler unmarshallerHandler = unmarshaller.getUnmarshallerHandler();
	       xr.setContentHandler((ContentHandler) unmarshallerHandler);
	 
	        InputSource xmlSource = new InputSource(new StringReader(patentxml));
	        xr.parse(xmlSource);
	        xml.us.patent.application.v16.PatentApplicationPublication app = (xml.us.patent.application.v16.PatentApplicationPublication) unmarshallerHandler.getResult();
	        
	        // extract patent data
	        xml.us.patent.application.v16.SubdocBibliographicInformation usBibliographicDataApp = app.getSubdocBibliographicInformation();
	        
    		// get publication information
	        patent.setPubDocNumber(usBibliographicDataApp.getDocumentId().getDocNumber().getvalue());        	
	        patent.setPubCountry("US");
    		patent.setPubKind(usBibliographicDataApp.getDocumentId().getKindCode().getvalue());
    		patent.setPubDate(usBibliographicDataApp.getDocumentId().getDocumentDate().getvalue());
    		
    		// get application informations
    		xml.us.patent.application.v16.DomesticFilingData filingdata = usBibliographicDataApp.getDomesticFilingData();
    		patent.setAppDocNumber(filingdata.getApplicationNumber().getDocNumber().getvalue());
    		patent.setAppCountry("US");
    		patent.setAppDate(filingdata.getFilingDate().getvalue());
    		
	        // get technical data
	        xml.us.patent.application.v16.TechnicalInformation technicalinfo = usBibliographicDataApp.getTechnicalInformation();	        
	        patent.setTitle(technicalinfo.getTitleOfInvention().getvalue());
	        
	        // get inventors
	        xml.us.patent.application.v16.Inventors inventors = usBibliographicDataApp.getInventors();
	        xml.us.patent.application.v16.FirstNamedInventor firstinventor = inventors.getFirstNamedInventor();
	        patent.addInventor(new AddrezzBook(firstinventor));
	        
	        List<xml.us.patent.application.v16.Inventor> otherinventors = inventors.getInventor();
	        for(xml.us.patent.application.v16.Inventor otherinventor : otherinventors) {
	        	patent.addInventor(new AddrezzBook(otherinventor));
	        }
	        
	        // get assignees
	        List<xml.us.patent.application.v16.Assignee> assignees = usBibliographicDataApp.getAssignee();	        
			if(assignees!=null) {
	    		for(xml.us.patent.application.v16.Assignee assignee : assignees) {
	    			patent.addAssignee(new AddrezzBook(assignee));
	    		}
			}
        		
    		// get US classification
			xml.us.patent.application.v16.ClassificationUs usClassification = technicalinfo.getClassificationUs();
			if(usClassification!=null) {
				patent.setMainClassification(usClassification.getClassificationUsPrimary().getUspc().getClazz() 
						+ " " + 
						usClassification.getClassificationUsPrimary().getUspc().getSubclass());
				
				List<xml.us.patent.application.v16.ClassificationUsSecondary> furtherClassifications = usClassification.getClassificationUsSecondary();
				if(furtherClassifications!=null){
					for(xml.us.patent.application.v16.ClassificationUsSecondary furtherClassification : furtherClassifications) {
						List<Object> furtherClassificationLst = furtherClassification.getUspcOrUspcFreeform();
						if(furtherClassificationLst!=null) {
							for(Object o : furtherClassificationLst) {
								if(o.getClass()==xml.us.patent.application.v16.Uspc.class) {
									patent.addfurtherClassification(((xml.us.patent.application.v16.Uspc)o).getClazz() 
											+ " " + 
											((xml.us.patent.application.v16.Uspc)o).getSubclass());
								}
								else if(o.getClass()==xml.us.patent.application.v16.UspcFreeform.class) {
									patent.addfurtherClassification(((xml.us.patent.application.v16.UspcFreeform)o).getvalue());
								}
							}
						}
    				}
				}
			}
			
    		// get IPC classification
			xml.us.patent.application.v16.ClassificationIpc ipcs = technicalinfo.getClassificationIpc();
			if(ipcs!=null) {
				xml.us.patent.application.v16.ClassificationIpcPrimary ipcmain = ipcs.getClassificationIpcPrimary();
				if(ipcmain!=null) {
					String ipcstr = ipcmain.getIpc().getvalue().replace(" ", "").replace("/", "");
    				if(ipcstr.length()>=7) {
	    				//patent.addIpcClassificationLevel();
						patent.addIpcSection(ipcstr.substring(0,1));
						patent.addIpcClass(ipcstr.substring(1,3));
						patent.addIpcSubclass(ipcstr.substring(3,4));
						String tmp = ipcstr.substring(4);
						if(tmp.length()>=3) {
							patent.addIpcSubgroup(tmp.substring(tmp.length()-2));
							patent.addIpcMainGroup(tmp.substring(0,tmp.length()-2));
							//patent.addIpcSymbolLevel();
							//patent.addIpcClassificationValue();
						}
						else {
							patent.addIpcSubgroup("");
							patent.addIpcMainGroup("");
						}
    				}
				}
				
				List<xml.us.patent.application.v16.ClassificationIpcSecondary> ipcothers = ipcs.getClassificationIpcSecondary();
				if(ipcothers!=null) {
					for(xml.us.patent.application.v16.ClassificationIpcSecondary ipcother : ipcothers) {
						String ipcstr = ipcother.getIpc().getvalue().replace(" ", "").replace("/", "");
	    				if(ipcstr.length()>=7) {
		    				//patent.addIpcClassificationLevel();
							patent.addIpcSection(ipcstr.substring(0,1));
							patent.addIpcClass(ipcstr.substring(1,3));
							patent.addIpcSubclass(ipcstr.substring(3,4));
							String tmp = ipcstr.substring(4);
							if(tmp.length()>=3) {
								patent.addIpcSubgroup(tmp.substring(tmp.length()-2));
								patent.addIpcMainGroup(tmp.substring(0,tmp.length()-2));
								//patent.addIpcSymbolLevel();
								//patent.addIpcClassificationValue();
							}
							else {
								patent.addIpcSubgroup("");
								patent.addIpcMainGroup("");
							}
	    				}
					}
				}
			}
			
			// get abstract
			xml.us.patent.application.v16.SubdocAbstract abstr = app.getSubdocAbstract();
			if(abstr!=null) {
				StringWriter sw = new StringWriter();
        		marshaller.marshal(abstr, sw);
        		patent.addAbstractParagraph(sw.toString().replaceAll("</.*?>|<[^>]*?/>", "").replaceAll("<.*?>", "\n"));
			}
			
			// get description
			xml.us.patent.application.v16.SubdocDescription descr = app.getSubdocDescription();
			if(descr!=null) {
				StringWriter sw = new StringWriter();
        		marshaller.marshal(descr, sw);
        		patent.addDescParagraph(sw.toString().replaceAll("</.*?>|<[^>]*?/>", "").replaceAll("<.*?>", "\n"));
				
			}
			
			// get claims
			xml.us.patent.application.v16.SubdocClaims claims = app.getSubdocClaims();
			if(claims!=null) {
				StringWriter sw = new StringWriter();
        		marshaller.marshal(claims, sw);
        		patent.addClaim(sw.toString().replaceAll("<claim id.*?>|</.*?>|<[^>]*?/>", "").replaceAll("<claim-ref.*?>|</claim-ref.*?>"," ").replaceAll("</claim-ref.*?>"," ").replaceAll("<.*?>", "\n"));
				
			}	        
	   } catch (ParserConfigurationException | SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JAXBException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return patent;
	}

	private static Patent parseGrantv45(String patentxml) {
		// TODO Auto-generated method stub
		Patent patent = new PatentGrant();
       	try {
			SAXParserFactory spf = SAXParserFactory.newInstance();
			SAXParser sp;
	
			sp = spf.newSAXParser();
	
			XMLReader xr = sp.getXMLReader();
       
	       // prase the xml according to its dtd version
	       JAXBContext jc = JAXBContext.newInstance("xml.us.patent.grant.v45");
	       Marshaller marshaller = jc.createMarshaller();	        
	       Unmarshaller unmarshaller = jc.createUnmarshaller();
	       UnmarshallerHandler unmarshallerHandler = unmarshaller.getUnmarshallerHandler();
	       xr.setContentHandler((ContentHandler) unmarshallerHandler);
	 
	        InputSource xmlSource = new InputSource(new StringReader(patentxml));
	        xr.parse(xmlSource);
	 
	        xml.us.patent.grant.v45.UsPatentGrant grant = (xml.us.patent.grant.v45.UsPatentGrant) unmarshallerHandler.getResult();
	        
	        // extract patent data
	        List<Object> grantLst = grant.getDocPageOrUsBibliographicDataGrantOrAbstractOrDrawingsOrDescriptionOrUsSequenceListDocOrUsMegatableDocOrTableExternalDocOrUsChemistryOrUsMathOrUsClaimStatementOrClaims();
	        for(int i=0; i<grantLst.size(); i++) {
	        	Object grantnode = grantLst.get(i);
	        	if(grantnode.getClass()==xml.us.patent.grant.v45.UsBibliographicDataGrant.class) {
	        		xml.us.patent.grant.v45.UsBibliographicDataGrant usBibliographicDataGrant = (xml.us.patent.grant.v45.UsBibliographicDataGrant) grantnode;
	        		
	        		// get publication reference
	        		xml.us.patent.grant.v45.PublicationReference publicationReference = usBibliographicDataGrant.getPublicationReference();
	        		
	        		xml.us.patent.grant.v45.DocumentId docId = publicationReference.getDocumentId();
	        		patent.setPubDocNumber(docId.getDocNumber());
	        		patent.setPubCountry(docId.getCountry().getvalue());
	        		patent.setPubKind(docId.getKind());
	        		patent.setPubDate(docId.getDate().getvalue());
	        		
	        		xml.us.patent.grant.v45.InventionTitle inventionTitle = usBibliographicDataGrant.getInventionTitle();
	        		patent.setTitle(inventionTitle.getvalue());
	        		
	        		// get application reference
	        		xml.us.patent.grant.v45.ApplicationReference applicationReference = usBibliographicDataGrant.getApplicationReference();
	        		docId = applicationReference.getDocumentId();
	        		patent.setAppDocNumber(docId.getDocNumber());
	        		patent.setAppCountry(docId.getCountry().getvalue());
	        		patent.setAppDate(docId.getDate().getvalue());
	        		
	        		// get inventors
	        		xml.us.patent.grant.v45.UsParties parties = usBibliographicDataGrant.getUsParties();
	        		if(parties!=null) {
	        			xml.us.patent.grant.v45.Inventors inventors = parties.getInventors();
		        		if(inventors!=null) {
		        			List<Object> inventorsLst = inventors.getInventorOrDeceasedInventor();
		        			for(Object inventornode : inventorsLst) {
	        					if(inventornode.getClass()==xml.us.patent.grant.v45.Inventor.class) {
	        						xml.us.patent.grant.v45.Inventor inventor = (xml.us.patent.grant.v45.Inventor) inventornode;
	        						List<xml.us.patent.grant.v45.Addressbook> inventorAddressbook = inventor.getAddressbook();
	        						for(xml.us.patent.grant.v45.Addressbook inventorAddressbookDet : inventorAddressbook)
	        						{
	        							patent.addInventor(new AddrezzBook(inventorAddressbookDet));
	        						}				        					
		        				}
			        		}
		        		}
	        		}
	        		
	        		// get assignees
	        		xml.us.patent.grant.v45.Assignees assignees = usBibliographicDataGrant.getAssignees();
	        		if(assignees!=null) {
		        		List<xml.us.patent.grant.v45.Assignee> assigneeLst = assignees.getAssignee();
		        		for(xml.us.patent.grant.v45.Assignee assigneeDet : assigneeLst) {
		        			patent.addAssignee(new AddrezzBook(assigneeDet));
		        			/*
		        			List<Object> assigneeLstLst = assignee.getNameOrPrefixOrLastNameOrOrgnameOrFirstNameOrMiddleNameOrSuffixOrIidOrRoleOrDepartmentOrSynonymOrRegisteredNumberOrAddressbook();
		        			for(Object assigneenode : assigneeLstLst) {
		        				if(assigneenode.getClass()==xml.us.patent.grant.v45.Orgname.class) {
		        					xml.us.patent.grant.v45.Orgname orgname = (xml.us.patent.grant.v45.Orgname)assigneenode;
		        					patent.addAssignee(orgname.getvalue());
		        				}
		        				else if(assigneenode.getClass()==xml.us.patent.grant.v45.Addressbook.class) {
		        					xml.us.patent.grant.v45.Addressbook addressbook = (xml.us.patent.grant.v45.Addressbook)assigneenode;
		        					List<Object> addressbookLst = addressbook.getNameOrPrefixOrLastNameOrOrgnameOrFirstNameOrMiddleNameOrSuffixOrIidOrRoleOrDepartmentOrSynonymOrRegisteredNumberOrAddressOrPhoneOrFaxOrEmailOrUrlOrEadOrDtextOrText();
		        					for(Object addressbooknode : addressbookLst) {
				        				if(addressbooknode.getClass()==xml.us.patent.grant.v45.Orgname.class) {
				        					xml.us.patent.grant.v45.Orgname orgname = (xml.us.patent.grant.v45.Orgname)addressbooknode;
				        					patent.addAssignee(orgname.getvalue());
				        				}
		        					}
		        				}
		        			}*/
		        		}
	        		}
	        		
	        		// get US classification
	        		xml.us.patent.grant.v45.ClassificationNational usClassification = usBibliographicDataGrant.getClassificationNational();
	        		if(usClassification!=null) {
		        		patent.setMainClassification(usClassification.getMainClassification());
		        		
		        		List<xml.us.patent.grant.v45.FurtherClassification> furtherClassifications = usClassification.getFurtherClassification();
		        		if(furtherClassifications!=null) {
		        			for(xml.us.patent.grant.v45.FurtherClassification furtherClassification : furtherClassifications) {
		        				patent.addfurtherClassification(furtherClassification.getvalue());
		        			}
		        		}
	        		}
	        		
	        		// get IPC classification
	        		xml.us.patent.grant.v45.ClassificationsIpcr ipcs = usBibliographicDataGrant.getClassificationsIpcr();
	        		if(ipcs!=null) {
	        			List<xml.us.patent.grant.v45.ClassificationIpcr> ipcLst = ipcs.getClassificationIpcr();
	        			if(ipcLst!=null) {
	        				for(xml.us.patent.grant.v45.ClassificationIpcr ipc : ipcLst) {
	        					xml.us.patent.grant.v45.IpcVersionIndicator versionIndicator = ipc.getIpcVersionIndicator();
	        					if(versionIndicator!=null) {
	        						patent.addIpcVersionDate(versionIndicator.getDate().getvalue());
	        					}
	        					patent.addIpcClassificationLevel(ipc.getClassificationLevel());
	        					patent.addIpcSection(ipc.getSection());
	        					patent.addIpcClass(ipc.getClazz().getvalue());
	        					patent.addIpcSubclass(ipc.getSubclass());
	        					patent.addIpcMainGroup(ipc.getMainGroup());
	        					patent.addIpcSubgroup(ipc.getSubgroup());
	        					patent.addIpcSymbolLevel(ipc.getSymbolPosition());
	        					patent.addIpcClassificationValue(ipc.getClassificationValue());
	        				}
	        			}
	        		}
	        		
	        		// get CPC main classification
	        		xml.us.patent.grant.v45.ClassificationsCpc cpcs = usBibliographicDataGrant.getClassificationsCpc();
	        		if(cpcs!=null) {
	        			// get main classification
	        			xml.us.patent.grant.v45.MainCpc maincpc = cpcs.getMainCpc();
	        			if(maincpc!=null) {
	        				xml.us.patent.grant.v45.ClassificationCpc cpc = maincpc.getClassificationCpc();
	        				if(cpc!=null) {
	        					xml.us.patent.grant.v45.CpcVersionIndicator versionIndicator = cpc.getCpcVersionIndicator();
	        					if(versionIndicator!=null) {
	        						patent.setCpcMainVersionDate(versionIndicator.getDate().getvalue());
	        					}
	        					patent.setCpcMainClassificationValue(cpc.getClassificationValue());
	        					patent.setCpcMainSection(cpc.getSection());
	        					patent.setCpcMainClass(cpc.getClazz().getvalue());
	        					patent.setCpcMainSubclass(cpc.getSubclass());
	        					patent.setCpcMainGroup(cpc.getMainGroup());
	        					patent.setCpcMainSubgroup(cpc.getSubgroup());
	        					patent.setCpcMainSymbolLevel(cpc.getSymbolPosition());
	        					patent.setCpcMainClassificationValue(cpc.getClassificationValue());
			        		}
	        			}
	        			
	        			// get further classification
	        			xml.us.patent.grant.v45.FurtherCpc furthercpcs = cpcs.getFurtherCpc();
	        			if(furthercpcs!=null) {
	        				List<xml.us.patent.grant.v45.ClassificationCpc> cpcLst = furthercpcs.getClassificationCpc();
	        				if(cpcLst!=null) {
	        					for(xml.us.patent.grant.v45.ClassificationCpc furthercpc : cpcLst) {
	        						xml.us.patent.grant.v45.CpcVersionIndicator versionIndicator = furthercpc.getCpcVersionIndicator();
		        					if(versionIndicator!=null) {
		        						patent.addCpcFurtherVersionDate(versionIndicator.getDate().getvalue());
		        					}
		        					patent.addCpcFurtherClassificationValue(furthercpc.getClassificationValue());
		        					patent.addCpcFurtherSection(furthercpc.getSection());
		        					patent.addCpcFurtherClass(furthercpc.getClazz().getvalue());
		        					patent.addCpcFurtherSubclass(furthercpc.getSubclass());
		        					patent.addCpcFurtherGroup(furthercpc.getMainGroup());
		        					patent.addCpcFurtherSubgroup(furthercpc.getSubgroup());
		        					patent.addCpcFurtherSymbolLevel(furthercpc.getSymbolPosition());
		        					patent.addCpcFurtherClassificationValue(furthercpc.getClassificationValue());
				        		}
	        				}
	        			}
	        		}
	        	}	        	
	        	else if(grantnode.getClass()==xml.us.patent.grant.v45.Abstract.class) { // get abstract
	        		xml.us.patent.grant.v45.Abstract abstr = (xml.us.patent.grant.v45.Abstract) grantnode;
	        		StringWriter sw = new StringWriter();
	        		marshaller.marshal(abstr, sw);
	        		patent.addAbstractParagraph(sw.toString().replaceAll("</.*?>|<[^>]*?/>", "").replaceAll("<.*?>", "\n"));
	        		/*
	        		List<Object> abstLst = abstr.getDocPageOrAbstProblemOrAbstSolutionOrP();
	        		for(int j=0; j<0; j++) {
	        			Object abstnode = abstLst.get(j);
	        			if(abstnode.getClass()==P.class) {
	        				P paragraph = (P) abstnode;
	        				patent.addAbstractParagraph(paragraph.getvalue());
	        			}
	        		}
	        		*/	        		
	        	}
	        	else if(grantnode.getClass()==xml.us.patent.grant.v45.Description.class) { // get description
	        		xml.us.patent.grant.v45.Description desc = (xml.us.patent.grant.v45.Description) grantnode;
	        		StringWriter sw = new StringWriter();
	        		marshaller.marshal(desc, sw);
	        		patent.addDescParagraph(sw.toString().replaceAll("</.*?>|<[^>]*?/>", "").replaceAll("<.*?>", "\n"));
	        		/*List<Object> descLst = desc.getDocPageOrInventionTitleOrTechnicalFieldOrBackgroundArtOrDisclosureOrDescriptionOfDrawingsOrBestModeOrModeForInventionOrIndustrialApplicabilityOrSequenceListTextOrHeadingOrP();
	        		for(int j=0; j<descLst.size(); j++) {
	        			Object descnode = descLst.get(j);
	        			if(descnode.getClass()==P.class) {
	        				P paragraph = (P) descnode;
	        				patent.descParagraphs.add(paragraph.getvalue());
	        			}
	        		}*/	        		
	        	}			        	
	        	else if(grantnode.getClass()==xml.us.patent.grant.v45.Claims.class) { // get claims
	        		xml.us.patent.grant.v45.Claims claims = (xml.us.patent.grant.v45.Claims) grantnode;
	        		StringWriter sw = new StringWriter();
	        		marshaller.marshal(claims, sw);
	        		patent.addClaim(sw.toString().replaceAll("<claim id.*?>|</.*?>|<[^>]*?/>", "").replaceAll("<claim-ref.*?>|</claim-ref.*?>"," ").replaceAll("</claim-ref.*?>"," ").replaceAll("<.*?>", "\n"));
	        		/*List<Object> claimsLst = claims.getDocPageOrClaim();
	        		for(int k=0; k<claimsLst.size(); k++) {
	        			Object claimsnode = claimsLst.get(k);
	        			if(claimsnode.getClass()==Claim.class) {
	        				Claim claim = (Claim) claimsnode;
	        				List<ClaimText> claimTxtLst = claim.getClaimText();
	        				for(int l=0; l<claimTxtLst.size(); l++) {
	        					List<Object> claimTxtLstLst = claimTxtLst.get(l).getContent();
	    	        			for(int m=0; m<claimTxtLstLst.size(); m++) {
	    	        				Object claimtxtnode = claimTxtLstLst.get(m);
	    	        				//System.out.print(claimtxtnode.getClass());
	    	        				if(claimtxtnode.getClass()==String.class) {
	    	        					System.out.println((String)claimtxtnode);	    	        					
	    	        				}
	    	        				else if(claimtxtnode.getClass()==ClaimText.class) {
	    	        					System.out.println(1);
	    	        				}
	    	        			}
	    	        			//patent.claims.add(claimTxtLst.get(l).getValue());
	    	        			//List<Object> claimTxtLstLst = claimTxtLst.get(l).getClaimTextOrClaimRefOrBOrIOrOOrUOrSupOrSubOrSmallcapsOrBrOrPreOrCrossrefOrFigrefOrImgOrChemistryOrMathsOrTables();
	    	        			//for(int m=0; m<claimTxtLstLst.size(); m++) {
	    	        				//Object claimtxtnode = claimTxtLstLst.get(m);
	    	        				//if(claimtxtnode.getClass()==ClaimTextValue.class) {
	    	        				//	patent.claims.add(((ClaimTextValue)claimtxtnode).getvalue());
	    	        				//}
	    	        			//}	    	        			
	    	        		}
	        			}
	        		}*/	        		
	        	}
	        }
	   } catch (ParserConfigurationException | SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JAXBException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        /*
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(grant, System.out);
        */
		return patent;
	}

	private static Patent parseGrantv44(String patentxml) {
		// TODO Auto-generated method stub
		Patent patent = new PatentGrant();
       	try {
			SAXParserFactory spf = SAXParserFactory.newInstance();
			SAXParser sp;
	
			sp = spf.newSAXParser();
	
			XMLReader xr = sp.getXMLReader();
       
	       // prase the xml according to its dtd version
	       JAXBContext jc = JAXBContext.newInstance("xml.us.patent.grant.v44");
	       Marshaller marshaller = jc.createMarshaller();	        
	       Unmarshaller unmarshaller = jc.createUnmarshaller();
	       UnmarshallerHandler unmarshallerHandler = unmarshaller.getUnmarshallerHandler();
	       xr.setContentHandler((ContentHandler) unmarshallerHandler);
	 
	        InputSource xmlSource = new InputSource(new StringReader(patentxml));
	        xr.parse(xmlSource);
	 
	        xml.us.patent.grant.v44.UsPatentGrant grant = (xml.us.patent.grant.v44.UsPatentGrant) unmarshallerHandler.getResult();
	        
	        // extract patent data
	        List<Object> grantLst = grant.getDocPageOrUsBibliographicDataGrantOrAbstractOrDrawingsOrDescriptionOrUsSequenceListDocOrUsMegatableDocOrTableExternalDocOrUsChemistryOrUsMathOrUsClaimStatementOrClaims();
	        for(int i=0; i<grantLst.size(); i++) {
	        	Object grantnode = grantLst.get(i);
	        	if(grantnode.getClass()==xml.us.patent.grant.v44.UsBibliographicDataGrant.class) {
	        		xml.us.patent.grant.v44.UsBibliographicDataGrant usBibliographicDataGrant = (xml.us.patent.grant.v44.UsBibliographicDataGrant) grantnode;
	        		
	        		// get publication reference
	        		xml.us.patent.grant.v44.PublicationReference publicationReference = usBibliographicDataGrant.getPublicationReference();
	        		
	        		xml.us.patent.grant.v44.DocumentId docId = publicationReference.getDocumentId();
	        		patent.setPubDocNumber(docId.getDocNumber());
	        		patent.setPubCountry(docId.getCountry().getvalue());
	        		patent.setPubKind(docId.getKind());
	        		patent.setPubDate(docId.getDate().getvalue());
	        		
	        		xml.us.patent.grant.v44.InventionTitle inventionTitle = usBibliographicDataGrant.getInventionTitle();
	        		patent.setTitle(inventionTitle.getvalue());
	        		
	        		// get application reference
	        		xml.us.patent.grant.v44.ApplicationReference applicationReference = usBibliographicDataGrant.getApplicationReference();
	        		docId = applicationReference.getDocumentId();
	        		patent.setAppDocNumber(docId.getDocNumber());
	        		patent.setAppCountry(docId.getCountry().getvalue());
	        		patent.setAppDate(docId.getDate().getvalue());
	        		
	        		// get inventors
	        		xml.us.patent.grant.v44.UsParties parties = usBibliographicDataGrant.getUsParties();
	        		if(parties!=null) {
	        			xml.us.patent.grant.v44.Inventors inventors = parties.getInventors();
		        		if(inventors!=null) {
		        			List<Object> inventorsLst = inventors.getInventorOrDeceasedInventor();
		        			for(Object inventornode : inventorsLst) {
	        					if(inventornode.getClass()==xml.us.patent.grant.v44.Inventor.class) {
	        						xml.us.patent.grant.v44.Inventor inventor = (xml.us.patent.grant.v44.Inventor) inventornode;
	        						List<xml.us.patent.grant.v44.Addressbook> inventorAddressbook = inventor.getAddressbook();
	        						for(xml.us.patent.grant.v44.Addressbook inventorAddressbookDet : inventorAddressbook)
	        						{
	        							patent.addInventor(new AddrezzBook(inventorAddressbookDet));
	        						}				        					
		        				}
			        		}
		        		}
	        		}
	        		
	        		// get assignees
	        		xml.us.patent.grant.v44.Assignees assignees = usBibliographicDataGrant.getAssignees();
	        		if(assignees!=null) {
		        		List<xml.us.patent.grant.v44.Assignee> assigneeLst = assignees.getAssignee();
		        		for(xml.us.patent.grant.v44.Assignee assigneeDet : assigneeLst) {
		        			patent.addAssignee(new AddrezzBook(assigneeDet));		        			
		        		}
	        		}
	        		
	        		// get US classification
	        		xml.us.patent.grant.v44.ClassificationNational usClassification = usBibliographicDataGrant.getClassificationNational();
	        		if(usClassification!=null) {
		        		patent.setMainClassification(usClassification.getMainClassification());
		        		
		        		List<xml.us.patent.grant.v44.FurtherClassification> furtherClassifications = usClassification.getFurtherClassification();
		        		if(furtherClassifications!=null) {
		        			for(xml.us.patent.grant.v44.FurtherClassification furtherClassification : furtherClassifications) {
		        				patent.addfurtherClassification(furtherClassification.getvalue());
		        			}
		        		}
	        		}
	        		
	        		// get IPC classification
	        		xml.us.patent.grant.v44.ClassificationsIpcr ipcs = usBibliographicDataGrant.getClassificationsIpcr();
	        		if(ipcs!=null) {
	        			List<xml.us.patent.grant.v44.ClassificationIpcr> ipcLst = ipcs.getClassificationIpcr();
	        			if(ipcLst!=null) {
	        				for(xml.us.patent.grant.v44.ClassificationIpcr ipc : ipcLst) {
	        					xml.us.patent.grant.v44.IpcVersionIndicator versionIndicator = ipc.getIpcVersionIndicator();
	        					if(versionIndicator!=null) {
	        						patent.addIpcVersionDate(versionIndicator.getDate().getvalue());
	        					}
	        					patent.addIpcClassificationLevel(ipc.getClassificationLevel());
	        					patent.addIpcSection(ipc.getSection());
	        					patent.addIpcClass(ipc.getClazz().getvalue());
	        					patent.addIpcSubclass(ipc.getSubclass());
	        					patent.addIpcMainGroup(ipc.getMainGroup());
	        					patent.addIpcSubgroup(ipc.getSubgroup());
	        					patent.addIpcSymbolLevel(ipc.getSymbolPosition());
	        					patent.addIpcClassificationValue(ipc.getClassificationValue());
	        				}
	        			}
	        		}
	        		
	        		// get CPC main classification
	        		xml.us.patent.grant.v44.ClassificationsCpc cpcs = usBibliographicDataGrant.getClassificationsCpc();
	        		if(cpcs!=null) {
	        			// get main classification
	        			xml.us.patent.grant.v44.MainCpc maincpc = cpcs.getMainCpc();
	        			if(maincpc!=null) {
	        				xml.us.patent.grant.v44.ClassificationCpc cpc = maincpc.getClassificationCpc();
	        				if(cpc!=null) {
	        					xml.us.patent.grant.v44.CpcVersionIndicator versionIndicator = cpc.getCpcVersionIndicator();
	        					if(versionIndicator!=null) {
	        						patent.setCpcMainVersionDate(versionIndicator.getDate().getvalue());
	        					}
	        					patent.setCpcMainClassificationValue(cpc.getClassificationValue());
	        					patent.setCpcMainSection(cpc.getSection());
	        					patent.setCpcMainClass(cpc.getClazz().getvalue());
	        					patent.setCpcMainSubclass(cpc.getSubclass());
	        					patent.setCpcMainGroup(cpc.getMainGroup());
	        					patent.setCpcMainSubgroup(cpc.getSubgroup());
	        					patent.setCpcMainSymbolLevel(cpc.getSymbolPosition());
	        					patent.setCpcMainClassificationValue(cpc.getClassificationValue());
			        		}
	        			}
	        			
	        			// get further classification
	        			xml.us.patent.grant.v44.FurtherCpc furthercpcs = cpcs.getFurtherCpc();
	        			if(furthercpcs!=null) {
	        				List<xml.us.patent.grant.v44.ClassificationCpc> cpcLst = furthercpcs.getClassificationCpc();
	        				if(cpcLst!=null) {
	        					for(xml.us.patent.grant.v44.ClassificationCpc furthercpc : cpcLst) {
	        						xml.us.patent.grant.v44.CpcVersionIndicator versionIndicator = furthercpc.getCpcVersionIndicator();
		        					if(versionIndicator!=null) {
		        						patent.addCpcFurtherVersionDate(versionIndicator.getDate().getvalue());
		        					}
		        					patent.addCpcFurtherClassificationValue(furthercpc.getClassificationValue());
		        					patent.addCpcFurtherSection(furthercpc.getSection());
		        					patent.addCpcFurtherClass(furthercpc.getClazz().getvalue());
		        					patent.addCpcFurtherSubclass(furthercpc.getSubclass());
		        					patent.addCpcFurtherGroup(furthercpc.getMainGroup());
		        					patent.addCpcFurtherSubgroup(furthercpc.getSubgroup());
		        					patent.addCpcFurtherSymbolLevel(furthercpc.getSymbolPosition());
		        					patent.addCpcFurtherClassificationValue(furthercpc.getClassificationValue());
				        		}
	        				}
	        			}
	        		}
	        	}	        	
	        	else if(grantnode.getClass()==xml.us.patent.grant.v44.Abstract.class) { // get abstract
	        		xml.us.patent.grant.v44.Abstract abstr = (xml.us.patent.grant.v44.Abstract) grantnode;
	        		StringWriter sw = new StringWriter();
	        		marshaller.marshal(abstr, sw);
	        		patent.addAbstractParagraph(sw.toString().replaceAll("</.*?>|<[^>]*?/>", "").replaceAll("<.*?>", "\n"));
	        	}
	        	else if(grantnode.getClass()==xml.us.patent.grant.v44.Description.class) { // get description
	        		xml.us.patent.grant.v44.Description desc = (xml.us.patent.grant.v44.Description) grantnode;
	        		StringWriter sw = new StringWriter();
	        		marshaller.marshal(desc, sw);
	        		patent.addDescParagraph(sw.toString().replaceAll("</.*?>|<[^>]*?/>", "").replaceAll("<.*?>", "\n"));       		
	        	}			        	
	        	else if(grantnode.getClass()==xml.us.patent.grant.v44.Claims.class) { // get claims
	        		xml.us.patent.grant.v44.Claims claims = (xml.us.patent.grant.v44.Claims) grantnode;
	        		StringWriter sw = new StringWriter();
	        		marshaller.marshal(claims, sw);
	        		patent.addClaim(sw.toString().replaceAll("<claim id.*?>|</.*?>|<[^>]*?/>", "").replaceAll("<claim-ref.*?>|</claim-ref.*?>"," ").replaceAll("</claim-ref.*?>"," ").replaceAll("<.*?>", "\n"));
	        	}
	        }
	   } catch (ParserConfigurationException | SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JAXBException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return patent;
	}

	private static Patent parseGrantv43(String patentxml) {
		// TODO Auto-generated method stub
		Patent patent = new PatentGrant();
       	try {
			SAXParserFactory spf = SAXParserFactory.newInstance();
			SAXParser sp;
	
			sp = spf.newSAXParser();
	
			XMLReader xr = sp.getXMLReader();
       
	       // prase the xml according to its dtd version
	       JAXBContext jc = JAXBContext.newInstance("xml.us.patent.grant.v43");
	       Marshaller marshaller = jc.createMarshaller();	        
	       Unmarshaller unmarshaller = jc.createUnmarshaller();
	       UnmarshallerHandler unmarshallerHandler = unmarshaller.getUnmarshallerHandler();
	       xr.setContentHandler((ContentHandler) unmarshallerHandler);
	 
	        InputSource xmlSource = new InputSource(new StringReader(patentxml));
	        xr.parse(xmlSource);
	 
	        xml.us.patent.grant.v43.UsPatentGrant grant = (xml.us.patent.grant.v43.UsPatentGrant) unmarshallerHandler.getResult();
	        
	        // extract patent data
	        List<Object> grantLst = grant.getDocPageOrUsBibliographicDataGrantOrAbstractOrDrawingsOrDescriptionOrUsSequenceListDocOrUsMegatableDocOrTableExternalDocOrUsChemistryOrUsMathOrUsClaimStatementOrClaims();
	        for(int i=0; i<grantLst.size(); i++) {
	        	Object grantnode = grantLst.get(i);
	        	if(grantnode.getClass()==xml.us.patent.grant.v43.UsBibliographicDataGrant.class) {
	        		xml.us.patent.grant.v43.UsBibliographicDataGrant usBibliographicDataGrant = (xml.us.patent.grant.v43.UsBibliographicDataGrant) grantnode;
	        		
	        		// get publication reference
	        		xml.us.patent.grant.v43.PublicationReference publicationReference = usBibliographicDataGrant.getPublicationReference();
	        		
	        		xml.us.patent.grant.v43.DocumentId docId = publicationReference.getDocumentId();
	        		patent.setPubDocNumber(docId.getDocNumber());
	        		patent.setPubCountry(docId.getCountry().getvalue());
	        		patent.setPubKind(docId.getKind());
	        		patent.setPubDate(docId.getDate().getvalue());
	        		
	        		xml.us.patent.grant.v43.InventionTitle inventionTitle = usBibliographicDataGrant.getInventionTitle();
	        		patent.setTitle(inventionTitle.getvalue());
	        		
	        		// get application reference
	        		xml.us.patent.grant.v43.ApplicationReference applicationReference = usBibliographicDataGrant.getApplicationReference();
	        		docId = applicationReference.getDocumentId();
	        		patent.setAppDocNumber(docId.getDocNumber());
	        		patent.setAppCountry(docId.getCountry().getvalue());
	        		patent.setAppDate(docId.getDate().getvalue());
	        		
	        		// get inventors
	        		xml.us.patent.grant.v43.UsParties parties = usBibliographicDataGrant.getUsParties();
	        		if(parties!=null) {
	        			xml.us.patent.grant.v43.Inventors inventors = parties.getInventors();
		        		if(inventors!=null) {
		        			List<Object> inventorsLst = inventors.getInventorOrDeceasedInventor();
		        			for(Object inventornode : inventorsLst) {
	        					if(inventornode.getClass()==xml.us.patent.grant.v43.Inventor.class) {
	        						xml.us.patent.grant.v43.Inventor inventor = (xml.us.patent.grant.v43.Inventor) inventornode;
	        						List<xml.us.patent.grant.v43.Addressbook> inventorAddressbook = inventor.getAddressbook();
	        						for(xml.us.patent.grant.v43.Addressbook inventorAddressbookDet : inventorAddressbook)
	        						{
	        							patent.addInventor(new AddrezzBook(inventorAddressbookDet));
	        						}				        					
		        				}
			        		}
		        		}
	        		}
	        		
	        		// get assignees
	        		xml.us.patent.grant.v43.Assignees assignees = usBibliographicDataGrant.getAssignees();
	        		if(assignees!=null) {
		        		List<xml.us.patent.grant.v43.Assignee> assigneeLst = assignees.getAssignee();
		        		for(xml.us.patent.grant.v43.Assignee assigneeDet : assigneeLst) {
		        			patent.addAssignee(new AddrezzBook(assigneeDet));
		        		}
	        		}
	        		
	        		// get US classification
	        		xml.us.patent.grant.v43.ClassificationNational usClassification = usBibliographicDataGrant.getClassificationNational();
	        		if(usClassification!=null) {
		        		patent.setMainClassification(usClassification.getMainClassification());
		        		
		        		List<xml.us.patent.grant.v43.FurtherClassification> furtherClassifications = usClassification.getFurtherClassification();
		        		if(furtherClassifications!=null) {
		        			for(xml.us.patent.grant.v43.FurtherClassification furtherClassification : furtherClassifications) {
		        				patent.addfurtherClassification(furtherClassification.getvalue());
		        			}
		        		}
	        		}
	        		
	        		// get IPC classification
	        		xml.us.patent.grant.v43.ClassificationsIpcr ipcs = usBibliographicDataGrant.getClassificationsIpcr();
	        		if(ipcs!=null) {
	        			List<xml.us.patent.grant.v43.ClassificationIpcr> ipcLst = ipcs.getClassificationIpcr();
	        			if(ipcLst!=null) {
	        				for(xml.us.patent.grant.v43.ClassificationIpcr ipc : ipcLst) {
	        					xml.us.patent.grant.v43.IpcVersionIndicator versionIndicator = ipc.getIpcVersionIndicator();
	        					if(versionIndicator!=null) {
	        						patent.addIpcVersionDate(versionIndicator.getDate().getvalue());
	        					}
	        					patent.addIpcClassificationLevel(ipc.getClassificationLevel());
	        					patent.addIpcSection(ipc.getSection());
	        					patent.addIpcClass(ipc.getClazz().getvalue());
	        					patent.addIpcSubclass(ipc.getSubclass());
	        					patent.addIpcMainGroup(ipc.getMainGroup());
	        					patent.addIpcSubgroup(ipc.getSubgroup());
	        					patent.addIpcSymbolLevel(ipc.getSymbolPosition());
	        					patent.addIpcClassificationValue(ipc.getClassificationValue());
	        				}
	        			}
	        		}
	        		
	        		// get CPC main classification
	        		xml.us.patent.grant.v43.ClassificationsCpc cpcs = usBibliographicDataGrant.getClassificationsCpc();
	        		if(cpcs!=null) {
	        			// get main classification
	        			xml.us.patent.grant.v43.MainCpc maincpc = cpcs.getMainCpc();
	        			if(maincpc!=null) {
	        				xml.us.patent.grant.v43.ClassificationCpc cpc = maincpc.getClassificationCpc();
	        				if(cpc!=null) {
	        					xml.us.patent.grant.v43.CpcVersionIndicator versionIndicator = cpc.getCpcVersionIndicator();
	        					if(versionIndicator!=null) {
	        						patent.setCpcMainVersionDate(versionIndicator.getDate().getvalue());
	        					}
	        					patent.setCpcMainClassificationValue(cpc.getClassificationValue());
	        					patent.setCpcMainSection(cpc.getSection());
	        					patent.setCpcMainClass(cpc.getClazz().getvalue());
	        					patent.setCpcMainSubclass(cpc.getSubclass());
	        					patent.setCpcMainGroup(cpc.getMainGroup());
	        					patent.setCpcMainSubgroup(cpc.getSubgroup());
	        					patent.setCpcMainSymbolLevel(cpc.getSymbolPosition());
	        					patent.setCpcMainClassificationValue(cpc.getClassificationValue());
			        		}
	        			}
	        			
	        			// get further classification
	        			xml.us.patent.grant.v43.FurtherCpc furthercpcs = cpcs.getFurtherCpc();
	        			if(furthercpcs!=null) {
	        				List<xml.us.patent.grant.v43.ClassificationCpc> cpcLst = furthercpcs.getClassificationCpc();
	        				if(cpcLst!=null) {
	        					for(xml.us.patent.grant.v43.ClassificationCpc furthercpc : cpcLst) {
	        						xml.us.patent.grant.v43.CpcVersionIndicator versionIndicator = furthercpc.getCpcVersionIndicator();
		        					if(versionIndicator!=null) {
		        						patent.addCpcFurtherVersionDate(versionIndicator.getDate().getvalue());
		        					}
		        					patent.addCpcFurtherClassificationValue(furthercpc.getClassificationValue());
		        					patent.addCpcFurtherSection(furthercpc.getSection());
		        					patent.addCpcFurtherClass(furthercpc.getClazz().getvalue());
		        					patent.addCpcFurtherSubclass(furthercpc.getSubclass());
		        					patent.addCpcFurtherGroup(furthercpc.getMainGroup());
		        					patent.addCpcFurtherSubgroup(furthercpc.getSubgroup());
		        					patent.addCpcFurtherSymbolLevel(furthercpc.getSymbolPosition());
		        					patent.addCpcFurtherClassificationValue(furthercpc.getClassificationValue());
				        		}
	        				}
	        			}
	        		}
	        	}	        	
	        	else if(grantnode.getClass()==xml.us.patent.grant.v43.Abstract.class) { // get abstract
	        		xml.us.patent.grant.v43.Abstract abstr = (xml.us.patent.grant.v43.Abstract) grantnode;
	        		StringWriter sw = new StringWriter();
	        		marshaller.marshal(abstr, sw);
	        		patent.addAbstractParagraph(sw.toString().replaceAll("</.*?>|<[^>]*?/>", "").replaceAll("<.*?>", "\n"));
	        	}
	        	else if(grantnode.getClass()==xml.us.patent.grant.v43.Description.class) { // get description
	        		xml.us.patent.grant.v43.Description desc = (xml.us.patent.grant.v43.Description) grantnode;
	        		StringWriter sw = new StringWriter();
	        		marshaller.marshal(desc, sw);
	        		patent.addDescParagraph(sw.toString().replaceAll("</.*?>|<[^>]*?/>", "").replaceAll("<.*?>", "\n"));       		
	        	}			        	
	        	else if(grantnode.getClass()==xml.us.patent.grant.v43.Claims.class) { // get claims
	        		xml.us.patent.grant.v43.Claims claims = (xml.us.patent.grant.v43.Claims) grantnode;
	        		StringWriter sw = new StringWriter();
	        		marshaller.marshal(claims, sw);
	        		patent.addClaim(sw.toString().replaceAll("<claim id.*?>|</.*?>|<[^>]*?/>", "").replaceAll("<claim-ref.*?>|</claim-ref.*?>"," ").replaceAll("</claim-ref.*?>"," ").replaceAll("<.*?>", "\n"));
	        	}
	        }
	   } catch (ParserConfigurationException | SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JAXBException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return patent;
	}
	
	private static Patent parseGrantv42(String patentxml) {
		// TODO Auto-generated method stub
		Patent patent = new PatentGrant();
       	try {
			SAXParserFactory spf = SAXParserFactory.newInstance();
			SAXParser sp;
	
			sp = spf.newSAXParser();
	
			XMLReader xr = sp.getXMLReader();
       
	       // prase the xml according to its dtd version
	       JAXBContext jc = JAXBContext.newInstance("xml.us.patent.grant.v42");
	       Marshaller marshaller = jc.createMarshaller();	        
	       Unmarshaller unmarshaller = jc.createUnmarshaller();
	       UnmarshallerHandler unmarshallerHandler = unmarshaller.getUnmarshallerHandler();
	       xr.setContentHandler((ContentHandler) unmarshallerHandler);
	 
	        InputSource xmlSource = new InputSource(new StringReader(patentxml));
	        xr.parse(xmlSource);
	 
	        xml.us.patent.grant.v42.UsPatentGrant grant = (xml.us.patent.grant.v42.UsPatentGrant) unmarshallerHandler.getResult();
	        
	        // extract patent data
	        List<Object> grantLst = grant.getDocPageOrUsBibliographicDataGrantOrAbstractOrDrawingsOrDescriptionOrUsSequenceListDocOrUsMegatableDocOrTableExternalDocOrUsChemistryOrUsMathOrUsClaimStatementOrClaims();
	        for(int i=0; i<grantLst.size(); i++) {
	        	Object grantnode = grantLst.get(i);
	        	if(grantnode.getClass()==xml.us.patent.grant.v42.UsBibliographicDataGrant.class) {
	        		xml.us.patent.grant.v42.UsBibliographicDataGrant usBibliographicDataGrant = (xml.us.patent.grant.v42.UsBibliographicDataGrant) grantnode;
	        		
	        		// get publication reference
	        		xml.us.patent.grant.v42.PublicationReference publicationReference = usBibliographicDataGrant.getPublicationReference();
	        		
	        		xml.us.patent.grant.v42.DocumentId docId = publicationReference.getDocumentId();
	        		patent.setPubDocNumber(docId.getDocNumber());
	        		patent.setPubCountry(docId.getCountry().getvalue());
	        		patent.setPubKind(docId.getKind());
	        		patent.setPubDate(docId.getDate().getvalue());
	        		
	        		xml.us.patent.grant.v42.InventionTitle inventionTitle = usBibliographicDataGrant.getInventionTitle();
	        		patent.setTitle(inventionTitle.getvalue());
	        		
	        		// get application reference
	        		xml.us.patent.grant.v42.ApplicationReference applicationReference = usBibliographicDataGrant.getApplicationReference();
	        		docId = applicationReference.getDocumentId();
	        		patent.setAppDocNumber(docId.getDocNumber());
	        		patent.setAppCountry(docId.getCountry().getvalue());
	        		patent.setAppDate(docId.getDate().getvalue());
	        		
	        		// get inventors
	        		xml.us.patent.grant.v42.Parties parties = usBibliographicDataGrant.getParties();
	        		if(parties!=null) {
	        			xml.us.patent.grant.v42.Inventors inventors = parties.getInventors();
		        		if(inventors!=null) {
		        			List<Object> inventorsLst = inventors.getInventorOrDeceasedInventor();
		        			for(Object inventornode : inventorsLst) {
	        					if(inventornode.getClass()==xml.us.patent.grant.v42.Inventor.class) {
	        						xml.us.patent.grant.v42.Inventor inventor = (xml.us.patent.grant.v42.Inventor) inventornode;
	        						List<xml.us.patent.grant.v42.Addressbook> inventorAddressbook = inventor.getAddressbook();
	        						for(xml.us.patent.grant.v42.Addressbook inventorAddressbookDet : inventorAddressbook)
	        						{
	        							patent.addInventor(new AddrezzBook(inventorAddressbookDet));
	        						}				        					
		        				}
			        		}
		        		}
	        		}
	        		
	        		// get assignees
	        		xml.us.patent.grant.v42.Assignees assignees = usBibliographicDataGrant.getAssignees();
	        		if(assignees!=null) {
		        		List<xml.us.patent.grant.v42.Assignee> assigneeLst = assignees.getAssignee();
		        		for(xml.us.patent.grant.v42.Assignee assigneeDet : assigneeLst) {
		        			patent.addAssignee(new AddrezzBook(assigneeDet));
		        		}
	        		}
	        		
	        		// get US classification
	        		xml.us.patent.grant.v42.ClassificationNational usClassification = usBibliographicDataGrant.getClassificationNational();
	        		if(usClassification!=null) {
		        		patent.setMainClassification(usClassification.getMainClassification());
		        		
		        		List<xml.us.patent.grant.v42.FurtherClassification> furtherClassifications = usClassification.getFurtherClassification();
		        		if(furtherClassifications!=null) {
		        			for(xml.us.patent.grant.v42.FurtherClassification furtherClassification : furtherClassifications) {
		        				patent.addfurtherClassification(furtherClassification.getvalue());
		        			}
		        		}
	        		}
	        		
	        		// get IPC classification
	        		xml.us.patent.grant.v42.ClassificationsIpcr ipcs = usBibliographicDataGrant.getClassificationsIpcr();
	        		if(ipcs!=null) {
	        			List<xml.us.patent.grant.v42.ClassificationIpcr> ipcLst = ipcs.getClassificationIpcr();
	        			if(ipcLst!=null) {
	        				for(xml.us.patent.grant.v42.ClassificationIpcr ipc : ipcLst) {
	        					xml.us.patent.grant.v42.IpcVersionIndicator versionIndicator = ipc.getIpcVersionIndicator();
	        					if(versionIndicator!=null) {
	        						patent.addIpcVersionDate(versionIndicator.getDate().getvalue());
	        					}
	        					patent.addIpcClassificationLevel(ipc.getClassificationLevel());
	        					patent.addIpcSection(ipc.getSection());
	        					patent.addIpcClass(ipc.getClazz().getvalue());
	        					patent.addIpcSubclass(ipc.getSubclass());
	        					patent.addIpcMainGroup(ipc.getMainGroup());
	        					patent.addIpcSubgroup(ipc.getSubgroup());
	        					patent.addIpcSymbolLevel(ipc.getSymbolPosition());
	        					patent.addIpcClassificationValue(ipc.getClassificationValue());
	        				}
	        			}	        		
	        		}
	        	}	        	
	        	else if(grantnode.getClass()==xml.us.patent.grant.v42.Abstract.class) { // get abstract
	        		xml.us.patent.grant.v42.Abstract abstr = (xml.us.patent.grant.v42.Abstract) grantnode;
	        		StringWriter sw = new StringWriter();
	        		marshaller.marshal(abstr, sw);
	        		patent.addAbstractParagraph(sw.toString().replaceAll("</.*?>|<[^>]*?/>", "").replaceAll("<.*?>", "\n"));
	        	}
	        	else if(grantnode.getClass()==xml.us.patent.grant.v42.Description.class) { // get description
	        		xml.us.patent.grant.v42.Description desc = (xml.us.patent.grant.v42.Description) grantnode;
	        		StringWriter sw = new StringWriter();
	        		marshaller.marshal(desc, sw);
	        		patent.addDescParagraph(sw.toString().replaceAll("</.*?>|<[^>]*?/>", "").replaceAll("<.*?>", "\n"));       		
	        	}			        	
	        	else if(grantnode.getClass()==xml.us.patent.grant.v42.Claims.class) { // get claims
	        		xml.us.patent.grant.v42.Claims claims = (xml.us.patent.grant.v42.Claims) grantnode;
	        		StringWriter sw = new StringWriter();
	        		marshaller.marshal(claims, sw);
	        		patent.addClaim(sw.toString().replaceAll("<claim id.*?>|</.*?>|<[^>]*?/>", "").replaceAll("<claim-ref.*?>|</claim-ref.*?>"," ").replaceAll("</claim-ref.*?>"," ").replaceAll("<.*?>", "\n"));
	        	}
	        }
	   } catch (ParserConfigurationException | SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JAXBException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return patent;
	}
	
	private static Patent parseGrantv41(String patentxml) {
		// TODO Auto-generated method stub
		Patent patent = new PatentGrant();
       	try {
			SAXParserFactory spf = SAXParserFactory.newInstance();
			SAXParser sp;
	
			sp = spf.newSAXParser();
	
			XMLReader xr = sp.getXMLReader();
       
	       // prase the xml according to its dtd version
	       JAXBContext jc = JAXBContext.newInstance("xml.us.patent.grant.v41");
	       Marshaller marshaller = jc.createMarshaller();	        
	       Unmarshaller unmarshaller = jc.createUnmarshaller();
	       UnmarshallerHandler unmarshallerHandler = unmarshaller.getUnmarshallerHandler();
	       xr.setContentHandler((ContentHandler) unmarshallerHandler);
	 
	        InputSource xmlSource = new InputSource(new StringReader(patentxml));
	        xr.parse(xmlSource);
	 
	        xml.us.patent.grant.v41.UsPatentGrant grant = (xml.us.patent.grant.v41.UsPatentGrant) unmarshallerHandler.getResult();
	        
	        // extract patent data
	        List<Object> grantLst = grant.getDocPageOrUsBibliographicDataGrantOrAbstractOrDrawingsOrDescriptionOrUsSequenceListDocOrUsMegatableDocOrTableExternalDocOrUsChemistryOrUsMathOrUsClaimStatementOrClaims();
	        for(int i=0; i<grantLst.size(); i++) {
	        	Object grantnode = grantLst.get(i);
	        	if(grantnode.getClass()==xml.us.patent.grant.v41.UsBibliographicDataGrant.class) {
	        		xml.us.patent.grant.v41.UsBibliographicDataGrant usBibliographicDataGrant = (xml.us.patent.grant.v41.UsBibliographicDataGrant) grantnode;
	        		
	        		// get publication reference
	        		xml.us.patent.grant.v41.PublicationReference publicationReference = usBibliographicDataGrant.getPublicationReference();
	        		
	        		xml.us.patent.grant.v41.DocumentId docId = publicationReference.getDocumentId();
	        		patent.setPubDocNumber(docId.getDocNumber());
	        		patent.setPubCountry(docId.getCountry().getvalue());
	        		patent.setPubKind(docId.getKind());
	        		patent.setPubDate(docId.getDate().getvalue());
	        		
	        		xml.us.patent.grant.v41.InventionTitle inventionTitle = usBibliographicDataGrant.getInventionTitle();
	        		patent.setTitle(inventionTitle.getvalue());
	        		
	        		// get application reference
	        		xml.us.patent.grant.v41.ApplicationReference applicationReference = usBibliographicDataGrant.getApplicationReference();
	        		docId = applicationReference.getDocumentId();
	        		patent.setAppDocNumber(docId.getDocNumber());
	        		patent.setAppCountry(docId.getCountry().getvalue());
	        		patent.setAppDate(docId.getDate().getvalue());
	        		
	        		// get inventors
	        		xml.us.patent.grant.v41.Parties parties = usBibliographicDataGrant.getParties();
	        		if(parties!=null) {
	        			xml.us.patent.grant.v41.Inventors inventors = parties.getInventors();
		        		if(inventors!=null) {
		        			List<Object> inventorsLst = inventors.getInventorOrDeceasedInventor();
		        			for(Object inventornode : inventorsLst) {
	        					if(inventornode.getClass()==xml.us.patent.grant.v41.Inventor.class) {
	        						xml.us.patent.grant.v41.Inventor inventor = (xml.us.patent.grant.v41.Inventor) inventornode;
	        						List<xml.us.patent.grant.v41.Addressbook> inventorAddressbook = inventor.getAddressbook();
	        						for(xml.us.patent.grant.v41.Addressbook inventorAddressbookDet : inventorAddressbook)
	        						{
	        							patent.addInventor(new AddrezzBook(inventorAddressbookDet));
	        						}				        					
		        				}
			        		}
		        		}
	        		}
	        		
	        		// get assignees
	        		xml.us.patent.grant.v41.Assignees assignees = usBibliographicDataGrant.getAssignees();
	        		if(assignees!=null) {
		        		List<xml.us.patent.grant.v41.Assignee> assigneeLst = assignees.getAssignee();
		        		for(xml.us.patent.grant.v41.Assignee assigneeDet : assigneeLst) {
		        			patent.addAssignee(new AddrezzBook(assigneeDet));
		        		}
	        		}
	        		
	        		// get US classification
	        		xml.us.patent.grant.v41.ClassificationNational usClassification = usBibliographicDataGrant.getClassificationNational();
	        		if(usClassification!=null) {
		        		patent.setMainClassification(usClassification.getMainClassification());
		        		
		        		List<xml.us.patent.grant.v41.FurtherClassification> furtherClassifications = usClassification.getFurtherClassification();
		        		if(furtherClassifications!=null) {
		        			for(xml.us.patent.grant.v41.FurtherClassification furtherClassification : furtherClassifications) {
		        				patent.addfurtherClassification(furtherClassification.getvalue());
		        			}
		        		}
	        		}
	        		
	        		// get IPC classification
	        		xml.us.patent.grant.v41.ClassificationsIpcr ipcs = usBibliographicDataGrant.getClassificationsIpcr();
	        		if(ipcs!=null) {
	        			List<xml.us.patent.grant.v41.ClassificationIpcr> ipcLst = ipcs.getClassificationIpcr();
	        			if(ipcLst!=null) {
	        				for(xml.us.patent.grant.v41.ClassificationIpcr ipc : ipcLst) {
	        					xml.us.patent.grant.v41.IpcVersionIndicator versionIndicator = ipc.getIpcVersionIndicator();
	        					if(versionIndicator!=null) {
	        						patent.addIpcVersionDate(versionIndicator.getDate().getvalue());
	        					}
	        					patent.addIpcClassificationLevel(ipc.getClassificationLevel());
	        					patent.addIpcSection(ipc.getSection());
	        					patent.addIpcClass(ipc.getClazz().getvalue());
	        					patent.addIpcSubclass(ipc.getSubclass());
	        					patent.addIpcMainGroup(ipc.getMainGroup());
	        					patent.addIpcSubgroup(ipc.getSubgroup());
	        					patent.addIpcSymbolLevel(ipc.getSymbolPosition());
	        					patent.addIpcClassificationValue(ipc.getClassificationValue());
	        				}
	        			}	        		
	        		}
	        	}	        	
	        	else if(grantnode.getClass()==xml.us.patent.grant.v41.Abstract.class) { // get abstract
	        		xml.us.patent.grant.v41.Abstract abstr = (xml.us.patent.grant.v41.Abstract) grantnode;
	        		StringWriter sw = new StringWriter();
	        		marshaller.marshal(abstr, sw);
	        		patent.addAbstractParagraph(sw.toString().replaceAll("</.*?>|<[^>]*?/>", "").replaceAll("<.*?>", "\n"));
	        	}
	        	else if(grantnode.getClass()==xml.us.patent.grant.v41.Description.class) { // get description
	        		xml.us.patent.grant.v41.Description desc = (xml.us.patent.grant.v41.Description) grantnode;
	        		StringWriter sw = new StringWriter();
	        		marshaller.marshal(desc, sw);
	        		patent.addDescParagraph(sw.toString().replaceAll("</.*?>|<[^>]*?/>", "").replaceAll("<.*?>", "\n"));       		
	        	}			        	
	        	else if(grantnode.getClass()==xml.us.patent.grant.v41.Claims.class) { // get claims
	        		xml.us.patent.grant.v41.Claims claims = (xml.us.patent.grant.v41.Claims) grantnode;
	        		StringWriter sw = new StringWriter();
	        		marshaller.marshal(claims, sw);
	        		patent.addClaim(sw.toString().replaceAll("<claim id.*?>|</.*?>|<[^>]*?/>", "").replaceAll("<claim-ref.*?>|</claim-ref.*?>"," ").replaceAll("</claim-ref.*?>"," ").replaceAll("<.*?>", "\n"));
	        	}
	        }
	   } catch (ParserConfigurationException | SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JAXBException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return patent;
	}
	
	private static Patent parseGrantv40_041202(String patentxml) {
		// TODO Auto-generated method stub
		Patent patent = new PatentGrant();
       	try {
			SAXParserFactory spf = SAXParserFactory.newInstance();
			SAXParser sp;
	
			sp = spf.newSAXParser();
	
			XMLReader xr = sp.getXMLReader();
       
	       // prase the xml according to its dtd version
	       JAXBContext jc = JAXBContext.newInstance("xml.us.patent.grant.v40_041202");
	       Marshaller marshaller = jc.createMarshaller();	        
	       Unmarshaller unmarshaller = jc.createUnmarshaller();
	       UnmarshallerHandler unmarshallerHandler = unmarshaller.getUnmarshallerHandler();
	       xr.setContentHandler((ContentHandler) unmarshallerHandler);
	 
	        InputSource xmlSource = new InputSource(new StringReader(patentxml));
	        xr.parse(xmlSource);
	 
	        xml.us.patent.grant.v40_041202.UsPatentGrant grant = (xml.us.patent.grant.v40_041202.UsPatentGrant) unmarshallerHandler.getResult();
	        
	        // extract patent data
	        List<Object> grantLst = grant.getDocPageOrUsBibliographicDataGrantOrAbstractOrDrawingsOrDescriptionOrSequenceListDocOrTableExternalDocOrUsChemistryOrUsMathOrClaims();
	        for(int i=0; i<grantLst.size(); i++) {
	        	Object grantnode = grantLst.get(i);
	        	if(grantnode.getClass()==xml.us.patent.grant.v40_041202.UsBibliographicDataGrant.class) {
	        		xml.us.patent.grant.v40_041202.UsBibliographicDataGrant usBibliographicDataGrant = (xml.us.patent.grant.v40_041202.UsBibliographicDataGrant) grantnode;
	        		
	        		// get publication reference
	        		xml.us.patent.grant.v40_041202.PublicationReference publicationReference = usBibliographicDataGrant.getPublicationReference();
	        		
	        		xml.us.patent.grant.v40_041202.DocumentId docId = publicationReference.getDocumentId();
	        		patent.setPubDocNumber(docId.getDocNumber());
	        		patent.setPubCountry(docId.getCountry().getvalue());
	        		patent.setPubKind(docId.getKind());
	        		patent.setPubDate(docId.getDate().getvalue());
	        		
	        		xml.us.patent.grant.v40_041202.InventionTitle inventionTitle = usBibliographicDataGrant.getInventionTitle();
	        		patent.setTitle(inventionTitle.getvalue());
	        		
	        		// get application reference
	        		xml.us.patent.grant.v40_041202.ApplicationReference applicationReference = usBibliographicDataGrant.getApplicationReference();
	        		docId = applicationReference.getDocumentId();
	        		patent.setAppDocNumber(docId.getDocNumber());
	        		patent.setAppCountry(docId.getCountry().getvalue());
	        		patent.setAppDate(docId.getDate().getvalue());
	        		
	        		// get inventors
	        		xml.us.patent.grant.v40_041202.Parties parties = usBibliographicDataGrant.getParties();
	        		if(parties!=null) {
	        			xml.us.patent.grant.v40_041202.Inventors inventors = parties.getInventors();
		        		if(inventors!=null) {
		        			List<Object> inventorsLst = inventors.getInventorOrDeceasedInventor();
		        			for(Object inventornode : inventorsLst) {
	        					if(inventornode.getClass()==xml.us.patent.grant.v40_041202.Inventor.class) {
	        						xml.us.patent.grant.v40_041202.Inventor inventor = (xml.us.patent.grant.v40_041202.Inventor) inventornode;
	        						List<xml.us.patent.grant.v40_041202.Addressbook> inventorAddressbook = inventor.getAddressbook();
	        						for(xml.us.patent.grant.v40_041202.Addressbook inventorAddressbookDet : inventorAddressbook)
	        						{
	        							patent.addInventor(new AddrezzBook(inventorAddressbookDet));
	        						}				        					
		        				}
			        		}
		        		}
	        		}
	        		
	        		// get assignees
	        		xml.us.patent.grant.v40_041202.Assignees assignees = usBibliographicDataGrant.getAssignees();
	        		if(assignees!=null) {
		        		List<xml.us.patent.grant.v40_041202.Assignee> assigneeLst = assignees.getAssignee();
		        		for(xml.us.patent.grant.v40_041202.Assignee assigneeDet : assigneeLst) {
		        			patent.addAssignee(new AddrezzBook(assigneeDet));
		        		}
	        		}
	        		
	        		// get US classification
	        		xml.us.patent.grant.v40_041202.ClassificationNational usClassification = usBibliographicDataGrant.getClassificationNational();
	        		if(usClassification!=null) {
		        		patent.setMainClassification(usClassification.getMainClassification());
		        		
		        		List<xml.us.patent.grant.v40_041202.FurtherClassification> furtherClassifications = usClassification.getFurtherClassification();
		        		if(furtherClassifications!=null) {
		        			for(xml.us.patent.grant.v40_041202.FurtherClassification furtherClassification : furtherClassifications) {
		        				patent.addfurtherClassification(furtherClassification.getvalue());
		        			}
		        		}
	        		}
	        		
	        		// get IPC classification
	        		xml.us.patent.grant.v40_041202.ClassificationsIpcr ipcs = usBibliographicDataGrant.getClassificationsIpcr();
	        		if(ipcs!=null) {
	        			List<xml.us.patent.grant.v40_041202.ClassificationIpcr> ipcLst = ipcs.getClassificationIpcr();
	        			if(ipcLst!=null) {
	        				for(xml.us.patent.grant.v40_041202.ClassificationIpcr ipc : ipcLst) {
	        					xml.us.patent.grant.v40_041202.IpcVersionIndicator versionIndicator = ipc.getIpcVersionIndicator();
	        					if(versionIndicator!=null) {
	        						patent.addIpcVersionDate(versionIndicator.getDate().getvalue());
	        					}
	        					patent.addIpcClassificationLevel(ipc.getClassificationLevel());
	        					patent.addIpcSection(ipc.getSection());
	        					patent.addIpcClass(ipc.getClazz().getvalue());
	        					patent.addIpcSubclass(ipc.getSubclass());
	        					patent.addIpcMainGroup(ipc.getMainGroup());
	        					patent.addIpcSubgroup(ipc.getSubgroup());
	        					patent.addIpcSymbolLevel(ipc.getSymbolPosition());
	        					patent.addIpcClassificationValue(ipc.getClassificationValue());
	        				}
	        			}	        		
	        		}
	        		else {
	        			xml.us.patent.grant.v40_041202.ClassificationIpc ipc = usBibliographicDataGrant.getClassificationIpc();
	        			if(ipc!=null) {
	        				String ipcstr = ipc.getMainClassification();
	        				if(ipcstr!=null) {
		        				String[] ipcstrTokens = ipcstr.split("/");
		        				if(ipcstrTokens.length==2) {
		    	    				//patent.addIpcClassificationLevel();
		    						patent.addIpcSection(ipcstrTokens[0].substring(0,1));
		    						patent.addIpcClass(ipcstrTokens[0].substring(1,3));
		    						patent.addIpcSubclass(ipcstrTokens[0].substring(3,4));
		    						patent.addIpcMainGroup(ipcstrTokens[0].substring(4));
		    						patent.addIpcSubgroup(ipcstrTokens[1]);
		    						//patent.addIpcSymbolLevel();
		    						//patent.addIpcClassificationValue();
		        				}
	        				}
	        				List<xml.us.patent.grant.v40_041202.FurtherClassification> ipcfurtherLst = ipc.getFurtherClassification();
	        				if(ipcfurtherLst!=null) {
	        					for(xml.us.patent.grant.v40_041202.FurtherClassification ipcfuther : ipcfurtherLst) {
	        						String ipcfutherstr = ipcfuther.getvalue();
	        						if(ipcfutherstr!=null) {
		        						String[] ipcfurtherTokens = ipcfutherstr.split("/");
		    	        				if(ipcfurtherTokens.length==2) {
		    	    	    				//patent.addIpcClassificationLevel();
		    	    						patent.addIpcSection(ipcfurtherTokens[0].substring(0,1));
		    	    						patent.addIpcClass(ipcfurtherTokens[0].substring(1,3));
		    	    						patent.addIpcSubclass(ipcfurtherTokens[0].substring(3,4));
		    	    						patent.addIpcMainGroup(ipcfurtherTokens[0].substring(4));
		    	    						patent.addIpcSubgroup(ipcfurtherTokens[1]);
		    	    						//patent.addIpcSymbolLevel();
		    	    						//patent.addIpcClassificationValue();
		    	        				}
	        						}
	        					}
	        				}
	        			}
	        		}
	        	}	        	
	        	else if(grantnode.getClass()==xml.us.patent.grant.v40_041202.Abstract.class) { // get abstract
	        		xml.us.patent.grant.v40_041202.Abstract abstr = (xml.us.patent.grant.v40_041202.Abstract) grantnode;
	        		StringWriter sw = new StringWriter();
	        		marshaller.marshal(abstr, sw);
	        		patent.addAbstractParagraph(sw.toString().replaceAll("</.*?>|<[^>]*?/>", "").replaceAll("<.*?>", "\n"));
	        	}
	        	else if(grantnode.getClass()==xml.us.patent.grant.v40_041202.Description.class) { // get description
	        		xml.us.patent.grant.v40_041202.Description desc = (xml.us.patent.grant.v40_041202.Description) grantnode;
	        		StringWriter sw = new StringWriter();
	        		marshaller.marshal(desc, sw);
	        		patent.addDescParagraph(sw.toString().replaceAll("</.*?>|<[^>]*?/>", "").replaceAll("<.*?>", "\n"));       		
	        	}			        	
	        	else if(grantnode.getClass()==xml.us.patent.grant.v40_041202.Claims.class) { // get claims
	        		xml.us.patent.grant.v40_041202.Claims claims = (xml.us.patent.grant.v40_041202.Claims) grantnode;
	        		StringWriter sw = new StringWriter();
	        		marshaller.marshal(claims, sw);
	        		patent.addClaim(sw.toString().replaceAll("<claim id.*?>|</.*?>|<[^>]*?/>", "").replaceAll("<claim-ref.*?>|</claim-ref.*?>"," ").replaceAll("</claim-ref.*?>"," ").replaceAll("<.*?>", "\n"));
	        	}
	        }
	   } catch (ParserConfigurationException | SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JAXBException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return patent;
	}
	
	private static Patent parseApplicationv44(String patentxml) {
		// TODO Auto-generated method stub
		Patent patent = new PatentApplication();
       	try {
			SAXParserFactory spf = SAXParserFactory.newInstance();
			SAXParser sp;
	
			sp = spf.newSAXParser();
	
			XMLReader xr = sp.getXMLReader();
       
	       // prase the xml according to its dtd version
	       JAXBContext jc = JAXBContext.newInstance("xml.us.patent.application.v44");
	       Marshaller marshaller = jc.createMarshaller();	        
	       Unmarshaller unmarshaller = jc.createUnmarshaller();
	       UnmarshallerHandler unmarshallerHandler = unmarshaller.getUnmarshallerHandler();
	       xr.setContentHandler((ContentHandler) unmarshallerHandler);
	 
	        InputSource xmlSource = new InputSource(new StringReader(patentxml));
	        xr.parse(xmlSource);
	 
	        xml.us.patent.application.v44.UsPatentApplication app = (xml.us.patent.application.v44.UsPatentApplication) unmarshallerHandler.getResult();
	        
	        // extract patent data
	        List<Object> grantLst = app.getDocPageOrUsBibliographicDataApplicationOrAbstractOrDrawingsOrDescriptionOrUsSequenceListDocOrUsMegatableDocOrTableExternalDocOrUsChemistryOrUsMathOrUsClaimStatementOrClaims();
	        for(int i=0; i<grantLst.size(); i++) {
	        	Object grantnode = grantLst.get(i);
	        	if(grantnode.getClass()==xml.us.patent.application.v44.UsBibliographicDataApplication.class) {
	        		xml.us.patent.application.v44.UsBibliographicDataApplication usBibliographicDataApp = (xml.us.patent.application.v44.UsBibliographicDataApplication) grantnode;
	        		
	        		// get publication reference
	        		xml.us.patent.application.v44.PublicationReference publicationReference = usBibliographicDataApp.getPublicationReference();
	        		
	        		xml.us.patent.application.v44.DocumentId docId = publicationReference.getDocumentId();
	        		patent.setPubDocNumber(docId.getDocNumber());
	        		patent.setPubCountry(docId.getCountry().getvalue());
	        		patent.setPubKind(docId.getKind());
	        		patent.setPubDate(docId.getDate().getvalue());
	        		
	        		xml.us.patent.application.v44.InventionTitle inventionTitle = usBibliographicDataApp.getInventionTitle();
	        		patent.setTitle(inventionTitle.getvalue());
	        		
	        		// get application reference
	        		xml.us.patent.application.v44.ApplicationReference applicationReference = usBibliographicDataApp.getApplicationReference();
	        		docId = applicationReference.getDocumentId();
	        		patent.setAppDocNumber(docId.getDocNumber());
	        		patent.setAppCountry(docId.getCountry().getvalue());
	        		patent.setAppDate(docId.getDate().getvalue());
	        		
	        		// get inventors
	        		xml.us.patent.application.v44.UsParties parties = usBibliographicDataApp.getUsParties();
	        		if(parties!=null) {
	        			xml.us.patent.application.v44.Inventors inventors = parties.getInventors();
		        		if(inventors!=null) {
		        			List<Object> inventorsLst = inventors.getInventorOrDeceasedInventor();
		        			for(Object inventornode : inventorsLst) {
	        					if(inventornode.getClass()==xml.us.patent.application.v44.Inventor.class) {
	        						xml.us.patent.application.v44.Inventor inventor = (xml.us.patent.application.v44.Inventor) inventornode;
	        						List<xml.us.patent.application.v44.Addressbook> inventorAddressbook = inventor.getAddressbook();
	        						for(xml.us.patent.application.v44.Addressbook inventorAddressbookDet : inventorAddressbook)
	        						{
	        							patent.addInventor(new AddrezzBook(inventorAddressbookDet));
	        						}				        					
		        				}
			        		}
		        		}
	        		}
	        		
	        		// get assignees
	        		xml.us.patent.application.v44.Assignees assignees = usBibliographicDataApp.getAssignees();
	        		if(assignees!=null) {
		        		List<xml.us.patent.application.v44.Assignee> assigneeLst = assignees.getAssignee();
		        		for(xml.us.patent.application.v44.Assignee assigneeDet : assigneeLst) {
		        			patent.addAssignee(new AddrezzBook(assigneeDet));
		        		}
	        		}
	        		
	        		// get US classification
	        		xml.us.patent.application.v44.ClassificationNational usClassification = usBibliographicDataApp.getClassificationNational();
	        		if(usClassification!=null) {
		        		patent.setMainClassification(usClassification.getMainClassification());
		        		
		        		List<xml.us.patent.application.v44.FurtherClassification> furtherClassifications = usClassification.getFurtherClassification();
		        		if(furtherClassifications!=null) {
		        			for(xml.us.patent.application.v44.FurtherClassification furtherClassification : furtherClassifications) {
		        				patent.addfurtherClassification(furtherClassification.getvalue());
		        			}
		        		}
	        		}
	        		
	        		// get IPC classification
	        		xml.us.patent.application.v44.ClassificationsIpcr ipcs = usBibliographicDataApp.getClassificationsIpcr();
	        		if(ipcs!=null) {
	        			List<xml.us.patent.application.v44.ClassificationIpcr> ipcLst = ipcs.getClassificationIpcr();
	        			if(ipcLst!=null) {
	        				for(xml.us.patent.application.v44.ClassificationIpcr ipc : ipcLst) {
	        					xml.us.patent.application.v44.IpcVersionIndicator versionIndicator = ipc.getIpcVersionIndicator();
	        					if(versionIndicator!=null) {
	        						patent.addIpcVersionDate(versionIndicator.getDate().getvalue());
	        					}
	        					patent.addIpcClassificationLevel(ipc.getClassificationLevel());
	        					patent.addIpcSection(ipc.getSection());
	        					patent.addIpcClass(ipc.getClazz().getvalue());
	        					patent.addIpcSubclass(ipc.getSubclass());
	        					patent.addIpcMainGroup(ipc.getMainGroup());
	        					patent.addIpcSubgroup(ipc.getSubgroup());
	        					patent.addIpcSymbolLevel(ipc.getSymbolPosition());
	        					patent.addIpcClassificationValue(ipc.getClassificationValue());
	        				}
	        			}
	        		}
	        		
	        		// get CPC main classification
	        		xml.us.patent.application.v44.ClassificationsCpc cpcs = usBibliographicDataApp.getClassificationsCpc();
	        		if(cpcs!=null) {
	        			// get main classification
	        			xml.us.patent.application.v44.MainCpc maincpc = cpcs.getMainCpc();
	        			if(maincpc!=null) {
	        				xml.us.patent.application.v44.ClassificationCpc cpc = maincpc.getClassificationCpc();
	        				if(cpc!=null) {
	        					xml.us.patent.application.v44.CpcVersionIndicator versionIndicator = cpc.getCpcVersionIndicator();
	        					if(versionIndicator!=null) {
	        						patent.setCpcMainVersionDate(versionIndicator.getDate().getvalue());
	        					}
	        					patent.setCpcMainClassificationValue(cpc.getClassificationValue());
	        					patent.setCpcMainSection(cpc.getSection());
	        					patent.setCpcMainClass(cpc.getClazz().getvalue());
	        					patent.setCpcMainSubclass(cpc.getSubclass());
	        					patent.setCpcMainGroup(cpc.getMainGroup());
	        					patent.setCpcMainSubgroup(cpc.getSubgroup());
	        					patent.setCpcMainSymbolLevel(cpc.getSymbolPosition());
	        					patent.setCpcMainClassificationValue(cpc.getClassificationValue());
			        		}
	        			}
	        			
	        			// get further classification
	        			xml.us.patent.application.v44.FurtherCpc furthercpcs = cpcs.getFurtherCpc();
	        			if(furthercpcs!=null) {
	        				List<xml.us.patent.application.v44.ClassificationCpc> cpcLst = furthercpcs.getClassificationCpc();
	        				if(cpcLst!=null) {
	        					for(xml.us.patent.application.v44.ClassificationCpc furthercpc : cpcLst) {
	        						xml.us.patent.application.v44.CpcVersionIndicator versionIndicator = furthercpc.getCpcVersionIndicator();
		        					if(versionIndicator!=null) {
		        						patent.addCpcFurtherVersionDate(versionIndicator.getDate().getvalue());
		        					}
		        					patent.addCpcFurtherClassificationValue(furthercpc.getClassificationValue());
		        					patent.addCpcFurtherSection(furthercpc.getSection());
		        					patent.addCpcFurtherClass(furthercpc.getClazz().getvalue());
		        					patent.addCpcFurtherSubclass(furthercpc.getSubclass());
		        					patent.addCpcFurtherGroup(furthercpc.getMainGroup());
		        					patent.addCpcFurtherSubgroup(furthercpc.getSubgroup());
		        					patent.addCpcFurtherSymbolLevel(furthercpc.getSymbolPosition());
		        					patent.addCpcFurtherClassificationValue(furthercpc.getClassificationValue());
				        		}
	        				}
	        			}
	        		}
	        	}	        	
	        	else if(grantnode.getClass()==xml.us.patent.application.v44.Abstract.class) { // get abstract
	        		xml.us.patent.application.v44.Abstract abstr = (xml.us.patent.application.v44.Abstract) grantnode;
	        		StringWriter sw = new StringWriter();
	        		marshaller.marshal(abstr, sw);
	        		patent.addAbstractParagraph(sw.toString().replaceAll("</.*?>|<[^>]*?/>", "").replaceAll("<.*?>", "\n"));
	        	}
	        	else if(grantnode.getClass()==xml.us.patent.application.v44.Description.class) { // get description
	        		xml.us.patent.application.v44.Description desc = (xml.us.patent.application.v44.Description) grantnode;
	        		StringWriter sw = new StringWriter();
	        		marshaller.marshal(desc, sw);
	        		patent.addDescParagraph(sw.toString().replaceAll("</.*?>|<[^>]*?/>", "").replaceAll("<.*?>", "\n"));
	        	}			        	
	        	else if(grantnode.getClass()==xml.us.patent.application.v44.Claims.class) { // get claims
	        		xml.us.patent.application.v44.Claims claims = (xml.us.patent.application.v44.Claims) grantnode;
	        		StringWriter sw = new StringWriter();
	        		marshaller.marshal(claims, sw);
	        		patent.addClaim(sw.toString().replaceAll("<claim id.*?>|</.*?>|<[^>]*?/>", "").replaceAll("<claim-ref.*?>|</claim-ref.*?>"," ").replaceAll("</claim-ref.*?>"," ").replaceAll("<.*?>", "\n"));
	        	}
	        }
	   } catch (ParserConfigurationException | SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JAXBException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return patent;
	}
	
	private static Patent parseApplicationv43(String patentxml) {
		// TODO Auto-generated method stub
		Patent patent = new PatentApplication();
       	try {
			SAXParserFactory spf = SAXParserFactory.newInstance();
			SAXParser sp;
	
			sp = spf.newSAXParser();
	
			XMLReader xr = sp.getXMLReader();
       
	       // prase the xml according to its dtd version
	       JAXBContext jc = JAXBContext.newInstance("xml.us.patent.application.v43");
	       Marshaller marshaller = jc.createMarshaller();	        
	       Unmarshaller unmarshaller = jc.createUnmarshaller();
	       UnmarshallerHandler unmarshallerHandler = unmarshaller.getUnmarshallerHandler();
	       xr.setContentHandler((ContentHandler) unmarshallerHandler);
	 
	        InputSource xmlSource = new InputSource(new StringReader(patentxml));
	        xr.parse(xmlSource);
	 
	        xml.us.patent.application.v43.UsPatentApplication app = (xml.us.patent.application.v43.UsPatentApplication) unmarshallerHandler.getResult();
	        
	        // extract patent data
	        List<Object> grantLst = app.getDocPageOrUsBibliographicDataApplicationOrAbstractOrDrawingsOrDescriptionOrUsSequenceListDocOrUsMegatableDocOrTableExternalDocOrUsChemistryOrUsMathOrUsClaimStatementOrClaims();
	        for(int i=0; i<grantLst.size(); i++) {
	        	Object grantnode = grantLst.get(i);
	        	if(grantnode.getClass()==xml.us.patent.application.v43.UsBibliographicDataApplication.class) {
	        		xml.us.patent.application.v43.UsBibliographicDataApplication usBibliographicDataApp = (xml.us.patent.application.v43.UsBibliographicDataApplication) grantnode;
	        		
	        		// get publication reference
	        		xml.us.patent.application.v43.PublicationReference publicationReference = usBibliographicDataApp.getPublicationReference();
	        		
	        		xml.us.patent.application.v43.DocumentId docId = publicationReference.getDocumentId();
	        		patent.setPubDocNumber(docId.getDocNumber());
	        		patent.setPubCountry(docId.getCountry().getvalue());
	        		patent.setPubKind(docId.getKind());
	        		patent.setPubDate(docId.getDate().getvalue());
	        		
	        		xml.us.patent.application.v43.InventionTitle inventionTitle = usBibliographicDataApp.getInventionTitle();
	        		patent.setTitle(inventionTitle.getvalue());
	        		
	        		// get application reference
	        		xml.us.patent.application.v43.ApplicationReference applicationReference = usBibliographicDataApp.getApplicationReference();
	        		docId = applicationReference.getDocumentId();
	        		patent.setAppDocNumber(docId.getDocNumber());
	        		patent.setAppCountry(docId.getCountry().getvalue());
	        		patent.setAppDate(docId.getDate().getvalue());
	        		
	        		// get inventors
	        		xml.us.patent.application.v43.UsParties parties = usBibliographicDataApp.getUsParties();
	        		if(parties!=null) {
	        			xml.us.patent.application.v43.Inventors inventors = parties.getInventors();
		        		if(inventors!=null) {
		        			List<Object> inventorsLst = inventors.getInventorOrDeceasedInventor();
		        			for(Object inventornode : inventorsLst) {
	        					if(inventornode.getClass()==xml.us.patent.application.v43.Inventor.class) {
	        						xml.us.patent.application.v43.Inventor inventor = (xml.us.patent.application.v43.Inventor) inventornode;
	        						List<xml.us.patent.application.v43.Addressbook> inventorAddressbook = inventor.getAddressbook();
	        						for(xml.us.patent.application.v43.Addressbook inventorAddressbookDet : inventorAddressbook)
	        						{
	        							patent.addInventor(new AddrezzBook(inventorAddressbookDet));
	        						}				        					
		        				}
			        		}
		        		}
	        		}
	        		
	        		// get assignees
	        		xml.us.patent.application.v43.Assignees assignees = usBibliographicDataApp.getAssignees();
	        		if(assignees!=null) {
		        		List<xml.us.patent.application.v43.Assignee> assigneeLst = assignees.getAssignee();
		        		for(xml.us.patent.application.v43.Assignee assigneeDet : assigneeLst) {
		        			patent.addAssignee(new AddrezzBook(assigneeDet));
		        		}
	        		}
	        		
	        		// get US classification
	        		xml.us.patent.application.v43.ClassificationNational usClassification = usBibliographicDataApp.getClassificationNational();
	        		if(usClassification!=null) {
		        		patent.setMainClassification(usClassification.getMainClassification());
		        		
		        		List<xml.us.patent.application.v43.FurtherClassification> furtherClassifications = usClassification.getFurtherClassification();
		        		if(furtherClassifications!=null) {
		        			for(xml.us.patent.application.v43.FurtherClassification furtherClassification : furtherClassifications) {
		        				patent.addfurtherClassification(furtherClassification.getvalue());
		        			}
		        		}
	        		}
	        		
	        		// get IPC classification
	        		xml.us.patent.application.v43.ClassificationsIpcr ipcs = usBibliographicDataApp.getClassificationsIpcr();
	        		if(ipcs!=null) {
	        			List<xml.us.patent.application.v43.ClassificationIpcr> ipcLst = ipcs.getClassificationIpcr();
	        			if(ipcLst!=null) {
	        				for(xml.us.patent.application.v43.ClassificationIpcr ipc : ipcLst) {
	        					xml.us.patent.application.v43.IpcVersionIndicator versionIndicator = ipc.getIpcVersionIndicator();
	        					if(versionIndicator!=null) {
	        						patent.addIpcVersionDate(versionIndicator.getDate().getvalue());
	        					}
	        					patent.addIpcClassificationLevel(ipc.getClassificationLevel());
	        					patent.addIpcSection(ipc.getSection());
	        					patent.addIpcClass(ipc.getClazz().getvalue());
	        					patent.addIpcSubclass(ipc.getSubclass());
	        					patent.addIpcMainGroup(ipc.getMainGroup());
	        					patent.addIpcSubgroup(ipc.getSubgroup());
	        					patent.addIpcSymbolLevel(ipc.getSymbolPosition());
	        					patent.addIpcClassificationValue(ipc.getClassificationValue());
	        				}
	        			}
	        		}
	        		
	        		// get CPC main classification
	        		xml.us.patent.application.v43.ClassificationsCpc cpcs = usBibliographicDataApp.getClassificationsCpc();
	        		if(cpcs!=null) {
	        			// get main classification
	        			xml.us.patent.application.v43.MainCpc maincpc = cpcs.getMainCpc();
	        			if(maincpc!=null) {
	        				xml.us.patent.application.v43.ClassificationCpc cpc = maincpc.getClassificationCpc();
	        				if(cpc!=null) {
	        					xml.us.patent.application.v43.CpcVersionIndicator versionIndicator = cpc.getCpcVersionIndicator();
	        					if(versionIndicator!=null) {
	        						patent.setCpcMainVersionDate(versionIndicator.getDate().getvalue());
	        					}
	        					patent.setCpcMainClassificationValue(cpc.getClassificationValue());
	        					patent.setCpcMainSection(cpc.getSection());
	        					patent.setCpcMainClass(cpc.getClazz().getvalue());
	        					patent.setCpcMainSubclass(cpc.getSubclass());
	        					patent.setCpcMainGroup(cpc.getMainGroup());
	        					patent.setCpcMainSubgroup(cpc.getSubgroup());
	        					patent.setCpcMainSymbolLevel(cpc.getSymbolPosition());
	        					patent.setCpcMainClassificationValue(cpc.getClassificationValue());
			        		}
	        			}
	        			
	        			// get further classification
	        			xml.us.patent.application.v43.FurtherCpc furthercpcs = cpcs.getFurtherCpc();
	        			if(furthercpcs!=null) {
	        				List<xml.us.patent.application.v43.ClassificationCpc> cpcLst = furthercpcs.getClassificationCpc();
	        				if(cpcLst!=null) {
	        					for(xml.us.patent.application.v43.ClassificationCpc furthercpc : cpcLst) {
	        						xml.us.patent.application.v43.CpcVersionIndicator versionIndicator = furthercpc.getCpcVersionIndicator();
		        					if(versionIndicator!=null) {
		        						patent.addCpcFurtherVersionDate(versionIndicator.getDate().getvalue());
		        					}
		        					patent.addCpcFurtherClassificationValue(furthercpc.getClassificationValue());
		        					patent.addCpcFurtherSection(furthercpc.getSection());
		        					patent.addCpcFurtherClass(furthercpc.getClazz().getvalue());
		        					patent.addCpcFurtherSubclass(furthercpc.getSubclass());
		        					patent.addCpcFurtherGroup(furthercpc.getMainGroup());
		        					patent.addCpcFurtherSubgroup(furthercpc.getSubgroup());
		        					patent.addCpcFurtherSymbolLevel(furthercpc.getSymbolPosition());
		        					patent.addCpcFurtherClassificationValue(furthercpc.getClassificationValue());
				        		}
	        				}
	        			}
	        		}
	        	}	        	
	        	else if(grantnode.getClass()==xml.us.patent.application.v43.Abstract.class) { // get abstract
	        		xml.us.patent.application.v43.Abstract abstr = (xml.us.patent.application.v43.Abstract) grantnode;
	        		StringWriter sw = new StringWriter();
	        		marshaller.marshal(abstr, sw);
	        		patent.addAbstractParagraph(sw.toString().replaceAll("</.*?>|<[^>]*?/>", "").replaceAll("<.*?>", "\n"));
	        	}
	        	else if(grantnode.getClass()==xml.us.patent.application.v43.Description.class) { // get description
	        		xml.us.patent.application.v43.Description desc = (xml.us.patent.application.v43.Description) grantnode;
	        		StringWriter sw = new StringWriter();
	        		marshaller.marshal(desc, sw);
	        		patent.addDescParagraph(sw.toString().replaceAll("</.*?>|<[^>]*?/>", "").replaceAll("<.*?>", "\n"));
	        	}			        	
	        	else if(grantnode.getClass()==xml.us.patent.application.v43.Claims.class) { // get claims
	        		xml.us.patent.application.v43.Claims claims = (xml.us.patent.application.v43.Claims) grantnode;
	        		StringWriter sw = new StringWriter();
	        		marshaller.marshal(claims, sw);
	        		patent.addClaim(sw.toString().replaceAll("<claim id.*?>|</.*?>|<[^>]*?/>", "").replaceAll("<claim-ref.*?>|</claim-ref.*?>"," ").replaceAll("</claim-ref.*?>"," ").replaceAll("<.*?>", "\n"));
	        	}
	        }
	   } catch (ParserConfigurationException | SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JAXBException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return patent;
	}
	
	private static Patent parseApplicationv42(String patentxml) {
		// TODO Auto-generated method stub
		Patent patent = new PatentApplication();
       	try {
			SAXParserFactory spf = SAXParserFactory.newInstance();
			SAXParser sp;
	
			sp = spf.newSAXParser();
	
			XMLReader xr = sp.getXMLReader();
       
	       // prase the xml according to its dtd version
	       JAXBContext jc = JAXBContext.newInstance("xml.us.patent.application.v42");
	       Marshaller marshaller = jc.createMarshaller();	        
	       Unmarshaller unmarshaller = jc.createUnmarshaller();
	       UnmarshallerHandler unmarshallerHandler = unmarshaller.getUnmarshallerHandler();
	       xr.setContentHandler((ContentHandler) unmarshallerHandler);
	 
	        InputSource xmlSource = new InputSource(new StringReader(patentxml));
	        xr.parse(xmlSource);
	 
	        xml.us.patent.application.v42.UsPatentApplication app = (xml.us.patent.application.v42.UsPatentApplication) unmarshallerHandler.getResult();
	        
	        // extract patent data
	        List<Object> grantLst = app.getDocPageOrUsBibliographicDataApplicationOrAbstractOrDrawingsOrDescriptionOrUsSequenceListDocOrUsMegatableDocOrTableExternalDocOrUsChemistryOrUsMathOrUsClaimStatementOrClaims();
	        for(int i=0; i<grantLst.size(); i++) {
	        	Object grantnode = grantLst.get(i);
	        	if(grantnode.getClass()==xml.us.patent.application.v42.UsBibliographicDataApplication.class) {
	        		xml.us.patent.application.v42.UsBibliographicDataApplication usBibliographicDataApp = (xml.us.patent.application.v42.UsBibliographicDataApplication) grantnode;
	        		
	        		// get publication reference
	        		xml.us.patent.application.v42.PublicationReference publicationReference = usBibliographicDataApp.getPublicationReference();
	        		
	        		xml.us.patent.application.v42.DocumentId docId = publicationReference.getDocumentId();
	        		patent.setPubDocNumber(docId.getDocNumber());
	        		patent.setPubCountry(docId.getCountry().getvalue());
	        		patent.setPubKind(docId.getKind());
	        		patent.setPubDate(docId.getDate().getvalue());
	        		
	        		xml.us.patent.application.v42.InventionTitle inventionTitle = usBibliographicDataApp.getInventionTitle();
	        		patent.setTitle(inventionTitle.getvalue());
	        		
	        		// get application reference
	        		xml.us.patent.application.v42.ApplicationReference applicationReference = usBibliographicDataApp.getApplicationReference();
	        		docId = applicationReference.getDocumentId();
	        		patent.setAppDocNumber(docId.getDocNumber());
	        		patent.setAppCountry(docId.getCountry().getvalue());
	        		patent.setAppDate(docId.getDate().getvalue());
	        		
	        		// get inventors
	        		xml.us.patent.application.v42.Parties parties = usBibliographicDataApp.getParties();
	        		if(parties!=null) {
	        			xml.us.patent.application.v42.Inventors inventors = parties.getInventors();
		        		if(inventors!=null) {
		        			List<Object> inventorsLst = inventors.getInventorOrDeceasedInventor();
		        			for(Object inventornode : inventorsLst) {
	        					if(inventornode.getClass()==xml.us.patent.application.v42.Inventor.class) {
	        						xml.us.patent.application.v42.Inventor inventor = (xml.us.patent.application.v42.Inventor) inventornode;
	        						List<xml.us.patent.application.v42.Addressbook> inventorAddressbook = inventor.getAddressbook();
	        						for(xml.us.patent.application.v42.Addressbook inventorAddressbookDet : inventorAddressbook)
	        						{
	        							patent.addInventor(new AddrezzBook(inventorAddressbookDet));
	        						}				        					
		        				}
			        		}
		        		}
	        		}
	        		
	        		// get assignees
	        		xml.us.patent.application.v42.Assignees assignees = usBibliographicDataApp.getAssignees();
	        		if(assignees!=null) {
		        		List<xml.us.patent.application.v42.Assignee> assigneeLst = assignees.getAssignee();
		        		for(xml.us.patent.application.v42.Assignee assigneeDet : assigneeLst) {
		        			patent.addAssignee(new AddrezzBook(assigneeDet));
		        		}
	        		}
	        		
	        		// get US classification
	        		xml.us.patent.application.v42.ClassificationNational usClassification = usBibliographicDataApp.getClassificationNational();
	        		if(usClassification!=null) {
		        		patent.setMainClassification(usClassification.getMainClassification());
		        		
		        		List<xml.us.patent.application.v42.FurtherClassification> furtherClassifications = usClassification.getFurtherClassification();
		        		if(furtherClassifications!=null) {
		        			for(xml.us.patent.application.v42.FurtherClassification furtherClassification : furtherClassifications) {
		        				patent.addfurtherClassification(furtherClassification.getvalue());
		        			}
		        		}
	        		}
	        		
	        		// get IPC classification
	        		xml.us.patent.application.v42.ClassificationsIpcr ipcs = usBibliographicDataApp.getClassificationsIpcr();
	        		if(ipcs!=null) {
	        			List<xml.us.patent.application.v42.ClassificationIpcr> ipcLst = ipcs.getClassificationIpcr();
	        			if(ipcLst!=null) {
	        				for(xml.us.patent.application.v42.ClassificationIpcr ipc : ipcLst) {
	        					xml.us.patent.application.v42.IpcVersionIndicator versionIndicator = ipc.getIpcVersionIndicator();
	        					if(versionIndicator!=null) {
	        						patent.addIpcVersionDate(versionIndicator.getDate().getvalue());
	        					}
	        					patent.addIpcClassificationLevel(ipc.getClassificationLevel());
	        					patent.addIpcSection(ipc.getSection());
	        					patent.addIpcClass(ipc.getClazz().getvalue());
	        					patent.addIpcSubclass(ipc.getSubclass());
	        					patent.addIpcMainGroup(ipc.getMainGroup());
	        					patent.addIpcSubgroup(ipc.getSubgroup());
	        					patent.addIpcSymbolLevel(ipc.getSymbolPosition());
	        					patent.addIpcClassificationValue(ipc.getClassificationValue());
	        				}
	        			}
	        		}
	        	}	        	
	        	else if(grantnode.getClass()==xml.us.patent.application.v42.Abstract.class) { // get abstract
	        		xml.us.patent.application.v42.Abstract abstr = (xml.us.patent.application.v42.Abstract) grantnode;
	        		StringWriter sw = new StringWriter();
	        		marshaller.marshal(abstr, sw);
	        		patent.addAbstractParagraph(sw.toString().replaceAll("</.*?>|<[^>]*?/>", "").replaceAll("<.*?>", "\n"));
	        	}
	        	else if(grantnode.getClass()==xml.us.patent.application.v42.Description.class) { // get description
	        		xml.us.patent.application.v42.Description desc = (xml.us.patent.application.v42.Description) grantnode;
	        		StringWriter sw = new StringWriter();
	        		marshaller.marshal(desc, sw);
	        		patent.addDescParagraph(sw.toString().replaceAll("</.*?>|<[^>]*?/>", "").replaceAll("<.*?>", "\n"));
	        	}			        	
	        	else if(grantnode.getClass()==xml.us.patent.application.v42.Claims.class) { // get claims
	        		xml.us.patent.application.v42.Claims claims = (xml.us.patent.application.v42.Claims) grantnode;
	        		StringWriter sw = new StringWriter();
	        		marshaller.marshal(claims, sw);
	        		patent.addClaim(sw.toString().replaceAll("<claim id.*?>|</.*?>|<[^>]*?/>", "").replaceAll("<claim-ref.*?>|</claim-ref.*?>"," ").replaceAll("</claim-ref.*?>"," ").replaceAll("<.*?>", "\n"));
	        	}
	        }
	   } catch (ParserConfigurationException | SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JAXBException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return patent;
	}
	
	private static Patent parseApplicationv41(String patentxml) {
		// TODO Auto-generated method stub
		Patent patent = new PatentApplication();
       	try {
			SAXParserFactory spf = SAXParserFactory.newInstance();
			SAXParser sp;
	
			sp = spf.newSAXParser();
	
			XMLReader xr = sp.getXMLReader();
       
	       // prase the xml according to its dtd version
	       JAXBContext jc = JAXBContext.newInstance("xml.us.patent.application.v41");
	       Marshaller marshaller = jc.createMarshaller();	        
	       Unmarshaller unmarshaller = jc.createUnmarshaller();
	       UnmarshallerHandler unmarshallerHandler = unmarshaller.getUnmarshallerHandler();
	       xr.setContentHandler((ContentHandler) unmarshallerHandler);
	 
	        InputSource xmlSource = new InputSource(new StringReader(patentxml));
	        xr.parse(xmlSource);
	 
	        xml.us.patent.application.v41.UsPatentApplication app = (xml.us.patent.application.v41.UsPatentApplication) unmarshallerHandler.getResult();
	        
	        // extract patent data
	        List<Object> grantLst = app.getDocPageOrUsBibliographicDataApplicationOrAbstractOrDrawingsOrDescriptionOrUsSequenceListDocOrUsMegatableDocOrTableExternalDocOrUsChemistryOrUsMathOrUsClaimStatementOrClaims();
	        for(int i=0; i<grantLst.size(); i++) {
	        	Object grantnode = grantLst.get(i);
	        	if(grantnode.getClass()==xml.us.patent.application.v41.UsBibliographicDataApplication.class) {
	        		xml.us.patent.application.v41.UsBibliographicDataApplication usBibliographicDataApp = (xml.us.patent.application.v41.UsBibliographicDataApplication) grantnode;
	        		
	        		// get publication reference
	        		xml.us.patent.application.v41.PublicationReference publicationReference = usBibliographicDataApp.getPublicationReference();
	        		
	        		xml.us.patent.application.v41.DocumentId docId = publicationReference.getDocumentId();
	        		patent.setPubDocNumber(docId.getDocNumber());
	        		patent.setPubCountry(docId.getCountry().getvalue());
	        		patent.setPubKind(docId.getKind());
	        		patent.setPubDate(docId.getDate().getvalue());
	        		
	        		xml.us.patent.application.v41.InventionTitle inventionTitle = usBibliographicDataApp.getInventionTitle();
	        		patent.setTitle(inventionTitle.getvalue());
	        		
	        		// get application reference
	        		xml.us.patent.application.v41.ApplicationReference applicationReference = usBibliographicDataApp.getApplicationReference();
	        		docId = applicationReference.getDocumentId();
	        		patent.setAppDocNumber(docId.getDocNumber());
	        		patent.setAppCountry(docId.getCountry().getvalue());
	        		patent.setAppDate(docId.getDate().getvalue());
	        		
	        		// get inventors
	        		xml.us.patent.application.v41.Parties parties = usBibliographicDataApp.getParties();
	        		if(parties!=null) {
	        			xml.us.patent.application.v41.Inventors inventors = parties.getInventors();
		        		if(inventors!=null) {
		        			List<Object> inventorsLst = inventors.getInventorOrDeceasedInventor();
		        			for(Object inventornode : inventorsLst) {
	        					if(inventornode.getClass()==xml.us.patent.application.v41.Inventor.class) {
	        						xml.us.patent.application.v41.Inventor inventor = (xml.us.patent.application.v41.Inventor) inventornode;
	        						List<xml.us.patent.application.v41.Addressbook> inventorAddressbook = inventor.getAddressbook();
	        						for(xml.us.patent.application.v41.Addressbook inventorAddressbookDet : inventorAddressbook)
	        						{
	        							patent.addInventor(new AddrezzBook(inventorAddressbookDet));
	        						}				        					
		        				}
			        		}
		        		}
	        		}
	        		
	        		// get assignees
	        		xml.us.patent.application.v41.Assignees assignees = usBibliographicDataApp.getAssignees();
	        		if(assignees!=null) {
		        		List<xml.us.patent.application.v41.Assignee> assigneeLst = assignees.getAssignee();
		        		for(xml.us.patent.application.v41.Assignee assigneeDet : assigneeLst) {
		        			patent.addAssignee(new AddrezzBook(assigneeDet));
		        		}
	        		}
	        		
	        		// get US classification
	        		xml.us.patent.application.v41.ClassificationNational usClassification = usBibliographicDataApp.getClassificationNational();
	        		if(usClassification!=null) {
		        		patent.setMainClassification(usClassification.getMainClassification());
		        		
		        		List<xml.us.patent.application.v41.FurtherClassification> furtherClassifications = usClassification.getFurtherClassification();
		        		if(furtherClassifications!=null) {
		        			for(xml.us.patent.application.v41.FurtherClassification furtherClassification : furtherClassifications) {
		        				patent.addfurtherClassification(furtherClassification.getvalue());
		        			}
		        		}
	        		}
	        		
	        		// get IPC classification
	        		xml.us.patent.application.v41.ClassificationsIpcr ipcs = usBibliographicDataApp.getClassificationsIpcr();
	        		if(ipcs!=null) {
	        			List<xml.us.patent.application.v41.ClassificationIpcr> ipcLst = ipcs.getClassificationIpcr();
	        			if(ipcLst!=null) {
	        				for(xml.us.patent.application.v41.ClassificationIpcr ipc : ipcLst) {
	        					xml.us.patent.application.v41.IpcVersionIndicator versionIndicator = ipc.getIpcVersionIndicator();
	        					if(versionIndicator!=null) {
	        						patent.addIpcVersionDate(versionIndicator.getDate().getvalue());
	        					}
	        					patent.addIpcClassificationLevel(ipc.getClassificationLevel());
	        					patent.addIpcSection(ipc.getSection());
	        					patent.addIpcClass(ipc.getClazz().getvalue());
	        					patent.addIpcSubclass(ipc.getSubclass());
	        					patent.addIpcMainGroup(ipc.getMainGroup());
	        					patent.addIpcSubgroup(ipc.getSubgroup());
	        					patent.addIpcSymbolLevel(ipc.getSymbolPosition());
	        					patent.addIpcClassificationValue(ipc.getClassificationValue());
	        				}
	        			}
	        		}
	        	}	        	
	        	else if(grantnode.getClass()==xml.us.patent.application.v41.Abstract.class) { // get abstract
	        		xml.us.patent.application.v41.Abstract abstr = (xml.us.patent.application.v41.Abstract) grantnode;
	        		StringWriter sw = new StringWriter();
	        		marshaller.marshal(abstr, sw);
	        		patent.addAbstractParagraph(sw.toString().replaceAll("</.*?>|<[^>]*?/>", "").replaceAll("<.*?>", "\n"));
	        	}
	        	else if(grantnode.getClass()==xml.us.patent.application.v41.Description.class) { // get description
	        		xml.us.patent.application.v41.Description desc = (xml.us.patent.application.v41.Description) grantnode;
	        		StringWriter sw = new StringWriter();
	        		marshaller.marshal(desc, sw);
	        		patent.addDescParagraph(sw.toString().replaceAll("</.*?>|<[^>]*?/>", "").replaceAll("<.*?>", "\n"));
	        	}			        	
	        	else if(grantnode.getClass()==xml.us.patent.application.v41.Claims.class) { // get claims
	        		xml.us.patent.application.v41.Claims claims = (xml.us.patent.application.v41.Claims) grantnode;
	        		StringWriter sw = new StringWriter();
	        		marshaller.marshal(claims, sw);
	        		patent.addClaim(sw.toString().replaceAll("<claim id.*?>|</.*?>|<[^>]*?/>", "").replaceAll("<claim-ref.*?>|</claim-ref.*?>"," ").replaceAll("</claim-ref.*?>"," ").replaceAll("<.*?>", "\n"));
	        	}
	        }
	   } catch (ParserConfigurationException | SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JAXBException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return patent;
	}
	
	private static Patent parseApplicationv40_041202(String patentxml) {
		// TODO Auto-generated method stub
		Patent patent = new PatentApplication();
       	try {
			SAXParserFactory spf = SAXParserFactory.newInstance();
			SAXParser sp;
	
			sp = spf.newSAXParser();
	
			XMLReader xr = sp.getXMLReader();
       
	       // prase the xml according to its dtd version
	       JAXBContext jc = JAXBContext.newInstance("xml.us.patent.application.v40_041202");
	       Marshaller marshaller = jc.createMarshaller();	        
	       Unmarshaller unmarshaller = jc.createUnmarshaller();
	       UnmarshallerHandler unmarshallerHandler = unmarshaller.getUnmarshallerHandler();
	       xr.setContentHandler((ContentHandler) unmarshallerHandler);
	 
	        InputSource xmlSource = new InputSource(new StringReader(patentxml));
	        xr.parse(xmlSource);
	 
	        xml.us.patent.application.v40_041202.UsPatentApplication app = (xml.us.patent.application.v40_041202.UsPatentApplication) unmarshallerHandler.getResult();
	        
	        // extract patent data
	        List<Object> grantLst = app.getDocPageOrUsBibliographicDataApplicationOrAbstractOrDrawingsOrDescriptionOrSequenceListDocOrTableExternalDocOrUsChemistryOrUsMathOrClaims();
	        for(int i=0; i<grantLst.size(); i++) {
	        	Object grantnode = grantLst.get(i);
	        	if(grantnode.getClass()==xml.us.patent.application.v40_041202.UsBibliographicDataApplication.class) {
	        		xml.us.patent.application.v40_041202.UsBibliographicDataApplication usBibliographicDataApp = (xml.us.patent.application.v40_041202.UsBibliographicDataApplication) grantnode;
	        		
	        		// get publication reference
	        		xml.us.patent.application.v40_041202.PublicationReference publicationReference = usBibliographicDataApp.getPublicationReference();
	        		
	        		xml.us.patent.application.v40_041202.DocumentId docId = publicationReference.getDocumentId();
	        		patent.setPubDocNumber(docId.getDocNumber());
	        		patent.setPubCountry(docId.getCountry().getvalue());
	        		patent.setPubKind(docId.getKind());
	        		patent.setPubDate(docId.getDate().getvalue());
	        		
	        		xml.us.patent.application.v40_041202.InventionTitle inventionTitle = usBibliographicDataApp.getInventionTitle();
	        		patent.setTitle(inventionTitle.getvalue());
	        		
	        		// get application reference
	        		xml.us.patent.application.v40_041202.ApplicationReference applicationReference = usBibliographicDataApp.getApplicationReference();
	        		docId = applicationReference.getDocumentId();
	        		patent.setAppDocNumber(docId.getDocNumber());
	        		patent.setAppCountry(docId.getCountry().getvalue());
	        		patent.setAppDate(docId.getDate().getvalue());
	        		
	        		// get inventors
	        		xml.us.patent.application.v40_041202.Parties parties = usBibliographicDataApp.getParties();
	        		if(parties!=null) {
	        			xml.us.patent.application.v40_041202.Inventors inventors = parties.getInventors();
		        		if(inventors!=null) {
		        			List<Object> inventorsLst = inventors.getInventorOrDeceasedInventor();
		        			for(Object inventornode : inventorsLst) {
	        					if(inventornode.getClass()==xml.us.patent.application.v40_041202.Inventor.class) {
	        						xml.us.patent.application.v40_041202.Inventor inventor = (xml.us.patent.application.v40_041202.Inventor) inventornode;
	        						List<xml.us.patent.application.v40_041202.Addressbook> inventorAddressbook = inventor.getAddressbook();
	        						for(xml.us.patent.application.v40_041202.Addressbook inventorAddressbookDet : inventorAddressbook)
	        						{
	        							patent.addInventor(new AddrezzBook(inventorAddressbookDet));
	        						}				        					
		        				}
			        		}
		        		}
	        		}
	        		
	        		// get assignees
	        		xml.us.patent.application.v40_041202.Assignees assignees = usBibliographicDataApp.getAssignees();
	        		if(assignees!=null) {
		        		List<xml.us.patent.application.v40_041202.Assignee> assigneeLst = assignees.getAssignee();
		        		for(xml.us.patent.application.v40_041202.Assignee assigneeDet : assigneeLst) {
		        			patent.addAssignee(new AddrezzBook(assigneeDet));
		        		}
	        		}
	        		
	        		// get US classification
	        		xml.us.patent.application.v40_041202.ClassificationNational usClassification = usBibliographicDataApp.getClassificationNational();
	        		if(usClassification!=null) {
		        		patent.setMainClassification(usClassification.getMainClassification());
		        		
		        		List<xml.us.patent.application.v40_041202.FurtherClassification> furtherClassifications = usClassification.getFurtherClassification();
		        		if(furtherClassifications!=null) {
		        			for(xml.us.patent.application.v40_041202.FurtherClassification furtherClassification : furtherClassifications) {
		        				patent.addfurtherClassification(furtherClassification.getvalue());
		        			}
		        		}
	        		}
	        		
	        		// get IPC classification
	        		xml.us.patent.application.v40_041202.ClassificationsIpcr ipcs = usBibliographicDataApp.getClassificationsIpcr();
	        		if(ipcs!=null) {
	        			List<xml.us.patent.application.v40_041202.ClassificationIpcr> ipcLst = ipcs.getClassificationIpcr();
	        			if(ipcLst!=null) {
	        				for(xml.us.patent.application.v40_041202.ClassificationIpcr ipc : ipcLst) {
	        					xml.us.patent.application.v40_041202.IpcVersionIndicator versionIndicator = ipc.getIpcVersionIndicator();
	        					if(versionIndicator!=null) {
	        						patent.addIpcVersionDate(versionIndicator.getDate().getvalue());
	        					}
	        					patent.addIpcClassificationLevel(ipc.getClassificationLevel());
	        					patent.addIpcSection(ipc.getSection());
	        					patent.addIpcClass(ipc.getClazz().getvalue());
	        					patent.addIpcSubclass(ipc.getSubclass());
	        					patent.addIpcMainGroup(ipc.getMainGroup());
	        					patent.addIpcSubgroup(ipc.getSubgroup());
	        					patent.addIpcSymbolLevel(ipc.getSymbolPosition());
	        					patent.addIpcClassificationValue(ipc.getClassificationValue());
	        				}
	        			}
	        		}
	        		else {
	        			xml.us.patent.application.v40_041202.ClassificationIpc ipc = usBibliographicDataApp.getClassificationIpc();
	        			if(ipc!=null) {
	        				String ipcstr = ipc.getMainClassification();
	        				if(ipcstr!=null) {
		        				String[] ipcstrTokens = ipcstr.split("/");
		        				if(ipcstrTokens.length==2) {
		    	    				//patent.addIpcClassificationLevel();
		    						patent.addIpcSection(ipcstrTokens[0].substring(0,1));
		    						patent.addIpcClass(ipcstrTokens[0].substring(1,3));
		    						patent.addIpcSubclass(ipcstrTokens[0].substring(3,4));
		    						patent.addIpcMainGroup(ipcstrTokens[0].substring(4));
		    						patent.addIpcSubgroup(ipcstrTokens[1]);
		    						//patent.addIpcSymbolLevel();
		    						//patent.addIpcClassificationValue();
		        				}
	        				}
	        				List<xml.us.patent.application.v40_041202.FurtherClassification> ipcfurtherLst = ipc.getFurtherClassification();
	        				if(ipcfurtherLst!=null) {
	        					for(xml.us.patent.application.v40_041202.FurtherClassification ipcfuther : ipcfurtherLst) {
	        						String ipcfutherstr = ipcfuther.getvalue();
	        						if(ipcfutherstr!=null) {
		        						String[] ipcfurtherTokens = ipcfutherstr.split("/");
		    	        				if(ipcfurtherTokens.length==2) {
		    	    	    				//patent.addIpcClassificationLevel();
		    	    						patent.addIpcSection(ipcfurtherTokens[0].substring(0,1));
		    	    						patent.addIpcClass(ipcfurtherTokens[0].substring(1,3));
		    	    						patent.addIpcSubclass(ipcfurtherTokens[0].substring(3,4));
		    	    						patent.addIpcMainGroup(ipcfurtherTokens[0].substring(4));
		    	    						patent.addIpcSubgroup(ipcfurtherTokens[1]);
		    	    						//patent.addIpcSymbolLevel();
		    	    						//patent.addIpcClassificationValue();
		    	        				}
	        						}
	        					}
	        				}
	        			}
	        		}
	        	}	        	
	        	else if(grantnode.getClass()==xml.us.patent.application.v40_041202.Abstract.class) { // get abstract
	        		xml.us.patent.application.v40_041202.Abstract abstr = (xml.us.patent.application.v40_041202.Abstract) grantnode;
	        		StringWriter sw = new StringWriter();
	        		marshaller.marshal(abstr, sw);
	        		patent.addAbstractParagraph(sw.toString().replaceAll("</.*?>|<[^>]*?/>", "").replaceAll("<.*?>", "\n"));
	        	}
	        	else if(grantnode.getClass()==xml.us.patent.application.v40_041202.Description.class) { // get description
	        		xml.us.patent.application.v40_041202.Description desc = (xml.us.patent.application.v40_041202.Description) grantnode;
	        		StringWriter sw = new StringWriter();
	        		marshaller.marshal(desc, sw);
	        		patent.addDescParagraph(sw.toString().replaceAll("</.*?>|<[^>]*?/>", "").replaceAll("<.*?>", "\n"));
	        	}			        	
	        	else if(grantnode.getClass()==xml.us.patent.application.v40_041202.Claims.class) { // get claims
	        		xml.us.patent.application.v40_041202.Claims claims = (xml.us.patent.application.v40_041202.Claims) grantnode;
	        		StringWriter sw = new StringWriter();
	        		marshaller.marshal(claims, sw);
	        		patent.addClaim(sw.toString().replaceAll("<claim id.*?>|</.*?>|<[^>]*?/>", "").replaceAll("<claim-ref.*?>|</claim-ref.*?>"," ").replaceAll("</claim-ref.*?>"," ").replaceAll("<.*?>", "\n"));
	        	}
	        }
	   } catch (ParserConfigurationException | SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JAXBException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return patent;
	}
	
	private static Patent parseApplicationv40_040908(String patentxml) {
		// TODO Auto-generated method stub
		Patent patent = new PatentApplication();
       	try {
			SAXParserFactory spf = SAXParserFactory.newInstance();
			SAXParser sp;
	
			sp = spf.newSAXParser();
	
			XMLReader xr = sp.getXMLReader();
       
	       // prase the xml according to its dtd version
	       JAXBContext jc = JAXBContext.newInstance("xml.us.patent.application.v40_040908");
	       Marshaller marshaller = jc.createMarshaller();	        
	       Unmarshaller unmarshaller = jc.createUnmarshaller();
	       UnmarshallerHandler unmarshallerHandler = unmarshaller.getUnmarshallerHandler();
	       xr.setContentHandler((ContentHandler) unmarshallerHandler);
	 
	        InputSource xmlSource = new InputSource(new StringReader(patentxml));
	        xr.parse(xmlSource);
	 
	        xml.us.patent.application.v40_040908.UsPatentApplication app = (xml.us.patent.application.v40_040908.UsPatentApplication) unmarshallerHandler.getResult();
	        
	        // extract patent data
	        List<Object> grantLst = app.getDocPageOrUsBibliographicDataApplicationOrAbstractOrDrawingsOrDescriptionOrSequenceListDocOrTableExternalDocOrUsChemistryOrUsMathOrClaims();
	        for(int i=0; i<grantLst.size(); i++) {
	        	Object grantnode = grantLst.get(i);
	        	if(grantnode.getClass()==xml.us.patent.application.v40_040908.UsBibliographicDataApplication.class) {
	        		xml.us.patent.application.v40_040908.UsBibliographicDataApplication usBibliographicDataApp = (xml.us.patent.application.v40_040908.UsBibliographicDataApplication) grantnode;
	        		
	        		// get publication reference
	        		xml.us.patent.application.v40_040908.PublicationReference publicationReference = usBibliographicDataApp.getPublicationReference();
	        		
	        		xml.us.patent.application.v40_040908.DocumentId docId = publicationReference.getDocumentId();
	        		patent.setPubDocNumber(docId.getDocNumber());
	        		patent.setPubCountry(docId.getCountry().getvalue());
	        		patent.setPubKind(docId.getKind());
	        		patent.setPubDate(docId.getDate().getvalue());
	        		
	        		xml.us.patent.application.v40_040908.InventionTitle inventionTitle = usBibliographicDataApp.getInventionTitle();
	        		patent.setTitle(inventionTitle.getvalue());
	        		
	        		// get application reference
	        		xml.us.patent.application.v40_040908.ApplicationReference applicationReference = usBibliographicDataApp.getApplicationReference();
	        		docId = applicationReference.getDocumentId();
	        		patent.setAppDocNumber(docId.getDocNumber());
	        		patent.setAppCountry(docId.getCountry().getvalue());
	        		patent.setAppDate(docId.getDate().getvalue());
	        		
	        		// get inventors
	        		xml.us.patent.application.v40_040908.Parties parties = usBibliographicDataApp.getParties();
	        		if(parties!=null) {
	        			xml.us.patent.application.v40_040908.Inventors inventors = parties.getInventors();
		        		if(inventors!=null) {
		        			List<Object> inventorsLst = inventors.getInventorOrDeceasedInventor();
		        			for(Object inventornode : inventorsLst) {
	        					if(inventornode.getClass()==xml.us.patent.application.v40_040908.Inventor.class) {
	        						xml.us.patent.application.v40_040908.Inventor inventor = (xml.us.patent.application.v40_040908.Inventor) inventornode;
	        						List<xml.us.patent.application.v40_040908.Addressbook> inventorAddressbook = inventor.getAddressbook();
	        						for(xml.us.patent.application.v40_040908.Addressbook inventorAddressbookDet : inventorAddressbook)
	        						{
	        							patent.addInventor(new AddrezzBook(inventorAddressbookDet));
	        						}				        					
		        				}
			        		}
		        		}
	        		}
	        		
	        		// get assignees
	        		xml.us.patent.application.v40_040908.Assignees assignees = usBibliographicDataApp.getAssignees();
	        		if(assignees!=null) {
		        		List<xml.us.patent.application.v40_040908.Assignee> assigneeLst = assignees.getAssignee();
		        		for(xml.us.patent.application.v40_040908.Assignee assigneeDet : assigneeLst) {
		        			patent.addAssignee(new AddrezzBook(assigneeDet));
		        		}
	        		}
	        		
	        		// get US classification
	        		xml.us.patent.application.v40_040908.ClassificationNational usClassification = usBibliographicDataApp.getClassificationNational();
	        		if(usClassification!=null) {
		        		patent.setMainClassification(usClassification.getMainClassification());
		        		
		        		List<xml.us.patent.application.v40_040908.FurtherClassification> furtherClassifications = usClassification.getFurtherClassification();
		        		if(furtherClassifications!=null) {
		        			for(xml.us.patent.application.v40_040908.FurtherClassification furtherClassification : furtherClassifications) {
		        				patent.addfurtherClassification(furtherClassification.getvalue());
		        			}
		        		}
	        		}
	        		
	        		// get IPC classification
	        		xml.us.patent.application.v40_040908.ClassificationsIpcr ipcs = usBibliographicDataApp.getClassificationsIpcr();
	        		if(ipcs!=null) {
	        			List<xml.us.patent.application.v40_040908.ClassificationIpcr> ipcLst = ipcs.getClassificationIpcr();
	        			if(ipcLst!=null) {
	        				for(xml.us.patent.application.v40_040908.ClassificationIpcr ipc : ipcLst) {
	        					xml.us.patent.application.v40_040908.IpcVersionIndicator versionIndicator = ipc.getIpcVersionIndicator();
	        					if(versionIndicator!=null) {
	        						patent.addIpcVersionDate(versionIndicator.getDate().getvalue());
	        					}
	        					patent.addIpcClassificationLevel(ipc.getClassificationLevel());
	        					patent.addIpcSection(ipc.getSection());
	        					patent.addIpcClass(ipc.getClazz().getvalue());
	        					patent.addIpcSubclass(ipc.getSubclass());
	        					patent.addIpcMainGroup(ipc.getMainGroup());
	        					patent.addIpcSubgroup(ipc.getSubgroup());
	        					patent.addIpcSymbolLevel(ipc.getSymbolPosition());
	        					patent.addIpcClassificationValue(ipc.getClassificationValue());
	        				}
	        			}
	        		}
	        		else {
	        			xml.us.patent.application.v40_040908.ClassificationIpc ipc = usBibliographicDataApp.getClassificationIpc();
	        			if(ipc!=null) {
	        				String ipcstr = ipc.getMainClassification();
	        				if(ipcstr!=null) {
		        				String[] ipcstrTokens = ipcstr.split("/");
		        				if(ipcstrTokens.length==2) {
		    	    				//patent.addIpcClassificationLevel();
		    						patent.addIpcSection(ipcstrTokens[0].substring(0,1));
		    						patent.addIpcClass(ipcstrTokens[0].substring(1,3));
		    						patent.addIpcSubclass(ipcstrTokens[0].substring(3,4));
		    						patent.addIpcMainGroup(ipcstrTokens[0].substring(4));
		    						patent.addIpcSubgroup(ipcstrTokens[1]);
		    						//patent.addIpcSymbolLevel();
		    						//patent.addIpcClassificationValue();
		        				}
	        				}
	        				List<xml.us.patent.application.v40_040908.FurtherClassification> ipcfurtherLst = ipc.getFurtherClassification();
	        				if(ipcfurtherLst!=null) {
	        					for(xml.us.patent.application.v40_040908.FurtherClassification ipcfuther : ipcfurtherLst) {
	        						String ipcfutherstr = ipcfuther.getvalue();
	        						if(ipcfutherstr!=null) {
		        						String[] ipcfurtherTokens = ipcfutherstr.split("/");
		    	        				if(ipcfurtherTokens.length==2) {
		    	    	    				//patent.addIpcClassificationLevel();
		    	    						patent.addIpcSection(ipcfurtherTokens[0].substring(0,1));
		    	    						patent.addIpcClass(ipcfurtherTokens[0].substring(1,3));
		    	    						patent.addIpcSubclass(ipcfurtherTokens[0].substring(3,4));
		    	    						patent.addIpcMainGroup(ipcfurtherTokens[0].substring(4));
		    	    						patent.addIpcSubgroup(ipcfurtherTokens[1]);
		    	    						//patent.addIpcSymbolLevel();
		    	    						//patent.addIpcClassificationValue();
		    	        				}
	        						}
	        					}
	        				}
	        			}
	        		}
	        	}	        	
	        	else if(grantnode.getClass()==xml.us.patent.application.v40_040908.Abstract.class) { // get abstract
	        		xml.us.patent.application.v40_040908.Abstract abstr = (xml.us.patent.application.v40_040908.Abstract) grantnode;
	        		StringWriter sw = new StringWriter();
	        		marshaller.marshal(abstr, sw);
	        		patent.addAbstractParagraph(sw.toString().replaceAll("</.*?>|<[^>]*?/>", "").replaceAll("<.*?>", "\n"));
	        	}
	        	else if(grantnode.getClass()==xml.us.patent.application.v40_040908.Description.class) { // get description
	        		xml.us.patent.application.v40_040908.Description desc = (xml.us.patent.application.v40_040908.Description) grantnode;
	        		StringWriter sw = new StringWriter();
	        		marshaller.marshal(desc, sw);
	        		patent.addDescParagraph(sw.toString().replaceAll("</.*?>|<[^>]*?/>", "").replaceAll("<.*?>", "\n"));
	        	}			        	
	        	else if(grantnode.getClass()==xml.us.patent.application.v40_040908.Claims.class) { // get claims
	        		xml.us.patent.application.v40_040908.Claims claims = (xml.us.patent.application.v40_040908.Claims) grantnode;
	        		StringWriter sw = new StringWriter();
	        		marshaller.marshal(claims, sw);
	        		patent.addClaim(sw.toString().replaceAll("<claim id.*?>|</.*?>|<[^>]*?/>", "").replaceAll("<claim-ref.*?>|</claim-ref.*?>"," ").replaceAll("</claim-ref.*?>"," ").replaceAll("<.*?>", "\n"));
	        	}
	        }
	   } catch (ParserConfigurationException | SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JAXBException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return patent;
	}

	private static Patent parseApplicationv40_040927(String patentxml) {
		// TODO Auto-generated method stub
		Patent patent = new PatentApplication();
       	try {
			SAXParserFactory spf = SAXParserFactory.newInstance();
			SAXParser sp;
	
			sp = spf.newSAXParser();
	
			XMLReader xr = sp.getXMLReader();
       
	       // prase the xml according to its dtd version
	       JAXBContext jc = JAXBContext.newInstance("xml.us.patent.application.v40_040927");
	       Marshaller marshaller = jc.createMarshaller();	        
	       Unmarshaller unmarshaller = jc.createUnmarshaller();
	       UnmarshallerHandler unmarshallerHandler = unmarshaller.getUnmarshallerHandler();
	       xr.setContentHandler((ContentHandler) unmarshallerHandler);
	 
	        InputSource xmlSource = new InputSource(new StringReader(patentxml));
	        xr.parse(xmlSource);
	 
	        xml.us.patent.application.v40_040927.UsPatentApplication app = (xml.us.patent.application.v40_040927.UsPatentApplication) unmarshallerHandler.getResult();
	        
	        // extract patent data
	        List<Object> grantLst = app.getDocPageOrUsBibliographicDataApplicationOrAbstractOrDrawingsOrDescriptionOrSequenceListDocOrTableExternalDocOrUsChemistryOrUsMathOrClaims();
	        for(int i=0; i<grantLst.size(); i++) {
	        	Object grantnode = grantLst.get(i);
	        	if(grantnode.getClass()==xml.us.patent.application.v40_040927.UsBibliographicDataApplication.class) {
	        		xml.us.patent.application.v40_040927.UsBibliographicDataApplication usBibliographicDataApp = (xml.us.patent.application.v40_040927.UsBibliographicDataApplication) grantnode;
	        		
	        		// get publication reference
	        		xml.us.patent.application.v40_040927.PublicationReference publicationReference = usBibliographicDataApp.getPublicationReference();
	        		
	        		xml.us.patent.application.v40_040927.DocumentId docId = publicationReference.getDocumentId();
	        		patent.setPubDocNumber(docId.getDocNumber());
	        		patent.setPubCountry(docId.getCountry().getvalue());
	        		patent.setPubKind(docId.getKind());
	        		patent.setPubDate(docId.getDate().getvalue());
	        		
	        		xml.us.patent.application.v40_040927.InventionTitle inventionTitle = usBibliographicDataApp.getInventionTitle();
	        		patent.setTitle(inventionTitle.getvalue());
	        		
	        		// get application reference
	        		xml.us.patent.application.v40_040927.ApplicationReference applicationReference = usBibliographicDataApp.getApplicationReference();
	        		docId = applicationReference.getDocumentId();
	        		patent.setAppDocNumber(docId.getDocNumber());
	        		patent.setAppCountry(docId.getCountry().getvalue());
	        		patent.setAppDate(docId.getDate().getvalue());
	        		
	        		// get inventors
	        		xml.us.patent.application.v40_040927.Parties parties = usBibliographicDataApp.getParties();
	        		if(parties!=null) {
	        			xml.us.patent.application.v40_040927.Inventors inventors = parties.getInventors();
		        		if(inventors!=null) {
		        			List<Object> inventorsLst = inventors.getInventorOrDeceasedInventor();
		        			for(Object inventornode : inventorsLst) {
	        					if(inventornode.getClass()==xml.us.patent.application.v40_040927.Inventor.class) {
	        						xml.us.patent.application.v40_040927.Inventor inventor = (xml.us.patent.application.v40_040927.Inventor) inventornode;
	        						List<xml.us.patent.application.v40_040927.Addressbook> inventorAddressbook = inventor.getAddressbook();
	        						for(xml.us.patent.application.v40_040927.Addressbook inventorAddressbookDet : inventorAddressbook)
	        						{
	        							patent.addInventor(new AddrezzBook(inventorAddressbookDet));
	        						}				        					
		        				}
			        		}
		        		}
	        		}
	        		
	        		// get assignees
	        		xml.us.patent.application.v40_040927.Assignees assignees = usBibliographicDataApp.getAssignees();
	        		if(assignees!=null) {
		        		List<xml.us.patent.application.v40_040927.Assignee> assigneeLst = assignees.getAssignee();
		        		for(xml.us.patent.application.v40_040927.Assignee assigneeDet : assigneeLst) {
		        			patent.addAssignee(new AddrezzBook(assigneeDet));
		        		}
	        		}
	        		
	        		// get US classification
	        		xml.us.patent.application.v40_040927.ClassificationNational usClassification = usBibliographicDataApp.getClassificationNational();
	        		if(usClassification!=null) {
		        		patent.setMainClassification(usClassification.getMainClassification());
		        		
		        		List<xml.us.patent.application.v40_040927.FurtherClassification> furtherClassifications = usClassification.getFurtherClassification();
		        		if(furtherClassifications!=null) {
		        			for(xml.us.patent.application.v40_040927.FurtherClassification furtherClassification : furtherClassifications) {
		        				patent.addfurtherClassification(furtherClassification.getvalue());
		        			}
		        		}
	        		}
	        		
	        		// get IPC classification
	        		xml.us.patent.application.v40_040927.ClassificationsIpcr ipcs = usBibliographicDataApp.getClassificationsIpcr();
	        		if(ipcs!=null) {
	        			List<xml.us.patent.application.v40_040927.ClassificationIpcr> ipcLst = ipcs.getClassificationIpcr();
	        			if(ipcLst!=null) {
	        				for(xml.us.patent.application.v40_040927.ClassificationIpcr ipc : ipcLst) {
	        					xml.us.patent.application.v40_040927.IpcVersionIndicator versionIndicator = ipc.getIpcVersionIndicator();
	        					if(versionIndicator!=null) {
	        						patent.addIpcVersionDate(versionIndicator.getDate().getvalue());
	        					}
	        					patent.addIpcClassificationLevel(ipc.getClassificationLevel());
	        					patent.addIpcSection(ipc.getSection());
	        					patent.addIpcClass(ipc.getClazz().getvalue());
	        					patent.addIpcSubclass(ipc.getSubclass());
	        					patent.addIpcMainGroup(ipc.getMainGroup());
	        					patent.addIpcSubgroup(ipc.getSubgroup());
	        					patent.addIpcSymbolLevel(ipc.getSymbolPosition());
	        					patent.addIpcClassificationValue(ipc.getClassificationValue());
	        				}
	        			}
	        		}
	        		else {
	        			xml.us.patent.application.v40_040927.ClassificationIpc ipc = usBibliographicDataApp.getClassificationIpc();
	        			if(ipc!=null) {
	        				String ipcstr = ipc.getMainClassification();
	        				if(ipcstr!=null) {
		        				String[] ipcstrTokens = ipcstr.split("/");
		        				if(ipcstrTokens.length==2) {
		    	    				//patent.addIpcClassificationLevel();
		    						patent.addIpcSection(ipcstrTokens[0].substring(0,1));
		    						patent.addIpcClass(ipcstrTokens[0].substring(1,3));
		    						patent.addIpcSubclass(ipcstrTokens[0].substring(3,4));
		    						patent.addIpcMainGroup(ipcstrTokens[0].substring(4));
		    						patent.addIpcSubgroup(ipcstrTokens[1]);
		    						//patent.addIpcSymbolLevel();
		    						//patent.addIpcClassificationValue();
		        				}
	        				}
	        				List<xml.us.patent.application.v40_040927.FurtherClassification> ipcfurtherLst = ipc.getFurtherClassification();
	        				if(ipcfurtherLst!=null) {
	        					for(xml.us.patent.application.v40_040927.FurtherClassification ipcfuther : ipcfurtherLst) {
	        						String ipcfutherstr = ipcfuther.getvalue();
	        						if(ipcfutherstr!=null) {
		        						String[] ipcfurtherTokens = ipcfutherstr.split("/");
		    	        				if(ipcfurtherTokens.length==2) {
		    	    	    				//patent.addIpcClassificationLevel();
		    	    						patent.addIpcSection(ipcfurtherTokens[0].substring(0,1));
		    	    						patent.addIpcClass(ipcfurtherTokens[0].substring(1,3));
		    	    						patent.addIpcSubclass(ipcfurtherTokens[0].substring(3,4));
		    	    						patent.addIpcMainGroup(ipcfurtherTokens[0].substring(4));
		    	    						patent.addIpcSubgroup(ipcfurtherTokens[1]);
		    	    						//patent.addIpcSymbolLevel();
		    	    						//patent.addIpcClassificationValue();
		    	        				}
	        						}
	        					}
	        				}
	        			}
	        		}
	        	}	        	
	        	else if(grantnode.getClass()==xml.us.patent.application.v40_040927.Abstract.class) { // get abstract
	        		xml.us.patent.application.v40_040927.Abstract abstr = (xml.us.patent.application.v40_040927.Abstract) grantnode;
	        		StringWriter sw = new StringWriter();
	        		marshaller.marshal(abstr, sw);
	        		patent.addAbstractParagraph(sw.toString().replaceAll("</.*?>|<[^>]*?/>", "").replaceAll("<.*?>", "\n"));
	        	}
	        	else if(grantnode.getClass()==xml.us.patent.application.v40_040927.Description.class) { // get description
	        		xml.us.patent.application.v40_040927.Description desc = (xml.us.patent.application.v40_040927.Description) grantnode;
	        		StringWriter sw = new StringWriter();
	        		marshaller.marshal(desc, sw);
	        		patent.addDescParagraph(sw.toString().replaceAll("</.*?>|<[^>]*?/>", "").replaceAll("<.*?>", "\n"));
	        	}			        	
	        	else if(grantnode.getClass()==xml.us.patent.application.v40_040927.Claims.class) { // get claims
	        		xml.us.patent.application.v40_040927.Claims claims = (xml.us.patent.application.v40_040927.Claims) grantnode;
	        		StringWriter sw = new StringWriter();
	        		marshaller.marshal(claims, sw);
	        		patent.addClaim(sw.toString().replaceAll("<claim id.*?>|</.*?>|<[^>]*?/>", "").replaceAll("<claim-ref.*?>|</claim-ref.*?>"," ").replaceAll("</claim-ref.*?>"," ").replaceAll("<.*?>", "\n"));
	        	}
	        }
	   } catch (ParserConfigurationException | SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JAXBException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return patent;
	}

	private static Patent parseApplicationv40_041028(String patentxml) {
		// TODO Auto-generated method stub
		Patent patent = new PatentApplication();
       	try {
			SAXParserFactory spf = SAXParserFactory.newInstance();
			SAXParser sp;
	
			sp = spf.newSAXParser();
	
			XMLReader xr = sp.getXMLReader();
       
	       // prase the xml according to its dtd version
	       JAXBContext jc = JAXBContext.newInstance("xml.us.patent.application.v40_041028");
	       Marshaller marshaller = jc.createMarshaller();	        
	       Unmarshaller unmarshaller = jc.createUnmarshaller();
	       UnmarshallerHandler unmarshallerHandler = unmarshaller.getUnmarshallerHandler();
	       xr.setContentHandler((ContentHandler) unmarshallerHandler);
	 
	        InputSource xmlSource = new InputSource(new StringReader(patentxml));
	        xr.parse(xmlSource);
	 
	        xml.us.patent.application.v40_041028.UsPatentApplication app = (xml.us.patent.application.v40_041028.UsPatentApplication) unmarshallerHandler.getResult();
	        
	        // extract patent data
	        List<Object> grantLst = app.getDocPageOrUsBibliographicDataApplicationOrAbstractOrDrawingsOrDescriptionOrSequenceListDocOrTableExternalDocOrUsChemistryOrUsMathOrClaims();
	        for(int i=0; i<grantLst.size(); i++) {
	        	Object grantnode = grantLst.get(i);
	        	if(grantnode.getClass()==xml.us.patent.application.v40_041028.UsBibliographicDataApplication.class) {
	        		xml.us.patent.application.v40_041028.UsBibliographicDataApplication usBibliographicDataApp = (xml.us.patent.application.v40_041028.UsBibliographicDataApplication) grantnode;
	        		
	        		// get publication reference
	        		xml.us.patent.application.v40_041028.PublicationReference publicationReference = usBibliographicDataApp.getPublicationReference();
	        		
	        		xml.us.patent.application.v40_041028.DocumentId docId = publicationReference.getDocumentId();
	        		patent.setPubDocNumber(docId.getDocNumber());
	        		patent.setPubCountry(docId.getCountry().getvalue());
	        		patent.setPubKind(docId.getKind());
	        		patent.setPubDate(docId.getDate().getvalue());
	        		
	        		xml.us.patent.application.v40_041028.InventionTitle inventionTitle = usBibliographicDataApp.getInventionTitle();
	        		patent.setTitle(inventionTitle.getvalue());
	        		
	        		// get application reference
	        		xml.us.patent.application.v40_041028.ApplicationReference applicationReference = usBibliographicDataApp.getApplicationReference();
	        		docId = applicationReference.getDocumentId();
	        		patent.setAppDocNumber(docId.getDocNumber());
	        		patent.setAppCountry(docId.getCountry().getvalue());
	        		patent.setAppDate(docId.getDate().getvalue());
	        		
	        		// get inventors
	        		xml.us.patent.application.v40_041028.Parties parties = usBibliographicDataApp.getParties();
	        		if(parties!=null) {
	        			xml.us.patent.application.v40_041028.Inventors inventors = parties.getInventors();
		        		if(inventors!=null) {
		        			List<Object> inventorsLst = inventors.getInventorOrDeceasedInventor();
		        			for(Object inventornode : inventorsLst) {
	        					if(inventornode.getClass()==xml.us.patent.application.v40_041028.Inventor.class) {
	        						xml.us.patent.application.v40_041028.Inventor inventor = (xml.us.patent.application.v40_041028.Inventor) inventornode;
	        						List<xml.us.patent.application.v40_041028.Addressbook> inventorAddressbook = inventor.getAddressbook();
	        						for(xml.us.patent.application.v40_041028.Addressbook inventorAddressbookDet : inventorAddressbook)
	        						{
	        							patent.addInventor(new AddrezzBook(inventorAddressbookDet));
	        						}				        					
		        				}
			        		}
		        		}
	        		}
	        		
	        		// get assignees
	        		xml.us.patent.application.v40_041028.Assignees assignees = usBibliographicDataApp.getAssignees();
	        		if(assignees!=null) {
		        		List<xml.us.patent.application.v40_041028.Assignee> assigneeLst = assignees.getAssignee();
		        		for(xml.us.patent.application.v40_041028.Assignee assigneeDet : assigneeLst) {
		        			patent.addAssignee(new AddrezzBook(assigneeDet));
		        		}
	        		}
	        		
	        		// get US classification
	        		xml.us.patent.application.v40_041028.ClassificationNational usClassification = usBibliographicDataApp.getClassificationNational();
	        		if(usClassification!=null) {
		        		patent.setMainClassification(usClassification.getMainClassification());
		        		
		        		List<xml.us.patent.application.v40_041028.FurtherClassification> furtherClassifications = usClassification.getFurtherClassification();
		        		if(furtherClassifications!=null) {
		        			for(xml.us.patent.application.v40_041028.FurtherClassification furtherClassification : furtherClassifications) {
		        				patent.addfurtherClassification(furtherClassification.getvalue());
		        			}
		        		}
	        		}
	        		
	        		// get IPC classification
	        		xml.us.patent.application.v40_041028.ClassificationsIpcr ipcs = usBibliographicDataApp.getClassificationsIpcr();
	        		if(ipcs!=null) {
	        			List<xml.us.patent.application.v40_041028.ClassificationIpcr> ipcLst = ipcs.getClassificationIpcr();
	        			if(ipcLst!=null) {
	        				for(xml.us.patent.application.v40_041028.ClassificationIpcr ipc : ipcLst) {
	        					xml.us.patent.application.v40_041028.IpcVersionIndicator versionIndicator = ipc.getIpcVersionIndicator();
	        					if(versionIndicator!=null) {
	        						patent.addIpcVersionDate(versionIndicator.getDate().getvalue());
	        					}
	        					patent.addIpcClassificationLevel(ipc.getClassificationLevel());
	        					patent.addIpcSection(ipc.getSection());
	        					patent.addIpcClass(ipc.getClazz().getvalue());
	        					patent.addIpcSubclass(ipc.getSubclass());
	        					patent.addIpcMainGroup(ipc.getMainGroup());
	        					patent.addIpcSubgroup(ipc.getSubgroup());
	        					patent.addIpcSymbolLevel(ipc.getSymbolPosition());
	        					patent.addIpcClassificationValue(ipc.getClassificationValue());
	        				}
	        			}
	        		}
	        		else {
	        			xml.us.patent.application.v40_041028.ClassificationIpc ipc = usBibliographicDataApp.getClassificationIpc();
	        			if(ipc!=null) {
	        				String ipcstr = ipc.getMainClassification();
	        				if(ipcstr!=null) {
		        				String[] ipcstrTokens = ipcstr.split("/");
		        				if(ipcstrTokens.length==2) {
		    	    				//patent.addIpcClassificationLevel();
		    						patent.addIpcSection(ipcstrTokens[0].substring(0,1));
		    						patent.addIpcClass(ipcstrTokens[0].substring(1,3));
		    						patent.addIpcSubclass(ipcstrTokens[0].substring(3,4));
		    						patent.addIpcMainGroup(ipcstrTokens[0].substring(4));
		    						patent.addIpcSubgroup(ipcstrTokens[1]);
		    						//patent.addIpcSymbolLevel();
		    						//patent.addIpcClassificationValue();
		        				}
	        				}
	        				List<xml.us.patent.application.v40_041028.FurtherClassification> ipcfurtherLst = ipc.getFurtherClassification();
	        				if(ipcfurtherLst!=null) {
	        					for(xml.us.patent.application.v40_041028.FurtherClassification ipcfuther : ipcfurtherLst) {
	        						String ipcfutherstr = ipcfuther.getvalue();
	        						if(ipcfutherstr!=null) {
		        						String[] ipcfurtherTokens = ipcfutherstr.split("/");
		    	        				if(ipcfurtherTokens.length==2) {
		    	    	    				//patent.addIpcClassificationLevel();
		    	    						patent.addIpcSection(ipcfurtherTokens[0].substring(0,1));
		    	    						patent.addIpcClass(ipcfurtherTokens[0].substring(1,3));
		    	    						patent.addIpcSubclass(ipcfurtherTokens[0].substring(3,4));
		    	    						patent.addIpcMainGroup(ipcfurtherTokens[0].substring(4));
		    	    						patent.addIpcSubgroup(ipcfurtherTokens[1]);
		    	    						//patent.addIpcSymbolLevel();
		    	    						//patent.addIpcClassificationValue();
		    	        				}
	        						}
	        					}
	        				}
	        			}
	        		}
	        	}	        	
	        	else if(grantnode.getClass()==xml.us.patent.application.v40_041028.Abstract.class) { // get abstract
	        		xml.us.patent.application.v40_041028.Abstract abstr = (xml.us.patent.application.v40_041028.Abstract) grantnode;
	        		StringWriter sw = new StringWriter();
	        		marshaller.marshal(abstr, sw);
	        		patent.addAbstractParagraph(sw.toString().replaceAll("</.*?>|<[^>]*?/>", "").replaceAll("<.*?>", "\n"));
	        	}
	        	else if(grantnode.getClass()==xml.us.patent.application.v40_041028.Description.class) { // get description
	        		xml.us.patent.application.v40_041028.Description desc = (xml.us.patent.application.v40_041028.Description) grantnode;
	        		StringWriter sw = new StringWriter();
	        		marshaller.marshal(desc, sw);
	        		patent.addDescParagraph(sw.toString().replaceAll("</.*?>|<[^>]*?/>", "").replaceAll("<.*?>", "\n"));
	        	}			        	
	        	else if(grantnode.getClass()==xml.us.patent.application.v40_041028.Claims.class) { // get claims
	        		xml.us.patent.application.v40_041028.Claims claims = (xml.us.patent.application.v40_041028.Claims) grantnode;
	        		StringWriter sw = new StringWriter();
	        		marshaller.marshal(claims, sw);
	        		patent.addClaim(sw.toString().replaceAll("<claim id.*?>|</.*?>|<[^>]*?/>", "").replaceAll("<claim-ref.*?>|</claim-ref.*?>"," ").replaceAll("</claim-ref.*?>"," ").replaceAll("<.*?>", "\n"));
	        	}
	        }
	   } catch (ParserConfigurationException | SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JAXBException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return patent;
	}

	private static Patent parseApplicationv40_040415(String patentxml) {
		// TODO Auto-generated method stub
		Patent patent = new PatentApplication();
       	try {
			SAXParserFactory spf = SAXParserFactory.newInstance();
			SAXParser sp;
	
			sp = spf.newSAXParser();
	
			XMLReader xr = sp.getXMLReader();
       
	       // prase the xml according to its dtd version
	       JAXBContext jc = JAXBContext.newInstance("xml.us.patent.application.v40_040415");
	       Marshaller marshaller = jc.createMarshaller();	        
	       Unmarshaller unmarshaller = jc.createUnmarshaller();
	       UnmarshallerHandler unmarshallerHandler = unmarshaller.getUnmarshallerHandler();
	       xr.setContentHandler((ContentHandler) unmarshallerHandler);
	 
	        InputSource xmlSource = new InputSource(new StringReader(patentxml));
	        xr.parse(xmlSource);
	 
	        xml.us.patent.application.v40_040415.UsPatentApplication app = (xml.us.patent.application.v40_040415.UsPatentApplication) unmarshallerHandler.getResult();
	        
	        // extract patent data
	        List<Object> grantLst = app.getDocPageOrUsBibliographicDataApplicationOrAbstractOrDrawingsOrDescriptionOrSequenceListOrTableExternalRefOrUsChemistryOrUsMathOrClaims();
	        for(int i=0; i<grantLst.size(); i++) {
	        	Object grantnode = grantLst.get(i);
	        	if(grantnode.getClass()==xml.us.patent.application.v40_040415.UsBibliographicDataApplication.class) {
	        		xml.us.patent.application.v40_040415.UsBibliographicDataApplication usBibliographicDataApp = (xml.us.patent.application.v40_040415.UsBibliographicDataApplication) grantnode;
	        		
	        		// get publication reference
	        		xml.us.patent.application.v40_040415.PublicationReference publicationReference = usBibliographicDataApp.getPublicationReference();
	        		
	        		xml.us.patent.application.v40_040415.DocumentId docId = publicationReference.getDocumentId();
	        		patent.setPubDocNumber(docId.getDocNumber());
	        		patent.setPubCountry(docId.getCountry().getvalue());
	        		patent.setPubKind(docId.getKind());
	        		patent.setPubDate(docId.getDate().getvalue());
	        		
	        		xml.us.patent.application.v40_040415.InventionTitle inventionTitle = usBibliographicDataApp.getInventionTitle();
	        		patent.setTitle(inventionTitle.getvalue());
	        		
	        		// get application reference
	        		xml.us.patent.application.v40_040415.ApplicationReference applicationReference = usBibliographicDataApp.getApplicationReference();
	        		docId = applicationReference.getDocumentId();
	        		patent.setAppDocNumber(docId.getDocNumber());
	        		patent.setAppCountry(docId.getCountry().getvalue());
	        		patent.setAppDate(docId.getDate().getvalue());
	        		
	        		// get inventors
	        		xml.us.patent.application.v40_040415.Parties parties = usBibliographicDataApp.getParties();
	        		if(parties!=null) {
	        			xml.us.patent.application.v40_040415.Inventors inventors = parties.getInventors();
		        		if(inventors!=null) {
		        			List<Object> inventorsLst = inventors.getInventorOrDeceasedInventor();
		        			for(Object inventornode : inventorsLst) {
	        					if(inventornode.getClass()==xml.us.patent.application.v40_040415.Inventor.class) {
	        						xml.us.patent.application.v40_040415.Inventor inventor = (xml.us.patent.application.v40_040415.Inventor) inventornode;
	        						List<xml.us.patent.application.v40_040415.Addressbook> inventorAddressbook = inventor.getAddressbook();
	        						for(xml.us.patent.application.v40_040415.Addressbook inventorAddressbookDet : inventorAddressbook)
	        						{
	        							patent.addInventor(new AddrezzBook(inventorAddressbookDet));
	        						}				        					
		        				}
			        		}
		        		}
	        		}
	        		
	        		// get assignees
	        		xml.us.patent.application.v40_040415.Assignees assignees = usBibliographicDataApp.getAssignees();
	        		if(assignees!=null) {
		        		List<xml.us.patent.application.v40_040415.Assignee> assigneeLst = assignees.getAssignee();
		        		for(xml.us.patent.application.v40_040415.Assignee assigneeDet : assigneeLst) {
		        			patent.addAssignee(new AddrezzBook(assigneeDet));
		        		}
	        		}
	        		
	        		// get US classification
	        		xml.us.patent.application.v40_040415.ClassificationNational usClassification = usBibliographicDataApp.getClassificationNational();
	        		if(usClassification!=null) {
		        		patent.setMainClassification(usClassification.getMainClassification());
		        		
		        		List<xml.us.patent.application.v40_040415.FurtherClassification> furtherClassifications = usClassification.getFurtherClassification();
		        		if(furtherClassifications!=null) {
		        			for(xml.us.patent.application.v40_040415.FurtherClassification furtherClassification : furtherClassifications) {
		        				patent.addfurtherClassification(furtherClassification.getvalue());
		        			}
		        		}
	        		}
	        	}	        	
	        	else if(grantnode.getClass()==xml.us.patent.application.v40_040415.Abstract.class) { // get abstract
	        		xml.us.patent.application.v40_040415.Abstract abstr = (xml.us.patent.application.v40_040415.Abstract) grantnode;
	        		StringWriter sw = new StringWriter();
	        		marshaller.marshal(abstr, sw);
	        		patent.addAbstractParagraph(sw.toString().replaceAll("</.*?>|<[^>]*?/>", "").replaceAll("<.*?>", "\n"));
	        	}
	        	else if(grantnode.getClass()==xml.us.patent.application.v40_040415.Description.class) { // get description
	        		xml.us.patent.application.v40_040415.Description desc = (xml.us.patent.application.v40_040415.Description) grantnode;
	        		StringWriter sw = new StringWriter();
	        		marshaller.marshal(desc, sw);
	        		patent.addDescParagraph(sw.toString().replaceAll("</.*?>|<[^>]*?/>", "").replaceAll("<.*?>", "\n"));
	        	}			        	
	        	else if(grantnode.getClass()==xml.us.patent.application.v40_040415.Claims.class) { // get claims
	        		xml.us.patent.application.v40_040415.Claims claims = (xml.us.patent.application.v40_040415.Claims) grantnode;
	        		StringWriter sw = new StringWriter();
	        		marshaller.marshal(claims, sw);
	        		patent.addClaim(sw.toString().replaceAll("<claim id.*?>|</.*?>|<[^>]*?/>", "").replaceAll("<claim-ref.*?>|</claim-ref.*?>"," ").replaceAll("</claim-ref.*?>"," ").replaceAll("<.*?>", "\n"));
	        	}
	        }
	   } catch (ParserConfigurationException | SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JAXBException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return patent;
	}
	
	private static Patent parseGrantv25(String patentxml) {
		// TODO Auto-generated method stub
		PatentGrant patent = new PatentGrant();
        
    	try {
			SAXParserFactory spf = SAXParserFactory.newInstance();
			SAXParser sp;
	
			sp = spf.newSAXParser();
	
			XMLReader xr = sp.getXMLReader();			
	       // prase the xml according to its dtd version
	       JAXBContext jc = JAXBContext.newInstance("xml.us.patent.grant.vST32_025xml");
	       Marshaller marshaller = jc.createMarshaller();
	       Unmarshaller unmarshaller = jc.createUnmarshaller();
	       UnmarshallerHandler unmarshallerHandler = unmarshaller.getUnmarshallerHandler();
	       xr.setContentHandler((ContentHandler) unmarshallerHandler);
	 
	        InputSource xmlSource = new InputSource(new StringReader(patentxml));
	        xr.parse(xmlSource);
	 
	        xml.us.patent.grant.vST32_025xml.PATDOC patdoc = (xml.us.patent.grant.vST32_025xml.PATDOC)unmarshallerHandler.getResult();
	        
	        // extract patent data
	        xml.us.patent.grant.vST32_025xml.SDOBI bibliographicInformation = patdoc.getSDOBI();
	        xml.us.patent.grant.vST32_025xml.B100 documentIdentification = bibliographicInformation.getB100();
	        xml.us.patent.grant.vST32_025xml.B110 documentNumber = documentIdentification.getB110();
	        patent.setPubDocNumber(documentNumber.getDNUM().getPDAT().getvalue());
	        
	        patent.setPubKind(documentIdentification.getB130().getPDAT().getvalue());	        
    		patent.setPubDate(documentIdentification.getB140().getDATE().getPDAT().getvalue());
    		patent.setPubCountry(documentIdentification.getB190().getPDAT().getvalue());
    		    		
    		xml.us.patent.grant.vST32_025xml.B200 domesticFilingData = bibliographicInformation.getB200();
    		patent.setAppDocNumber(domesticFilingData.getB210().getDNUM().getPDAT().getvalue());
    		patent.setAppDate(domesticFilingData.getB220().getDATE().getPDAT().getvalue());
    		patent.setAppCountry(patent.getPubCountry());    		
    		
	        xml.us.patent.grant.vST32_025xml.B500 technicalInformation = bibliographicInformation.getB500();
	        xml.us.patent.grant.vST32_025xml.B540 title = technicalInformation.getB540();
	        List<Object> titleLst = title.getSTEXT().get(0).getPDATOrFOrFOROrIMGOrHILOrCWU();
	        for(Object titlenode : titleLst) {
	        	if(titlenode.getClass()==xml.us.patent.grant.vST32_025xml.PDAT.class) {
	        		patent.setTitle(((xml.us.patent.grant.vST32_025xml.PDAT)titlenode).getvalue());
	        	}
	        }
	        
	        // get US classification
    		xml.us.patent.grant.vST32_025xml.B520 usClassification = technicalInformation.getB520();
    		patent.setMainClassification(usClassification.getB521().getPDAT().getvalue());
    		
    		List<xml.us.patent.grant.vST32_025xml.B522> furtherClassifications = usClassification.getB522();
    		if(furtherClassifications!=null) {
    			for(xml.us.patent.grant.vST32_025xml.B522 furtherClassification : furtherClassifications) {
    				patent.addfurtherClassification(furtherClassification.getPDAT().getvalue());
    			}
    		}
    		
    		// get ipc classification
    		xml.us.patent.grant.vST32_025xml.B510 ipcs = technicalInformation.getB510();
    		if(ipcs!=null) {
    			xml.us.patent.grant.vST32_025xml.B511 ipcmain = ipcs.getB511();
    			if(ipcmain!=null) {
    				String ipcstr = ipcmain.getPDAT().getvalue().replace(" ", "").replace("/", "");
    				if(ipcstr.length()>=7) {
	    				//patent.addIpcClassificationLevel();
						patent.addIpcSection(ipcstr.substring(0,1));
						patent.addIpcClass(ipcstr.substring(1,3));
						patent.addIpcSubclass(ipcstr.substring(3,4));
						String tmp = ipcstr.substring(4);
						if(tmp.length()>=3) {
							patent.addIpcSubgroup(tmp.substring(tmp.length()-2));
							patent.addIpcMainGroup(tmp.substring(0,tmp.length()-2));
							//patent.addIpcSymbolLevel();
							//patent.addIpcClassificationValue();
						}
						else {
							patent.addIpcSubgroup("");
							patent.addIpcMainGroup("");
						}
    				}
    			}
    			
    			List<xml.us.patent.grant.vST32_025xml.B512> ipcothers = ipcs.getB512();
    			if(ipcothers!=null) {
    				for(xml.us.patent.grant.vST32_025xml.B512 ipcother : ipcothers) {
    					String ipcstr = ipcother.getPDAT().getvalue().replace(" ", "").replace("/", "");
        				if(ipcstr.length()>=7) {
    	    				//patent.addIpcClassificationLevel();
    						patent.addIpcSection(ipcstr.substring(0,1));
    						patent.addIpcClass(ipcstr.substring(1,3));
    						patent.addIpcSubclass(ipcstr.substring(3,4));
    						String tmp = ipcstr.substring(4);
    						if(tmp.length()>=3) {
    							patent.addIpcSubgroup(tmp.substring(tmp.length()-2));
    							patent.addIpcMainGroup(tmp.substring(0,tmp.length()-2));
    							//patent.addIpcSymbolLevel();
    							//patent.addIpcClassificationValue();
    						}
    						else {
    							patent.addIpcSubgroup("");
    							patent.addIpcMainGroup("");
    						}
        				}
    				}
    			}
    		}
    		
    		xml.us.patent.grant.vST32_025xml.B700 parties = bibliographicInformation.getB700();
    		if(parties!=null) {
    			// get inventors        		
    			xml.us.patent.grant.vST32_025xml.B720 inventors = parties.getB720();
        		if(inventors!=null) {
        			List<xml.us.patent.grant.vST32_025xml.B721> inventorsLst = inventors.getB721();
        			for(xml.us.patent.grant.vST32_025xml.B721 inventor : inventorsLst) {
        				xml.us.patent.grant.vST32_025xml.PARTYUS inventorDet = inventor.getPARTYUS();
        				if(inventorDet!=null) {
    						patent.addInventor(new AddrezzBook(inventorDet));
        				}
        			}
        		}
        		
        		// get assignees    		
    			List<xml.us.patent.grant.vST32_025xml.B730> assignees = parties.getB730();
        		if(assignees!=null) {
        			for (xml.us.patent.grant.vST32_025xml.B730 assignee : assignees){
        				List<Object> lst = assignee.getB731OrB732US();
	        			if(lst!=null) {
	        				for(Object node : lst) {
		        				if(node.getClass()==xml.us.patent.grant.vST32_025xml.B731.class) {
		        					xml.us.patent.grant.vST32_025xml.PARTYUS assigneeDet = ((xml.us.patent.grant.vST32_025xml.B731)node).getPARTYUS();
		        					if(assignee!=null) {
		        						patent.addAssignee(new AddrezzBook(assigneeDet));
		        					}
		        				}
	        				}
	        			}
        			}
        		}
    		
    		}
    		
    		// get abstract
    		xml.us.patent.grant.vST32_025xml.SDOAB abstr = patdoc.getSDOAB();
    		if(abstr!=null) {
        		StringWriter sw = new StringWriter();
        		marshaller.marshal(abstr, sw);
   				patent.addAbstractParagraph(sw.toString().replaceAll("</.*?>|<[^>]*?/>", "").replaceAll("<.*?>", "\n"));
    		}
    		
    		// get description
    		xml.us.patent.grant.vST32_025xml.SDODE descr = patdoc.getSDODE();
    		if(descr!=null) {
        		StringWriter sw = new StringWriter();
        		marshaller.marshal(descr, sw);
        		patent.addDescParagraph(sw.toString().replaceAll("</.*?>|<[^>]*?/>", "").replaceAll("<.*?>", "\n"));
    		}
    		
    		// get claims
    		xml.us.patent.grant.vST32_025xml.SDOCL claims = patdoc.getSDOCL();
    		if(claims!=null) {
        		StringWriter sw = new StringWriter();
        		marshaller.marshal(claims, sw);
        		patent.addClaim(sw.toString().replaceAll("<claim id.*?>|</.*?>|<[^>]*?/>", "").replaceAll("<claim-ref.*?>|</claim-ref.*?>"," ").replaceAll("</claim-ref.*?>"," ").replaceAll("<.*?>", "\n"));
    		}    		
	   } catch (ParserConfigurationException | SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JAXBException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return patent;
	}

	private static Patent parseGrantv24(String patentxml) {
		// TODO Auto-generated method stub
		/*2001 patents*/
		patentxml = patentxml.replaceAll("<B597US>","<B597US/>").replaceAll("<CITED-BY-EXAMINER>", "<CITED-BY-EXAMINER/>").replaceAll("<CITED-BY-OTHER>", "<CITED-BY-OTHER/>").replaceAll("<EMI ID=.*?", "");
		PatentGrant patent = new PatentGrant();
        
    	try {
			SAXParserFactory spf = SAXParserFactory.newInstance();
			SAXParser sp;
	
			sp = spf.newSAXParser();
	
			XMLReader xr = sp.getXMLReader();			
	       // prase the xml according to its dtd version
	       JAXBContext jc = JAXBContext.newInstance("xml.us.patent.grant.vST32_024");
	       Marshaller marshaller = jc.createMarshaller();
	       Unmarshaller unmarshaller = jc.createUnmarshaller();
	       UnmarshallerHandler unmarshallerHandler = unmarshaller.getUnmarshallerHandler();
	       xr.setContentHandler((ContentHandler) unmarshallerHandler);
	 
	        InputSource xmlSource = new InputSource(new StringReader(patentxml));
	        xr.parse(xmlSource);
	 
	        xml.us.patent.grant.vST32_024.PATDOC patdoc = (xml.us.patent.grant.vST32_024.PATDOC)unmarshallerHandler.getResult();
	        
	        // extract patent data
	        xml.us.patent.grant.vST32_024.SDOBI bibliographicInformation = patdoc.getSDOBI();
	        xml.us.patent.grant.vST32_024.B100 documentIdentification = bibliographicInformation.getB100();
	        xml.us.patent.grant.vST32_024.B110 documentNumber = documentIdentification.getB110();
	        patent.setPubDocNumber(documentNumber.getDNUM().getPDAT().getvalue());
	        
	        patent.setPubKind(documentIdentification.getB130().getPDAT().getvalue());	        
    		patent.setPubDate(documentIdentification.getB140().getDATE().getPDAT().getvalue());
    		patent.setPubCountry(documentIdentification.getB190().getPDAT().getvalue());
    		    		
    		xml.us.patent.grant.vST32_024.B200 domesticFilingData = bibliographicInformation.getB200();
    		patent.setAppDocNumber(domesticFilingData.getB210().getDNUM().getPDAT().getvalue());
    		patent.setAppDate(domesticFilingData.getB220().getDATE().getPDAT().getvalue());
    		patent.setAppCountry(patent.getPubCountry());    		
    		
	        xml.us.patent.grant.vST32_024.B500 technicalInformation = bibliographicInformation.getB500();
	        xml.us.patent.grant.vST32_024.B540 title = technicalInformation.getB540();
	        List<Object> titleLst = title.getSTEXT().get(0).getPDATOrFOrFOROrIMGOrHILOrCWU();
	        for(Object titlenode : titleLst) {
	        	if(titlenode.getClass()==xml.us.patent.grant.vST32_024.PDAT.class) {
	        		patent.setTitle(((xml.us.patent.grant.vST32_024.PDAT)titlenode).getvalue());
	        	}
	        }
	        
	        // get US classification
    		xml.us.patent.grant.vST32_024.B520 usClassification = technicalInformation.getB520();
    		patent.setMainClassification(usClassification.getB521().getPDAT().getvalue());
    		
    		List<xml.us.patent.grant.vST32_024.B522> furtherClassifications = usClassification.getB522();
    		if(furtherClassifications!=null) {
    			for(xml.us.patent.grant.vST32_024.B522 furtherClassification : furtherClassifications) {
    				patent.addfurtherClassification(furtherClassification.getPDAT().getvalue());
    			}
    		}
    		
    		// get ipc classification
    		xml.us.patent.grant.vST32_024.B510 ipcs = technicalInformation.getB510();
    		if(ipcs!=null) {
    			xml.us.patent.grant.vST32_024.B511 ipcmain = ipcs.getB511();
    			if(ipcmain!=null) {
    				String ipcstr = ipcmain.getPDAT().getvalue().replace(" ", "").replace("/", "");
    				if(ipcstr.length()>=7) {
	    				//patent.addIpcClassificationLevel();
						patent.addIpcSection(ipcstr.substring(0,1));
						patent.addIpcClass(ipcstr.substring(1,3));
						patent.addIpcSubclass(ipcstr.substring(3,4));
						String tmp = ipcstr.substring(4);
						if(tmp.length()>=3) {
							patent.addIpcSubgroup(tmp.substring(tmp.length()-2));
							patent.addIpcMainGroup(tmp.substring(0,tmp.length()-2));
							//patent.addIpcSymbolLevel();
							//patent.addIpcClassificationValue();
						}
						else {
							patent.addIpcSubgroup("");
							patent.addIpcMainGroup("");
						}
    				}
    			}
    			
    			List<xml.us.patent.grant.vST32_024.B512> ipcothers = ipcs.getB512();
    			if(ipcothers!=null) {
    				for(xml.us.patent.grant.vST32_024.B512 ipcother : ipcothers) {
    					String ipcstr = ipcother.getPDAT().getvalue().replace(" ", "").replace("/", "");
        				if(ipcstr.length()>=7) {
    	    				//patent.addIpcClassificationLevel();
    						patent.addIpcSection(ipcstr.substring(0,1));
    						patent.addIpcClass(ipcstr.substring(1,3));
    						patent.addIpcSubclass(ipcstr.substring(3,4));
    						String tmp = ipcstr.substring(4);
    						if(tmp.length()>=3) {
    							patent.addIpcSubgroup(tmp.substring(tmp.length()-2));
    							patent.addIpcMainGroup(tmp.substring(0,tmp.length()-2));
    							//patent.addIpcSymbolLevel();
    							//patent.addIpcClassificationValue();
    						}
    						else {
    							patent.addIpcSubgroup("");
    							patent.addIpcMainGroup("");
    						}
        				}
    				}
    			}
    		}
    		
    		xml.us.patent.grant.vST32_024.B700 parties = bibliographicInformation.getB700();
    		if(parties!=null) {
    			// get inventors        		
    			xml.us.patent.grant.vST32_024.B720 inventors = parties.getB720();
        		if(inventors!=null) {
        			List<xml.us.patent.grant.vST32_024.B721> inventorsLst = inventors.getB721();
        			for(xml.us.patent.grant.vST32_024.B721 inventor : inventorsLst) {
        				xml.us.patent.grant.vST32_024.PARTYUS inventorDet = inventor.getPARTYUS();
        				if(inventorDet!=null) {
    						patent.addInventor(new AddrezzBook(inventorDet));
        				}
        			}
        		}
        		
        		// get assignees    		
    			List<xml.us.patent.grant.vST32_024.B730> assignees = parties.getB730();
        		if(assignees!=null) {
        			for (xml.us.patent.grant.vST32_024.B730 assignee : assignees){
        				List<Object> lst = assignee.getB731OrB732US();
	        			if(lst!=null) {
	        				for(Object node : lst) {
		        				if(node.getClass()==xml.us.patent.grant.vST32_024.B731.class) {
		        					xml.us.patent.grant.vST32_024.PARTYUS assigneeDet = ((xml.us.patent.grant.vST32_024.B731)node).getPARTYUS();
		        					if(assignee!=null) {
		        						patent.addAssignee(new AddrezzBook(assigneeDet));
		        					}
		        				}
	        				}
	        			}
        			}
        		}
    		
    		}
    		
    		// get abstract
    		xml.us.patent.grant.vST32_024.SDOAB abstr = patdoc.getSDOAB();
    		if(abstr!=null) {
        		StringWriter sw = new StringWriter();
        		marshaller.marshal(abstr, sw);
   				patent.addAbstractParagraph(sw.toString().replaceAll("</.*?>|<[^>]*?/>", "").replaceAll("<.*?>", "\n"));
    		}
    		
    		// get description
    		xml.us.patent.grant.vST32_024.SDODE descr = patdoc.getSDODE();
    		if(descr!=null) {
        		StringWriter sw = new StringWriter();
        		marshaller.marshal(descr, sw);
        		patent.addDescParagraph(sw.toString().replaceAll("</.*?>|<[^>]*?/>", "").replaceAll("<.*?>", "\n"));
    		}
    		
    		// get claims
    		xml.us.patent.grant.vST32_024.SDOCL claims = patdoc.getSDOCL();
    		if(claims!=null) {
        		StringWriter sw = new StringWriter();
        		marshaller.marshal(claims, sw);
        		patent.addClaim(sw.toString().replaceAll("<claim id.*?>|</.*?>|<[^>]*?/>", "").replaceAll("<claim-ref.*?>|</claim-ref.*?>"," ").replaceAll("</claim-ref.*?>"," ").replaceAll("<.*?>", "\n"));
    		}    		
	   } catch (ParserConfigurationException | SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JAXBException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return patent;
	}


	public static String transform1(String patentxml) throws ParserConfigurationException, SAXException, IOException {
		   DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		   Document doc = db.parse(patentxml);
		   NodeList l = doc.getElementsByTagName("doc-number");
		   if(l!=null) {
			   for(int i=0; i<l.getLength(); i++) {
				   System.out.println(l.item(i).getNodeName());
				   System.out.println(l.item(i).getNodeValue());
				   System.out.println(l.item(i).getTextContent()+"\n\n");			   
			   }
		   }
		   
		   
		   /*
		    db.setEntityResolver(new EntityResolver() {
	    @Override
	    public InputSource resolveEntity(String publicId, String systemId)
	            throws SAXException, IOException {
	        if (systemId.contains("schema.dtd")) {
	            return new InputSource(new FileReader("/path/to/schema.dtd"));
	        } else {
	            return null;
	        }
	    }
	});
	return new InputSource(Foo.class.getResourceAsStream("schema.dtd"));
		    */

		   return "";
	   }
	   
	}

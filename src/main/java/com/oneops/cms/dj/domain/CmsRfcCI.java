package com.oneops.cms.dj.domain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * The Class CmsRfcCI.
 */
public class CmsRfcCI extends CmsRfcCIBasic  implements Serializable{

	private static final long serialVersionUID = 1L;

	private long nsId;
	private int ciClassId;
	private int rfcActionId;
	private String releaseNsPath;
	private Map<String,CmsRfcAttribute> attributes = new HashMap<String,CmsRfcAttribute>();
	
	/**
	 * Gets the release ns path.
	 *
	 * @return the release ns path
	 */
	public String getReleaseNsPath() {
		return releaseNsPath;
	}
	
	/**
	 * Sets the release ns path.
	 *
	 * @param releaseNsPath the new release ns path
	 */
	public void setReleaseNsPath(String releaseNsPath) {
		this.releaseNsPath = releaseNsPath;
	}
	
	/**
	 * Gets the ns id.
	 *
	 * @return the ns id
	 */
	public long getNsId() {
		return nsId;
	}
	
	/**
	 * Sets the ns id.
	 *
	 * @param nsId the new ns id
	 */
	public void setNsId(long nsId) {
		this.nsId = nsId;
	}
	
	/**
	 * Gets the ci class id.
	 *
	 * @return the ci class id
	 */
	public int getCiClassId() {
		return ciClassId;
	}
	
	/**
	 * Sets the ci class id.
	 *
	 * @param ciClassId the new ci class id
	 */
	public void setCiClassId(int ciClassId) {
		this.ciClassId = ciClassId;
	}
	
	/**
	 * Gets the rfc action id.
	 *
	 * @return the rfc action id
	 */
	public int getRfcActionId() {
		return rfcActionId;
	}
	
	/**
	 * Sets the rfc action id.
	 *
	 * @param rfcActionId the new rfc action id
	 */
	public void setRfcActionId(int rfcActionId) {
		this.rfcActionId = rfcActionId;
	}
	
	/**
	 * Gets the attribute.
	 *
	 * @param attributeName the attribute name
	 * @return the attribute
	 */
	public CmsRfcAttribute getAttribute(String attributeName) {
		return this.attributes.get(attributeName);
	}
	
	/**
	 * Sets the attributes.
	 *
	 * @param attributes the attributes
	 */
	public void setAttributes(Map<String,CmsRfcAttribute> attributes) {
		this.attributes = attributes;
	}
	
	/**
	 * Gets the attributes.
	 *
	 * @return the attributes
	 */
	public Map<String,CmsRfcAttribute> getAttributes() {
		return attributes;
	}
	
	/**
	 * Adds the attribute.
	 *
	 * @param attribute the attribute
	 */
	public void addAttribute(CmsRfcAttribute attribute) {
		this.attributes.put(attribute.getAttributeName(), attribute);
	}

	/**
	 * Sets the ns path.
	 *
	 * @param nsPath the new ns path
	 */
	public void setNsPath(String nsPath) {
		super.setNsPath(nsPath);
		if (this.releaseNsPath == null) {
			//  /oneops/montest/mtest/bom/custom/1
			// Lets strip off platform parts for the release
			String[] nsParts = nsPath.split("/");
			String releaseNs = "";
			for (int i=1; i< nsParts.length; i++) {
				if (nsParts[i].equals("_design")) break;
				releaseNs += "/" + nsParts[i];
				if (nsParts[i].equals("bom")) break;
				if (nsParts[i].equals("manifest")) break;
			}
			this.releaseNsPath = releaseNs;
		}
	}
	
}
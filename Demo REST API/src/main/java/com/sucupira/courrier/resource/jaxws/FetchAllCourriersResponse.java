
package com.sucupira.courrier.resource.jaxws;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

// TODO: Auto-generated Javadoc
/**
 * The Class FetchAllCourriersResponse.
 */
@XmlRootElement(name = "fetchAllCourriersResponse", namespace = "http://resource.courrier.sucupira.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "fetchAllCourriersResponse", namespace = "http://resource.courrier.sucupira.com/")
public class FetchAllCourriersResponse {

    /** The return. */
    @XmlElement(name = "return", namespace = "")
    private List<com.sucupira.courrier.model.Courrier> _return;

    /**
     * Gets the return.
     *
     * @return     returns List<Courrier>
     */
    public List<com.sucupira.courrier.model.Courrier> getReturn() {
        return this._return;
    }

    /**
     * Sets the return.
     *
     * @param _return     the value for the _return property
     */
    public void setReturn(List<com.sucupira.courrier.model.Courrier> _return) {
        this._return = _return;
    }

}

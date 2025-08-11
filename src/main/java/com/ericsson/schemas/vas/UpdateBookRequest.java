
package com.ericsson.schemas.vas;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="bookName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="bookAuthor" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="bookEdition" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="bookPrice" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="bookAvailable" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "bookName",
    "bookAuthor",
    "bookEdition",
    "bookPrice",
    "bookAvailable"
})
@XmlRootElement(name = "updateBookRequest")
public class UpdateBookRequest {

    @XmlElement(required = true)
    protected String bookName;
    @XmlElement(required = true)
    protected String bookAuthor;
    protected int bookEdition;
    @XmlElement(required = true)
    protected BigDecimal bookPrice;
    protected boolean bookAvailable;

    /**
     * Gets the value of the bookName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBookName() {
        return bookName;
    }

    /**
     * Sets the value of the bookName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBookName(String value) {
        this.bookName = value;
    }

    /**
     * Gets the value of the bookAuthor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBookAuthor() {
        return bookAuthor;
    }

    /**
     * Sets the value of the bookAuthor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBookAuthor(String value) {
        this.bookAuthor = value;
    }

    /**
     * Gets the value of the bookEdition property.
     * 
     */
    public int getBookEdition() {
        return bookEdition;
    }

    /**
     * Sets the value of the bookEdition property.
     * 
     */
    public void setBookEdition(int value) {
        this.bookEdition = value;
    }

    /**
     * Gets the value of the bookPrice property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getBookPrice() {
        return bookPrice;
    }

    /**
     * Sets the value of the bookPrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setBookPrice(BigDecimal value) {
        this.bookPrice = value;
    }

    /**
     * Gets the value of the bookAvailable property.
     * 
     */
    public boolean isBookAvailable() {
        return bookAvailable;
    }

    /**
     * Sets the value of the bookAvailable property.
     * 
     */
    public void setBookAvailable(boolean value) {
        this.bookAvailable = value;
    }

}

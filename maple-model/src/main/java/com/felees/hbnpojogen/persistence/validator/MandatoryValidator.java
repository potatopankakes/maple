package com.felees.hbnpojogen.persistence.validator;


import java.io.Serializable;
import org.hibernate.validator.Validator;
import com.felees.hbnpojogen.persistence.validator.Mandatory;



/**
 * An HibernateValidator class for the &amp;Mandatory annotation. It ensures
 * that the value is not null. The &amp;NotNull and &amp;NotEmpty annotations
 * were not used because they will generate a
 * org.hibernate.PropertyValueException instead of an
 * org.hibernate.validator.InvalidStateException. The latter exceptions is
 * desired since it will provide an array of InvalidValue.
 * 
 * 
 * @author alexiaa
 * @version $Revision: 1$
 */
public class MandatoryValidator
        implements Validator<Mandatory>, Serializable {

    /**
     * Serial Version UID.
     */
    private static final long serialVersionUID = -4278995218315807547L;



    /**
     * 
     * {@inheritDoc}
     * 
     * @see org.hibernate.validator.Validator#initialize(java.lang.annotation.Annotation)
     */
   @SuppressWarnings("unused")
    public void initialize(Mandatory parameters) {
        // no parameters
    }



    /**
     * {@inheritDoc}
     * 
     * @see org.hibernate.validator.Validator#isValid(java.lang.Object)
     */
    public boolean isValid(Object value) {
        // if the value is null return false
        if (value == null) {
            return false;
        }
        // if the value is a String it checks its length
        if (value instanceof String) {
            String stringValue = (String) value;
            if (stringValue.trim().length() == 0) {
                return false;
            }
        }
        return true;
    }
}

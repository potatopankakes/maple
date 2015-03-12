package com.gnoras.maple.dal.model;

import com.felees.hbnpojogen.persistence.IPojoGenEntity;
import com.felees.hbnpojogen.persistence.validator.Mandatory;
import com.gnoras.maple.dal.model.PrivilegedGroup;
import com.gnoras.maple.dal.model.interfaces.IPrivilege;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.proxy.HibernateProxy;
import org.hibernate.validator.Length;
import org.hibernate.validator.Valid;


/** 
 * Object mapping for hibernate-handled table: privilege.
 * @author autogenerated
 */

@Entity
@Table(name = "privilege", catalog = "maple")
public class Privilege implements Cloneable, Serializable, IPojoGenEntity, IPrivilege {

	/** Serial Version UID. */
	private static final long serialVersionUID = -559024024L;
	/** Use a WeakHashMap so entries will be garbage collected once all entities 
		referring to a saved hash are garbage collected themselves. */
	private static final Map<Serializable, String> SAVED_HASHES =
		Collections.synchronizedMap(new WeakHashMap<Serializable, String>());
	
	/** hashCode temporary storage. */
	private volatile String hashCode;
	

	/** Field mapping. */
	private String description;
	/** Field mapping. */
	private String id;
	/** Field mapping. */
	private String name;
	/** Field mapping. */
	private Set<PrivilegedGroup> privilegedGroups = new HashSet<PrivilegedGroup>();

	/**
	 * Default constructor, mainly for hibernate use.
	 */
	public Privilege() {
		// Default constructor
	} 

	/** Constructor taking a given ID.
	 * @param id to set
	 */
	public Privilege(String id) {
		this.id = id;
	}
	
	/** Constructor taking a given ID.
	 * @param description String object;
	 * @param id String object;
	 * @param name String object;
	 */
	public Privilege(String description, String id, String name) {

		this.description = description;
		this.id = id;
		this.name = name;
	}
	
 


 
	/** Return the type of this class. Useful for when dealing with proxies.
	* @return Defining class.
	*/
	@Transient
	public Class<?> getClassType() {
		return Privilege.class;
	}
 

    /**
     * Return the value associated with the column: description.
	 * @return A String object (this.description)
	 */
	@Mandatory
	@Length(max=250)
	@Column( length = 250  )
	public String getDescription() {
		return this.description;
		
	}
	

  
    /**  
     * Set the value related to the column: description.
	 * @param description the description value you wish to set
	 */
	public void setDescription(final String description) {
		this.description = description;
	}

    /**
     * Return the value associated with the column: id.
	 * @return A String object (this.id)
	 */
    @Id 
	@Mandatory
	@Length(max=36)
	@Column( name = "id", length = 36  )
	public String getId() {
		return this.id;
		
	}
	

  
    /**  
     * Set the value related to the column: id.
	 * @param id the id value you wish to set
	 */
	public void setId(final String id) {
		// If we've just been persisted and hashCode has been
		// returned then make sure other entities with this
		// ID return the already returned hash code
		if ( (this.id == null ) &&
				(id != null) &&
				(this.hashCode != null) ) {
			SAVED_HASHES.put( id, this.hashCode );
		}
		this.id = id;
	}

    /**
     * Return the value associated with the column: name.
	 * @return A String object (this.name)
	 */
	@Mandatory
	@Length(max=50)
	@Column( length = 50  )
	public String getName() {
		return this.name;
		
	}
	

  
    /**  
     * Set the value related to the column: name.
	 * @param name the name value you wish to set
	 */
	public void setName(final String name) {
		this.name = name;
	}

    /**
     * Return the value associated with the column: privilegedGroup.
	 * @return A Set&lt;PrivilegedGroup&gt; object (this.privilegedGroup)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "privilege"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Valid
	public Set<PrivilegedGroup> getPrivilegedGroups() {
		return this.privilegedGroups;
		
	}
	
	/**
	 * Adds a bi-directional link of type PrivilegedGroup to the privilegedGroups set.
	 * @param privilegedGroup item to add
	 */
	public void addPrivilegedGroup(PrivilegedGroup privilegedGroup) {
		privilegedGroup.setPrivilege(this);
		this.privilegedGroups.add(privilegedGroup);
	}

  
    /**  
     * Set the value related to the column: privilegedGroup.
	 * @param privilegedGroup the privilegedGroup value you wish to set
	 */
	public void setPrivilegedGroups(final Set<PrivilegedGroup> privilegedGroup) {
		this.privilegedGroups = privilegedGroup;
	}


   /**
    * Deep copy.
	* @return cloned object
	* @throws CloneNotSupportedException on error
    */
    @Override
    public Privilege clone() throws CloneNotSupportedException {
		super.clone();  // keep hierarchy
        final Privilege copy = new Privilege();

		copy.setDescription(this.getDescription());
		copy.setId(this.getId());
		copy.setName(this.getName());
		if (this.getPrivilegedGroups() != null) {
			copy.getPrivilegedGroups().addAll(this.getPrivilegedGroups());
		}
		return copy;
	}
	
 
	


	/** Provides toString implementation.
	 * @see java.lang.Object#toString()
	 * @return String representation of this class.
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("description: " + this.getDescription() + ", ");
		sb.append("id: " + this.getId() + ", ");
		sb.append("name: " + this.getName() + ", ");
		return sb.toString();		
	}


	/** Equals implementation. 
	 * @see java.lang.Object#equals(java.lang.Object)
	 * @param aThat Object to compare with
	 * @return true/false
	 */
	@Override
	public boolean equals(final Object aThat) {
		Object proxyThat = aThat;
		
		if ( this == aThat ) {
			 return true;
		}

		
		if (aThat instanceof HibernateProxy) {
 			// narrow down the proxy to the class we are dealing with.
 			try {
				proxyThat = ((HibernateProxy) aThat).getHibernateLazyInitializer().getImplementation(); 
			} catch (org.hibernate.ObjectNotFoundException e) {
				return false;
		   	}
		}
		if (aThat == null)  {
			 return false;
		}
		
		final Privilege that; 
		try {
			that = (Privilege) proxyThat;
			if ( !(that.getClassType().equals(this.getClassType()))){
				return false;
			}
		} catch (org.hibernate.ObjectNotFoundException e) {
				return false;
		} catch (ClassCastException e) {
				return false;
		}
		
		
		boolean result = true;
		result = result && (((this.getId() == null) && ( that.getId() == null)) || (this.getId() != null  && this.getId().equals(that.getId())));
		result = result && (((getDescription() == null) && (that.getDescription() == null)) || (getDescription() != null && getDescription().equals(that.getDescription())));
		result = result && (((getName() == null) && (that.getName() == null)) || (getName() != null && getName().equals(that.getName())));
		return result;
	}
	
	
	/** Calculate the hashcode.
	 * @see java.lang.Object#hashCode()
	 * @return a calculated number
	 */
	@Override
	public int hashCode() {
		if ( this.hashCode == null ) {
			synchronized ( this ) {
				if ( this.hashCode == null ) {
					String newHashCode = null;

					if ( getId() != null ) {
						newHashCode = SAVED_HASHES.get( getId() );
					}
					
					if ( newHashCode == null ) {
						if ( getId() != null ) {
							newHashCode = getId();
						} else {
						newHashCode = String.valueOf(super.hashCode());

						}
					}
					
					this.hashCode = newHashCode;
				}
			}
		}
	return this.hashCode.hashCode();
	}
	
	

	
}
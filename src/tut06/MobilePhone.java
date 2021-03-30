package tut06;

import utils.AttrRef;
import utils.DOpt;
import utils.DomainConstraint;
import utils.NotPossibleException;
import utils.OptType;

/**
 * 
 * @author tranquyet
 * 
 * @overview represents mobile phone
 * 
 * @attributes <tt>
 * 
 *             manName String
 * 
 *             model String
 * 
 *             color Character char
 * 
 *             year Integer int
 * 
 *             guaranteed Boolean boolean <tt>
 * @object a typical MobilePhone is mob =<mn, m, c, y, g> where manName(mN),
 *         model(m), color(c), year(y), guaranteed(g)
 * @abstract properties <tt> mutable(manName) = F/\ optional(manName) =F/\
 *           length(manName)=8/\
 * 
 *           mutable(model) = F/\ optional(model) =F/\ length(model)=15/\
 * 
 *           mutable(color) = F/\ optional(color) =F/\length(color) =1/\
 * 
 *           mutable(year) = F/\ optional(year) =F/\ min(year)=1970/\
 * 
 *           mutable(guaranteed) = F/\ optional(guaranteed) =F/\ <tt>
 * 
 *
 */
public class MobilePhone {

	@DomainConstraint(type = "Integer", mutable = false, optional = false, length = 30)
	private String manName;

	@DomainConstraint(type = "String", mutable = false, optional = false, length = 15)
	private String model;

	@DomainConstraint(type = "Character", mutable = true, optional = false, length = 1)
	private char color;

	@DomainConstraint(type = "Integer", mutable = false, optional = false, min = 1970)
	private int year;

	@DomainConstraint(type = "Boolean", mutable = true, optional = false)
	private boolean guaranteed;

	@DOpt(type = OptType.Constructor)
	public MobilePhone(@AttrRef("manName") String manName, @AttrRef("model") String model, @AttrRef("color") char color,
			@AttrRef("year") int year, @AttrRef("guaranteed") boolean guarenteed) throws NotPossibleException {

	}

	/**
	 * 
	 * @effects return manName
	 */
	@DOpt(type = OptType.Observer)
	@AttrRef("manName")
	public String getManName() {
		return manName;
	}

	/**
	 * @effects
	 * 
	 *          <pre>
	 * if manName is valid
	 * 		set this.manName = manName
	 * 		return true
	 * else 
	 * 		return false
	 * 
	 *          </pre>
	 */
	@DOpt(type = OptType.Mutator)
	@AttrRef("manName")
	public boolean setManName(String manName) {
		if (validateManName(manName)) {
			this.manName = manName;
			return true;

		} else {
			return false;
		}
	}

	@DOpt(type = OptType.Observer)
	@AttrRef("model")
	public String getModel() {
		return model;
	}

	@DOpt(type = OptType.Mutator)
	@AttrRef("model")
	public boolean setModel(String model) {
		if (validateModel(model)) {
			this.model = model;
			return true;
		} else {
			return false;
		}
	}

}

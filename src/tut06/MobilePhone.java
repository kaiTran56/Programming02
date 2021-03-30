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
			@AttrRef("year") int year, @AttrRef("guaranteed") boolean guaranteed) throws NotPossibleException {
		if (!validateManName(manName)) {
			throw new NotPossibleException("MobilePhone.init: invalid mobile phone manName: " + manName);
		}
		if (!validateModel(model)) {
			throw new NotPossibleException("MobilePhone.init: invalid mobile phone model: " + model);
		}
		if (!validateColor(color)) {
			throw new NotPossibleException("MobilePhone.init: invalid mobile phone color: " + color);
		}
		if (!validateYear(year)) {
			throw new NotPossibleException("MobilePhone.init: invalid mobile phone year: " + year);
		}

		this.manName = manName;
		this.model = model;
		this.color = color;
		this.year = year;
		this.guaranteed = guaranteed;
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

	@DOpt(type = OptType.Observer)
	@AttrRef("color")
	public char getColor() {
		return color;
	}

	@DOpt(type = OptType.Mutator)
	@AttrRef("color")
	public boolean setColor(char color) {
		if (validateColor(color)) {
			this.color = color;
			return true;
		} else {
			return false;
		}
	}

	@DOpt(type = OptType.Observer)
	@AttrRef("year")
	public int getYear() {
		return year;
	}

	@DOpt(type = OptType.Mutator)
	@AttrRef("year")
	public boolean setYear(int year) {
		if (validateYear(year)) {
			this.year = year;
			return true;
		} else {
			return false;
		}
	}

	@DOpt(type = OptType.Observer)
	@AttrRef("guaranteed")
	public boolean getGuaranteed() {
		return guaranteed;
	}

	@DOpt(type = OptType.Mutator)
	@AttrRef("guaranteed")
	public boolean setGuaranteed(boolean guaranteed) {
		this.guaranteed = guaranteed;
		return true;
	}

	@DOpt(type = OptType.Helper)
	@AttrRef("manName")
	private boolean validateManName(String manName) {
		return manName != null && manName.length() <= 30;
	}

	@DOpt(type = OptType.Helper)
	@AttrRef("model")
	private boolean validateModel(String model) {
		return model != null && model.length() <= 15;
	}

	@DOpt(type = OptType.Helper)
	@AttrRef("color")
	private boolean validateColor(char color) {
		char[] validColor = { 'R', 'O', 'Y', 'B', 'P' };
		for (char temp : validColor) {
			if (color == temp) {
				return true;
			}
		}
		return false;
	}

	@DOpt(type = OptType.Helper)
	@AttrRef("year")
	private boolean validateYear(int year) {
		return year >= 1970;
	}

	@DOpt(type = OptType.Helper)
	public boolean repOk() {
		return validateColor(color) && validateManName(manName) && validateModel(model) && validateYear(year);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof MobilePhone)) {
			return false;
		} else {
			MobilePhone other = (MobilePhone) obj;
			return manName.equals(other.getManName()) && model.equals(other.getModel()) && year == other.getYear()
					&& color == other.getColor();
		}
	}

	@Override
	public String toString() {
		return "MobilePhone:<" + manName + ", " + model + ", " + color + ", " + year + ", guarannteed: " + guaranteed
				+ ">";
	}

}

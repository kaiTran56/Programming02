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

	public MobilePhone(@AttrRef("manName") String manName, @AttrRef("model") String model, @AttrRef("color") char color,
			@AttrRef("year") int year, @AttrRef("guaranteed") boolean guaranteed) throws NotPossibleException {

	}

	@DOpt(type = OptType.Observer)
	@AttrRef("manName")
	public String getManName() {
		return manName;
	}

	@DOpt(type = OptType.Mutator)
	@AttrRef("manName")
	public void setManName(String manName) {
		this.manName = manName;
	}

	@DOpt(type = OptType.Observer)
	@AttrRef("model")
	public String getModel() {
		return model;
	}

	@DOpt(type = OptType.Mutator)
	@AttrRef("model")
	public void setModel(String model) {
		this.model = model;
	}

	@DOpt(type = OptType.Observer)
	@AttrRef("color")
	public char getColor() {
		return color;
	}

	@DOpt(type = OptType.Mutator)
	@AttrRef("color")
	public void setColor(char color) {
		this.color = color;
	}

	@DOpt(type = OptType.Observer)
	@AttrRef("year")
	public int getYear() {
		return year;
	}

	@DOpt(type = OptType.Mutator)
	@AttrRef("year")
	public void setYear(int year) {
		this.year = year;
	}

	@DOpt(type = OptType.Observer)
	@AttrRef("guaranteed")
	public boolean isGuaranteed() {
		return guaranteed;
	}

	@DOpt(type = OptType.Mutator)
	@AttrRef("guaranteed")
	public void setGuaranteed(boolean guaranteed) {
		this.guaranteed = guaranteed;
	}

	@Override
	@DOpt(type = OptType.Default)
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	@Override
	@DOpt(type = OptType.Default)
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@DOpt(type = OptType.Helper)
	public boolean repOk() {
		return false;
	}

	@DOpt(type = OptType.Helper)
	@AttrRef("nmanName")
	private boolean validateManName(String manName) {
		return false;
	}

	@DOpt(type = OptType.Helper)
	@AttrRef("model")
	private boolean validateModel(String model) {
		return false;
	}

	@DOpt(type = OptType.Helper)
	@AttrRef("color")
	private boolean validateColor(char color) {
		return false;
	}

}

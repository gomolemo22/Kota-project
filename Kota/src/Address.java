
public class Address {
	private String address_line_1;
	private String city;
	private String PostalCode;
	private String province;
	private String country;
	private String iso;
	private boolean status;
	
	public String getStreet() {
		return address_line_1;
	}
	public void setStreet(String address_line_1) {
		this.address_line_1 = address_line_1;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPostalCode() {
		return PostalCode;
	}
	public void setPostalCode(String postalcode) {
		this.PostalCode = postalcode;
	}
	public String getCountry(){
		return country;
	}
	public void setCountry(String country){
		this.country = country;
	}
	public void setProvince(String province){
		this.province = province;
	}
	public String getProvince(){
		return province;
	}
	public void setISO(String iso){
		this.iso = iso;
	}
	public String getISO(){
		return iso;
	}
	public void setStatus(boolean status){
		this.status = status;
	}
	public boolean getStatus(){
		return status;
	}
}

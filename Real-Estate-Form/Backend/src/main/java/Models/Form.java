package Models;

public class Form {

    private String pdfName;
    private String name;
    private String surname;
    private String phone;
    private String whatsapp;
    private String email;
    private Boolean residence; // false default
    private Boolean visa; //false default
    private String nationality;
    private String moneyQuant;
    private String financeType;
    private String propertyType;
    private String floors;
    private String rooms;
    private String bathrooms;
    private String garages;
    private String constructionState;
    private String minConstructionYear;
    private String state;
    private String city;
    private String comunity;

    public Form(){ }
    public Form(String pdfName, String name, String surname, String phone, String whatsapp, String email, Boolean residence,
                Boolean visa, String nationality, String moneyQuant, String financeType, String propertyType,
                String floors, String rooms, String bathrooms, String garages, String constructionState,
                String minConstructionYear, String state, String city, String comunity) {
        this.pdfName = pdfName;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.whatsapp = whatsapp;
        this.email = email;
        this.residence = residence;
        this.visa = visa;
        this.nationality = nationality;
        this.moneyQuant = moneyQuant;
        this.financeType = financeType;
        this.propertyType = propertyType;
        this.floors = floors;
        this.rooms = rooms;
        this.bathrooms = bathrooms;
        this.garages = garages;
        this.constructionState = constructionState;
        this.minConstructionYear = minConstructionYear;
        this.state = state;
        this.city = city;
        this.comunity = comunity;
    }

    public String getComunity() {
        return comunity;
    }

    public void setComunity(String comunity) {
        this.comunity = comunity;
    }

    public String getPdfName() {
        return pdfName;
    }

    public void setPdfName(String pdfName) {
        this.pdfName = pdfName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(String whatsapp) {
        this.whatsapp = whatsapp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getResidence() {
        return residence;
    }

    public void setResidence(Boolean residence) {
        this.residence = residence;
    }

    public Boolean getVisa() {
        return visa;
    }

    public void setVisa(Boolean visa) {
        this.visa = visa;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getMoneyQuant() {
        return moneyQuant;
    }

    public void setMoneyQuant(String moneyQuant) {
        this.moneyQuant = moneyQuant;
    }

    public String getFinanceType() {
        return financeType;
    }

    public void setFinanceType(String financeType) {
        this.financeType = financeType;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public String getFloors() {
        return floors;
    }

    public void setFloors(String floors) {
        this.floors = floors;
    }

    public String getRooms() {
        return rooms;
    }

    public void setRooms(String rooms) {
        this.rooms = rooms;
    }

    public String getBathrooms() {
        return bathrooms;
    }

    public void setBathrooms(String bathrooms) {
        this.bathrooms = bathrooms;
    }

    public String getGarages() {
        return garages;
    }

    public void setGarages(String garages) {
        this.garages = garages;
    }

    public String getConstructionState() {
        return constructionState;
    }

    public void setConstructionState(String constructionState) {
        this.constructionState = constructionState;
    }

    public String getMinConstructionYear() {
        return minConstructionYear;
    }

    public void setMinConstructionYear(String minConstructionYear) {
        this.minConstructionYear = minConstructionYear;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}

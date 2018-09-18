
package database.project;

import DataBaseFun.Insurance;
import java.util.Date;
import javafx.beans.property.SimpleStringProperty;

public class Car_Spec {
    
   //Primary Info
   private SimpleStringProperty ReferenceKey;
   private SimpleStringProperty LicenseNo;
   private SimpleStringProperty ChassisNo;
   private SimpleStringProperty PlateNo;
   private SimpleStringProperty FuelType;
   private SimpleStringProperty EngineNo;
   //Car Spec
   private SimpleStringProperty Purchase;
   private SimpleStringProperty CarBrand;
   private SimpleStringProperty Model;
   private SimpleStringProperty ManufYear;
   private SimpleStringProperty NoOfDoors;
   private SimpleStringProperty LicCategory;
   private SimpleStringProperty PrevAccidents;
   //extra Info
   private SimpleStringProperty Weight;
   private SimpleStringProperty Power;
   private SimpleStringProperty Color;
   private SimpleStringProperty Alarm;
   private SimpleStringProperty Turbo;
   private SimpleStringProperty DOSI;
   private SimpleStringProperty DOEI;   
   private SimpleStringProperty InsuranceCost;
   
    public Car_Spec(String DOSI,String DOEI,String InsuranceCost,String ReferenceKey,String ChassisNo, String EngineNo, String PlateNo, String FuelType,String LicenseNo, 
            String Purchase, String CarBrand, String Model, String ManufYear, String NoOfDoors, String LicCategory,
            String PrevAccidents, String Weight, String Power,String Turbo, String Alarm, String Color
            ) 
    {
        this.DOSI=new SimpleStringProperty (DOSI);
        this.DOEI=new SimpleStringProperty (DOEI);
        this.ReferenceKey = new SimpleStringProperty (ReferenceKey);
        this.LicenseNo = new SimpleStringProperty (LicenseNo);
        this.ChassisNo = new SimpleStringProperty (ChassisNo);
        this.PlateNo = new SimpleStringProperty (PlateNo);
        this.FuelType = new SimpleStringProperty (FuelType);
        this.EngineNo = new SimpleStringProperty (EngineNo);
        this.Purchase = new SimpleStringProperty (Purchase);
        this.CarBrand = new SimpleStringProperty (CarBrand);
        this.Model = new SimpleStringProperty (Model);
        this.ManufYear = new SimpleStringProperty (ManufYear);
        this.NoOfDoors = new SimpleStringProperty (NoOfDoors);
        this.LicCategory = new SimpleStringProperty (LicCategory);
        this.PrevAccidents = new SimpleStringProperty (PrevAccidents);
        this.Weight = new SimpleStringProperty (Weight);
        this.Power = new SimpleStringProperty (Power);
        this.Color = new SimpleStringProperty (Color);
        this.Alarm = new SimpleStringProperty (Alarm);
        this.Turbo = new SimpleStringProperty (Turbo);
        //this.PassengersCovered = new SimpleStringProperty (PassengersCovered);
        this.InsuranceCost = new SimpleStringProperty (InsuranceCost);
    }

    public Car_Spec(Insurance insurance){
        
        this.DOSI=new SimpleStringProperty (insurance.getDOSI());
        this.DOEI=new SimpleStringProperty (insurance.getDOEI());
        this.ReferenceKey = new SimpleStringProperty (insurance.getRefKey());
        this.LicenseNo = new SimpleStringProperty (insurance.getLicenseNumber());
        this.ChassisNo = new SimpleStringProperty (insurance.getChassisNumber());
        this.PlateNo = new SimpleStringProperty (insurance.getPlateNumber());
        this.FuelType = new SimpleStringProperty (insurance.getFuelType());
        this.EngineNo = new SimpleStringProperty (insurance.getEnginId());
        this.Purchase = new SimpleStringProperty (insurance.getPurchase());
        this.CarBrand = new SimpleStringProperty (insurance.getCarBrand());
        this.Model = new SimpleStringProperty (insurance.getModelCar());
        this.ManufYear = new SimpleStringProperty (insurance.getManufYear()+"");
        this.NoOfDoors = new SimpleStringProperty (insurance.getNumberOfDoors()+"");
        this.LicCategory = new SimpleStringProperty (insurance.getLicCategory());
        this.PrevAccidents = new SimpleStringProperty (insurance.getPrevAccedents()+"");
        this.Weight = new SimpleStringProperty (insurance.getWeight()+"");
        this.Power = new SimpleStringProperty (insurance.getPower()+"");
        this.Color = new SimpleStringProperty (insurance.getColor());
        this.Alarm = new SimpleStringProperty (insurance.getFAlarm());
        this.Turbo = new SimpleStringProperty (insurance.getFTurbo()+"");
        // this.PassengersCovered = new SimpleStringProperty (PassengersCovered);
        this.InsuranceCost = new SimpleStringProperty (insurance.getInsCost()+"");
   
    }
           
        public Insurance getInsurance(){
            Insurance ins=new Insurance(DOSI.getValue(),DOEI.getValue(),Integer.parseInt(this.getInsuranceCost().getValue())
                    ,this.getReferenceKey().getValue()
            ,this.getChassisNo().getValue(),this.getEngineNo().getValue(),this.getPlateNo().getValue()
            ,this.getFuelType().getValue(),this.getLicenseNo().getValue(),this.getPurchase().getValue()
            ,this.getCarBrand().getValue(),this.getModel().getValue(),Integer.valueOf(this.getManufYear().getValue())
            ,Integer.valueOf(this.getNoOfDoors().getValue()),this.getLicCategory().getValue(),this.getPrevAccidents().getValue()
            ,Integer.valueOf(this.getWeight().getValue()),Integer.valueOf(this.getPower().getValue()),this.getTurbo().getValue(),this.getAlarm().getValue(),
                    this.getColor().getValue());
            ins.setDOSI(DOSI.getValue());
            ins.setDOSI(DOEI.getValue());
          return ins;
        }
      
    
 
    public SimpleStringProperty getReferenceKey() {
        return ReferenceKey;
    }
        
    public SimpleStringProperty getLicenseNo() {
        return LicenseNo;
    }

    public SimpleStringProperty getChassisNo() {
        return ChassisNo;
    }

    public SimpleStringProperty getPlateNo() {
        return PlateNo;
    }

    public SimpleStringProperty getFuelType() {
        return FuelType;
    }

    public SimpleStringProperty getEngineNo() {
        return EngineNo;
    }

    public SimpleStringProperty getPurchase() {
        return Purchase;
    }

    public SimpleStringProperty getCarBrand() {
        return CarBrand;
    }

    public SimpleStringProperty getModel() {
        return Model;
    }

    public SimpleStringProperty getManufYear() {
        return ManufYear;
    }

    public SimpleStringProperty getNoOfDoors() {
        return NoOfDoors;
    }

    public SimpleStringProperty getLicCategory() {
        return LicCategory;
    }

    public SimpleStringProperty getPrevAccidents() {
        return PrevAccidents;
    }

    public SimpleStringProperty getWeight() {
        return Weight;
    }

    public SimpleStringProperty getPower() {
        return Power;
    }

    public SimpleStringProperty getColor() {
        return Color;
    }

    public SimpleStringProperty getAlarm() {
        return Alarm;
    }

    public SimpleStringProperty getTurbo() {
        return Turbo;
    }
/*
    public SimpleStringProperty getPassengersCovered() {
        return PassengersCovered;
    }
*/
    public SimpleStringProperty getInsuranceCost() {
        return InsuranceCost;
    }
    
       public SimpleStringProperty getDOSI() {
        return DOSI;
    }
       
          public SimpleStringProperty getDOEI() {
        return DOEI;
    }
    public void setReferenceKey(String ReferenceKey) {
        this.ReferenceKey = new SimpleStringProperty (ReferenceKey);
    }

    public void setLicenseNo(String LicenseNo) {
        this.LicenseNo =new SimpleStringProperty ( LicenseNo);
    }

    public void setChassisNo(String ChassisNo) {
        this.ChassisNo =new SimpleStringProperty ( ChassisNo);
    }

    public void setPlateNo(String PlateNo) {
        this.PlateNo = new SimpleStringProperty (PlateNo);
    }

    public void setFuelType(String FuelType) {
        this.FuelType = new SimpleStringProperty (FuelType);
    }

    public void setEngineNo(String EngineNo) {
        this.EngineNo =new SimpleStringProperty ( EngineNo);
    }

    public void setPurchase(String Purchase) {
        this.Purchase = new SimpleStringProperty (Purchase);
    }

    public void setCarBrand(String CarBrand) {
        this.CarBrand = new SimpleStringProperty (CarBrand);
    }

    public void setModel(String Model) {
        this.Model = new SimpleStringProperty (Model);
    }

    public void setManufYear(String ManufYear) {
        this.ManufYear = new SimpleStringProperty (ManufYear);
    }

    public void setNoOfDoors(String NoOfDoors) {
        this.NoOfDoors = new SimpleStringProperty (NoOfDoors);
    }

    public void setLicCategory(String LicCategory) {
        this.LicCategory =new SimpleStringProperty ( LicCategory);
    }

    public void setPrevAccidents(String PrevAccidents) {
        this.PrevAccidents = new SimpleStringProperty (PrevAccidents);
    }

    public void setWeight(String Weight) {
        this.Weight =new SimpleStringProperty ( Weight);
    }

    public void setPower(String Power) {
        this.Power = new SimpleStringProperty (Power);
    }

    public void setColor(String Color) {
        this.Color =new SimpleStringProperty ( Color);
    }

    public void setAlarm(String Alarm) {
        this.Alarm = new SimpleStringProperty (Alarm);
    }

    public void setTurbo(String Turbo) {
        this.Turbo = new SimpleStringProperty (Turbo);
    }

    public void setDOSI(String DOSI) {
        this.DOSI = new SimpleStringProperty (DOSI);
    }

    public void setDOEI(String DOEI) {
        this.DOEI = new SimpleStringProperty (DOEI);
    }

    public void setInsuranceCost(String InsuranceCost) {
        this.InsuranceCost = new SimpleStringProperty (InsuranceCost);
    }

    
    
   
   
   
}

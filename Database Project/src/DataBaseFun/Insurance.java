
package DataBaseFun;

import java.util.Date;


public class Insurance
{
   
    private String DOSI;
    private String DOEI;
    private int InsCost=0;
    private String RefKey="";
    private String ChassisNumber="";
    private String EnginId="";
    private String PlateNumber="";       
    private String FuelType="";       
    private String LicenseNumber="";       
    private String Purchase="";      
    private String CarBrand="";       
    private String ModelCar="";       
    private int ManufYear=0;
    private int NumberOfDoors=0;
    private String LicCategory="";
    private String PrevAccedents="";
    private int Weight=0;
    private int Power=0;       
    private String FTurbo="";
    private String FAlarm="";            
    private String Color;     
    
    
    public Insurance(String dosi,String doei,int inscost,String refkey
            ,String chassisnumber,String enginid,String platenumber
            ,String fueltype,String licensenumber,String purchase
            ,String carbrand,String modelcar,int manufyear
            ,int numberofdoors,String liccategory,String prevaccedents
            ,int weight,int power,String fturbo,String falarm,String color)
    {
        DOSI=dosi;
        Purchase=purchase;
        CarBrand=carbrand;
        DOEI=doei;
        InsCost=inscost;
        RefKey=refkey;
        ChassisNumber=chassisnumber;
        EnginId=enginid;
        PlateNumber=platenumber;
        FuelType=fueltype;
        LicCategory=liccategory;
        LicenseNumber=licensenumber;
        PrevAccedents=prevaccedents;
        Weight=weight;
        Power=power;
        ModelCar=modelcar;
        FTurbo=fturbo;
        FAlarm=falarm;
        ManufYear=manufyear;
        NumberOfDoors=numberofdoors;
        Color=color;
    }
    
    public String getDOSI() {
        return DOSI;
    }

    public void setDOSI(String DOSI) {
        this.DOSI = DOSI;
    }

    public String getDOEI() {
        return DOEI;
    }
    public void setDOEI(String DOEI) {
        this.DOEI = DOEI;
    }

    public int getInsCost() {
        return InsCost;
    }

    public String getStringOfDOSI(){
        if(DOSI!=null)
        {
            System.out.println(DOSI.toString());
    return (DOSI.toString());
        }
        return "";
    }
   
     
    
    public void setInsCost(int InsCost) {
        this.InsCost = InsCost;
    }

    public String getRefKey() {
        return RefKey;
    }

    public void setRefKey(String RefKey) {
        this.RefKey = RefKey;
    }

    public String getChassisNumber() {
        return ChassisNumber;
    }

    public void setChassisNumber(String ChassisNumber) {
        this.ChassisNumber = ChassisNumber;
    }

    public String getEnginId() {
        return EnginId;
    }

    public void setEnginId(String EnginId) {
        this.EnginId = EnginId;
    }

    public String getPlateNumber() {
        return PlateNumber;
    }

    public void setPlateNumber(String PlateNumber) {
        this.PlateNumber = PlateNumber;
    }

    public String getFuelType() {
        return FuelType;
    }

    public void setFuelType(String FuelType) {
        this.FuelType = FuelType;
    }

    public String getLicenseNumber() {
        return LicenseNumber;
    }

    public void setLicenseNumber(String LicenseNumber) {
        this.LicenseNumber = LicenseNumber;
    }

    public String getPurchase() {
        return Purchase;
    }

    public void setPurchase(String Purchase) {
        this.Purchase = Purchase;
    }

    public String getCarBrand() {
        return CarBrand;
    }

    public void setCarBrand(String CarBrand) {
        this.CarBrand = CarBrand;
    }

    public String getModelCar() {
        return ModelCar;
    }

    public void setModelCar(String ModelCar) {
        this.ModelCar = ModelCar;
    }

    public int getManufYear() {
        return ManufYear;
    }

    public void setManufYear(int ManufYear) {
        this.ManufYear = ManufYear;
    }

    public int getNumberOfDoors() {
        return NumberOfDoors;
    }

    public void setNumberOfDoors(int NumberOfDoors) {
        this.NumberOfDoors = NumberOfDoors;
    }

    public String getLicCategory() {
        return LicCategory;
    }

    public void setLicCategory(String LicCategory) {
        this.LicCategory = LicCategory;
    }

    public String getPrevAccedents() {
        return PrevAccedents;
    }

    public void setPrevAccedents(String PrevAccedents) {
        this.PrevAccedents = PrevAccedents;
    }

    public int getWeight() {
        return Weight;
    }

    public void setWeight(int Weight) {
        this.Weight = Weight;
    }

    public int getPower() {
        return Power;
    }

    public void setPower(int Power) {
        this.Power = Power;
    }

    public String getFTurbo() {
        return FTurbo;
    }

    public void setFTurbo(String FTurbo) {
        this.FTurbo = FTurbo;
    }

    public String getFAlarm() {
        return FAlarm;
    }

    public void setFAlarm(String FAlarm) {
        this.FAlarm = FAlarm;
    }

   
    

    public String getColor() {
        return Color;
    }

    public void setColor(String Color) {
        this.Color = Color;
    }

  
          
    
    
    
    
    
    
}

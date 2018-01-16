package iskconbangalore.org.akshayapatraoperations;

/**
 * Created by i308830 on 1/7/18.
 */

public class SchoolData {
    public String School,Quantity,TempQuantity,Exp_Time;

    SchoolData()
    {
        this.School="";
       // this.GPS_Coord="";
        this.Quantity="";
        this.TempQuantity="";
        this.Exp_Time="";
    }
    SchoolData(String SchoolName,String GPS_Cood, String Quantity, String TempQuantity,String Exp_Time)
    {
      this.School = SchoolName;
     // this.GPS_Coord = GPS_Cood;
      this.Quantity = Quantity;
      this.TempQuantity = TempQuantity;
      this.Exp_Time = Exp_Time;
    }
}

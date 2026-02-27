package interfaces;

public interface PowerSystem {
    double estimatePowerOutput(double durationHours); 
    double getThermalManagementRating();              
    double getPowerDraw();                            
    String getName();
}

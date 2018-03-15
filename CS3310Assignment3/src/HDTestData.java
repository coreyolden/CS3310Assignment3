
public class HDTestData {
	
	private String serialNumber ="empty";
	private String modelNumber = "empty";
	private long capacity = 0;
	private int poweredOn = 0;
	
	
	public void setSerial(String serial) {
		serialNumber = serial;
	}
	public void setModel(String model) {
		modelNumber = model;
	}
	public void setCapacity(long cap) {
		capacity = cap;
	}
	public void setPoweredOn(int on) {
		poweredOn = on;
	}
	
	public String getSerial(){
		return serialNumber;
	}
	public String getModel() {
		return modelNumber;
	}
	public long getCapacity() {
		return capacity;
	}
	public int getPoweredOnTime() {
		return poweredOn;
	}
}

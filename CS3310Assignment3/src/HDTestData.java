
public class HDTestData {
	
	private String serialNumber ="empty";
	private String modelNumber = "empty";
	private long capacity = 0;
	private int poweredOn = 0;
	
	/**sets the serial number 
	 *
	 * @param serial
	 */
	public void setSerial(String serial) {
		serialNumber = serial;
	}
	
	/**sets the model 
	 * 
	 * @param model
	 */
	public void setModel(String model) {
		modelNumber = model;
	}
	
	/**sets the capacity
	 * 
	 * @param cap
	 */
	public void setCapacity(long cap) {
		capacity = cap;
	}
	
	/**sets powered on time 
	 * 
	 * @param on
	 */
	public void setPoweredOn(int on) {
		poweredOn = on;
	}
	
	/**returns the serial number 
	 * 
	 * @return
	 */
	public String getSerial(){
		return serialNumber;
	}
	
	/**returns the model 
	 * 
	 * @return
	 */
	public String getModel() {
		return modelNumber;
	}
	
	/**returns the capacity 
	 * 
	 * @return
	 */
	public long getCapacity() {
		return capacity;
	}
	
	/**returns the powered on time 
	 * 
	 * @return
	 */
	public int getPoweredOnTime() {
		return poweredOn;
	}
}
